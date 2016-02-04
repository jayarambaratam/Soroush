package mobi.mmdt.ott.provider.p168b;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import mobi.mmdt.ott.provider.p167a.C1567a;
import mobi.mmdt.ott.provider.p172f.C1619f;

/* renamed from: mobi.mmdt.ott.provider.b.d */
public class C1575d extends C1567a {
    public int m7927a(Context context, C1577f c1577f) {
        String[] strArr = null;
        ContentResolver contentResolver = context.getContentResolver();
        Uri a = m7928a();
        ContentValues b = m7898b();
        String c = c1577f == null ? null : c1577f.m7914c();
        if (c1577f != null) {
            strArr = c1577f.m7915d();
        }
        return contentResolver.update(a, b, c, strArr);
    }

    public Uri m7928a() {
        return C1574c.f5275a;
    }

    public C1575d m7929a(int i) {
        this.a.put("CHANNELS_followers", Integer.valueOf(i));
        return this;
    }

    public C1575d m7930a(long j) {
        this.a.put("CHANNELS_creation_date", Long.valueOf(j));
        return this;
    }

    public C1575d m7931a(String str) {
        if (str == null) {
            throw new IllegalArgumentException("CHANNELName must not be null");
        }
        this.a.put("CHANNELS_name", str);
        return this;
    }

    public C1575d m7932a(C1619f c1619f) {
        if (c1619f == null) {
            throw new IllegalArgumentException("myRole must not be null");
        }
        this.a.put("CHANNELS_my_role", Integer.valueOf(c1619f.ordinal()));
        return this;
    }

    public C1575d m7933a(boolean z) {
        this.a.put("CHANNELS_is_mute", Boolean.valueOf(z));
        return this;
    }

    public C1575d m7934b(String str) {
        if (str == null) {
            throw new IllegalArgumentException("CHANNELOwner must not be null");
        }
        this.a.put("CHANNELS_channel_owner", str);
        return this;
    }

    public C1575d m7935c(String str) {
        this.a.put("CHANNELS_avatar_url", str);
        return this;
    }

    public C1575d m7936d(String str) {
        this.a.put("CHANNELS_avatar_thumbnail_url", str);
        return this;
    }

    public C1575d m7937e(String str) {
        this.a.put("CHANNELS_description", str);
        return this;
    }
}
