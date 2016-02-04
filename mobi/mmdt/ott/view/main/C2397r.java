package mobi.mmdt.ott.view.main;

import android.view.animation.AccelerateDecelerateInterpolator;
import mobi.mmdt.ott.view.components.p184a.C1753a;
import mobi.mmdt.ott.view.components.p184a.p185a.C1752a;

/* renamed from: mobi.mmdt.ott.view.main.r */
class C2397r implements Runnable {
    final /* synthetic */ NewGroupActivity f7864a;

    C2397r(NewGroupActivity newGroupActivity) {
        this.f7864a = newGroupActivity;
    }

    public void run() {
        C1753a.m8688a(new C1752a()).m8701a(750).m8702a(new AccelerateDecelerateInterpolator()).m8704a(this.f7864a.f7561o);
    }
}
