package mobi.mmdt.ott.view.main;

import android.content.Intent;

/* renamed from: mobi.mmdt.ott.view.main.l */
class C2391l implements Runnable {
    final /* synthetic */ MainActivity f7858a;

    C2391l(MainActivity mainActivity) {
        this.f7858a = mainActivity;
    }

    public void run() {
        this.f7858a.startActivity(new Intent(this.f7858a.getApplicationContext(), NewConversationContactSelectionListActivity.class));
        this.f7858a.overridePendingTransition(2131034125, 2131034129);
    }
}
