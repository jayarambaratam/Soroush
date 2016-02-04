package mobi.mmdt.ott.view.conversation.activities;

import android.content.Intent;
import mobi.mmdt.ott.view.channel.ChannelInfoActivity;

class bv implements Runnable {
    final /* synthetic */ ChannelConversationActivity f6463a;

    bv(ChannelConversationActivity channelConversationActivity) {
        this.f6463a = channelConversationActivity;
    }

    public void run() {
        Intent intent = new Intent(this.f6463a.getApplicationContext(), ChannelInfoActivity.class);
        intent.putExtra("KEY_CHANNEL_ID", this.f6463a.f6380q);
        intent.putExtra("KEY_IS_FOLLOWED", this.f6463a.f6386w);
        this.f6463a.startActivityForResult(intent, 1478);
        this.f6463a.overridePendingTransition(2131034125, 2131034129);
    }
}
