package android.support.v4.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build.VERSION;
import android.support.v4.view.cb;
import android.view.View;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

/* renamed from: android.support.v4.widget.e */
class C0338e extends ImageView {
    private AnimationListener f1691a;
    private int f1692b;

    public C0338e(Context context, int i, float f) {
        Drawable shapeDrawable;
        super(context);
        float f2 = getContext().getResources().getDisplayMetrics().density;
        int i2 = (int) ((f * f2) * 2.0f);
        int i3 = (int) (1.75f * f2);
        int i4 = (int) (0.0f * f2);
        this.f1692b = (int) (3.5f * f2);
        if (m3414a()) {
            shapeDrawable = new ShapeDrawable(new OvalShape());
            cb.m2432j(this, f2 * 4.0f);
        } else {
            shapeDrawable = new ShapeDrawable(new C0339f(this, this.f1692b, i2));
            cb.m2396a((View) this, 1, shapeDrawable.getPaint());
            shapeDrawable.getPaint().setShadowLayer((float) this.f1692b, (float) i4, (float) i3, 503316480);
            int i5 = this.f1692b;
            setPadding(i5, i5, i5, i5);
        }
        shapeDrawable.getPaint().setColor(i);
        setBackgroundDrawable(shapeDrawable);
    }

    private boolean m3414a() {
        return VERSION.SDK_INT >= 21;
    }

    public void m3415a(AnimationListener animationListener) {
        this.f1691a = animationListener;
    }

    public void onAnimationEnd() {
        super.onAnimationEnd();
        if (this.f1691a != null) {
            this.f1691a.onAnimationEnd(getAnimation());
        }
    }

    public void onAnimationStart() {
        super.onAnimationStart();
        if (this.f1691a != null) {
            this.f1691a.onAnimationStart(getAnimation());
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (!m3414a()) {
            setMeasuredDimension(getMeasuredWidth() + (this.f1692b * 2), getMeasuredHeight() + (this.f1692b * 2));
        }
    }

    public void setBackgroundColor(int i) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(i);
        }
    }
}
