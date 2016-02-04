package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.support.design.C0070k;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

/* renamed from: android.support.design.widget.u */
public class C0095u extends MarginLayoutParams {
    C0071r f666a;
    boolean f667b;
    public int f668c;
    public int f669d;
    public int f670e;
    int f671f;
    View f672g;
    View f673h;
    final Rect f674i;
    Object f675j;
    private boolean f676k;
    private boolean f677l;
    private boolean f678m;

    public C0095u(int i, int i2) {
        super(i, i2);
        this.f667b = false;
        this.f668c = 0;
        this.f669d = 0;
        this.f670e = -1;
        this.f671f = -1;
        this.f674i = new Rect();
    }

    C0095u(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f667b = false;
        this.f668c = 0;
        this.f669d = 0;
        this.f670e = -1;
        this.f671f = -1;
        this.f674i = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0070k.CoordinatorLayout_LayoutParams);
        this.f668c = obtainStyledAttributes.getInteger(C0070k.CoordinatorLayout_LayoutParams_android_layout_gravity, 0);
        this.f671f = obtainStyledAttributes.getResourceId(C0070k.CoordinatorLayout_LayoutParams_layout_anchor, -1);
        this.f669d = obtainStyledAttributes.getInteger(C0070k.CoordinatorLayout_LayoutParams_layout_anchorGravity, 0);
        this.f670e = obtainStyledAttributes.getInteger(C0070k.CoordinatorLayout_LayoutParams_layout_keyline, -1);
        this.f667b = obtainStyledAttributes.hasValue(C0070k.CoordinatorLayout_LayoutParams_layout_behavior);
        if (this.f667b) {
            this.f666a = CoordinatorLayout.m314a(context, attributeSet, obtainStyledAttributes.getString(C0070k.CoordinatorLayout_LayoutParams_layout_behavior));
        }
        obtainStyledAttributes.recycle();
    }

    public C0095u(C0095u c0095u) {
        super(c0095u);
        this.f667b = false;
        this.f668c = 0;
        this.f669d = 0;
        this.f670e = -1;
        this.f671f = -1;
        this.f674i = new Rect();
    }

    public C0095u(LayoutParams layoutParams) {
        super(layoutParams);
        this.f667b = false;
        this.f668c = 0;
        this.f669d = 0;
        this.f670e = -1;
        this.f671f = -1;
        this.f674i = new Rect();
    }

    public C0095u(MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
        this.f667b = false;
        this.f668c = 0;
        this.f669d = 0;
        this.f670e = -1;
        this.f671f = -1;
        this.f674i = new Rect();
    }

    private void m823a(View view, CoordinatorLayout coordinatorLayout) {
        this.f672g = coordinatorLayout.findViewById(this.f671f);
        if (this.f672g != null) {
            View view2 = this.f672g;
            View parent = this.f672g.getParent();
            while (parent != coordinatorLayout && parent != null) {
                if (parent != view) {
                    if (parent instanceof View) {
                        view2 = parent;
                    }
                    parent = parent.getParent();
                } else if (coordinatorLayout.isInEditMode()) {
                    this.f673h = null;
                    this.f672g = null;
                    return;
                } else {
                    throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                }
            }
            this.f673h = view2;
        } else if (coordinatorLayout.isInEditMode()) {
            this.f673h = null;
            this.f672g = null;
        } else {
            throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + coordinatorLayout.getResources().getResourceName(this.f671f) + " to anchor view " + view);
        }
    }

    private boolean m824b(View view, CoordinatorLayout coordinatorLayout) {
        if (this.f672g.getId() != this.f671f) {
            return false;
        }
        View view2 = this.f672g;
        View parent = this.f672g.getParent();
        while (parent != coordinatorLayout) {
            if (parent == null || parent == view) {
                this.f673h = null;
                this.f672g = null;
                return false;
            }
            if (parent instanceof View) {
                view2 = parent;
            }
            parent = parent.getParent();
        }
        this.f673h = view2;
        return true;
    }

    public int m825a() {
        return this.f671f;
    }

    void m826a(Rect rect) {
        this.f674i.set(rect);
    }

    public void m827a(C0071r c0071r) {
        if (this.f666a != c0071r) {
            this.f666a = c0071r;
            this.f675j = null;
            this.f667b = true;
        }
    }

    void m828a(boolean z) {
        this.f677l = z;
    }

    boolean m829a(CoordinatorLayout coordinatorLayout, View view) {
        if (this.f676k) {
            return true;
        }
        boolean d = (this.f666a != null ? this.f666a.m217d(coordinatorLayout, view) : 0) | this.f676k;
        this.f676k = d;
        return d;
    }

    boolean m830a(CoordinatorLayout coordinatorLayout, View view, View view2) {
        return view2 == this.f673h || (this.f666a != null && this.f666a.m213b(coordinatorLayout, view, view2));
    }

    public C0071r m831b() {
        return this.f666a;
    }

    View m832b(CoordinatorLayout coordinatorLayout, View view) {
        if (this.f671f == -1) {
            this.f673h = null;
            this.f672g = null;
            return null;
        }
        if (this.f672g == null || !m824b(view, coordinatorLayout)) {
            m823a(view, coordinatorLayout);
        }
        return this.f672g;
    }

    void m833b(boolean z) {
        this.f678m = z;
    }

    Rect m834c() {
        return this.f674i;
    }

    boolean m835d() {
        return this.f672g == null && this.f671f != -1;
    }

    boolean m836e() {
        if (this.f666a == null) {
            this.f676k = false;
        }
        return this.f676k;
    }

    void m837f() {
        this.f676k = false;
    }

    void m838g() {
        this.f677l = false;
    }

    boolean m839h() {
        return this.f677l;
    }

    boolean m840i() {
        return this.f678m;
    }

    void m841j() {
        this.f678m = false;
    }
}
