package mobi.mmdt.ott.view.conversation.activities;

import android.os.Handler;

class bm implements Runnable {
    final /* synthetic */ ChannelConversationActivity f6453a;

    bm(ChannelConversationActivity channelConversationActivity) {
        this.f6453a = channelConversationActivity;
    }

    public void run() {
        new Handler().postDelayed(new bn(this), 50);
    }
}
