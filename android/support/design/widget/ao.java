package android.support.design.widget;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.support.v4.p013c.p014a.C0177a;
import android.support.v4.view.cb;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

@TargetApi(21)
class ao extends ai {
    private Interpolator f464j;

    ao(View view, ax axVar) {
        super(view, axVar);
        if (!view.isInEditMode()) {
            this.f464j = AnimationUtils.loadInterpolator(this.h.getContext(), 17563661);
        }
    }

    private Animator m531a(Animator animator) {
        animator.setInterpolator(this.f464j);
        return animator;
    }

    void m532a() {
    }

    public void m533a(float f) {
        cb.m2432j(this.h, f);
    }

    void m534a(int i) {
        if (this.b instanceof RippleDrawable) {
            ((RippleDrawable) this.b).setColor(ColorStateList.valueOf(i));
        } else {
            super.m512a(i);
        }
    }

    void m535a(ColorStateList colorStateList, Mode mode, int i, int i2) {
        Drawable layerDrawable;
        this.a = C0177a.m1549c(m503g());
        C0177a.m1544a(this.a, colorStateList);
        if (mode != null) {
            C0177a.m1545a(this.a, mode);
        }
        if (i2 > 0) {
            this.c = m487a(i2, colorStateList);
            layerDrawable = new LayerDrawable(new Drawable[]{this.c, this.a});
        } else {
            this.c = null;
            layerDrawable = this.a;
        }
        this.b = new RippleDrawable(ColorStateList.valueOf(i), layerDrawable, null);
        this.i.m480a(this.b);
        this.i.m479a(0, 0, 0, 0);
    }

    void m536a(int[] iArr) {
    }

    void m537b(float f) {
        StateListAnimator stateListAnimator = new StateListAnimator();
        stateListAnimator.addState(e, m531a(ObjectAnimator.ofFloat(this.h, "translationZ", new float[]{f})));
        stateListAnimator.addState(f, m531a(ObjectAnimator.ofFloat(this.h, "translationZ", new float[]{f})));
        stateListAnimator.addState(g, m531a(ObjectAnimator.ofFloat(this.h, "translationZ", new float[]{0.0f})));
        this.h.setStateListAnimator(stateListAnimator);
    }

    boolean m538b() {
        return false;
    }

    C0084i m539f() {
        return new C0085j();
    }
}
