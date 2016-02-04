package com.p032a.p033a.p042j;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

/* renamed from: com.a.a.j.e */
public class C0631e<T, Y> {
    private final LinkedHashMap<T, Y> f2599a;
    private int f2600b;
    private final int f2601c;
    private int f2602d;

    public C0631e(int i) {
        this.f2599a = new LinkedHashMap(100, 0.75f, true);
        this.f2602d = 0;
        this.f2601c = i;
        this.f2600b = i;
    }

    private void m4596c() {
        m4603b(this.f2600b);
    }

    protected int m4597a(Y y) {
        return 1;
    }

    public void m4598a() {
        m4603b(0);
    }

    protected void m4599a(T t, Y y) {
    }

    public int m4600b() {
        return this.f2602d;
    }

    public Y m4601b(T t) {
        return this.f2599a.get(t);
    }

    public Y m4602b(T t, Y y) {
        if (m4597a(y) >= this.f2600b) {
            m4599a(t, y);
            return null;
        }
        Y put = this.f2599a.put(t, y);
        if (y != null) {
            this.f2602d += m4597a(y);
        }
        if (put != null) {
            this.f2602d -= m4597a(put);
        }
        m4596c();
        return put;
    }

    protected void m4603b(int i) {
        while (this.f2602d > i) {
            Entry entry = (Entry) this.f2599a.entrySet().iterator().next();
            Object value = entry.getValue();
            this.f2602d -= m4597a(value);
            Object key = entry.getKey();
            this.f2599a.remove(key);
            m4599a(key, value);
        }
    }

    public Y m4604c(T t) {
        Y remove = this.f2599a.remove(t);
        if (remove != null) {
            this.f2602d -= m4597a(remove);
        }
        return remove;
    }
}
