package mobi.mmdt.ott.provider.p173g;

import android.database.Cursor;
import mobi.mmdt.ott.provider.p167a.C1568b;
import mobi.mmdt.ott.provider.p172f.C1619f;

/* renamed from: mobi.mmdt.ott.provider.g.f */
public class C1625f extends C1568b {
    public C1625f(Cursor cursor) {
        super(cursor);
    }

    public long m8269a() {
        Long d = m7902d("_id");
        if (d != null) {
            return d.longValue();
        }
        throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
    }

    public String m8270b() {
        String b = m7900b("PrivateGroups_group_id");
        if (b != null) {
            return b;
        }
        throw new NullPointerException("The value of 'group_id' in the database was null, which is not allowed according to the model definition");
    }

    public String m8271c() {
        String b = m7900b("PrivateGroups_name");
        if (b != null) {
            return b;
        }
        throw new NullPointerException("The value of 'group_name' in the database was null, which is not allowed according to the model definition");
    }

    public String m8272d() {
        return m7900b("PrivateGroups_avatar_url");
    }

    public String m8273e() {
        return m7900b("PrivateGroups_thumbnail_url");
    }

    public String m8274f() {
        return m7900b("PrivateGroups_description");
    }

    public boolean m8275g() {
        Boolean e = m7903e("PrivateGroups_is_mute");
        if (e != null) {
            return e.booleanValue();
        }
        throw new NullPointerException("The value of 'is_mute' in the database was null, which is not allowed according to the model definition");
    }

    public C1619f m8276h() {
        Integer c = m7901c("PrivateGroups_my_role");
        if (c != null) {
            return C1619f.values()[c.intValue()];
        }
        throw new NullPointerException("The value of 'my_role' in the database was null, which is not allowed according to the model definition");
    }

    public int m8277i() {
        String b = m7900b("PrivateGroups_extra");
        if (b != null) {
            return new C1626g(b).m8279b();
        }
        throw new NullPointerException("The value of 'extra field' in the database was null, which is not allowed according to the model definition");
    }
}
