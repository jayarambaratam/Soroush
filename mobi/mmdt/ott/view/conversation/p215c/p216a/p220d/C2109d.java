package mobi.mmdt.ott.view.conversation.p215c.p216a.p220d;

import android.view.View;
import android.view.View.OnClickListener;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p224d.C2182b;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.d.d */
class C2109d implements OnClickListener {
    final /* synthetic */ C2108c f6921a;

    C2109d(C2108c c2108c) {
        this.f6921a = c2108c;
    }

    public void onClick(View view) {
        C2182b c2182b = (C2182b) this.f6921a.m8619a();
        switch (C2110e.f6922a[c2182b.m9989s().ordinal()]) {
            case VideoSize.CIF /*1*/:
                this.f6921a.f6919g.m9344a(c2182b.m9847k(), true);
            case VideoSize.HVGA /*2*/:
                this.f6921a.f6919g.m9345b(c2182b.m9847k());
            case Version.API03_CUPCAKE_15 /*3*/:
                this.f6921a.f6919g.m9344a(c2182b.m9847k(), true);
            case Version.API04_DONUT_16 /*4*/:
                this.f6921a.f6919g.m9344a(c2182b.m9847k(), true);
            case Version.API05_ECLAIR_20 /*5*/:
                this.f6921a.f6920h.m9342a(c2182b.m9988r(), true);
            default:
        }
    }
}
