package android.support.v7.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources.Theme;
import android.support.v7.p019a.C0368k;
import android.view.LayoutInflater;

/* renamed from: android.support.v7.view.e */
public class C0429e extends ContextWrapper {
    private int f2054a;
    private Theme f2055b;
    private LayoutInflater f2056c;

    public C0429e(Context context, int i) {
        super(context);
        this.f2054a = i;
    }

    public C0429e(Context context, Theme theme) {
        super(context);
        this.f2055b = theme;
    }

    private void m3964b() {
        boolean z = this.f2055b == null;
        if (z) {
            this.f2055b = getResources().newTheme();
            Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f2055b.setTo(theme);
            }
        }
        m3966a(this.f2055b, this.f2054a, z);
    }

    public int m3965a() {
        return this.f2054a;
    }

    protected void m3966a(Theme theme, int i, boolean z) {
        theme.applyStyle(i, true);
    }

    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f2056c == null) {
            this.f2056c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f2056c;
    }

    public Theme getTheme() {
        if (this.f2055b != null) {
            return this.f2055b;
        }
        if (this.f2054a == 0) {
            this.f2054a = C0368k.Theme_AppCompat_Light;
        }
        m3964b();
        return this.f2055b;
    }

    public void setTheme(int i) {
        if (this.f2054a != i) {
            this.f2054a = i;
            m3964b();
        }
    }
}
