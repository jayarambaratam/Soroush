package mobi.mmdt.ott.provider.p176j;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import mobi.mmdt.ott.provider.p167a.C1569c;

/* renamed from: mobi.mmdt.ott.provider.j.e */
public class C1645e extends C1569c<C1645e> {
    public C1644d m8376a(Context context, String[] strArr) {
        Cursor query = context.getContentResolver().query(m7917f(), strArr, m7914c(), m7915d(), m7916e());
        return query == null ? null : new C1644d(query);
    }

    public C1645e m8377a(String... strArr) {
        m7908a("syncedcontacts_phone_number", (Object[]) strArr);
        return this;
    }

    public C1644d m8378b(Context context) {
        return m8376a(context, null);
    }

    protected Uri m8379g() {
        return C1642b.f5457a;
    }
}
