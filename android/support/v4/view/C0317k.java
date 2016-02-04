package android.support.v4.view;

import android.os.Bundle;
import android.view.View;
import android.view.View.AccessibilityDelegate;

/* renamed from: android.support.v4.view.k */
class C0317k {
    public static Object m2921a(C0313m c0313m) {
        return new C0318l(c0313m);
    }

    public static Object m2922a(Object obj, View view) {
        return ((AccessibilityDelegate) obj).getAccessibilityNodeProvider(view);
    }

    public static boolean m2923a(Object obj, View view, int i, Bundle bundle) {
        return ((AccessibilityDelegate) obj).performAccessibilityAction(view, i, bundle);
    }
}
