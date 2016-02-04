package mobi.mmdt.ott.view.conversation.p215c.p216a.p220d;

import android.view.View;
import android.view.View.OnClickListener;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p224d.C2188h;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.d.z */
class C2131z implements OnClickListener {
    final /* synthetic */ C2130y f6973a;

    C2131z(C2130y c2130y) {
        this.f6973a = c2130y;
    }

    public void onClick(View view) {
        C2188h c2188h = (C2188h) this.f6973a.m8619a();
        switch (ab.f6901a[c2188h.m10020s().ordinal()]) {
            case VideoSize.CIF /*1*/:
                this.f6973a.f6971i.m9344a(c2188h.m9847k(), true);
            case VideoSize.HVGA /*2*/:
                this.f6973a.f6971i.m9345b(c2188h.m9847k());
            case Version.API03_CUPCAKE_15 /*3*/:
                this.f6973a.f6971i.m9344a(c2188h.m9847k(), true);
            case Version.API04_DONUT_16 /*4*/:
                this.f6973a.f6971i.m9344a(c2188h.m9847k(), true);
            default:
        }
    }
}
