package android.support.v4.view;

import android.animation.ValueAnimator;
import android.graphics.Paint;
import android.view.View;

class cs {
    public static float m2666a(View view) {
        return view.getAlpha();
    }

    public static int m2667a(int i, int i2) {
        return View.combineMeasuredStates(i, i2);
    }

    public static int m2668a(int i, int i2, int i3) {
        return View.resolveSizeAndState(i, i2, i3);
    }

    static long m2669a() {
        return ValueAnimator.getFrameDelay();
    }

    public static void m2670a(View view, float f) {
        view.setTranslationX(f);
    }

    public static void m2671a(View view, int i, Paint paint) {
        view.setLayerType(i, paint);
    }

    public static void m2672a(View view, boolean z) {
        view.setSaveFromParentEnabled(z);
    }

    public static int m2673b(View view) {
        return view.getLayerType();
    }

    public static void m2674b(View view, float f) {
        view.setTranslationY(f);
    }

    public static void m2675b(View view, boolean z) {
        view.setActivated(z);
    }

    public static int m2676c(View view) {
        return view.getMeasuredWidthAndState();
    }

    public static void m2677c(View view, float f) {
        view.setAlpha(f);
    }

    public static int m2678d(View view) {
        return view.getMeasuredState();
    }

    public static void m2679d(View view, float f) {
        view.setRotation(f);
    }

    public static float m2680e(View view) {
        return view.getTranslationX();
    }

    public static void m2681e(View view, float f) {
        view.setRotationX(f);
    }

    public static float m2682f(View view) {
        return view.getTranslationY();
    }

    public static void m2683f(View view, float f) {
        view.setRotationY(f);
    }

    public static float m2684g(View view) {
        return view.getScaleX();
    }

    public static void m2685g(View view, float f) {
        view.setScaleX(f);
    }

    public static void m2686h(View view) {
        view.jumpDrawablesToCurrentState();
    }

    public static void m2687h(View view, float f) {
        view.setScaleY(f);
    }

    public static void m2688i(View view, float f) {
        view.setPivotX(f);
    }
}
