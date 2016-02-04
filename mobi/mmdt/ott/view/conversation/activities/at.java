package mobi.mmdt.ott.view.conversation.activities;

import android.support.design.widget.Snackbar;

class at implements Runnable {
    final /* synthetic */ ar f6432a;

    at(ar arVar) {
        this.f6432a = arVar;
    }

    public void run() {
        Snackbar a = Snackbar.m377a(this.f6432a.f6430b.k, this.f6432a.f6430b.getString(2131230821), -2);
        a.m392a(2131230916, new au(this));
        a.m395a();
    }
}
