package mobi.mmdt.ott.view.conversation.p215c.p216a.p219c;

import android.view.View;
import android.view.View.OnClickListener;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p227c.C2176d;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.c.j */
class C2089j implements OnClickListener {
    final /* synthetic */ C2088i f6858a;

    C2089j(C2088i c2088i) {
        this.f6858a = c2088i;
    }

    public void onClick(View view) {
        C2176d c2176d = (C2176d) this.f6858a.m8619a();
        switch (C2091l.f6860a[c2176d.m9959r().ordinal()]) {
            case VideoSize.CIF /*1*/:
                this.f6858a.f6856h.m9344a(c2176d.m9847k(), false);
            case VideoSize.HVGA /*2*/:
                this.f6858a.f6856h.m9345b(c2176d.m9847k());
            case Version.API03_CUPCAKE_15 /*3*/:
                this.f6858a.f6856h.m9344a(c2176d.m9847k(), false);
            case Version.API04_DONUT_16 /*4*/:
                this.f6858a.f6856h.m9344a(c2176d.m9847k(), false);
            default:
        }
    }
}
