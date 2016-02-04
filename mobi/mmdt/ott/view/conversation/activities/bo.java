package mobi.mmdt.ott.view.conversation.activities;

import android.os.Handler;
import mobi.mmdt.ott.logic.p112a.p117b.p118a.C1341g;

class bo implements Runnable {
    final /* synthetic */ C1341g f6455a;
    final /* synthetic */ ChannelConversationActivity f6456b;

    bo(ChannelConversationActivity channelConversationActivity, C1341g c1341g) {
        this.f6456b = channelConversationActivity;
        this.f6455a = c1341g;
    }

    public void run() {
        new Handler().postDelayed(new bp(this), 50);
        new Handler().postDelayed(new bq(this), 100);
    }
}
