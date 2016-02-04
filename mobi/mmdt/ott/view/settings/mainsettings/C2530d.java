package mobi.mmdt.ott.view.settings.mainsettings;

import android.content.Intent;
import mobi.mmdt.ott.view.settings.mainsettings.messages.MessagesSettingsListActivity;

/* renamed from: mobi.mmdt.ott.view.settings.mainsettings.d */
class C2530d implements Runnable {
    final /* synthetic */ MainSettingsListActivity f8150a;

    C2530d(MainSettingsListActivity mainSettingsListActivity) {
        this.f8150a = mainSettingsListActivity;
    }

    public void run() {
        this.f8150a.startActivity(new Intent(this.f8150a.getApplicationContext(), MessagesSettingsListActivity.class));
        this.f8150a.overridePendingTransition(2131034125, 2131034129);
    }
}
