package android.support.design.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.support.v4.p013c.C0198a;

/* renamed from: android.support.design.widget.i */
class C0084i extends Drawable {
    final Paint f601a;
    final Rect f602b;
    final RectF f603c;
    float f604d;
    private int f605e;
    private int f606f;
    private int f607g;
    private int f608h;
    private ColorStateList f609i;
    private int f610j;
    private boolean f611k;
    private float f612l;

    public C0084i() {
        this.f602b = new Rect();
        this.f603c = new RectF();
        this.f611k = true;
        this.f601a = new Paint(1);
        this.f601a.setStyle(Style.STROKE);
    }

    private Shader m770a() {
        Rect rect = this.f602b;
        copyBounds(rect);
        float height = this.f604d / ((float) rect.height());
        return new LinearGradient(0.0f, (float) rect.top, 0.0f, (float) rect.bottom, new int[]{C0198a.m1617a(this.f605e, this.f610j), C0198a.m1617a(this.f606f, this.f610j), C0198a.m1617a(C0198a.m1625c(this.f606f, 0), this.f610j), C0198a.m1617a(C0198a.m1625c(this.f608h, 0), this.f610j), C0198a.m1617a(this.f608h, this.f610j), C0198a.m1617a(this.f607g, this.f610j)}, new float[]{0.0f, height, 0.5f, 0.5f, 1.0f - height, 1.0f}, TileMode.CLAMP);
    }

    void m771a(float f) {
        if (this.f604d != f) {
            this.f604d = f;
            this.f601a.setStrokeWidth(1.3333f * f);
            this.f611k = true;
            invalidateSelf();
        }
    }

    void m772a(int i, int i2, int i3, int i4) {
        this.f605e = i;
        this.f606f = i2;
        this.f607g = i3;
        this.f608h = i4;
    }

    void m773a(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.f610j = colorStateList.getColorForState(getState(), this.f610j);
        }
        this.f609i = colorStateList;
        this.f611k = true;
        invalidateSelf();
    }

    final void m774b(float f) {
        if (f != this.f612l) {
            this.f612l = f;
            invalidateSelf();
        }
    }

    public void draw(Canvas canvas) {
        if (this.f611k) {
            this.f601a.setShader(m770a());
            this.f611k = false;
        }
        float strokeWidth = this.f601a.getStrokeWidth() / 2.0f;
        RectF rectF = this.f603c;
        copyBounds(this.f602b);
        rectF.set(this.f602b);
        rectF.left += strokeWidth;
        rectF.top += strokeWidth;
        rectF.right -= strokeWidth;
        rectF.bottom -= strokeWidth;
        canvas.save();
        canvas.rotate(this.f612l, rectF.centerX(), rectF.centerY());
        canvas.drawOval(rectF, this.f601a);
        canvas.restore();
    }

    public int getOpacity() {
        return this.f604d > 0.0f ? -3 : -2;
    }

    public boolean getPadding(Rect rect) {
        int round = Math.round(this.f604d);
        rect.set(round, round, round, round);
        return true;
    }

    public boolean isStateful() {
        return (this.f609i != null && this.f609i.isStateful()) || super.isStateful();
    }

    protected void onBoundsChange(Rect rect) {
        this.f611k = true;
    }

    protected boolean onStateChange(int[] iArr) {
        if (this.f609i != null) {
            int colorForState = this.f609i.getColorForState(iArr, this.f610j);
            if (colorForState != this.f610j) {
                this.f611k = true;
                this.f610j = colorForState;
            }
        }
        if (this.f611k) {
            invalidateSelf();
        }
        return this.f611k;
    }

    public void setAlpha(int i) {
        this.f601a.setAlpha(i);
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f601a.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
