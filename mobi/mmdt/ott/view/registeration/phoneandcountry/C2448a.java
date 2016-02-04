package mobi.mmdt.ott.view.registeration.phoneandcountry;

import android.content.Intent;
import mobi.mmdt.ott.view.registeration.phoneandcountry.countryselection.CountrySelectionActivity;

/* renamed from: mobi.mmdt.ott.view.registeration.phoneandcountry.a */
class C2448a implements Runnable {
    final /* synthetic */ PhoneAndCountryActivity f7967a;

    C2448a(PhoneAndCountryActivity phoneAndCountryActivity) {
        this.f7967a = phoneAndCountryActivity;
    }

    public void run() {
        this.f7967a.startActivityForResult(new Intent(this.f7967a.getApplicationContext(), CountrySelectionActivity.class), 114);
        this.f7967a.overridePendingTransition(2131034125, 2131034129);
    }
}
