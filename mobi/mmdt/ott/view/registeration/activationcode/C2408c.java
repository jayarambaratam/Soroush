package mobi.mmdt.ott.view.registeration.activationcode;

import android.content.Intent;
import mobi.mmdt.ott.view.registeration.phoneandcountry.PhoneAndCountryActivity;

/* renamed from: mobi.mmdt.ott.view.registeration.activationcode.c */
class C2408c implements Runnable {
    final /* synthetic */ ActivationCodeActivity f7906a;

    C2408c(ActivationCodeActivity activationCodeActivity) {
        this.f7906a = activationCodeActivity;
    }

    public void run() {
        Intent intent = new Intent(this.f7906a.getApplicationContext(), PhoneAndCountryActivity.class);
        intent.putExtra("KEY_COUNTRY_NAME", this.f7906a.f7880i);
        intent.putExtra("KEY_COUNTRY_CODE", this.f7906a.f7881j);
        intent.putExtra("KEY_PHONE_NUMBER", this.f7906a.f7882k);
        this.f7906a.startActivity(intent);
        this.f7906a.finish();
        this.f7906a.overridePendingTransition(2131034126, 2131034130);
    }
}
