package mobi.mmdt.ott.view.channel;

import android.support.design.widget.Snackbar;

/* renamed from: mobi.mmdt.ott.view.channel.o */
class C1739o implements Runnable {
    final /* synthetic */ C1737m f5716a;

    C1739o(C1737m c1737m) {
        this.f5716a = c1737m;
    }

    public void run() {
        Snackbar a = Snackbar.m377a(this.f5716a.f5714a.i, this.f5716a.f5714a.getString(2131230821), -2);
        a.m392a(2131230916, new C1740p(this));
        a.m395a();
    }
}
