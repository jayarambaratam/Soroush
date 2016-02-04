package mobi.mmdt.ott.view.conversation.groupinfo;

import android.support.design.widget.Snackbar;
import mobi.mmdt.componentsutils.view.p085a.C1123a;
import mobi.mmdt.ott.logic.C1486a;
import mobi.mmdt.ott.logic.p112a.p128e.p132b.p133a.C1414c;
import org.linphone.core.VideoSize;

class ac implements Runnable {
    final /* synthetic */ C1414c f7427a;
    final /* synthetic */ GroupInfoActivity f7428b;

    ac(GroupInfoActivity groupInfoActivity, C1414c c1414c) {
        this.f7428b = groupInfoActivity;
        this.f7427a = c1414c;
    }

    public void run() {
        CharSequence string = this.f7428b.getString(2131230821);
        switch (am.f7439a[this.f7427a.m6997d().ordinal()]) {
            case VideoSize.CIF /*1*/:
                string = this.f7428b.getString(2131230962);
                break;
        }
        C1123a.m6432a(this.f7428b.m8494q()).m6437a();
        Snackbar a = Snackbar.m377a(this.f7428b.i, string, -2);
        if (!this.f7427a.m6997d().equals(C1486a.USER_NOT_HAVE_PERMISSION)) {
            a.m392a(2131230916, new ad(this));
        }
        a.m395a();
    }
}
