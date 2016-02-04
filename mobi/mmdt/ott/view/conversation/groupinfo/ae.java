package mobi.mmdt.ott.view.conversation.groupinfo;

import android.support.design.widget.Snackbar;
import mobi.mmdt.componentsutils.view.p085a.C1123a;
import mobi.mmdt.ott.logic.p112a.p128e.p132b.p133a.C1412a;

class ae implements Runnable {
    final /* synthetic */ C1412a f7430a;
    final /* synthetic */ GroupInfoActivity f7431b;

    ae(GroupInfoActivity groupInfoActivity, C1412a c1412a) {
        this.f7431b = groupInfoActivity;
        this.f7430a = c1412a;
    }

    public void run() {
        C1123a.m6432a(this.f7431b.m8494q()).m6437a();
        Snackbar a = Snackbar.m377a(this.f7431b.i, this.f7431b.getString(2131230821), -2);
        a.m392a(2131230916, new af(this));
        a.m395a();
    }
}
