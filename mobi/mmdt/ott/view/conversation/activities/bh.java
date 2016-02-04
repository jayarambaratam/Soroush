package mobi.mmdt.ott.view.conversation.activities;

import android.support.design.widget.Snackbar;

class bh implements Runnable {
    final /* synthetic */ ChannelConversationActivity f6447a;

    bh(ChannelConversationActivity channelConversationActivity) {
        this.f6447a = channelConversationActivity;
    }

    public void run() {
        this.f6447a.j.m9651f();
        Snackbar.m377a(this.f6447a.k, this.f6447a.getString(2131230821), -1).m395a();
    }
}
