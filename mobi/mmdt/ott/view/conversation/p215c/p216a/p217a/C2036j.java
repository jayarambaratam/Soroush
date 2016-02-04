package mobi.mmdt.ott.view.conversation.p215c.p216a.p217a;

import android.view.View;
import android.view.View.OnClickListener;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p225a.C2156c;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.a.j */
class C2036j implements OnClickListener {
    final /* synthetic */ C2035i f6701a;

    C2036j(C2035i c2035i) {
        this.f6701a = c2035i;
    }

    public void onClick(View view) {
        C2156c c2156c = (C2156c) this.f6701a.m8619a();
        switch (C2038l.f6703a[c2156c.m9863t().ordinal()]) {
            case VideoSize.CIF /*1*/:
                this.f6701a.f6699h.m9344a(c2156c.m9847k(), true);
            case VideoSize.HVGA /*2*/:
                this.f6701a.f6699h.m9345b(c2156c.m9847k());
            case Version.API03_CUPCAKE_15 /*3*/:
                this.f6701a.f6699h.m9344a(c2156c.m9847k(), true);
            case Version.API04_DONUT_16 /*4*/:
                this.f6701a.f6699h.m9344a(c2156c.m9847k(), true);
            default:
        }
    }
}
