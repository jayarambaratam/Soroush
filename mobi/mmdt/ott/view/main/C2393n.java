package mobi.mmdt.ott.view.main;

import android.content.Intent;
import mobi.mmdt.ott.view.channel.ExploreChannelsActivity;

/* renamed from: mobi.mmdt.ott.view.main.n */
class C2393n implements Runnable {
    final /* synthetic */ MainActivity f7860a;

    C2393n(MainActivity mainActivity) {
        this.f7860a = mainActivity;
    }

    public void run() {
        this.f7860a.startActivity(new Intent(this.f7860a.getApplicationContext(), ExploreChannelsActivity.class));
        this.f7860a.overridePendingTransition(2131034125, 2131034129);
    }
}
