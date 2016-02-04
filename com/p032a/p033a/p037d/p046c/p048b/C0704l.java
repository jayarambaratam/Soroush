package com.p032a.p033a.p037d.p046c.p048b;

import android.content.Context;
import android.net.Uri;
import com.p032a.p033a.p037d.p038a.C0586c;
import com.p032a.p033a.p037d.p038a.C0596k;
import com.p032a.p033a.p037d.p038a.C0597l;
import com.p032a.p033a.p037d.p046c.C0677s;
import com.p032a.p033a.p037d.p046c.C0689x;
import com.p032a.p033a.p037d.p046c.C0711e;
import java.io.InputStream;

/* renamed from: com.a.a.d.c.b.l */
public class C0704l extends C0689x<InputStream> implements C0695g<Uri> {
    public C0704l(Context context, C0677s<C0711e, InputStream> c0677s) {
        super(context, c0677s);
    }

    protected C0586c<InputStream> m4741a(Context context, Uri uri) {
        return new C0597l(context, uri);
    }

    protected C0586c<InputStream> m4742a(Context context, String str) {
        return new C0596k(context.getApplicationContext().getAssets(), str);
    }
}
