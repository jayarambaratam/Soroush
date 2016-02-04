package com.p032a.p033a.p037d.p049d.p054d;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.p032a.p033a.C0574e;
import com.p032a.p033a.C0872i;
import com.p032a.p033a.p035b.C0576a;
import com.p032a.p033a.p037d.C0730g;
import com.p032a.p033a.p037d.C0739e;
import com.p032a.p033a.p037d.p039b.C0652e;
import com.p032a.p033a.p037d.p039b.p040a.C0605e;
import com.p032a.p033a.p037d.p046c.C0677s;
import com.p032a.p033a.p037d.p049d.C0758a;

/* renamed from: com.a.a.d.d.d.g */
class C0775g {
    private final C0769j f2846a;
    private final C0576a f2847b;
    private final Handler f2848c;
    private boolean f2849d;
    private boolean f2850e;
    private C0574e<C0576a, C0576a, Bitmap, Bitmap> f2851f;
    private C0781i f2852g;
    private boolean f2853h;

    public C0775g(Context context, C0769j c0769j, C0576a c0576a, int i, int i2) {
        this(c0769j, c0576a, null, C0775g.m4941a(context, c0576a, i, i2, C0872i.m5264a(context).m5272a()));
    }

    C0775g(C0769j c0769j, C0576a c0576a, Handler handler, C0574e<C0576a, C0576a, Bitmap, Bitmap> c0574e) {
        this.f2849d = false;
        this.f2850e = false;
        if (handler == null) {
            handler = new Handler(Looper.getMainLooper(), new C0782k());
        }
        this.f2846a = c0769j;
        this.f2847b = c0576a;
        this.f2848c = handler;
        this.f2851f = c0574e;
    }

    private static C0574e<C0576a, C0576a, Bitmap, Bitmap> m4941a(Context context, C0576a c0576a, int i, int i2, C0605e c0605e) {
        C0739e c0786o = new C0786o(c0605e);
        C0677s c0784m = new C0784m();
        return C0872i.m5270b(context).m5330a(c0784m, C0576a.class).m5344a((Object) c0576a).m5345a(Bitmap.class).m4290b(C0758a.m4894b()).m4292b(c0786o).m4295b(true).m4289b(C0652e.NONE).m4288b(i, i2);
    }

    private void m4942e() {
        if (this.f2849d && !this.f2850e) {
            this.f2850e = true;
            this.f2847b.m4341a();
            this.f2851f.m4291b(new C0783l()).m4285a(new C0781i(this.f2848c, this.f2847b.m4345d(), SystemClock.uptimeMillis() + ((long) this.f2847b.m4343b())));
        }
    }

    public void m4943a() {
        if (!this.f2849d) {
            this.f2849d = true;
            this.f2853h = false;
            m4942e();
        }
    }

    void m4944a(C0781i c0781i) {
        if (this.f2853h) {
            this.f2848c.obtainMessage(2, c0781i).sendToTarget();
            return;
        }
        C0781i c0781i2 = this.f2852g;
        this.f2852g = c0781i;
        this.f2846a.m4920b(c0781i.f2858b);
        if (c0781i2 != null) {
            this.f2848c.obtainMessage(2, c0781i2).sendToTarget();
        }
        this.f2850e = false;
        m4942e();
    }

    public void m4945a(C0730g<Bitmap> c0730g) {
        if (c0730g == null) {
            throw new NullPointerException("Transformation must not be null");
        }
        this.f2851f = this.f2851f.m4296b(c0730g);
    }

    public void m4946b() {
        this.f2849d = false;
    }

    public void m4947c() {
        m4946b();
        if (this.f2852g != null) {
            C0872i.m5268a(this.f2852g);
            this.f2852g = null;
        }
        this.f2853h = true;
    }

    public Bitmap m4948d() {
        return this.f2852g != null ? this.f2852g.d_() : null;
    }
}
