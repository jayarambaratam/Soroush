package mobi.mmdt.ott.view.conversation.groupinfo;

import android.view.animation.AccelerateDecelerateInterpolator;
import mobi.mmdt.ott.view.components.p184a.C1753a;
import mobi.mmdt.ott.view.components.p184a.p185a.C1752a;

/* renamed from: mobi.mmdt.ott.view.conversation.groupinfo.k */
class C2260k implements Runnable {
    final /* synthetic */ GroupInfoActivity f7476a;

    C2260k(GroupInfoActivity groupInfoActivity) {
        this.f7476a = groupInfoActivity;
    }

    public void run() {
        C1753a.m8688a(new C1752a()).m8701a(750).m8702a(new AccelerateDecelerateInterpolator()).m8704a(this.f7476a.f7406q);
    }
}
