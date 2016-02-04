package mobi.mmdt.ott.view.registeration.phoneandcountry;

import mobi.mmdt.ott.logic.C1494c;
import mobi.mmdt.ott.logic.p112a.p137g.p141b.p143b.C1438b;

/* renamed from: mobi.mmdt.ott.view.registeration.phoneandcountry.c */
class C2450c implements Runnable {
    final /* synthetic */ PhoneAndCountryActivity f7969a;

    C2450c(PhoneAndCountryActivity phoneAndCountryActivity) {
        this.f7969a = phoneAndCountryActivity;
    }

    public void run() {
        C1494c.m7539a(new C1438b(this.f7969a.getApplicationContext(), this.f7969a.f7954i.m10669b().substring(1), this.f7969a.f7954i.m10671d()));
    }
}
