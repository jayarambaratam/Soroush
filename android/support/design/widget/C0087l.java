package android.support.design.widget;

import android.support.v4.view.bs;
import android.support.v4.view.ff;
import android.view.View;

/* renamed from: android.support.design.widget.l */
class C0087l implements bs {
    final /* synthetic */ CollapsingToolbarLayout f658a;

    C0087l(CollapsingToolbarLayout collapsingToolbarLayout) {
        this.f658a = collapsingToolbarLayout;
    }

    public ff m816a(View view, ff ffVar) {
        this.f658a.f315t = ffVar;
        this.f658a.requestLayout();
        return ffVar.m2903f();
    }
}
