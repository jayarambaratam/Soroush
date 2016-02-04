package mobi.mmdt.ott.view.channel;

import android.support.design.widget.Snackbar;

/* renamed from: mobi.mmdt.ott.view.channel.u */
class C1745u implements Runnable {
    final /* synthetic */ C1744t f5723a;

    C1745u(C1744t c1744t) {
        this.f5723a = c1744t;
    }

    public void run() {
        Snackbar a = Snackbar.m377a(this.f5723a.f5722a.f5644i, this.f5723a.f5722a.getString(2131230821), -2);
        a.m392a(2131230916, new C1746v(this));
        a.m395a();
    }
}
