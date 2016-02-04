package mobi.mmdt.ott;

import java.util.Timer;
import java.util.TimerTask;

/* renamed from: mobi.mmdt.ott.i */
public class C1318i implements Runnable {
    private Timer f4589a;
    private int f4590b;
    private Runnable f4591c;

    public C1318i(int i) {
        this.f4590b = i;
    }

    public void m6992a(Runnable runnable) {
        this.f4591c = runnable;
        if (this.f4589a != null) {
            this.f4589a.cancel();
        }
        TimerTask c1319j = new C1319j(this);
        this.f4589a = new Timer();
        this.f4589a.schedule(c1319j, (long) this.f4590b);
    }

    public void run() {
        if (this.f4591c != null) {
            this.f4591c.run();
        }
    }
}
