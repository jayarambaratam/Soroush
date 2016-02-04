package android.support.v4.widget;

import android.util.Log;
import android.view.View;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class bx extends bw {
    private Method f1638a;
    private Field f1639b;

    bx() {
        try {
            this.f1638a = View.class.getDeclaredMethod("getDisplayList", (Class[]) null);
        } catch (Throwable e) {
            Log.e("SlidingPaneLayout", "Couldn't fetch getDisplayList method; dimming won't work right.", e);
        }
        try {
            this.f1639b = View.class.getDeclaredField("mRecreateDisplayList");
            this.f1639b.setAccessible(true);
        } catch (Throwable e2) {
            Log.e("SlidingPaneLayout", "Couldn't fetch mRecreateDisplayList field; dimming will be slow.", e2);
        }
    }

    public void m3339a(SlidingPaneLayout slidingPaneLayout, View view) {
        if (this.f1638a == null || this.f1639b == null) {
            view.invalidate();
            return;
        }
        try {
            this.f1639b.setBoolean(view, true);
            this.f1638a.invoke(view, (Object[]) null);
        } catch (Throwable e) {
            Log.e("SlidingPaneLayout", "Error refreshing display list state", e);
        }
        super.m3338a(slidingPaneLayout, view);
    }
}
