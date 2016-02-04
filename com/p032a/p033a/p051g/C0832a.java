package com.p032a.p033a.p051g;

import com.p032a.p033a.p037d.C0676b;
import com.p032a.p033a.p037d.C0727f;
import com.p032a.p033a.p037d.C0739e;
import com.p032a.p033a.p037d.p046c.C0677s;
import com.p032a.p033a.p037d.p049d.p058f.C0802c;
import java.io.File;

/* renamed from: com.a.a.g.a */
public class C0832a<A, T, Z, R> implements C0831f<A, T, Z, R>, Cloneable {
    private final C0831f<A, T, Z, R> f2938a;
    private C0739e<File, Z> f2939b;
    private C0739e<T, Z> f2940c;
    private C0727f<Z> f2941d;
    private C0802c<Z, R> f2942e;
    private C0676b<T> f2943f;

    public C0832a(C0831f<A, T, Z, R> c0831f) {
        this.f2938a = c0831f;
    }

    public C0739e<File, Z> m5108a() {
        return this.f2939b != null ? this.f2939b : this.f2938a.m4826a();
    }

    public void m5109a(C0676b<T> c0676b) {
        this.f2943f = c0676b;
    }

    public void m5110a(C0739e<T, Z> c0739e) {
        this.f2940c = c0739e;
    }

    public C0739e<T, Z> m5111b() {
        return this.f2940c != null ? this.f2940c : this.f2938a.m4827b();
    }

    public C0676b<T> m5112c() {
        return this.f2943f != null ? this.f2943f : this.f2938a.m4828c();
    }

    public /* synthetic */ Object clone() {
        return m5116g();
    }

    public C0727f<Z> m5113d() {
        return this.f2941d != null ? this.f2941d : this.f2938a.m4829d();
    }

    public C0677s<A, T> m5114e() {
        return this.f2938a.m5106e();
    }

    public C0802c<Z, R> m5115f() {
        return this.f2942e != null ? this.f2942e : this.f2938a.m5107f();
    }

    public C0832a<A, T, Z, R> m5116g() {
        try {
            return (C0832a) super.clone();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
