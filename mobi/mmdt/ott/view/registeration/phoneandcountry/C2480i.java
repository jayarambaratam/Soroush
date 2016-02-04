package mobi.mmdt.ott.view.registeration.phoneandcountry;

import android.support.design.widget.Snackbar;

/* renamed from: mobi.mmdt.ott.view.registeration.phoneandcountry.i */
class C2480i implements Runnable {
    final /* synthetic */ C2478g f8057a;

    C2480i(C2478g c2478g) {
        this.f8057a = c2478g;
    }

    public void run() {
        Snackbar a = Snackbar.m377a(this.f8057a.f8055a.f7955j, this.f8057a.f8055a.getString(2131230821), -2);
        a.m392a(2131230916, new C2481j(this));
        a.m395a();
    }
}
