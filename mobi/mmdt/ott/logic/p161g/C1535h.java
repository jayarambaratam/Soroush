package mobi.mmdt.ott.logic.p161g;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import java.util.Iterator;
import mobi.mmdt.ott.logic.p112a.p113a.p114a.C1320a;
import mobi.mmdt.ott.p086a.p087a.C1129a;
import mobi.mmdt.ott.view.p178a.C1659a;
import org.linphone.LinphoneSimpleListener.LinphoneOnAudioChangedListener.AudioState;
import org.linphone.core.LinphoneAddress;
import org.linphone.core.LinphoneCall;
import org.linphone.core.LinphoneCall.State;
import org.linphone.core.LinphoneChatMessage;
import org.linphone.core.LinphoneCore.EcCalibratorStatus;
import org.linphone.core.LinphoneCore.GlobalState;
import org.linphone.core.LinphoneCore.RegistrationState;
import p000a.p001a.p002a.C0002c;

/* renamed from: mobi.mmdt.ott.logic.g.h */
class C1535h implements C1129a {
    final /* synthetic */ C1534g f5172a;

    C1535h(C1534g c1534g) {
        this.f5172a = c1534g;
    }

    public void m7749a() {
        this.f5172a.f5166l = true;
        if (this.f5172a.f5160f == null || this.f5172a.f5159e == null || this.f5172a.f5160f == null) {
            this.f5172a.m7740b();
        } else if (this.f5172a.f5158d) {
            this.f5172a.f5158d = false;
            this.f5172a.m7733j();
            this.f5172a.m7734k();
        }
    }

    public void m7750a(Context context, NetworkInfo networkInfo, ConnectivityManager connectivityManager) {
        Log.d("SipService", "Connectivity Changed " + networkInfo.getReason() + " " + networkInfo.toString() + " " + networkInfo.getState() + " " + connectivityManager.getNetworkPreference());
    }

    public void m7751a(AudioState audioState) {
        if (audioState == AudioState.BLUETOOTH) {
            this.f5172a.f5168n = true;
            this.f5172a.f5167m = false;
        } else if (audioState == AudioState.EARPIECE) {
            this.f5172a.f5168n = false;
            this.f5172a.f5167m = false;
        } else {
            this.f5172a.f5168n = false;
            this.f5172a.f5167m = true;
        }
    }

    public void m7752a(LinphoneAddress linphoneAddress, LinphoneChatMessage linphoneChatMessage, int i) {
    }

    public void m7753a(LinphoneCall linphoneCall, int i) {
    }

    public void m7754a(LinphoneCall linphoneCall, State state, String str) {
        Iterator it = this.f5172a.f5156b.iterator();
        while (it.hasNext()) {
            C1531e c1531e = (C1531e) it.next();
            if (c1531e != null) {
                c1531e.m7716a(this.f5172a.m7721a(state), str);
                c1531e.m7715a(linphoneCall.getDuration(), linphoneCall.getCurrentQuality());
            }
        }
        if (this.f5172a.f5156b.size() == 0) {
            C0002c.m2a().m17c(new C1320a(this.f5172a.m7747h(), this.f5172a.m7747h().toString(), null));
        }
        if (state.equals(State.IncomingReceived)) {
            LinphoneAddress remoteAddress = linphoneCall.getRemoteAddress();
            String userName = remoteAddress.getUserName() != null ? remoteAddress.getUserName() : remoteAddress.getDisplayName() != null ? remoteAddress.getDisplayName() : null;
            C1659a.m8436a(this.f5172a.f5171q, userName);
        }
    }

    public void m7755a(LinphoneCall linphoneCall, boolean z, String str) {
    }

    public void m7756a(EcCalibratorStatus ecCalibratorStatus, int i) {
    }

    public void m7757a(GlobalState globalState, String str) {
    }

    public void m7758a(RegistrationState registrationState) {
        if (registrationState != RegistrationState.RegistrationOk && registrationState != RegistrationState.RegistrationNone && registrationState != RegistrationState.RegistrationProgress && registrationState != RegistrationState.RegistrationFailed && registrationState != RegistrationState.RegistrationCleared) {
            Log.d("SipService", "Unknown status notification " + registrationState);
        }
    }
}
