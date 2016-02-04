package com.p032a.p033a.p045h;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.p032a.p033a.C0883l;
import com.p032a.p033a.p037d.C0667c;
import com.p032a.p033a.p037d.C0730g;
import com.p032a.p033a.p037d.p038a.C0586c;
import com.p032a.p033a.p037d.p039b.C0652e;
import com.p032a.p033a.p037d.p039b.C0655f;
import com.p032a.p033a.p037d.p039b.C0658i;
import com.p032a.p033a.p037d.p039b.C0670y;
import com.p032a.p033a.p037d.p049d.p058f.C0802c;
import com.p032a.p033a.p042j.C0876d;
import com.p032a.p033a.p042j.C0879h;
import com.p032a.p033a.p045h.p056b.C0778k;
import com.p032a.p033a.p045h.p056b.C0855h;
import com.p032a.p033a.p045h.p060a.C0837f;
import com.p032a.p033a.p051g.C0831f;
import java.util.Queue;
import net.frakbot.glowpadbackport.BuildConfig;

/* renamed from: com.a.a.h.b */
public final class C0861b<A, T, Z, R> implements C0855h, C0860d, C0661i {
    private static final Queue<C0861b<?, ?, ?, ?>> f2979a;
    private C0670y<?> f2980A;
    private C0658i f2981B;
    private long f2982C;
    private C0862c f2983D;
    private final String f2984b;
    private C0667c f2985c;
    private Drawable f2986d;
    private int f2987e;
    private int f2988f;
    private int f2989g;
    private Context f2990h;
    private C0730g<Z> f2991i;
    private C0831f<A, T, Z, R> f2992j;
    private C0863e f2993k;
    private A f2994l;
    private Class<R> f2995m;
    private boolean f2996n;
    private C0883l f2997o;
    private C0778k<R> f2998p;
    private C0866h<? super A, R> f2999q;
    private float f3000r;
    private C0655f f3001s;
    private C0837f<R> f3002t;
    private int f3003u;
    private int f3004v;
    private C0652e f3005w;
    private Drawable f3006x;
    private Drawable f3007y;
    private boolean f3008z;

    static {
        f2979a = C0879h.m5306a(0);
    }

    private C0861b() {
        this.f2984b = String.valueOf(hashCode());
    }

    public static <A, T, Z, R> C0861b<A, T, Z, R> m5193a(C0831f<A, T, Z, R> c0831f, A a, C0667c c0667c, Context context, C0883l c0883l, C0778k<R> c0778k, float f, Drawable drawable, int i, Drawable drawable2, int i2, Drawable drawable3, int i3, C0866h<? super A, R> c0866h, C0863e c0863e, C0655f c0655f, C0730g<Z> c0730g, Class<R> cls, boolean z, C0837f<R> c0837f, int i4, int i5, C0652e c0652e) {
        C0861b<A, T, Z, R> c0861b = (C0861b) f2979a.poll();
        if (c0861b == null) {
            c0861b = new C0861b();
        }
        c0861b.m5198b(c0831f, a, c0667c, context, c0883l, c0778k, f, drawable, i, drawable2, i2, drawable3, i3, c0866h, c0863e, c0655f, c0730g, cls, z, c0837f, i4, i5, c0652e);
        return c0861b;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m5194a(com.p032a.p033a.p037d.p039b.C0670y<?> r7, R r8) {
        /*
        r6 = this;
        r5 = r6.m5205p();
        r0 = com.p032a.p033a.p045h.C0862c.COMPLETE;
        r6.f2983D = r0;
        r6.f2980A = r7;
        r0 = r6.f2999q;
        if (r0 == 0) goto L_0x001d;
    L_0x000e:
        r0 = r6.f2999q;
        r2 = r6.f2994l;
        r3 = r6.f2998p;
        r4 = r6.f3008z;
        r1 = r8;
        r0 = r0.m5239a(r1, r2, r3, r4, r5);
        if (r0 != 0) goto L_0x002a;
    L_0x001d:
        r0 = r6.f3002t;
        r1 = r6.f3008z;
        r0 = r0.m5130a(r1, r5);
        r1 = r6.f2998p;
        r1.m4957a(r8, r0);
    L_0x002a:
        r6.m5206q();
        r0 = "GenericRequest";
        r1 = 2;
        r0 = android.util.Log.isLoggable(r0, r1);
        if (r0 == 0) goto L_0x0070;
    L_0x0036:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "Resource ready in ";
        r0 = r0.append(r1);
        r2 = r6.f2982C;
        r2 = com.p032a.p033a.p042j.C0876d.m5295a(r2);
        r0 = r0.append(r2);
        r1 = " size: ";
        r0 = r0.append(r1);
        r1 = r7.m4679c();
        r2 = (double) r1;
        r4 = 4517110426252607488; // 0x3eb0000000000000 float:0.0 double:9.5367431640625E-7;
        r2 = r2 * r4;
        r0 = r0.append(r2);
        r1 = " fromCache: ";
        r0 = r0.append(r1);
        r1 = r6.f3008z;
        r0 = r0.append(r1);
        r0 = r0.toString();
        r6.m5195a(r0);
    L_0x0070:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.a.a.h.b.a(com.a.a.d.b.y, java.lang.Object):void");
    }

    private void m5195a(String str) {
        Log.v("GenericRequest", str + " this: " + this.f2984b);
    }

    private static void m5196a(String str, Object obj, String str2) {
        if (obj == null) {
            StringBuilder stringBuilder = new StringBuilder(str);
            stringBuilder.append(" must not be null");
            if (str2 != null) {
                stringBuilder.append(", ");
                stringBuilder.append(str2);
            }
            throw new NullPointerException(stringBuilder.toString());
        }
    }

    private void m5197b(C0670y c0670y) {
        this.f3001s.m4649a(c0670y);
        this.f2980A = null;
    }

    private void m5198b(C0831f<A, T, Z, R> c0831f, A a, C0667c c0667c, Context context, C0883l c0883l, C0778k<R> c0778k, float f, Drawable drawable, int i, Drawable drawable2, int i2, Drawable drawable3, int i3, C0866h<? super A, R> c0866h, C0863e c0863e, C0655f c0655f, C0730g<Z> c0730g, Class<R> cls, boolean z, C0837f<R> c0837f, int i4, int i5, C0652e c0652e) {
        this.f2992j = c0831f;
        this.f2994l = a;
        this.f2985c = c0667c;
        this.f2986d = drawable3;
        this.f2987e = i3;
        this.f2990h = context.getApplicationContext();
        this.f2997o = c0883l;
        this.f2998p = c0778k;
        this.f3000r = f;
        this.f3006x = drawable;
        this.f2988f = i;
        this.f3007y = drawable2;
        this.f2989g = i2;
        this.f2999q = c0866h;
        this.f2993k = c0863e;
        this.f3001s = c0655f;
        this.f2991i = c0730g;
        this.f2995m = cls;
        this.f2996n = z;
        this.f3002t = c0837f;
        this.f3003u = i4;
        this.f3004v = i5;
        this.f3005w = c0652e;
        this.f2983D = C0862c.PENDING;
        if (a != null) {
            C0861b.m5196a("ModelLoader", c0831f.m5106e(), "try .using(ModelLoader)");
            C0861b.m5196a("Transcoder", c0831f.m5107f(), "try .as*(Class).transcode(ResourceTranscoder)");
            C0861b.m5196a("Transformation", c0730g, "try .transform(UnitTransformation.get())");
            if (c0652e.m4637a()) {
                C0861b.m5196a("SourceEncoder", c0831f.m4828c(), "try .sourceEncoder(Encoder) or .diskCacheStrategy(NONE/RESULT)");
            } else {
                C0861b.m5196a("SourceDecoder", c0831f.m4827b(), "try .decoder/.imageDecoder/.videoDecoder(ResourceDecoder) or .diskCacheStrategy(ALL/SOURCE)");
            }
            if (c0652e.m4637a() || c0652e.m4638b()) {
                C0861b.m5196a("CacheDecoder", c0831f.m4826a(), "try .cacheDecoder(ResouceDecoder) or .diskCacheStrategy(NONE)");
            }
            if (c0652e.m4638b()) {
                C0861b.m5196a("Encoder", c0831f.m4829d(), "try .encode(ResourceEncoder) or .diskCacheStrategy(NONE/SOURCE)");
            }
        }
    }

    private void m5199b(Exception exception) {
        if (m5204o()) {
            Drawable k = this.f2994l == null ? m5200k() : null;
            if (k == null) {
                k = m5201l();
            }
            if (k == null) {
                k = m5202m();
            }
            this.f2998p.m4956a(exception, k);
        }
    }

    private Drawable m5200k() {
        if (this.f2986d == null && this.f2987e > 0) {
            this.f2986d = this.f2990h.getResources().getDrawable(this.f2987e);
        }
        return this.f2986d;
    }

    private Drawable m5201l() {
        if (this.f3007y == null && this.f2989g > 0) {
            this.f3007y = this.f2990h.getResources().getDrawable(this.f2989g);
        }
        return this.f3007y;
    }

    private Drawable m5202m() {
        if (this.f3006x == null && this.f2988f > 0) {
            this.f3006x = this.f2990h.getResources().getDrawable(this.f2988f);
        }
        return this.f3006x;
    }

    private boolean m5203n() {
        return this.f2993k == null || this.f2993k.m5220a(this);
    }

    private boolean m5204o() {
        return this.f2993k == null || this.f2993k.m5221b(this);
    }

    private boolean m5205p() {
        return this.f2993k == null || !this.f2993k.m5223c();
    }

    private void m5206q() {
        if (this.f2993k != null) {
            this.f2993k.m5222c(this);
        }
    }

    public void m5207a() {
        this.f2992j = null;
        this.f2994l = null;
        this.f2990h = null;
        this.f2998p = null;
        this.f3006x = null;
        this.f3007y = null;
        this.f2986d = null;
        this.f2999q = null;
        this.f2993k = null;
        this.f2991i = null;
        this.f3002t = null;
        this.f3008z = false;
        this.f2981B = null;
        f2979a.offer(this);
    }

    public void m5208a(int i, int i2) {
        if (Log.isLoggable("GenericRequest", 2)) {
            m5195a("Got onSizeReady in " + C0876d.m5295a(this.f2982C));
        }
        if (this.f2983D == C0862c.WAITING_FOR_SIZE) {
            this.f2983D = C0862c.RUNNING;
            int round = Math.round(this.f3000r * ((float) i));
            int round2 = Math.round(this.f3000r * ((float) i2));
            C0586c a = this.f2992j.m5106e().m4700a(this.f2994l, round, round2);
            if (a == null) {
                m5210a(new Exception("Failed to load model: '" + this.f2994l + "'"));
                return;
            }
            C0802c f = this.f2992j.m5107f();
            if (Log.isLoggable("GenericRequest", 2)) {
                m5195a("finished setup for calling load in " + C0876d.m5295a(this.f2982C));
            }
            this.f3008z = true;
            this.f2981B = this.f3001s.m4647a(this.f2985c, round, round2, a, this.f2992j, this.f2991i, f, this.f2997o, this.f2996n, this.f3005w, this);
            this.f3008z = this.f2980A != null;
            if (Log.isLoggable("GenericRequest", 2)) {
                m5195a("finished onSizeReady in " + C0876d.m5295a(this.f2982C));
            }
        }
    }

    public void m5209a(C0670y<?> c0670y) {
        if (c0670y == null) {
            m5210a(new Exception("Expected to receive a Resource<R> with an object of " + this.f2995m + " inside, but instead got null."));
            return;
        }
        Object b = c0670y.m4678b();
        if (b == null || !this.f2995m.isAssignableFrom(b.getClass())) {
            m5197b((C0670y) c0670y);
            m5210a(new Exception("Expected to receive an object of " + this.f2995m + " but instead got " + (b != null ? b.getClass() : BuildConfig.FLAVOR) + "{" + b + "}" + " inside Resource{" + c0670y + "}." + (b != null ? BuildConfig.FLAVOR : " To indicate failure return a null Resource object, rather than a Resource object containing null data.")));
        } else if (m5203n()) {
            m5194a((C0670y) c0670y, b);
        } else {
            m5197b((C0670y) c0670y);
            this.f2983D = C0862c.COMPLETE;
        }
    }

    public void m5210a(Exception exception) {
        if (Log.isLoggable("GenericRequest", 3)) {
            Log.d("GenericRequest", "load failed", exception);
        }
        this.f2983D = C0862c.FAILED;
        if (this.f2999q == null || !this.f2999q.m5238a(exception, this.f2994l, this.f2998p, m5205p())) {
            m5199b(exception);
        }
    }

    public void m5211b() {
        this.f2982C = C0876d.m5296a();
        if (this.f2994l == null) {
            m5210a(null);
            return;
        }
        this.f2983D = C0862c.WAITING_FOR_SIZE;
        if (C0879h.m5308a(this.f3003u, this.f3004v)) {
            m5208a(this.f3003u, this.f3004v);
        } else {
            this.f2998p.m4954a((C0855h) this);
        }
        if (!(m5216g() || m5219j() || !m5204o())) {
            this.f2998p.m4953a(m5202m());
        }
        if (Log.isLoggable("GenericRequest", 2)) {
            m5195a("finished run method in " + C0876d.m5295a(this.f2982C));
        }
    }

    void m5212c() {
        this.f2983D = C0862c.CANCELLED;
        if (this.f2981B != null) {
            this.f2981B.m4655a();
            this.f2981B = null;
        }
    }

    public void m5213d() {
        C0879h.m5307a();
        if (this.f2983D != C0862c.CLEARED) {
            m5212c();
            if (this.f2980A != null) {
                m5197b(this.f2980A);
            }
            if (m5204o()) {
                this.f2998p.m4958b(m5202m());
            }
            this.f2983D = C0862c.CLEARED;
        }
    }

    public void m5214e() {
        m5213d();
        this.f2983D = C0862c.PAUSED;
    }

    public boolean m5215f() {
        return this.f2983D == C0862c.RUNNING || this.f2983D == C0862c.WAITING_FOR_SIZE;
    }

    public boolean m5216g() {
        return this.f2983D == C0862c.COMPLETE;
    }

    public boolean m5217h() {
        return m5216g();
    }

    public boolean m5218i() {
        return this.f2983D == C0862c.CANCELLED || this.f2983D == C0862c.CLEARED;
    }

    public boolean m5219j() {
        return this.f2983D == C0862c.FAILED;
    }
}
