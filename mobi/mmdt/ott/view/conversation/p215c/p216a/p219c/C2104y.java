package mobi.mmdt.ott.view.conversation.p215c.p216a.p219c;

import android.view.View;
import android.view.View.OnClickListener;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p227c.C2180h;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.c.y */
class C2104y implements OnClickListener {
    final /* synthetic */ C2103x f6895a;

    C2104y(C2103x c2103x) {
        this.f6895a = c2103x;
    }

    public void onClick(View view) {
        C2180h c2180h = (C2180h) this.f6895a.m8619a();
        switch (aa.f6816a[c2180h.m9976s().ordinal()]) {
            case VideoSize.CIF /*1*/:
                this.f6895a.f6893j.m9344a(c2180h.m9847k(), false);
            case VideoSize.HVGA /*2*/:
                this.f6895a.f6893j.m9345b(c2180h.m9847k());
            case Version.API03_CUPCAKE_15 /*3*/:
                this.f6895a.f6893j.m9344a(c2180h.m9847k(), false);
            case Version.API04_DONUT_16 /*4*/:
                this.f6895a.f6893j.m9344a(c2180h.m9847k(), false);
            default:
        }
    }
}
