package android.support.design.widget;

import android.support.v4.view.cb;
import android.view.View;
import java.util.Comparator;

/* renamed from: android.support.design.widget.x */
class C0098x implements Comparator<View> {
    C0098x() {
    }

    public int m846a(View view, View view2) {
        float E = cb.m2386E(view);
        float E2 = cb.m2386E(view2);
        return E > E2 ? -1 : E < E2 ? 1 : 0;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m846a((View) obj, (View) obj2);
    }
}
