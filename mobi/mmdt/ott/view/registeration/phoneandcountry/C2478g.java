package mobi.mmdt.ott.view.registeration.phoneandcountry;

import android.os.Handler;

/* renamed from: mobi.mmdt.ott.view.registeration.phoneandcountry.g */
class C2478g implements Runnable {
    final /* synthetic */ PhoneAndCountryActivity f8055a;

    C2478g(PhoneAndCountryActivity phoneAndCountryActivity) {
        this.f8055a = phoneAndCountryActivity;
    }

    public void run() {
        new Handler().postDelayed(new C2479h(this), 50);
        new Handler().postDelayed(new C2480i(this), 100);
    }
}
