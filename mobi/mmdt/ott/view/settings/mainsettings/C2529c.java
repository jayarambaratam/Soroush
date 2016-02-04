package mobi.mmdt.ott.view.settings.mainsettings;

import android.content.Intent;
import mobi.mmdt.ott.view.settings.mainsettings.notifications.NotificationsSettingsListActivity;

/* renamed from: mobi.mmdt.ott.view.settings.mainsettings.c */
class C2529c implements Runnable {
    final /* synthetic */ MainSettingsListActivity f8149a;

    C2529c(MainSettingsListActivity mainSettingsListActivity) {
        this.f8149a = mainSettingsListActivity;
    }

    public void run() {
        this.f8149a.startActivity(new Intent(this.f8149a.getApplicationContext(), NotificationsSettingsListActivity.class));
        this.f8149a.overridePendingTransition(2131034125, 2131034129);
    }
}
