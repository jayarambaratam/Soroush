package com.p063b.p064a;

import java.util.ArrayList;
import java.util.List;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: com.b.a.j */
class C0925j {
    private static /* synthetic */ int[] f3539e;
    public C0920e f3540a;
    public String f3541b;
    public List<C0915b> f3542c;
    public List<String> f3543d;

    public C0925j(C0920e c0920e, String str) {
        this.f3540a = null;
        this.f3541b = null;
        this.f3542c = null;
        this.f3543d = null;
        if (c0920e == null) {
            c0920e = C0920e.DESCENDANT;
        }
        this.f3540a = c0920e;
        this.f3541b = str;
    }

    static /* synthetic */ int[] m5783a() {
        int[] iArr = f3539e;
        if (iArr == null) {
            iArr = new int[C0918c.values().length];
            try {
                iArr[C0918c.DASHMATCH.ordinal()] = 4;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[C0918c.EQUALS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[C0918c.EXISTS.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[C0918c.INCLUDES.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            f3539e = iArr;
        }
        return iArr;
    }

    public void m5784a(String str) {
        if (this.f3543d == null) {
            this.f3543d = new ArrayList();
        }
        this.f3543d.add(str);
    }

    public void m5785a(String str, C0918c c0918c, String str2) {
        if (this.f3542c == null) {
            this.f3542c = new ArrayList();
        }
        this.f3542c.add(new C0915b(str, c0918c, str2));
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.f3540a == C0920e.CHILD) {
            stringBuilder.append("> ");
        } else if (this.f3540a == C0920e.FOLLOWS) {
            stringBuilder.append("+ ");
        }
        stringBuilder.append(this.f3541b == null ? "*" : this.f3541b);
        if (this.f3542c != null) {
            for (C0915b c0915b : this.f3542c) {
                stringBuilder.append('[').append(c0915b.f3332a);
                switch (C0925j.m5783a()[c0915b.f3333b.ordinal()]) {
                    case VideoSize.HVGA /*2*/:
                        stringBuilder.append('=').append(c0915b.f3334c);
                        break;
                    case Version.API03_CUPCAKE_15 /*3*/:
                        stringBuilder.append("~=").append(c0915b.f3334c);
                        break;
                    case Version.API04_DONUT_16 /*4*/:
                        stringBuilder.append("|=").append(c0915b.f3334c);
                        break;
                    default:
                        break;
                }
                stringBuilder.append(']');
            }
        }
        if (this.f3543d != null) {
            for (String append : this.f3543d) {
                stringBuilder.append(':').append(append);
            }
        }
        return stringBuilder.toString();
    }
}
