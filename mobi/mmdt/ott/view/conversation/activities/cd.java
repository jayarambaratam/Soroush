package mobi.mmdt.ott.view.conversation.activities;

import android.os.Handler;

class cd implements Runnable {
    final /* synthetic */ String f6476a;
    final /* synthetic */ ChannelConversationActivity f6477b;

    cd(ChannelConversationActivity channelConversationActivity, String str) {
        this.f6477b = channelConversationActivity;
        this.f6476a = str;
    }

    public void run() {
        new Handler().postDelayed(new ce(this), 50);
        new Handler().postDelayed(new cf(this), 100);
    }
}
