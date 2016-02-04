package mobi.mmdt.ott.view.conversation.p215c.p216a.p217a;

import android.view.View;
import android.view.View.OnClickListener;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p225a.C2155b;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.a.g */
class C2033g implements OnClickListener {
    final /* synthetic */ C2032f f6692a;

    C2033g(C2032f c2032f) {
        this.f6692a = c2032f;
    }

    public void onClick(View view) {
        C2155b c2155b = (C2155b) this.f6692a.m8619a();
        switch (C2034h.f6693a[c2155b.m9859u().ordinal()]) {
            case VideoSize.CIF /*1*/:
                this.f6692a.f6690h.m9344a(c2155b.m9847k(), true);
            case VideoSize.HVGA /*2*/:
                this.f6692a.f6690h.m9345b(c2155b.m9847k());
            case Version.API03_CUPCAKE_15 /*3*/:
                this.f6692a.f6690h.m9344a(c2155b.m9847k(), true);
            case Version.API04_DONUT_16 /*4*/:
                this.f6692a.f6690h.m9344a(c2155b.m9847k(), true);
            case Version.API05_ECLAIR_20 /*5*/:
                this.f6692a.f6691i.m9342a(c2155b.m9858t(), true);
            default:
        }
    }
}
