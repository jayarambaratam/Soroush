package mobi.mmdt.ott.provider.p174h;

import android.database.Cursor;
import mobi.mmdt.ott.provider.p167a.C1568b;

/* renamed from: mobi.mmdt.ott.provider.h.e */
public class C1632e extends C1568b {
    public C1632e(Cursor cursor) {
        super(cursor);
    }

    public String m8313a() {
        String b = m7900b("stickers_complete_sticker_id");
        if (b != null) {
            return b;
        }
        throw new NullPointerException("The value of 'complete_sticker_id' in the database was null, which is not allowed according to the model definition");
    }

    public int m8314b() {
        Integer c = m7901c("stickers_sticker_id");
        if (c != null) {
            return c.intValue();
        }
        throw new NullPointerException("The value of 'sticker_id' in the database was null, which is not allowed according to the model definition");
    }

    public int m8315c() {
        Integer c = m7901c("stickers_package_id");
        if (c != null) {
            return c.intValue();
        }
        throw new NullPointerException("The value of 'package_id' in the database was null, which is not allowed according to the model definition");
    }

    public int m8316d() {
        Integer c = m7901c("stickers_sticker_version");
        if (c != null) {
            return c.intValue();
        }
        throw new NullPointerException("The value of 'sticker_version' in the database was null, which is not allowed according to the model definition");
    }

    public String m8317e() {
        String b = m7900b("stickers_original_uri");
        if (b != null) {
            return b;
        }
        throw new NullPointerException("The value of 'original_uri' in the database was null, which is not allowed according to the model definition");
    }

    public C1634g m8318f() {
        Integer c = m7901c("stickers_download_state");
        if (c != null) {
            return C1634g.values()[c.intValue()];
        }
        throw new NullPointerException("The value of 'download_state' in the database was null, which is not allowed according to the model definition");
    }

    public String m8319g() {
        String b = m7900b("stickers_thumbnail_uri");
        if (b != null) {
            return b;
        }
        throw new NullPointerException("The value of 'thumbnail_uri' in the database was null, which is not allowed according to the model definition");
    }

    public int m8320h() {
        Integer c = m7901c("stickers_x_axis");
        if (c != null) {
            return c.intValue();
        }
        throw new NullPointerException("The value of 'x_axis' in the database was null, which is not allowed according to the model definition");
    }

    public int m8321i() {
        Integer c = m7901c("stickers_y_axis");
        if (c != null) {
            return c.intValue();
        }
        throw new NullPointerException("The value of 'y_axis' in the database was null, which is not allowed according to the model definition");
    }

    public int m8322j() {
        Integer c = m7901c("stickers_ver_span");
        if (c != null) {
            return c.intValue();
        }
        throw new NullPointerException("The value of 'ver_span' in the database was null, which is not allowed according to the model definition");
    }

    public int m8323k() {
        Integer c = m7901c("stickers_hor_span");
        if (c != null) {
            return c.intValue();
        }
        throw new NullPointerException("The value of 'hor_span' in the database was null, which is not allowed according to the model definition");
    }
}
