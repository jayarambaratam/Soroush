package com.p032a.p033a.p037d.p046c;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.a.a.d.c.c */
public class C0709c {
    private static final C0677s f2711c;
    private final Map<Class, Map<Class, C0681t>> f2712a;
    private final Map<Class, Map<Class, C0677s>> f2713b;
    private final Context f2714d;

    static {
        f2711c = new C0710d();
    }

    public C0709c(Context context) {
        this.f2712a = new HashMap();
        this.f2713b = new HashMap();
        this.f2714d = context.getApplicationContext();
    }

    private <T, Y> void m4749a(Class<T> cls, Class<Y> cls2, C0677s<T, Y> c0677s) {
        Map map = (Map) this.f2713b.get(cls);
        if (map == null) {
            map = new HashMap();
            this.f2713b.put(cls, map);
        }
        map.put(cls2, c0677s);
    }

    private <T, Y> void m4750b(Class<T> cls, Class<Y> cls2) {
        m4749a((Class) cls, (Class) cls2, f2711c);
    }

    private <T, Y> C0677s<T, Y> m4751c(Class<T> cls, Class<Y> cls2) {
        Map map = (Map) this.f2713b.get(cls);
        return map != null ? (C0677s) map.get(cls2) : null;
    }

    private <T, Y> C0681t<T, Y> m4752d(Class<T> cls, Class<Y> cls2) {
        Map map = (Map) this.f2712a.get(cls);
        C0681t<T, Y> c0681t = map != null ? (C0681t) map.get(cls2) : null;
        if (c0681t != null) {
            return c0681t;
        }
        C0681t<T, Y> c0681t2 = c0681t;
        for (Class cls3 : this.f2712a.keySet()) {
            if (cls3.isAssignableFrom(cls)) {
                map = (Map) this.f2712a.get(cls3);
                if (map != null) {
                    c0681t = (C0681t) map.get(cls2);
                    if (c0681t != null) {
                        return c0681t;
                    }
                    c0681t2 = c0681t;
                }
            }
            c0681t = c0681t2;
            c0681t2 = c0681t;
        }
        return c0681t2;
    }

    public synchronized <T, Y> C0677s<T, Y> m4753a(Class<T> cls, Class<Y> cls2) {
        C0677s<T, Y> c;
        c = m4751c(cls, cls2);
        if (c == null) {
            C0681t d = m4752d(cls, cls2);
            if (d != null) {
                C0677s a = d.m4703a(this.f2714d, this);
                m4749a((Class) cls, (Class) cls2, a);
            } else {
                m4750b(cls, cls2);
            }
        } else if (f2711c.equals(c)) {
            c = null;
        }
        return c;
    }

    public synchronized <T, Y> C0681t<T, Y> m4754a(Class<T> cls, Class<Y> cls2, C0681t<T, Y> c0681t) {
        C0681t<T, Y> c0681t2;
        this.f2713b.clear();
        Map map = (Map) this.f2712a.get(cls);
        if (map == null) {
            map = new HashMap();
            this.f2712a.put(cls, map);
        }
        c0681t2 = (C0681t) map.put(cls2, c0681t);
        if (c0681t2 != null) {
            for (Map containsValue : this.f2712a.values()) {
                if (containsValue.containsValue(c0681t2)) {
                    c0681t2 = null;
                    break;
                }
            }
        }
        return c0681t2;
    }
}
