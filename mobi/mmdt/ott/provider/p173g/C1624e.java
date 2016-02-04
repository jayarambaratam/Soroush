package mobi.mmdt.ott.provider.p173g;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import mobi.mmdt.ott.provider.p167a.C1567a;
import mobi.mmdt.ott.provider.p172f.C1619f;

/* renamed from: mobi.mmdt.ott.provider.g.e */
public class C1624e extends C1567a {
    public int m8259a(Context context, C1627h c1627h) {
        String[] strArr = null;
        ContentResolver contentResolver = context.getContentResolver();
        Uri a = m8260a();
        ContentValues b = m7898b();
        String c = c1627h == null ? null : c1627h.m7914c();
        if (c1627h != null) {
            strArr = c1627h.m7915d();
        }
        return contentResolver.update(a, b, c, strArr);
    }

    public Uri m8260a() {
        return C1623d.f5433a;
    }

    public C1624e m8261a(int i) {
        this.a.put("PrivateGroups_extra", new C1626g(i).m8278a());
        return this;
    }

    public C1624e m8262a(long j) {
        this.a.put("PrivateGroups_creation_date", Long.valueOf(j));
        return this;
    }

    public C1624e m8263a(String str) {
        if (str == null) {
            throw new IllegalArgumentException("groupName must not be null");
        }
        this.a.put("PrivateGroups_name", str);
        return this;
    }

    public C1624e m8264a(C1619f c1619f) {
        if (c1619f == null) {
            throw new IllegalArgumentException("myRole must not be null");
        }
        this.a.put("PrivateGroups_my_role", Integer.valueOf(c1619f.ordinal()));
        return this;
    }

    public C1624e m8265a(boolean z) {
        this.a.put("PrivateGroups_is_mute", Boolean.valueOf(z));
        return this;
    }

    public C1624e m8266b(String str) {
        this.a.put("PrivateGroups_avatar_url", str);
        return this;
    }

    public C1624e m8267c(String str) {
        this.a.put("PrivateGroups_thumbnail_url", str);
        return this;
    }

    public C1624e m8268d(String str) {
        this.a.put("PrivateGroups_description", str);
        return this;
    }
}
