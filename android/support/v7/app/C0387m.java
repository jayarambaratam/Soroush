package android.support.v7.app;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;

/* renamed from: android.support.v7.app.m */
class C0387m implements C0372g {
    final Activity f1897a;

    private C0387m(Activity activity) {
        this.f1897a = activity;
    }

    public Drawable m3831a() {
        TypedArray obtainStyledAttributes = m3834b().obtainStyledAttributes(null, new int[]{16843531}, 16843470, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        return drawable;
    }

    public void m3832a(int i) {
        ActionBar actionBar = this.f1897a.getActionBar();
        if (actionBar != null) {
            actionBar.setHomeActionContentDescription(i);
        }
    }

    public void m3833a(Drawable drawable, int i) {
        ActionBar actionBar = this.f1897a.getActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(drawable);
            actionBar.setHomeActionContentDescription(i);
        }
    }

    public Context m3834b() {
        ActionBar actionBar = this.f1897a.getActionBar();
        return actionBar != null ? actionBar.getThemedContext() : this.f1897a;
    }

    public boolean m3835c() {
        ActionBar actionBar = this.f1897a.getActionBar();
        return (actionBar == null || (actionBar.getDisplayOptions() & 4) == 0) ? false : true;
    }
}
