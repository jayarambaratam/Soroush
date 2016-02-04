package mobi.mmdt.ott.view.conversation.p215c.p216a.p219c;

import mobi.mmdt.ott.provider.p169c.C1593m;
import mobi.mmdt.ott.provider.p170d.C1604i;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.c.l */
/* synthetic */ class C2091l {
    static final /* synthetic */ int[] f6860a;
    static final /* synthetic */ int[] f6861b;

    static {
        f6861b = new int[C1593m.values().length];
        try {
            f6861b[C1593m.SENDING.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f6861b[C1593m.PENDING.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f6861b[C1593m.PENDING_RETRANSMIT.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f6861b[C1593m.DELIVERED.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f6861b[C1593m.NOT_SEEN.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f6861b[C1593m.SEEN.ordinal()] = 6;
        } catch (NoSuchFieldError e6) {
        }
        try {
            f6861b[C1593m.NOT_READ.ordinal()] = 7;
        } catch (NoSuchFieldError e7) {
        }
        try {
            f6861b[C1593m.READ.ordinal()] = 8;
        } catch (NoSuchFieldError e8) {
        }
        try {
            f6861b[C1593m.DRAFT.ordinal()] = 9;
        } catch (NoSuchFieldError e9) {
        }
        f6860a = new int[C1604i.values().length];
        try {
            f6860a[C1604i.NOT_STARTED.ordinal()] = 1;
        } catch (NoSuchFieldError e10) {
        }
        try {
            f6860a[C1604i.TRANSMITTING.ordinal()] = 2;
        } catch (NoSuchFieldError e11) {
        }
        try {
            f6860a[C1604i.CANCEL.ordinal()] = 3;
        } catch (NoSuchFieldError e12) {
        }
        try {
            f6860a[C1604i.ERROR.ordinal()] = 4;
        } catch (NoSuchFieldError e13) {
        }
        try {
            f6860a[C1604i.FINISHED.ordinal()] = 5;
        } catch (NoSuchFieldError e14) {
        }
        try {
            f6860a[C1604i.DELETED.ordinal()] = 6;
        } catch (NoSuchFieldError e15) {
        }
    }
}
