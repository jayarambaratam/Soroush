package mobi.mmdt.ott.logic;

import android.content.Context;
import java.util.TimerTask;
import mobi.mmdt.ott.logic.p112a.p147h.C1453d;

/* renamed from: mobi.mmdt.ott.logic.e */
final class C1520e extends TimerTask {
    final /* synthetic */ Context f5095a;

    C1520e(Context context) {
        this.f5095a = context;
    }

    public void run() {
        C1494c.m7541c(new C1453d(this.f5095a));
    }
}
