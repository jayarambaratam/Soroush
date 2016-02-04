package android.support.design.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.GradientDrawable;
import android.support.design.C0040d;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;

abstract class al {
    static final int[] f434e;
    static final int[] f435f;
    static final int[] f436g;
    private OnPreDrawListener f437a;
    final View f438h;
    final ax f439i;

    static {
        f434e = new int[]{16842919, 16842910};
        f435f = new int[]{16842908, 16842910};
        f436g = new int[0];
    }

    al(View view, ax axVar) {
        this.f438h = view;
        this.f439i = axVar;
    }

    private void m486h() {
        if (this.f437a == null) {
            this.f437a = new am(this);
        }
    }

    C0084i m487a(int i, ColorStateList colorStateList) {
        Resources resources = this.f438h.getResources();
        C0084i f = m502f();
        f.m772a(resources.getColor(C0040d.design_fab_stroke_top_outer_color), resources.getColor(C0040d.design_fab_stroke_top_inner_color), resources.getColor(C0040d.design_fab_stroke_end_inner_color), resources.getColor(C0040d.design_fab_stroke_end_outer_color));
        f.m771a((float) i);
        f.m773a(colorStateList);
        return f;
    }

    abstract void m488a();

    abstract void m489a(float f);

    abstract void m490a(int i);

    abstract void m491a(ColorStateList colorStateList);

    abstract void m492a(ColorStateList colorStateList, Mode mode, int i, int i2);

    abstract void m493a(Mode mode);

    abstract void m494a(an anVar);

    abstract void m495a(int[] iArr);

    abstract void m496b(float f);

    abstract void m497b(an anVar);

    boolean m498b() {
        return false;
    }

    void m499c() {
    }

    void m500d() {
        if (m498b()) {
            m486h();
            this.f438h.getViewTreeObserver().addOnPreDrawListener(this.f437a);
        }
    }

    void m501e() {
        if (this.f437a != null) {
            this.f438h.getViewTreeObserver().removeOnPreDrawListener(this.f437a);
            this.f437a = null;
        }
    }

    C0084i m502f() {
        return new C0084i();
    }

    GradientDrawable m503g() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(-1);
        return gradientDrawable;
    }
}
