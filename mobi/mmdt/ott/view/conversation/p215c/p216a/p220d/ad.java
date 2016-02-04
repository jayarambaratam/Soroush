package mobi.mmdt.ott.view.conversation.p215c.p216a.p220d;

import android.view.View;
import android.view.View.OnClickListener;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p224d.C2189i;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.d.ad */
class ad implements OnClickListener {
    final /* synthetic */ ac f6910a;

    ad(ac acVar) {
        this.f6910a = acVar;
    }

    public void onClick(View view) {
        C2189i c2189i = (C2189i) this.f6910a.m8619a();
        switch (af.f6912a[c2189i.m10027s().ordinal()]) {
            case VideoSize.CIF /*1*/:
                this.f6910a.f6908h.m9344a(c2189i.m9847k(), true);
            case VideoSize.HVGA /*2*/:
                this.f6910a.f6908h.m9345b(c2189i.m9847k());
            case Version.API03_CUPCAKE_15 /*3*/:
                this.f6910a.f6908h.m9344a(c2189i.m9847k(), true);
            case Version.API04_DONUT_16 /*4*/:
                this.f6910a.f6908h.m9344a(c2189i.m9847k(), true);
            default:
        }
    }
}
