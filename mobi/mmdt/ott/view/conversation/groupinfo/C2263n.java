package mobi.mmdt.ott.view.conversation.groupinfo;

import com.p065c.p066a.p067a.C0950c;
import mobi.mmdt.ott.logic.C1494c;
import mobi.mmdt.ott.logic.p112a.p128e.p129a.p131b.C1406d;

/* renamed from: mobi.mmdt.ott.view.conversation.groupinfo.n */
class C2263n implements Runnable {
    final /* synthetic */ String f7479a;
    final /* synthetic */ String f7480b;
    final /* synthetic */ GroupInfoActivity f7481c;

    C2263n(GroupInfoActivity groupInfoActivity, String str, String str2) {
        this.f7481c = groupInfoActivity;
        this.f7479a = str;
        this.f7480b = str2;
    }

    public void run() {
        C0950c c1406d = new C1406d(this.f7481c.getApplicationContext(), this.f7481c.f7414y, this.f7479a, this.f7480b, this.f7481c.n, this.f7481c.m);
        this.f7481c.f7394D = this.f7481c;
        C1494c.m7540b(c1406d);
    }
}
