package mobi.mmdt.ott.provider.p168b;

import android.database.Cursor;
import mobi.mmdt.ott.provider.p167a.C1568b;
import mobi.mmdt.ott.provider.p172f.C1619f;

/* renamed from: mobi.mmdt.ott.provider.b.e */
public class C1576e extends C1568b {
    public C1576e(Cursor cursor) {
        super(cursor);
    }

    public String m7938a() {
        String b = m7900b("CHANNELS_id");
        if (b != null) {
            return b;
        }
        throw new NullPointerException("The value of 'group_id' in the database was null, which is not allowed according to the model definition");
    }

    public String m7939b() {
        String b = m7900b("CHANNELS_name");
        if (b != null) {
            return b;
        }
        throw new NullPointerException("The value of 'group_name' in the database was null, which is not allowed according to the model definition");
    }

    public String m7940c() {
        return m7900b("CHANNELS_avatar_url");
    }

    public String m7941d() {
        return m7900b("CHANNELS_avatar_thumbnail_url");
    }

    public String m7942e() {
        return m7900b("CHANNELS_description");
    }

    public String m7943f() {
        return m7900b("CHANNELS_channel_owner");
    }

    public int m7944g() {
        Integer c = m7901c("CHANNELS_followers");
        if (c != null) {
            return c.intValue();
        }
        throw new NullPointerException("The value of 'followers' in the database was null, which is not allowed according to the model definition");
    }

    public boolean m7945h() {
        Boolean e = m7903e("CHANNELS_is_mute");
        if (e != null) {
            return e.booleanValue();
        }
        throw new NullPointerException("The value of 'is_mute' in the database was null, which is not allowed according to the model definition");
    }

    public C1619f m7946i() {
        Integer c = m7901c("CHANNELS_my_role");
        if (c != null) {
            return C1619f.values()[c.intValue()];
        }
        throw new NullPointerException("The value of 'my_role' in the database was null, which is not allowed according to the model definition");
    }

    public long m7947j() {
        Long d = m7902d("CHANNELS_creation_date");
        if (d != null) {
            return d.longValue();
        }
        throw new NullPointerException("The value of 'my_role' in the database was null, which is not allowed according to the model definition");
    }

    public boolean m7948k() {
        Boolean e = m7903e("CHANNELS_is_reply_allowed");
        if (e != null) {
            return e.booleanValue();
        }
        throw new NullPointerException("The value of 'is_mute' in the database was null, which is not allowed according to the model definition");
    }
}
