package mobi.mmdt.ott.provider.p171e;

import android.database.Cursor;
import mobi.mmdt.ott.provider.p167a.C1568b;

/* renamed from: mobi.mmdt.ott.provider.e.d */
public class C1610d extends C1568b {
    public C1610d(Cursor cursor) {
        super(cursor);
    }

    public long m8185a() {
        Long d = m7902d("_id");
        if (d != null) {
            return d.longValue();
        }
        throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
    }

    public String m8186b() {
        return m7900b("members_nick_name");
    }

    public String m8187c() {
        return m7900b("members_avatar_url");
    }

    public String m8188d() {
        return m7900b("members_avatar_thumbnail_url");
    }

    public String m8189e() {
        String b = m7900b("members_user_id");
        if (b != null) {
            return b;
        }
        throw new NullPointerException("The value of 'user_id' in the database was null, which is not allowed according to the model definition");
    }

    public String m8190f() {
        return m7900b("members_local_phone_number");
    }

    public Long m8191g() {
        return m7902d("members_last_online");
    }

    public boolean m8192h() {
        Boolean e = m7903e("members_is_local_user");
        if (e != null) {
            return e.booleanValue();
        }
        throw new NullPointerException("The value of 'is_local_user' in the database was null, which is not allowed according to the model definition");
    }

    public boolean m8193i() {
        Boolean e = m7903e("members_can_reply");
        if (e != null) {
            return e.booleanValue();
        }
        throw new NullPointerException("The value of 'can_reply' in the database was null, which is not allowed according to the model definition");
    }

    public boolean m8194j() {
        Boolean e = m7903e("members_is_anouncer");
        if (e != null) {
            return e.booleanValue();
        }
        throw new NullPointerException("The value of 'is_anouncer' in the database was null, which is not allowed according to the model definition");
    }

    public String m8195k() {
        return m7900b("members_local_name");
    }

    public String m8196l() {
        return m7900b("members_moto");
    }

    public String m8197m() {
        return m7900b("members_local_image_uri");
    }

    public boolean m8198n() {
        Boolean e = m7903e("members_is_new_user");
        if (e != null) {
            return e.booleanValue();
        }
        throw new NullPointerException("The value of 'is_new_user' in the database was null, which is not allowed according to the model definition");
    }
}
