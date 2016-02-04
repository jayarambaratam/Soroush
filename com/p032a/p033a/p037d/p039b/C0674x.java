package com.p032a.p033a.p037d.p039b;

import com.p032a.p033a.p037d.C0667c;
import java.security.MessageDigest;
import org.jivesoftware.smack.util.StringUtils;

/* renamed from: com.a.a.d.b.x */
class C0674x implements C0667c {
    private final String f2696a;
    private final C0667c f2697b;

    public C0674x(String str, C0667c c0667c) {
        this.f2696a = str;
        this.f2697b = c0667c;
    }

    public void m4696a(MessageDigest messageDigest) {
        messageDigest.update(this.f2696a.getBytes(StringUtils.UTF8));
        this.f2697b.m4674a(messageDigest);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0674x c0674x = (C0674x) obj;
        return !this.f2696a.equals(c0674x.f2696a) ? false : this.f2697b.equals(c0674x.f2697b);
    }

    public int hashCode() {
        return (this.f2696a.hashCode() * 31) + this.f2697b.hashCode();
    }
}
