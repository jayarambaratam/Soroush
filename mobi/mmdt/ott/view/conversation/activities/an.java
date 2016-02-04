package mobi.mmdt.ott.view.conversation.activities;

import android.os.Handler;

class an implements Runnable {
    final /* synthetic */ ChannelConversationActivity f6425a;

    an(ChannelConversationActivity channelConversationActivity) {
        this.f6425a = channelConversationActivity;
    }

    public void run() {
        new Handler().postDelayed(new ao(this), 50);
        new Handler().postDelayed(new ap(this), 100);
    }
}
