package mobi.mmdt.ott.view.conversation.activities;

import android.os.Handler;

class co implements Runnable {
    final /* synthetic */ GroupConversationActivity f6492a;

    co(GroupConversationActivity groupConversationActivity) {
        this.f6492a = groupConversationActivity;
    }

    public void run() {
        new Handler().postDelayed(new cp(this), 50);
        new Handler().postDelayed(new cq(this), 100);
    }
}
