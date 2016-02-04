package android.support.v4.view;

import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

class fa {
    public static void m2895a(View view, fe feVar) {
        AnimatorUpdateListener animatorUpdateListener = null;
        if (feVar != null) {
            animatorUpdateListener = new fb(feVar, view);
        }
        view.animate().setUpdateListener(animatorUpdateListener);
    }
}
