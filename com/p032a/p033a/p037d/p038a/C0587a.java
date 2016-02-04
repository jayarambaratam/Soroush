package com.p032a.p033a.p037d.p038a;

import android.content.res.AssetManager;
import android.util.Log;
import com.p032a.p033a.C0883l;

/* renamed from: com.a.a.d.a.a */
public abstract class C0587a<T> implements C0586c<T> {
    private final String f2517a;
    private final AssetManager f2518b;
    private T f2519c;

    public C0587a(AssetManager assetManager, String str) {
        this.f2518b = assetManager;
        this.f2517a = str;
    }

    protected abstract T m4442a(AssetManager assetManager, String str);

    public T m4443a(C0883l c0883l) {
        this.f2519c = m4442a(this.f2518b, this.f2517a);
        return this.f2519c;
    }

    public void m4444a() {
        if (this.f2519c != null) {
            try {
                m4445a(this.f2519c);
            } catch (Throwable e) {
                if (Log.isLoggable("AssetUriFetcher", 2)) {
                    Log.v("AssetUriFetcher", "Failed to close data", e);
                }
            }
        }
    }

    protected abstract void m4445a(T t);

    public String m4446b() {
        return this.f2517a;
    }

    public void m4447c() {
    }
}
