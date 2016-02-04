package mobi.mmdt.ott.view.conversation.activities;

import android.view.animation.AccelerateDecelerateInterpolator;
import mobi.mmdt.ott.view.components.p184a.C1753a;
import mobi.mmdt.ott.view.components.p184a.p191g.C1774d;

/* renamed from: mobi.mmdt.ott.view.conversation.activities.m */
class C2005m implements Runnable {
    final /* synthetic */ C1992a f6544a;

    C2005m(C1992a c1992a) {
        this.f6544a = c1992a;
    }

    public void run() {
        C1753a.m8688a(new C1774d()).m8701a(500).m8702a(new AccelerateDecelerateInterpolator()).m8704a(this.f6544a.f6347E);
    }
}
