package mobi.mmdt.ott.view.main;

import android.os.Handler;

/* renamed from: mobi.mmdt.ott.view.main.y */
class C2404y implements Runnable {
    final /* synthetic */ NewGroupContactSelectionListActivity f7878a;

    C2404y(NewGroupContactSelectionListActivity newGroupContactSelectionListActivity) {
        this.f7878a = newGroupContactSelectionListActivity;
    }

    public void run() {
        new Handler().postDelayed(new C2405z(this), 50);
        new Handler().postDelayed(new aa(this), 100);
    }
}
