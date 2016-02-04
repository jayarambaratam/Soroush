package mobi.mmdt.ott.view.conversation.p215c.p216a.p218b;

import android.view.View;
import android.view.View.OnClickListener;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p226b.C2165b;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.b.c */
class C2055c implements OnClickListener {
    final /* synthetic */ C2054b f6761a;

    C2055c(C2054b c2054b) {
        this.f6761a = c2054b;
    }

    public void onClick(View view) {
        C2165b c2165b = (C2165b) this.f6761a.m8619a();
        switch (C2056d.f6762a[c2165b.m9905s().ordinal()]) {
            case VideoSize.CIF /*1*/:
                this.f6761a.f6759g.m9344a(c2165b.m9847k(), true);
            case VideoSize.HVGA /*2*/:
                this.f6761a.f6759g.m9345b(c2165b.m9847k());
            case Version.API03_CUPCAKE_15 /*3*/:
                this.f6761a.f6759g.m9344a(c2165b.m9847k(), true);
            case Version.API04_DONUT_16 /*4*/:
                this.f6761a.f6759g.m9344a(c2165b.m9847k(), true);
            case Version.API05_ECLAIR_20 /*5*/:
                this.f6761a.f6760h.m9342a(c2165b.m9904r(), true);
            default:
        }
    }
}
