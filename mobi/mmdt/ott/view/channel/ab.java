package mobi.mmdt.ott.view.channel;

import android.os.Handler;
import mobi.mmdt.ott.logic.p112a.p117b.p118a.C1345k;

class ab implements Runnable {
    final /* synthetic */ C1345k f5670a;
    final /* synthetic */ ExploreChannelsActivity f5671b;

    ab(ExploreChannelsActivity exploreChannelsActivity, C1345k c1345k) {
        this.f5671b = exploreChannelsActivity;
        this.f5670a = c1345k;
    }

    public void run() {
        new Handler().postDelayed(new ac(this), 50);
    }
}
