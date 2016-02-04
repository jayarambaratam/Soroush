package mobi.mmdt.ott.view.conversation.activities;

import android.os.Handler;

class br implements Runnable {
    final /* synthetic */ ChannelConversationActivity f6459a;

    br(ChannelConversationActivity channelConversationActivity) {
        this.f6459a = channelConversationActivity;
    }

    public void run() {
        new Handler().postDelayed(new bs(this), 50);
        new Handler().postDelayed(new bt(this), 100);
    }
}
