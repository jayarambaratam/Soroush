package mobi.mmdt.ott.view.registeration.phoneandcountry.countryselection;

import android.view.animation.AccelerateDecelerateInterpolator;
import mobi.mmdt.ott.view.components.p184a.C1753a;
import mobi.mmdt.ott.view.components.p184a.p195i.C1780a;

/* renamed from: mobi.mmdt.ott.view.registeration.phoneandcountry.countryselection.b */
class C2453b implements Runnable {
    final /* synthetic */ C2452a f7977a;

    C2453b(C2452a c2452a) {
        this.f7977a = c2452a;
    }

    public void run() {
        if (this.f7977a.f7973c.getAlpha() == 0.0f) {
            C1753a.m8688a(new C1780a()).m8701a(100).m8702a(new AccelerateDecelerateInterpolator()).m8704a(this.f7977a.f7973c);
        }
    }
}
