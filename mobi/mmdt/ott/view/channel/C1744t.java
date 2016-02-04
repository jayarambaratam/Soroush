package mobi.mmdt.ott.view.channel;

import android.os.Handler;

/* renamed from: mobi.mmdt.ott.view.channel.t */
class C1744t implements Runnable {
    final /* synthetic */ ExploreChannelsActivity f5722a;

    C1744t(ExploreChannelsActivity exploreChannelsActivity) {
        this.f5722a = exploreChannelsActivity;
    }

    public void run() {
        new Handler().postDelayed(new C1745u(this), 50);
    }
}
