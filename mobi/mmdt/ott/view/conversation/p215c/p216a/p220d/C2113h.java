package mobi.mmdt.ott.view.conversation.p215c.p216a.p220d;

import android.view.View;
import android.view.View.OnClickListener;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p224d.C2183c;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.d.h */
class C2113h implements OnClickListener {
    final /* synthetic */ C2111f f6931a;

    C2113h(C2111f c2111f) {
        this.f6931a = c2111f;
    }

    public void onClick(View view) {
        C2183c c2183c = (C2183c) this.f6931a.m8619a();
        switch (C2114i.f6932a[c2183c.m9993r().ordinal()]) {
            case Version.API05_ECLAIR_20 /*5*/:
                this.f6931a.f6929h.m9343b(c2183c.m9990o(), c2183c.m9845i(), true);
            default:
        }
    }
}
