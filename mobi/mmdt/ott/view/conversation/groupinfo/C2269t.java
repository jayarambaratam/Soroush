package mobi.mmdt.ott.view.conversation.groupinfo;

import com.p065c.p066a.p067a.C0950c;
import mobi.mmdt.ott.logic.C1494c;
import mobi.mmdt.ott.logic.p112a.p128e.p132b.p134b.C1419c;
import mobi.mmdt.ott.provider.p172f.C1619f;

/* renamed from: mobi.mmdt.ott.view.conversation.groupinfo.t */
class C2269t implements Runnable {
    final /* synthetic */ String f7493a;
    final /* synthetic */ C1619f f7494b;
    final /* synthetic */ C1619f f7495c;
    final /* synthetic */ GroupInfoActivity f7496d;

    C2269t(GroupInfoActivity groupInfoActivity, String str, C1619f c1619f, C1619f c1619f2) {
        this.f7496d = groupInfoActivity;
        this.f7493a = str;
        this.f7494b = c1619f;
        this.f7495c = c1619f2;
    }

    public void run() {
        C0950c c1419c = new C1419c(this.f7496d.getApplicationContext(), this.f7496d.f7414y, new String[]{this.f7493a}, new C1619f[]{this.f7494b}, new C1619f[]{this.f7495c});
        this.f7496d.f7394D = this.f7496d;
        C1494c.m7540b(c1419c);
    }
}
