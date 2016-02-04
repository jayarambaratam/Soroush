package mobi.mmdt.ott.view.channel;

import android.os.Handler;

/* renamed from: mobi.mmdt.ott.view.channel.q */
class C1741q implements Runnable {
    final /* synthetic */ String f5718a;
    final /* synthetic */ ExploreChannelsActivity f5719b;

    C1741q(ExploreChannelsActivity exploreChannelsActivity, String str) {
        this.f5719b = exploreChannelsActivity;
        this.f5718a = str;
    }

    public void run() {
        new Handler().postDelayed(new C1742r(this), 50);
        new Handler().postDelayed(new C1743s(this), 100);
    }
}
