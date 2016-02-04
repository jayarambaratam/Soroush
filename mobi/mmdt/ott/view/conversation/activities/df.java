package mobi.mmdt.ott.view.conversation.activities;

import android.os.Handler;

class df implements Runnable {
    final /* synthetic */ SingleConversationActivity f6515a;

    df(SingleConversationActivity singleConversationActivity) {
        this.f6515a = singleConversationActivity;
    }

    public void run() {
        new Handler().postDelayed(new dg(this), 500);
    }
}
