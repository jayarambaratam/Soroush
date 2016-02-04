package mobi.mmdt.ott.view.registeration.activationcode;

import android.support.design.widget.Snackbar;

/* renamed from: mobi.mmdt.ott.view.registeration.activationcode.p */
class C2421p implements Runnable {
    final /* synthetic */ C2419n f7920a;

    C2421p(C2419n c2419n) {
        this.f7920a = c2419n;
    }

    public void run() {
        Snackbar a = Snackbar.m377a(this.f7920a.f7918a.f7884m, this.f7920a.f7918a.getString(2131230821), -2);
        a.m392a(2131230916, new C2422q(this));
        a.m395a();
    }
}
