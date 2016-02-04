package android.support.design.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class bn {
    private static bn f500a;
    private final Object f501b;
    private final Handler f502c;
    private bq f503d;
    private bq f504e;

    private bn() {
        this.f501b = new Object();
        this.f502c = new Handler(Looper.getMainLooper(), new bo(this));
    }

    static bn m578a() {
        if (f500a == null) {
            f500a = new bn();
        }
        return f500a;
    }

    private void m580a(bq bqVar) {
        if (bqVar.f507b != -2) {
            int i = 2750;
            if (bqVar.f507b > 0) {
                i = bqVar.f507b;
            } else if (bqVar.f507b == -1) {
                i = 1500;
            }
            this.f502c.removeCallbacksAndMessages(bqVar);
            this.f502c.sendMessageDelayed(Message.obtain(this.f502c, 0, bqVar), (long) i);
        }
    }

    private boolean m581a(bq bqVar, int i) {
        bp bpVar = (bp) bqVar.f506a.get();
        if (bpVar == null) {
            return false;
        }
        bpVar.m560a(i);
        return true;
    }

    private void m582b() {
        if (this.f504e != null) {
            this.f503d = this.f504e;
            this.f504e = null;
            bp bpVar = (bp) this.f503d.f506a.get();
            if (bpVar != null) {
                bpVar.m559a();
            } else {
                this.f503d = null;
            }
        }
    }

    private void m583b(bq bqVar) {
        synchronized (this.f501b) {
            if (this.f503d == bqVar || this.f504e == bqVar) {
                m581a(bqVar, 2);
            }
        }
    }

    private boolean m584f(bp bpVar) {
        return this.f503d != null && this.f503d.m596a(bpVar);
    }

    private boolean m585g(bp bpVar) {
        return this.f504e != null && this.f504e.m596a(bpVar);
    }

    public void m586a(int i, bp bpVar) {
        synchronized (this.f501b) {
            if (m584f(bpVar)) {
                this.f503d.f507b = i;
                this.f502c.removeCallbacksAndMessages(this.f503d);
                m580a(this.f503d);
                return;
            }
            if (m585g(bpVar)) {
                this.f504e.f507b = i;
            } else {
                this.f504e = new bq(i, bpVar);
            }
            if (this.f503d == null || !m581a(this.f503d, 4)) {
                this.f503d = null;
                m582b();
                return;
            }
        }
    }

    public void m587a(bp bpVar) {
        synchronized (this.f501b) {
            if (m584f(bpVar)) {
                this.f503d = null;
                if (this.f504e != null) {
                    m582b();
                }
            }
        }
    }

    public void m588a(bp bpVar, int i) {
        synchronized (this.f501b) {
            if (m584f(bpVar)) {
                m581a(this.f503d, i);
            } else if (m585g(bpVar)) {
                m581a(this.f504e, i);
            }
        }
    }

    public void m589b(bp bpVar) {
        synchronized (this.f501b) {
            if (m584f(bpVar)) {
                m580a(this.f503d);
            }
        }
    }

    public void m590c(bp bpVar) {
        synchronized (this.f501b) {
            if (m584f(bpVar)) {
                this.f502c.removeCallbacksAndMessages(this.f503d);
            }
        }
    }

    public void m591d(bp bpVar) {
        synchronized (this.f501b) {
            if (m584f(bpVar)) {
                m580a(this.f503d);
            }
        }
    }

    public boolean m592e(bp bpVar) {
        boolean z;
        synchronized (this.f501b) {
            z = m584f(bpVar) || m585g(bpVar);
        }
        return z;
    }
}
