package mobi.mmdt.ott.view.main;

import android.support.design.widget.Snackbar;

class aa implements Runnable {
    final /* synthetic */ C2404y f7586a;

    aa(C2404y c2404y) {
        this.f7586a = c2404y;
    }

    public void run() {
        Snackbar a = Snackbar.m377a(this.f7586a.f7878a.i, this.f7586a.f7878a.getString(2131230821), -2);
        a.m392a(2131230916, new ab(this));
        a.m395a();
    }
}
