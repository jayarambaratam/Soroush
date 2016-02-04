package android.support.design.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.support.design.C0038b;
import android.support.v4.p013c.p014a.C0177a;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

class ac extends al {
    Drawable f440a;
    Drawable f441b;
    C0084i f442c;
    aw f443d;
    private float f444j;
    private float f445k;
    private int f446l;
    private br f447m;
    private boolean f448n;

    ac(View view, ax axVar) {
        super(view, axVar);
        this.f446l = view.getResources().getInteger(17694720);
        this.f447m = new br();
        this.f447m.m603a(view);
        this.f447m.m605a(e, m505a(new ag()));
        this.f447m.m605a(f, m505a(new ag()));
        this.f447m.m605a(g, m505a(new ah()));
    }

    private Animation m505a(Animation animation) {
        animation.setInterpolator(C0072a.f429b);
        animation.setDuration((long) this.f446l);
        return animation;
    }

    private static ColorStateList m508b(int i) {
        r0 = new int[3][];
        int[] iArr = new int[]{f, i, e};
        iArr[1] = i;
        r0[2] = new int[0];
        iArr[2] = 0;
        return new ColorStateList(r0, iArr);
    }

    private void m509h() {
        Rect rect = new Rect();
        this.f443d.getPadding(rect);
        this.i.m479a(rect.left, rect.top, rect.right, rect.bottom);
    }

    void m510a() {
        this.f447m.m606b();
    }

    void m511a(float f) {
        if (this.f444j != f && this.f443d != null) {
            this.f443d.m555a(f, this.f445k + f);
            this.f444j = f;
            m509h();
        }
    }

    void m512a(int i) {
        C0177a.m1544a(this.f441b, m508b(i));
    }

    void m513a(ColorStateList colorStateList) {
        C0177a.m1544a(this.f440a, colorStateList);
        if (this.f442c != null) {
            this.f442c.m773a(colorStateList);
        }
    }

    void m514a(ColorStateList colorStateList, Mode mode, int i, int i2) {
        Drawable[] drawableArr;
        this.f440a = C0177a.m1549c(m503g());
        C0177a.m1544a(this.f440a, colorStateList);
        if (mode != null) {
            C0177a.m1545a(this.f440a, mode);
        }
        this.f441b = C0177a.m1549c(m503g());
        C0177a.m1544a(this.f441b, m508b(i));
        C0177a.m1545a(this.f441b, Mode.MULTIPLY);
        if (i2 > 0) {
            this.f442c = m487a(i2, colorStateList);
            drawableArr = new Drawable[]{this.f442c, this.f440a, this.f441b};
        } else {
            this.f442c = null;
            drawableArr = new Drawable[]{this.f440a, this.f441b};
        }
        this.f443d = new aw(this.h.getResources(), new LayerDrawable(drawableArr), this.i.m478a(), this.f444j, this.f444j + this.f445k);
        this.f443d.m556a(false);
        this.i.m480a(this.f443d);
        m509h();
    }

    void m515a(Mode mode) {
        C0177a.m1545a(this.f440a, mode);
    }

    void m516a(an anVar) {
        if (!this.f448n && this.h.getVisibility() == 0) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.h.getContext(), C0038b.design_fab_out);
            loadAnimation.setInterpolator(C0072a.f429b);
            loadAnimation.setDuration(200);
            loadAnimation.setAnimationListener(new ad(this, anVar));
            this.h.startAnimation(loadAnimation);
        } else if (anVar != null) {
            anVar.m530b();
        }
    }

    void m517a(int[] iArr) {
        this.f447m.m604a(iArr);
    }

    void m518b(float f) {
        if (this.f445k != f && this.f443d != null) {
            this.f445k = f;
            this.f443d.m558c(this.f444j + f);
            m509h();
        }
    }

    void m519b(an anVar) {
        if (this.h.getVisibility() != 0 || this.f448n) {
            this.h.clearAnimation();
            this.h.setVisibility(0);
            Animation loadAnimation = AnimationUtils.loadAnimation(this.h.getContext(), C0038b.design_fab_in);
            loadAnimation.setDuration(200);
            loadAnimation.setInterpolator(C0072a.f429b);
            loadAnimation.setAnimationListener(new ae(this, anVar));
            this.h.startAnimation(loadAnimation);
        } else if (anVar != null) {
            anVar.m529a();
        }
    }
}
