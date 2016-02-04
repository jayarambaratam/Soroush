package android.support.v7.app;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;

/* renamed from: android.support.v7.app.l */
class C0386l implements C0372g {
    final Activity f1895a;
    C0390p f1896b;

    private C0386l(Activity activity) {
        this.f1895a = activity;
    }

    public Drawable m3826a() {
        return C0389o.m3841a(this.f1895a);
    }

    public void m3827a(int i) {
        this.f1896b = C0389o.m3842a(this.f1896b, this.f1895a, i);
    }

    public void m3828a(Drawable drawable, int i) {
        this.f1895a.getActionBar().setDisplayShowHomeEnabled(true);
        this.f1896b = C0389o.m3843a(this.f1896b, this.f1895a, drawable, i);
        this.f1895a.getActionBar().setDisplayShowHomeEnabled(false);
    }

    public Context m3829b() {
        ActionBar actionBar = this.f1895a.getActionBar();
        return actionBar != null ? actionBar.getThemedContext() : this.f1895a;
    }

    public boolean m3830c() {
        ActionBar actionBar = this.f1895a.getActionBar();
        return (actionBar == null || (actionBar.getDisplayOptions() & 4) == 0) ? false : true;
    }
}
