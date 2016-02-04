package com.p065c.p066a.p067a.p074g;

import com.p065c.p066a.p067a.C0954d;
import com.p065c.p066a.p067a.p072e.C0956b;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/* renamed from: com.c.a.a.g.g */
public class C0971g implements C0967c {
    private final TreeSet<C0954d> f3674a;
    private final Map<String, Integer> f3675b;
    private final Map<Long, C0954d> f3676c;

    public C0971g(Comparator<C0954d> comparator) {
        this.f3674a = new TreeSet(comparator);
        this.f3675b = new HashMap();
        this.f3676c = new HashMap();
    }

    private void m5967a(String str) {
        if (this.f3675b.containsKey(str)) {
            this.f3675b.put(str, Integer.valueOf(((Integer) this.f3675b.get(str)).intValue() + 1));
        } else {
            this.f3675b.put(str, Integer.valueOf(1));
        }
    }

    private C0954d m5968b() {
        return this.f3674a.size() < 1 ? null : (C0954d) this.f3674a.first();
    }

    private void m5969b(String str) {
        Integer num = (Integer) this.f3675b.get(str);
        if (num == null || num.intValue() == 0) {
            C0956b.m5907b("detected inconsistency in NonPersistentJobSet's group id hash", new Object[0]);
        } else if (Integer.valueOf(num.intValue() - 1).intValue() == 0) {
            this.f3675b.remove(str);
        }
    }

    public int m5970a() {
        return this.f3674a.size();
    }

    public C0954d m5971a(Collection<String> collection) {
        if (collection == null || collection.size() == 0) {
            return m5968b();
        }
        Iterator it = this.f3674a.iterator();
        while (it.hasNext()) {
            C0954d c0954d = (C0954d) it.next();
            if (c0954d.m5898i() == null || !collection.contains(c0954d.m5898i())) {
                return c0954d;
            }
        }
        return null;
    }

    public C0966b m5972a(long j, Collection<String> collection) {
        int i = 0;
        int size = this.f3675b.keySet().size();
        Set hashSet = size > 0 ? new HashSet() : null;
        Iterator it = this.f3674a.iterator();
        while (it.hasNext()) {
            int i2;
            C0954d c0954d = (C0954d) it.next();
            if (c0954d.m5896g() < j) {
                if (c0954d.m5898i() == null) {
                    i2 = i + 1;
                } else if (collection == null || !collection.contains(c0954d.m5898i())) {
                    if (size > 0 && hashSet.add(c0954d.m5898i())) {
                        i2 = i + 1;
                    }
                }
                i = i2;
            }
            i2 = i;
            i = i2;
        }
        return new C0966b(i, hashSet);
    }

    public boolean m5973a(C0954d c0954d) {
        if (c0954d.m5886a() == null) {
            throw new RuntimeException("cannot add job holder w/o an ID");
        }
        boolean add = this.f3674a.add(c0954d);
        if (!add) {
            m5975b(c0954d);
            add = this.f3674a.add(c0954d);
        }
        if (add) {
            this.f3676c.put(c0954d.m5886a(), c0954d);
            if (c0954d.m5898i() != null) {
                m5967a(c0954d.m5898i());
            }
        }
        return add;
    }

    public C0966b m5974b(Collection<String> collection) {
        Set set = null;
        if (this.f3675b.size() == 0) {
            return new C0966b(this.f3674a.size(), null);
        }
        Iterator it = this.f3674a.iterator();
        int i = 0;
        while (it.hasNext()) {
            Set set2;
            C0954d c0954d = (C0954d) it.next();
            if (c0954d.m5898i() != null) {
                if (collection == null || !collection.contains(c0954d.m5898i())) {
                    if (set == null) {
                        set = new HashSet();
                        set.add(c0954d.m5898i());
                        set2 = set;
                        i++;
                        set = set2;
                    } else if (!set.add(c0954d.m5898i())) {
                    }
                }
            }
            set2 = set;
            i++;
            set = set2;
        }
        return new C0966b(i, set);
    }

    public boolean m5975b(C0954d c0954d) {
        boolean remove = this.f3674a.remove(c0954d);
        if (remove) {
            this.f3676c.remove(c0954d.m5886a());
            if (c0954d.m5898i() != null) {
                m5969b(c0954d.m5898i());
            }
        }
        return remove;
    }
}
