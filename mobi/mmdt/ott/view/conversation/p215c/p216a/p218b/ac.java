package mobi.mmdt.ott.view.conversation.p215c.p216a.p218b;

import android.view.View;
import android.view.View.OnClickListener;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p226b.C2172i;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.b.ac */
class ac implements OnClickListener {
    final /* synthetic */ ab f6751a;

    ac(ab abVar) {
        this.f6751a = abVar;
    }

    public void onClick(View view) {
        C2172i c2172i = (C2172i) this.f6751a.m8619a();
        switch (ae.f6753a[c2172i.m9943s().ordinal()]) {
            case VideoSize.CIF /*1*/:
                this.f6751a.f6749h.m9344a(c2172i.m9847k(), true);
            case VideoSize.HVGA /*2*/:
                this.f6751a.f6749h.m9345b(c2172i.m9847k());
            case Version.API03_CUPCAKE_15 /*3*/:
                this.f6751a.f6749h.m9344a(c2172i.m9847k(), true);
            case Version.API04_DONUT_16 /*4*/:
                this.f6751a.f6749h.m9344a(c2172i.m9847k(), true);
            default:
        }
    }
}
