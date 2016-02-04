package mobi.mmdt.ott.view.conversation.activities;

import android.os.Handler;

class bf implements Runnable {
    final /* synthetic */ ChannelConversationActivity f6445a;

    bf(ChannelConversationActivity channelConversationActivity) {
        this.f6445a = channelConversationActivity;
    }

    public void run() {
        new Handler().postDelayed(new bg(this), 50);
        this.f6445a.f6387x.setVisibility(8);
    }
}
