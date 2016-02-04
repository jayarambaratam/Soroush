package at.grabner.circleprogress;

/* renamed from: at.grabner.circleprogress.a */
/* synthetic */ class C0534a {
    static final /* synthetic */ int[] f2264a;
    static final /* synthetic */ int[] f2265b;

    static {
        f2265b = new int[C0537d.values().length];
        try {
            f2265b[C0537d.IDLE.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f2265b[C0537d.SPINNING.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f2265b[C0537d.END_SPINNING.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f2265b[C0537d.END_SPINNING_START_ANIMATING.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f2265b[C0537d.ANIMATING.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
        f2264a = new int[C0536c.values().length];
        try {
            f2264a[C0536c.START_SPINNING.ordinal()] = 1;
        } catch (NoSuchFieldError e6) {
        }
        try {
            f2264a[C0536c.STOP_SPINNING.ordinal()] = 2;
        } catch (NoSuchFieldError e7) {
        }
        try {
            f2264a[C0536c.SET_VALUE.ordinal()] = 3;
        } catch (NoSuchFieldError e8) {
        }
        try {
            f2264a[C0536c.SET_VALUE_ANIMATED.ordinal()] = 4;
        } catch (NoSuchFieldError e9) {
        }
        try {
            f2264a[C0536c.TICK.ordinal()] = 5;
        } catch (NoSuchFieldError e10) {
        }
    }
}
