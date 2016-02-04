package mobi.mmdt.ott.view.conversation.groupinfo;

import android.os.Handler;

/* renamed from: mobi.mmdt.ott.view.conversation.groupinfo.p */
class C2265p implements Runnable {
    final /* synthetic */ C2264o f7483a;

    C2265p(C2264o c2264o) {
        this.f7483a = c2264o;
    }

    public void run() {
        new Handler().postDelayed(new C2266q(this), 50);
    }
}
