package mobi.mmdt.ott.view.channel;

import mobi.mmdt.ott.provider.p169c.C1583c;

/* renamed from: mobi.mmdt.ott.view.channel.b */
class C1726b implements Runnable {
    final /* synthetic */ ChannelInfoActivity f5702a;

    C1726b(ChannelInfoActivity channelInfoActivity) {
        this.f5702a = channelInfoActivity;
    }

    public void run() {
        Thread.currentThread().setPriority(1);
        this.f5702a.runOnUiThread(new C1727c(this, C1583c.m8002m(this.f5702a.getApplicationContext(), this.f5702a.f5636s)));
    }
}
