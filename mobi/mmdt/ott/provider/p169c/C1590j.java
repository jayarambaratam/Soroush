package mobi.mmdt.ott.provider.p169c;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import mobi.mmdt.ott.provider.C1579c;

/* renamed from: mobi.mmdt.ott.provider.c.j */
public class C1590j extends C1579c {
    private String f5310a;

    public C1590j(Context context, Uri uri, String str, Uri... uriArr) {
        super(context, uri, uriArr);
        this.f5310a = str;
    }

    protected Cursor m8063a() {
        return new C1589i().m8052a(getContext(), this.f5310a);
    }
}
