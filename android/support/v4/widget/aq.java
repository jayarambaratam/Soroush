package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

class aq extends Animation {
    final /* synthetic */ at f1596a;
    final /* synthetic */ ap f1597b;

    aq(ap apVar, at atVar) {
        this.f1597b = apVar;
        this.f1596a = atVar;
    }

    public void applyTransformation(float f, Transformation transformation) {
        if (this.f1597b.f1584a) {
            this.f1597b.m3192b(f, this.f1596a);
            return;
        }
        float a = this.f1597b.m3185a(this.f1596a);
        float g = this.f1596a.m3227g();
        float f2 = this.f1596a.m3226f();
        float k = this.f1596a.m3231k();
        this.f1597b.m3189a(f, this.f1596a);
        if (f <= 0.5f) {
            float f3 = 0.8f - a;
            this.f1596a.m3216b(f2 + (ap.f1583c.getInterpolation(f / 0.5f) * f3));
        }
        if (f > 0.5f) {
            this.f1596a.m3219c(((0.8f - a) * ap.f1583c.getInterpolation((f - 0.5f) / 0.5f)) + g);
        }
        this.f1596a.m3222d((0.25f * f) + k);
        this.f1597b.m3201c((216.0f * f) + (1080.0f * (this.f1597b.f1592k / 5.0f)));
    }
}
