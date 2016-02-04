package mobi.mmdt.ott.view.components.p184a;

import android.view.View;
import android.view.animation.Interpolator;
import com.nineoldandroids.animation.Animator.AnimatorListener;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.view.ViewHelper;

/* renamed from: mobi.mmdt.ott.view.components.a.i */
public abstract class C1751i {
    private AnimatorSet f5731a;
    private long f5732b;

    public C1751i() {
        this.f5732b = 1000;
        this.f5731a = new AnimatorSet();
    }

    public C1751i m8676a(long j) {
        this.f5732b = j;
        return this;
    }

    public C1751i m8677a(Interpolator interpolator) {
        this.f5731a.setInterpolator(interpolator);
        return this;
    }

    public C1751i m8678a(AnimatorListener animatorListener) {
        this.f5731a.addListener(animatorListener);
        return this;
    }

    public void m8679a() {
        m8683b();
    }

    protected abstract void m8680a(View view);

    public C1751i m8681b(long j) {
        m8686d().setStartDelay(j);
        return this;
    }

    public C1751i m8682b(View view) {
        m8685c(view);
        m8680a(view);
        return this;
    }

    public void m8683b() {
        this.f5731a.setDuration(this.f5732b);
        this.f5731a.start();
    }

    public long m8684c() {
        return this.f5732b;
    }

    public void m8685c(View view) {
        ViewHelper.setAlpha(view, 1.0f);
        ViewHelper.setScaleX(view, 1.0f);
        ViewHelper.setScaleY(view, 1.0f);
        ViewHelper.setTranslationX(view, 0.0f);
        ViewHelper.setTranslationY(view, 0.0f);
        ViewHelper.setRotation(view, 0.0f);
        ViewHelper.setRotationY(view, 0.0f);
        ViewHelper.setRotationX(view, 0.0f);
        ViewHelper.setPivotX(view, ((float) view.getMeasuredWidth()) / 2.0f);
        ViewHelper.setPivotY(view, ((float) view.getMeasuredHeight()) / 2.0f);
    }

    public AnimatorSet m8686d() {
        return this.f5731a;
    }
}
