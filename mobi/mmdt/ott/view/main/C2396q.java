package mobi.mmdt.ott.view.main;

import android.content.Intent;
import mobi.mmdt.ott.view.settings.mainsettings.MainSettingsListActivity;

/* renamed from: mobi.mmdt.ott.view.main.q */
class C2396q implements Runnable {
    final /* synthetic */ MainActivity f7863a;

    C2396q(MainActivity mainActivity) {
        this.f7863a = mainActivity;
    }

    public void run() {
        this.f7863a.startActivity(new Intent(this.f7863a.getApplicationContext(), MainSettingsListActivity.class));
        this.f7863a.overridePendingTransition(2131034125, 2131034129);
    }
}
