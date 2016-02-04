package mobi.mmdt.ott.view.components;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.C0071r;
import android.support.design.widget.C0095u;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.util.AttributeSet;
import android.view.View;
import mobi.mmdt.componentsutils.p079a.C1111c;

public class ScrollingFABBehavior extends C0071r<FloatingActionButton> {
    private int f5730a;

    public ScrollingFABBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5730a = C1111c.m6401b(context);
    }

    public boolean m8672a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
        return view instanceof AppBarLayout;
    }

    public boolean m8673b(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
        if (view instanceof AppBarLayout) {
            floatingActionButton.setTranslationY(((float) (-(((C0095u) floatingActionButton.getLayoutParams()).bottomMargin + floatingActionButton.getHeight()))) * (view.getY() / ((float) this.f5730a)));
        }
        return true;
    }

    public /* synthetic */ boolean m8674b(CoordinatorLayout coordinatorLayout, View view, View view2) {
        return m8672a(coordinatorLayout, (FloatingActionButton) view, view2);
    }

    public /* synthetic */ boolean m8675c(CoordinatorLayout coordinatorLayout, View view, View view2) {
        return m8673b(coordinatorLayout, (FloatingActionButton) view, view2);
    }
}
