package mobi.mmdt.ott.view.conversation.activities;

import android.support.design.widget.Snackbar;

class ap implements Runnable {
    final /* synthetic */ an f6427a;

    ap(an anVar) {
        this.f6427a = anVar;
    }

    public void run() {
        Snackbar a = Snackbar.m377a(this.f6427a.f6425a.k, this.f6427a.f6425a.getString(2131230821), -2);
        a.m392a(2131230916, new aq(this));
        a.m395a();
    }
}
