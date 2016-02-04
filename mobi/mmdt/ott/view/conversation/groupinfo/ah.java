package mobi.mmdt.ott.view.conversation.groupinfo;

import android.support.design.widget.Snackbar;

class ah implements Runnable {
    final /* synthetic */ ag f7434a;

    ah(ag agVar) {
        this.f7434a = agVar;
    }

    public void run() {
        Snackbar a = Snackbar.m377a(this.f7434a.f7433a.i, this.f7434a.f7433a.getString(2131230821), -2);
        a.m392a(2131230916, new ai(this));
        a.m395a();
    }
}
