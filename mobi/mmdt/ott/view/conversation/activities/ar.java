package mobi.mmdt.ott.view.conversation.activities;

import android.os.Handler;
import mobi.mmdt.ott.logic.p112a.p117b.p118a.C1338d;

class ar implements Runnable {
    final /* synthetic */ C1338d f6429a;
    final /* synthetic */ ChannelConversationActivity f6430b;

    ar(ChannelConversationActivity channelConversationActivity, C1338d c1338d) {
        this.f6430b = channelConversationActivity;
        this.f6429a = c1338d;
    }

    public void run() {
        new Handler().postDelayed(new as(this), 50);
        new Handler().postDelayed(new at(this), 100);
    }
}
