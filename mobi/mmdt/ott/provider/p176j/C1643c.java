package mobi.mmdt.ott.provider.p176j;

import android.net.Uri;
import mobi.mmdt.ott.provider.p167a.C1567a;

/* renamed from: mobi.mmdt.ott.provider.j.c */
public class C1643c extends C1567a {
    public Uri m8373a() {
        return C1642b.f5457a;
    }

    public C1643c m8374a(String str) {
        if (str == null) {
            throw new IllegalArgumentException("phoneNumber must not be null");
        }
        this.a.put("syncedcontacts_phone_number", str);
        return this;
    }
}
