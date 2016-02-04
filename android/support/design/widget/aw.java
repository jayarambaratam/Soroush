package android.support.design.widget;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.support.design.C0040d;
import android.support.v7.p009c.p010a.C0075b;

class aw extends C0075b {
    static final double f469a;
    final Paint f470b;
    final Paint f471c;
    final RectF f472d;
    float f473e;
    Path f474f;
    float f475g;
    float f476h;
    float f477i;
    float f478j;
    private boolean f479k;
    private final int f480l;
    private final int f481m;
    private final int f482n;
    private boolean f483o;
    private float f484p;
    private boolean f485q;

    static {
        f469a = Math.cos(Math.toRadians(45.0d));
    }

    public aw(Resources resources, Drawable drawable, float f, float f2, float f3) {
        super(drawable);
        this.f479k = true;
        this.f483o = true;
        this.f485q = false;
        this.f480l = resources.getColor(C0040d.design_fab_shadow_start_color);
        this.f481m = resources.getColor(C0040d.design_fab_shadow_mid_color);
        this.f482n = resources.getColor(C0040d.design_fab_shadow_end_color);
        this.f470b = new Paint(5);
        this.f470b.setStyle(Style.FILL);
        this.f473e = (float) Math.round(f);
        this.f472d = new RectF();
        this.f471c = new Paint(this.f470b);
        this.f471c.setAntiAlias(false);
        m555a(f2, f3);
    }

    public static float m547a(float f, float f2, boolean z) {
        return z ? (float) (((double) (1.5f * f)) + ((1.0d - f469a) * ((double) f2))) : 1.5f * f;
    }

    private void m548a(Canvas canvas) {
        int save = canvas.save();
        canvas.rotate(this.f484p, this.f472d.centerX(), this.f472d.centerY());
        float f = (-this.f473e) - this.f477i;
        float f2 = this.f473e;
        Object obj = this.f472d.width() - (2.0f * f2) > 0.0f ? 1 : null;
        Object obj2 = this.f472d.height() - (2.0f * f2) > 0.0f ? 1 : null;
        float f3 = f2 / ((this.f478j - (this.f478j * 0.5f)) + f2);
        float f4 = f2 / ((this.f478j - (this.f478j * 0.25f)) + f2);
        float f5 = f2 / (f2 + (this.f478j - (this.f478j * 1.0f)));
        int save2 = canvas.save();
        canvas.translate(this.f472d.left + f2, this.f472d.top + f2);
        canvas.scale(f3, f4);
        canvas.drawPath(this.f474f, this.f470b);
        if (obj != null) {
            canvas.scale(1.0f / f3, 1.0f);
            canvas.drawRect(0.0f, f, this.f472d.width() - (2.0f * f2), -this.f473e, this.f471c);
        }
        canvas.restoreToCount(save2);
        save2 = canvas.save();
        canvas.translate(this.f472d.right - f2, this.f472d.bottom - f2);
        canvas.scale(f3, f5);
        canvas.rotate(180.0f);
        canvas.drawPath(this.f474f, this.f470b);
        if (obj != null) {
            canvas.scale(1.0f / f3, 1.0f);
            canvas.drawRect(0.0f, f, this.f472d.width() - (2.0f * f2), this.f477i + (-this.f473e), this.f471c);
        }
        canvas.restoreToCount(save2);
        int save3 = canvas.save();
        canvas.translate(this.f472d.left + f2, this.f472d.bottom - f2);
        canvas.scale(f3, f5);
        canvas.rotate(270.0f);
        canvas.drawPath(this.f474f, this.f470b);
        if (obj2 != null) {
            canvas.scale(1.0f / f5, 1.0f);
            canvas.drawRect(0.0f, f, this.f472d.height() - (2.0f * f2), -this.f473e, this.f471c);
        }
        canvas.restoreToCount(save3);
        save3 = canvas.save();
        canvas.translate(this.f472d.right - f2, this.f472d.top + f2);
        canvas.scale(f3, f4);
        canvas.rotate(90.0f);
        canvas.drawPath(this.f474f, this.f470b);
        if (obj2 != null) {
            canvas.scale(1.0f / f4, 1.0f);
            canvas.drawRect(0.0f, f, this.f472d.height() - (2.0f * f2), -this.f473e, this.f471c);
        }
        canvas.restoreToCount(save3);
        canvas.restoreToCount(save);
    }

    private void m549a(Rect rect) {
        float f = this.f476h * 1.5f;
        this.f472d.set(((float) rect.left) + this.f476h, ((float) rect.top) + f, ((float) rect.right) - this.f476h, ((float) rect.bottom) - f);
        getWrappedDrawable().setBounds((int) this.f472d.left, (int) this.f472d.top, (int) this.f472d.right, (int) this.f472d.bottom);
        m551b();
    }

    public static float m550b(float f, float f2, boolean z) {
        return z ? (float) (((double) f) + ((1.0d - f469a) * ((double) f2))) : f;
    }

    private void m551b() {
        RectF rectF = new RectF(-this.f473e, -this.f473e, this.f473e, this.f473e);
        RectF rectF2 = new RectF(rectF);
        rectF2.inset(-this.f477i, -this.f477i);
        if (this.f474f == null) {
            this.f474f = new Path();
        } else {
            this.f474f.reset();
        }
        this.f474f.setFillType(FillType.EVEN_ODD);
        this.f474f.moveTo(-this.f473e, 0.0f);
        this.f474f.rLineTo(-this.f477i, 0.0f);
        this.f474f.arcTo(rectF2, 180.0f, 90.0f, false);
        this.f474f.arcTo(rectF, 270.0f, -90.0f, false);
        this.f474f.close();
        float f = -rectF2.top;
        if (f > 0.0f) {
            float f2 = this.f473e / f;
            float f3 = f2 + ((1.0f - f2) / 2.0f);
            float[] fArr = new float[]{0.0f, f2, f3, 1.0f};
            f2 = 0.0f;
            this.f470b.setShader(new RadialGradient(0.0f, f2, f, new int[]{0, this.f480l, this.f481m, this.f482n}, fArr, TileMode.CLAMP));
        }
        f = 0.0f;
        this.f471c.setShader(new LinearGradient(0.0f, rectF.top, f, rectF2.top, new int[]{this.f480l, this.f481m, this.f482n}, new float[]{0.0f, 0.5f, 1.0f}, TileMode.CLAMP));
        this.f471c.setAntiAlias(false);
    }

    private static int m552d(float f) {
        int round = Math.round(f);
        return round % 2 == 1 ? round - 1 : round;
    }

    public float m553a() {
        return this.f478j;
    }

    final void m554a(float f) {
        if (this.f484p != f) {
            this.f484p = f;
            invalidateSelf();
        }
    }

    void m555a(float f, float f2) {
        if (f < 0.0f || f2 < 0.0f) {
            throw new IllegalArgumentException("invalid shadow size");
        }
        float d = (float) m552d(f);
        float d2 = (float) m552d(f2);
        if (d > d2) {
            if (!this.f485q) {
                this.f485q = true;
            }
            d = d2;
        }
        if (this.f478j != d || this.f476h != d2) {
            this.f478j = d;
            this.f476h = d2;
            this.f477i = (float) Math.round(d * 1.5f);
            this.f475g = d2;
            this.f479k = true;
            invalidateSelf();
        }
    }

    public void m556a(boolean z) {
        this.f483o = z;
        invalidateSelf();
    }

    public void m557b(float f) {
        m555a(f, this.f476h);
    }

    public void m558c(float f) {
        m555a(this.f478j, f);
    }

    public void draw(Canvas canvas) {
        if (this.f479k) {
            m549a(getBounds());
            this.f479k = false;
        }
        m548a(canvas);
        super.draw(canvas);
    }

    public int getOpacity() {
        return -3;
    }

    public boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil((double) m547a(this.f476h, this.f473e, this.f483o));
        int ceil2 = (int) Math.ceil((double) m550b(this.f476h, this.f473e, this.f483o));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    protected void onBoundsChange(Rect rect) {
        this.f479k = true;
    }

    public void setAlpha(int i) {
        super.setAlpha(i);
        this.f470b.setAlpha(i);
        this.f471c.setAlpha(i);
    }
}
