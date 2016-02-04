package mobi.mmdt.ott.view.channel;

import android.os.Handler;

/* renamed from: mobi.mmdt.ott.view.channel.i */
class C1733i implements Runnable {
    final /* synthetic */ C1732h f5710a;

    C1733i(C1732h c1732h) {
        this.f5710a = c1732h;
    }

    public void run() {
        new Handler().postDelayed(new C1734j(this), 50);
    }
}
