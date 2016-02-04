package com.p065c.p066a.p067a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeSet;

/* renamed from: com.c.a.a.b */
public class C0948b {
    private ArrayList<String> f3620a;
    private final TreeSet<String> f3621b;

    public C0948b() {
        this.f3621b = new TreeSet();
    }

    public synchronized Collection<String> m5861a() {
        if (this.f3620a == null) {
            this.f3620a = new ArrayList(this.f3621b);
        }
        return this.f3620a;
    }

    public synchronized void m5862a(String str) {
        if (this.f3621b.add(str)) {
            this.f3620a = null;
        }
    }

    public synchronized void m5863b(String str) {
        if (this.f3621b.remove(str)) {
            this.f3620a = null;
        }
    }
}
