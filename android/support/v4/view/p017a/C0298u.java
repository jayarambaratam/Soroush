package android.support.v4.view.p017a;

import android.graphics.Rect;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;

/* renamed from: android.support.v4.view.a.u */
class C0298u {
    public static Object m2153a(Object obj) {
        return AccessibilityNodeInfo.obtain((AccessibilityNodeInfo) obj);
    }

    public static void m2154a(Object obj, int i) {
        ((AccessibilityNodeInfo) obj).addAction(i);
    }

    public static void m2155a(Object obj, Rect rect) {
        ((AccessibilityNodeInfo) obj).getBoundsInParent(rect);
    }

    public static void m2156a(Object obj, View view) {
        ((AccessibilityNodeInfo) obj).addChild(view);
    }

    public static void m2157a(Object obj, CharSequence charSequence) {
        ((AccessibilityNodeInfo) obj).setClassName(charSequence);
    }

    public static void m2158a(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setClickable(z);
    }

    public static int m2159b(Object obj) {
        return ((AccessibilityNodeInfo) obj).getActions();
    }

    public static void m2160b(Object obj, Rect rect) {
        ((AccessibilityNodeInfo) obj).getBoundsInScreen(rect);
    }

    public static void m2161b(Object obj, View view) {
        ((AccessibilityNodeInfo) obj).setParent(view);
    }

    public static void m2162b(Object obj, CharSequence charSequence) {
        ((AccessibilityNodeInfo) obj).setContentDescription(charSequence);
    }

    public static void m2163b(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setEnabled(z);
    }

    public static CharSequence m2164c(Object obj) {
        return ((AccessibilityNodeInfo) obj).getClassName();
    }

    public static void m2165c(Object obj, Rect rect) {
        ((AccessibilityNodeInfo) obj).setBoundsInParent(rect);
    }

    public static void m2166c(Object obj, View view) {
        ((AccessibilityNodeInfo) obj).setSource(view);
    }

    public static void m2167c(Object obj, CharSequence charSequence) {
        ((AccessibilityNodeInfo) obj).setPackageName(charSequence);
    }

    public static void m2168c(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setFocusable(z);
    }

    public static CharSequence m2169d(Object obj) {
        return ((AccessibilityNodeInfo) obj).getContentDescription();
    }

    public static void m2170d(Object obj, Rect rect) {
        ((AccessibilityNodeInfo) obj).setBoundsInScreen(rect);
    }

    public static void m2171d(Object obj, CharSequence charSequence) {
        ((AccessibilityNodeInfo) obj).setText(charSequence);
    }

    public static void m2172d(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setFocused(z);
    }

    public static CharSequence m2173e(Object obj) {
        return ((AccessibilityNodeInfo) obj).getPackageName();
    }

    public static void m2174e(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setLongClickable(z);
    }

    public static CharSequence m2175f(Object obj) {
        return ((AccessibilityNodeInfo) obj).getText();
    }

    public static void m2176f(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setScrollable(z);
    }

    public static void m2177g(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setSelected(z);
    }

    public static boolean m2178g(Object obj) {
        return ((AccessibilityNodeInfo) obj).isCheckable();
    }

    public static boolean m2179h(Object obj) {
        return ((AccessibilityNodeInfo) obj).isChecked();
    }

    public static boolean m2180i(Object obj) {
        return ((AccessibilityNodeInfo) obj).isClickable();
    }

    public static boolean m2181j(Object obj) {
        return ((AccessibilityNodeInfo) obj).isEnabled();
    }

    public static boolean m2182k(Object obj) {
        return ((AccessibilityNodeInfo) obj).isFocusable();
    }

    public static boolean m2183l(Object obj) {
        return ((AccessibilityNodeInfo) obj).isFocused();
    }

    public static boolean m2184m(Object obj) {
        return ((AccessibilityNodeInfo) obj).isLongClickable();
    }

    public static boolean m2185n(Object obj) {
        return ((AccessibilityNodeInfo) obj).isPassword();
    }

    public static boolean m2186o(Object obj) {
        return ((AccessibilityNodeInfo) obj).isScrollable();
    }

    public static boolean m2187p(Object obj) {
        return ((AccessibilityNodeInfo) obj).isSelected();
    }

    public static void m2188q(Object obj) {
        ((AccessibilityNodeInfo) obj).recycle();
    }
}
