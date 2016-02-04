package mobi.mmdt.ott.view.channel;

import android.os.Handler;
import mobi.mmdt.ott.logic.p112a.p117b.p118a.C1343i;

/* renamed from: mobi.mmdt.ott.view.channel.z */
class C1750z implements Runnable {
    final /* synthetic */ C1343i f5728a;
    final /* synthetic */ ExploreChannelsActivity f5729b;

    C1750z(ExploreChannelsActivity exploreChannelsActivity, C1343i c1343i) {
        this.f5729b = exploreChannelsActivity;
        this.f5728a = c1343i;
    }

    public void run() {
        new Handler().postDelayed(new aa(this), 50);
        if (this.f5729b.f5645j != null) {
            this.f5729b.f5645j.m8650a(this.f5728a.m7031a(), true);
        }
    }
}
