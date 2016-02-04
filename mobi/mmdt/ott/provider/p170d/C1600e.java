package mobi.mmdt.ott.provider.p170d;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import mobi.mmdt.ott.provider.p167a.C1567a;

/* renamed from: mobi.mmdt.ott.provider.d.e */
public class C1600e extends C1567a {
    public int m8106a(Context context, C1602g c1602g) {
        String[] strArr = null;
        ContentResolver contentResolver = context.getContentResolver();
        Uri a = m8107a();
        ContentValues b = m7898b();
        String c = c1602g == null ? null : c1602g.m7914c();
        if (c1602g != null) {
            strArr = c1602g.m7915d();
        }
        return contentResolver.update(a, b, c, strArr);
    }

    public Uri m8107a() {
        return C1599d.f5376a;
    }

    public C1600e m8108a(int i) {
        this.a.put("files_progress", Integer.valueOf(i));
        return this;
    }

    public C1600e m8109a(long j) {
        this.a.put("files_size", Long.valueOf(j));
        return this;
    }

    public C1600e m8110a(Integer num) {
        this.a.put("files_duration", num);
        return this;
    }

    public C1600e m8111a(String str) {
        this.a.put("files_file_uri", str);
        return this;
    }

    public C1600e m8112a(C1603h c1603h) {
        this.a.put("files_audio_state", c1603h == null ? null : Integer.valueOf(c1603h.ordinal()));
        return this;
    }

    public C1600e m8113a(C1604i c1604i) {
        if (c1604i == null) {
            throw new IllegalArgumentException("downloadState must not be null");
        }
        this.a.put("files_download_state", Integer.valueOf(c1604i.ordinal()));
        return this;
    }

    public C1600e m8114a(C1605j c1605j) {
        if (c1605j == null) {
            throw new IllegalArgumentException("type must not be null");
        }
        this.a.put("files_type", Integer.valueOf(c1605j.ordinal()));
        return this;
    }

    public C1600e m8115b(int i) {
        this.a.put("files_audio_playing_time", Integer.valueOf(i));
        return this;
    }

    public C1600e m8116b(String str) {
        this.a.put("files_file_url", str);
        return this;
    }

    public C1600e m8117b(C1604i c1604i) {
        if (c1604i == null) {
            throw new IllegalArgumentException("ThumbnaildownloadState must not be null");
        }
        this.a.put("files_thumbnail_download_state", Integer.valueOf(c1604i.ordinal()));
        return this;
    }

    public C1600e m8118c(String str) {
        this.a.put("files_server_file_id", str);
        return this;
    }

    public C1600e m8119d(String str) {
        if (str == null) {
            throw new IllegalArgumentException("name must not be null");
        }
        this.a.put("files_name", str);
        return this;
    }

    public C1600e m8120e(String str) {
        this.a.put("files_thumbnail_uri", str);
        return this;
    }

    public C1600e m8121f(String str) {
        this.a.put("files_thumbnail_url", str);
        return this;
    }
}
