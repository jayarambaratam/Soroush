package android.support.v7.app;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.Toolbar;

/* renamed from: android.support.v7.app.n */
class C0388n implements C0372g {
    final Toolbar f1898a;
    final Drawable f1899b;
    final CharSequence f1900c;

    C0388n(Toolbar toolbar) {
        this.f1898a = toolbar;
        this.f1899b = toolbar.getNavigationIcon();
        this.f1900c = toolbar.getNavigationContentDescription();
    }

    public Drawable m3836a() {
        return this.f1899b;
    }

    public void m3837a(int i) {
        if (i == 0) {
            this.f1898a.setNavigationContentDescription(this.f1900c);
        } else {
            this.f1898a.setNavigationContentDescription(i);
        }
    }

    public void m3838a(Drawable drawable, int i) {
        this.f1898a.setNavigationIcon(drawable);
        m3837a(i);
    }

    public Context m3839b() {
        return this.f1898a.getContext();
    }

    public boolean m3840c() {
        return true;
    }
}
