package android.support.v7.app;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.p019a.C0359b;
import android.support.v7.widget.TintTypedArray;

class al implements C0372g {
    final /* synthetic */ aj f1777a;

    private al(aj ajVar) {
        this.f1777a = ajVar;
    }

    public Drawable m3634a() {
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(m3637b(), null, new int[]{C0359b.homeAsUpIndicator});
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        return drawable;
    }

    public void m3635a(int i) {
        C0370a a = this.f1777a.m3482a();
        if (a != null) {
            a.m3581c(i);
        }
    }

    public void m3636a(Drawable drawable, int i) {
        C0370a a = this.f1777a.m3482a();
        if (a != null) {
            a.m3572a(drawable);
            a.m3581c(i);
        }
    }

    public Context m3637b() {
        return this.f1777a.m3496k();
    }

    public boolean m3638c() {
        C0370a a = this.f1777a.m3482a();
        return (a == null || (a.m3567a() & 4) == 0) ? false : true;
    }
}
