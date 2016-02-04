package com.p063b.p064a;

import java.util.ArrayList;
import java.util.List;

/* renamed from: com.b.a.i */
public class C0924i {
    public List<C0925j> f3537a;
    public int f3538b;

    public C0924i() {
        this.f3537a = null;
        this.f3538b = 0;
    }

    public int m5776a() {
        return this.f3537a == null ? 0 : this.f3537a.size();
    }

    public C0925j m5777a(int i) {
        return (C0925j) this.f3537a.get(i);
    }

    public void m5778a(C0925j c0925j) {
        if (this.f3537a == null) {
            this.f3537a = new ArrayList();
        }
        this.f3537a.add(c0925j);
    }

    public boolean m5779b() {
        return this.f3537a == null ? true : this.f3537a.isEmpty();
    }

    public void m5780c() {
        this.f3538b += 10000;
    }

    public void m5781d() {
        this.f3538b += 100;
    }

    public void m5782e() {
        this.f3538b++;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (C0925j append : this.f3537a) {
            stringBuilder.append(append).append(' ');
        }
        return stringBuilder.append('(').append(this.f3538b).append(')').toString();
    }
}
