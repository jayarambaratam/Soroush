package mobi.mmdt.ott.view.conversation.p215c.p216a.p217a;

import android.view.View;
import android.view.View.OnClickListener;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p225a.C2157d;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.a.o */
class C2041o implements OnClickListener {
    final /* synthetic */ C2039m f6712a;

    C2041o(C2039m c2039m) {
        this.f6712a = c2039m;
    }

    public void onClick(View view) {
        C2157d c2157d = (C2157d) this.f6712a.m8619a();
        switch (C2042p.f6713a[c2157d.m9869t().ordinal()]) {
            case Version.API05_ECLAIR_20 /*5*/:
                this.f6712a.f6710i.m9343b(c2157d.m9866q(), c2157d.m9845i(), true);
            default:
        }
    }
}
