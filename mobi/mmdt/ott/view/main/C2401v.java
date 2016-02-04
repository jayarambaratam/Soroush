package mobi.mmdt.ott.view.main;

import android.os.Handler;
import mobi.mmdt.ott.logic.p112a.p128e.p129a.p130a.C1398b;

/* renamed from: mobi.mmdt.ott.view.main.v */
class C2401v implements Runnable {
    final /* synthetic */ C1398b f7874a;
    final /* synthetic */ NewGroupContactSelectionListActivity f7875b;

    C2401v(NewGroupContactSelectionListActivity newGroupContactSelectionListActivity, C1398b c1398b) {
        this.f7875b = newGroupContactSelectionListActivity;
        this.f7874a = c1398b;
    }

    public void run() {
        new Handler().postDelayed(new C2402w(this), 50);
        new Handler().postDelayed(new C2403x(this), 100);
    }
}
