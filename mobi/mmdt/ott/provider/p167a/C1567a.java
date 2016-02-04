package mobi.mmdt.ott.provider.p167a;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;

/* renamed from: mobi.mmdt.ott.provider.a.a */
public abstract class C1567a {
    protected final ContentValues f5250a;

    public C1567a() {
        this.f5250a = new ContentValues();
    }

    public abstract Uri m7896a();

    public Uri m7897a(Context context) {
        return context.getContentResolver().insert(m7896a(), m7898b());
    }

    public ContentValues m7898b() {
        return this.f5250a;
    }
}
