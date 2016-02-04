package mobi.mmdt.ott.view.conversation.p215c.p216a.p220d;

import android.view.View;
import android.view.View.OnClickListener;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p224d.C2184d;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.d.l */
class C2117l implements OnClickListener {
    final /* synthetic */ C2115j f6941a;

    C2117l(C2115j c2115j) {
        this.f6941a = c2115j;
    }

    public void onClick(View view) {
        C2184d c2184d = (C2184d) this.f6941a.m8619a();
        switch (C2118m.f6942a[c2184d.m9999r().ordinal()]) {
            case Version.API05_ECLAIR_20 /*5*/:
                this.f6941a.f6939h.m9343b(c2184d.m9996o(), c2184d.m9845i(), true);
            default:
        }
    }
}
