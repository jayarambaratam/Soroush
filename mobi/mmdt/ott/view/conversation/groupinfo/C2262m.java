package mobi.mmdt.ott.view.conversation.groupinfo;

import com.p065c.p066a.p067a.C0950c;
import mobi.mmdt.ott.logic.C1494c;
import mobi.mmdt.ott.logic.p112a.p128e.p132b.p134b.C1420d;

/* renamed from: mobi.mmdt.ott.view.conversation.groupinfo.m */
class C2262m implements Runnable {
    final /* synthetic */ GroupInfoActivity f7478a;

    C2262m(GroupInfoActivity groupInfoActivity) {
        this.f7478a = groupInfoActivity;
    }

    public void run() {
        C0950c c1420d = new C1420d(this.f7478a.getApplicationContext(), this.f7478a.f7414y);
        r0.f7394D = this.f7478a;
        C1494c.m7540b(c1420d);
    }
}
