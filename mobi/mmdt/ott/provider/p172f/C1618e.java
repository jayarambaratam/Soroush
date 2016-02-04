package mobi.mmdt.ott.provider.p172f;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import mobi.mmdt.ott.provider.C1579c;

/* renamed from: mobi.mmdt.ott.provider.f.e */
public class C1618e extends C1579c {
    private String f5417a;

    public C1618e(Context context, Uri uri, String str, Uri... uriArr) {
        super(context, uri, uriArr);
        this.f5417a = str;
    }

    protected Cursor m8246a() {
        return new C1617d().m8238a(getContext(), this.f5417a);
    }
}
