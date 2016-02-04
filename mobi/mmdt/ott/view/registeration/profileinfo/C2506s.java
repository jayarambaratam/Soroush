package mobi.mmdt.ott.view.registeration.profileinfo;

import android.support.design.widget.Snackbar;

/* renamed from: mobi.mmdt.ott.view.registeration.profileinfo.s */
class C2506s implements Runnable {
    final /* synthetic */ C2504q f8100a;

    C2506s(C2504q c2504q) {
        this.f8100a = c2504q;
    }

    public void run() {
        Snackbar a = Snackbar.m377a(this.f8100a.f8098a.i, this.f8100a.f8098a.getString(2131230821), -2);
        a.m392a(2131230916, new C2507t(this));
        a.m395a();
    }
}
