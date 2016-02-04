package mobi.mmdt.ott.provider.p177k;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import mobi.mmdt.ott.provider.C1579c;

/* renamed from: mobi.mmdt.ott.provider.k.a */
public class C1646a extends C1579c {
    private String f5459a;

    public C1646a(Context context, Uri uri, String str, Uri... uriArr) {
        super(context, uri, uriArr);
        this.f5459a = str;
    }

    protected Cursor m8380a() {
        return new C1651f().m8391a(getContext(), this.f5459a);
    }
}
