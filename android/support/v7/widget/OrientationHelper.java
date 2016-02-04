package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.View;

public abstract class OrientationHelper {
    public static final int HORIZONTAL = 0;
    private static final int INVALID_SIZE = Integer.MIN_VALUE;
    public static final int VERTICAL = 1;
    private int mLastTotalSpace;
    protected final LayoutManager mLayoutManager;

    /* renamed from: android.support.v7.widget.OrientationHelper.1 */
    final class C04931 extends OrientationHelper {
        C04931(LayoutManager layoutManager) {
            super(null);
        }

        public int getDecoratedEnd(View view) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            return layoutParams.rightMargin + this.mLayoutManager.getDecoratedRight(view);
        }

        public int getDecoratedMeasurement(View view) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            return layoutParams.rightMargin + (this.mLayoutManager.getDecoratedMeasuredWidth(view) + layoutParams.leftMargin);
        }

        public int getDecoratedMeasurementInOther(View view) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            return layoutParams.bottomMargin + (this.mLayoutManager.getDecoratedMeasuredHeight(view) + layoutParams.topMargin);
        }

        public int getDecoratedStart(View view) {
            return this.mLayoutManager.getDecoratedLeft(view) - ((LayoutParams) view.getLayoutParams()).leftMargin;
        }

        public int getEnd() {
            return this.mLayoutManager.getWidth();
        }

        public int getEndAfterPadding() {
            return this.mLayoutManager.getWidth() - this.mLayoutManager.getPaddingRight();
        }

        public int getEndPadding() {
            return this.mLayoutManager.getPaddingRight();
        }

        public int getStartAfterPadding() {
            return this.mLayoutManager.getPaddingLeft();
        }

        public int getTotalSpace() {
            return (this.mLayoutManager.getWidth() - this.mLayoutManager.getPaddingLeft()) - this.mLayoutManager.getPaddingRight();
        }

        public void offsetChild(View view, int i) {
            view.offsetLeftAndRight(i);
        }

        public void offsetChildren(int i) {
            this.mLayoutManager.offsetChildrenHorizontal(i);
        }
    }

    /* renamed from: android.support.v7.widget.OrientationHelper.2 */
    final class C04942 extends OrientationHelper {
        C04942(LayoutManager layoutManager) {
            super(null);
        }

        public int getDecoratedEnd(View view) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            return layoutParams.bottomMargin + this.mLayoutManager.getDecoratedBottom(view);
        }

        public int getDecoratedMeasurement(View view) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            return layoutParams.bottomMargin + (this.mLayoutManager.getDecoratedMeasuredHeight(view) + layoutParams.topMargin);
        }

        public int getDecoratedMeasurementInOther(View view) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            return layoutParams.rightMargin + (this.mLayoutManager.getDecoratedMeasuredWidth(view) + layoutParams.leftMargin);
        }

        public int getDecoratedStart(View view) {
            return this.mLayoutManager.getDecoratedTop(view) - ((LayoutParams) view.getLayoutParams()).topMargin;
        }

        public int getEnd() {
            return this.mLayoutManager.getHeight();
        }

        public int getEndAfterPadding() {
            return this.mLayoutManager.getHeight() - this.mLayoutManager.getPaddingBottom();
        }

        public int getEndPadding() {
            return this.mLayoutManager.getPaddingBottom();
        }

        public int getStartAfterPadding() {
            return this.mLayoutManager.getPaddingTop();
        }

        public int getTotalSpace() {
            return (this.mLayoutManager.getHeight() - this.mLayoutManager.getPaddingTop()) - this.mLayoutManager.getPaddingBottom();
        }

        public void offsetChild(View view, int i) {
            view.offsetTopAndBottom(i);
        }

        public void offsetChildren(int i) {
            this.mLayoutManager.offsetChildrenVertical(i);
        }
    }

    private OrientationHelper(LayoutManager layoutManager) {
        this.mLastTotalSpace = INVALID_SIZE;
        this.mLayoutManager = layoutManager;
    }

    public static OrientationHelper createHorizontalHelper(LayoutManager layoutManager) {
        return new C04931(layoutManager);
    }

    public static OrientationHelper createOrientationHelper(LayoutManager layoutManager, int i) {
        switch (i) {
            case HORIZONTAL /*0*/:
                return createHorizontalHelper(layoutManager);
            case VERTICAL /*1*/:
                return createVerticalHelper(layoutManager);
            default:
                throw new IllegalArgumentException("invalid orientation");
        }
    }

    public static OrientationHelper createVerticalHelper(LayoutManager layoutManager) {
        return new C04942(layoutManager);
    }

    public abstract int getDecoratedEnd(View view);

    public abstract int getDecoratedMeasurement(View view);

    public abstract int getDecoratedMeasurementInOther(View view);

    public abstract int getDecoratedStart(View view);

    public abstract int getEnd();

    public abstract int getEndAfterPadding();

    public abstract int getEndPadding();

    public abstract int getStartAfterPadding();

    public abstract int getTotalSpace();

    public int getTotalSpaceChange() {
        return INVALID_SIZE == this.mLastTotalSpace ? HORIZONTAL : getTotalSpace() - this.mLastTotalSpace;
    }

    public abstract void offsetChild(View view, int i);

    public abstract void offsetChildren(int i);

    public void onLayoutComplete() {
        this.mLastTotalSpace = getTotalSpace();
    }
}
