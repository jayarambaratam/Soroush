package jp.wasabeef.recyclerview.animators.internal;

import android.support.v4.view.cb;
import android.view.View;

public final class ViewHelper {
    public static void clear(View view) {
        cb.m2413c(view, 1.0f);
        cb.m2429h(view, 1.0f);
        cb.m2427g(view, 1.0f);
        cb.m2408b(view, 0.0f);
        cb.m2393a(view, 0.0f);
        cb.m2418d(view, 0.0f);
        cb.m2424f(view, 0.0f);
        cb.m2421e(view, 0.0f);
        view.setPivotY((float) (view.getMeasuredHeight() / 2));
        cb.m2431i(view, (float) (view.getMeasuredWidth() / 2));
        cb.m2442s(view).m2802a(null);
    }
}
