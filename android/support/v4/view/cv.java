package android.support.v4.view;

import android.view.View;
import android.view.ViewParent;

class cv {
    public static void m2694a(View view, int i) {
        view.setImportantForAccessibility(i);
    }

    public static void m2695a(View view, int i, int i2, int i3, int i4) {
        view.postInvalidate(i, i2, i3, i4);
    }

    public static void m2696a(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    public static void m2697a(View view, Runnable runnable, long j) {
        view.postOnAnimationDelayed(runnable, j);
    }

    public static boolean m2698a(View view) {
        return view.hasTransientState();
    }

    public static void m2699b(View view) {
        view.postInvalidateOnAnimation();
    }

    public static int m2700c(View view) {
        return view.getImportantForAccessibility();
    }

    public static ViewParent m2701d(View view) {
        return view.getParentForAccessibility();
    }

    public static int m2702e(View view) {
        return view.getMinimumWidth();
    }

    public static int m2703f(View view) {
        return view.getMinimumHeight();
    }

    public static void m2704g(View view) {
        view.requestFitSystemWindows();
    }

    public static boolean m2705h(View view) {
        return view.getFitsSystemWindows();
    }

    public static boolean m2706i(View view) {
        return view.hasOverlappingRendering();
    }
}
