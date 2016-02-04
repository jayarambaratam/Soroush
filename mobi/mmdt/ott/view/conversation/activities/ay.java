package mobi.mmdt.ott.view.conversation.activities;

import android.os.Handler;

class ay implements Runnable {
    final /* synthetic */ ChannelConversationActivity f6437a;

    ay(ChannelConversationActivity channelConversationActivity) {
        this.f6437a = channelConversationActivity;
    }

    public void run() {
        new Handler().postDelayed(new az(this), 50);
        new Handler().postDelayed(new ba(this), 100);
    }
}
