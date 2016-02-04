package android.support.design.widget;

import android.animation.ValueAnimator;
import android.view.animation.Interpolator;

class cz extends cu {
    final ValueAnimator f580a;

    cz() {
        this.f580a = new ValueAnimator();
    }

    public void m728a() {
        this.f580a.start();
    }

    public void m729a(float f, float f2) {
        this.f580a.setFloatValues(new float[]{f, f2});
    }

    public void m730a(int i) {
        this.f580a.setDuration((long) i);
    }

    public void m731a(int i, int i2) {
        this.f580a.setIntValues(new int[]{i, i2});
    }

    public void m732a(cv cvVar) {
        this.f580a.addListener(new db(this, cvVar));
    }

    public void m733a(cw cwVar) {
        this.f580a.addUpdateListener(new da(this, cwVar));
    }

    public void m734a(Interpolator interpolator) {
        this.f580a.setInterpolator(interpolator);
    }

    public boolean m735b() {
        return this.f580a.isRunning();
    }

    public int m736c() {
        return ((Integer) this.f580a.getAnimatedValue()).intValue();
    }

    public float m737d() {
        return ((Float) this.f580a.getAnimatedValue()).floatValue();
    }

    public void m738e() {
        this.f580a.cancel();
    }

    public float m739f() {
        return this.f580a.getAnimatedFraction();
    }

    public long m740g() {
        return this.f580a.getDuration();
    }
}
