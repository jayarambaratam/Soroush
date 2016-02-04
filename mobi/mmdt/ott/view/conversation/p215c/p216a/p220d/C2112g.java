package mobi.mmdt.ott.view.conversation.p215c.p216a.p220d;

import android.view.View;
import android.view.View.OnClickListener;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p224d.C2183c;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.d.g */
class C2112g implements OnClickListener {
    final /* synthetic */ C2111f f6930a;

    C2112g(C2111f c2111f) {
        this.f6930a = c2111f;
    }

    public void onClick(View view) {
        C2183c c2183c = (C2183c) this.f6930a.m8619a();
        switch (C2114i.f6932a[c2183c.m9993r().ordinal()]) {
            case VideoSize.CIF /*1*/:
                this.f6930a.f6928g.m9344a(c2183c.m9847k(), true);
            case VideoSize.HVGA /*2*/:
                this.f6930a.f6928g.m9345b(c2183c.m9847k());
            case Version.API03_CUPCAKE_15 /*3*/:
                this.f6930a.f6928g.m9344a(c2183c.m9847k(), true);
            case Version.API04_DONUT_16 /*4*/:
                this.f6930a.f6928g.m9344a(c2183c.m9847k(), true);
            default:
        }
    }
}
