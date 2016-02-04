package com.p032a.p033a.p061i;

import com.p032a.p033a.p037d.C0667c;
import java.security.MessageDigest;
import org.jivesoftware.smack.util.StringUtils;

/* renamed from: com.a.a.i.c */
public class C0871c implements C0667c {
    private final String f3039a;

    public C0871c(String str) {
        if (str == null) {
            throw new NullPointerException("Signature cannot be null!");
        }
        this.f3039a = str;
    }

    public void m5261a(MessageDigest messageDigest) {
        messageDigest.update(this.f3039a.getBytes(StringUtils.UTF8));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f3039a.equals(((C0871c) obj).f3039a);
    }

    public int hashCode() {
        return this.f3039a.hashCode();
    }

    public String toString() {
        return "StringSignature{signature='" + this.f3039a + '\'' + '}';
    }
}
