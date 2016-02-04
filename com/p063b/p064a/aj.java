package com.p063b.p064a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: com.b.a.aj */
public class aj implements ak {
    private List<Byte> f3245a;
    private List<Float> f3246b;

    public aj() {
        this.f3245a = null;
        this.f3246b = null;
        this.f3245a = new ArrayList();
        this.f3246b = new ArrayList();
    }

    public void m5485a(float f, float f2) {
        this.f3245a.add(Byte.valueOf((byte) 0));
        this.f3246b.add(Float.valueOf(f));
        this.f3246b.add(Float.valueOf(f2));
    }

    public void m5486a(float f, float f2, float f3, float f4) {
        this.f3245a.add(Byte.valueOf((byte) 3));
        this.f3246b.add(Float.valueOf(f));
        this.f3246b.add(Float.valueOf(f2));
        this.f3246b.add(Float.valueOf(f3));
        this.f3246b.add(Float.valueOf(f4));
    }

    public void m5487a(float f, float f2, float f3, float f4, float f5, float f6) {
        this.f3245a.add(Byte.valueOf((byte) 2));
        this.f3246b.add(Float.valueOf(f));
        this.f3246b.add(Float.valueOf(f2));
        this.f3246b.add(Float.valueOf(f3));
        this.f3246b.add(Float.valueOf(f4));
        this.f3246b.add(Float.valueOf(f5));
        this.f3246b.add(Float.valueOf(f6));
    }

    public void m5488a(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5) {
        int i = 0;
        int i2 = (z ? 2 : 0) | 4;
        if (z2) {
            i = 1;
        }
        this.f3245a.add(Byte.valueOf((byte) (i | i2)));
        this.f3246b.add(Float.valueOf(f));
        this.f3246b.add(Float.valueOf(f2));
        this.f3246b.add(Float.valueOf(f3));
        this.f3246b.add(Float.valueOf(f4));
        this.f3246b.add(Float.valueOf(f5));
    }

    public void m5489a(ak akVar) {
        Iterator it = this.f3246b.iterator();
        for (Byte byteValue : this.f3245a) {
            byte byteValue2 = byteValue.byteValue();
            switch (byteValue2) {
                case VideoSize.QCIF /*0*/:
                    akVar.m5479a(((Float) it.next()).floatValue(), ((Float) it.next()).floatValue());
                    break;
                case VideoSize.CIF /*1*/:
                    akVar.m5484b(((Float) it.next()).floatValue(), ((Float) it.next()).floatValue());
                    break;
                case VideoSize.HVGA /*2*/:
                    akVar.m5481a(((Float) it.next()).floatValue(), ((Float) it.next()).floatValue(), ((Float) it.next()).floatValue(), ((Float) it.next()).floatValue(), ((Float) it.next()).floatValue(), ((Float) it.next()).floatValue());
                    break;
                case Version.API03_CUPCAKE_15 /*3*/:
                    akVar.m5480a(((Float) it.next()).floatValue(), ((Float) it.next()).floatValue(), ((Float) it.next()).floatValue(), ((Float) it.next()).floatValue());
                    break;
                case Version.API08_FROYO_22 /*8*/:
                    akVar.m5483b();
                    break;
                default:
                    akVar.m5482a(((Float) it.next()).floatValue(), ((Float) it.next()).floatValue(), ((Float) it.next()).floatValue(), (byteValue2 & 2) != 0, (byteValue2 & 1) != 0, ((Float) it.next()).floatValue(), ((Float) it.next()).floatValue());
                    break;
            }
        }
    }

    public boolean m5490a() {
        return this.f3245a.isEmpty();
    }

    public void m5491b() {
        this.f3245a.add(Byte.valueOf((byte) 8));
    }

    public void m5492b(float f, float f2) {
        this.f3245a.add(Byte.valueOf((byte) 1));
        this.f3246b.add(Float.valueOf(f));
        this.f3246b.add(Float.valueOf(f2));
    }
}
