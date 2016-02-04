package mobi.mmdt.ott.view.registeration.phoneandcountry.countryselection.components;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.View;

/* renamed from: mobi.mmdt.ott.view.registeration.phoneandcountry.countryselection.components.h */
class C2464h extends LinearSmoothScroller {
    final /* synthetic */ C2463g f8024a;

    C2464h(C2463g c2463g, Context context) {
        this.f8024a = c2463g;
        super(context);
    }

    public int calculateDyToMakeVisible(View view, int i) {
        int i2 = 0;
        LayoutManager layoutManager = getLayoutManager();
        if (!layoutManager.canScrollVertically()) {
            return 0;
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int decoratedTop = layoutManager.getDecoratedTop(view) - layoutParams.topMargin;
        int decoratedBottom = layoutManager.getDecoratedBottom(view) + layoutParams.bottomMargin;
        if (this.f8024a.f8023c.getPosition(view) == 0) {
            i2 = layoutManager.getPaddingTop();
        }
        int calculateDtToFit = calculateDtToFit(decoratedTop, decoratedBottom, i2, layoutManager.getHeight() - layoutManager.getPaddingBottom(), i);
        if (calculateDtToFit == 0) {
            calculateDtToFit = 1;
        }
        return calculateDtToFit;
    }

    public PointF computeScrollVectorForPosition(int i) {
        return getChildCount() == 0 ? null : new PointF(0.0f, (float) this.f8024a.f8023c.m10710c(i));
    }

    protected int getVerticalSnapPreference() {
        return -1;
    }

    protected void onChildAttachedToWindow(View view) {
        super.onChildAttachedToWindow(view);
    }

    protected void onStop() {
        super.onStop();
        this.f8024a.f8023c.requestLayout();
    }
}
