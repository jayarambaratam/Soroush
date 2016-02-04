package android.support.design.widget;

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.ff;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;

/* renamed from: android.support.design.widget.r */
public abstract class C0071r<V extends View> {
    public C0071r(Context context, AttributeSet attributeSet) {
    }

    public Parcelable m198a(CoordinatorLayout coordinatorLayout, V v) {
        return BaseSavedState.EMPTY_STATE;
    }

    public ff m199a(CoordinatorLayout coordinatorLayout, V v, ff ffVar) {
        return ffVar;
    }

    public void m200a(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
    }

    public void m201a(CoordinatorLayout coordinatorLayout, V v, View view) {
    }

    public void m202a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4) {
    }

    public void m203a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr) {
    }

    public boolean m204a(CoordinatorLayout coordinatorLayout, V v, int i) {
        return false;
    }

    public boolean m205a(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3, int i4) {
        return false;
    }

    public boolean m206a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        return false;
    }

    public boolean m207a(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
        return false;
    }

    public boolean m208a(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2, boolean z) {
        return false;
    }

    public boolean m209a(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
        return false;
    }

    public final int m210b(CoordinatorLayout coordinatorLayout, V v) {
        return -16777216;
    }

    public void m211b(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
    }

    public boolean m212b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        return false;
    }

    public boolean m213b(CoordinatorLayout coordinatorLayout, V v, View view) {
        return false;
    }

    public final float m214c(CoordinatorLayout coordinatorLayout, V v) {
        return 0.0f;
    }

    public boolean m215c(CoordinatorLayout coordinatorLayout, V v, View view) {
        return false;
    }

    public void m216d(CoordinatorLayout coordinatorLayout, V v, View view) {
    }

    public boolean m217d(CoordinatorLayout coordinatorLayout, V v) {
        return m214c(coordinatorLayout, v) > 0.0f;
    }
}
