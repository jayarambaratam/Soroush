package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.view.View;
import android.view.WindowInsets;

class cy {
    public static ff m2717a(View view, ff ffVar) {
        if (!(ffVar instanceof fg)) {
            return ffVar;
        }
        WindowInsets g = ((fg) ffVar).m2911g();
        WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(g);
        return onApplyWindowInsets != g ? new fg(onApplyWindowInsets) : ffVar;
    }

    public static void m2718a(View view) {
        view.requestApplyInsets();
    }

    public static void m2719a(View view, float f) {
        view.setElevation(f);
    }

    static void m2720a(View view, ColorStateList colorStateList) {
        view.setBackgroundTintList(colorStateList);
    }

    static void m2721a(View view, Mode mode) {
        view.setBackgroundTintMode(mode);
    }

    public static void m2722a(View view, bs bsVar) {
        view.setOnApplyWindowInsetsListener(new cz(bsVar));
    }

    public static float m2723b(View view) {
        return view.getElevation();
    }

    public static ff m2724b(View view, ff ffVar) {
        if (!(ffVar instanceof fg)) {
            return ffVar;
        }
        WindowInsets g = ((fg) ffVar).m2911g();
        WindowInsets dispatchApplyWindowInsets = view.dispatchApplyWindowInsets(g);
        return dispatchApplyWindowInsets != g ? new fg(dispatchApplyWindowInsets) : ffVar;
    }

    public static float m2725c(View view) {
        return view.getTranslationZ();
    }

    public static boolean m2726d(View view) {
        return view.isNestedScrollingEnabled();
    }

    public static void m2727e(View view) {
        view.stopNestedScroll();
    }

    public static float m2728f(View view) {
        return view.getZ();
    }
}
