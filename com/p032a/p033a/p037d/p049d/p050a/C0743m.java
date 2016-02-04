package com.p032a.p033a.p037d.p049d.p050a;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.view.Gravity;
import com.p032a.p033a.p037d.p049d.p052b.C0742b;

/* renamed from: com.a.a.d.d.a.m */
public class C0743m extends C0742b {
    private final Rect f2766a;
    private int f2767b;
    private int f2768c;
    private boolean f2769d;
    private boolean f2770e;
    private C0744n f2771f;

    public C0743m(Resources resources, Bitmap bitmap) {
        this(resources, new C0744n(bitmap));
    }

    C0743m(Resources resources, C0744n c0744n) {
        this.f2766a = new Rect();
        if (c0744n == null) {
            throw new NullPointerException("BitmapState must not be null");
        }
        int i;
        this.f2771f = c0744n;
        if (resources != null) {
            i = resources.getDisplayMetrics().densityDpi;
            if (i == 0) {
                i = 160;
            }
            c0744n.f2774b = i;
        } else {
            i = c0744n.f2774b;
        }
        this.f2767b = c0744n.f2773a.getScaledWidth(i);
        this.f2768c = c0744n.f2773a.getScaledHeight(i);
    }

    public void m4843a(int i) {
    }

    public boolean m4844a() {
        return false;
    }

    public Bitmap m4845b() {
        return this.f2771f.f2773a;
    }

    public void draw(Canvas canvas) {
        if (this.f2769d) {
            Gravity.apply(119, this.f2767b, this.f2768c, getBounds(), this.f2766a);
            this.f2769d = false;
        }
        canvas.drawBitmap(this.f2771f.f2773a, null, this.f2766a, this.f2771f.f2775c);
    }

    public ConstantState getConstantState() {
        return this.f2771f;
    }

    public int getIntrinsicHeight() {
        return this.f2768c;
    }

    public int getIntrinsicWidth() {
        return this.f2767b;
    }

    public int getOpacity() {
        Bitmap bitmap = this.f2771f.f2773a;
        return (bitmap == null || bitmap.hasAlpha() || this.f2771f.f2775c.getAlpha() < 255) ? -3 : -1;
    }

    public boolean isRunning() {
        return false;
    }

    public Drawable mutate() {
        if (!this.f2770e && super.mutate() == this) {
            this.f2771f = new C0744n(this.f2771f);
            this.f2770e = true;
        }
        return this;
    }

    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f2769d = true;
    }

    public void setAlpha(int i) {
        if (this.f2771f.f2775c.getAlpha() != i) {
            this.f2771f.m4847a(i);
            invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f2771f.m4848a(colorFilter);
        invalidateSelf();
    }

    public void start() {
    }

    public void stop() {
    }
}
