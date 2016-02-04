package com.p032a.p033a.p037d.p046c;

import android.content.Context;
import android.net.Uri;
import com.p032a.p033a.p037d.p038a.C0586c;
import org.apache.http.myHttp.HttpHost;

/* renamed from: com.a.a.d.c.x */
public abstract class C0689x<T> implements C0677s<Uri, T> {
    private final Context f2704a;
    private final C0677s<C0711e, T> f2705b;

    public C0689x(Context context, C0677s<C0711e, T> c0677s) {
        this.f2704a = context;
        this.f2705b = c0677s;
    }

    private static boolean m4716a(String str) {
        return "file".equals(str) || "content".equals(str) || "android.resource".equals(str);
    }

    protected abstract C0586c<T> m4717a(Context context, Uri uri);

    protected abstract C0586c<T> m4718a(Context context, String str);

    public final C0586c<T> m4719a(Uri uri, int i, int i2) {
        String scheme = uri.getScheme();
        if (!C0689x.m4716a(scheme)) {
            return this.f2705b != null ? (HttpHost.DEFAULT_SCHEME_NAME.equals(scheme) || "https".equals(scheme)) ? this.f2705b.m4700a(new C0711e(uri.toString()), i, i2) : null : null;
        } else {
            if (!C0692a.m4725a(uri)) {
                return m4717a(this.f2704a, uri);
            }
            return m4718a(this.f2704a, C0692a.m4726b(uri));
        }
    }
}
