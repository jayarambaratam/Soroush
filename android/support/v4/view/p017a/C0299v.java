package android.support.v4.view.p017a;

import android.view.accessibility.AccessibilityNodeInfo;

/* renamed from: android.support.v4.view.a.v */
class C0299v {
    public static void m2189a(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setVisibleToUser(z);
    }

    public static boolean m2190a(Object obj) {
        return ((AccessibilityNodeInfo) obj).isVisibleToUser();
    }

    public static void m2191b(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setAccessibilityFocused(z);
    }

    public static boolean m2192b(Object obj) {
        return ((AccessibilityNodeInfo) obj).isAccessibilityFocused();
    }
}
