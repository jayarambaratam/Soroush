package mobi.mmdt.ott.view.call;

import android.os.Handler;

/* renamed from: mobi.mmdt.ott.view.call.j */
class C1695j implements Runnable {
    final /* synthetic */ CallActivity f5588a;

    C1695j(CallActivity callActivity) {
        this.f5588a = callActivity;
    }

    public void run() {
        if (this.f5588a.f5575v != null) {
            this.f5588a.f5575v.cancel();
        }
        new Handler().postDelayed(new C1696k(this), 1000);
    }
}
