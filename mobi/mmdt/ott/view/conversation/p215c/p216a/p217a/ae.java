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

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.a.ae */
class ae implements C1982b {
    final /* synthetic */ C2158e f6625a;
    final /* synthetic */ EditText f6626b;
    final /* synthetic */ C2043q f6627c;

    ae(C2043q c2043q, C2158e c2158e, EditText editText) {
        this.f6627c = c2043q;
        this.f6625a = c2158e;
        this.f6626b = editText;
    }

    public void m9665a(String str, boolean z, boolean z2) {
        if (z) {
            if (!str.equals(this.f6625a.m9844f())) {
                return;
            }
            if (!z2 || this.f6626b == null) {
                C1753a.m8688a(new C1778a()).m8701a(500).m8702a(new AccelerateDecelerateInterpolator()).m8704a(this.f6626b);
                new Handler().postDelayed(new af(this), 500);
                return;
            }
            this.f6626b.setVisibility(0);
            C1753a.m8688a(new C1777a()).m8701a(500).m8702a(new AccelerateDecelerateInterpolator()).m8704a(this.f6626b);
        } else if (this.f6626b != null) {
            this.f6626b.setText(BuildConfig.FLAVOR);
        }
    }
}
