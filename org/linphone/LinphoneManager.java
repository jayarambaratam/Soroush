package org.linphone;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothProfile;
import android.bluetooth.BluetoothProfile.ServiceListener;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.Vibrator;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import mobi.mmdt.componentsutils.p079a.p080a.C1104b;
import mobi.mmdt.ott.p086a.C1134b;
import mobi.mmdt.ott.p086a.C1135c;
import mobi.mmdt.ott.p086a.C1136d;
import mobi.mmdt.ott.p086a.p087a.p088a.C1128a;
import org.jivesoftware.smack.tcp.XMPPTCPConnection.PacketWriter;
import org.linphone.LinphoneSimpleListener.ConnectivityChangedListener;
import org.linphone.LinphoneSimpleListener.LinphoneOnAudioChangedListener;
import org.linphone.LinphoneSimpleListener.LinphoneOnAudioChangedListener.AudioState;
import org.linphone.LinphoneSimpleListener.LinphoneOnCallEncryptionChangedListener;
import org.linphone.LinphoneSimpleListener.LinphoneOnCallStateChangedListener;
import org.linphone.LinphoneSimpleListener.LinphoneOnComposingReceivedListener;
import org.linphone.LinphoneSimpleListener.LinphoneOnDTMFReceivedListener;
import org.linphone.LinphoneSimpleListener.LinphoneOnRegistrationStateChangedListener;
import org.linphone.LinphoneSimpleListener.LinphoneServiceListener;
import org.linphone.compatibility.Compatibility;
import org.linphone.core.CallDirection;
import org.linphone.core.LinphoneAddress;
import org.linphone.core.LinphoneCall;
import org.linphone.core.LinphoneCall.State;
import org.linphone.core.LinphoneCallParams;
import org.linphone.core.LinphoneCallStats;
import org.linphone.core.LinphoneChatMessage;
import org.linphone.core.LinphoneChatRoom;
import org.linphone.core.LinphoneContent;
import org.linphone.core.LinphoneCore;
import org.linphone.core.LinphoneCore.EcCalibratorStatus;
import org.linphone.core.LinphoneCore.GlobalState;
import org.linphone.core.LinphoneCore.RegistrationState;
import org.linphone.core.LinphoneCore.RemoteProvisioningState;
import org.linphone.core.LinphoneCoreException;
import org.linphone.core.LinphoneCoreFactory;
import org.linphone.core.LinphoneCoreListener;
import org.linphone.core.LinphoneEvent;
import org.linphone.core.LinphoneFriend;
import org.linphone.core.LinphoneInfoMessage;
import org.linphone.core.LinphoneProxyConfig;
import org.linphone.core.PayloadType;
import org.linphone.core.PresenceActivityType;
import org.linphone.core.PublishState;
import org.linphone.core.SubscriptionState;
import org.linphone.mediastream.Log;
import org.linphone.mediastream.Version;
import org.linphone.mediastream.video.capture.hwconf.AndroidCameraConfiguration;
import org.linphone.mediastream.video.capture.hwconf.AndroidCameraConfiguration.AndroidCamera;
import org.linphone.mediastream.video.capture.hwconf.Hacks;

public class LinphoneManager implements LinphoneCoreListener {
    private static final int LINPHONE_VOLUME_STREAM = 0;
    private static final int dbStep = 4;
    private static LinphoneManager instance;
    private static boolean sExited;
    private static boolean sLastProximitySensorValueNearby;
    private static Set<Activity> sProximityDependentActivities;
    private static SensorEventListener sProximitySensorListener;
    private static List<LinphoneSimpleListener> simpleListeners;
    private String basePath;
    private BroadcastReceiver bluetoothActionReceiver;
    private BroadcastReceiver bluetoothReiceiver;
    private LinphoneOnComposingReceivedListener composingReceivedListener;
    private ConnectivityChangedListener connectivityListener;
    private boolean disableRinging;
    private LinphoneOnDTMFReceivedListener dtmfReceivedListener;
    public boolean isBluetoothScoConnected;
    private boolean isRinging;
    public boolean isUsingBluetoothAudioRoute;
    private String lastLcStatusMessage;
    private boolean mAudioFocused;
    private AudioManager mAudioManager;
    private BluetoothAdapter mBluetoothAdapter;
    private BluetoothHeadset mBluetoothHeadset;
    private boolean mBluetoothStarted;
    private final String mChatDatabaseFile;
    private ConnectivityManager mConnectivityManager;
    private WakeLock mIncallWakeLock;
    private BroadcastReceiver mKeepAliveReceiver;
    private final String mLPConfigXsd;
    private int mLastNetworkType;
    private LinphoneCore mLc;
    public final String mLinphoneConfigFile;
    private final String mLinphoneFactoryConfigFile;
    private final String mLinphoneRootCaFile;
    private ListenerDispatcher mListenerDispatcher;
    private final String mPauseSoundFile;
    private PowerManager mPowerManager;
    private LinphonePreferences mPrefs;
    private Resources mR;
    private final String mRingSoundFile;
    private final String mRingbackSoundFile;
    private MediaPlayer mRingerPlayer;
    private Context mServiceContext;
    private Timer mTimer;
    private Vibrator mVibrator;
    private LinphoneCall ringingCall;
    private int savedMaxCallWhileGsmIncall;

    public interface EcCalibrationListener {
        void onEcCalibrationStatus(EcCalibratorStatus ecCalibratorStatus, int i);
    }

    /* renamed from: org.linphone.LinphoneManager.1 */
    class C27941 implements ServiceListener {
        C27941() {
        }

        @TargetApi(11)
        public void onServiceConnected(int i, BluetoothProfile bluetoothProfile) {
            if (i == 1) {
                Log.m11089d("Bluetooth headset connected");
                LinphoneManager.this.mServiceContext.registerReceiver(LinphoneManager.this.bluetoothActionReceiver, new IntentFilter("android.bluetooth.headset.action.VENDOR_SPECIFIC_HEADSET_EVENT"));
                LinphoneManager.this.mBluetoothHeadset = (BluetoothHeadset) bluetoothProfile;
                LinphoneManager.this.isBluetoothScoConnected = true;
            }
        }

        @TargetApi(11)
        public void onServiceDisconnected(int i) {
            if (i == 1) {
                LinphoneManager.this.mServiceContext.unregisterReceiver(LinphoneManager.this.bluetoothActionReceiver);
                LinphoneManager.this.mBluetoothHeadset = null;
                LinphoneManager.this.isBluetoothScoConnected = false;
                Log.m11089d("Bluetooth headset disconnected");
                LinphoneManager.this.routeAudioToReceiver();
            }
        }
    }

    /* renamed from: org.linphone.LinphoneManager.2 */
    class C27952 extends TimerTask {
        C27952() {
        }

        public void run() {
            LinphoneManager.this.mLc.iterate();
        }
    }

    /* renamed from: org.linphone.LinphoneManager.3 */
    final class C27963 implements SensorEventListener {
        C27963() {
        }

        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
            if (sensorEvent.timestamp != 0) {
                LinphoneManager.sLastProximitySensorValueNearby = LinphoneManager.isProximitySensorNearby(sensorEvent).booleanValue();
                LinphoneManager.proximityNearbyChanged();
            }
        }
    }

    public interface AddressType {
        String getDisplayedName();

        CharSequence getText();

        void setDisplayedName(String str);

        void setText(CharSequence charSequence);
    }

    public class LinphoneConfigException extends LinphoneException {
        public LinphoneConfigException(String str) {
            super(str);
        }

        public LinphoneConfigException(String str, Throwable th) {
            super(str, th);
        }

        public LinphoneConfigException(Throwable th) {
            super(th);
        }
    }

    class ListenerDispatcher implements LinphoneServiceListener {
        private LinphoneServiceListener serviceListener;

        public ListenerDispatcher(LinphoneServiceListener linphoneServiceListener) {
            this.serviceListener = linphoneServiceListener;
        }

        public void onCallEncryptionChanged(LinphoneCall linphoneCall, boolean z, String str) {
            if (this.serviceListener != null) {
                this.serviceListener.onCallEncryptionChanged(linphoneCall, z, str);
            }
            for (LinphoneOnCallEncryptionChangedListener onCallEncryptionChanged : LinphoneManager.this.getSimpleListeners(LinphoneOnCallEncryptionChangedListener.class)) {
                onCallEncryptionChanged.onCallEncryptionChanged(linphoneCall, z, str);
            }
        }

        public void onCallStateChanged(LinphoneCall linphoneCall, State state, String str) {
            if (state == State.OutgoingInit || state == State.IncomingReceived) {
                LinphoneManager.this.enableCamera(linphoneCall, LinphoneManager.this.mLc.getConferenceSize() == 0);
            }
            Context context = LinphoneManager.this.getContext();
            if (context != null) {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (state == State.CallEnd && LinphoneManager.this.mLc.getCallsNb() == 0 && telephonyManager.getCallState() == 0) {
                    LinphoneManager.this.routeAudioToReceiver();
                }
            }
            if (this.serviceListener != null) {
                this.serviceListener.onCallStateChanged(linphoneCall, state, str);
            }
            for (LinphoneOnCallStateChangedListener onCallStateChanged : LinphoneManager.this.getSimpleListeners(LinphoneOnCallStateChangedListener.class)) {
                onCallStateChanged.onCallStateChanged(linphoneCall, state, str);
            }
        }

        public void onDisplayStatus(String str) {
            if (this.serviceListener != null) {
                this.serviceListener.onDisplayStatus(str);
            }
        }

        public void onGlobalStateChanged(GlobalState globalState, String str) {
            if (this.serviceListener != null) {
                this.serviceListener.onGlobalStateChanged(globalState, str);
            }
        }

        public void onRegistrationStateChanged(RegistrationState registrationState, String str) {
            if (this.serviceListener != null) {
                this.serviceListener.onRegistrationStateChanged(registrationState, str);
            }
            for (LinphoneOnRegistrationStateChangedListener onRegistrationStateChanged : LinphoneManager.this.getSimpleListeners(LinphoneOnRegistrationStateChangedListener.class)) {
                onRegistrationStateChanged.onRegistrationStateChanged(registrationState);
            }
        }

        public void tryingNewOutgoingCallButAlreadyInCall() {
            if (this.serviceListener != null) {
                this.serviceListener.tryingNewOutgoingCallButAlreadyInCall();
            }
        }

        public void tryingNewOutgoingCallButCannotGetCallParameters() {
            if (this.serviceListener != null) {
                this.serviceListener.tryingNewOutgoingCallButCannotGetCallParameters();
            }
        }

        public void tryingNewOutgoingCallButWrongDestinationAddress() {
            if (this.serviceListener != null) {
                this.serviceListener.tryingNewOutgoingCallButWrongDestinationAddress();
            }
        }
    }

    public interface NewOutgoingCallUiListener {
        void onAlreadyInCall();

        void onCannotGetCallParameters();

        void onWrongDestinationAddress();
    }

    static {
        simpleListeners = new ArrayList();
        sProximityDependentActivities = new HashSet();
        sProximitySensorListener = new C27963();
    }

    protected LinphoneManager(Context context, LinphoneServiceListener linphoneServiceListener) {
        this.mLastNetworkType = -1;
        this.bluetoothReiceiver = new BluetoothManager();
        this.bluetoothActionReceiver = new BluetoothActionReceiver();
        this.mKeepAliveReceiver = new KeepAliveReceiver();
        this.disableRinging = false;
        sExited = false;
        this.mServiceContext = context;
        this.mListenerDispatcher = new ListenerDispatcher(linphoneServiceListener);
        this.basePath = context.getFilesDir().getAbsolutePath();
        this.mLPConfigXsd = this.basePath + "/lpconfig.xsd";
        this.mLinphoneFactoryConfigFile = this.basePath + "/linphonerc";
        this.mLinphoneConfigFile = this.basePath + "/.linphonerc";
        this.mLinphoneRootCaFile = this.basePath + "/rootca.pem";
        this.mRingSoundFile = this.basePath + "/oldphone_mono.wav";
        this.mRingbackSoundFile = this.basePath + "/ringback.wav";
        this.mPauseSoundFile = this.basePath + "/toy_mono.wav";
        this.mChatDatabaseFile = this.basePath + "/linphone-history.db";
        this.mPrefs = LinphonePreferences.instance();
        this.mAudioManager = (AudioManager) context.getSystemService("audio");
        this.mVibrator = (Vibrator) context.getSystemService("vibrator");
        this.mPowerManager = (PowerManager) context.getSystemService("power");
        this.mConnectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        this.mR = context.getResources();
    }

    public static void addListener(LinphoneSimpleListener linphoneSimpleListener) {
        if (!simpleListeners.contains(linphoneSimpleListener)) {
            simpleListeners.add(linphoneSimpleListener);
        }
    }

    private synchronized void allowSIPCalls() {
        if (this.savedMaxCallWhileGsmIncall == 0) {
            Log.m11097w("SIP calls are already allowed as no GSM call knowned to be running");
        } else {
            this.mLc.setMaxCalls(this.savedMaxCallWhileGsmIncall);
            this.savedMaxCallWhileGsmIncall = LINPHONE_VOLUME_STREAM;
        }
    }

    private void copyAssetsFromPackage() {
        copyIfNotExist(C1135c.oldphone_mono, this.mRingSoundFile);
        copyIfNotExist(C1135c.ringback, this.mRingbackSoundFile);
        copyIfNotExist(C1135c.toy_mono, this.mPauseSoundFile);
        copyIfNotExist(C1135c.lpconfig, this.mLPConfigXsd);
        copyIfNotExist(C1135c.linphonerc_default, this.mLinphoneConfigFile);
        copyFromPackage(C1135c.linphonerc_factory, new File(this.mLinphoneFactoryConfigFile).getName());
        copyIfNotExist(C1135c.rootca, this.mLinphoneRootCaFile);
    }

    private void copyFromPackage(int i, String str) {
        FileOutputStream openFileOutput = this.mServiceContext.openFileOutput(str, LINPHONE_VOLUME_STREAM);
        InputStream openRawResource = this.mR.openRawResource(i);
        byte[] bArr = new byte[8048];
        while (true) {
            int read = openRawResource.read(bArr);
            if (read != -1) {
                openFileOutput.write(bArr, LINPHONE_VOLUME_STREAM, read);
            } else {
                openFileOutput.flush();
                openFileOutput.close();
                openRawResource.close();
                return;
            }
        }
    }

    private void copyIfNotExist(int i, String str) {
        File file = new File(str);
        if (!file.exists()) {
            copyFromPackage(i, file.getName());
        }
    }

    public static synchronized LinphoneManager createAndStart(Context context, LinphoneServiceListener linphoneServiceListener) {
        LinphoneManager linphoneManager;
        synchronized (LinphoneManager.class) {
            if (instance != null) {
                throw new RuntimeException("Linphone Manager is already initialized");
            }
            instance = new LinphoneManager(context, linphoneServiceListener);
            instance.startLibLinphone(context);
            setGsmIdle(((TelephonyManager) context.getSystemService("phone")).getCallState() == 0);
            getInstance().changeStatusToOnline();
            linphoneManager = instance;
        }
        return linphoneManager;
    }

    public static synchronized void destroy() {
        synchronized (LinphoneManager.class) {
            if (instance != null) {
                getInstance().changeStatusToOffline();
                sExited = true;
                instance.doDestroy();
            }
        }
    }

    @TargetApi(11)
    private void doDestroy() {
        if (SipLibService.isReady()) {
            try {
                this.mServiceContext.unregisterReceiver(this.bluetoothReiceiver);
            } catch (Exception e) {
            }
        }
        try {
            this.mServiceContext.unregisterReceiver(this.bluetoothActionReceiver);
        } catch (Exception e2) {
        }
        try {
            if (Version.sdkAboveOrEqual(11)) {
                this.mBluetoothAdapter.closeProfileProxy(1, this.mBluetoothHeadset);
            }
        } catch (Exception e3) {
        }
        try {
            this.mTimer.cancel();
            this.mLc.destroy();
        } catch (Throwable e4) {
            C1104b.m6368b((Object) this, e4);
        } finally {
            this.mServiceContext.unregisterReceiver(instance.mKeepAliveReceiver);
            this.mLc = null;
            instance = null;
        }
    }

    public static String extractADisplayName(Resources resources, LinphoneAddress linphoneAddress) {
        if (linphoneAddress == null) {
            return resources.getString(C1136d.unknown_incoming_call_name);
        }
        String displayName = linphoneAddress.getDisplayName();
        if (displayName != null) {
            return displayName;
        }
        if (linphoneAddress.getUserName() != null) {
            return linphoneAddress.getUserName();
        }
        displayName = linphoneAddress.toString();
        return (displayName == null || displayName.length() <= 1) ? resources.getString(C1136d.unknown_incoming_call_name) : displayName;
    }

    public static String extractIncomingRemoteName(Resources resources, LinphoneAddress linphoneAddress) {
        return extractADisplayName(resources, linphoneAddress);
    }

    public static synchronized LinphoneManager getInstance() {
        LinphoneManager linphoneManager;
        synchronized (LinphoneManager.class) {
            if (instance != null) {
                linphoneManager = instance;
            } else if (sExited) {
                throw new RuntimeException("Linphone Manager was already destroyed. Better use getLcIfManagerNotDestroyed and check returned value");
            } else {
                throw new RuntimeException("Linphone Manager should be created before accessed");
            }
        }
        return linphoneManager;
    }

    public static synchronized LinphoneCore getLc() {
        LinphoneCore linphoneCore;
        synchronized (LinphoneManager.class) {
            linphoneCore = getInstance().mLc;
        }
        return linphoneCore;
    }

    public static synchronized LinphoneCore getLcIfManagerNotDestroyedOrNull() {
        LinphoneCore linphoneCore;
        synchronized (LinphoneManager.class) {
            if (sExited) {
                Log.m11097w("Trying to get linphone core while LinphoneManager already destroyed");
                linphoneCore = null;
            } else {
                linphoneCore = getLc();
            }
        }
        return linphoneCore;
    }

    private <T> List<T> getSimpleListeners(Class<T> cls) {
        List<T> arrayList = new ArrayList();
        for (LinphoneSimpleListener linphoneSimpleListener : simpleListeners) {
            if (cls.isInstance(linphoneSimpleListener)) {
                arrayList.add(linphoneSimpleListener);
            }
        }
        return arrayList;
    }

    private String getString(int i) {
        return this.mR.getString(i);
    }

    public static boolean isInstanciated() {
        return instance != null;
    }

    private boolean isPresenceModelActivitySet() {
        return (isInstanciated() && getLc().getPresenceModel() != null) || getLc().getPresenceModel().getActivity() != null;
    }

    public static Boolean isProximitySensorNearby(SensorEvent sensorEvent) {
        boolean z = true;
        float f = sensorEvent.values[LINPHONE_VOLUME_STREAM];
        float maximumRange = sensorEvent.sensor.getMaximumRange();
        Log.m11089d("Proximity sensor report [", Float.valueOf(f), "] , for max range [", Float.valueOf(maximumRange), "]");
        if (maximumRange > 4.001f) {
            maximumRange = 4.001f;
        }
        if (f >= maximumRange) {
            z = false;
        }
        return Boolean.valueOf(z);
    }

    private boolean isTunnelNeeded(NetworkInfo networkInfo) {
        if (networkInfo == null) {
            Log.m11095i("No connectivity: tunnel should be disabled");
            return false;
        }
        String tunnelMode = this.mPrefs.getTunnelMode();
        if (getString(C1136d.tunnel_mode_entry_value_always).equals(tunnelMode)) {
            return true;
        }
        if (networkInfo.getType() == 1 || !getString(C1136d.tunnel_mode_entry_value_3G_only).equals(tunnelMode)) {
            return false;
        }
        Log.m11095i("need tunnel: 'no wifi' connection");
        return true;
    }

    private void manageTunnelServer(NetworkInfo networkInfo) {
        if (this.mLc != null && this.mLc.isTunnelAvailable()) {
            Log.m11095i("Managing tunnel");
            if (isTunnelNeeded(networkInfo)) {
                Log.m11095i("Tunnel need to be activated");
                this.mLc.tunnelEnable(true);
                return;
            }
            Log.m11095i("Tunnel should not be used");
            String tunnelMode = this.mPrefs.getTunnelMode();
            this.mLc.tunnelEnable(false);
            if (getString(C1136d.tunnel_mode_entry_value_auto).equals(tunnelMode)) {
                this.mLc.tunnelAutoDetect();
            }
        }
    }

    private synchronized void preventSIPCalls() {
        if (this.savedMaxCallWhileGsmIncall != 0) {
            Log.m11097w("SIP calls are already blocked due to GSM call running");
        } else {
            this.savedMaxCallWhileGsmIncall = this.mLc.getMaxCalls();
            this.mLc.setMaxCalls(LINPHONE_VOLUME_STREAM);
        }
    }

    private static void proximityNearbyChanged() {
        boolean z = sLastProximitySensorValueNearby;
        for (Activity simulateProximitySensorNearby : sProximityDependentActivities) {
            simulateProximitySensorNearby(simulateProximitySensorNearby, z);
        }
    }

    public static boolean reinviteWithVideo() {
        return CallManager.getInstance().reinviteWithVideo();
    }

    public static void removeListener(LinphoneSimpleListener linphoneSimpleListener) {
        simpleListeners.remove(linphoneSimpleListener);
    }

    private void requestAudioFocus() {
        if (!this.mAudioFocused) {
            int requestAudioFocus = this.mAudioManager.requestAudioFocus(null, LINPHONE_VOLUME_STREAM, 2);
            Object[] objArr = new Object[1];
            objArr[LINPHONE_VOLUME_STREAM] = "Audio focus requested: " + (requestAudioFocus == 1 ? "Granted" : "Denied");
            Log.m11089d(objArr);
            if (requestAudioFocus == 1) {
                this.mAudioFocused = true;
            }
        }
    }

    private void resetCameraFromPreferences() {
        int i = LINPHONE_VOLUME_STREAM;
        boolean useFrontCam = this.mPrefs.useFrontCam();
        AndroidCamera[] retrieveCameras = AndroidCameraConfiguration.retrieveCameras();
        int length = retrieveCameras.length;
        for (int i2 = LINPHONE_VOLUME_STREAM; i2 < length; i2++) {
            AndroidCamera androidCamera = retrieveCameras[i2];
            if (androidCamera.frontFacing == useFrontCam) {
                i = androidCamera.id;
            }
        }
        getLc().setVideoDevice(i);
    }

    private void routeAudioToSpeakerHelper(boolean z) {
        this.isUsingBluetoothAudioRoute = false;
        if (this.mAudioManager != null && this.mBluetoothStarted) {
            this.mAudioManager.stopBluetoothSco();
            this.mAudioManager.setBluetoothScoOn(false);
            this.mBluetoothStarted = false;
        }
        if (z) {
            this.mLc.enableSpeaker(true);
        } else {
            this.mLc.enableSpeaker(false);
        }
        for (LinphoneOnAudioChangedListener onAudioStateChanged : getSimpleListeners(LinphoneOnAudioChangedListener.class)) {
            onAudioStateChanged.onAudioStateChanged(z ? AudioState.SPEAKER : AudioState.EARPIECE);
        }
    }

    public static void setGsmIdle(boolean z) {
        LinphoneManager linphoneManager = instance;
        if (linphoneManager != null) {
            if (z) {
                linphoneManager.allowSIPCalls();
            } else {
                linphoneManager.preventSIPCalls();
            }
        }
    }

    private static void simulateProximitySensorNearby(Activity activity, boolean z) {
        Window window = activity.getWindow();
        LayoutParams attributes = window.getAttributes();
        View childAt = ((ViewGroup) window.getDecorView().findViewById(16908290)).getChildAt(LINPHONE_VOLUME_STREAM);
        if (z) {
            attributes.screenBrightness = 0.1f;
            childAt.setVisibility(dbStep);
            Compatibility.hideNavigationBar(activity);
        } else {
            attributes.screenBrightness = -1.0f;
            childAt.setVisibility(LINPHONE_VOLUME_STREAM);
            Compatibility.showNavigationBar(activity);
        }
        window.setAttributes(attributes);
    }

    private synchronized void startLibLinphone(Context context) {
        boolean z = true;
        synchronized (this) {
            try {
                copyAssetsFromPackage();
                if (this.mR.getBoolean(C1134b.disable_every_log)) {
                    z = false;
                }
                LinphoneCoreFactory.instance().setDebugMode(z, "mobi.mmdt.ott.voip");
                initLiblinphone(context);
                PreferencesMigrator preferencesMigrator = new PreferencesMigrator(this.mServiceContext);
                if (preferencesMigrator.isMigrationNeeded()) {
                    preferencesMigrator.doMigration();
                }
                int migrateToMultiTransport = getLc().migrateToMultiTransport();
                Log.m11089d("Migration to multi transport result = " + migrateToMultiTransport);
                IntentFilter intentFilter = new IntentFilter("android.intent.action.SCREEN_ON");
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
                this.mServiceContext.registerReceiver(this.mKeepAliveReceiver, intentFilter);
                updateNetworkReachability();
                startBluetooth();
            } catch (Throwable e) {
                Log.m11090e(e, "Cannot start linphone");
            }
        }
    }

    public static synchronized void startProximitySensorForActivity(Activity activity) {
        synchronized (LinphoneManager.class) {
            if (sProximityDependentActivities.contains(activity)) {
                Log.m11095i("proximity sensor already active for " + activity.getLocalClassName());
            } else {
                if (sProximityDependentActivities.isEmpty()) {
                    SensorManager sensorManager = (SensorManager) activity.getSystemService("sensor");
                    Sensor defaultSensor = sensorManager.getDefaultSensor(8);
                    if (defaultSensor != null) {
                        sensorManager.registerListener(sProximitySensorListener, defaultSensor, 2);
                        Log.m11095i("Proximity sensor detected, registering");
                    }
                } else if (sLastProximitySensorValueNearby) {
                    simulateProximitySensorNearby(activity, true);
                }
                sProximityDependentActivities.add(activity);
            }
        }
    }

    private synchronized void startRinging() {
        if (!this.disableRinging) {
            if (Hacks.needGalaxySAudioHack()) {
                this.mAudioManager.setMode(1);
            }
            try {
                if ((this.mAudioManager.getRingerMode() == 1 || this.mAudioManager.getRingerMode() == 2) && this.mVibrator != null) {
                    this.mVibrator.vibrate(new long[]{0, 1000, 1000}, 1);
                }
                if (this.mRingerPlayer == null) {
                    requestAudioFocus();
                    this.mRingerPlayer = new MediaPlayer();
                    this.mRingerPlayer.setAudioStreamType(2);
                    String ringtone = LinphonePreferences.instance().getRingtone(System.DEFAULT_RINGTONE_URI.toString());
                    try {
                        if (ringtone.startsWith("content://")) {
                            this.mRingerPlayer.setDataSource(this.mServiceContext, Uri.parse(ringtone));
                        } else {
                            FileInputStream fileInputStream = new FileInputStream(ringtone);
                            this.mRingerPlayer.setDataSource(fileInputStream.getFD());
                            fileInputStream.close();
                        }
                    } catch (Throwable e) {
                        Log.m11090e(e, "Cannot set ringtone");
                    }
                    this.mRingerPlayer.prepare();
                    this.mRingerPlayer.setLooping(true);
                    this.mRingerPlayer.start();
                    this.isRinging = true;
                } else {
                    Log.m11097w("already ringing");
                    this.isRinging = true;
                }
            } catch (Throwable e2) {
                Log.m11090e(e2, "cannot handle incoming call");
            }
        }
    }

    public static synchronized void stopProximitySensorForActivity(Activity activity) {
        synchronized (LinphoneManager.class) {
            sProximityDependentActivities.remove(activity);
            simulateProximitySensorNearby(activity, false);
            if (sProximityDependentActivities.isEmpty()) {
                ((SensorManager) activity.getSystemService("sensor")).unregisterListener(sProximitySensorListener);
                sLastProximitySensorValueNearby = false;
            }
        }
    }

    private synchronized void stopRinging() {
        if (this.mRingerPlayer != null) {
            this.mRingerPlayer.stop();
            this.mRingerPlayer.release();
            this.mRingerPlayer = null;
        }
        if (this.mVibrator != null) {
            this.mVibrator.cancel();
        }
        if (Hacks.needGalaxySAudioHack()) {
            this.mAudioManager.setMode(LINPHONE_VOLUME_STREAM);
        }
        this.isRinging = false;
        routeAudioToReceiver();
    }

    public boolean acceptCall(LinphoneCall linphoneCall) {
        try {
            this.mLc.acceptCall(linphoneCall);
            return true;
        } catch (Throwable e) {
            Log.m11094i(e, "Accept call failed");
            return false;
        }
    }

    public boolean acceptCallIfIncomingPending() {
        if (!this.mLc.isInComingInvitePending()) {
            return false;
        }
        this.mLc.acceptCall(this.mLc.getCurrentCall());
        return true;
    }

    public boolean acceptCallWithParams(LinphoneCall linphoneCall, LinphoneCallParams linphoneCallParams) {
        try {
            this.mLc.acceptCallWithParams(linphoneCall, linphoneCallParams);
            return true;
        } catch (Throwable e) {
            Log.m11094i(e, "Accept call failed");
            return false;
        }
    }

    public void addConnectivityChangedListener(ConnectivityChangedListener connectivityChangedListener) {
        this.connectivityListener = connectivityChangedListener;
    }

    public boolean addVideo() {
        enableCamera(this.mLc.getCurrentCall(), true);
        return reinviteWithVideo();
    }

    public void adjustVolume(int i) {
        int i2 = LINPHONE_VOLUME_STREAM;
        if (VERSION.SDK_INT < 15) {
            int streamVolume = this.mAudioManager.getStreamVolume(LINPHONE_VOLUME_STREAM);
            int streamMaxVolume = this.mAudioManager.getStreamMaxVolume(LINPHONE_VOLUME_STREAM);
            streamVolume += i;
            if (streamVolume > streamMaxVolume) {
                streamVolume = streamMaxVolume;
            }
            if (streamVolume >= 0) {
                i2 = streamVolume;
            }
            this.mLc.setPlaybackGain((float) ((i2 - streamMaxVolume) * dbStep));
            return;
        }
        this.mAudioManager.adjustStreamVolume(LINPHONE_VOLUME_STREAM, i < 0 ? -1 : 1, 1);
    }

    public void authInfoRequested(LinphoneCore linphoneCore, String str, String str2) {
    }

    public void byeReceived(LinphoneCore linphoneCore, String str) {
    }

    public void callEncryptionChanged(LinphoneCore linphoneCore, LinphoneCall linphoneCall, boolean z, String str) {
        this.mListenerDispatcher.onCallEncryptionChanged(linphoneCall, z, str);
    }

    @SuppressLint({"Wakelock"})
    public void callState(LinphoneCore linphoneCore, LinphoneCall linphoneCall, State state, String str) {
        Log.m11095i("new state [", state, "]");
        if (state != State.IncomingReceived || linphoneCall.equals(linphoneCore.getCurrentCall()) || linphoneCall.getReplacedCall() == null) {
            if (state == State.IncomingReceived && this.mR.getBoolean(C1134b.auto_answer_calls)) {
                try {
                    this.mLc.acceptCall(linphoneCall);
                } catch (Throwable e) {
                    C1104b.m6368b((Object) this, e);
                }
            } else if (state == State.IncomingReceived || (state == State.CallIncomingEarlyMedia && this.mR.getBoolean(C1134b.allow_ringing_while_early_media))) {
                if (this.mLc.getCallsNb() == 1) {
                    this.ringingCall = linphoneCall;
                    startRinging();
                }
            } else if (linphoneCall == this.ringingCall && this.isRinging) {
                stopRinging();
            }
            if (state == State.Connected) {
                if (this.mLc.getCallsNb() == 1) {
                    requestAudioFocus();
                    Compatibility.setAudioManagerInCallMode(this.mAudioManager);
                }
                if (Hacks.needSoftvolume()) {
                    adjustVolume(LINPHONE_VOLUME_STREAM);
                }
            }
            if ((state == State.CallEnd || state == State.Error) && this.mLc.getCallsNb() == 0) {
                if (this.mAudioFocused) {
                    Object[] objArr = new Object[1];
                    objArr[LINPHONE_VOLUME_STREAM] = "Audio focus released a bit later: " + (this.mAudioManager.abandonAudioFocus(null) == 1 ? "Granted" : "Denied");
                    Log.m11089d(objArr);
                    this.mAudioFocused = false;
                }
                Context context = getContext();
                if (context != null && ((TelephonyManager) context.getSystemService("phone")).getCallState() == 0) {
                    this.mAudioManager.setMode(LINPHONE_VOLUME_STREAM);
                    Log.m11089d("---AudioManager: back to MODE_NORMAL");
                }
            }
            if (state == State.CallEnd && this.mLc.getCallsNb() == 0) {
                if (this.mIncallWakeLock == null || !this.mIncallWakeLock.isHeld()) {
                    Log.m11095i("Last call ended: no incall (CPU only) wake lock were held");
                } else {
                    this.mIncallWakeLock.release();
                    Log.m11095i("Last call ended: releasing incall (CPU only) wake lock");
                }
            }
            if (state == State.StreamsRunning) {
                if (this.mIncallWakeLock == null) {
                    this.mIncallWakeLock = this.mPowerManager.newWakeLock(1, "incall");
                }
                if (this.mIncallWakeLock.isHeld()) {
                    Log.m11095i("New call active while incall (CPU only) wake lock already active");
                } else {
                    Log.m11095i("New call active : acquiring incall (CPU only) wake lock");
                    this.mIncallWakeLock.acquire();
                }
            }
            this.mListenerDispatcher.onCallStateChanged(linphoneCall, state, str);
        }
    }

    public void callStatsUpdated(LinphoneCore linphoneCore, LinphoneCall linphoneCall, LinphoneCallStats linphoneCallStats) {
    }

    public void changeStatusToOffline() {
        if (isInstanciated() && isPresenceModelActivitySet() && getLc().getPresenceModel().getActivity().getType() != PresenceActivityType.Offline) {
            getLc().getPresenceModel().getActivity().setType(PresenceActivityType.Offline);
        } else if (isInstanciated() && !isPresenceModelActivitySet()) {
            getLc().setPresenceModel(LinphoneCoreFactory.instance().createPresenceModel(PresenceActivityType.Offline, null));
        }
    }

    public void changeStatusToOnThePhone() {
        if (isInstanciated() && isPresenceModelActivitySet() && getLc().getPresenceModel().getActivity().getType() != PresenceActivityType.OnThePhone) {
            getLc().getPresenceModel().getActivity().setType(PresenceActivityType.OnThePhone);
        } else if (isInstanciated() && !isPresenceModelActivitySet()) {
            getLc().setPresenceModel(LinphoneCoreFactory.instance().createPresenceModel(PresenceActivityType.OnThePhone, null));
        }
    }

    public void changeStatusToOnline() {
        if (isInstanciated() && isPresenceModelActivitySet() && getLc().getPresenceModel().getActivity().getType() != PresenceActivityType.Online) {
            getLc().getPresenceModel().getActivity().setType(PresenceActivityType.Online);
        } else if (isInstanciated() && !isPresenceModelActivitySet()) {
            getLc().setPresenceModel(LinphoneCoreFactory.instance().createPresenceModel(PresenceActivityType.Online, null));
        }
    }

    public void configuringStatus(LinphoneCore linphoneCore, RemoteProvisioningState remoteProvisioningState, String str) {
        Log.m11089d("Remote provisioning status = " + remoteProvisioningState.toString());
    }

    public void connectivityChanged(ConnectivityManager connectivityManager, boolean z) {
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        updateNetworkReachability();
        if (this.connectivityListener != null) {
            this.connectivityListener.onConnectivityChanged(this.mServiceContext, activeNetworkInfo, connectivityManager);
        }
    }

    public boolean detectAudioCodec(String str) {
        PayloadType[] audioCodecs = this.mLc.getAudioCodecs();
        int length = audioCodecs.length;
        for (int i = LINPHONE_VOLUME_STREAM; i < length; i++) {
            if (str.equals(audioCodecs[i].getMime())) {
                return true;
            }
        }
        return false;
    }

    public boolean detectVideoCodec(String str) {
        PayloadType[] videoCodecs = this.mLc.getVideoCodecs();
        int length = videoCodecs.length;
        for (int i = LINPHONE_VOLUME_STREAM; i < length; i++) {
            if (str.equals(videoCodecs[i].getMime())) {
                return true;
            }
        }
        return false;
    }

    public void disableRinging() {
        this.disableRinging = true;
    }

    public void displayMessage(LinphoneCore linphoneCore, String str) {
    }

    public void displayStatus(LinphoneCore linphoneCore, String str) {
        Log.m11095i(str);
        this.lastLcStatusMessage = str;
        this.mListenerDispatcher.onDisplayStatus(str);
    }

    public void displayWarning(LinphoneCore linphoneCore, String str) {
    }

    public void dtmfReceived(LinphoneCore linphoneCore, LinphoneCall linphoneCall, int i) {
        Log.m11089d("DTMF received: " + i);
        if (this.dtmfReceivedListener != null) {
            this.dtmfReceivedListener.onDTMFReceived(linphoneCall, i);
        }
    }

    public void ecCalibrationStatus(LinphoneCore linphoneCore, EcCalibratorStatus ecCalibratorStatus, int i, Object obj) {
        ((EcCalibrationListener) obj).onEcCalibrationStatus(ecCalibratorStatus, i);
    }

    public void enableCamera(LinphoneCall linphoneCall, boolean z) {
        if (linphoneCall != null) {
            linphoneCall.enableCamera(z);
        }
    }

    public Context getContext() {
        try {
            if (this.mServiceContext != null) {
                return this.mServiceContext;
            }
            if (SipLibService.isReady()) {
                return SipLibService.instance().getApplicationContext();
            }
            return null;
        } catch (Throwable e) {
            C1104b.m6368b((Object) this, e);
        }
    }

    public LinphoneCall getCurrentCall() {
        return this.mLc.isIncall() ? this.mLc.getCurrentCall() : null;
    }

    public String getLPConfigXsdPath() {
        return this.mLPConfigXsd;
    }

    public String getLastLcStatusMessage() {
        return this.lastLcStatusMessage;
    }

    public synchronized LinphoneCall getPendingIncomingCall() {
        LinphoneCall linphoneCall = null;
        synchronized (this) {
            LinphoneCall currentCall = this.mLc.getCurrentCall();
            if (currentCall != null) {
                State state = currentCall.getState();
                Object obj = (currentCall.getDirection() == CallDirection.Incoming && (state == State.IncomingReceived || state == State.CallIncomingEarlyMedia)) ? 1 : null;
                if (obj == null) {
                    currentCall = null;
                }
                linphoneCall = currentCall;
            }
        }
        return linphoneCall;
    }

    public void globalState(LinphoneCore linphoneCore, GlobalState globalState, String str) {
        Log.m11095i("new state [", globalState, "]");
        this.mListenerDispatcher.onGlobalStateChanged(globalState, str);
    }

    public void infoReceived(LinphoneCore linphoneCore, LinphoneCall linphoneCall, LinphoneInfoMessage linphoneInfoMessage) {
        Log.m11089d("Info message received from " + linphoneCall.getRemoteAddress().asString());
        if (linphoneInfoMessage.getContent() != null) {
            Log.m11089d("Info received with body with mime type " + linphoneInfoMessage.getContent().getType() + "/" + linphoneInfoMessage.getContent().getSubtype() + " and data [" + linphoneInfoMessage.getContent().getDataAsString() + "]");
        }
    }

    public synchronized void initLiblinphone(Context context) {
        LinphoneCoreFactory.instance().setDebugMode(false, "mobi.mmdt.ott.voip");
        this.mLc = LinphoneCoreFactory.instance().createLinphoneCore(this, this.mLinphoneConfigFile, this.mLinphoneFactoryConfigFile, null, context);
        this.mLc.setContext(context);
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), LINPHONE_VOLUME_STREAM).versionName;
            if (str == null) {
                str = String.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), LINPHONE_VOLUME_STREAM).versionCode);
            }
            this.mLc.setUserAgent("com.mmdt", str);
        } catch (Throwable e) {
            Log.m11090e(e, "cannot get version name");
        }
        this.mLc.setZrtpSecretsCache(this.basePath + "/zrtp_secrets");
        this.mLc.setRing(null);
        this.mLc.setRootCA(this.mLinphoneRootCaFile);
        this.mLc.setPlayFile(this.mPauseSoundFile);
        this.mLc.setChatDatabasePath(this.mChatDatabaseFile);
        this.mLc.setMaxCalls(1);
        this.mLc.enableKeepAlive(true);
        this.mLc.enableVideo(false, false);
        this.mLc.setDownloadBandwidth(128);
        this.mLc.setUploadBandwidth(128);
        Log.m11097w("MediaStreamer : " + Runtime.getRuntime().availableProcessors() + " cores detected and configured");
        this.mLc.setCpuCount(r0);
        initTunnelFromConf();
        TimerTask c27952 = new C27952();
        this.mTimer = new Timer("Linphone scheduler");
        this.mTimer.schedule(c27952, 0, 20);
    }

    public void initTunnelFromConf() {
        if (this.mLc.isTunnelAvailable()) {
            NetworkInfo activeNetworkInfo = this.mConnectivityManager.getActiveNetworkInfo();
            this.mLc.tunnelCleanServers();
            String tunnelHost = this.mPrefs.getTunnelHost();
            if (tunnelHost != null) {
                this.mLc.tunnelAddServerAndMirror(tunnelHost, this.mPrefs.getTunnelPort(), 12345, PacketWriter.QUEUE_SIZE);
                manageTunnelServer(activeNetworkInfo);
            }
        }
    }

    public void isComposingReceived(LinphoneCore linphoneCore, LinphoneChatRoom linphoneChatRoom) {
        Log.m11089d("Composing received for chatroom " + linphoneChatRoom.getPeerAddress().asStringUriOnly());
        if (this.composingReceivedListener != null) {
            this.composingReceivedListener.onComposingReceived(linphoneChatRoom);
        }
    }

    public void messageReceived(LinphoneCore linphoneCore, LinphoneChatRoom linphoneChatRoom, LinphoneChatMessage linphoneChatMessage) {
    }

    public void newOutgoingCall(String str, String str2) {
        boolean z = true;
        try {
            LinphoneAddress interpretUrl = this.mLc.interpretUrl(str);
            if (this.mServiceContext.getResources().getBoolean(C1134b.override_domain_using_default_one)) {
                interpretUrl.setDomain(this.mServiceContext.getString(C1136d.default_domain));
            }
            LinphoneProxyConfig defaultProxyConfig = this.mLc.getDefaultProxyConfig();
            if (this.mR.getBoolean(C1134b.forbid_self_call) && defaultProxyConfig != null && interpretUrl.asStringUriOnly().equals(defaultProxyConfig.getIdentity())) {
                this.mListenerDispatcher.tryingNewOutgoingCallButWrongDestinationAddress();
                return;
            }
            interpretUrl.setDisplayName(str2);
            boolean z2 = !LinphoneUtils.isHightBandwidthConnection(SipLibService.instance().getApplicationContext());
            if (this.mLc.isNetworkReachable()) {
                try {
                    if (Version.isVideoCapable()) {
                        boolean isVideoEnabled = this.mPrefs.isVideoEnabled();
                        boolean shouldInitiateVideoCall = this.mPrefs.shouldInitiateVideoCall();
                        CallManager instance = CallManager.getInstance();
                        if (!(isVideoEnabled && shouldInitiateVideoCall)) {
                            z = false;
                        }
                        instance.inviteAddress(interpretUrl, z, z2);
                        return;
                    }
                    CallManager.getInstance().inviteAddress(interpretUrl, false, z2);
                    return;
                } catch (LinphoneCoreException e) {
                    this.mListenerDispatcher.tryingNewOutgoingCallButCannotGetCallParameters();
                    return;
                }
            }
            Log.m11091e("Error: " + getString(C1136d.error_network_unreachable));
            throw new C1128a();
        } catch (LinphoneCoreException e2) {
            this.mListenerDispatcher.tryingNewOutgoingCallButWrongDestinationAddress();
        }
    }

    public void newOutgoingCall(AddressType addressType) {
        newOutgoingCall(addressType.getText().toString(), addressType.getDisplayedName());
    }

    public void newSubscriptionRequest(LinphoneCore linphoneCore, LinphoneFriend linphoneFriend, String str) {
    }

    public void notifyPresenceReceived(LinphoneCore linphoneCore, LinphoneFriend linphoneFriend) {
    }

    public void notifyReceived(LinphoneCore linphoneCore, LinphoneCall linphoneCall, LinphoneAddress linphoneAddress, byte[] bArr) {
    }

    public void notifyReceived(LinphoneCore linphoneCore, LinphoneEvent linphoneEvent, String str, LinphoneContent linphoneContent) {
        Log.m11089d("Notify received for event " + str);
        if (linphoneContent != null) {
            Log.m11089d("with content " + linphoneContent.getType() + "/" + linphoneContent.getSubtype() + " data:" + linphoneContent.getDataAsString());
        }
    }

    public void playDtmf(ContentResolver contentResolver, char c) {
        try {
            if (System.getInt(contentResolver, "dtmf_tone") == 0) {
                return;
            }
        } catch (SettingNotFoundException e) {
        }
        getLc().playDtmf(c, -1);
    }

    public void publishStateChanged(LinphoneCore linphoneCore, LinphoneEvent linphoneEvent, PublishState publishState) {
    }

    public void refreshRegister() {
        if (getLc() != null) {
            getLc().refreshRegisters();
        }
    }

    public void registrationState(LinphoneCore linphoneCore, LinphoneProxyConfig linphoneProxyConfig, RegistrationState registrationState, String str) {
        Log.m11095i("new state [" + registrationState + "]");
        this.mListenerDispatcher.onRegistrationStateChanged(registrationState, str);
    }

    @TargetApi(11)
    public boolean routeAudioToBluetooth() {
        if (!BluetoothAdapter.getDefaultAdapter().isEnabled() || !this.mAudioManager.isBluetoothScoAvailableOffCall()) {
            return false;
        }
        this.mAudioManager.setBluetoothScoOn(true);
        this.mAudioManager.startBluetoothSco();
        this.mBluetoothStarted = true;
        if (Version.sdkAboveOrEqual(11)) {
            this.isUsingBluetoothAudioRoute = false;
            if (this.mBluetoothHeadset != null) {
                for (BluetoothDevice bluetoothDevice : this.mBluetoothHeadset.getConnectedDevices()) {
                    this.isUsingBluetoothAudioRoute = (this.mBluetoothHeadset.getConnectionState(bluetoothDevice) == 2 ? 1 : LINPHONE_VOLUME_STREAM) | this.isUsingBluetoothAudioRoute;
                }
            }
            if (this.isUsingBluetoothAudioRoute) {
                for (LinphoneOnAudioChangedListener onAudioStateChanged : getSimpleListeners(LinphoneOnAudioChangedListener.class)) {
                    onAudioStateChanged.onAudioStateChanged(AudioState.SPEAKER);
                }
            } else {
                Log.m11089d("No bluetooth device available");
                scoDisconnected();
            }
        }
        return this.isUsingBluetoothAudioRoute;
    }

    public void routeAudioToReceiver() {
        routeAudioToSpeakerHelper(false);
    }

    public void routeAudioToSpeaker() {
        routeAudioToSpeakerHelper(true);
    }

    public void scoConnected() {
        Log.m11095i("Bluetooth sco connected!");
        this.isBluetoothScoConnected = true;
    }

    public void scoDisconnected() {
        Log.m11097w("Bluetooth sco disconnected!");
        this.isUsingBluetoothAudioRoute = false;
        this.isBluetoothScoConnected = false;
        if (this.mAudioManager != null) {
            this.mAudioManager.stopBluetoothSco();
            this.mAudioManager.setBluetoothScoOn(false);
        }
    }

    public void sendStaticImage(boolean z) {
        if (this.mLc.isIncall()) {
            enableCamera(this.mLc.getCurrentCall(), !z);
        }
    }

    public void setOnComposingReceivedListener(LinphoneOnComposingReceivedListener linphoneOnComposingReceivedListener) {
        this.composingReceivedListener = linphoneOnComposingReceivedListener;
    }

    public void setOnDTMFReceivedListener(LinphoneOnDTMFReceivedListener linphoneOnDTMFReceivedListener) {
        this.dtmfReceivedListener = linphoneOnDTMFReceivedListener;
    }

    public void show(LinphoneCore linphoneCore) {
    }

    @TargetApi(11)
    public void startBluetooth() {
        boolean z = false;
        this.mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (!this.mBluetoothAdapter.isEnabled()) {
            this.isBluetoothScoConnected = false;
            scoDisconnected();
            routeAudioToReceiver();
        } else if (Version.sdkAboveOrEqual(11)) {
            this.mBluetoothAdapter.getProfileProxy(this.mServiceContext, new C27941(), 1);
        } else {
            try {
                this.mServiceContext.unregisterReceiver(this.bluetoothReiceiver);
            } catch (Exception e) {
            }
            Intent registerReceiver = this.mServiceContext.registerReceiver(this.bluetoothReiceiver, new IntentFilter("android.media.SCO_AUDIO_STATE_CHANGED"));
            if (registerReceiver != null) {
                z = registerReceiver.getIntExtra("android.media.extra.SCO_AUDIO_STATE", LINPHONE_VOLUME_STREAM);
            }
            if (z) {
                this.isBluetoothScoConnected = true;
            }
        }
    }

    public void startEcCalibration(EcCalibrationListener ecCalibrationListener) {
        int streamVolume = this.mAudioManager.getStreamVolume(LINPHONE_VOLUME_STREAM);
        this.mAudioManager.setStreamVolume(LINPHONE_VOLUME_STREAM, this.mAudioManager.getStreamMaxVolume(LINPHONE_VOLUME_STREAM), LINPHONE_VOLUME_STREAM);
        this.mLc.startEchoCalibration(ecCalibrationListener);
        this.mAudioManager.setStreamVolume(LINPHONE_VOLUME_STREAM, streamVolume, LINPHONE_VOLUME_STREAM);
    }

    public void subscriptionStateChanged(LinphoneCore linphoneCore, LinphoneEvent linphoneEvent, SubscriptionState subscriptionState) {
        Log.m11089d("Subscription state changed to " + subscriptionState + " event name is " + linphoneEvent.getEventName());
    }

    public void terminateCall() {
        if (this.mLc.isIncall()) {
            this.mLc.terminateCall(this.mLc.getCurrentCall());
        }
    }

    public void textReceived(LinphoneCore linphoneCore, LinphoneChatRoom linphoneChatRoom, LinphoneAddress linphoneAddress, String str) {
    }

    public boolean toggleEnableCamera() {
        boolean z = false;
        if (this.mLc.isIncall()) {
            if (!this.mLc.getCurrentCall().cameraEnabled()) {
                z = true;
            }
            enableCamera(this.mLc.getCurrentCall(), z);
        }
        return z;
    }

    public void transferState(LinphoneCore linphoneCore, LinphoneCall linphoneCall, State state) {
    }

    public void updateNetworkReachability() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.mServiceContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || activeNetworkInfo.getState() == NetworkInfo.State.DISCONNECTED) {
            Log.m11095i("No connectivity: setting network unreachable");
            this.mLc.setNetworkReachable(false);
        } else if (activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED) {
            manageTunnelServer(activeNetworkInfo);
            if (!LinphonePreferences.instance().isWifiOnlyEnabled()) {
                int type = activeNetworkInfo.getType();
                if (type != this.mLastNetworkType) {
                    Log.m11095i("Connectivity has changed.");
                    this.mLc.setNetworkReachable(false);
                }
                this.mLc.setNetworkReachable(true);
                this.mLastNetworkType = type;
            } else if (activeNetworkInfo.getType() == 1) {
                this.mLc.setNetworkReachable(true);
            } else {
                Log.m11095i("Wifi-only mode, setting network not reachable");
                this.mLc.setNetworkReachable(false);
            }
        }
    }
}
