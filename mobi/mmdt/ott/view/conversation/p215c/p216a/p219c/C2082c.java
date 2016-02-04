package mobi.mmdt.ott.view.conversation.p215c.p216a.p219c;

import android.view.View;
import android.view.View.OnClickListener;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p227c.C2174b;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.c.c */
class C2082c implements OnClickListener {
    final /* synthetic */ C2081b f6837a;

    C2082c(C2081b c2081b) {
        this.f6837a = c2081b;
    }

    public void onClick(View view) {
        C2174b c2174b = (C2174b) this.f6837a.m8619a();
        switch (C2083d.f6838a[c2174b.m9949s().ordinal()]) {
            case VideoSize.CIF /*1*/:
                this.f6837a.f6835h.m9344a(c2174b.m9847k(), false);
            case VideoSize.HVGA /*2*/:
                this.f6837a.f6835h.m9345b(c2174b.m9847k());
            case Version.API03_CUPCAKE_15 /*3*/:
                this.f6837a.f6835h.m9344a(c2174b.m9847k(), false);
            case Version.API04_DONUT_16 /*4*/:
                this.f6837a.f6835h.m9344a(c2174b.m9847k(), false);
            case Version.API05_ECLAIR_20 /*5*/:
            case Version.API06_ECLAIR_201 /*6*/:
                this.f6837a.f6836i.m9342a(c2174b.m9948r(), false);
            default:
        }
    }
}
