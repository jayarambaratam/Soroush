package android.support.design.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.design.C0070k;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;
import android.view.Gravity;

/* renamed from: android.support.design.internal.a */
public class C0046a extends LinearLayoutCompat {
    protected boolean f197a;
    boolean f198b;
    private Drawable f199c;
    private final Rect f200d;
    private final Rect f201e;
    private int f202f;

    public C0046a(Context context) {
        super(context);
        this.f200d = new Rect();
        this.f201e = new Rect();
        this.f202f = 119;
        this.f197a = true;
        this.f198b = false;
    }

    public C0046a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C0046a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f200d = new Rect();
        this.f201e = new Rect();
        this.f202f = 119;
        this.f197a = true;
        this.f198b = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0070k.ForegroundLinearLayout, i, 0);
        this.f202f = obtainStyledAttributes.getInt(C0070k.ForegroundLinearLayout_android_foregroundGravity, this.f202f);
        Drawable drawable = obtainStyledAttributes.getDrawable(C0070k.ForegroundLinearLayout_android_foreground);
        if (drawable != null) {
            setForeground(drawable);
        }
        this.f197a = obtainStyledAttributes.getBoolean(C0070k.ForegroundLinearLayout_foregroundInsidePadding, true);
        obtainStyledAttributes.recycle();
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f199c != null) {
            Drawable drawable = this.f199c;
            if (this.f198b) {
                this.f198b = false;
                Rect rect = this.f200d;
                Rect rect2 = this.f201e;
                int right = getRight() - getLeft();
                int bottom = getBottom() - getTop();
                if (this.f197a) {
                    rect.set(0, 0, right, bottom);
                } else {
                    rect.set(getPaddingLeft(), getPaddingTop(), right - getPaddingRight(), bottom - getPaddingBottom());
                }
                Gravity.apply(this.f202f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), rect, rect2);
                drawable.setBounds(rect2);
            }
            drawable.draw(canvas);
        }
    }

    public void drawableHotspotChanged(float f, float f2) {
        super.drawableHotspotChanged(f, f2);
        if (this.f199c != null) {
            this.f199c.setHotspot(f, f2);
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f199c != null && this.f199c.isStateful()) {
            this.f199c.setState(getDrawableState());
        }
    }

    public Drawable getForeground() {
        return this.f199c;
    }

    public int getForegroundGravity() {
        return this.f202f;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.f199c != null) {
            this.f199c.jumpToCurrentState();
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f198b |= z;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f198b = true;
    }

    public void setForeground(Drawable drawable) {
        if (this.f199c != drawable) {
            if (this.f199c != null) {
                this.f199c.setCallback(null);
                unscheduleDrawable(this.f199c);
            }
            this.f199c = drawable;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                if (this.f202f == 119) {
                    drawable.getPadding(new Rect());
                }
            } else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    public void setForegroundGravity(int i) {
        if (this.f202f != i) {
            int i2 = (8388615 & i) == 0 ? 8388611 | i : i;
            if ((i2 & 112) == 0) {
                i2 |= 48;
            }
            this.f202f = i2;
            if (this.f202f == 119 && this.f199c != null) {
                this.f199c.getPadding(new Rect());
            }
            requestLayout();
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f199c;
    }
}
