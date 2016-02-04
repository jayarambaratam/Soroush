package android.support.v4.p012b;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Build.VERSION;

/* renamed from: android.support.v4.b.n */
public class C0168n {
    private static final C0169o f1088a;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 15) {
            f1088a = new C0172r();
        } else if (i >= 11) {
            f1088a = new C0171q();
        } else {
            f1088a = new C0170p();
        }
    }

    public static Intent m1535a(ComponentName componentName) {
        return f1088a.m1536a(componentName);
    }
}
