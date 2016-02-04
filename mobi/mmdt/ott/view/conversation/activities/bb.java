package mobi.mmdt.ott.view.conversation.activities;

import android.os.Handler;

class bb implements Runnable {
    final /* synthetic */ ChannelConversationActivity f6441a;

    bb(ChannelConversationActivity channelConversationActivity) {
        this.f6441a = channelConversationActivity;
    }

    public void run() {
        new Handler().postDelayed(new bc(this), 50);
        new Handler().postDelayed(new bd(this), 100);
    }
}
