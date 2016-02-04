package mobi.mmdt.ott.provider.p174h;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import mobi.mmdt.ott.provider.p167a.C1569c;

/* renamed from: mobi.mmdt.ott.provider.h.f */
public class C1633f extends C1569c<C1633f> {
    public C1632e m8324a(Context context, String[] strArr) {
        Cursor query = context.getContentResolver().query(m7917f(), strArr, m7914c(), m7915d(), m7916e());
        return query == null ? null : new C1632e(query);
    }

    public C1633f m8325a(String... strArr) {
        m7908a("stickers_complete_sticker_id", (Object[]) strArr);
        return this;
    }

    public C1632e m8326b(Context context) {
        return m8324a(context, null);
    }

    public C1633f m8327b(int... iArr) {
        m7908a("stickers_sticker_id", m7910a(iArr));
        return this;
    }

    public C1633f m8328c(int... iArr) {
        m7908a("stickers_package_id", m7910a(iArr));
        return this;
    }

    protected Uri m8329g() {
        return C1630c.f5439a;
    }
}
