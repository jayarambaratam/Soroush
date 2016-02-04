package org.linphone;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiManager.WifiLock;
import android.os.Handler;
import android.os.IBinder;
import android.os.SystemClock;
import mobi.mmdt.componentsutils.p079a.p080a.C1104b;
import mobi.mmdt.ott.p086a.C1134b;
import mobi.mmdt.ott.p086a.p087a.C1130b;
import org.linphone.LinphoneManager.NewOutgoingCallUiListener;
import org.linphone.LinphoneSimpleListener.LinphoneServiceListener;
import org.linphone.core.LinphoneCall;
import org.linphone.core.LinphoneCall.State;
import org.linphone.core.LinphoneCore.GlobalState;
import org.linphone.core.LinphoneCore.RegistrationState;
import org.linphone.mediastream.Log;
import org.linphone.mediastream.Version;

public final class SipLibService extends Service implements LinphoneServiceListener {
    private static final int IC_LEVEL_OFFLINE = 3;
    private static final int IC_LEVEL_ORANGE = 0;
    public static final String START_LINPHONE_LOGS = " ==== Phone information dump ====";
    private static SipLibService instance;
    private static final Class<?>[] mSetFgSign;
    private static final Class<?>[] mStartFgSign;
    private static final Class<?>[] mStopFgSign;
    private InCallIconState mCurrentIncallIconState;
    public Handler mHandler;
    private PendingIntent mKeepAlivePendingIntent;
    private NotificationManager mNM;
    private Object[] mSetForegroundArgs;
    private Object[] mStartForegroundArgs;
    private Object[] mStopForegroundArgs;
    private boolean mTestDelayElapsed;
    private WifiLock mWifiLock;
    private WifiManager mWifiManager;

    /* renamed from: org.linphone.SipLibService.1 */
    class C27971 implements Runnable {
        C27971() {
        }

        public void run() {
            SipLibService.this.mTestDelayElapsed = true;
        }
    }

    /* renamed from: org.linphone.SipLibService.2 */
    class C27982 implements Runnable {
        final /* synthetic */ String val$message;

        C27982(String str) {
            this.val$message = str;
        }

        public void run() {
            if (SipLibService.guiListener() != null) {
                SipLibService.guiListener().onDisplayStatus(this.val$message);
            }
        }
    }

    /* renamed from: org.linphone.SipLibService.3 */
    class C27993 implements Runnable {
        final /* synthetic */ String val$message;

        C27993(String str) {
            this.val$message = str;
        }

        public void run() {
            if (SipLibService.guiListener() != null) {
                SipLibService.guiListener().onGlobalStateChangedToOn(this.val$message);
            }
        }
    }

    /* renamed from: org.linphone.SipLibService.4 */
    class C28004 implements Runnable {
        final /* synthetic */ RegistrationState val$state;

        C28004(RegistrationState registrationState) {
            this.val$state = registrationState;
        }

        public void run() {
            if (C1130b.m6471a()) {
                C1130b.m6468a(SipLibService.this.getApplicationContext(), null).onRegistrationStateChanged(this.val$state);
            }
        }
    }

    /* renamed from: org.linphone.SipLibService.5 */
    class C28015 implements Runnable {
        final /* synthetic */ LinphoneCall val$call;
        final /* synthetic */ String val$message;
        final /* synthetic */ State val$state;

        C28015(LinphoneCall linphoneCall, State state, String str) {
            this.val$call = linphoneCall;
            this.val$state = state;
            this.val$message = str;
        }

        public void run() {
            if (SipLibService.guiListener() != null) {
                SipLibService.guiListener().onCallStateChanged(this.val$call, this.val$state, this.val$message);
            }
        }
    }

    /* renamed from: org.linphone.SipLibService.6 */
    class C28026 implements Runnable {
        C28026() {
        }

        public void run() {
            if (SipLibService.guiListener() != null) {
                SipLibService.guiListener().onAlreadyInCall();
            }
        }
    }

    /* renamed from: org.linphone.SipLibService.7 */
    class C28037 implements Runnable {
        C28037() {
        }

        public void run() {
            if (SipLibService.guiListener() != null) {
                SipLibService.guiListener().onCannotGetCallParameters();
            }
        }
    }

    /* renamed from: org.linphone.SipLibService.8 */
    class C28048 implements Runnable {
        C28048() {
        }

        public void run() {
            if (SipLibService.guiListener() != null) {
                SipLibService.guiListener().onWrongDestinationAddress();
            }
        }
    }

    enum InCallIconState {
        IN_CALL,
        PAUSE,
        VIDEO,
        IDLE
    }

    public interface LinphoneGuiListener extends NewOutgoingCallUiListener {
        void onCallStateChanged(LinphoneCall linphoneCall, State state, String str);

        void onDisplayStatus(String str);

        void onGlobalStateChangedToOn(String str);
    }

    static {
        mSetFgSign = new Class[]{Boolean.TYPE};
        mStartFgSign = new Class[]{Integer.TYPE, Notification.class};
        mStopFgSign = new Class[]{Boolean.TYPE};
    }

    public SipLibService() {
        this.mHandler = new Handler();
        this.mTestDelayElapsed = true;
        this.mCurrentIncallIconState = InCallIconState.IDLE;
        this.mSetForegroundArgs = new Object[1];
        this.mStartForegroundArgs = new Object[2];
        this.mStopForegroundArgs = new Object[1];
    }

    private static LinphoneGuiListener guiListener() {
        return null;
    }

    public static SipLibService instance() {
        if (isReady()) {
            return instance;
        }
        throw new RuntimeException("LinphoneService not instantiated yet");
    }

    public static boolean isReady() {
        return instance != null && instance.mTestDelayElapsed;
    }

    private synchronized void notifyWrapper(int i, Notification notification) {
        if (instance == null || notification == null) {
            Log.m11095i("Service not ready, discarding notification");
        } else {
            this.mNM.notify(i, notification);
        }
    }

    private void resetIntentLaunchedOnNotificationClick() {
        Log.m11091e("SipLibService", "Call incomingReceivedActivity");
    }

    @TargetApi(12)
    private void startWifiLock() {
        this.mWifiLock = this.mWifiManager.createWifiLock(IC_LEVEL_OFFLINE, getPackageName() + "-wifi-call-lock");
        this.mWifiLock.setReferenceCounted(false);
    }

    public void displayMessageNotification(String str, String str2, String str3) {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.annotation.TargetApi(19)
    void invokeMethod(java.lang.reflect.Method r5, java.lang.Object[] r6) {
        /*
        r4 = this;
        r5.invoke(r4, r6);	 Catch:{ InvocationTargetException -> 0x0004, IllegalAccessException -> 0x0011 }
    L_0x0003:
        return;
    L_0x0004:
        r0 = move-exception;
    L_0x0005:
        r1 = 1;
        r1 = new java.lang.Object[r1];
        r2 = 0;
        r3 = "Unable to invoke method";
        r1[r2] = r3;
        org.linphone.mediastream.Log.m11096w(r0, r1);
        goto L_0x0003;
    L_0x0011:
        r0 = move-exception;
        goto L_0x0005;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.linphone.SipLibService.invokeMethod(java.lang.reflect.Method, java.lang.Object[]):void");
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCallEncryptionChanged(LinphoneCall linphoneCall, boolean z, String str) {
    }

    public void onCallStateChanged(LinphoneCall linphoneCall, State state, String str) {
        if (instance == null) {
            Log.m11095i("Service not ready, discarding call state change to ", state.toString());
            return;
        }
        if (state == State.IncomingReceived) {
            onIncomingReceived();
        }
        if (state == State.CallUpdatedByRemote) {
            boolean videoEnabled = linphoneCall.getRemoteParams().getVideoEnabled();
            boolean videoEnabled2 = linphoneCall.getCurrentParamsCopy().getVideoEnabled();
            boolean shouldAutomaticallyAcceptVideoRequests = LinphonePreferences.instance().shouldAutomaticallyAcceptVideoRequests();
            if (!(!videoEnabled || videoEnabled2 || shouldAutomaticallyAcceptVideoRequests || LinphoneManager.getLc().isInConference())) {
                try {
                    LinphoneManager.getLc().deferCallUpdate(linphoneCall);
                } catch (Throwable e) {
                    C1104b.m6368b((Object) this, e);
                }
            }
        }
        if (state == State.StreamsRunning) {
            if (getResources().getBoolean(C1134b.enable_call_notification)) {
            }
            if (Version.sdkAboveOrEqual(12)) {
                this.mWifiLock.acquire();
            }
        } else if (getResources().getBoolean(C1134b.enable_call_notification)) {
        }
        if ((state == State.CallEnd || state == State.Error) && LinphoneManager.getLc().getCallsNb() < 1 && Version.sdkAboveOrEqual(12)) {
            this.mWifiLock.release();
        }
        this.mHandler.post(new C28015(linphoneCall, state, str));
    }

    public void onCreate() {
        super.onCreate();
        Log.m11091e("dddd", "Call SipLibService onCreate");
        Log.m11095i(START_LINPHONE_LOGS);
        this.mNM = (NotificationManager) getSystemService("notification");
        LinphoneManager.createAndStart(this, this);
        this.mWifiManager = (WifiManager) getSystemService("wifi");
        if (Version.sdkAboveOrEqual(12)) {
            startWifiLock();
        }
        instance = this;
        if (Version.sdkStrictlyBelow(5)) {
            try {
                getClass().getMethod("setForeground", mSetFgSign);
            } catch (Throwable e) {
                Log.m11090e(e, "Couldn't find foreground method");
            }
        } else {
            try {
                getClass().getMethod("startForeground", mStartFgSign);
                getClass().getMethod("stopForeground", mStopFgSign);
            } catch (Throwable e2) {
                Log.m11090e(e2, "Couldn't find startGoreground or stopForeground");
            }
        }
        if (!this.mTestDelayElapsed) {
            this.mHandler.postDelayed(new C27971(), 5000);
        }
        this.mKeepAlivePendingIntent = PendingIntent.getBroadcast(this, IC_LEVEL_ORANGE, new Intent(this, KeepAliveHandler.class), 1073741824);
        ((AlarmManager) getSystemService("alarm")).setRepeating(2, SystemClock.elapsedRealtime() + 1000, 60000, this.mKeepAlivePendingIntent);
    }

    public synchronized void onDestroy() {
        instance = null;
        LinphoneManager.destroy();
        if (Version.sdkAboveOrEqual(12)) {
            this.mWifiLock.release();
        }
        ((AlarmManager) getSystemService("alarm")).cancel(this.mKeepAlivePendingIntent);
        super.onDestroy();
    }

    public void onDisplayStatus(String str) {
        this.mHandler.post(new C27982(str));
    }

    public void onGlobalStateChanged(GlobalState globalState, String str) {
        if (globalState == GlobalState.GlobalOn) {
            this.mHandler.postDelayed(new C27993(str), 50);
        }
    }

    protected void onIncomingReceived() {
        Log.m11091e("SipLibService", "Call incomingReceivedActivity");
    }

    public void onRegistrationStateChanged(RegistrationState registrationState, String str) {
        this.mHandler.post(new C28004(registrationState));
    }

    public void tryingNewOutgoingCallButAlreadyInCall() {
        this.mHandler.post(new C28026());
    }

    public void tryingNewOutgoingCallButCannotGetCallParameters() {
        this.mHandler.post(new C28037());
    }

    public void tryingNewOutgoingCallButWrongDestinationAddress() {
        this.mHandler.post(new C28048());
    }
}
