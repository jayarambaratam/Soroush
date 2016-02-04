package mobi.mmdt.ott.view.conversation.p215c.p216a.p217a;

import android.view.View;
import android.view.View.OnClickListener;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p225a.C2156c;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.a.k */
class C2037k implements OnClickListener {
    final /* synthetic */ C2035i f6702a;

    C2037k(C2035i c2035i) {
        this.f6702a = c2035i;
    }

    public void onClick(View view) {
        C2156c c2156c = (C2156c) this.f6702a.m8619a();
        switch (C2038l.f6703a[c2156c.m9863t().ordinal()]) {
            case Version.API05_ECLAIR_20 /*5*/:
                this.f6702a.f6700i.m9343b(c2156c.m9860q(), c2156c.m9845i(), true);
            default:
        }
    }
}
