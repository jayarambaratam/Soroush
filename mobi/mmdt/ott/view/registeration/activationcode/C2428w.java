package mobi.mmdt.ott.view.registeration.activationcode;

import android.support.design.widget.Snackbar;
import mobi.mmdt.ott.logic.C1486a;

/* renamed from: mobi.mmdt.ott.view.registeration.activationcode.w */
class C2428w implements Runnable {
    final /* synthetic */ C2426u f7928a;

    C2428w(C2426u c2426u) {
        this.f7928a = c2426u;
    }

    public void run() {
        if (this.f7928a.f7925a.m6997d() == C1486a.NOT_AUTHORIZED) {
            Snackbar.m377a(this.f7928a.f7926b.f7884m, this.f7928a.f7926b.getString(2131230869), 0).m395a();
            return;
        }
        Snackbar a = Snackbar.m377a(this.f7928a.f7926b.f7884m, this.f7928a.f7926b.getString(2131230821), -2);
        a.m392a(2131230916, new C2429x(this));
        a.m395a();
    }
}
