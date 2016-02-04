package mobi.mmdt.ott.view.conversation.p215c.p216a.p218b;

import android.view.View;
import android.view.View.OnClickListener;
import mobi.mmdt.ott.provider.p170d.C1603h;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p226b.C2168e;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.b.n */
class C2066n implements OnClickListener {
    final /* synthetic */ C2065m f6790a;

    C2066n(C2065m c2065m) {
        this.f6790a = c2065m;
    }

    public void onClick(View view) {
        C2168e c2168e = (C2168e) this.f6790a.m8619a();
        switch (C2068p.f6792a[c2168e.m9921s().ordinal()]) {
            case VideoSize.CIF /*1*/:
                this.f6790a.f6789h.m9344a(c2168e.m9847k(), true);
            case VideoSize.HVGA /*2*/:
                this.f6790a.f6789h.m9345b(c2168e.m9847k());
            case Version.API03_CUPCAKE_15 /*3*/:
                this.f6790a.f6789h.m9344a(c2168e.m9847k(), true);
            case Version.API04_DONUT_16 /*4*/:
                this.f6790a.f6789h.m9344a(c2168e.m9847k(), true);
            case Version.API05_ECLAIR_20 /*5*/:
                if (c2168e.m9919q() == C1603h.PLAYING.ordinal()) {
                    this.f6790a.f6788g.m9348z();
                } else {
                    this.f6790a.f6788g.m9346a(c2168e.m9847k());
                }
            default:
        }
    }
}
