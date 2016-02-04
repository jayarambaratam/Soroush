package android.support.v4.p011a;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;

/* renamed from: android.support.v4.a.h */
class C0121h implements C0115c {
    private TimeInterpolator f708a;

    C0121h() {
    }

    public C0118l m931a() {
        return new C0123j(ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}));
    }

    public void m932a(View view) {
        if (this.f708a == null) {
            this.f708a = new ValueAnimator().getInterpolator();
        }
        view.animate().setInterpolator(this.f708a);
    }
}
