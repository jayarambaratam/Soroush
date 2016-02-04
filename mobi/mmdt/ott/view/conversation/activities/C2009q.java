package mobi.mmdt.ott.view.conversation.activities;

import android.view.animation.AccelerateDecelerateInterpolator;
import mobi.mmdt.ott.view.components.p184a.C1753a;
import mobi.mmdt.ott.view.components.p184a.p191g.C1775e;

/* renamed from: mobi.mmdt.ott.view.conversation.activities.q */
class C2009q implements Runnable {
    final /* synthetic */ C1992a f6548a;

    C2009q(C1992a c1992a) {
        this.f6548a = c1992a;
    }

    public void run() {
        C1753a.m8688a(new C1775e()).m8701a(500).m8702a(new AccelerateDecelerateInterpolator()).m8704a(this.f6548a.f6347E);
    }
}
