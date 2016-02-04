package mobi.mmdt.ott.provider.p172f;

import android.database.Cursor;
import mobi.mmdt.ott.provider.p167a.C1568b;

/* renamed from: mobi.mmdt.ott.provider.f.c */
public class C1616c extends C1568b {
    public C1616c(Cursor cursor) {
        super(cursor);
    }

    public String m8235a() {
        String b = m7900b("members_group_user_id");
        if (b != null) {
            return b;
        }
        throw new NullPointerException("The value of 'user_id' in the database was null, which is not allowed according to the model definition");
    }

    public C1619f m8236b() {
        Integer c = m7901c("members_group_user_role");
        if (c != null) {
            return C1619f.values()[c.intValue()];
        }
        throw new NullPointerException("The value of 'user_role' in the database was null, which is not allowed according to the model definition");
    }

    public boolean m8237c() {
        Boolean e = m7903e("members_group_added_by_me");
        if (e != null) {
            return e.booleanValue();
        }
        throw new NullPointerException("The value of 'user_affiliation' in the database was null, which is not allowed according to the model definition");
    }
}
