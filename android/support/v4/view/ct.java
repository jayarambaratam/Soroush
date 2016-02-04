package android.support.v4.view;

import android.view.View;
import android.view.View.AccessibilityDelegate;

class ct {
    public static void m2689a(View view, Object obj) {
        view.setAccessibilityDelegate((AccessibilityDelegate) obj);
    }

    public static void m2690a(View view, boolean z) {
        view.setFitsSystemWindows(z);
    }

    public static boolean m2691a(View view, int i) {
        return view.canScrollHorizontally(i);
    }

    public static boolean m2692b(View view, int i) {
        return view.canScrollVertically(i);
    }
}
