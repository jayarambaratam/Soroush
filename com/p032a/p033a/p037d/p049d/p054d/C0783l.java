package com.p032a.p033a.p037d.p049d.p054d;

import com.p032a.p033a.p037d.C0667c;
import java.security.MessageDigest;
import java.util.UUID;

/* renamed from: com.a.a.d.d.d.l */
class C0783l implements C0667c {
    private final UUID f2862a;

    public C0783l() {
        this(UUID.randomUUID());
    }

    C0783l(UUID uuid) {
        this.f2862a = uuid;
    }

    public void m4971a(MessageDigest messageDigest) {
        throw new UnsupportedOperationException("Not implemented");
    }

    public boolean equals(Object obj) {
        return obj instanceof C0783l ? ((C0783l) obj).f2862a.equals(this.f2862a) : false;
    }

    public int hashCode() {
        return this.f2862a.hashCode();
    }
}
