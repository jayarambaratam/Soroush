package com.p032a.p033a.p037d.p049d.p057e;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import com.p032a.p033a.p037d.C0739e;
import com.p032a.p033a.p037d.p039b.C0670y;
import com.p032a.p033a.p037d.p039b.p040a.C0605e;
import com.p032a.p033a.p037d.p046c.C0716j;
import com.p032a.p033a.p037d.p049d.p050a.C0729c;
import com.p032a.p033a.p037d.p049d.p050a.C0748q;
import com.p032a.p033a.p037d.p049d.p054d.C0770b;
import com.p032a.p033a.p042j.C0873a;
import java.io.InputStream;

/* renamed from: com.a.a.d.d.e.c */
public class C0795c implements C0739e<C0716j, C0793a> {
    private static final C0797e f2882a;
    private static final C0796d f2883b;
    private final C0739e<C0716j, Bitmap> f2884c;
    private final C0739e<InputStream, C0770b> f2885d;
    private final C0605e f2886e;
    private final C0797e f2887f;
    private final C0796d f2888g;
    private String f2889h;

    static {
        f2882a = new C0797e();
        f2883b = new C0796d();
    }

    public C0795c(C0739e<C0716j, Bitmap> c0739e, C0739e<InputStream, C0770b> c0739e2, C0605e c0605e) {
        this(c0739e, c0739e2, c0605e, f2882a, f2883b);
    }

    C0795c(C0739e<C0716j, Bitmap> c0739e, C0739e<InputStream, C0770b> c0739e2, C0605e c0605e, C0797e c0797e, C0796d c0796d) {
        this.f2884c = c0739e;
        this.f2885d = c0739e2;
        this.f2886e = c0605e;
        this.f2887f = c0797e;
        this.f2888g = c0796d;
    }

    private C0793a m5012a(C0716j c0716j, int i, int i2, byte[] bArr) {
        return c0716j.m4769a() != null ? m5015b(c0716j, i, i2, bArr) : m5014b(c0716j, i, i2);
    }

    private C0793a m5013a(InputStream inputStream, int i, int i2) {
        C0670y a = this.f2885d.m4834a(inputStream, i, i2);
        if (a == null) {
            return null;
        }
        C0770b c0770b = (C0770b) a.m4678b();
        return c0770b.m4931e() > 1 ? new C0793a(null, a) : new C0793a(new C0729c(c0770b.m4927b(), this.f2886e), null);
    }

    private C0793a m5014b(C0716j c0716j, int i, int i2) {
        C0670y a = this.f2884c.m4834a(c0716j, i, i2);
        return a != null ? new C0793a(a, null) : null;
    }

    private C0793a m5015b(C0716j c0716j, int i, int i2, byte[] bArr) {
        InputStream a = this.f2888g.m5019a(c0716j.m4769a(), bArr);
        a.mark(ItemAnimator.FLAG_MOVED);
        C0748q a2 = this.f2887f.m5020a(a);
        a.reset();
        C0793a c0793a = null;
        if (a2 == C0748q.GIF) {
            c0793a = m5013a(a, i, i2);
        }
        return c0793a == null ? m5014b(new C0716j(a, c0716j.m4770b()), i, i2) : c0793a;
    }

    public C0670y<C0793a> m5016a(C0716j c0716j, int i, int i2) {
        C0873a a = C0873a.m5286a();
        byte[] b = a.m5288b();
        try {
            C0793a a2 = m5012a(c0716j, i, i2, b);
            return a2 != null ? new C0794b(a2) : null;
        } finally {
            a.m5287a(b);
        }
    }

    public String m5018a() {
        if (this.f2889h == null) {
            this.f2889h = this.f2885d.m4835a() + this.f2884c.m4835a();
        }
        return this.f2889h;
    }
}
