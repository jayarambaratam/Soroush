package com.p065c.p066a.p067a.p074g;

import java.util.Set;

/* renamed from: com.c.a.a.g.b */
public class C0966b {
    private int f3665a;
    private Set<String> f3666b;

    public C0966b(int i, Set<String> set) {
        this.f3665a = i;
        this.f3666b = set;
    }

    public int m5944a() {
        return this.f3665a;
    }

    public C0966b m5945a(C0966b c0966b) {
        if (this.f3666b == null || c0966b.f3666b == null) {
            this.f3665a += c0966b.f3665a;
            if (this.f3666b == null) {
                this.f3666b = c0966b.f3666b;
            }
        } else {
            int i = 0;
            for (String add : c0966b.f3666b) {
                i = !this.f3666b.add(add) ? i + 1 : i;
            }
            this.f3665a = (this.f3665a + c0966b.f3665a) - i;
        }
        return this;
    }
}
