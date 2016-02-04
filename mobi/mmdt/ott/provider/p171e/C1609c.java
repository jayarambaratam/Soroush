package mobi.mmdt.ott.provider.p171e;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import mobi.mmdt.ott.provider.p167a.C1567a;

/* renamed from: mobi.mmdt.ott.provider.e.c */
public class C1609c extends C1567a {
    public int m8171a(Context context, C1612f c1612f) {
        String[] strArr = null;
        ContentResolver contentResolver = context.getContentResolver();
        Uri a = m8172a();
        ContentValues b = m7898b();
        String c = c1612f == null ? null : c1612f.m7914c();
        if (c1612f != null) {
            strArr = c1612f.m7915d();
        }
        return contentResolver.update(a, b, c, strArr);
    }

    public Uri m8172a() {
        return C1608b.f5398a;
    }

    public C1609c m8173a(String str) {
        this.a.put("members_nick_name", str);
        return this;
    }

    public C1609c m8174a(boolean z) {
        this.a.put("members_is_local_user", Boolean.valueOf(z));
        return this;
    }

    public C1609c m8175b(String str) {
        this.a.put("members_avatar_url", str);
        return this;
    }

    public C1609c m8176b(boolean z) {
        this.a.put("members_can_reply", Boolean.valueOf(z));
        return this;
    }

    public C1609c m8177c() {
        this.a.putNull("members_local_image_uri");
        return this;
    }

    public C1609c m8178c(String str) {
        this.a.put("members_avatar_thumbnail_url", str);
        return this;
    }

    public C1609c m8179c(boolean z) {
        this.a.put("members_is_anouncer", Boolean.valueOf(z));
        return this;
    }

    public C1609c m8180d(String str) {
        this.a.put("members_local_phone_number", str);
        return this;
    }

    public C1609c m8181d(boolean z) {
        this.a.put("members_is_deactivated_user", Boolean.valueOf(z));
        return this;
    }

    public C1609c m8182e(String str) {
        this.a.put("members_local_name", str);
        return this;
    }

    public C1609c m8183f(String str) {
        this.a.put("members_moto", str);
        return this;
    }

    public C1609c m8184g(String str) {
        this.a.put("members_local_image_uri", str);
        return this;
    }
}
