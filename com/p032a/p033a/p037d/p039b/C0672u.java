package com.p032a.p033a.p037d.p039b;

import android.util.Log;
import com.p032a.p033a.C0883l;
import com.p032a.p033a.p037d.p039b.p043c.C0648i;

/* renamed from: com.a.a.d.b.u */
class C0672u implements C0648i, Runnable {
    private final C0883l f2688a;
    private final C0662v f2689b;
    private final C0617a<?, ?, ?> f2690c;
    private C0673w f2691d;
    private volatile boolean f2692e;

    public C0672u(C0662v c0662v, C0617a<?, ?, ?> c0617a, C0883l c0883l) {
        this.f2689b = c0662v;
        this.f2690c = c0617a;
        this.f2691d = C0673w.CACHE;
        this.f2688a = c0883l;
    }

    private void m4688a(C0670y c0670y) {
        this.f2689b.m4657a(c0670y);
    }

    private void m4689a(Exception exception) {
        if (m4690c()) {
            this.f2691d = C0673w.SOURCE;
            this.f2689b.m4659b(this);
            return;
        }
        this.f2689b.m4658a(exception);
    }

    private boolean m4690c() {
        return this.f2691d == C0673w.CACHE;
    }

    private C0670y<?> m4691d() {
        return m4690c() ? m4692e() : m4693f();
    }

    private C0670y<?> m4692e() {
        C0670y<?> a;
        try {
            a = this.f2690c.m4572a();
        } catch (Exception e) {
            if (Log.isLoggable("EngineRunnable", 3)) {
                Log.d("EngineRunnable", "Exception decoding result from cache: " + e);
            }
            a = null;
        }
        return a == null ? this.f2690c.m4573b() : a;
    }

    private C0670y<?> m4693f() {
        return this.f2690c.m4574c();
    }

    public void m4694a() {
        this.f2692e = true;
        this.f2690c.m4575d();
    }

    public int m4695b() {
        return this.f2688a.ordinal();
    }

    public void run() {
        Exception exception = null;
        if (!this.f2692e) {
            C0670y d;
            try {
                d = m4691d();
            } catch (Throwable e) {
                if (Log.isLoggable("EngineRunnable", 2)) {
                    Log.v("EngineRunnable", "Exception decoding", e);
                }
                Throwable th = e;
                Object obj = null;
            }
            if (this.f2692e) {
                if (d != null) {
                    d.m4680d();
                }
            } else if (d == null) {
                m4689a(exception);
            } else {
                m4688a(d);
            }
        }
    }
}
