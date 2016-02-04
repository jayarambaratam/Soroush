package mobi.mmdt.ott.view.settings.mainsettings;

import android.content.Intent;
import mobi.mmdt.ott.view.settings.mainsettings.network.NetworkSettingsListActivity;

/* renamed from: mobi.mmdt.ott.view.settings.mainsettings.f */
class C2532f implements Runnable {
    final /* synthetic */ MainSettingsListActivity f8152a;

    C2532f(MainSettingsListActivity mainSettingsListActivity) {
        this.f8152a = mainSettingsListActivity;
    }

    public void run() {
        this.f8152a.startActivity(new Intent(this.f8152a.getApplicationContext(), NetworkSettingsListActivity.class));
        this.f8152a.overridePendingTransition(2131034125, 2131034129);
    }
}
