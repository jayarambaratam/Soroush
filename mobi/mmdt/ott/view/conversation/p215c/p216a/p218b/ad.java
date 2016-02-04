package mobi.mmdt.ott.view.conversation.p215c.p216a.p218b;

import android.view.View;
import android.view.View.OnClickListener;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p226b.C2172i;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.b.ad */
class ad implements OnClickListener {
    final /* synthetic */ ab f6752a;

    ad(ab abVar) {
        this.f6752a = abVar;
    }

    public void onClick(View view) {
        C2172i c2172i = (C2172i) this.f6752a.m8619a();
        switch (ae.f6753a[c2172i.m9943s().ordinal()]) {
            case Version.API05_ECLAIR_20 /*5*/:
                this.f6752a.f6750i.m9341a(c2172i.m9939o(), c2172i.m9845i(), true);
            default:
        }
    }
}
