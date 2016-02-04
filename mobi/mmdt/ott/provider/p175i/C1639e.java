package mobi.mmdt.ott.provider.p175i;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import mobi.mmdt.ott.provider.p167a.C1569c;

/* renamed from: mobi.mmdt.ott.provider.i.e */
public class C1639e extends C1569c<C1639e> {
    public C1638d m8364a(Context context, String[] strArr) {
        Cursor query = context.getContentResolver().query(m7917f(), strArr, m7914c(), m7915d(), m7916e());
        return query == null ? null : new C1638d(query);
    }

    public C1639e m8365a(C1640f... c1640fArr) {
        m7913b("stickerspackage_download_state", c1640fArr);
        return this;
    }

    public C1638d m8366b(Context context) {
        return m8364a(context, null);
    }

    public C1639e m8367b(int... iArr) {
        m7908a("stickerspackage_package_id", m7910a(iArr));
        return this;
    }

    protected Uri m8368g() {
        return C1636b.f5447a;
    }
}
