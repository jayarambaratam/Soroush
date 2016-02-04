package mobi.mmdt.ott.view.settings.mainsettings.profile_info.deactivate_account;

import android.os.Handler;

/* renamed from: mobi.mmdt.ott.view.settings.mainsettings.profile_info.deactivate_account.a */
class C2552a implements Runnable {
    final /* synthetic */ DeactivateAccountActivity f8190a;

    C2552a(DeactivateAccountActivity deactivateAccountActivity) {
        this.f8190a = deactivateAccountActivity;
    }

    public void run() {
        new Handler().postDelayed(new C2553b(this), 50);
        new Handler().postDelayed(new C2554c(this), 100);
    }
}
