package mobi.mmdt.ott.view.conversation.activities;

import android.support.design.widget.Snackbar;

class ct implements Runnable {
    final /* synthetic */ cr f6497a;

    ct(cr crVar) {
        this.f6497a = crVar;
    }

    public void run() {
        Snackbar a = Snackbar.m377a(this.f6497a.f6495a.k, this.f6497a.f6495a.getString(2131230821), -2);
        a.m392a(2131230916, new cu(this));
        a.m395a();
    }
}
