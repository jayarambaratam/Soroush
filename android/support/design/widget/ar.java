package android.support.design.widget;

import android.content.Context;
import android.support.v4.view.cb;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import java.util.List;

abstract class ar extends di<View> {
    public ar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    int m265a(View view) {
        return view.getMeasuredHeight();
    }

    abstract View m266a(List<View> list);

    public boolean m267a(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
        int i5 = view.getLayoutParams().height;
        if (i5 != -1 && i5 != -2) {
            return false;
        }
        List d = coordinatorLayout.m349d(view);
        if (d.isEmpty()) {
            return false;
        }
        View a = m266a(d);
        if (a == null || !cb.m2385D(a)) {
            return false;
        }
        if (cb.m2447x(a)) {
            cb.m2404a(view, true);
        }
        int size = MeasureSpec.getSize(i3);
        if (size == 0) {
            size = coordinatorLayout.getHeight();
        }
        coordinatorLayout.m334a(view, i, i2, MeasureSpec.makeMeasureSpec(m265a(a) + (size - a.getMeasuredHeight()), i5 == -1 ? 1073741824 : RtlSpacingHelper.UNDEFINED), i4);
        return true;
    }
}
