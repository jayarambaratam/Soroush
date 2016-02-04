package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.support.v4.view.p018b.C0305a;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;

class ap extends Drawable implements Animatable {
    private static final Interpolator f1582b;
    private static final Interpolator f1583c;
    boolean f1584a;
    private final int[] f1585d;
    private final ArrayList<Animation> f1586e;
    private final at f1587f;
    private float f1588g;
    private Resources f1589h;
    private View f1590i;
    private Animation f1591j;
    private float f1592k;
    private double f1593l;
    private double f1594m;
    private final Callback f1595n;

    static {
        f1582b = new LinearInterpolator();
        f1583c = new C0305a();
    }

    public ap(Context context, View view) {
        this.f1585d = new int[]{-16777216};
        this.f1586e = new ArrayList();
        this.f1595n = new as(this);
        this.f1590i = view;
        this.f1589h = context.getResources();
        this.f1587f = new at(this.f1595n);
        this.f1587f.m3214a(this.f1585d);
        m3196a(1);
        m3191b();
    }

    private float m3185a(at atVar) {
        return (float) Math.toRadians(((double) atVar.m3221d()) / (6.283185307179586d * atVar.m3230j()));
    }

    private int m3186a(float f, int i, int i2) {
        int intValue = Integer.valueOf(i).intValue();
        int i3 = (intValue >> 24) & 255;
        int i4 = (intValue >> 16) & 255;
        int i5 = (intValue >> 8) & 255;
        intValue &= 255;
        int intValue2 = Integer.valueOf(i2).intValue();
        return (intValue + ((int) (((float) ((intValue2 & 255) - intValue)) * f))) | ((((i3 + ((int) (((float) (((intValue2 >> 24) & 255) - i3)) * f))) << 24) | ((i4 + ((int) (((float) (((intValue2 >> 16) & 255) - i4)) * f))) << 16)) | ((((int) (((float) (((intValue2 >> 8) & 255) - i5)) * f)) + i5) << 8));
    }

    private void m3188a(double d, double d2, double d3, double d4, float f, float f2) {
        at atVar = this.f1587f;
        float f3 = this.f1589h.getDisplayMetrics().density;
        this.f1593l = ((double) f3) * d;
        this.f1594m = ((double) f3) * d2;
        atVar.m3207a(((float) d4) * f3);
        atVar.m3206a(((double) f3) * d3);
        atVar.m3220c(0);
        atVar.m3208a(f * f3, f3 * f2);
        atVar.m3210a((int) this.f1593l, (int) this.f1594m);
    }

    private void m3189a(float f, at atVar) {
        if (f > 0.75f) {
            atVar.m3217b(m3186a((f - 0.75f) / 0.25f, atVar.m3228h(), atVar.m3205a()));
        }
    }

    private void m3191b() {
        at atVar = this.f1587f;
        Animation aqVar = new aq(this, atVar);
        aqVar.setRepeatCount(-1);
        aqVar.setRepeatMode(1);
        aqVar.setInterpolator(f1582b);
        aqVar.setAnimationListener(new ar(this, atVar));
        this.f1591j = aqVar;
    }

    private void m3192b(float f, at atVar) {
        m3189a(f, atVar);
        float floor = (float) (Math.floor((double) (atVar.m3231k() / 0.8f)) + 1.0d);
        float a = m3185a(atVar);
        atVar.m3216b((((atVar.m3227g() - a) - atVar.m3226f()) * f) + atVar.m3226f());
        atVar.m3219c(atVar.m3227g());
        atVar.m3222d(((floor - atVar.m3231k()) * f) + atVar.m3231k());
    }

    public void m3194a(float f) {
        this.f1587f.m3225e(f);
    }

    public void m3195a(float f, float f2) {
        this.f1587f.m3216b(f);
        this.f1587f.m3219c(f2);
    }

    public void m3196a(int i) {
        if (i == 0) {
            m3188a(56.0d, 56.0d, 12.5d, 3.0d, 12.0f, 6.0f);
        } else {
            m3188a(40.0d, 40.0d, 8.75d, 2.5d, 10.0f, 5.0f);
        }
    }

    public void m3197a(boolean z) {
        this.f1587f.m3213a(z);
    }

    public void m3198a(int... iArr) {
        this.f1587f.m3214a(iArr);
        this.f1587f.m3220c(0);
    }

    public void m3199b(float f) {
        this.f1587f.m3222d(f);
    }

    public void m3200b(int i) {
        this.f1587f.m3209a(i);
    }

    void m3201c(float f) {
        this.f1588g = f;
        invalidateSelf();
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int save = canvas.save();
        canvas.rotate(this.f1588g, bounds.exactCenterX(), bounds.exactCenterY());
        this.f1587f.m3211a(canvas, bounds);
        canvas.restoreToCount(save);
    }

    public int getAlpha() {
        return this.f1587f.m3218c();
    }

    public int getIntrinsicHeight() {
        return (int) this.f1594m;
    }

    public int getIntrinsicWidth() {
        return (int) this.f1593l;
    }

    public int getOpacity() {
        return -3;
    }

    public boolean isRunning() {
        ArrayList arrayList = this.f1586e;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Animation animation = (Animation) arrayList.get(i);
            if (animation.hasStarted() && !animation.hasEnded()) {
                return true;
            }
        }
        return false;
    }

    public void setAlpha(int i) {
        this.f1587f.m3223d(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f1587f.m3212a(colorFilter);
    }

    public void start() {
        this.f1591j.reset();
        this.f1587f.m3232l();
        if (this.f1587f.m3229i() != this.f1587f.m3224e()) {
            this.f1584a = true;
            this.f1591j.setDuration(666);
            this.f1590i.startAnimation(this.f1591j);
            return;
        }
        this.f1587f.m3220c(0);
        this.f1587f.m3233m();
        this.f1591j.setDuration(1332);
        this.f1590i.startAnimation(this.f1591j);
    }

    public void stop() {
        this.f1590i.clearAnimation();
        m3201c(0.0f);
        this.f1587f.m3213a(false);
        this.f1587f.m3220c(0);
        this.f1587f.m3233m();
    }
}
