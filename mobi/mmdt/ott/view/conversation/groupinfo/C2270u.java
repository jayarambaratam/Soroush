package mobi.mmdt.ott.view.conversation.groupinfo;

import android.os.Handler;
import mobi.mmdt.componentsutils.view.p085a.C1123a;

/* renamed from: mobi.mmdt.ott.view.conversation.groupinfo.u */
class C2270u implements Runnable {
    final /* synthetic */ GroupInfoActivity f7497a;

    C2270u(GroupInfoActivity groupInfoActivity) {
        this.f7497a = groupInfoActivity;
    }

    public void run() {
        C1123a.m6432a(this.f7497a.m8494q()).m6437a();
        new Handler().postDelayed(new C2271v(this), 150);
    }
}
