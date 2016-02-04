package mobi.mmdt.ott.provider.p169c;

import android.content.ContentProviderClient;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import mobi.mmdt.ott.provider.OttProvider;
import mobi.mmdt.ott.provider.p167a.C1569c;

/* renamed from: mobi.mmdt.ott.provider.c.i */
public class C1589i extends C1569c<C1589i> {
    public C1587g m8052a(Context context, String str) {
        ContentProviderClient acquireContentProviderClient = context.getContentResolver().acquireContentProviderClient("mobi.mmdt.ott.provider");
        Cursor a = ((OttProvider) acquireContentProviderClient.getLocalContentProvider()).m7891a(m7917f(), str);
        acquireContentProviderClient.release();
        return a == null ? null : new C1587g(a);
    }

    public C1587g m8053a(Context context, String[] strArr) {
        Cursor query = context.getContentResolver().query(m7917f(), strArr, m7914c(), m7915d(), m7916e());
        return query == null ? null : new C1587g(query);
    }

    public C1589i m8054a(long j) {
        m7907a("conversations_send_time", (Object) Long.valueOf(j));
        return this;
    }

    public C1589i m8055a(String... strArr) {
        m7908a("conversations_message_id", (Object[]) strArr);
        return this;
    }

    public C1589i m8056a(C1592l... c1592lArr) {
        m7908a("conversations_direction_type", (Object[]) c1592lArr);
        return this;
    }

    public C1589i m8057a(C1593m... c1593mArr) {
        m7908a("conversations_event_state", (Object[]) c1593mArr);
        return this;
    }

    public void m8058a(Context context, ContentValues[] contentValuesArr) {
        ContentProviderClient acquireContentProviderClient = context.getContentResolver().acquireContentProviderClient("mobi.mmdt.ott.provider");
        acquireContentProviderClient.getLocalContentProvider().bulkInsert(m7917f(), contentValuesArr);
        acquireContentProviderClient.release();
    }

    public C1587g m8059b(Context context) {
        return m8053a(context, null);
    }

    public C1589i m8060b(long... jArr) {
        m7908a("conversations._id", m7911a(jArr));
        return this;
    }

    public C1589i m8061b(String... strArr) {
        m7908a("conversations_party", (Object[]) strArr);
        return this;
    }

    protected Uri m8062g() {
        return C1585e.f5294a;
    }
}
