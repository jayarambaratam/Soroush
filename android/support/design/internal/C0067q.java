package android.support.design.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.design.C0069j;
import android.support.design.C0070k;
import android.support.v4.view.cb;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/* renamed from: android.support.design.internal.q */
public class C0067q extends FrameLayout {
    private Drawable f260a;
    private Rect f261b;
    private Rect f262c;

    public C0067q(Context context) {
        this(context, null);
    }

    public C0067q(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C0067q(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f262c = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0070k.ScrimInsetsFrameLayout, i, C0069j.Widget_Design_ScrimInsetsFrameLayout);
        this.f260a = obtainStyledAttributes.getDrawable(C0070k.ScrimInsetsFrameLayout_insetForeground);
        obtainStyledAttributes.recycle();
        setWillNotDraw(true);
        cb.m2401a((View) this, new C0068r(this));
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.f261b != null && this.f260a != null) {
            int save = canvas.save();
            canvas.translate((float) getScrollX(), (float) getScrollY());
            this.f262c.set(0, 0, width, this.f261b.top);
            this.f260a.setBounds(this.f262c);
            this.f260a.draw(canvas);
            this.f262c.set(0, height - this.f261b.bottom, width, height);
            this.f260a.setBounds(this.f262c);
            this.f260a.draw(canvas);
            this.f262c.set(0, this.f261b.top, this.f261b.left, height - this.f261b.bottom);
            this.f260a.setBounds(this.f262c);
            this.f260a.draw(canvas);
            this.f262c.set(width - this.f261b.right, this.f261b.top, width, height - this.f261b.bottom);
            this.f260a.setBounds(this.f262c);
            this.f260a.draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f260a != null) {
            this.f260a.setCallback(this);
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f260a != null) {
            this.f260a.setCallback(null);
        }
    }
}
