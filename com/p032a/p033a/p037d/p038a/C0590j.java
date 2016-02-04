package com.p032a.p033a.p037d.p038a;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.p032a.p033a.C0883l;

/* renamed from: com.a.a.d.a.j */
public abstract class C0590j<T> implements C0586c<T> {
    private final Uri f2522a;
    private final Context f2523b;
    private T f2524c;

    public C0590j(Context context, Uri uri) {
        this.f2523b = context.getApplicationContext();
        this.f2522a = uri;
    }

    public final T m4457a(C0883l c0883l) {
        this.f2524c = m4460b(this.f2522a, this.f2523b.getContentResolver());
        return this.f2524c;
    }

    public void m4458a() {
        if (this.f2524c != null) {
            try {
                m4459a(this.f2524c);
            } catch (Throwable e) {
                if (Log.isLoggable("LocalUriFetcher", 2)) {
                    Log.v("LocalUriFetcher", "failed to close data", e);
                }
            }
        }
    }

    protected abstract void m4459a(T t);

    protected abstract T m4460b(Uri uri, ContentResolver contentResolver);

    public String m4461b() {
        return this.f2522a.toString();
    }

    public void m4462c() {
    }
}
