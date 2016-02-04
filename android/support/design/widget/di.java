package android.support.design.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

class di<V extends View> extends C0071r<V> {
    private dj f268a;
    private int f269b;
    private int f270c;

    public di() {
        this.f269b = 0;
        this.f270c = 0;
    }

    public di(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f269b = 0;
        this.f270c = 0;
    }

    public boolean m218a(int i) {
        if (this.f268a != null) {
            return this.f268a.m752a(i);
        }
        this.f269b = i;
        return false;
    }

    public boolean m219a(CoordinatorLayout coordinatorLayout, V v, int i) {
        coordinatorLayout.m333a((View) v, i);
        if (this.f268a == null) {
            this.f268a = new dj(v);
        }
        this.f268a.m751a();
        if (this.f269b != 0) {
            this.f268a.m752a(this.f269b);
            this.f269b = 0;
        }
        if (this.f270c != 0) {
            this.f268a.m754b(this.f270c);
            this.f270c = 0;
        }
        return true;
    }

    public int m220b() {
        return this.f268a != null ? this.f268a.m753b() : 0;
    }
}
