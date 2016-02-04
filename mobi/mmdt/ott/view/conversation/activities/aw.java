package mobi.mmdt.ott.view.conversation.activities;

import android.os.Handler;

class aw implements Runnable {
    final /* synthetic */ ChannelConversationActivity f6435a;

    aw(ChannelConversationActivity channelConversationActivity) {
        this.f6435a = channelConversationActivity;
    }

    public void run() {
        new Handler().postDelayed(new ax(this), 50);
    }
}
