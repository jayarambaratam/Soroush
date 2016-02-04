package mobi.mmdt.ott.provider.p172f;

import android.content.ContentProviderClient;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import mobi.mmdt.ott.provider.OttProvider;
import mobi.mmdt.ott.provider.p167a.C1569c;

/* renamed from: mobi.mmdt.ott.provider.f.d */
public class C1617d extends C1569c<C1617d> {
    public C1616c m8238a(Context context, String str) {
        ContentProviderClient acquireContentProviderClient = context.getContentResolver().acquireContentProviderClient("mobi.mmdt.ott.provider");
        Cursor a = ((OttProvider) acquireContentProviderClient.getLocalContentProvider()).m7891a(m7917f(), str);
        acquireContentProviderClient.release();
        return a == null ? null : new C1616c(a);
    }

    public C1616c m8239a(Context context, String[] strArr) {
        Cursor query = context.getContentResolver().query(m7917f(), strArr, m7914c(), m7915d(), m7916e());
        return query == null ? null : new C1616c(query);
    }

    public C1617d m8240a(String... strArr) {
        m7908a("members_group_group_id", (Object[]) strArr);
        return this;
    }

    public void m8241a(Context context, ContentValues[] contentValuesArr) {
        ContentProviderClient acquireContentProviderClient = context.getContentResolver().acquireContentProviderClient("mobi.mmdt.ott.provider");
        acquireContentProviderClient.getLocalContentProvider().bulkInsert(m7917f(), contentValuesArr);
        acquireContentProviderClient.release();
    }

    public C1616c m8242b(Context context) {
        return m8239a(context, null);
    }

    public C1617d m8243b(String... strArr) {
        m7908a("members_group_user_id", (Object[]) strArr);
        return this;
    }

    public C1617d m8244c(String... strArr) {
        m7913b("members_group_user_id", strArr);
        return this;
    }

    protected Uri m8245g() {
        return C1615b.f5415a;
    }
}
