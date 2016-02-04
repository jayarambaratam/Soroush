package mobi.mmdt.ott.view.conversation.groupinfo;

import android.support.design.widget.Snackbar;
import mobi.mmdt.componentsutils.view.p085a.C1123a;

class ak implements Runnable {
    final /* synthetic */ GroupInfoActivity f7437a;

    ak(GroupInfoActivity groupInfoActivity) {
        this.f7437a = groupInfoActivity;
    }

    public void run() {
        C1123a.m6432a(this.f7437a.m8494q()).m6437a();
        Snackbar a = Snackbar.m377a(this.f7437a.i, this.f7437a.getString(2131230821), -2);
        a.m392a(2131230916, new al(this));
        a.m395a();
    }
}
