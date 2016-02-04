package mobi.mmdt.ott.provider.p168b;

import android.content.ContentProviderClient;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import mobi.mmdt.ott.provider.p167a.C1569c;

/* renamed from: mobi.mmdt.ott.provider.b.f */
public class C1577f extends C1569c<C1577f> {
    public C1576e m7949a(Context context, String[] strArr) {
        Cursor query = context.getContentResolver().query(m7917f(), strArr, m7914c(), m7915d(), m7916e());
        return query == null ? null : new C1576e(query);
    }

    public C1577f m7950a(String... strArr) {
        m7908a("CHANNELS_id", (Object[]) strArr);
        return this;
    }

    public void m7951a(Context context, ContentValues[] contentValuesArr) {
        ContentProviderClient acquireContentProviderClient = context.getContentResolver().acquireContentProviderClient("mobi.mmdt.ott.provider");
        acquireContentProviderClient.getLocalContentProvider().bulkInsert(m7917f(), contentValuesArr);
        acquireContentProviderClient.release();
    }

    public C1576e m7952b(Context context) {
        return m7949a(context, null);
    }

    protected Uri m7953g() {
        return C1574c.f5275a;
    }
}
