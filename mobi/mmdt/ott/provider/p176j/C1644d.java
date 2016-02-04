package mobi.mmdt.ott.provider.p176j;

import android.database.Cursor;
import mobi.mmdt.ott.provider.p167a.C1568b;

/* renamed from: mobi.mmdt.ott.provider.j.d */
public class C1644d extends C1568b {
    public C1644d(Cursor cursor) {
        super(cursor);
    }

    public String m8375a() {
        String b = m7900b("syncedcontacts_phone_number");
        if (b != null) {
            return b;
        }
        throw new NullPointerException("The value of 'phone_number' in the database was null, which is not allowed according to the model definition");
    }
}
