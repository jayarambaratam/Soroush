package android.support.v4.view;

import android.view.KeyEvent;

class ag {
    public static int m2221a(int i) {
        return KeyEvent.normalizeMetaState(i);
    }

    public static boolean m2222a(int i, int i2) {
        return KeyEvent.metaStateHasModifiers(i, i2);
    }

    public static boolean m2223b(int i) {
        return KeyEvent.metaStateHasNoModifiers(i);
    }
}
