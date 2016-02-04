package com.p063b.p064a;

import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: com.b.a.ac */
public class ac implements Cloneable {
    private static /* synthetic */ int[] f3215c;
    float f3216a;
    by f3217b;

    public ac(float f) {
        this.f3216a = 0.0f;
        this.f3217b = by.px;
        this.f3216a = f;
        this.f3217b = by.px;
    }

    public ac(float f, by byVar) {
        this.f3216a = 0.0f;
        this.f3217b = by.px;
        this.f3216a = f;
        this.f3217b = byVar;
    }

    static /* synthetic */ int[] m5459d() {
        int[] iArr = f3215c;
        if (iArr == null) {
            iArr = new int[by.values().length];
            try {
                iArr[by.cm.ordinal()] = 5;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[by.em.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[by.ex.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[by.in.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[by.mm.ordinal()] = 6;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[by.pc.ordinal()] = 8;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[by.percent.ordinal()] = 9;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[by.pt.ordinal()] = 7;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr[by.px.ordinal()] = 1;
            } catch (NoSuchFieldError e9) {
            }
            f3215c = iArr;
        }
        return iArr;
    }

    public float m5460a() {
        return this.f3216a;
    }

    public float m5461a(float f) {
        switch (ac.m5459d()[this.f3217b.ordinal()]) {
            case VideoSize.CIF /*1*/:
                return this.f3216a;
            case Version.API04_DONUT_16 /*4*/:
                return this.f3216a * f;
            case Version.API05_ECLAIR_20 /*5*/:
                return (this.f3216a * f) / 2.54f;
            case Version.API06_ECLAIR_201 /*6*/:
                return (this.f3216a * f) / 25.4f;
            case Version.API07_ECLAIR_21 /*7*/:
                return (this.f3216a * f) / 72.0f;
            case Version.API08_FROYO_22 /*8*/:
                return (this.f3216a * f) / 6.0f;
            default:
                return this.f3216a;
        }
    }

    public float m5462a(cb cbVar) {
        switch (ac.m5459d()[this.f3217b.ordinal()]) {
            case VideoSize.CIF /*1*/:
                return this.f3216a;
            case VideoSize.HVGA /*2*/:
                return this.f3216a * cbVar.m5616b();
            case Version.API03_CUPCAKE_15 /*3*/:
                return this.f3216a * cbVar.m5617c();
            case Version.API04_DONUT_16 /*4*/:
                return this.f3216a * cbVar.m5614a();
            case Version.API05_ECLAIR_20 /*5*/:
                return (this.f3216a * cbVar.m5614a()) / 2.54f;
            case Version.API06_ECLAIR_201 /*6*/:
                return (this.f3216a * cbVar.m5614a()) / 25.4f;
            case Version.API07_ECLAIR_21 /*7*/:
                return (this.f3216a * cbVar.m5614a()) / 72.0f;
            case Version.API08_FROYO_22 /*8*/:
                return (this.f3216a * cbVar.m5614a()) / 6.0f;
            case Version.API09_GINGERBREAD_23 /*9*/:
                C0930o d = cbVar.m5618d();
                if (d == null) {
                    return this.f3216a;
                }
                return (d.f3578c * this.f3216a) / 100.0f;
            default:
                return this.f3216a;
        }
    }

    public float m5463a(cb cbVar, float f) {
        return this.f3217b == by.percent ? (this.f3216a * f) / 100.0f : m5462a(cbVar);
    }

    public float m5464b(cb cbVar) {
        if (this.f3217b != by.percent) {
            return m5462a(cbVar);
        }
        C0930o d = cbVar.m5618d();
        if (d == null) {
            return this.f3216a;
        }
        return (d.f3579d * this.f3216a) / 100.0f;
    }

    public boolean m5465b() {
        return this.f3216a == 0.0f;
    }

    public float m5466c(cb cbVar) {
        if (this.f3217b != by.percent) {
            return m5462a(cbVar);
        }
        C0930o d = cbVar.m5618d();
        if (d == null) {
            return this.f3216a;
        }
        float f = d.f3578c;
        float f2 = d.f3579d;
        if (f == f2) {
            return (this.f3216a * f) / 100.0f;
        }
        return (((float) (Math.sqrt((double) ((f2 * f2) + (f * f))) / 1.414213562373095d)) * this.f3216a) / 100.0f;
    }

    public boolean m5467c() {
        return this.f3216a < 0.0f;
    }

    public String toString() {
        return new StringBuilder(String.valueOf(String.valueOf(this.f3216a))).append(this.f3217b).toString();
    }
}
