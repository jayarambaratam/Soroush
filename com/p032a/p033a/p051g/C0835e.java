package com.p032a.p033a.p051g;

import com.p032a.p033a.p037d.C0676b;
import com.p032a.p033a.p037d.C0727f;
import com.p032a.p033a.p037d.C0739e;
import com.p032a.p033a.p037d.p046c.C0677s;
import com.p032a.p033a.p037d.p049d.p058f.C0802c;
import java.io.File;

/* renamed from: com.a.a.g.e */
public class C0835e<A, T, Z, R> implements C0831f<A, T, Z, R> {
    private final C0677s<A, T> f2947a;
    private final C0802c<Z, R> f2948b;
    private final C0737b<T, Z> f2949c;

    public C0835e(C0677s<A, T> c0677s, C0802c<Z, R> c0802c, C0737b<T, Z> c0737b) {
        if (c0677s == null) {
            throw new NullPointerException("ModelLoader must not be null");
        }
        this.f2947a = c0677s;
        if (c0802c == null) {
            throw new NullPointerException("Transcoder must not be null");
        }
        this.f2948b = c0802c;
        if (c0737b == null) {
            throw new NullPointerException("DataLoadProvider must not be null");
        }
        this.f2949c = c0737b;
    }

    public C0739e<File, Z> m5124a() {
        return this.f2949c.m4826a();
    }

    public C0739e<T, Z> m5125b() {
        return this.f2949c.m4827b();
    }

    public C0676b<T> m5126c() {
        return this.f2949c.m4828c();
    }

    public C0727f<Z> m5127d() {
        return this.f2949c.m4829d();
    }

    public C0677s<A, T> m5128e() {
        return this.f2947a;
    }

    public C0802c<Z, R> m5129f() {
        return this.f2948b;
    }
}
