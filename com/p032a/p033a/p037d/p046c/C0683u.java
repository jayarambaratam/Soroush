package com.p032a.p033a.p037d.p046c;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;
import com.p032a.p033a.p037d.p038a.C0586c;

/* renamed from: com.a.a.d.c.u */
public class C0683u<T> implements C0677s<Integer, T> {
    private final C0677s<Uri, T> f2701a;
    private final Resources f2702b;

    public C0683u(Context context, C0677s<Uri, T> c0677s) {
        this(context.getResources(), (C0677s) c0677s);
    }

    public C0683u(Resources resources, C0677s<Uri, T> c0677s) {
        this.f2702b = resources;
        this.f2701a = c0677s;
    }

    public C0586c<T> m4707a(Integer num, int i, int i2) {
        Object parse;
        try {
            parse = Uri.parse("android.resource://" + this.f2702b.getResourcePackageName(num.intValue()) + '/' + this.f2702b.getResourceTypeName(num.intValue()) + '/' + this.f2702b.getResourceEntryName(num.intValue()));
        } catch (Throwable e) {
            if (Log.isLoggable("ResourceLoader", 5)) {
                Log.w("ResourceLoader", "Received invalid resource id: " + num, e);
            }
            parse = null;
        }
        return parse != null ? this.f2701a.m4700a(parse, i, i2) : null;
    }
}
