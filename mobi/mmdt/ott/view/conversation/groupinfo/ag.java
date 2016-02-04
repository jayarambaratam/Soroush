package mobi.mmdt.ott.view.conversation.groupinfo;

import android.os.Handler;
import mobi.mmdt.componentsutils.view.p085a.C1123a;

class ag implements Runnable {
    final /* synthetic */ GroupInfoActivity f7433a;

    ag(GroupInfoActivity groupInfoActivity) {
        this.f7433a = groupInfoActivity;
    }

    public void run() {
        C1123a.m6432a(this.f7433a.m8494q()).m6437a();
        new Handler().postDelayed(new ah(this), 100);
    }
}
