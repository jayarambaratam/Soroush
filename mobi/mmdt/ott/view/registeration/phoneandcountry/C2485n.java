package mobi.mmdt.ott.view.registeration.phoneandcountry;

import android.support.design.widget.Snackbar;

/* renamed from: mobi.mmdt.ott.view.registeration.phoneandcountry.n */
class C2485n implements Runnable {
    final /* synthetic */ C2483l f8064a;

    C2485n(C2483l c2483l) {
        this.f8064a = c2483l;
    }

    public void run() {
        Snackbar a = Snackbar.m377a(this.f8064a.f8062a.f7955j, this.f8064a.f8062a.getString(2131230821), -2);
        a.m392a(2131230916, new C2486o(this));
        a.m395a();
    }
}
