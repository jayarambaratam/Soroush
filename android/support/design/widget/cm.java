package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.C0039c;

class cm {
    private static final int[] f562a;

    static {
        f562a = new int[]{C0039c.colorPrimary};
    }

    static void m677a(Context context) {
        int i = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(f562a);
        if (!obtainStyledAttributes.hasValue(0)) {
            i = 1;
        }
        if (obtainStyledAttributes != null) {
            obtainStyledAttributes.recycle();
        }
        if (i != 0) {
            throw new IllegalArgumentException("You need to use a Theme.AppCompat theme (or descendant) with the design library.");
        }
    }
}
