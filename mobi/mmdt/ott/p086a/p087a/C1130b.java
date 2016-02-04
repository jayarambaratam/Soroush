package mobi.mmdt.ott.p086a.p087a;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import mobi.mmdt.componentsutils.p079a.p080a.C1104b;
import net.frakbot.glowpadbackport.BuildConfig;
import org.linphone.LinphoneManager;
import org.linphone.LinphoneManager.EcCalibrationListener;
import org.linphone.LinphonePreferences;
import org.linphone.LinphoneSimpleListener.ConnectivityChangedListener;
import org.linphone.LinphoneSimpleListener.LinphoneOnAudioChangedListener;
import org.linphone.LinphoneSimpleListener.LinphoneOnAudioChangedListener.AudioState;
import org.linphone.LinphoneSimpleListener.LinphoneOnCallEncryptionChangedListener;
import org.linphone.LinphoneSimpleListener.LinphoneOnCallStateChangedListener;
import org.linphone.LinphoneSimpleListener.LinphoneOnComposingReceivedListener;
import org.linphone.LinphoneSimpleListener.LinphoneOnDTMFReceivedListener;
import org.linphone.LinphoneSimpleListener.LinphoneOnGlobalStateChangedListener;
import org.linphone.LinphoneSimpleListener.LinphoneOnMessageReceivedListener;
import org.linphone.LinphoneSimpleListener.LinphoneOnRegistrationStateChangedListener;
import org.linphone.LinphoneUtils;
import org.linphone.SipLibService;
import org.linphone.core.LinphoneAddress;
import org.linphone.core.LinphoneAddress.TransportType;
import org.linphone.core.LinphoneCall;
import org.linphone.core.LinphoneCall.State;
import org.linphone.core.LinphoneChatMessage;
import org.linphone.core.LinphoneChatRoom;
import org.linphone.core.LinphoneCore;
import org.linphone.core.LinphoneCore.EcCalibratorStatus;
import org.linphone.core.LinphoneCore.GlobalState;
import org.linphone.core.LinphoneCore.RegistrationState;
import org.linphone.core.VideoSize;

/* renamed from: mobi.mmdt.ott.a.a.b */
public class C1130b implements EcCalibrationListener, ConnectivityChangedListener, LinphoneOnAudioChangedListener, LinphoneOnCallEncryptionChangedListener, LinphoneOnCallStateChangedListener, LinphoneOnComposingReceivedListener, LinphoneOnDTMFReceivedListener, LinphoneOnGlobalStateChangedListener, LinphoneOnMessageReceivedListener, LinphoneOnRegistrationStateChangedListener {
    private static C1130b f4185a;
    private C1132d f4186b;
    private LinphonePreferences f4187c;
    private Context f4188d;
    private boolean f4189e;
    private ArrayList<C1129a> f4190f;

    private C1130b(Context context, C1129a c1129a) {
        this.f4189e = false;
        this.f4190f = new ArrayList();
        if (c1129a != null) {
            m6476a(c1129a);
        }
        this.f4188d = context;
        m6472k();
        this.f4187c = LinphonePreferences.instance();
    }

    public static C1130b m6468a(Context context, C1129a c1129a) {
        if (f4185a == null) {
            f4185a = new C1130b(context, c1129a);
        }
        return f4185a;
    }

    public static boolean m6471a() {
        return f4185a != null;
    }

    private void m6472k() {
        if (SipLibService.isReady()) {
            m6473l();
            return;
        }
        this.f4188d.startService(new Intent("android.intent.action.MAIN").setClass(this.f4188d, SipLibService.class));
        this.f4186b = new C1132d();
        this.f4186b.start();
    }

    private void m6473l() {
        LinphoneManager.removeListener(this);
        LinphoneManager.addListener(this);
        Iterator it = this.f4190f.iterator();
        while (it.hasNext()) {
            ((C1129a) it.next()).m6458a();
        }
    }

    public void m6474a(String str, int i, String str2, String str3, int i2, int i3, boolean z) {
        String str4 = str + ":" + i;
        if (LinphonePreferences.instance().getAccountCount() != 0) {
            for (int i4 = 0; i4 < LinphonePreferences.instance().getAccountCount(); i4++) {
                try {
                    LinphonePreferences.instance().deleteAccount(i4);
                } catch (Throwable e) {
                    C1104b.m6368b((Object) this, e);
                }
            }
        }
        this.f4187c.useRandomPort(true);
        this.f4187c.setDebugEnabled(z);
        this.f4187c.setAutoStart(false);
        this.f4187c.setBackgroundModeEnabled(true);
        this.f4187c.setWifiOnlyEnabled(Boolean.valueOf(false));
        switch (i3) {
            case VideoSize.QCIF /*0*/:
                this.f4187c.setNewAccountTransport(TransportType.LinphoneTransportTcp);
                break;
            case VideoSize.CIF /*1*/:
                this.f4187c.setNewAccountTransport(TransportType.LinphoneTransportTls);
                break;
            case VideoSize.HVGA /*2*/:
                this.f4187c.setNewAccountTransport(TransportType.LinphoneTransportUdp);
                break;
            default:
                this.f4187c.setNewAccountTransport(TransportType.LinphoneTransportUdp);
                break;
        }
        this.f4187c.setNewAccountUsername(str2);
        this.f4187c.setNewAccountDomain(str4);
        this.f4187c.setNewAccountPassword(str3);
        this.f4187c.setNewAccountExpires(BuildConfig.FLAVOR + i2);
        this.f4187c.saveNewAccount();
        m6481d();
    }

    public void m6475a(String str, String str2) {
        LinphoneManager.getInstance().newOutgoingCall(str, str2);
    }

    public void m6476a(C1129a c1129a) {
        this.f4190f.add(c1129a);
    }

    public void m6477a(boolean z) {
        LinphoneManager.getLc().muteMic(z);
    }

    public void m6478b() {
        LinphoneCall i = m6486i();
        LinphoneCore lc = LinphoneManager.getLc();
        if (i == null || !LinphoneUtils.isCallRunning(i)) {
            List callsInState = LinphoneUtils.getCallsInState(lc, Collections.singletonList(State.Paused));
            if (callsInState.size() == 1) {
                LinphoneCall linphoneCall = (LinphoneCall) callsInState.get(0);
                if ((i != null && linphoneCall.equals(i)) || i == null) {
                    lc.resumeCall(linphoneCall);
                }
            } else if (i != null) {
                lc.resumeCall(i);
            }
        } else if (i.isInConference()) {
            lc.removeFromConference(i);
            if (lc.getConferenceSize() <= 1) {
                lc.leaveConference();
            }
        } else {
            lc.pauseCall(i);
        }
    }

    public void m6479b(boolean z) {
        if (z) {
            LinphoneManager.getInstance().routeAudioToSpeaker();
            LinphoneManager.getLc().enableSpeaker(z);
            return;
        }
        LinphoneManager.getInstance().routeAudioToReceiver();
    }

    public void m6480c() {
        LinphoneManager.getInstance().refreshRegister();
    }

    public void m6481d() {
        if (LinphonePreferences.instance().getAccountCount() != 0) {
            for (int i = 1; i < LinphonePreferences.instance().getAccountCount(); i++) {
                try {
                    this.f4187c.setAccountEnabled(i, true);
                } catch (Throwable e) {
                    try {
                        C1104b.m6368b((Object) this, e);
                    } catch (Throwable e2) {
                        C1104b.m6368b((Object) this, e2);
                        return;
                    }
                }
            }
            m6480c();
        }
    }

    public void m6482e() {
        if (LinphonePreferences.instance().getAccountCount() != 0) {
            for (int i = 1; i < LinphonePreferences.instance().getAccountCount(); i++) {
                try {
                    this.f4187c.setAccountEnabled(i, false);
                } catch (Throwable e) {
                    try {
                        C1104b.m6368b((Object) this, e);
                    } catch (Throwable e2) {
                        C1104b.m6368b((Object) this, e2);
                        return;
                    }
                }
            }
            this.f4187c.setAccountEnabled(0, false);
            m6480c();
        }
    }

    public void m6483f() {
        if (LinphonePreferences.instance().getAccountCount() != 0) {
            for (int i = 0; i < LinphonePreferences.instance().getAccountCount(); i++) {
                try {
                    LinphonePreferences.instance().deleteAccount(i);
                } catch (Throwable e) {
                    C1104b.m6368b((Object) this, e);
                }
            }
        }
    }

    public boolean m6484g() {
        return LinphoneManager.getInstance().acceptCallIfIncomingPending();
    }

    public void m6485h() {
        LinphoneCore lc = LinphoneManager.getLc();
        LinphoneCall currentCall = lc.getCurrentCall();
        if (currentCall != null) {
            lc.terminateCall(currentCall);
        } else if (lc.isInConference()) {
            lc.terminateConference();
        } else {
            lc.terminateAllCalls();
        }
    }

    public LinphoneCall m6486i() {
        return LinphoneManager.getLc().getCurrentCall();
    }

    public synchronized void m6487j() {
        this.f4188d.stopService(new Intent("android.intent.action.MAIN").setClass(this.f4188d, SipLibService.class));
    }

    public void onAudioStateChanged(AudioState audioState) {
        Log.d("SunLinphone", "onAudioStateChanged : <" + audioState + ">");
        Iterator it = this.f4190f.iterator();
        while (it.hasNext()) {
            ((C1129a) it.next()).m6460a(audioState);
        }
    }

    public void onCallEncryptionChanged(LinphoneCall linphoneCall, boolean z, String str) {
        Log.d("SunLinphone", "onCallEncryptionChanged : <>");
        Iterator it = this.f4190f.iterator();
        while (it.hasNext()) {
            ((C1129a) it.next()).m6464a(linphoneCall, z, str);
        }
    }

    public void onCallStateChanged(LinphoneCall linphoneCall, State state, String str) {
        Log.d("SunLinphone", "onCallStateChanged : <" + linphoneCall.getState().toString() + " " + linphoneCall.getRemoteAddress() + " " + linphoneCall.getDuration() + " " + state.toString() + " " + str + ">");
        if (linphoneCall.getCurrentParamsCopy() != null) {
            Log.d("SunLinphone", "Sunlin : " + linphoneCall.getCurrentParamsCopy().getUsedAudioCodec());
        }
        Iterator it = this.f4190f.iterator();
        while (it.hasNext()) {
            ((C1129a) it.next()).m6463a(linphoneCall, state, str);
        }
    }

    public void onComposingReceived(LinphoneChatRoom linphoneChatRoom) {
        Log.d("SunLinphone", "onComposingReceived : <>");
    }

    public void onConnectivityChanged(Context context, NetworkInfo networkInfo, ConnectivityManager connectivityManager) {
        Log.d("SunLinphone", "onConnectivityChanged : <>");
        Iterator it = this.f4190f.iterator();
        while (it.hasNext()) {
            ((C1129a) it.next()).m6459a(context, networkInfo, connectivityManager);
        }
    }

    public void onDTMFReceived(LinphoneCall linphoneCall, int i) {
        Log.d("SunLinphone", "onDTMFReceived : <>");
        Iterator it = this.f4190f.iterator();
        while (it.hasNext()) {
            ((C1129a) it.next()).m6462a(linphoneCall, i);
        }
    }

    public void onEcCalibrationStatus(EcCalibratorStatus ecCalibratorStatus, int i) {
        Log.d("SunLinphone", "onEcCalibrationStatus : <" + ecCalibratorStatus + " " + i + ">");
        Iterator it = this.f4190f.iterator();
        while (it.hasNext()) {
            ((C1129a) it.next()).m6465a(ecCalibratorStatus, i);
        }
    }

    public void onGlobalStateChanged(GlobalState globalState, String str) {
        Log.d("SunLinphone", "onGlobalStateChanged : <" + globalState + ">");
        Iterator it = this.f4190f.iterator();
        while (it.hasNext()) {
            ((C1129a) it.next()).m6466a(globalState, str);
        }
    }

    public void onMessageReceived(LinphoneAddress linphoneAddress, LinphoneChatMessage linphoneChatMessage, int i) {
        Log.d("SunLinphone", "onMessageReceived : <" + linphoneAddress.getDisplayName() + " " + linphoneAddress.getUserName() + " " + linphoneChatMessage.toString() + " " + i + ">");
        Iterator it = this.f4190f.iterator();
        while (it.hasNext()) {
            ((C1129a) it.next()).m6461a(linphoneAddress, linphoneChatMessage, i);
        }
    }

    public void onRegistrationStateChanged(RegistrationState registrationState) {
        Log.d("SunLinphone", "onRegistrationStateChanged : <" + registrationState.toString() + ">");
        if (registrationState == RegistrationState.RegistrationOk) {
            this.f4189e = true;
        } else {
            this.f4189e = false;
        }
        Iterator it = this.f4190f.iterator();
        while (it.hasNext()) {
            ((C1129a) it.next()).m6467a(registrationState);
        }
    }
}
