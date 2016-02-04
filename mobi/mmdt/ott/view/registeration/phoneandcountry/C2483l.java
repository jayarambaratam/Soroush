package mobi.mmdt.ott.view.registeration.phoneandcountry;

import android.os.Handler;

/* renamed from: mobi.mmdt.ott.view.registeration.phoneandcountry.l */
class C2483l implements Runnable {
    final /* synthetic */ PhoneAndCountryActivity f8062a;

    C2483l(PhoneAndCountryActivity phoneAndCountryActivity) {
        this.f8062a = phoneAndCountryActivity;
    }

    public void run() {
        new Handler().postDelayed(new C2484m(this), 50);
        new Handler().postDelayed(new C2485n(this), 100);
    }
}
