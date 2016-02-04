package mobi.mmdt.ott.provider.p175i;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import mobi.mmdt.ott.provider.p167a.C1567a;

/* renamed from: mobi.mmdt.ott.provider.i.c */
public class C1637c extends C1567a {
    public int m8342a(Context context, C1639e c1639e) {
        String[] strArr = null;
        ContentResolver contentResolver = context.getContentResolver();
        Uri a = m8343a();
        ContentValues b = m7898b();
        String c = c1639e == null ? null : c1639e.m7914c();
        if (c1639e != null) {
            strArr = c1639e.m7915d();
        }
        return contentResolver.update(a, b, c, strArr);
    }

    public Uri m8343a() {
        return C1636b.f5447a;
    }

    public C1637c m8344a(int i) {
        this.a.put("stickerspackage_package_version", Integer.valueOf(i));
        return this;
    }

    public C1637c m8345a(String str) {
        if (str == null) {
            throw new IllegalArgumentException("price must not be null");
        }
        this.a.put("stickerspackage_price", str);
        return this;
    }

    public C1637c m8346a(C1640f c1640f) {
        if (c1640f == null) {
            throw new IllegalArgumentException("downloadState must not be null");
        }
        this.a.put("stickerspackage_download_state", Integer.valueOf(c1640f.ordinal()));
        return this;
    }

    public C1637c m8347a(boolean z) {
        this.a.put("stickerspackage_is_hidden", Boolean.valueOf(z));
        return this;
    }

    public C1637c m8348b(int i) {
        this.a.put("stickerspackage_progress", Integer.valueOf(i));
        return this;
    }

    public C1637c m8349b(String str) {
        if (str == null) {
            throw new IllegalArgumentException("designer must not be null");
        }
        this.a.put("stickerspackage_designer", str);
        return this;
    }

    public C1637c m8350c(int i) {
        this.a.put("stickerspackage_download_id", Integer.valueOf(i));
        return this;
    }

    public C1637c m8351c(String str) {
        if (str == null) {
            throw new IllegalArgumentException("field must not be null");
        }
        this.a.put("stickerspackage_field", str);
        return this;
    }

    public C1637c m8352d(int i) {
        this.a.put("stickerspackage_package_id", Integer.valueOf(i));
        return this;
    }

    public C1637c m8353d(String str) {
        if (str == null) {
            throw new IllegalArgumentException("name must not be null");
        }
        this.a.put("stickerspackage_name", str);
        return this;
    }

    public C1637c m8354e(int i) {
        this.a.put("stickerspackage_count", Integer.valueOf(i));
        return this;
    }

    public C1637c m8355e(String str) {
        if (str == null) {
            throw new IllegalArgumentException("thumbnailUri must not be null");
        }
        this.a.put("stickerspackage_thumbnail_uri", str);
        return this;
    }

    public C1637c m8356f(String str) {
        this.a.put("stickerspackage_description", str);
        return this;
    }
}
