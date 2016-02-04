package com.p032a.p033a.p037d.p046c;

import android.net.Uri;
import android.text.TextUtils;
import com.p032a.p033a.p037d.p038a.C0586c;
import java.io.File;

/* renamed from: com.a.a.d.c.w */
public class C0686w<T> implements C0677s<String, T> {
    private final C0677s<Uri, T> f2703a;

    public C0686w(C0677s<Uri, T> c0677s) {
        this.f2703a = c0677s;
    }

    private static Uri m4711a(String str) {
        return Uri.fromFile(new File(str));
    }

    public C0586c<T> m4713a(String str, int i, int i2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Object a;
        if (str.startsWith("/")) {
            a = C0686w.m4711a(str);
        } else {
            a = Uri.parse(str);
            if (a.getScheme() == null) {
                a = C0686w.m4711a(str);
            }
        }
        return this.f2703a.m4700a(a, i, i2);
    }
}
