package mobi.mmdt.ott.view.registeration.profileinfo;

import android.support.design.widget.Snackbar;

/* renamed from: mobi.mmdt.ott.view.registeration.profileinfo.l */
class C2499l implements Runnable {
    final /* synthetic */ C2497j f8093a;

    C2499l(C2497j c2497j) {
        this.f8093a = c2497j;
    }

    public void run() {
        Snackbar a = Snackbar.m377a(this.f8093a.f8091a.i, this.f8093a.f8091a.getString(2131230821), -2);
        a.m392a(2131230916, new C2500m(this));
        a.m395a();
    }
}
