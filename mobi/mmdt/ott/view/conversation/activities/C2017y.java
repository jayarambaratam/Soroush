package mobi.mmdt.ott.view.conversation.activities;

import android.content.Intent;
import mobi.mmdt.ott.view.main.NewBulkMessageContactSelectionListActivity;

/* renamed from: mobi.mmdt.ott.view.conversation.activities.y */
class C2017y implements Runnable {
    final /* synthetic */ BulkMessageConversationActivity f6559a;

    C2017y(BulkMessageConversationActivity bulkMessageConversationActivity) {
        this.f6559a = bulkMessageConversationActivity;
    }

    public void run() {
        Intent intent = new Intent(this.f6559a.getApplicationContext(), NewBulkMessageContactSelectionListActivity.class);
        intent.putExtra("KEY_CHECKED_USERNAME_ARRAYLIST", this.f6559a.f6377p);
        this.f6559a.startActivityForResult(intent, 1440);
        this.f6559a.overridePendingTransition(2131034125, 2131034129);
    }
}
