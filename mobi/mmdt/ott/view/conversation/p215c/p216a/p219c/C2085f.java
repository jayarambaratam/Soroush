package mobi.mmdt.ott.view.conversation.p215c.p216a.p219c;

import android.view.View;
import android.view.View.OnClickListener;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p227c.C2175c;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.c.f */
class C2085f implements OnClickListener {
    final /* synthetic */ C2084e f6847a;

    C2085f(C2084e c2084e) {
        this.f6847a = c2084e;
    }

    public void onClick(View view) {
        C2175c c2175c = (C2175c) this.f6847a.m8619a();
        switch (C2087h.f6849a[c2175c.m9953r().ordinal()]) {
            case VideoSize.CIF /*1*/:
                this.f6847a.f6845h.m9344a(c2175c.m9847k(), false);
            case VideoSize.HVGA /*2*/:
                this.f6847a.f6845h.m9345b(c2175c.m9847k());
            case Version.API03_CUPCAKE_15 /*3*/:
                this.f6847a.f6845h.m9344a(c2175c.m9847k(), false);
            case Version.API04_DONUT_16 /*4*/:
                this.f6847a.f6845h.m9344a(c2175c.m9847k(), false);
            default:
        }
    }
}
