package mobi.mmdt.ott.view.conversation.activities;

import android.os.Handler;
import mobi.mmdt.ott.logic.p112a.p117b.p118a.C1347m;

class bj implements Runnable {
    final /* synthetic */ C1347m f6449a;
    final /* synthetic */ ChannelConversationActivity f6450b;

    bj(ChannelConversationActivity channelConversationActivity, C1347m c1347m) {
        this.f6450b = channelConversationActivity;
        this.f6449a = c1347m;
    }

    public void run() {
        new Handler().postDelayed(new bk(this), 50);
        new Handler().postDelayed(new bl(this), 50);
    }
}
