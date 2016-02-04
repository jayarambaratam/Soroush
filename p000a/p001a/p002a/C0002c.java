package p000a.p001a.p002a;

import android.os.Looper;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: a.a.a.c */
public class C0002c {
    public static String f5a;
    static volatile C0002c f6b;
    private static final C0006g f7c;
    private static final Map<Class<?>, List<Class<?>>> f8d;
    private final Map<Class<?>, CopyOnWriteArrayList<C0015p>> f9e;
    private final Map<Object, List<Class<?>>> f10f;
    private final Map<Class<?>, Object> f11g;
    private final ThreadLocal<C0005f> f12h;
    private final C0008i f13i;
    private final C0001b f14j;
    private final C0000a f15k;
    private final C0014o f16l;
    private final ExecutorService f17m;
    private final boolean f18n;
    private final boolean f19o;
    private final boolean f20p;
    private final boolean f21q;
    private final boolean f22r;
    private final boolean f23s;

    static {
        f5a = "Event";
        f7c = new C0006g();
        f8d = new HashMap();
    }

    public C0002c() {
        this(f7c);
    }

    C0002c(C0006g c0006g) {
        this.f12h = new C0003d(this);
        this.f9e = new HashMap();
        this.f10f = new HashMap();
        this.f11g = new ConcurrentHashMap();
        this.f13i = new C0008i(this, Looper.getMainLooper(), 10);
        this.f14j = new C0001b(this);
        this.f15k = new C0000a(this);
        this.f16l = new C0014o(c0006g.f40h);
        this.f19o = c0006g.f33a;
        this.f20p = c0006g.f34b;
        this.f21q = c0006g.f35c;
        this.f22r = c0006g.f36d;
        this.f18n = c0006g.f37e;
        this.f23s = c0006g.f38f;
        this.f17m = c0006g.f39g;
    }

    public static C0002c m2a() {
        if (f6b == null) {
            synchronized (C0002c.class) {
                if (f6b == null) {
                    f6b = new C0002c();
                }
            }
        }
        return f6b;
    }

    private List<Class<?>> m3a(Class<?> cls) {
        List<Class<?>> list;
        synchronized (f8d) {
            list = (List) f8d.get(cls);
            if (list == null) {
                list = new ArrayList();
                for (Class cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
                    list.add(cls2);
                    C0002c.m10a((List) list, cls2.getInterfaces());
                }
                f8d.put(cls, list);
            }
        }
        return list;
    }

    private void m4a(C0015p c0015p, Object obj, Throwable th) {
        if (obj instanceof C0012m) {
            if (this.f19o) {
                Log.e(f5a, "SubscriberExceptionEvent subscriber " + c0015p.f63a.getClass() + " threw an exception", th);
                C0012m c0012m = (C0012m) obj;
                Log.e(f5a, "Initial event " + c0012m.f55c + " caused exception in " + c0012m.f56d, c0012m.f54b);
            }
        } else if (this.f18n) {
            throw new C0007h("Invoking subscriber failed", th);
        } else {
            if (this.f19o) {
                Log.e(f5a, "Could not dispatch event: " + obj.getClass() + " to subscribing class " + c0015p.f63a.getClass(), th);
            }
            if (this.f21q) {
                m17c(new C0012m(this, th, obj, c0015p.f63a));
            }
        }
    }

    private void m5a(C0015p c0015p, Object obj, boolean z) {
        switch (C0004e.f25a[c0015p.f64b.f58b.ordinal()]) {
            case VideoSize.CIF /*1*/:
                m13a(c0015p, obj);
            case VideoSize.HVGA /*2*/:
                if (z) {
                    m13a(c0015p, obj);
                } else {
                    this.f13i.m19a(c0015p, obj);
                }
            case Version.API03_CUPCAKE_15 /*3*/:
                if (z) {
                    this.f14j.m1a(c0015p, obj);
                } else {
                    m13a(c0015p, obj);
                }
            case Version.API04_DONUT_16 /*4*/:
                this.f15k.m0a(c0015p, obj);
            default:
                throw new IllegalStateException("Unknown thread mode: " + c0015p.f64b.f58b);
        }
    }

    private void m6a(Object obj, C0005f c0005f) {
        boolean z;
        Class cls = obj.getClass();
        if (this.f23s) {
            List a = m3a(cls);
            boolean z2 = false;
            for (int i = 0; i < a.size(); i++) {
                z2 |= m11a(obj, c0005f, (Class) a.get(i));
            }
            z = z2;
        } else {
            z = m11a(obj, c0005f, cls);
        }
        if (!z) {
            if (this.f20p) {
                Log.d(f5a, "No subscribers registered for event " + cls);
            }
            if (this.f22r && cls != C0009j.class && cls != C0012m.class) {
                m17c(new C0009j(this, obj));
            }
        }
    }

    private void m7a(Object obj, C0013n c0013n, boolean z, int i) {
        CopyOnWriteArrayList copyOnWriteArrayList;
        Class cls = c0013n.f59c;
        CopyOnWriteArrayList copyOnWriteArrayList2 = (CopyOnWriteArrayList) this.f9e.get(cls);
        C0015p c0015p = new C0015p(obj, c0013n, i);
        if (copyOnWriteArrayList2 == null) {
            copyOnWriteArrayList2 = new CopyOnWriteArrayList();
            this.f9e.put(cls, copyOnWriteArrayList2);
            copyOnWriteArrayList = copyOnWriteArrayList2;
        } else if (copyOnWriteArrayList2.contains(c0015p)) {
            throw new C0007h("Subscriber " + obj.getClass() + " already registered to event " + cls);
        } else {
            copyOnWriteArrayList = copyOnWriteArrayList2;
        }
        int size = copyOnWriteArrayList.size();
        int i2 = 0;
        while (i2 <= size) {
            if (i2 == size || c0015p.f65c > ((C0015p) copyOnWriteArrayList.get(i2)).f65c) {
                copyOnWriteArrayList.add(i2, c0015p);
                break;
            }
            i2++;
        }
        List list = (List) this.f10f.get(obj);
        if (list == null) {
            list = new ArrayList();
            this.f10f.put(obj, list);
        }
        list.add(cls);
        if (z) {
            Object obj2;
            synchronized (this.f11g) {
                obj2 = this.f11g.get(cls);
            }
            if (obj2 != null) {
                m5a(c0015p, obj2, Looper.getMainLooper() == Looper.myLooper());
            }
        }
    }

    private void m8a(Object obj, Class<?> cls) {
        List list = (List) this.f9e.get(cls);
        if (list != null) {
            int size = list.size();
            int i = 0;
            while (i < size) {
                int i2;
                C0015p c0015p = (C0015p) list.get(i);
                if (c0015p.f63a == obj) {
                    c0015p.f66d = false;
                    list.remove(i);
                    i2 = i - 1;
                    i = size - 1;
                } else {
                    i2 = i;
                    i = size;
                }
                size = i;
                i = i2 + 1;
            }
        }
    }

    private synchronized void m9a(Object obj, boolean z, int i) {
        for (C0013n a : this.f16l.m26a(obj.getClass())) {
            m7a(obj, a, z, i);
        }
    }

    static void m10a(List<Class<?>> list, Class<?>[] clsArr) {
        for (Class cls : clsArr) {
            if (!list.contains(cls)) {
                list.add(cls);
                C0002c.m10a((List) list, cls.getInterfaces());
            }
        }
    }

    private boolean m11a(Object obj, C0005f c0005f, Class<?> cls) {
        synchronized (this) {
            CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) this.f9e.get(cls);
        }
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        Iterator it = copyOnWriteArrayList.iterator();
        loop0:
        while (it.hasNext()) {
            C0015p c0015p = (C0015p) it.next();
            c0005f.f30e = obj;
            c0005f.f29d = c0015p;
            try {
                m5a(c0015p, obj, c0005f.f28c);
                Object obj2 = c0005f.f31f;
                continue;
            } finally {
                c0005f.f30e = null;
                c0005f.f29d = null;
                c0005f.f31f = false;
            }
            if (obj2 != null) {
                break loop0;
            }
        }
        return true;
    }

    void m12a(C0010k c0010k) {
        Object obj = c0010k.f48a;
        C0015p c0015p = c0010k.f49b;
        C0010k.m21a(c0010k);
        if (c0015p.f66d) {
            m13a(c0015p, obj);
        }
    }

    void m13a(C0015p c0015p, Object obj) {
        try {
            c0015p.f64b.f57a.invoke(c0015p.f63a, new Object[]{obj});
        } catch (InvocationTargetException e) {
            m4a(c0015p, obj, e.getCause());
        } catch (Throwable e2) {
            throw new IllegalStateException("Unexpected exception", e2);
        }
    }

    public void m14a(Object obj) {
        m9a(obj, false, 0);
    }

    ExecutorService m15b() {
        return this.f17m;
    }

    public synchronized void m16b(Object obj) {
        List<Class> list = (List) this.f10f.get(obj);
        if (list != null) {
            for (Class a : list) {
                m8a(obj, a);
            }
            this.f10f.remove(obj);
        } else {
            Log.w(f5a, "Subscriber to unregister was not registered before: " + obj.getClass());
        }
    }

    public void m17c(Object obj) {
        C0005f c0005f = (C0005f) this.f12h.get();
        List list = c0005f.f26a;
        list.add(obj);
        if (!c0005f.f27b) {
            c0005f.f28c = Looper.getMainLooper() == Looper.myLooper();
            c0005f.f27b = true;
            if (c0005f.f31f) {
                throw new C0007h("Internal error. Abort state was not reset");
            }
            while (!list.isEmpty()) {
                try {
                    m6a(list.remove(0), c0005f);
                } finally {
                    c0005f.f27b = false;
                    c0005f.f28c = false;
                }
            }
        }
    }
}
