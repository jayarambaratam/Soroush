package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.design.C0069j;
import android.support.design.C0070k;
import android.support.v4.os.C0269j;
import android.support.v4.view.cb;
import android.support.v4.view.ff;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

@C0093s(a = Behavior.class)
public class AppBarLayout extends LinearLayout {
    boolean f288a;
    private int f289b;
    private int f290c;
    private int f291d;
    private float f292e;
    private int f293f;
    private ff f294g;
    private final List<C0083h> f295h;

    public class Behavior extends ap<AppBarLayout> {
        private int f278a;
        private boolean f279b;
        private boolean f280c;
        private cn f281d;
        private int f282e;
        private boolean f283f;
        private float f284g;
        private WeakReference<View> f285h;
        private C0080e f286i;

        public class SavedState extends BaseSavedState {
            public static final Creator<SavedState> CREATOR;
            int f265a;
            float f266b;
            boolean f267c;

            static {
                CREATOR = C0269j.m1809a(new C0081f());
            }

            public SavedState(Parcel parcel, ClassLoader classLoader) {
                super(parcel);
                this.f265a = parcel.readInt();
                this.f266b = parcel.readFloat();
                this.f267c = parcel.readByte() != null;
            }

            public SavedState(Parcelable parcelable) {
                super(parcelable);
            }

            public void writeToParcel(Parcel parcel, int i) {
                super.writeToParcel(parcel, i);
                parcel.writeInt(this.f265a);
                parcel.writeFloat(this.f266b);
                parcel.writeByte((byte) (this.f267c ? 1 : 0));
            }
        }

        public Behavior() {
            this.f282e = -1;
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f282e = -1;
        }

        private View m233a(AppBarLayout appBarLayout, int i) {
            int childCount = appBarLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = appBarLayout.getChildAt(i2);
                if (childAt.getTop() <= (-i) && childAt.getBottom() >= (-i)) {
                    return childAt;
                }
            }
            return null;
        }

        private int m234b(AppBarLayout appBarLayout, int i) {
            int abs = Math.abs(i);
            int childCount = appBarLayout.getChildCount();
            int i2 = 0;
            while (i2 < childCount) {
                View childAt = appBarLayout.getChildAt(i2);
                C0082g c0082g = (C0082g) childAt.getLayoutParams();
                Interpolator b = c0082g.m768b();
                if (abs < childAt.getTop() || abs > childAt.getBottom()) {
                    i2++;
                } else if (b == null) {
                    return i;
                } else {
                    int height;
                    i2 = c0082g.m767a();
                    if ((i2 & 1) != 0) {
                        height = (c0082g.bottomMargin + (childAt.getHeight() + c0082g.topMargin)) + 0;
                        if ((i2 & 2) != 0) {
                            height -= cb.m2441r(childAt);
                        }
                    } else {
                        height = 0;
                    }
                    if (cb.m2447x(childAt)) {
                        height -= appBarLayout.getTopInset();
                    }
                    if (height <= 0) {
                        return i;
                    }
                    return Integer.signum(i) * (Math.round(b.getInterpolation(((float) (abs - childAt.getTop())) / ((float) height)) * ((float) height)) + childAt.getTop());
                }
            }
            return i;
        }

        private void m235b(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            int a = m238a();
            View a2 = m233a(appBarLayout, a);
            if (a2 != null) {
                C0082g c0082g = (C0082g) a2.getLayoutParams();
                if ((c0082g.m767a() & 17) == 17) {
                    int i = -a2.getTop();
                    int i2 = -a2.getBottom();
                    int r = (c0082g.m767a() & 2) == 2 ? cb.m2441r(a2) + i2 : i2;
                    if (a >= (r + i) / 2) {
                        r = i;
                    }
                    m236b(coordinatorLayout, appBarLayout, as.m541a(r, -appBarLayout.getTotalScrollRange(), 0));
                }
            }
        }

        private void m236b(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
            int a = m238a();
            if (a != i) {
                if (this.f281d == null) {
                    this.f281d = dk.m755a();
                    this.f281d.m684a(C0072a.f430c);
                    this.f281d.m683a(new C0078d(this, coordinatorLayout, appBarLayout));
                } else {
                    this.f281d.m688e();
                }
                this.f281d.m680a(Math.round(((((float) Math.abs(a - i)) / coordinatorLayout.getResources().getDisplayMetrics().density) * 1000.0f) / 300.0f));
                this.f281d.m681a(a, i);
                this.f281d.m678a();
            } else if (this.f281d != null && this.f281d.m685b()) {
                this.f281d.m688e();
            }
        }

        private void m237d(AppBarLayout appBarLayout) {
            List h = appBarLayout.f295h;
            int size = h.size();
            for (int i = 0; i < size; i++) {
                C0083h c0083h = (C0083h) h.get(i);
                if (c0083h != null) {
                    c0083h.m769a(appBarLayout, m260b());
                }
            }
        }

        int m238a() {
            return m260b() + this.f278a;
        }

        int m239a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2, int i3) {
            int a = m238a();
            if (i2 == 0 || a < i2 || a > i3) {
                return 0;
            }
            int a2 = as.m541a(i, i2, i3);
            if (a == a2) {
                return 0;
            }
            int b = appBarLayout.m283c() ? m234b(appBarLayout, a2) : a2;
            boolean a3 = m252a(b);
            a -= a2;
            this.f278a = a2 - b;
            if (!a3 && appBarLayout.m283c()) {
                coordinatorLayout.m346c((View) appBarLayout);
            }
            m237d(appBarLayout);
            return a;
        }

        /* synthetic */ int m241a(View view) {
            return m263c((AppBarLayout) view);
        }

        public Parcelable m242a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            boolean z = false;
            Parcelable a = super.m198a(coordinatorLayout, appBarLayout);
            int b = m260b();
            int childCount = appBarLayout.getChildCount();
            int i = 0;
            while (i < childCount) {
                View childAt = appBarLayout.getChildAt(i);
                int bottom = childAt.getBottom() + b;
                if (childAt.getTop() + b > 0 || bottom < 0) {
                    i++;
                } else {
                    SavedState savedState = new SavedState(a);
                    savedState.f265a = i;
                    if (bottom == cb.m2441r(childAt)) {
                        z = true;
                    }
                    savedState.f267c = z;
                    savedState.f266b = ((float) bottom) / ((float) childAt.getHeight());
                    return savedState;
                }
            }
            return a;
        }

        public void m244a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, Parcelable parcelable) {
            if (parcelable instanceof SavedState) {
                SavedState savedState = (SavedState) parcelable;
                super.m200a(coordinatorLayout, (View) appBarLayout, savedState.getSuperState());
                this.f282e = savedState.f265a;
                this.f284g = savedState.f266b;
                this.f283f = savedState.f267c;
                return;
            }
            super.m200a(coordinatorLayout, (View) appBarLayout, parcelable);
            this.f282e = -1;
        }

        public void m245a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view) {
            if (!this.f280c) {
                m235b(coordinatorLayout, appBarLayout);
            }
            this.f279b = false;
            this.f280c = false;
            this.f285h = new WeakReference(view);
        }

        public void m246a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int i3, int i4) {
            if (i4 < 0) {
                m229b(coordinatorLayout, appBarLayout, i4, -appBarLayout.getDownNestedScrollRange(), 0);
                this.f279b = true;
                return;
            }
            this.f279b = false;
        }

        public void m247a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int[] iArr) {
            if (i2 != 0 && !this.f279b) {
                int i3;
                int b;
                if (i2 < 0) {
                    i3 = -appBarLayout.getTotalScrollRange();
                    b = i3 + appBarLayout.getDownNestedPreScrollRange();
                } else {
                    i3 = -appBarLayout.getUpNestedPreScrollRange();
                    b = 0;
                }
                iArr[1] = m229b(coordinatorLayout, appBarLayout, i2, i3, b);
            }
        }

        boolean m253a(AppBarLayout appBarLayout) {
            if (this.f286i != null) {
                return this.f286i.m762a(appBarLayout);
            }
            if (this.f285h == null) {
                return true;
            }
            View view = (View) this.f285h.get();
            return (view == null || !view.isShown() || cb.m2412b(view, -1)) ? false : true;
        }

        public boolean m254a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
            boolean a = super.m219a(coordinatorLayout, appBarLayout, i);
            int e = appBarLayout.getPendingAction();
            int i2;
            if (e != 0) {
                int i3 = (e & 4) != 0 ? 1 : 0;
                if ((e & 2) != 0) {
                    i2 = -appBarLayout.getUpNestedPreScrollRange();
                    if (i3 != 0) {
                        m236b(coordinatorLayout, appBarLayout, i2);
                    } else {
                        m228b(coordinatorLayout, (View) appBarLayout, i2);
                    }
                } else if ((e & 1) != 0) {
                    if (i3 != 0) {
                        m236b(coordinatorLayout, appBarLayout, 0);
                    } else {
                        m228b(coordinatorLayout, (View) appBarLayout, 0);
                    }
                }
            } else if (this.f282e >= 0) {
                View childAt = appBarLayout.getChildAt(this.f282e);
                i2 = -childAt.getBottom();
                m252a(this.f283f ? cb.m2441r(childAt) + i2 : Math.round(((float) childAt.getHeight()) * this.f284g) + i2);
            }
            appBarLayout.m287e();
            this.f282e = -1;
            m237d(appBarLayout);
            return a;
        }

        public boolean m255a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, float f, float f2, boolean z) {
            boolean z2 = false;
            if (!z) {
                z2 = m226a(coordinatorLayout, (View) appBarLayout, -appBarLayout.getTotalScrollRange(), 0, -f2);
            } else if (f2 < 0.0f) {
                r1 = (-appBarLayout.getTotalScrollRange()) + appBarLayout.getDownNestedPreScrollRange();
                if (m238a() < r1) {
                    m236b(coordinatorLayout, appBarLayout, r1);
                    z2 = true;
                }
            } else {
                r1 = -appBarLayout.getUpNestedPreScrollRange();
                if (m238a() > r1) {
                    m236b(coordinatorLayout, appBarLayout, r1);
                    z2 = true;
                }
            }
            this.f280c = z2;
            return z2;
        }

        public boolean m256a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i) {
            boolean z = (i & 2) != 0 && appBarLayout.m285d() && coordinatorLayout.getHeight() - view.getHeight() <= appBarLayout.getHeight();
            if (z && this.f281d != null) {
                this.f281d.m688e();
            }
            this.f285h = null;
            return z;
        }

        public /* bridge */ /* synthetic */ int m260b() {
            return super.m220b();
        }

        int m261b(AppBarLayout appBarLayout) {
            return -appBarLayout.getDownNestedScrollRange();
        }

        int m263c(AppBarLayout appBarLayout) {
            return appBarLayout.getTotalScrollRange();
        }

        /* synthetic */ boolean m264c(View view) {
            return m253a((AppBarLayout) view);
        }
    }

    public class ScrollingViewBehavior extends ar {
        private int f287a;

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0070k.ScrollingViewBehavior_Params);
            this.f287a = obtainStyledAttributes.getDimensionPixelSize(C0070k.ScrollingViewBehavior_Params_behavior_overlapTop, 0);
            obtainStyledAttributes.recycle();
        }

        private int m268a(View view, int i) {
            if (this.f287a != 0 && (view instanceof AppBarLayout)) {
                AppBarLayout appBarLayout = (AppBarLayout) view;
                int totalScrollRange = appBarLayout.getTotalScrollRange();
                int b = appBarLayout.getDownNestedPreScrollRange();
                if (b != 0 && totalScrollRange + i <= b) {
                    return 0;
                }
                totalScrollRange -= b;
                if (totalScrollRange != 0) {
                    return as.m541a(Math.round(((((float) i) / ((float) totalScrollRange)) + 1.0f) * ((float) this.f287a)), 0, this.f287a);
                }
            }
            return this.f287a;
        }

        private boolean m269e(CoordinatorLayout coordinatorLayout, View view, View view2) {
            C0071r b = ((C0095u) view2.getLayoutParams()).m831b();
            if (!(b instanceof Behavior)) {
                return false;
            }
            int a = ((Behavior) b).m238a();
            m272a((view2.getHeight() + a) - m268a(view2, a));
            return true;
        }

        int m270a(View view) {
            return view instanceof AppBarLayout ? ((AppBarLayout) view).getTotalScrollRange() : super.m265a(view);
        }

        View m271a(List<View> list) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                View view = (View) list.get(i);
                if (view instanceof AppBarLayout) {
                    return view;
                }
            }
            return null;
        }

        public boolean m273a(CoordinatorLayout coordinatorLayout, View view, int i) {
            super.m219a(coordinatorLayout, view, i);
            List d = coordinatorLayout.m349d(view);
            int size = d.size();
            int i2 = 0;
            while (i2 < size && !m269e(coordinatorLayout, view, (View) d.get(i2))) {
                i2++;
            }
            return true;
        }

        public /* bridge */ /* synthetic */ boolean m274a(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
            return super.m267a(coordinatorLayout, view, i, i2, i3, i4);
        }

        public /* bridge */ /* synthetic */ int m275b() {
            return super.m220b();
        }

        public boolean m276b(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        public boolean m277c(CoordinatorLayout coordinatorLayout, View view, View view2) {
            m269e(coordinatorLayout, view, view2);
            return false;
        }
    }

    public AppBarLayout(Context context) {
        this(context, null);
    }

    public AppBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f289b = -1;
        this.f290c = -1;
        this.f291d = -1;
        this.f293f = 0;
        setOrientation(1);
        cm.m677a(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0070k.AppBarLayout, 0, C0069j.Widget_Design_AppBarLayout);
        this.f292e = (float) obtainStyledAttributes.getDimensionPixelSize(C0070k.AppBarLayout_elevation, 0);
        setBackgroundDrawable(obtainStyledAttributes.getDrawable(C0070k.AppBarLayout_android_background));
        if (obtainStyledAttributes.hasValue(C0070k.AppBarLayout_expanded)) {
            setExpanded(obtainStyledAttributes.getBoolean(C0070k.AppBarLayout_expanded, false));
        }
        obtainStyledAttributes.recycle();
        dk.m756a(this);
        this.f295h = new ArrayList();
        cb.m2432j(this, this.f292e);
        cb.m2401a((View) this, new C0076c(this));
    }

    private void m281b() {
        this.f289b = -1;
        this.f290c = -1;
        this.f291d = -1;
    }

    private boolean m283c() {
        return this.f288a;
    }

    private boolean m285d() {
        return getTotalScrollRange() != 0;
    }

    private void m287e() {
        this.f293f = 0;
    }

    private int getDownNestedPreScrollRange() {
        if (this.f290c != -1) {
            return this.f290c;
        }
        int i = 0;
        int childCount = getChildCount() - 1;
        while (childCount >= 0) {
            int i2;
            View childAt = getChildAt(childCount);
            C0082g c0082g = (C0082g) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i3 = c0082g.f599a;
            if ((i3 & 5) == 5) {
                i2 = (c0082g.bottomMargin + c0082g.topMargin) + i;
                i2 = (i3 & 8) != 0 ? i2 + cb.m2441r(childAt) : i2 + measuredHeight;
            } else if (i > 0) {
                break;
            } else {
                i2 = i;
            }
            childCount--;
            i = i2;
        }
        this.f290c = i;
        return i;
    }

    private int getDownNestedScrollRange() {
        if (this.f291d != -1) {
            return this.f291d;
        }
        int i;
        int childCount = getChildCount();
        int i2 = 0;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            C0082g c0082g = (C0082g) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight() + (c0082g.topMargin + c0082g.bottomMargin);
            i = c0082g.f599a;
            if ((i & 1) == 0) {
                break;
            }
            i2 += measuredHeight;
            if ((i & 2) != 0) {
                i = i2 - (cb.m2441r(childAt) + getTopInset());
                break;
            }
        }
        i = i2;
        i = Math.max(0, i);
        this.f291d = i;
        return i;
    }

    private int getPendingAction() {
        return this.f293f;
    }

    private int getTopInset() {
        return this.f294g != null ? this.f294g.m2899b() : 0;
    }

    private int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    private void setWindowInsets(ff ffVar) {
        this.f289b = -1;
        this.f294g = ffVar;
        int i = 0;
        int childCount = getChildCount();
        while (i < childCount) {
            ffVar = cb.m2407b(getChildAt(i), ffVar);
            if (!ffVar.m2902e()) {
                i++;
            } else {
                return;
            }
        }
    }

    protected C0082g m292a() {
        return new C0082g(-1, -2);
    }

    public C0082g m293a(AttributeSet attributeSet) {
        return new C0082g(getContext(), attributeSet);
    }

    protected C0082g m294a(LayoutParams layoutParams) {
        return layoutParams instanceof LinearLayout.LayoutParams ? new C0082g((LinearLayout.LayoutParams) layoutParams) : layoutParams instanceof MarginLayoutParams ? new C0082g((MarginLayoutParams) layoutParams) : new C0082g(layoutParams);
    }

    public void m295a(C0083h c0083h) {
        if (c0083h != null && !this.f295h.contains(c0083h)) {
            this.f295h.add(c0083h);
        }
    }

    public void m296a(boolean z, boolean z2) {
        this.f293f = (z2 ? 4 : 0) | (z ? 1 : 2);
        requestLayout();
    }

    public void m297b(C0083h c0083h) {
        if (c0083h != null) {
            this.f295h.remove(c0083h);
        }
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof C0082g;
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return m292a();
    }

    protected /* synthetic */ LinearLayout.LayoutParams m11099generateDefaultLayoutParams() {
        return m292a();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m293a(attributeSet);
    }

    protected /* synthetic */ LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return m294a(layoutParams);
    }

    public /* synthetic */ LinearLayout.LayoutParams m11100generateLayoutParams(AttributeSet attributeSet) {
        return m293a(attributeSet);
    }

    protected /* synthetic */ LinearLayout.LayoutParams m11101generateLayoutParams(LayoutParams layoutParams) {
        return m294a(layoutParams);
    }

    final int getMinimumHeightForVisibleOverlappingContent() {
        int b = this.f294g != null ? this.f294g.m2899b() : 0;
        int r = cb.m2441r(this);
        if (r != 0) {
            return (r * 2) + b;
        }
        r = getChildCount();
        return r >= 1 ? (cb.m2441r(getChildAt(r - 1)) * 2) + b : 0;
    }

    public float getTargetElevation() {
        return this.f292e;
    }

    public final int getTotalScrollRange() {
        if (this.f289b != -1) {
            return this.f289b;
        }
        int r;
        int childCount = getChildCount();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            C0082g c0082g = (C0082g) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i3 = c0082g.f599a;
            if ((i3 & 1) == 0) {
                break;
            }
            i += c0082g.bottomMargin + (measuredHeight + c0082g.topMargin);
            if ((i3 & 2) != 0) {
                r = i - cb.m2441r(childAt);
                break;
            }
        }
        r = i;
        r = Math.max(0, r - getTopInset());
        this.f289b = r;
        return r;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        m281b();
        this.f288a = false;
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            if (((C0082g) getChildAt(i5).getLayoutParams()).m768b() != null) {
                this.f288a = true;
                return;
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        m281b();
    }

    public void setExpanded(boolean z) {
        m296a(z, cb.m2385D(this));
    }

    public void setOrientation(int i) {
        if (i != 1) {
            throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
        }
        super.setOrientation(i);
    }

    public void setTargetElevation(float f) {
        this.f292e = f;
    }
}
