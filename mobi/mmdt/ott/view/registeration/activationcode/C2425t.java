package mobi.mmdt.ott.view.registeration.activationcode;

import android.content.Intent;
import mobi.mmdt.ott.view.registeration.profileinfo.ProfileInfoActivity;

/* renamed from: mobi.mmdt.ott.view.registeration.activationcode.t */
class C2425t implements Runnable {
    final /* synthetic */ C2423r f7924a;

    C2425t(C2423r c2423r) {
        this.f7924a = c2423r;
    }

    public void run() {
        this.f7924a.f7922a.startActivity(new Intent(this.f7924a.f7922a.getApplicationContext(), ProfileInfoActivity.class));
        this.f7924a.f7922a.finish();
        this.f7924a.f7922a.overridePendingTransition(2131034125, 2131034129);
    }
}
