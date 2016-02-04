package mobi.mmdt.ott.view.conversation.activities;

import android.support.design.widget.Snackbar;

class bd implements Runnable {
    final /* synthetic */ bb f6443a;

    bd(bb bbVar) {
        this.f6443a = bbVar;
    }

    public void run() {
        Snackbar a = Snackbar.m377a(this.f6443a.f6441a.k, this.f6443a.f6441a.getString(2131230821), -2);
        a.m392a(2131230916, new be(this));
        a.m395a();
    }
}
