package mobi.mmdt.ott.view.registeration.phoneandcountry;

import android.os.Handler;

/* renamed from: mobi.mmdt.ott.view.registeration.phoneandcountry.d */
class C2475d implements Runnable {
    final /* synthetic */ PhoneAndCountryActivity f8052a;

    C2475d(PhoneAndCountryActivity phoneAndCountryActivity) {
        this.f8052a = phoneAndCountryActivity;
    }

    public void run() {
        new Handler().postDelayed(new C2476e(this), 50);
        new Handler().postDelayed(new C2477f(this), 100);
    }
}
