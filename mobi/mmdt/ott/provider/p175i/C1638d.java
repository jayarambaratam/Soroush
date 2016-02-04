package mobi.mmdt.ott.provider.p175i;

import android.database.Cursor;
import mobi.mmdt.ott.provider.p167a.C1568b;

/* renamed from: mobi.mmdt.ott.provider.i.d */
public class C1638d extends C1568b {
    public C1638d(Cursor cursor) {
        super(cursor);
    }

    public int m8357a() {
        Integer c = m7901c("stickerspackage_download_id");
        if (c != null) {
            return c.intValue();
        }
        throw new NullPointerException("The value of 'download_id' in the database was null, which is not allowed according to the model definition");
    }

    public C1640f m8358b() {
        Integer c = m7901c("stickerspackage_download_state");
        if (c != null) {
            return C1640f.values()[c.intValue()];
        }
        throw new NullPointerException("The value of 'download_state' in the database was null, which is not allowed according to the model definition");
    }

    public int m8359c() {
        Integer c = m7901c("stickerspackage_progress");
        if (c != null) {
            return c.intValue();
        }
        throw new NullPointerException("The value of 'progress' in the database was null, which is not allowed according to the model definition");
    }

    public int m8360d() {
        Integer c = m7901c("stickerspackage_package_id");
        if (c != null) {
            return c.intValue();
        }
        throw new NullPointerException("The value of 'package_id' in the database was null, which is not allowed according to the model definition");
    }

    public String m8361e() {
        String b = m7900b("stickerspackage_name");
        if (b != null) {
            return b;
        }
        throw new NullPointerException("The value of 'name' in the database was null, which is not allowed according to the model definition");
    }

    public boolean m8362f() {
        Boolean e = m7903e("stickerspackage_is_hidden");
        if (e != null) {
            return e.booleanValue();
        }
        throw new NullPointerException("The value of 'is_hidden' in the database was null, which is not allowed according to the model definition");
    }

    public String m8363g() {
        String b = m7900b("stickerspackage_thumbnail_uri");
        if (b != null) {
            return b;
        }
        throw new NullPointerException("The value of 'thumbnail_uri' in the database was null, which is not allowed according to the model definition");
    }

    public int getCount() {
        Integer c = m7901c("stickerspackage_count");
        if (c != null) {
            return c.intValue();
        }
        throw new NullPointerException("The value of 'count' in the database was null, which is not allowed according to the model definition");
    }
}
