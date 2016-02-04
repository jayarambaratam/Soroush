package mobi.mmdt.ott.provider.p177k;

import android.content.ContentProviderClient;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import mobi.mmdt.ott.provider.OttProvider;
import mobi.mmdt.ott.provider.p167a.C1569c;

/* renamed from: mobi.mmdt.ott.provider.k.f */
public class C1651f extends C1569c<C1651f> {
    public C1650e m8391a(Context context, String str) {
        ContentProviderClient acquireContentProviderClient = context.getContentResolver().acquireContentProviderClient("mobi.mmdt.ott.provider");
        Cursor a = ((OttProvider) acquireContentProviderClient.getLocalContentProvider()).m7891a(m7917f(), str);
        acquireContentProviderClient.release();
        return a == null ? null : new C1650e(a);
    }

    public C1650e m8392a(Context context, String[] strArr) {
        Cursor query = context.getContentResolver().query(m7917f(), strArr, m7914c(), m7915d(), m7916e());
        return query == null ? null : new C1650e(query);
    }

    public C1651f m8393a(String... strArr) {
        m7908a("userinchatstates_party", (Object[]) strArr);
        return this;
    }

    public C1650e m8394b(Context context) {
        return m8392a(context, null);
    }

    protected Uri m8395g() {
        return C1648c.f5460a;
    }
}
