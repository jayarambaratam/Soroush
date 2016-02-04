package android.support.v4.view.p017a;

import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityEvent;

/* renamed from: android.support.v4.view.a.a */
public class C0278a {
    private static final C0279e f1285a;

    static {
        if (VERSION.SDK_INT >= 19) {
            f1285a = new C0282c();
        } else if (VERSION.SDK_INT >= 14) {
            f1285a = new C0281b();
        } else {
            f1285a = new C0280d();
        }
    }

    public static am m1865a(AccessibilityEvent accessibilityEvent) {
        return new am(accessibilityEvent);
    }

    public static void m1866a(AccessibilityEvent accessibilityEvent, int i) {
        f1285a.m1934a(accessibilityEvent, i);
    }

    public static int m1867b(AccessibilityEvent accessibilityEvent) {
        return f1285a.m1933a(accessibilityEvent);
    }
}
