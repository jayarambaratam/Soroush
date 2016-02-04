package mobi.mmdt.ott.view.conversation.groupinfo;

import mobi.mmdt.ott.provider.p169c.C1583c;

/* renamed from: mobi.mmdt.ott.view.conversation.groupinfo.y */
class C2274y implements Runnable {
    final /* synthetic */ GroupInfoActivity f7501a;

    C2274y(GroupInfoActivity groupInfoActivity) {
        this.f7501a = groupInfoActivity;
    }

    public void run() {
        Thread.currentThread().setPriority(1);
        this.f7501a.runOnUiThread(new C2275z(this, C1583c.m8002m(this.f7501a.getApplicationContext(), this.f7501a.f7414y)));
    }
}
