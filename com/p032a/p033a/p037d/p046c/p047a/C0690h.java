package com.p032a.p033a.p037d.p046c.p047a;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.p032a.p033a.p037d.p038a.C0586c;
import com.p032a.p033a.p037d.p038a.C0589d;
import com.p032a.p033a.p037d.p038a.C0591e;
import com.p032a.p033a.p037d.p046c.C0677s;
import com.p032a.p033a.p037d.p046c.C0689x;
import com.p032a.p033a.p037d.p046c.C0711e;

/* renamed from: com.a.a.d.c.a.h */
public class C0690h extends C0689x<ParcelFileDescriptor> implements C0679c<Uri> {
    public C0690h(Context context, C0677s<C0711e, ParcelFileDescriptor> c0677s) {
        super(context, c0677s);
    }

    protected C0586c<ParcelFileDescriptor> m4721a(Context context, Uri uri) {
        return new C0591e(context, uri);
    }

    protected C0586c<ParcelFileDescriptor> m4722a(Context context, String str) {
        return new C0589d(context.getApplicationContext().getAssets(), str);
    }
}
