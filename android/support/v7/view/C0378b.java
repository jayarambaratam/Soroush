package android.support.v7.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

/* renamed from: android.support.v7.view.b */
public abstract class C0378b {
    private Object f1862a;
    private boolean f1863b;

    public abstract MenuInflater m3759a();

    public abstract void m3760a(int i);

    public abstract void m3761a(View view);

    public abstract void m3762a(CharSequence charSequence);

    public void m3763a(Object obj) {
        this.f1862a = obj;
    }

    public void m3764a(boolean z) {
        this.f1863b = z;
    }

    public abstract Menu m3765b();

    public abstract void m3766b(int i);

    public abstract void m3767b(CharSequence charSequence);

    public abstract void m3768c();

    public abstract void m3769d();

    public abstract CharSequence m3770f();

    public abstract CharSequence m3771g();

    public boolean m3772h() {
        return false;
    }

    public abstract View m3773i();

    public Object m3774j() {
        return this.f1862a;
    }

    public boolean m3775k() {
        return this.f1863b;
    }
}
