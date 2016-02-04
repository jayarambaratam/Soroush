package com.p032a.p033a.p037d.p046c;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.a.a.d.c.m */
public final class C0719m implements C0712f {
    private final Map<String, List<C0718l>> f2731c;
    private volatile Map<String, String> f2732d;

    C0719m(Map<String, List<C0718l>> map) {
        this.f2731c = Collections.unmodifiableMap(map);
    }

    private Map<String, String> m4775b() {
        Map<String, String> hashMap = new HashMap();
        for (Entry entry : this.f2731c.entrySet()) {
            StringBuilder stringBuilder = new StringBuilder();
            List list = (List) entry.getValue();
            for (int i = 0; i < list.size(); i++) {
                stringBuilder.append(((C0718l) list.get(i)).m4774a());
                if (i != list.size() - 1) {
                    stringBuilder.append(',');
                }
            }
            hashMap.put(entry.getKey(), stringBuilder.toString());
        }
        return hashMap;
    }

    public Map<String, String> m4776a() {
        if (this.f2732d == null) {
            synchronized (this) {
                if (this.f2732d == null) {
                    this.f2732d = Collections.unmodifiableMap(m4775b());
                }
            }
        }
        return this.f2732d;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0719m)) {
            return false;
        }
        return this.f2731c.equals(((C0719m) obj).f2731c);
    }

    public int hashCode() {
        return this.f2731c.hashCode();
    }

    public String toString() {
        return "LazyHeaders{headers=" + this.f2731c + '}';
    }
}
