package mobi.mmdt.ott.view.conversation.groupinfo;

import android.os.Handler;
import mobi.mmdt.componentsutils.view.p085a.C1123a;

/* renamed from: mobi.mmdt.ott.view.conversation.groupinfo.w */
class C2272w implements Runnable {
    final /* synthetic */ GroupInfoActivity f7499a;

    C2272w(GroupInfoActivity groupInfoActivity) {
        this.f7499a = groupInfoActivity;
    }

    public void run() {
        C1123a.m6432a(this.f7499a.m8494q()).m6437a();
        new Handler().postDelayed(new C2273x(this), 150);
    }
}
