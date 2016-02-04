package mobi.mmdt.ott.view.conversation.p215c.p216a.p217a;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p225a.C2158e;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.a.ad */
class ad implements OnFocusChangeListener {
    final /* synthetic */ C2158e f6623a;
    final /* synthetic */ C2043q f6624b;

    ad(C2043q c2043q, C2158e c2158e) {
        this.f6624b = c2043q;
        this.f6623a = c2158e;
    }

    public void onFocusChange(View view, boolean z) {
        if (z) {
            this.f6624b.c.m9335a(this.f6623a.m8660h());
        }
    }
}
