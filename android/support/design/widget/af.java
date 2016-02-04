package android.support.design.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

abstract class af extends Animation {
    final /* synthetic */ ac f453a;
    private float f454b;
    private float f455c;

    private af(ac acVar) {
        this.f453a = acVar;
    }

    protected abstract float m520a();

    protected void applyTransformation(float f, Transformation transformation) {
        this.f453a.f443d.m557b(this.f454b + (this.f455c * f));
    }

    public void reset() {
        super.reset();
        this.f454b = this.f453a.f443d.m553a();
        this.f455c = m520a() - this.f454b;
    }
}
