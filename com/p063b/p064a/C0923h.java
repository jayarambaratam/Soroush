package com.p063b.p064a;

import java.util.ArrayList;
import java.util.List;
import net.frakbot.glowpadbackport.BuildConfig;

/* renamed from: com.b.a.h */
public class C0923h {
    private List<C0922g> f3536a;

    public C0923h() {
        this.f3536a = null;
    }

    public List<C0922g> m5772a() {
        return this.f3536a;
    }

    public void m5773a(C0922g c0922g) {
        if (this.f3536a == null) {
            this.f3536a = new ArrayList();
        }
        for (int i = 0; i < this.f3536a.size(); i++) {
            if (((C0922g) this.f3536a.get(i)).f3534a.f3538b > c0922g.f3534a.f3538b) {
                this.f3536a.add(i, c0922g);
                return;
            }
        }
        this.f3536a.add(c0922g);
    }

    public void m5774a(C0923h c0923h) {
        if (c0923h.f3536a != null) {
            if (this.f3536a == null) {
                this.f3536a = new ArrayList(c0923h.f3536a.size());
            }
            for (C0922g add : c0923h.f3536a) {
                this.f3536a.add(add);
            }
        }
    }

    public boolean m5775b() {
        return this.f3536a == null || this.f3536a.isEmpty();
    }

    public String toString() {
        if (this.f3536a == null) {
            return BuildConfig.FLAVOR;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (C0922g c0922g : this.f3536a) {
            stringBuilder.append(c0922g.toString()).append('\n');
        }
        return stringBuilder.toString();
    }
}
