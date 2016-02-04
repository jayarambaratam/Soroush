package p000a.p001a.p002a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

/* renamed from: a.a.a.i */
final class C0008i extends Handler {
    private final C0011l f41a;
    private final int f42b;
    private final C0002c f43c;
    private boolean f44d;

    C0008i(C0002c c0002c, Looper looper, int i) {
        super(looper);
        this.f43c = c0002c;
        this.f42b = i;
        this.f41a = new C0011l();
    }

    void m19a(C0015p c0015p, Object obj) {
        C0010k a = C0010k.m20a(c0015p, obj);
        synchronized (this) {
            this.f41a.m24a(a);
            if (!this.f44d) {
                this.f44d = true;
                if (!sendMessage(obtainMessage())) {
                    throw new C0007h("Could not send handler message");
                }
            }
        }
    }

    public void handleMessage(Message message) {
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            do {
                C0010k a = this.f41a.m22a();
                if (a == null) {
                    synchronized (this) {
                        a = this.f41a.m22a();
                        if (a == null) {
                            this.f44d = false;
                            this.f44d = false;
                            return;
                        }
                    }
                }
                this.f43c.m12a(a);
            } while (SystemClock.uptimeMillis() - uptimeMillis < ((long) this.f42b));
            if (sendMessage(obtainMessage())) {
                this.f44d = true;
                return;
            }
            throw new C0007h("Could not send handler message");
        } catch (Throwable th) {
            this.f44d = false;
        }
    }
}
