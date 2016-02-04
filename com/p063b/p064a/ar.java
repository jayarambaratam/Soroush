package com.p063b.p064a;

import java.util.List;
import org.apache.http.myHttp.HttpStatus;

/* renamed from: com.b.a.ar */
public class ar implements Cloneable {
    public Boolean f3263A;
    public Boolean f3264B;
    public bj f3265C;
    public Float f3266D;
    public String f3267E;
    public as f3268F;
    public String f3269G;
    public bj f3270H;
    public Float f3271I;
    public bj f3272J;
    public Float f3273K;
    public az f3274L;
    public long f3275a;
    public bj f3276b;
    public as f3277c;
    public Float f3278d;
    public bj f3279e;
    public Float f3280f;
    public ac f3281g;
    public au f3282h;
    public av f3283i;
    public Float f3284j;
    public ac[] f3285k;
    public ac f3286l;
    public Float f3287m;
    public C0934s f3288n;
    public List<String> f3289o;
    public ac f3290p;
    public Integer f3291q;
    public at f3292r;
    public ax f3293s;
    public ay f3294t;
    public aw f3295u;
    public Boolean f3296v;
    public C0931p f3297w;
    public String f3298x;
    public String f3299y;
    public String f3300z;

    protected ar() {
        this.f3275a = 0;
    }

    public static ar m5497a() {
        ar arVar = new ar();
        arVar.f3275a = -1;
        arVar.f3276b = C0934s.f3588b;
        arVar.f3277c = as.NonZero;
        arVar.f3278d = Float.valueOf(1.0f);
        arVar.f3279e = null;
        arVar.f3280f = Float.valueOf(1.0f);
        arVar.f3281g = new ac(1.0f);
        arVar.f3282h = au.Butt;
        arVar.f3283i = av.Miter;
        arVar.f3284j = Float.valueOf(4.0f);
        arVar.f3285k = null;
        arVar.f3286l = new ac(0.0f);
        arVar.f3287m = Float.valueOf(1.0f);
        arVar.f3288n = C0934s.f3588b;
        arVar.f3289o = null;
        arVar.f3290p = new ac(12.0f, by.pt);
        arVar.f3291q = Integer.valueOf(HttpStatus.SC_BAD_REQUEST);
        arVar.f3292r = at.Normal;
        arVar.f3293s = ax.None;
        arVar.f3294t = ay.LTR;
        arVar.f3295u = aw.Start;
        arVar.f3296v = Boolean.valueOf(true);
        arVar.f3297w = null;
        arVar.f3298x = null;
        arVar.f3299y = null;
        arVar.f3300z = null;
        arVar.f3263A = Boolean.TRUE;
        arVar.f3264B = Boolean.TRUE;
        arVar.f3265C = C0934s.f3588b;
        arVar.f3266D = Float.valueOf(1.0f);
        arVar.f3267E = null;
        arVar.f3268F = as.NonZero;
        arVar.f3269G = null;
        arVar.f3270H = null;
        arVar.f3271I = Float.valueOf(1.0f);
        arVar.f3272J = null;
        arVar.f3273K = Float.valueOf(1.0f);
        arVar.f3274L = az.None;
        return arVar;
    }

    public void m5498a(boolean z) {
        this.f3263A = Boolean.TRUE;
        this.f3296v = z ? Boolean.TRUE : Boolean.FALSE;
        this.f3297w = null;
        this.f3267E = null;
        this.f3287m = Float.valueOf(1.0f);
        this.f3265C = C0934s.f3588b;
        this.f3266D = Float.valueOf(1.0f);
        this.f3269G = null;
        this.f3270H = null;
        this.f3271I = Float.valueOf(1.0f);
        this.f3272J = null;
        this.f3273K = Float.valueOf(1.0f);
        this.f3274L = az.None;
    }

    protected Object clone() {
        try {
            ar arVar = (ar) super.clone();
            if (this.f3285k != null) {
                arVar.f3285k = (ac[]) this.f3285k.clone();
            }
            return arVar;
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e.toString());
        }
    }
}
