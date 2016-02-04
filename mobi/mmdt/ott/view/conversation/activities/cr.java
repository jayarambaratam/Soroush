package mobi.mmdt.ott.view.conversation.activities;

import android.os.Handler;

class cr implements Runnable {
    final /* synthetic */ GroupConversationActivity f6495a;

    cr(GroupConversationActivity groupConversationActivity) {
        this.f6495a = groupConversationActivity;
    }

    public void run() {
        new Handler().postDelayed(new cs(this), 50);
        new Handler().postDelayed(new ct(this), 100);
    }
}
