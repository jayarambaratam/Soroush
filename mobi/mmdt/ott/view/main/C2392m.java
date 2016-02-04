package mobi.mmdt.ott.view.main;

import android.content.Intent;

/* renamed from: mobi.mmdt.ott.view.main.m */
class C2392m implements Runnable {
    final /* synthetic */ MainActivity f7859a;

    C2392m(MainActivity mainActivity) {
        this.f7859a = mainActivity;
    }

    public void run() {
        this.f7859a.startActivity(new Intent(this.f7859a.getApplicationContext(), NewGroupActivity.class));
        this.f7859a.overridePendingTransition(2131034125, 2131034129);
    }
}
