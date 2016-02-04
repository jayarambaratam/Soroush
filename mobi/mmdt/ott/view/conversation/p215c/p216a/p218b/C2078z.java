package mobi.mmdt.ott.view.conversation.p215c.p216a.p218b;

import android.view.View;
import android.view.View.OnClickListener;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p226b.C2171h;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.b.z */
class C2078z implements OnClickListener {
    final /* synthetic */ C2076x f6814a;

    C2078z(C2076x c2076x) {
        this.f6814a = c2076x;
    }

    public void onClick(View view) {
        C2171h c2171h = (C2171h) this.f6814a.m8619a();
        switch (aa.f6742a[c2171h.m9936s().ordinal()]) {
            case Version.API05_ECLAIR_20 /*5*/:
                this.f6814a.f6812j.m9341a(c2171h.m9932o(), c2171h.m9845i(), true);
            default:
        }
    }
}
