package mobi.mmdt.ott.view.conversation.p215c.p216a.p217a;

import android.view.View;
import android.view.View.OnClickListener;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p225a.C2157d;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.a.n */
class C2040n implements OnClickListener {
    final /* synthetic */ C2039m f6711a;

    C2040n(C2039m c2039m) {
        this.f6711a = c2039m;
    }

    public void onClick(View view) {
        C2157d c2157d = (C2157d) this.f6711a.m8619a();
        switch (C2042p.f6713a[c2157d.m9869t().ordinal()]) {
            case VideoSize.CIF /*1*/:
                this.f6711a.f6709h.m9344a(c2157d.m9847k(), true);
            case VideoSize.HVGA /*2*/:
                this.f6711a.f6709h.m9345b(c2157d.m9847k());
            case Version.API03_CUPCAKE_15 /*3*/:
                this.f6711a.f6709h.m9344a(c2157d.m9847k(), true);
            case Version.API04_DONUT_16 /*4*/:
                this.f6711a.f6709h.m9344a(c2157d.m9847k(), true);
            default:
        }
    }
}
