package mobi.mmdt.ott.provider.p173g;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import mobi.mmdt.ott.provider.C1579c;

/* renamed from: mobi.mmdt.ott.provider.g.a */
public class C1620a extends C1579c {
    private String f5424a;

    public C1620a(Context context, Uri uri, String str, Uri... uriArr) {
        super(context, uri, uriArr);
        this.f5424a = str;
    }

    protected Cursor m8247a() {
        return new C1627h().m8280a(getContext(), this.f5424a);
    }
}
