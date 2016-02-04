package mobi.mmdt.ott.provider.p173g;

import android.content.ContentProviderClient;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import mobi.mmdt.ott.provider.OttProvider;
import mobi.mmdt.ott.provider.p167a.C1569c;

/* renamed from: mobi.mmdt.ott.provider.g.h */
public class C1627h extends C1569c<C1627h> {
    public C1625f m8280a(Context context, String str) {
        ContentProviderClient acquireContentProviderClient = context.getContentResolver().acquireContentProviderClient("mobi.mmdt.ott.provider");
        Cursor a = ((OttProvider) acquireContentProviderClient.getLocalContentProvider()).m7891a(m7917f(), str);
        acquireContentProviderClient.release();
        return a == null ? null : new C1625f(a);
    }

    public C1625f m8281a(Context context, String[] strArr) {
        Cursor query = context.getContentResolver().query(m7917f(), strArr, m7914c(), m7915d(), m7916e());
        return query == null ? null : new C1625f(query);
    }

    public C1627h m8282a(String... strArr) {
        m7908a("PrivateGroups_group_id", (Object[]) strArr);
        return this;
    }

    public void m8283a(Context context, ContentValues[] contentValuesArr) {
        ContentProviderClient acquireContentProviderClient = context.getContentResolver().acquireContentProviderClient("mobi.mmdt.ott.provider");
        acquireContentProviderClient.getLocalContentProvider().bulkInsert(m7917f(), contentValuesArr);
        acquireContentProviderClient.release();
    }

    public C1625f m8284b(Context context) {
        return m8281a(context, null);
    }

    protected Uri m8285g() {
        return C1623d.f5433a;
    }
}
