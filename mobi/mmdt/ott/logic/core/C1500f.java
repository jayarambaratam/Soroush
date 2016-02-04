package mobi.mmdt.ott.logic.core;

import mobi.mmdt.ott.logic.p156c.C1492b;
import mobi.mmdt.ott.logic.p161g.C1529b;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.ar;

/* renamed from: mobi.mmdt.ott.logic.core.f */
/* synthetic */ class C1500f {
    static final /* synthetic */ int[] f5055a;
    static final /* synthetic */ int[] f5056b;
    static final /* synthetic */ int[] f5057c;

    static {
        f5057c = new int[C1492b.values().length];
        try {
            f5057c[C1492b.TCP.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f5057c[C1492b.TLS.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f5057c[C1492b.UDP.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        f5056b = new int[C1529b.values().length];
        try {
            f5056b[C1529b.TCP.ordinal()] = 1;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f5056b[C1529b.TLS.ordinal()] = 2;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f5056b[C1529b.UDP.ordinal()] = 3;
        } catch (NoSuchFieldError e6) {
        }
        f5055a = new int[ar.values().length];
        try {
            f5055a[ar.Chat.ordinal()] = 1;
        } catch (NoSuchFieldError e7) {
        }
        try {
            f5055a[ar.Voip.ordinal()] = 2;
        } catch (NoSuchFieldError e8) {
        }
    }
}
