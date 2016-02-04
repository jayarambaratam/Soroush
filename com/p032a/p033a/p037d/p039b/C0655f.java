package com.p032a.p033a.p037d.p039b;

import android.os.Looper;
import android.util.Log;
import com.p032a.p033a.C0883l;
import com.p032a.p033a.p037d.C0667c;
import com.p032a.p033a.p037d.C0730g;
import com.p032a.p033a.p037d.p038a.C0586c;
import com.p032a.p033a.p037d.p039b.p041b.C0619b;
import com.p032a.p033a.p037d.p039b.p041b.C0632o;
import com.p032a.p033a.p037d.p039b.p041b.C0634p;
import com.p032a.p033a.p037d.p049d.p058f.C0802c;
import com.p032a.p033a.p042j.C0876d;
import com.p032a.p033a.p042j.C0879h;
import com.p032a.p033a.p045h.C0661i;
import com.p032a.p033a.p051g.C0737b;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/* renamed from: com.a.a.d.b.f */
public class C0655f implements C0634p, C0653p, C0654t {
    private final Map<C0667c, C0663l> f2633a;
    private final C0669r f2634b;
    private final C0632o f2635c;
    private final C0656g f2636d;
    private final Map<C0667c, WeakReference<C0671s<?>>> f2637e;
    private final C0675z f2638f;
    private final C0657h f2639g;
    private ReferenceQueue<C0671s<?>> f2640h;

    public C0655f(C0632o c0632o, C0619b c0619b, ExecutorService executorService, ExecutorService executorService2) {
        this(c0632o, c0619b, executorService, executorService2, null, null, null, null, null);
    }

    C0655f(C0632o c0632o, C0619b c0619b, ExecutorService executorService, ExecutorService executorService2, Map<C0667c, C0663l> map, C0669r c0669r, Map<C0667c, WeakReference<C0671s<?>>> map2, C0656g c0656g, C0675z c0675z) {
        Map hashMap;
        Map hashMap2;
        this.f2635c = c0632o;
        this.f2639g = new C0657h(c0619b);
        if (map2 == null) {
            hashMap = new HashMap();
        }
        this.f2637e = hashMap;
        if (c0669r == null) {
            c0669r = new C0669r();
        }
        this.f2634b = c0669r;
        if (map == null) {
            hashMap2 = new HashMap();
        }
        this.f2633a = hashMap2;
        if (c0656g == null) {
            c0656g = new C0656g(executorService, executorService2, this);
        }
        this.f2636d = c0656g;
        if (c0675z == null) {
            c0675z = new C0675z();
        }
        this.f2638f = c0675z;
        c0632o.m4608a((C0634p) this);
    }

    private C0671s<?> m4642a(C0667c c0667c) {
        C0670y a = this.f2635c.m4605a(c0667c);
        return a == null ? null : a instanceof C0671s ? (C0671s) a : new C0671s(a, true);
    }

    private C0671s<?> m4643a(C0667c c0667c, boolean z) {
        if (!z) {
            return null;
        }
        C0671s<?> c0671s;
        WeakReference weakReference = (WeakReference) this.f2637e.get(c0667c);
        if (weakReference != null) {
            c0671s = (C0671s) weakReference.get();
            if (c0671s != null) {
                c0671s.m4686e();
            } else {
                this.f2637e.remove(c0667c);
            }
        } else {
            c0671s = null;
        }
        return c0671s;
    }

    private ReferenceQueue<C0671s<?>> m4644a() {
        if (this.f2640h == null) {
            this.f2640h = new ReferenceQueue();
            Looper.myQueue().addIdleHandler(new C0659j(this.f2637e, this.f2640h));
        }
        return this.f2640h;
    }

    private static void m4645a(String str, long j, C0667c c0667c) {
        Log.v("Engine", str + " in " + C0876d.m5295a(j) + "ms, key: " + c0667c);
    }

    private C0671s<?> m4646b(C0667c c0667c, boolean z) {
        if (!z) {
            return null;
        }
        C0671s<?> a = m4642a(c0667c);
        if (a == null) {
            return a;
        }
        a.m4686e();
        this.f2637e.put(c0667c, new C0660k(c0667c, a, m4644a()));
        return a;
    }

    public <T, Z, R> C0658i m4647a(C0667c c0667c, int i, int i2, C0586c<T> c0586c, C0737b<T, Z> c0737b, C0730g<Z> c0730g, C0802c<Z, R> c0802c, C0883l c0883l, boolean z, C0652e c0652e, C0661i c0661i) {
        C0879h.m5307a();
        long a = C0876d.m5296a();
        C0667c a2 = this.f2634b.m4677a(c0586c.m4440b(), c0667c, i, i2, c0737b.m4826a(), c0737b.m4827b(), c0730g, c0737b.m4829d(), c0802c, c0737b.m4828c());
        C0670y b = m4646b(a2, z);
        if (b != null) {
            c0661i.m4657a(b);
            if (Log.isLoggable("Engine", 2)) {
                C0655f.m4645a("Loaded resource from cache", a, a2);
            }
            return null;
        }
        b = m4643a(a2, z);
        if (b != null) {
            c0661i.m4657a(b);
            if (Log.isLoggable("Engine", 2)) {
                C0655f.m4645a("Loaded resource from active resources", a, a2);
            }
            return null;
        }
        C0663l c0663l = (C0663l) this.f2633a.get(a2);
        if (c0663l != null) {
            c0663l.m4669a(c0661i);
            if (Log.isLoggable("Engine", 2)) {
                C0655f.m4645a("Added to existing load", a, a2);
            }
            return new C0658i(c0661i, c0663l);
        }
        C0663l a3 = this.f2636d.m4653a(a2, z);
        C0672u c0672u = new C0672u(a3, new C0617a(a2, i, i2, c0586c, c0737b, c0730g, c0802c, this.f2639g, c0652e, c0883l), c0883l);
        this.f2633a.put(a2, a3);
        a3.m4669a(c0661i);
        a3.m4667a(c0672u);
        if (Log.isLoggable("Engine", 2)) {
            C0655f.m4645a("Started new load", a, a2);
        }
        return new C0658i(c0661i, a3);
    }

    public void m4648a(C0663l c0663l, C0667c c0667c) {
        C0879h.m5307a();
        if (c0663l.equals((C0663l) this.f2633a.get(c0667c))) {
            this.f2633a.remove(c0667c);
        }
    }

    public void m4649a(C0670y c0670y) {
        C0879h.m5307a();
        if (c0670y instanceof C0671s) {
            ((C0671s) c0670y).m4687f();
            return;
        }
        throw new IllegalArgumentException("Cannot release anything but an EngineResource");
    }

    public void m4650a(C0667c c0667c, C0671s<?> c0671s) {
        C0879h.m5307a();
        if (c0671s != null) {
            c0671s.m4681a(c0667c, this);
            if (c0671s.m4682a()) {
                this.f2637e.put(c0667c, new C0660k(c0667c, c0671s, m4644a()));
            }
        }
        this.f2633a.remove(c0667c);
    }

    public void m4651b(C0670y<?> c0670y) {
        C0879h.m5307a();
        this.f2638f.m4697a(c0670y);
    }

    public void m4652b(C0667c c0667c, C0671s c0671s) {
        C0879h.m5307a();
        this.f2637e.remove(c0667c);
        if (c0671s.m4682a()) {
            this.f2635c.m4609b(c0667c, c0671s);
        } else {
            this.f2638f.m4697a(c0671s);
        }
    }
}
