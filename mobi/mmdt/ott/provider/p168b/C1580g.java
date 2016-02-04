package mobi.mmdt.ott.provider.p168b;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import mobi.mmdt.ott.provider.C1579c;
import mobi.mmdt.ott.provider.p169c.C1589i;

/* renamed from: mobi.mmdt.ott.provider.b.g */
public class C1580g extends C1579c {
    private String f5277a;

    public C1580g(Context context, Uri uri, String str, Uri... uriArr) {
        super(context, uri, uriArr);
        this.f5277a = str;
    }

    protected Cursor m7957a() {
        return new C1589i().m8052a(getContext(), this.f5277a);
    }
}
