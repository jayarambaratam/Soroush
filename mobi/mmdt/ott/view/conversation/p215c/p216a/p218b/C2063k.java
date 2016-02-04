package mobi.mmdt.ott.view.conversation.p215c.p216a.p218b;

import android.view.View;
import android.view.View.OnClickListener;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p226b.C2167d;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.b.k */
class C2063k implements OnClickListener {
    final /* synthetic */ C2061i f6781a;

    C2063k(C2061i c2061i) {
        this.f6781a = c2061i;
    }

    public void onClick(View view) {
        C2167d c2167d = (C2167d) this.f6781a.m8619a();
        switch (C2064l.f6782a[c2167d.m9915r().ordinal()]) {
            case Version.API05_ECLAIR_20 /*5*/:
                this.f6781a.f6779h.m9343b(c2167d.m9912o(), c2167d.m9845i(), true);
            default:
        }
    }
}
