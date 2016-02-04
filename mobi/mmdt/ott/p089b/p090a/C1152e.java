package mobi.mmdt.ott.p089b.p090a;

import mobi.mmdt.ott.p089b.C1161e;
import mobi.mmdt.ott.p089b.C1162g;
import org.jivesoftware.smack.packet.Presence.Type;
import org.jivesoftware.smackx.chatstates.ChatState;

/* renamed from: mobi.mmdt.ott.b.a.e */
/* synthetic */ class C1152e {
    static final /* synthetic */ int[] f4226a;
    static final /* synthetic */ int[] f4227b;
    static final /* synthetic */ int[] f4228c;
    static final /* synthetic */ int[] f4229d;

    static {
        f4229d = new int[Type.values().length];
        try {
            f4229d[Type.available.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f4229d[Type.unavailable.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        f4228c = new int[ChatState.values().length];
        try {
            f4228c[ChatState.composing.ordinal()] = 1;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f4228c[ChatState.gone.ordinal()] = 2;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f4228c[ChatState.inactive.ordinal()] = 3;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f4228c[ChatState.paused.ordinal()] = 4;
        } catch (NoSuchFieldError e6) {
        }
        try {
            f4228c[ChatState.active.ordinal()] = 5;
        } catch (NoSuchFieldError e7) {
        }
        f4227b = new int[C1161e.values().length];
        try {
            f4227b[C1161e.Admin.ordinal()] = 1;
        } catch (NoSuchFieldError e8) {
        }
        try {
            f4227b[C1161e.Member.ordinal()] = 2;
        } catch (NoSuchFieldError e9) {
        }
        try {
            f4227b[C1161e.Outcast.ordinal()] = 3;
        } catch (NoSuchFieldError e10) {
        }
        try {
            f4227b[C1161e.Owner.ordinal()] = 4;
        } catch (NoSuchFieldError e11) {
        }
        f4226a = new int[C1162g.values().length];
        try {
            f4226a[C1162g.INACTIVE.ordinal()] = 1;
        } catch (NoSuchFieldError e12) {
        }
        try {
            f4226a[C1162g.PAUSED.ordinal()] = 2;
        } catch (NoSuchFieldError e13) {
        }
        try {
            f4226a[C1162g.COMPOSING.ordinal()] = 3;
        } catch (NoSuchFieldError e14) {
        }
        try {
            f4226a[C1162g.GONE.ordinal()] = 4;
        } catch (NoSuchFieldError e15) {
        }
        try {
            f4226a[C1162g.ACTIVE.ordinal()] = 5;
        } catch (NoSuchFieldError e16) {
        }
    }
}
