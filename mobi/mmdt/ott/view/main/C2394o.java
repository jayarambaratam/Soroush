package mobi.mmdt.ott.view.main;

import android.content.Intent;

/* renamed from: mobi.mmdt.ott.view.main.o */
class C2394o implements Runnable {
    final /* synthetic */ MainActivity f7861a;

    C2394o(MainActivity mainActivity) {
        this.f7861a = mainActivity;
    }

    public void run() {
        this.f7861a.startActivity(new Intent(this.f7861a.getApplicationContext(), NewBulkMessageContactSelectionListActivity.class));
        this.f7861a.overridePendingTransition(2131034125, 2131034129);
    }
}
