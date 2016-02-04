package android.support.design.widget;

import android.os.Build.VERSION;
import android.support.v4.view.cb;
import android.view.View;
import android.view.ViewParent;

class dj {
    private final View f592a;
    private int f593b;
    private int f594c;
    private int f595d;
    private int f596e;

    public dj(View view) {
        this.f592a = view;
    }

    private static void m749a(View view) {
        float o = cb.m2438o(view);
        cb.m2408b(view, 1.0f + o);
        cb.m2408b(view, o);
    }

    private void m750c() {
        cb.m2422e(this.f592a, this.f595d - (this.f592a.getTop() - this.f593b));
        cb.m2425f(this.f592a, this.f596e - (this.f592a.getLeft() - this.f594c));
        if (VERSION.SDK_INT < 23) {
            m749a(this.f592a);
            ViewParent parent = this.f592a.getParent();
            if (parent instanceof View) {
                m749a((View) parent);
            }
        }
    }

    public void m751a() {
        this.f593b = this.f592a.getTop();
        this.f594c = this.f592a.getLeft();
        m750c();
    }

    public boolean m752a(int i) {
        if (this.f595d == i) {
            return false;
        }
        this.f595d = i;
        m750c();
        return true;
    }

    public int m753b() {
        return this.f595d;
    }

    public boolean m754b(int i) {
        if (this.f596e == i) {
            return false;
        }
        this.f596e = i;
        m750c();
        return true;
    }
}
