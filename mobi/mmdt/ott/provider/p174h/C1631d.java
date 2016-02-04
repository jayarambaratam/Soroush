package mobi.mmdt.ott.provider.p174h;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import mobi.mmdt.ott.provider.p167a.C1567a;

/* renamed from: mobi.mmdt.ott.provider.h.d */
public class C1631d extends C1567a {
    public int m8300a(Context context, C1633f c1633f) {
        String[] strArr = null;
        ContentResolver contentResolver = context.getContentResolver();
        Uri a = m8301a();
        ContentValues b = m7898b();
        String c = c1633f == null ? null : c1633f.m7914c();
        if (c1633f != null) {
            strArr = c1633f.m7915d();
        }
        return contentResolver.update(a, b, c, strArr);
    }

    public Uri m8301a() {
        return C1630c.f5439a;
    }

    public C1631d m8302a(int i) {
        this.a.put("stickers_sticker_id", Integer.valueOf(i));
        return this;
    }

    public C1631d m8303a(String str) {
        if (str == null) {
            throw new IllegalArgumentException("completeStickerId must not be null");
        }
        this.a.put("stickers_complete_sticker_id", str);
        return this;
    }

    public C1631d m8304a(C1634g c1634g) {
        if (c1634g == null) {
            throw new IllegalArgumentException("downloadState must not be null");
        }
        this.a.put("stickers_download_state", Integer.valueOf(c1634g.ordinal()));
        return this;
    }

    public C1631d m8305b(int i) {
        this.a.put("stickers_package_id", Integer.valueOf(i));
        return this;
    }

    public C1631d m8306b(String str) {
        if (str == null) {
            throw new IllegalArgumentException("originalUri must not be null");
        }
        this.a.put("stickers_original_uri", str);
        return this;
    }

    public C1631d m8307c(int i) {
        this.a.put("stickers_sticker_version", Integer.valueOf(i));
        return this;
    }

    public C1631d m8308c(String str) {
        if (str == null) {
            throw new IllegalArgumentException("thumbnailUri must not be null");
        }
        this.a.put("stickers_thumbnail_uri", str);
        return this;
    }

    public C1631d m8309d(int i) {
        this.a.put("stickers_x_axis", Integer.valueOf(i));
        return this;
    }

    public C1631d m8310e(int i) {
        this.a.put("stickers_y_axis", Integer.valueOf(i));
        return this;
    }

    public C1631d m8311f(int i) {
        this.a.put("stickers_ver_span", Integer.valueOf(i));
        return this;
    }

    public C1631d m8312g(int i) {
        this.a.put("stickers_hor_span", Integer.valueOf(i));
        return this;
    }
}
