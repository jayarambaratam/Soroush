package com.p032a.p033a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.p032a.p033a.p037d.C0667c;
import com.p032a.p033a.p037d.C0676b;
import com.p032a.p033a.p037d.C0730g;
import com.p032a.p033a.p037d.C0739e;
import com.p032a.p033a.p037d.C0807d;
import com.p032a.p033a.p037d.p039b.C0652e;
import com.p032a.p033a.p037d.p049d.C0792d;
import com.p032a.p033a.p042j.C0879h;
import com.p032a.p033a.p045h.C0848a;
import com.p032a.p033a.p045h.C0860d;
import com.p032a.p033a.p045h.C0861b;
import com.p032a.p033a.p045h.C0863e;
import com.p032a.p033a.p045h.C0864f;
import com.p032a.p033a.p045h.C0866h;
import com.p032a.p033a.p045h.C0867j;
import com.p032a.p033a.p045h.p056b.C0778k;
import com.p032a.p033a.p045h.p060a.C0837f;
import com.p032a.p033a.p045h.p060a.C0844g;
import com.p032a.p033a.p051g.C0831f;
import com.p032a.p033a.p051g.C0832a;
import com.p032a.p033a.p055e.C0809i;
import com.p032a.p033a.p055e.C0824q;
import com.p032a.p033a.p061i.C0870b;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: com.a.a.e */
public class C0574e<ModelType, DataType, ResourceType, TranscodeType> implements Cloneable {
    private boolean f2381A;
    private Drawable f2382B;
    private int f2383C;
    protected final Class<ModelType> f2384a;
    protected final Context f2385b;
    protected final C0872i f2386c;
    protected final Class<TranscodeType> f2387d;
    protected final C0824q f2388e;
    protected final C0809i f2389f;
    private C0832a<ModelType, DataType, ResourceType, TranscodeType> f2390g;
    private ModelType f2391h;
    private C0667c f2392i;
    private boolean f2393j;
    private int f2394k;
    private int f2395l;
    private C0866h<? super ModelType, TranscodeType> f2396m;
    private Float f2397n;
    private C0574e<?, ?, ?, TranscodeType> f2398o;
    private Float f2399p;
    private Drawable f2400q;
    private Drawable f2401r;
    private C0883l f2402s;
    private boolean f2403t;
    private C0837f<TranscodeType> f2404u;
    private int f2405v;
    private int f2406w;
    private C0652e f2407x;
    private C0730g<ResourceType> f2408y;
    private boolean f2409z;

    C0574e(Context context, Class<ModelType> cls, C0831f<ModelType, DataType, ResourceType, TranscodeType> c0831f, Class<TranscodeType> cls2, C0872i c0872i, C0824q c0824q, C0809i c0809i) {
        C0832a c0832a = null;
        this.f2392i = C0870b.m5259a();
        this.f2399p = Float.valueOf(1.0f);
        this.f2402s = null;
        this.f2403t = true;
        this.f2404u = C0844g.m5141a();
        this.f2405v = -1;
        this.f2406w = -1;
        this.f2407x = C0652e.RESULT;
        this.f2408y = C0792d.m5002b();
        this.f2385b = context;
        this.f2384a = cls;
        this.f2387d = cls2;
        this.f2386c = c0872i;
        this.f2388e = c0824q;
        this.f2389f = c0809i;
        if (c0831f != null) {
            c0832a = new C0832a(c0831f);
        }
        this.f2390g = c0832a;
        if (context == null) {
            throw new NullPointerException("Context can't be null");
        } else if (cls != null && c0831f == null) {
            throw new NullPointerException("LoadProvider must not be null");
        }
    }

    C0574e(C0831f<ModelType, DataType, ResourceType, TranscodeType> c0831f, Class<TranscodeType> cls, C0574e<ModelType, ?, ?, ?> c0574e) {
        this(c0574e.f2385b, c0574e.f2384a, c0831f, cls, c0574e.f2386c, c0574e.f2388e, c0574e.f2389f);
        this.f2391h = c0574e.f2391h;
        this.f2393j = c0574e.f2393j;
        this.f2392i = c0574e.f2392i;
        this.f2407x = c0574e.f2407x;
        this.f2403t = c0574e.f2403t;
    }

    private C0860d m4279a(C0778k<TranscodeType> c0778k, float f, C0883l c0883l, C0863e c0863e) {
        return C0861b.m5193a(this.f2390g, this.f2391h, this.f2392i, this.f2385b, c0883l, c0778k, f, this.f2400q, this.f2394k, this.f2401r, this.f2395l, this.f2382B, this.f2383C, this.f2396m, c0863e, this.f2386c.m5277b(), this.f2408y, this.f2387d, this.f2403t, this.f2404u, this.f2406w, this.f2405v, this.f2407x);
    }

    private C0860d m4280a(C0778k<TranscodeType> c0778k, C0867j c0867j) {
        C0860d c0867j2;
        if (this.f2398o != null) {
            if (this.f2381A) {
                throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
            }
            if (this.f2398o.f2404u.equals(C0844g.m5141a())) {
                this.f2398o.f2404u = this.f2404u;
            }
            if (this.f2398o.f2402s == null) {
                this.f2398o.f2402s = m4281a();
            }
            if (C0879h.m5308a(this.f2406w, this.f2405v) && !C0879h.m5308a(this.f2398o.f2406w, this.f2398o.f2405v)) {
                this.f2398o.m4288b(this.f2406w, this.f2405v);
            }
            c0867j2 = new C0867j(c0867j);
            C0860d a = m4279a(c0778k, this.f2399p.floatValue(), this.f2402s, c0867j2);
            this.f2381A = true;
            C0860d a2 = this.f2398o.m4280a(c0778k, c0867j2);
            this.f2381A = false;
            c0867j2.m5244a(a, a2);
            return c0867j2;
        } else if (this.f2397n == null) {
            return m4279a(c0778k, this.f2399p.floatValue(), this.f2402s, c0867j);
        } else {
            c0867j2 = new C0867j(c0867j);
            c0867j2.m5244a(m4279a(c0778k, this.f2399p.floatValue(), this.f2402s, c0867j2), m4279a(c0778k, this.f2397n.floatValue(), m4281a(), c0867j2));
            return c0867j2;
        }
    }

    private C0883l m4281a() {
        return this.f2402s == C0883l.LOW ? C0883l.NORMAL : this.f2402s == C0883l.NORMAL ? C0883l.HIGH : C0883l.IMMEDIATE;
    }

    private C0860d m4282b(C0778k<TranscodeType> c0778k) {
        if (this.f2402s == null) {
            this.f2402s = C0883l.NORMAL;
        }
        return m4280a(c0778k, null);
    }

    C0574e<ModelType, DataType, ResourceType, TranscodeType> m4283a(C0837f<TranscodeType> c0837f) {
        if (c0837f == null) {
            throw new NullPointerException("Animation factory must not be null!");
        }
        this.f2404u = c0837f;
        return this;
    }

    public C0778k<TranscodeType> m4284a(ImageView imageView) {
        C0879h.m5307a();
        if (imageView == null) {
            throw new IllegalArgumentException("You must pass in a non null View");
        }
        if (!(this.f2409z || imageView.getScaleType() == null)) {
            switch (C0836g.f2950a[imageView.getScaleType().ordinal()]) {
                case VideoSize.CIF /*1*/:
                    m4299f();
                    break;
                case VideoSize.HVGA /*2*/:
                case Version.API03_CUPCAKE_15 /*3*/:
                case Version.API04_DONUT_16 /*4*/:
                    m4298e();
                    break;
            }
        }
        return m4285a(this.f2386c.m5274a(imageView, this.f2387d));
    }

    public <Y extends C0778k<TranscodeType>> Y m4285a(Y y) {
        C0879h.m5307a();
        if (y == null) {
            throw new IllegalArgumentException("You must pass in a non null Target");
        } else if (this.f2393j) {
            C0860d a = y.m4952a();
            if (a != null) {
                a.m5187d();
                this.f2388e.m5088b(a);
                a.m5185a();
            }
            a = m4282b((C0778k) y);
            y.m4955a(a);
            this.f2389f.m5048a(y);
            this.f2388e.m5086a(a);
            return y;
        } else {
            throw new IllegalArgumentException("You must first set a model (try #load())");
        }
    }

    public C0574e<ModelType, DataType, ResourceType, TranscodeType> m4286b(float f) {
        if (f < 0.0f || f > 1.0f) {
            throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        this.f2397n = Float.valueOf(f);
        return this;
    }

    public C0574e<ModelType, DataType, ResourceType, TranscodeType> m4287b(int i) {
        this.f2394k = i;
        return this;
    }

    public C0574e<ModelType, DataType, ResourceType, TranscodeType> m4288b(int i, int i2) {
        if (C0879h.m5308a(i, i2)) {
            this.f2406w = i;
            this.f2405v = i2;
            return this;
        }
        throw new IllegalArgumentException("Width and height must be Target#SIZE_ORIGINAL or > 0");
    }

    public C0574e<ModelType, DataType, ResourceType, TranscodeType> m4289b(C0652e c0652e) {
        this.f2407x = c0652e;
        return this;
    }

    public C0574e<ModelType, DataType, ResourceType, TranscodeType> m4290b(C0676b<DataType> c0676b) {
        if (this.f2390g != null) {
            this.f2390g.m5109a((C0676b) c0676b);
        }
        return this;
    }

    public C0574e<ModelType, DataType, ResourceType, TranscodeType> m4291b(C0667c c0667c) {
        if (c0667c == null) {
            throw new NullPointerException("Signature must not be null");
        }
        this.f2392i = c0667c;
        return this;
    }

    public C0574e<ModelType, DataType, ResourceType, TranscodeType> m4292b(C0739e<DataType, ResourceType> c0739e) {
        if (this.f2390g != null) {
            this.f2390g.m5110a((C0739e) c0739e);
        }
        return this;
    }

    public C0574e<ModelType, DataType, ResourceType, TranscodeType> m4293b(C0866h<? super ModelType, TranscodeType> c0866h) {
        this.f2396m = c0866h;
        return this;
    }

    public C0574e<ModelType, DataType, ResourceType, TranscodeType> m4294b(ModelType modelType) {
        this.f2391h = modelType;
        this.f2393j = true;
        return this;
    }

    public C0574e<ModelType, DataType, ResourceType, TranscodeType> m4295b(boolean z) {
        this.f2403t = !z;
        return this;
    }

    public C0574e<ModelType, DataType, ResourceType, TranscodeType> m4296b(C0730g<ResourceType>... c0730gArr) {
        this.f2409z = true;
        if (c0730gArr.length == 1) {
            this.f2408y = c0730gArr[0];
        } else {
            this.f2408y = new C0807d(c0730gArr);
        }
        return this;
    }

    public C0848a<TranscodeType> m4297c(int i, int i2) {
        C0848a c0864f = new C0864f(this.f2386c.m5283g(), i, i2);
        this.f2386c.m5283g().post(new C0830f(this, c0864f));
        return c0864f;
    }

    public /* synthetic */ Object clone() {
        return m4300g();
    }

    void m4298e() {
    }

    void m4299f() {
    }

    public C0574e<ModelType, DataType, ResourceType, TranscodeType> m4300g() {
        try {
            C0574e<ModelType, DataType, ResourceType, TranscodeType> c0574e = (C0574e) super.clone();
            c0574e.f2390g = this.f2390g != null ? this.f2390g.m5116g() : null;
            return c0574e;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public C0574e<ModelType, DataType, ResourceType, TranscodeType> m4301h() {
        return m4283a(C0844g.m5141a());
    }
}
