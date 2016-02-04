package com.p063b.p064a;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* renamed from: com.b.a.bc */
public class bc extends bf implements bb, be {
    public List<bi> f3202i;
    public Set<String> f3203j;
    public String f3204k;
    public Set<String> f3205l;
    public Set<String> f3206m;
    public Set<String> f3207n;

    protected bc() {
        this.f3202i = new ArrayList();
        this.f3203j = null;
        this.f3204k = null;
        this.f3205l = null;
        this.f3206m = null;
        this.f3207n = null;
    }

    public List<bi> m5446a() {
        return this.f3202i;
    }

    public void m5447a(bi biVar) {
        this.f3202i.add(biVar);
    }

    public void m5448a(String str) {
        this.f3204k = str;
    }

    public void m5449a(Set<String> set) {
        this.f3203j = set;
    }

    public Set<String> m5450b() {
        return this.f3203j;
    }

    public void m5451b(Set<String> set) {
        this.f3205l = set;
    }

    public String m5452c() {
        return this.f3204k;
    }

    public void m5453c(Set<String> set) {
        this.f3206m = set;
    }

    public Set<String> m5454d() {
        return null;
    }

    public void m5455d(Set<String> set) {
        this.f3207n = set;
    }

    public Set<String> m5456e() {
        return this.f3206m;
    }

    public Set<String> m5457f() {
        return this.f3207n;
    }
}
