package mobi.mmdt.ott.view.conversation.p215c.p216a.p220d;

import android.view.View;
import android.view.View.OnClickListener;
import mobi.mmdt.ott.provider.p170d.C1603h;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p224d.C2185e;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.d.o */
class C2120o implements OnClickListener {
    final /* synthetic */ C2119n f6950a;

    C2120o(C2119n c2119n) {
        this.f6950a = c2119n;
    }

    public void onClick(View view) {
        C2185e c2185e = (C2185e) this.f6950a.m8619a();
        switch (C2122q.f6952a[c2185e.m10005s().ordinal()]) {
            case VideoSize.CIF /*1*/:
                this.f6950a.f6949h.m9344a(c2185e.m9847k(), true);
            case VideoSize.HVGA /*2*/:
                this.f6950a.f6949h.m9345b(c2185e.m9847k());
            case Version.API03_CUPCAKE_15 /*3*/:
                this.f6950a.f6949h.m9344a(c2185e.m9847k(), true);
            case Version.API04_DONUT_16 /*4*/:
                this.f6950a.f6949h.m9344a(c2185e.m9847k(), true);
            case Version.API05_ECLAIR_20 /*5*/:
                if (c2185e.m10003q() == C1603h.PLAYING.ordinal()) {
                    this.f6950a.f6948g.m9348z();
                } else {
                    this.f6950a.f6948g.m9346a(c2185e.m9847k());
                }
            default:
        }
    }
}
