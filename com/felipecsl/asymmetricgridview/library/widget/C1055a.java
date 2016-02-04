package com.felipecsl.asymmetricgridview.library.widget;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* renamed from: com.felipecsl.asymmetricgridview.library.widget.a */
public final class C1055a extends Animation {
    public static final boolean f3972a;
    private static final WeakHashMap<View, C1055a> f3973b;
    private final WeakReference<View> f3974c;
    private float f3975d;
    private float f3976e;
    private float f3977f;
    private float f3978g;
    private float f3979h;
    private final RectF f3980i;
    private final RectF f3981j;
    private final Matrix f3982k;

    static {
        f3972a = VERSION.SDK_INT < 11;
        f3973b = new WeakHashMap();
    }

    private C1055a(View view) {
        this.f3975d = 1.0f;
        this.f3976e = 1.0f;
        this.f3977f = 1.0f;
        this.f3980i = new RectF();
        this.f3981j = new RectF();
        this.f3982k = new Matrix();
        setDuration(0);
        setFillAfter(true);
        view.setAnimation(this);
        this.f3974c = new WeakReference(view);
    }

    public static C1055a m6258a(View view) {
        C1055a c1055a = (C1055a) f3973b.get(view);
        if (c1055a != null) {
            return c1055a;
        }
        c1055a = new C1055a(view);
        f3973b.put(view, c1055a);
        return c1055a;
    }

    private void m6259a(Matrix matrix, View view) {
        float width = (float) view.getWidth();
        float height = (float) view.getHeight();
        float f = this.f3976e;
        float f2 = this.f3977f;
        if (!(f == 1.0f && f2 == 1.0f)) {
            width = ((f * width) - width) / 2.0f;
            height = ((f2 * height) - height) / 2.0f;
            matrix.postScale(f, f2);
            matrix.postTranslate(-width, -height);
        }
        matrix.postTranslate(this.f3978g, this.f3979h);
    }

    private void m6260a(RectF rectF, View view) {
        rectF.set(0.0f, 0.0f, (float) view.getWidth(), (float) view.getHeight());
        Matrix matrix = this.f3982k;
        matrix.reset();
        m6259a(matrix, view);
        this.f3982k.mapRect(rectF);
        rectF.offset((float) view.getLeft(), (float) view.getTop());
        if (rectF.right < rectF.left) {
            float f = rectF.right;
            rectF.right = rectF.left;
            rectF.left = f;
        }
        if (rectF.bottom < rectF.top) {
            f = rectF.top;
            rectF.top = rectF.bottom;
            rectF.bottom = f;
        }
    }

    private void m6261c() {
        View view = (View) this.f3974c.get();
        if (view != null) {
            m6260a(this.f3980i, view);
        }
    }

    private void m6262d() {
        View view = (View) this.f3974c.get();
        if (view != null) {
            View view2 = (View) view.getParent();
            if (view2 != null) {
                view.setAnimation(this);
                RectF rectF = this.f3981j;
                m6260a(rectF, view);
                rectF.union(this.f3980i);
                view2.invalidate((int) Math.floor((double) rectF.left), (int) Math.floor((double) rectF.top), (int) Math.ceil((double) rectF.right), (int) Math.ceil((double) rectF.bottom));
            }
        }
    }

    public float m6263a() {
        return this.f3975d;
    }

    public void m6264a(float f) {
        if (this.f3975d != f) {
            this.f3975d = f;
            View view = (View) this.f3974c.get();
            if (view != null) {
                view.invalidate();
            }
        }
    }

    protected void applyTransformation(float f, Transformation transformation) {
        View view = (View) this.f3974c.get();
        if (view != null) {
            transformation.setAlpha(this.f3975d);
            m6259a(transformation.getMatrix(), view);
        }
    }

    public float m6265b() {
        return this.f3978g;
    }

    public void m6266b(float f) {
        if (this.f3978g != f) {
            m6261c();
            this.f3978g = f;
            m6262d();
        }
    }

    public void reset() {
    }
}
