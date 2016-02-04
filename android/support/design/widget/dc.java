package android.support.design.widget;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;

class dc {
    private static final de f588a;

    static {
        if (VERSION.SDK_INT >= 11) {
            f588a = new dg();
        } else {
            f588a = new df();
        }
    }

    static void m742a(ViewGroup viewGroup, View view, Rect rect) {
        f588a.m744a(viewGroup, view, rect);
    }

    static void m743b(ViewGroup viewGroup, View view, Rect rect) {
        rect.set(0, 0, view.getWidth(), view.getHeight());
        m742a(viewGroup, view, rect);
    }
}
