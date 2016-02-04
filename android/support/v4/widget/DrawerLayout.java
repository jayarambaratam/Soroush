package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.v4.p012b.C0125h;
import android.support.v4.p013c.p014a.C0177a;
import android.support.v4.view.C0327v;
import android.support.v4.view.aa;
import android.support.v4.view.cb;
import android.support.v4.view.dj;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import java.util.ArrayList;
import mobi.mmdt.ott.C1317h;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

public class DrawerLayout extends ViewGroup implements ag {
    static final C0354w f1423a;
    private static final int[] f1424b;
    private static final boolean f1425c;
    private static final boolean f1426d;
    private Drawable f1427A;
    private CharSequence f1428B;
    private CharSequence f1429C;
    private Object f1430D;
    private boolean f1431E;
    private Drawable f1432F;
    private Drawable f1433G;
    private Drawable f1434H;
    private Drawable f1435I;
    private final ArrayList<View> f1436J;
    private final C0353v f1437e;
    private float f1438f;
    private int f1439g;
    private int f1440h;
    private float f1441i;
    private Paint f1442j;
    private final ct f1443k;
    private final ct f1444l;
    private final ac f1445m;
    private final ac f1446n;
    private int f1447o;
    private boolean f1448p;
    private boolean f1449q;
    private int f1450r;
    private int f1451s;
    private boolean f1452t;
    private boolean f1453u;
    private C0357z f1454v;
    private float f1455w;
    private float f1456x;
    private Drawable f1457y;
    private Drawable f1458z;

    public class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR;
        int f1420a;
        int f1421b;
        int f1422c;

        static {
            CREATOR = new ab();
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f1420a = 0;
            this.f1421b = 0;
            this.f1422c = 0;
            this.f1420a = parcel.readInt();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
            this.f1420a = 0;
            this.f1421b = 0;
            this.f1422c = 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f1420a);
        }
    }

    static {
        boolean z = true;
        f1424b = new int[]{16842931};
        f1425c = VERSION.SDK_INT >= 19;
        if (VERSION.SDK_INT < 21) {
            z = false;
        }
        f1426d = z;
        if (VERSION.SDK_INT >= 21) {
            f1423a = new C0355x();
        } else {
            f1423a = new C0356y();
        }
    }

    public DrawerLayout(Context context) {
        this(context, null);
    }

    public DrawerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DrawerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1437e = new C0353v(this);
        this.f1440h = -1728053248;
        this.f1442j = new Paint();
        this.f1449q = true;
        this.f1432F = null;
        this.f1433G = null;
        this.f1434H = null;
        this.f1435I = null;
        setDescendantFocusability(262144);
        float f = getResources().getDisplayMetrics().density;
        this.f1439g = (int) ((64.0f * f) + 0.5f);
        float f2 = 400.0f * f;
        this.f1445m = new ac(this, 3);
        this.f1446n = new ac(this, 5);
        this.f1443k = ct.m3373a((ViewGroup) this, 1.0f, this.f1445m);
        this.f1443k.m3392a(1);
        this.f1443k.m3391a(f2);
        this.f1445m.m3121a(this.f1443k);
        this.f1444l = ct.m3373a((ViewGroup) this, 1.0f, this.f1446n);
        this.f1444l.m3392a(2);
        this.f1444l.m3391a(f2);
        this.f1446n.m3121a(this.f1444l);
        setFocusableInTouchMode(true);
        cb.m2414c((View) this, 1);
        cb.m2400a((View) this, new C0352u(this));
        dj.m2741a(this, false);
        if (cb.m2447x(this)) {
            f1423a.m3438a((View) this);
            this.f1457y = f1423a.m3437a(context);
        }
        this.f1438f = f * 10.0f;
        this.f1436J = new ArrayList();
    }

    private void m2953a(View view, boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((z || m2989g(childAt)) && !(z && childAt == view)) {
                cb.m2414c(childAt, 4);
            } else {
                cb.m2414c(childAt, 1);
            }
        }
    }

    private boolean m2954a(Drawable drawable, int i) {
        if (drawable == null || !C0177a.m1548b(drawable)) {
            return false;
        }
        C0177a.m1547b(drawable, i);
        return true;
    }

    static String m2955c(int i) {
        return (i & 3) == 3 ? "LEFT" : (i & 5) == 5 ? "RIGHT" : Integer.toHexString(i);
    }

    private void m2958f() {
        if (!f1426d) {
            this.f1458z = m2959g();
            this.f1427A = m2960h();
        }
    }

    private Drawable m2959g() {
        int h = cb.m2428h(this);
        if (h == 0) {
            if (this.f1432F != null) {
                m2954a(this.f1432F, h);
                return this.f1432F;
            }
        } else if (this.f1433G != null) {
            m2954a(this.f1433G, h);
            return this.f1433G;
        }
        return this.f1434H;
    }

    private Drawable m2960h() {
        int h = cb.m2428h(this);
        if (h == 0) {
            if (this.f1433G != null) {
                m2954a(this.f1433G, h);
                return this.f1433G;
            }
        } else if (this.f1432F != null) {
            m2954a(this.f1432F, h);
            return this.f1432F;
        }
        return this.f1435I;
    }

    private boolean m2961i() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (((aa) getChildAt(i).getLayoutParams()).f1571c) {
                return true;
            }
        }
        return false;
    }

    private boolean m2962j() {
        return m2963k() != null;
    }

    private View m2963k() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (m2989g(childAt) && m2993k(childAt)) {
                return childAt;
            }
        }
        return null;
    }

    private static boolean m2965m(View view) {
        Drawable background = view.getBackground();
        return background != null && background.getOpacity() == -1;
    }

    private static boolean m2966n(View view) {
        return (cb.m2420e(view) == 4 || cb.m2420e(view) == 2) ? false : true;
    }

    public int m2967a(View view) {
        int e = m2984e(view);
        return e == 3 ? this.f1450r : e == 5 ? this.f1451s : 0;
    }

    View m2968a() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (((aa) childAt.getLayoutParams()).f1572d) {
                return childAt;
            }
        }
        return null;
    }

    public CharSequence m2969a(int i) {
        int a = C0327v.m2941a(i, cb.m2428h(this));
        return a == 3 ? this.f1428B : a == 5 ? this.f1429C : null;
    }

    public void m2970a(int i, int i2) {
        int a = C0327v.m2941a(i2, cb.m2428h(this));
        if (a == 3) {
            this.f1450r = i;
        } else if (a == 5) {
            this.f1451s = i;
        }
        if (i != 0) {
            (a == 3 ? this.f1443k : this.f1444l).m3410e();
        }
        View b;
        switch (i) {
            case VideoSize.CIF /*1*/:
                b = m2976b(a);
                if (b != null) {
                    m2991i(b);
                }
            case VideoSize.HVGA /*2*/:
                b = m2976b(a);
                if (b != null) {
                    m2990h(b);
                }
            default:
        }
    }

    void m2971a(int i, int i2, View view) {
        int i3 = 1;
        int a = this.f1443k.m3390a();
        int a2 = this.f1444l.m3390a();
        if (!(a == 1 || a2 == 1)) {
            i3 = (a == 2 || a2 == 2) ? 2 : 0;
        }
        if (view != null && i2 == 0) {
            aa aaVar = (aa) view.getLayoutParams();
            if (aaVar.f1570b == 0.0f) {
                m2978b(view);
            } else if (aaVar.f1570b == 1.0f) {
                m2981c(view);
            }
        }
        if (i3 != this.f1447o) {
            this.f1447o = i3;
            if (this.f1454v != null) {
                this.f1454v.m3451a(i3);
            }
        }
    }

    void m2972a(View view, float f) {
        if (this.f1454v != null) {
            this.f1454v.m3453a(view, f);
        }
    }

    public void m2973a(Object obj, boolean z) {
        this.f1430D = obj;
        this.f1431E = z;
        boolean z2 = !z && getBackground() == null;
        setWillNotDraw(z2);
        requestLayout();
    }

    void m2974a(boolean z) {
        int childCount = getChildCount();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            aa aaVar = (aa) childAt.getLayoutParams();
            if (m2989g(childAt) && (!z || aaVar.f1571c)) {
                i = m2975a(childAt, 3) ? i | this.f1443k.m3396a(childAt, -childAt.getWidth(), childAt.getTop()) : i | this.f1444l.m3396a(childAt, getWidth(), childAt.getTop());
                aaVar.f1571c = false;
            }
        }
        this.f1445m.m3118a();
        this.f1446n.m3118a();
        if (i != 0) {
            invalidate();
        }
    }

    boolean m2975a(View view, int i) {
        return (m2984e(view) & i) == i;
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        int i3 = 0;
        if (getDescendantFocusability() != 393216) {
            int i4;
            int childCount = getChildCount();
            int i5 = 0;
            for (i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                if (!m2989g(childAt)) {
                    this.f1436J.add(childAt);
                } else if (m2992j(childAt)) {
                    i5 = 1;
                    childAt.addFocusables(arrayList, i, i2);
                }
            }
            if (i5 == 0) {
                i4 = this.f1436J.size();
                while (i3 < i4) {
                    View view = (View) this.f1436J.get(i3);
                    if (view.getVisibility() == 0) {
                        view.addFocusables(arrayList, i, i2);
                    }
                    i3++;
                }
            }
            this.f1436J.clear();
        }
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (m2968a() != null || m2989g(view)) {
            cb.m2414c(view, 4);
        } else {
            cb.m2414c(view, 1);
        }
        if (!f1425c) {
            cb.m2400a(view, this.f1437e);
        }
    }

    View m2976b(int i) {
        int a = C0327v.m2941a(i, cb.m2428h(this)) & 7;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((m2984e(childAt) & 7) == a) {
                return childAt;
            }
        }
        return null;
    }

    public void m2977b() {
        m2974a(false);
    }

    void m2978b(View view) {
        aa aaVar = (aa) view.getLayoutParams();
        if (aaVar.f1572d) {
            aaVar.f1572d = false;
            if (this.f1454v != null) {
                this.f1454v.m3454b(view);
            }
            m2953a(view, false);
            if (hasWindowFocus()) {
                View rootView = getRootView();
                if (rootView != null) {
                    rootView.sendAccessibilityEvent(32);
                }
            }
        }
    }

    void m2979b(View view, float f) {
        aa aaVar = (aa) view.getLayoutParams();
        if (f != aaVar.f1570b) {
            aaVar.f1570b = f;
            m2972a(view, f);
        }
    }

    void m2980c() {
        int i = 0;
        if (!this.f1453u) {
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            int childCount = getChildCount();
            while (i < childCount) {
                getChildAt(i).dispatchTouchEvent(obtain);
                i++;
            }
            obtain.recycle();
            this.f1453u = true;
        }
    }

    void m2981c(View view) {
        aa aaVar = (aa) view.getLayoutParams();
        if (!aaVar.f1572d) {
            aaVar.f1572d = true;
            if (this.f1454v != null) {
                this.f1454v.m3452a(view);
            }
            m2953a(view, true);
            if (hasWindowFocus()) {
                sendAccessibilityEvent(32);
            }
            view.requestFocus();
        }
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return (layoutParams instanceof aa) && super.checkLayoutParams(layoutParams);
    }

    public void computeScroll() {
        int childCount = getChildCount();
        float f = 0.0f;
        for (int i = 0; i < childCount; i++) {
            f = Math.max(f, ((aa) getChildAt(i).getLayoutParams()).f1570b);
        }
        this.f1441i = f;
        if ((this.f1443k.m3397a(true) | this.f1444l.m3397a(true)) != 0) {
            cb.m2417d(this);
        }
    }

    float m2982d(View view) {
        return ((aa) view.getLayoutParams()).f1570b;
    }

    public void m2983d(int i) {
        View b = m2976b(i);
        if (b == null) {
            throw new IllegalArgumentException("No drawer view found with gravity " + m2955c(i));
        }
        m2990h(b);
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        int i;
        int height = getHeight();
        boolean f = m2987f(view);
        int i2 = 0;
        int width = getWidth();
        int save = canvas.save();
        if (f) {
            int childCount = getChildCount();
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = getChildAt(i3);
                if (childAt != view && childAt.getVisibility() == 0 && m2965m(childAt) && m2989g(childAt)) {
                    if (childAt.getHeight() < height) {
                        i = width;
                    } else if (m2975a(childAt, 3)) {
                        i = childAt.getRight();
                        if (i <= i2) {
                            i = i2;
                        }
                        i2 = i;
                        i = width;
                    } else {
                        i = childAt.getLeft();
                        if (i < width) {
                        }
                    }
                    i3++;
                    width = i;
                }
                i = width;
                i3++;
                width = i;
            }
            canvas.clipRect(i2, 0, width, getHeight());
        }
        i = width;
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas.restoreToCount(save);
        if (this.f1441i > 0.0f && f) {
            this.f1442j.setColor((((int) (((float) ((this.f1440h & -16777216) >>> 24)) * this.f1441i)) << 24) | (this.f1440h & 16777215));
            canvas.drawRect((float) i2, 0.0f, (float) i, (float) getHeight(), this.f1442j);
        } else if (this.f1458z != null && m2975a(view, 3)) {
            i = this.f1458z.getIntrinsicWidth();
            i2 = view.getRight();
            r2 = Math.max(0.0f, Math.min(((float) i2) / ((float) this.f1443k.m3398b()), 1.0f));
            this.f1458z.setBounds(i2, view.getTop(), i + i2, view.getBottom());
            this.f1458z.setAlpha((int) (255.0f * r2));
            this.f1458z.draw(canvas);
        } else if (this.f1427A != null && m2975a(view, 5)) {
            i = this.f1427A.getIntrinsicWidth();
            i2 = view.getLeft();
            r2 = Math.max(0.0f, Math.min(((float) (getWidth() - i2)) / ((float) this.f1444l.m3398b()), 1.0f));
            this.f1427A.setBounds(i2 - i, view.getTop(), i2, view.getBottom());
            this.f1427A.setAlpha((int) (255.0f * r2));
            this.f1427A.draw(canvas);
        }
        return drawChild;
    }

    int m2984e(View view) {
        return C0327v.m2941a(((aa) view.getLayoutParams()).f1569a, cb.m2428h(this));
    }

    public void m2985e(int i) {
        View b = m2976b(i);
        if (b == null) {
            throw new IllegalArgumentException("No drawer view found with gravity " + m2955c(i));
        }
        m2991i(b);
    }

    public boolean m2986f(int i) {
        View b = m2976b(i);
        return b != null ? m2992j(b) : false;
    }

    boolean m2987f(View view) {
        return ((aa) view.getLayoutParams()).f1569a == 0;
    }

    public boolean m2988g(int i) {
        View b = m2976b(i);
        return b != null ? m2993k(b) : false;
    }

    boolean m2989g(View view) {
        return (C0327v.m2941a(((aa) view.getLayoutParams()).f1569a, cb.m2428h(view)) & 7) != 0;
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new aa(-1, -1);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new aa(getContext(), attributeSet);
    }

    protected LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof aa ? new aa((aa) layoutParams) : layoutParams instanceof MarginLayoutParams ? new aa((MarginLayoutParams) layoutParams) : new aa(layoutParams);
    }

    public float getDrawerElevation() {
        return f1426d ? this.f1438f : 0.0f;
    }

    public Drawable getStatusBarBackgroundDrawable() {
        return this.f1457y;
    }

    public void m2990h(View view) {
        if (m2989g(view)) {
            if (this.f1449q) {
                aa aaVar = (aa) view.getLayoutParams();
                aaVar.f1570b = 1.0f;
                aaVar.f1572d = true;
                m2953a(view, true);
            } else if (m2975a(view, 3)) {
                this.f1443k.m3396a(view, 0, view.getTop());
            } else {
                this.f1444l.m3396a(view, getWidth() - view.getWidth(), view.getTop());
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    public void m2991i(View view) {
        if (m2989g(view)) {
            if (this.f1449q) {
                aa aaVar = (aa) view.getLayoutParams();
                aaVar.f1570b = 0.0f;
                aaVar.f1572d = false;
            } else if (m2975a(view, 3)) {
                this.f1443k.m3396a(view, -view.getWidth(), view.getTop());
            } else {
                this.f1444l.m3396a(view, getWidth(), view.getTop());
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    public boolean m2992j(View view) {
        if (m2989g(view)) {
            return ((aa) view.getLayoutParams()).f1572d;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public boolean m2993k(View view) {
        if (m2989g(view)) {
            return ((aa) view.getLayoutParams()).f1570b > 0.0f;
        } else {
            throw new IllegalArgumentException("View " + view + " is not a drawer");
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f1449q = true;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f1449q = true;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f1431E && this.f1457y != null) {
            int a = f1423a.m3436a(this.f1430D);
            if (a > 0) {
                this.f1457y.setBounds(0, 0, getWidth(), a);
                this.f1457y.draw(canvas);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r8) {
        /*
        r7 = this;
        r1 = 1;
        r2 = 0;
        r0 = android.support.v4.view.bf.m2309a(r8);
        r3 = r7.f1443k;
        r3 = r3.m3395a(r8);
        r4 = r7.f1444l;
        r4 = r4.m3395a(r8);
        r3 = r3 | r4;
        switch(r0) {
            case 0: goto L_0x0027;
            case 1: goto L_0x0065;
            case 2: goto L_0x0050;
            case 3: goto L_0x0065;
            default: goto L_0x0016;
        };
    L_0x0016:
        r0 = r2;
    L_0x0017:
        if (r3 != 0) goto L_0x0025;
    L_0x0019:
        if (r0 != 0) goto L_0x0025;
    L_0x001b:
        r0 = r7.m2961i();
        if (r0 != 0) goto L_0x0025;
    L_0x0021:
        r0 = r7.f1453u;
        if (r0 == 0) goto L_0x0026;
    L_0x0025:
        r2 = r1;
    L_0x0026:
        return r2;
    L_0x0027:
        r0 = r8.getX();
        r4 = r8.getY();
        r7.f1455w = r0;
        r7.f1456x = r4;
        r5 = r7.f1441i;
        r6 = 0;
        r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1));
        if (r5 <= 0) goto L_0x006d;
    L_0x003a:
        r5 = r7.f1443k;
        r0 = (int) r0;
        r4 = (int) r4;
        r0 = r5.m3408d(r0, r4);
        if (r0 == 0) goto L_0x006d;
    L_0x0044:
        r0 = r7.m2987f(r0);
        if (r0 == 0) goto L_0x006d;
    L_0x004a:
        r0 = r1;
    L_0x004b:
        r7.f1452t = r2;
        r7.f1453u = r2;
        goto L_0x0017;
    L_0x0050:
        r0 = r7.f1443k;
        r4 = 3;
        r0 = r0.m3409d(r4);
        if (r0 == 0) goto L_0x0016;
    L_0x0059:
        r0 = r7.f1445m;
        r0.m3118a();
        r0 = r7.f1446n;
        r0.m3118a();
        r0 = r2;
        goto L_0x0017;
    L_0x0065:
        r7.m2974a(r1);
        r7.f1452t = r2;
        r7.f1453u = r2;
        goto L_0x0016;
    L_0x006d:
        r0 = r2;
        goto L_0x004b;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.DrawerLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || !m2962j()) {
            return super.onKeyDown(i, keyEvent);
        }
        aa.m2207b(keyEvent);
        return true;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        View k = m2963k();
        if (k != null && m2967a(k) == 0) {
            m2977b();
        }
        return k != null;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.f1448p = true;
        int i5 = i3 - i;
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                aa aaVar = (aa) childAt.getLayoutParams();
                if (m2987f(childAt)) {
                    childAt.layout(aaVar.leftMargin, aaVar.topMargin, aaVar.leftMargin + childAt.getMeasuredWidth(), aaVar.topMargin + childAt.getMeasuredHeight());
                } else {
                    int i7;
                    float f;
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (m2975a(childAt, 3)) {
                        i7 = ((int) (((float) measuredWidth) * aaVar.f1570b)) + (-measuredWidth);
                        f = ((float) (measuredWidth + i7)) / ((float) measuredWidth);
                    } else {
                        i7 = i5 - ((int) (((float) measuredWidth) * aaVar.f1570b));
                        f = ((float) (i5 - i7)) / ((float) measuredWidth);
                    }
                    Object obj = f != aaVar.f1570b ? 1 : null;
                    int i8;
                    switch (aaVar.f1569a & 112) {
                        case Version.API16_JELLY_BEAN_41 /*16*/:
                            int i9 = i4 - i2;
                            i8 = (i9 - measuredHeight) / 2;
                            if (i8 < aaVar.topMargin) {
                                i8 = aaVar.topMargin;
                            } else if (i8 + measuredHeight > i9 - aaVar.bottomMargin) {
                                i8 = (i9 - aaVar.bottomMargin) - measuredHeight;
                            }
                            childAt.layout(i7, i8, measuredWidth + i7, measuredHeight + i8);
                            break;
                        case C1317h.Theme_panelMenuListTheme /*80*/:
                            i8 = i4 - i2;
                            childAt.layout(i7, (i8 - aaVar.bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + i7, i8 - aaVar.bottomMargin);
                            break;
                        default:
                            childAt.layout(i7, aaVar.topMargin, measuredWidth + i7, measuredHeight + aaVar.topMargin);
                            break;
                    }
                    if (obj != null) {
                        m2979b(childAt, f);
                    }
                    int i10 = aaVar.f1570b > 0.0f ? 0 : 4;
                    if (childAt.getVisibility() != i10) {
                        childAt.setVisibility(i10);
                    }
                }
            }
        }
        this.f1448p = false;
        this.f1449q = false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void onMeasure(int r14, int r15) {
        /*
        r13 = this;
        r1 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        r7 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        r4 = 0;
        r12 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r3 = android.view.View.MeasureSpec.getMode(r14);
        r5 = android.view.View.MeasureSpec.getMode(r15);
        r2 = android.view.View.MeasureSpec.getSize(r14);
        r0 = android.view.View.MeasureSpec.getSize(r15);
        if (r3 != r12) goto L_0x001b;
    L_0x0019:
        if (r5 == r12) goto L_0x0056;
    L_0x001b:
        r6 = r13.isInEditMode();
        if (r6 == 0) goto L_0x0058;
    L_0x0021:
        if (r3 != r7) goto L_0x0050;
    L_0x0023:
        if (r5 != r7) goto L_0x0054;
    L_0x0025:
        r1 = r0;
    L_0x0026:
        r13.setMeasuredDimension(r2, r1);
        r0 = r13.f1430D;
        if (r0 == 0) goto L_0x0060;
    L_0x002d:
        r0 = android.support.v4.view.cb.m2447x(r13);
        if (r0 == 0) goto L_0x0060;
    L_0x0033:
        r0 = 1;
        r3 = r0;
    L_0x0035:
        r6 = android.support.v4.view.cb.m2428h(r13);
        r7 = r13.getChildCount();
        r5 = r4;
    L_0x003e:
        if (r5 >= r7) goto L_0x014b;
    L_0x0040:
        r8 = r13.getChildAt(r5);
        r0 = r8.getVisibility();
        r9 = 8;
        if (r0 != r9) goto L_0x0062;
    L_0x004c:
        r0 = r5 + 1;
        r5 = r0;
        goto L_0x003e;
    L_0x0050:
        if (r3 != 0) goto L_0x0023;
    L_0x0052:
        r2 = r1;
        goto L_0x0023;
    L_0x0054:
        if (r5 == 0) goto L_0x0026;
    L_0x0056:
        r1 = r0;
        goto L_0x0026;
    L_0x0058:
        r0 = new java.lang.IllegalArgumentException;
        r1 = "DrawerLayout must be measured with MeasureSpec.EXACTLY.";
        r0.<init>(r1);
        throw r0;
    L_0x0060:
        r3 = r4;
        goto L_0x0035;
    L_0x0062:
        r0 = r8.getLayoutParams();
        r0 = (android.support.v4.widget.aa) r0;
        if (r3 == 0) goto L_0x007d;
    L_0x006a:
        r9 = r0.f1569a;
        r9 = android.support.v4.view.C0327v.m2941a(r9, r6);
        r10 = android.support.v4.view.cb.m2447x(r8);
        if (r10 == 0) goto L_0x009e;
    L_0x0076:
        r10 = f1423a;
        r11 = r13.f1430D;
        r10.m3439a(r8, r11, r9);
    L_0x007d:
        r9 = r13.m2987f(r8);
        if (r9 == 0) goto L_0x00a6;
    L_0x0083:
        r9 = r0.leftMargin;
        r9 = r2 - r9;
        r10 = r0.rightMargin;
        r9 = r9 - r10;
        r9 = android.view.View.MeasureSpec.makeMeasureSpec(r9, r12);
        r10 = r0.topMargin;
        r10 = r1 - r10;
        r0 = r0.bottomMargin;
        r0 = r10 - r0;
        r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r12);
        r8.measure(r9, r0);
        goto L_0x004c;
    L_0x009e:
        r10 = f1423a;
        r11 = r13.f1430D;
        r10.m3440a(r0, r11, r9);
        goto L_0x007d;
    L_0x00a6:
        r9 = r13.m2989g(r8);
        if (r9 == 0) goto L_0x011c;
    L_0x00ac:
        r9 = f1426d;
        if (r9 == 0) goto L_0x00bf;
    L_0x00b0:
        r9 = android.support.v4.view.cb.m2444u(r8);
        r10 = r13.f1438f;
        r9 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1));
        if (r9 == 0) goto L_0x00bf;
    L_0x00ba:
        r9 = r13.f1438f;
        android.support.v4.view.cb.m2432j(r8, r9);
    L_0x00bf:
        r9 = r13.m2984e(r8);
        r9 = r9 & 7;
        r10 = r4 & r9;
        if (r10 == 0) goto L_0x00fe;
    L_0x00c9:
        r0 = new java.lang.IllegalStateException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Child drawer has absolute gravity ";
        r1 = r1.append(r2);
        r2 = m2955c(r9);
        r1 = r1.append(r2);
        r2 = " but this ";
        r1 = r1.append(r2);
        r2 = "DrawerLayout";
        r1 = r1.append(r2);
        r2 = " already has a ";
        r1 = r1.append(r2);
        r2 = "drawer view along that edge";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x00fe:
        r9 = r13.f1439g;
        r10 = r0.leftMargin;
        r9 = r9 + r10;
        r10 = r0.rightMargin;
        r9 = r9 + r10;
        r10 = r0.width;
        r9 = getChildMeasureSpec(r14, r9, r10);
        r10 = r0.topMargin;
        r11 = r0.bottomMargin;
        r10 = r10 + r11;
        r0 = r0.height;
        r0 = getChildMeasureSpec(r15, r10, r0);
        r8.measure(r9, r0);
        goto L_0x004c;
    L_0x011c:
        r0 = new java.lang.IllegalStateException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Child ";
        r1 = r1.append(r2);
        r1 = r1.append(r8);
        r2 = " at index ";
        r1 = r1.append(r2);
        r1 = r1.append(r5);
        r2 = " does not have a valid layout_gravity - must be Gravity.LEFT, ";
        r1 = r1.append(r2);
        r2 = "Gravity.RIGHT or Gravity.NO_GRAVITY";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x014b:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.DrawerLayout.onMeasure(int, int):void");
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.f1420a != 0) {
            View b = m2976b(savedState.f1420a);
            if (b != null) {
                m2990h(b);
            }
        }
        m2970a(savedState.f1421b, 3);
        m2970a(savedState.f1422c, 5);
    }

    public void onRtlPropertiesChanged(int i) {
        m2958f();
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        View a = m2968a();
        if (a != null) {
            savedState.f1420a = ((aa) a.getLayoutParams()).f1569a;
        }
        savedState.f1421b = this.f1450r;
        savedState.f1422c = this.f1451s;
        return savedState;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f1443k.m3399b(motionEvent);
        this.f1444l.m3399b(motionEvent);
        float x;
        float y;
        switch (motionEvent.getAction() & 255) {
            case VideoSize.QCIF /*0*/:
                x = motionEvent.getX();
                y = motionEvent.getY();
                this.f1455w = x;
                this.f1456x = y;
                this.f1452t = false;
                this.f1453u = false;
                break;
            case VideoSize.CIF /*1*/:
                boolean z;
                x = motionEvent.getX();
                y = motionEvent.getY();
                View d = this.f1443k.m3408d((int) x, (int) y);
                if (d != null && m2987f(d)) {
                    x -= this.f1455w;
                    y -= this.f1456x;
                    int d2 = this.f1443k.m3407d();
                    if ((x * x) + (y * y) < ((float) (d2 * d2))) {
                        View a = m2968a();
                        if (a != null) {
                            z = m2967a(a) == 2;
                            m2974a(z);
                            this.f1452t = false;
                            break;
                        }
                    }
                }
                z = true;
                m2974a(z);
                this.f1452t = false;
            case Version.API03_CUPCAKE_15 /*3*/:
                m2974a(true);
                this.f1452t = false;
                this.f1453u = false;
                break;
        }
        return true;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        this.f1452t = z;
        if (z) {
            m2974a(true);
        }
    }

    public void requestLayout() {
        if (!this.f1448p) {
            super.requestLayout();
        }
    }

    public void setDrawerElevation(float f) {
        this.f1438f = f;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (m2989g(childAt)) {
                cb.m2432j(childAt, this.f1438f);
            }
        }
    }

    public void setDrawerListener(C0357z c0357z) {
        this.f1454v = c0357z;
    }

    public void setDrawerLockMode(int i) {
        m2970a(i, 3);
        m2970a(i, 5);
    }

    public void setScrimColor(int i) {
        this.f1440h = i;
        invalidate();
    }

    public void setStatusBarBackground(int i) {
        this.f1457y = i != 0 ? C0125h.m1018a(getContext(), i) : null;
        invalidate();
    }

    public void setStatusBarBackground(Drawable drawable) {
        this.f1457y = drawable;
        invalidate();
    }

    public void setStatusBarBackgroundColor(int i) {
        this.f1457y = new ColorDrawable(i);
        invalidate();
    }
}
