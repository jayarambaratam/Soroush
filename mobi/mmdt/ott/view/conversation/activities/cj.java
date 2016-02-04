package mobi.mmdt.ott.view.conversation.activities;

import android.content.Intent;
import mobi.mmdt.ott.view.conversation.groupinfo.GroupInfoActivity;

class cj implements Runnable {
    final /* synthetic */ GroupConversationActivity f6486a;

    cj(GroupConversationActivity groupConversationActivity) {
        this.f6486a = groupConversationActivity;
    }

    public void run() {
        Intent intent = new Intent(this.f6486a.getApplicationContext(), GroupInfoActivity.class);
        intent.putExtra("KEY_GROUP_ID", this.f6486a.f6391q);
        this.f6486a.startActivityForResult(intent, 1478);
        this.f6486a.overridePendingTransition(2131034125, 2131034129);
    }
}
