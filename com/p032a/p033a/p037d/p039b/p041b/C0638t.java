package com.p032a.p033a.p037d.p039b.p041b;

import com.p032a.p033a.p037d.C0667c;
import com.p032a.p033a.p042j.C0631e;
import com.p032a.p033a.p042j.C0879h;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.a.a.d.b.b.t */
class C0638t {
    private final C0631e<C0667c, String> f2608a;

    C0638t() {
        this.f2608a = new C0631e(1000);
    }

    public String m4628a(C0667c c0667c) {
        String str;
        synchronized (this.f2608a) {
            str = (String) this.f2608a.m4601b((Object) c0667c);
        }
        if (str == null) {
            try {
                MessageDigest instance = MessageDigest.getInstance("SHA-256");
                c0667c.m4674a(instance);
                str = C0879h.m5303a(instance.digest());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (NoSuchAlgorithmException e2) {
                e2.printStackTrace();
            }
            synchronized (this.f2608a) {
                this.f2608a.m4602b(c0667c, str);
            }
        }
        return str;
    }
}
