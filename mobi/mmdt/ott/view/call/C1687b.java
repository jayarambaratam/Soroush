package mobi.mmdt.ott.view.call;

import android.view.animation.AccelerateDecelerateInterpolator;
import mobi.mmdt.ott.view.components.p184a.C1753a;
import mobi.mmdt.ott.view.components.p184a.p191g.C1774d;

/* renamed from: mobi.mmdt.ott.view.call.b */
class C1687b implements Runnable {
    final /* synthetic */ CallActivity f5579a;

    C1687b(CallActivity callActivity) {
        this.f5579a = callActivity;
    }

    public void run() {
        this.f5579a.f5565l.setVisibility(0);
        C1753a.m8688a(new C1774d()).m8701a(250).m8702a(new AccelerateDecelerateInterpolator()).m8704a(this.f5579a.f5565l);
    }
}
