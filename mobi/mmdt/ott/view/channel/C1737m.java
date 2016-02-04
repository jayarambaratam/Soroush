package mobi.mmdt.ott.view.channel;

import android.os.Handler;

/* renamed from: mobi.mmdt.ott.view.channel.m */
class C1737m implements Runnable {
    final /* synthetic */ ChannelInfoActivity f5714a;

    C1737m(ChannelInfoActivity channelInfoActivity) {
        this.f5714a = channelInfoActivity;
    }

    public void run() {
        new Handler().postDelayed(new C1738n(this), 50);
        new Handler().postDelayed(new C1739o(this), 150);
    }
}
