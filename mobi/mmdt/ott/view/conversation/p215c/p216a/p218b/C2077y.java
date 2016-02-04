package mobi.mmdt.ott.view.conversation.p215c.p216a.p218b;

import android.view.View;
import android.view.View.OnClickListener;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p226b.C2171h;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.b.y */
class C2077y implements OnClickListener {
    final /* synthetic */ C2076x f6813a;

    C2077y(C2076x c2076x) {
        this.f6813a = c2076x;
    }

    public void onClick(View view) {
        C2171h c2171h = (C2171h) this.f6813a.m8619a();
        switch (aa.f6742a[c2171h.m9936s().ordinal()]) {
            case VideoSize.CIF /*1*/:
                this.f6813a.f6811i.m9344a(c2171h.m9847k(), true);
            case VideoSize.HVGA /*2*/:
                this.f6813a.f6811i.m9345b(c2171h.m9847k());
            case Version.API03_CUPCAKE_15 /*3*/:
                this.f6813a.f6811i.m9344a(c2171h.m9847k(), true);
            case Version.API04_DONUT_16 /*4*/:
                this.f6813a.f6811i.m9344a(c2171h.m9847k(), true);
            default:
        }
    }
}
