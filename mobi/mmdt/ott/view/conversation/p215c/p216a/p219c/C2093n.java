package mobi.mmdt.ott.view.conversation.p215c.p216a.p219c;

import android.view.View;
import android.view.View.OnClickListener;
import mobi.mmdt.ott.provider.p170d.C1603h;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p227c.C2177e;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.c.n */
class C2093n implements OnClickListener {
    final /* synthetic */ C2092m f6869a;

    C2093n(C2092m c2092m) {
        this.f6869a = c2092m;
    }

    public void onClick(View view) {
        C2177e c2177e = (C2177e) this.f6869a.m8619a();
        switch (C2095p.f6871a[c2177e.m9965s().ordinal()]) {
            case VideoSize.CIF /*1*/:
                this.f6869a.f6868i.m9344a(c2177e.m9847k(), false);
            case VideoSize.HVGA /*2*/:
                this.f6869a.f6868i.m9345b(c2177e.m9847k());
            case Version.API03_CUPCAKE_15 /*3*/:
                this.f6869a.f6868i.m9344a(c2177e.m9847k(), false);
            case Version.API04_DONUT_16 /*4*/:
                this.f6869a.f6868i.m9344a(c2177e.m9847k(), false);
            case Version.API05_ECLAIR_20 /*5*/:
                if (c2177e.m9963q() == C1603h.PLAYING.ordinal()) {
                    this.f6869a.f6867h.m9348z();
                } else {
                    this.f6869a.f6867h.m9346a(c2177e.m9847k());
                }
            default:
        }
    }
}
