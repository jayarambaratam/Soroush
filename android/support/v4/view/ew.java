package android.support.v4.view;

import android.view.View;
import android.view.animation.Interpolator;

class ew {
    public static long m2862a(View view) {
        return view.animate().getDuration();
    }

    public static void m2863a(View view, float f) {
        view.animate().alpha(f);
    }

    public static void m2864a(View view, long j) {
        view.animate().setDuration(j);
    }

    public static void m2865a(View view, fc fcVar) {
        if (fcVar != null) {
            view.animate().setListener(new ex(fcVar, view));
        } else {
            view.animate().setListener(null);
        }
    }

    public static void m2866a(View view, Interpolator interpolator) {
        view.animate().setInterpolator(interpolator);
    }

    public static void m2867b(View view) {
        view.animate().cancel();
    }

    public static void m2868b(View view, float f) {
        view.animate().translationX(f);
    }

    public static void m2869b(View view, long j) {
        view.animate().setStartDelay(j);
    }

    public static void m2870c(View view) {
        view.animate().start();
    }

    public static void m2871c(View view, float f) {
        view.animate().translationY(f);
    }

    public static void m2872d(View view, float f) {
        view.animate().rotationX(f);
    }

    public static void m2873e(View view, float f) {
        view.animate().rotationY(f);
    }

    public static void m2874f(View view, float f) {
        view.animate().scaleX(f);
    }

    public static void m2875g(View view, float f) {
        view.animate().scaleY(f);
    }
}
