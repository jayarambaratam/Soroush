package mobi.mmdt.ott.provider.p177k;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import mobi.mmdt.ott.provider.p167a.C1567a;

/* renamed from: mobi.mmdt.ott.provider.k.d */
public class C1649d extends C1567a {
    public int m8386a(Context context, C1651f c1651f) {
        String[] strArr = null;
        ContentResolver contentResolver = context.getContentResolver();
        Uri a = m8387a();
        ContentValues b = m7898b();
        String c = c1651f == null ? null : c1651f.m7914c();
        if (c1651f != null) {
            strArr = c1651f.m7915d();
        }
        return contentResolver.update(a, b, c, strArr);
    }

    public Uri m8387a() {
        return C1648c.f5460a;
    }

    public C1649d m8388a(String str) {
        if (str == null) {
            throw new IllegalArgumentException("sender must not be null");
        }
        this.a.put("userinchatstates_sender", str);
        return this;
    }

    public C1649d m8389a(C1652g c1652g) {
        if (c1652g == null) {
            throw new IllegalArgumentException("state must not be null");
        }
        this.a.put("userinchatstates_state", Integer.valueOf(c1652g.ordinal()));
        return this;
    }

    public C1649d m8390b(String str) {
        if (str == null) {
            throw new IllegalArgumentException("party must not be null");
        }
        this.a.put("userinchatstates_party", str);
        return this;
    }
}
