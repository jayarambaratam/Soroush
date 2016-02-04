package android.support.v4.view.p017a;

import android.view.accessibility.AccessibilityRecord;

/* renamed from: android.support.v4.view.a.as */
class as {
    public static Object m1924a() {
        return AccessibilityRecord.obtain();
    }

    public static void m1925a(Object obj, int i) {
        ((AccessibilityRecord) obj).setFromIndex(i);
    }

    public static void m1926a(Object obj, boolean z) {
        ((AccessibilityRecord) obj).setScrollable(z);
    }

    public static void m1927b(Object obj, int i) {
        ((AccessibilityRecord) obj).setItemCount(i);
    }

    public static void m1928c(Object obj, int i) {
        ((AccessibilityRecord) obj).setScrollX(i);
    }

    public static void m1929d(Object obj, int i) {
        ((AccessibilityRecord) obj).setScrollY(i);
    }

    public static void m1930e(Object obj, int i) {
        ((AccessibilityRecord) obj).setToIndex(i);
    }
}
