package mobi.mmdt.ott.view.channel;

import android.os.Handler;

/* renamed from: mobi.mmdt.ott.view.channel.w */
class C1747w implements Runnable {
    final /* synthetic */ ExploreChannelsActivity f5725a;

    C1747w(ExploreChannelsActivity exploreChannelsActivity) {
        this.f5725a = exploreChannelsActivity;
    }

    public void run() {
        new Handler().postDelayed(new C1748x(this), 50);
        new Handler().postDelayed(new C1749y(this), 100);
    }
}
