package mobi.mmdt.ott.view.main;

import android.content.Intent;
import mobi.mmdt.ott.view.about.AboutActivity;

/* renamed from: mobi.mmdt.ott.view.main.p */
class C2395p implements Runnable {
    final /* synthetic */ MainActivity f7862a;

    C2395p(MainActivity mainActivity) {
        this.f7862a = mainActivity;
    }

    public void run() {
        this.f7862a.startActivity(new Intent(this.f7862a.getApplicationContext(), AboutActivity.class));
        this.f7862a.overridePendingTransition(2131034125, 2131034129);
    }
}
