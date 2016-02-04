package android.support.v4.view;

import android.view.View;
import android.view.ViewParent;

class ej implements eg {
    ej() {
    }

    public void m2772a(ViewParent viewParent, View view) {
        if (viewParent instanceof bq) {
            ((bq) viewParent).onStopNestedScroll(view);
        }
    }

    public void m2773a(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
        if (viewParent instanceof bq) {
            ((bq) viewParent).onNestedScroll(view, i, i2, i3, i4);
        }
    }

    public void m2774a(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
        if (viewParent instanceof bq) {
            ((bq) viewParent).onNestedPreScroll(view, i, i2, iArr);
        }
    }

    public boolean m2775a(ViewParent viewParent, View view, float f, float f2) {
        return viewParent instanceof bq ? ((bq) viewParent).onNestedPreFling(view, f, f2) : false;
    }

    public boolean m2776a(ViewParent viewParent, View view, float f, float f2, boolean z) {
        return viewParent instanceof bq ? ((bq) viewParent).onNestedFling(view, f, f2, z) : false;
    }

    public boolean m2777a(ViewParent viewParent, View view, View view2, int i) {
        return viewParent instanceof bq ? ((bq) viewParent).onStartNestedScroll(view, view2, i) : false;
    }

    public void m2778b(ViewParent viewParent, View view, View view2, int i) {
        if (viewParent instanceof bq) {
            ((bq) viewParent).onNestedScrollAccepted(view, view2, i);
        }
    }
}
