package com.felipecsl.asymmetricgridview.library.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;

/* renamed from: com.felipecsl.asymmetricgridview.library.widget.g */
public class C1062g extends C1061i {
    private static final int[] f3995a;
    private Drawable f3996b;
    private int f3997c;
    private int f3998d;
    private int f3999e;
    private int f4000f;

    static {
        f3995a = new int[]{16843049, 16843561, 16843562};
    }

    public C1062g(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f3995a);
        setDividerDrawable(obtainStyledAttributes.getDrawable(0));
        this.f3999e = obtainStyledAttributes.getInt(1, 0);
        this.f4000f = obtainStyledAttributes.getDimensionPixelSize(2, 0);
        obtainStyledAttributes.recycle();
    }

    void m6291a(Canvas canvas) {
        int childCount = getChildCount();
        int i = 0;
        while (i < childCount) {
            View childAt = getChildAt(i);
            if (!(childAt == null || childAt.getVisibility() == 8 || !m6293a(i))) {
                m6292a(canvas, childAt.getTop() - ((LayoutParams) childAt.getLayoutParams()).topMargin);
            }
            i++;
        }
        if (m6293a(childCount)) {
            View childAt2 = getChildAt(childCount - 1);
            m6292a(canvas, childAt2 == null ? (getHeight() - getPaddingBottom()) - this.f3998d : childAt2.getBottom());
        }
    }

    void m6292a(Canvas canvas, int i) {
        this.f3996b.setBounds(getPaddingLeft() + this.f4000f, i, (getWidth() - getPaddingRight()) - this.f4000f, this.f3998d + i);
        this.f3996b.draw(canvas);
    }

    protected boolean m6293a(int i) {
        if (i == 0) {
            return (this.f3999e & 1) != 0;
        } else {
            if (i == getChildCount()) {
                return (this.f3999e & 4) != 0;
            } else {
                if ((this.f3999e & 2) == 0) {
                    return false;
                }
                for (int i2 = i - 1; i2 >= 0; i2--) {
                    if (getChildAt(i2).getVisibility() != 8) {
                        return true;
                    }
                }
                return false;
            }
        }
    }

    void m6294b(Canvas canvas) {
        int childCount = getChildCount();
        int i = 0;
        while (i < childCount) {
            View childAt = getChildAt(i);
            if (!(childAt == null || childAt.getVisibility() == 8 || !m6293a(i))) {
                m6295b(canvas, childAt.getLeft() - ((LayoutParams) childAt.getLayoutParams()).leftMargin);
            }
            i++;
        }
        if (m6293a(childCount)) {
            View childAt2 = getChildAt(childCount - 1);
            m6295b(canvas, childAt2 == null ? (getWidth() - getPaddingRight()) - this.f3997c : childAt2.getRight());
        }
    }

    void m6295b(Canvas canvas, int i) {
        this.f3996b.setBounds(i, getPaddingTop() + this.f4000f, this.f3997c + i, (getHeight() - getPaddingBottom()) - this.f4000f);
        this.f3996b.draw(canvas);
    }

    public int getDividerPadding() {
        return this.f4000f;
    }

    public int getDividerWidth() {
        return this.f3997c;
    }

    public int getShowDividers() {
        return this.f3999e;
    }

    protected void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
        int indexOfChild = indexOfChild(view);
        int orientation = getOrientation();
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (m6293a(indexOfChild)) {
            if (orientation == 1) {
                layoutParams.topMargin = this.f3998d;
            } else {
                layoutParams.leftMargin = this.f3997c;
            }
        }
        int childCount = getChildCount();
        if (indexOfChild == childCount - 1 && m6293a(childCount)) {
            if (orientation == 1) {
                layoutParams.bottomMargin = this.f3998d;
            } else {
                layoutParams.rightMargin = this.f3997c;
            }
        }
        super.measureChildWithMargins(view, i, i2, i3, i4);
    }

    protected void onDraw(Canvas canvas) {
        if (this.f3996b != null) {
            if (getOrientation() == 1) {
                m6291a(canvas);
            } else {
                m6294b(canvas);
            }
        }
        super.onDraw(canvas);
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable != this.f3996b) {
            if ((drawable instanceof ColorDrawable) && VERSION.SDK_INT < 11) {
                drawable = new C1060f((ColorDrawable) drawable);
            }
            this.f3996b = drawable;
            if (drawable != null) {
                this.f3997c = drawable.getIntrinsicWidth();
                this.f3998d = drawable.getIntrinsicHeight();
            } else {
                this.f3997c = 0;
                this.f3998d = 0;
            }
            setWillNotDraw(drawable == null);
            requestLayout();
        }
    }

    public void setDividerPadding(int i) {
        this.f4000f = i;
    }

    public void setShowDividers(int i) {
        if (i != this.f3999e) {
            requestLayout();
            invalidate();
        }
        this.f3999e = i;
    }
}
