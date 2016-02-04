package mobi.mmdt.ott.view.conversation.p215c.p216a.p217a;

import android.os.Handler;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.EditText;
import mobi.mmdt.ott.view.components.p184a.C1753a;
import mobi.mmdt.ott.view.components.p184a.p192h.p193a.C1777a;
import mobi.mmdt.ott.view.components.p184a.p192h.p194b.C1778a;
import mobi.mmdt.ott.view.conversation.p213a.C1982b;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p225a.C2158e;
import net.frakbot.glowpadbackport.BuildConfig;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.a.z */
class C2052z implements C1982b {
    final /* synthetic */ C2158e f6739a;
    final /* synthetic */ EditText f6740b;
    final /* synthetic */ C2043q f6741c;

    C2052z(C2043q c2043q, C2158e c2158e, EditText editText) {
        this.f6741c = c2043q;
        this.f6739a = c2158e;
        this.f6740b = editText;
    }

    public void m9701a(String str, boolean z, boolean z2) {
        if (z) {
            if (!str.equals(this.f6739a.m9844f())) {
                return;
            }
            if (!z2 || this.f6740b == null) {
                C1753a.m8688a(new C1778a()).m8701a(500).m8702a(new AccelerateDecelerateInterpolator()).m8704a(this.f6740b);
                new Handler().postDelayed(new aa(this), 500);
                return;
            }
            this.f6740b.setVisibility(0);
            C1753a.m8688a(new C1777a()).m8701a(500).m8702a(new AccelerateDecelerateInterpolator()).m8704a(this.f6740b);
        } else if (this.f6740b != null) {
            this.f6740b.setText(BuildConfig.FLAVOR);
        }
    }
}
