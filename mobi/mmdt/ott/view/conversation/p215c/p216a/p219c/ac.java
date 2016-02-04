package mobi.mmdt.ott.view.conversation.p215c.p216a.p219c;

import android.view.View;
import android.view.View.OnClickListener;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p227c.C2181i;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.c.ac */
class ac implements OnClickListener {
    final /* synthetic */ ab f6826a;

    ac(ab abVar) {
        this.f6826a = abVar;
    }

    public void onClick(View view) {
        C2181i c2181i = (C2181i) this.f6826a.m8619a();
        switch (ae.f6828a[c2181i.m9983s().ordinal()]) {
            case VideoSize.CIF /*1*/:
                this.f6826a.f6824i.m9344a(c2181i.m9847k(), false);
            case VideoSize.HVGA /*2*/:
                this.f6826a.f6824i.m9345b(c2181i.m9847k());
            case Version.API03_CUPCAKE_15 /*3*/:
                this.f6826a.f6824i.m9344a(c2181i.m9847k(), false);
            case Version.API04_DONUT_16 /*4*/:
                this.f6826a.f6824i.m9344a(c2181i.m9847k(), false);
            default:
        }
    }
}
