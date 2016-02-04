package mobi.mmdt.ott.view.channel;

import android.os.Handler;
import mobi.mmdt.componentsutils.view.p085a.C1123a;

/* renamed from: mobi.mmdt.ott.view.channel.k */
class C1735k implements Runnable {
    final /* synthetic */ ChannelInfoActivity f5712a;

    C1735k(ChannelInfoActivity channelInfoActivity) {
        this.f5712a = channelInfoActivity;
    }

    public void run() {
        C1123a.m6432a(this.f5712a.m8494q()).m6437a();
        new Handler().postDelayed(new C1736l(this), 150);
    }
}
