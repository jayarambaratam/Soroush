package mobi.mmdt.ott.view.settings.mainsettings;

import android.content.Intent;
import mobi.mmdt.ott.view.settings.mainsettings.privacy.PrivacySettingsListActivity;

/* renamed from: mobi.mmdt.ott.view.settings.mainsettings.e */
class C2531e implements Runnable {
    final /* synthetic */ MainSettingsListActivity f8151a;

    C2531e(MainSettingsListActivity mainSettingsListActivity) {
        this.f8151a = mainSettingsListActivity;
    }

    public void run() {
        this.f8151a.startActivity(new Intent(this.f8151a.getApplicationContext(), PrivacySettingsListActivity.class));
        this.f8151a.overridePendingTransition(2131034125, 2131034129);
    }
}
