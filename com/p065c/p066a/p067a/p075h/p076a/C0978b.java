package com.p065c.p066a.p067a.p075h.p076a;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.c.a.a.h.a.b */
public class C0978b {
    private final StringBuilder f3694a;
    private final Map<String, String> f3695b;

    public C0978b() {
        this.f3694a = new StringBuilder();
        this.f3695b = new HashMap();
    }

    private String m5998b(boolean z, Collection<String> collection) {
        if (collection == null || collection.size() == 0) {
            return z ? "w_n" : "wo_n";
        } else {
            this.f3694a.setLength(0);
            this.f3694a.append(z ? "X" : "Y");
            for (String append : collection) {
                this.f3694a.append("-").append(append);
            }
            return this.f3694a.toString();
        }
    }

    public synchronized String m5999a(boolean z, Collection<String> collection) {
        return (String) this.f3695b.get(m5998b(z, collection));
    }

    public synchronized void m6000a(String str, boolean z, Collection<String> collection) {
        this.f3695b.put(m5998b(z, collection), str);
    }
}
