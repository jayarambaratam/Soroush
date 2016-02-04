package mobi.mmdt.ott.view.conversation.activities;

import android.os.Handler;

class ak implements Runnable {
    final /* synthetic */ ChannelConversationActivity f6422a;

    ak(ChannelConversationActivity channelConversationActivity) {
        this.f6422a = channelConversationActivity;
    }

    public void run() {
        new Handler().postDelayed(new al(this), 50);
        new Handler().postDelayed(new am(this), 100);
    }
}
