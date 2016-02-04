package android.support.v4.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.animation.Interpolator;

public class bj {
    Object f1629a;
    bk f1630b;

    private bj(int i, Context context, Interpolator interpolator) {
        if (i >= 14) {
            this.f1630b = new bn();
        } else if (i >= 9) {
            this.f1630b = new bm();
        } else {
            this.f1630b = new bl();
        }
        this.f1629a = this.f1630b.m3278a(context, interpolator);
    }

    bj(Context context, Interpolator interpolator) {
        this(VERSION.SDK_INT, context, interpolator);
    }

    public static bj m3263a(Context context) {
        return m3264a(context, null);
    }

    public static bj m3264a(Context context, Interpolator interpolator) {
        return new bj(context, interpolator);
    }

    public void m3265a(int i, int i2, int i3, int i4) {
        this.f1630b.m3279a(this.f1629a, i, i2, i3, i4);
    }

    public void m3266a(int i, int i2, int i3, int i4, int i5) {
        this.f1630b.m3280a(this.f1629a, i, i2, i3, i4, i5);
    }

    public void m3267a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.f1630b.m3281a(this.f1629a, i, i2, i3, i4, i5, i6, i7, i8);
    }

    public void m3268a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        this.f1630b.m3282a(this.f1629a, i, i2, i3, i4, i5, i6, i7, i8, i9, i10);
    }

    public boolean m3269a() {
        return this.f1630b.m3283a(this.f1629a);
    }

    public boolean m3270a(int i, int i2, int i3, int i4, int i5, int i6) {
        return this.f1630b.m3284a(this.f1629a, i, i2, i3, i4, i5, i6);
    }

    public int m3271b() {
        return this.f1630b.m3285b(this.f1629a);
    }

    public int m3272c() {
        return this.f1630b.m3286c(this.f1629a);
    }

    public int m3273d() {
        return this.f1630b.m3290g(this.f1629a);
    }

    public int m3274e() {
        return this.f1630b.m3291h(this.f1629a);
    }

    public float m3275f() {
        return this.f1630b.m3287d(this.f1629a);
    }

    public boolean m3276g() {
        return this.f1630b.m3288e(this.f1629a);
    }

    public void m3277h() {
        this.f1630b.m3289f(this.f1629a);
    }
}
