package mobi.mmdt.ott.p086a.p087a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import org.linphone.LinphoneSimpleListener.LinphoneOnAudioChangedListener.AudioState;
import org.linphone.core.LinphoneAddress;
import org.linphone.core.LinphoneCall;
import org.linphone.core.LinphoneCall.State;
import org.linphone.core.LinphoneChatMessage;
import org.linphone.core.LinphoneCore.EcCalibratorStatus;
import org.linphone.core.LinphoneCore.GlobalState;
import org.linphone.core.LinphoneCore.RegistrationState;

/* renamed from: mobi.mmdt.ott.a.a.a */
public interface C1129a {
    void m6458a();

    void m6459a(Context context, NetworkInfo networkInfo, ConnectivityManager connectivityManager);

    void m6460a(AudioState audioState);

    void m6461a(LinphoneAddress linphoneAddress, LinphoneChatMessage linphoneChatMessage, int i);

    void m6462a(LinphoneCall linphoneCall, int i);

    void m6463a(LinphoneCall linphoneCall, State state, String str);

    void m6464a(LinphoneCall linphoneCall, boolean z, String str);

    void m6465a(EcCalibratorStatus ecCalibratorStatus, int i);

    void m6466a(GlobalState globalState, String str);

    void m6467a(RegistrationState registrationState);
}
