package mobi.mmdt.ott.view.conversation.p215c.p216a.p220d;

import android.view.View;
import android.view.View.OnClickListener;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p224d.C2184d;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.d.k */
class C2116k implements OnClickListener {
    final /* synthetic */ C2115j f6940a;

    C2116k(C2115j c2115j) {
        this.f6940a = c2115j;
    }

    public void onClick(View view) {
        C2184d c2184d = (C2184d) this.f6940a.m8619a();
        switch (C2118m.f6942a[c2184d.m9999r().ordinal()]) {
            case VideoSize.CIF /*1*/:
                this.f6940a.f6938g.m9344a(c2184d.m9847k(), true);
            case VideoSize.HVGA /*2*/:
                this.f6940a.f6938g.m9345b(c2184d.m9847k());
            case Version.API03_CUPCAKE_15 /*3*/:
                this.f6940a.f6938g.m9344a(c2184d.m9847k(), true);
            case Version.API04_DONUT_16 /*4*/:
                this.f6940a.f6938g.m9344a(c2184d.m9847k(), true);
            default:
        }
    }
}
