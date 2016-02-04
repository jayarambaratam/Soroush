package mobi.mmdt.ott.view.conversation.p215c.p216a.p220d;

import android.view.View;
import android.view.View.OnClickListener;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p224d.C2188h;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.d.aa */
class aa implements OnClickListener {
    final /* synthetic */ C2130y f6900a;

    aa(C2130y c2130y) {
        this.f6900a = c2130y;
    }

    public void onClick(View view) {
        C2188h c2188h = (C2188h) this.f6900a.m8619a();
        switch (ab.f6901a[c2188h.m10020s().ordinal()]) {
            case Version.API05_ECLAIR_20 /*5*/:
                this.f6900a.f6972j.m9341a(c2188h.m10016o(), c2188h.m9845i(), true);
            default:
        }
    }
}
