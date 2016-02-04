package mobi.mmdt.ott.view.conversation.groupinfo;

import com.p065c.p066a.p067a.C0950c;
import mobi.mmdt.ott.logic.C1494c;
import mobi.mmdt.ott.logic.p112a.p128e.p129a.p131b.C1410h;

/* renamed from: mobi.mmdt.ott.view.conversation.groupinfo.l */
class C2261l implements Runnable {
    final /* synthetic */ GroupInfoActivity f7477a;

    C2261l(GroupInfoActivity groupInfoActivity) {
        this.f7477a = groupInfoActivity;
    }

    public void run() {
        C0950c c1410h = new C1410h(this.f7477a.getApplicationContext(), this.f7477a.f7414y, this.f7477a.f7395E);
        this.f7477a.f7394D = this.f7478a;
        C1494c.m7540b(c1410h);
    }
}
