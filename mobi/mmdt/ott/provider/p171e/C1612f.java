package mobi.mmdt.ott.provider.p171e;

import android.content.ContentProviderClient;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import mobi.mmdt.ott.provider.OttProvider;
import mobi.mmdt.ott.provider.p167a.C1569c;

/* renamed from: mobi.mmdt.ott.provider.e.f */
public class C1612f extends C1569c<C1612f> {
    public C1610d m8212a(Context context, String[] strArr) {
        Cursor query = context.getContentResolver().query(m7917f(), strArr, m7914c(), m7915d(), m7916e());
        return query == null ? null : new C1610d(query);
    }

    public C1612f m8213a(boolean z) {
        m7908a("members_is_local_user", m7909a(Boolean.valueOf(z)));
        return this;
    }

    public C1612f m8214a(String... strArr) {
        m7908a("members_user_id", (Object[]) strArr);
        return this;
    }

    public void m8215a(Context context, String str) {
        ContentProviderClient acquireContentProviderClient = context.getContentResolver().acquireContentProviderClient("mobi.mmdt.ott.provider");
        ((OttProvider) acquireContentProviderClient.getLocalContentProvider()).m7894b(m7917f(), str);
        acquireContentProviderClient.release();
    }

    public void m8216a(Context context, ContentValues[] contentValuesArr) {
        ContentProviderClient acquireContentProviderClient = context.getContentResolver().acquireContentProviderClient("mobi.mmdt.ott.provider");
        acquireContentProviderClient.getLocalContentProvider().bulkInsert(m7917f(), contentValuesArr);
        acquireContentProviderClient.release();
    }

    public C1610d m8217b(Context context) {
        return m8212a(context, null);
    }

    public C1612f m8218b(boolean z) {
        m7908a("members_is_synced_contact", m7909a(Boolean.valueOf(z)));
        return this;
    }

    public C1612f m8219b(String... strArr) {
        m7913b("members_user_id", strArr);
        return this;
    }

    protected Uri m8220g() {
        return C1608b.f5398a;
    }
}
