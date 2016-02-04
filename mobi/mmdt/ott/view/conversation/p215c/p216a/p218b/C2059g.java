package mobi.mmdt.ott.view.conversation.p215c.p216a.p218b;

import android.view.View;
import android.view.View.OnClickListener;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p226b.C2166c;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.b.g */
class C2059g implements OnClickListener {
    final /* synthetic */ C2057e f6771a;

    C2059g(C2057e c2057e) {
        this.f6771a = c2057e;
    }

    public void onClick(View view) {
        C2166c c2166c = (C2166c) this.f6771a.m8619a();
        switch (C2060h.f6772a[c2166c.m9909r().ordinal()]) {
            case Version.API05_ECLAIR_20 /*5*/:
                this.f6771a.f6769h.m9343b(c2166c.m9906o(), c2166c.m9845i(), true);
            default:
        }
    }
}
