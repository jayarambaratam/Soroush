package com.p032a.p033a.p037d.p039b.p041b;

import com.p032a.p033a.p037d.C0667c;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.a.a.d.b.b.e */
final class C0622e {
    private final Map<C0667c, C0624g> f2584a;
    private final C0625h f2585b;

    C0622e() {
        this.f2584a = new HashMap();
        this.f2585b = new C0625h();
    }

    void m4584a(C0667c c0667c) {
        C0624g c0624g;
        synchronized (this) {
            c0624g = (C0624g) this.f2584a.get(c0667c);
            if (c0624g == null) {
                c0624g = this.f2585b.m4586a();
                this.f2584a.put(c0667c, c0624g);
            }
            c0624g.f2587b++;
        }
        c0624g.f2586a.lock();
    }

    void m4585b(C0667c c0667c) {
        C0624g c0624g;
        synchronized (this) {
            c0624g = (C0624g) this.f2584a.get(c0667c);
            if (c0624g == null || c0624g.f2587b <= 0) {
                throw new IllegalArgumentException("Cannot release a lock that is not held, key: " + c0667c + ", interestedThreads: " + (c0624g == null ? 0 : c0624g.f2587b));
            }
            int i = c0624g.f2587b - 1;
            c0624g.f2587b = i;
            if (i == 0) {
                C0624g c0624g2 = (C0624g) this.f2584a.remove(c0667c);
                if (c0624g2.equals(c0624g)) {
                    this.f2585b.m4587a(c0624g2);
                } else {
                    throw new IllegalStateException("Removed the wrong lock, expected to remove: " + c0624g + ", but actually removed: " + c0624g2 + ", key: " + c0667c);
                }
            }
        }
        c0624g.f2586a.unlock();
    }
}
