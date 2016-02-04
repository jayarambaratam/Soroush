package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.view.bf;
import android.support.v4.view.bo;
import android.support.v4.view.bp;
import android.support.v4.view.bq;
import android.support.v4.view.br;
import android.support.v4.view.cb;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

public class SwipeRefreshLayout extends ViewGroup implements bo, bq {
    private static final String f1509c;
    private static final int[] f1510y;
    private int f1511A;
    private float f1512B;
    private ap f1513C;
    private Animation f1514D;
    private Animation f1515E;
    private Animation f1516F;
    private Animation f1517G;
    private Animation f1518H;
    private float f1519I;
    private boolean f1520J;
    private int f1521K;
    private int f1522L;
    private boolean f1523M;
    private AnimationListener f1524N;
    private final Animation f1525O;
    private final Animation f1526P;
    protected int f1527a;
    protected int f1528b;
    private View f1529d;
    private ch f1530e;
    private boolean f1531f;
    private int f1532g;
    private float f1533h;
    private float f1534i;
    private final br f1535j;
    private final bp f1536k;
    private final int[] f1537l;
    private final int[] f1538m;
    private boolean f1539n;
    private int f1540o;
    private int f1541p;
    private boolean f1542q;
    private float f1543r;
    private float f1544s;
    private boolean f1545t;
    private int f1546u;
    private boolean f1547v;
    private boolean f1548w;
    private final DecelerateInterpolator f1549x;
    private C0338e f1550z;

    static {
        f1509c = SwipeRefreshLayout.class.getSimpleName();
        f1510y = new int[]{16842766};
    }

    public SwipeRefreshLayout(Context context) {
        this(context, null);
    }

    public SwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1531f = false;
        this.f1533h = -1.0f;
        this.f1537l = new int[2];
        this.f1538m = new int[2];
        this.f1542q = false;
        this.f1546u = -1;
        this.f1511A = -1;
        this.f1524N = new bz(this);
        this.f1525O = new ce(this);
        this.f1526P = new cf(this);
        this.f1532g = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f1540o = getResources().getInteger(17694721);
        setWillNotDraw(false);
        this.f1549x = new DecelerateInterpolator(2.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f1510y);
        setEnabled(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.f1521K = (int) (displayMetrics.density * 40.0f);
        this.f1522L = (int) (displayMetrics.density * 40.0f);
        m3057b();
        cb.m2405a((ViewGroup) this, true);
        this.f1519I = displayMetrics.density * 64.0f;
        this.f1533h = this.f1519I;
        this.f1535j = new br(this);
        this.f1536k = new bp(this);
        setNestedScrollingEnabled(true);
    }

    private float m3041a(MotionEvent motionEvent, int i) {
        int a = bf.m2310a(motionEvent, i);
        return a < 0 ? -1.0f : bf.m2315d(motionEvent, a);
    }

    private Animation m3042a(int i, int i2) {
        if (this.f1547v && m3064c()) {
            return null;
        }
        Animation ccVar = new cc(this, i, i2);
        ccVar.setDuration(300);
        this.f1550z.m3415a(null);
        this.f1550z.clearAnimation();
        this.f1550z.startAnimation(ccVar);
        return ccVar;
    }

    private void m3043a(float f) {
        this.f1513C.m3197a(true);
        float min = Math.min(1.0f, Math.abs(f / this.f1533h));
        float max = (((float) Math.max(((double) min) - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        float abs = Math.abs(f) - this.f1533h;
        float f2 = this.f1523M ? this.f1519I - ((float) this.f1528b) : this.f1519I;
        abs = Math.max(0.0f, Math.min(abs, f2 * 2.0f) / f2);
        abs = ((float) (((double) (abs / 4.0f)) - Math.pow((double) (abs / 4.0f), 2.0d))) * 2.0f;
        int i = ((int) ((f2 * min) + ((f2 * abs) * 2.0f))) + this.f1528b;
        if (this.f1550z.getVisibility() != 0) {
            this.f1550z.setVisibility(0);
        }
        if (!this.f1547v) {
            cb.m2427g(this.f1550z, 1.0f);
            cb.m2429h(this.f1550z, 1.0f);
        }
        if (f < this.f1533h) {
            if (this.f1547v) {
                setAnimationProgress(f / this.f1533h);
            }
            if (this.f1513C.getAlpha() > 76 && !m3054a(this.f1516F)) {
                m3067d();
            }
            this.f1513C.m3195a(0.0f, Math.min(0.8f, max * 0.8f));
            this.f1513C.m3194a(Math.min(1.0f, max));
        } else if (this.f1513C.getAlpha() < 255 && !m3054a(this.f1517G)) {
            m3069e();
        }
        this.f1513C.m3199b(((-0.25f + (max * 0.4f)) + (abs * 2.0f)) * 0.5f);
        m3045a(i - this.f1541p, true);
    }

    private void m3044a(int i, AnimationListener animationListener) {
        this.f1527a = i;
        this.f1525O.reset();
        this.f1525O.setDuration(200);
        this.f1525O.setInterpolator(this.f1549x);
        if (animationListener != null) {
            this.f1550z.m3415a(animationListener);
        }
        this.f1550z.clearAnimation();
        this.f1550z.startAnimation(this.f1525O);
    }

    private void m3045a(int i, boolean z) {
        this.f1550z.bringToFront();
        this.f1550z.offsetTopAndBottom(i);
        this.f1541p = this.f1550z.getTop();
        if (z && VERSION.SDK_INT < 11) {
            invalidate();
        }
    }

    private void m3050a(MotionEvent motionEvent) {
        int b = bf.m2311b(motionEvent);
        if (bf.m2312b(motionEvent, b) == this.f1546u) {
            this.f1546u = bf.m2312b(motionEvent, b == 0 ? 1 : 0);
        }
    }

    private void m3051a(AnimationListener animationListener) {
        this.f1550z.setVisibility(0);
        if (VERSION.SDK_INT >= 11) {
            this.f1513C.setAlpha(255);
        }
        this.f1514D = new ca(this);
        this.f1514D.setDuration((long) this.f1540o);
        if (animationListener != null) {
            this.f1550z.m3415a(animationListener);
        }
        this.f1550z.clearAnimation();
        this.f1550z.startAnimation(this.f1514D);
    }

    private void m3052a(boolean z, boolean z2) {
        if (this.f1531f != z) {
            this.f1520J = z2;
            m3070f();
            this.f1531f = z;
            if (this.f1531f) {
                m3044a(this.f1541p, this.f1524N);
            } else {
                m3061b(this.f1524N);
            }
        }
    }

    private boolean m3054a(Animation animation) {
        return (animation == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void m3057b() {
        this.f1550z = new C0338e(getContext(), -328966, 20.0f);
        this.f1513C = new ap(getContext(), this);
        this.f1513C.m3200b(-328966);
        this.f1550z.setImageDrawable(this.f1513C);
        this.f1550z.setVisibility(8);
        addView(this.f1550z);
    }

    private void m3058b(float f) {
        if (f > this.f1533h) {
            m3052a(true, true);
            return;
        }
        this.f1531f = false;
        this.f1513C.m3195a(0.0f, 0.0f);
        AnimationListener animationListener = null;
        if (!this.f1547v) {
            animationListener = new cd(this);
        }
        m3059b(this.f1541p, animationListener);
        this.f1513C.m3197a(false);
    }

    private void m3059b(int i, AnimationListener animationListener) {
        if (this.f1547v) {
            m3063c(i, animationListener);
            return;
        }
        this.f1527a = i;
        this.f1526P.reset();
        this.f1526P.setDuration(200);
        this.f1526P.setInterpolator(this.f1549x);
        if (animationListener != null) {
            this.f1550z.m3415a(animationListener);
        }
        this.f1550z.clearAnimation();
        this.f1550z.startAnimation(this.f1526P);
    }

    private void m3061b(AnimationListener animationListener) {
        this.f1515E = new cb(this);
        this.f1515E.setDuration(150);
        this.f1550z.m3415a(animationListener);
        this.f1550z.clearAnimation();
        this.f1550z.startAnimation(this.f1515E);
    }

    private void m3062c(float f) {
        m3045a((this.f1527a + ((int) (((float) (this.f1528b - this.f1527a)) * f))) - this.f1550z.getTop(), false);
    }

    private void m3063c(int i, AnimationListener animationListener) {
        this.f1527a = i;
        if (m3064c()) {
            this.f1512B = (float) this.f1513C.getAlpha();
        } else {
            this.f1512B = cb.m2443t(this.f1550z);
        }
        this.f1518H = new cg(this);
        this.f1518H.setDuration(150);
        if (animationListener != null) {
            this.f1550z.m3415a(animationListener);
        }
        this.f1550z.clearAnimation();
        this.f1550z.startAnimation(this.f1518H);
    }

    private boolean m3064c() {
        return VERSION.SDK_INT < 11;
    }

    private void m3067d() {
        this.f1516F = m3042a(this.f1513C.getAlpha(), 76);
    }

    private void m3069e() {
        this.f1517G = m3042a(this.f1513C.getAlpha(), 255);
    }

    private void m3070f() {
        if (this.f1529d == null) {
            int i = 0;
            while (i < getChildCount()) {
                View childAt = getChildAt(i);
                if (childAt.equals(this.f1550z)) {
                    i++;
                } else {
                    this.f1529d = childAt;
                    return;
                }
            }
        }
    }

    private void setAnimationProgress(float f) {
        if (m3064c()) {
            setColorViewAlpha((int) (255.0f * f));
            return;
        }
        cb.m2427g(this.f1550z, f);
        cb.m2429h(this.f1550z, f);
    }

    private void setColorViewAlpha(int i) {
        this.f1550z.getBackground().setAlpha(i);
        this.f1513C.setAlpha(i);
    }

    public boolean m3076a() {
        boolean z = false;
        if (VERSION.SDK_INT >= 14) {
            return cb.m2412b(this.f1529d, -1);
        }
        if (this.f1529d instanceof AbsListView) {
            AbsListView absListView = (AbsListView) this.f1529d;
            return absListView.getChildCount() > 0 && (absListView.getFirstVisiblePosition() > 0 || absListView.getChildAt(0).getTop() < absListView.getPaddingTop());
        } else {
            if (cb.m2412b(this.f1529d, -1) || this.f1529d.getScrollY() > 0) {
                z = true;
            }
            return z;
        }
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.f1536k.m2349a(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.f1536k.m2348a(f, f2);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.f1536k.m2352a(i, i2, iArr, iArr2);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.f1536k.m2351a(i, i2, i3, i4, iArr);
    }

    protected int getChildDrawingOrder(int i, int i2) {
        return this.f1511A < 0 ? i2 : i2 == i + -1 ? this.f1511A : i2 >= this.f1511A ? i2 + 1 : i2;
    }

    public int getNestedScrollAxes() {
        return this.f1535j.m2355a();
    }

    public int getProgressCircleDiameter() {
        return this.f1550z != null ? this.f1550z.getMeasuredHeight() : 0;
    }

    public boolean hasNestedScrollingParent() {
        return this.f1536k.m2353b();
    }

    public boolean isNestedScrollingEnabled() {
        return this.f1536k.m2347a();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        m3070f();
        int a = bf.m2309a(motionEvent);
        if (this.f1548w && a == 0) {
            this.f1548w = false;
        }
        if (!isEnabled() || this.f1548w || m3076a() || this.f1531f || this.f1539n) {
            return false;
        }
        float a2;
        switch (a) {
            case VideoSize.QCIF /*0*/:
                m3045a(this.f1528b - this.f1550z.getTop(), true);
                this.f1546u = bf.m2312b(motionEvent, 0);
                this.f1545t = false;
                a2 = m3041a(motionEvent, this.f1546u);
                if (a2 != -1.0f) {
                    this.f1544s = a2;
                    break;
                }
                return false;
            case VideoSize.CIF /*1*/:
            case Version.API03_CUPCAKE_15 /*3*/:
                this.f1545t = false;
                this.f1546u = -1;
                break;
            case VideoSize.HVGA /*2*/:
                if (this.f1546u == -1) {
                    Log.e(f1509c, "Got ACTION_MOVE event but don't have an active pointer id.");
                    return false;
                }
                a2 = m3041a(motionEvent, this.f1546u);
                if (a2 != -1.0f) {
                    if (a2 - this.f1544s > ((float) this.f1532g) && !this.f1545t) {
                        this.f1543r = this.f1544s + ((float) this.f1532g);
                        this.f1545t = true;
                        this.f1513C.setAlpha(76);
                        break;
                    }
                }
                return false;
            case Version.API06_ECLAIR_201 /*6*/:
                m3050a(motionEvent);
                break;
        }
        return this.f1545t;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() != 0) {
            if (this.f1529d == null) {
                m3070f();
            }
            if (this.f1529d != null) {
                View view = this.f1529d;
                int paddingLeft = getPaddingLeft();
                int paddingTop = getPaddingTop();
                view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
                measuredHeight = this.f1550z.getMeasuredWidth();
                this.f1550z.layout((measuredWidth / 2) - (measuredHeight / 2), this.f1541p, (measuredWidth / 2) + (measuredHeight / 2), this.f1541p + this.f1550z.getMeasuredHeight());
            }
        }
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f1529d == null) {
            m3070f();
        }
        if (this.f1529d != null) {
            int i3;
            this.f1529d.measure(MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
            this.f1550z.measure(MeasureSpec.makeMeasureSpec(this.f1521K, 1073741824), MeasureSpec.makeMeasureSpec(this.f1522L, 1073741824));
            if (!(this.f1523M || this.f1542q)) {
                this.f1542q = true;
                i3 = -this.f1550z.getMeasuredHeight();
                this.f1528b = i3;
                this.f1541p = i3;
            }
            this.f1511A = -1;
            for (i3 = 0; i3 < getChildCount(); i3++) {
                if (getChildAt(i3) == this.f1550z) {
                    this.f1511A = i3;
                    return;
                }
            }
        }
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        return dispatchNestedFling(f, f2, z);
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        if (i2 > 0 && this.f1534i > 0.0f) {
            if (((float) i2) > this.f1534i) {
                iArr[1] = i2 - ((int) this.f1534i);
                this.f1534i = 0.0f;
            } else {
                this.f1534i -= (float) i2;
                iArr[1] = i2;
            }
            m3043a(this.f1534i);
        }
        if (this.f1523M && i2 > 0 && this.f1534i == 0.0f && Math.abs(i2 - iArr[1]) > 0) {
            this.f1550z.setVisibility(8);
        }
        int[] iArr2 = this.f1537l;
        if (dispatchNestedPreScroll(i - iArr[0], i2 - iArr[1], iArr2, null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr2[1] + iArr[1];
        }
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        dispatchNestedScroll(i, i2, i3, i4, this.f1538m);
        int i5 = this.f1538m[1] + i4;
        if (i5 < 0) {
            this.f1534i = ((float) Math.abs(i5)) + this.f1534i;
            m3043a(this.f1534i);
        }
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f1535j.m2357a(view, view2, i);
        startNestedScroll(i & 2);
        this.f1534i = 0.0f;
        this.f1539n = true;
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return (!isEnabled() || this.f1548w || this.f1531f || (i & 2) == 0) ? false : true;
    }

    public void onStopNestedScroll(View view) {
        this.f1535j.m2356a(view);
        this.f1539n = false;
        if (this.f1534i > 0.0f) {
            m3058b(this.f1534i);
            this.f1534i = 0.0f;
        }
        stopNestedScroll();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = bf.m2309a(motionEvent);
        if (this.f1548w && a == 0) {
            this.f1548w = false;
        }
        if (!isEnabled() || this.f1548w || m3076a() || this.f1539n) {
            return false;
        }
        float d;
        switch (a) {
            case VideoSize.QCIF /*0*/:
                this.f1546u = bf.m2312b(motionEvent, 0);
                this.f1545t = false;
                break;
            case VideoSize.CIF /*1*/:
                a = bf.m2310a(motionEvent, this.f1546u);
                if (a < 0) {
                    Log.e(f1509c, "Got ACTION_UP event but don't have an active pointer id.");
                    return false;
                }
                d = (bf.m2315d(motionEvent, a) - this.f1543r) * 0.5f;
                this.f1545t = false;
                m3058b(d);
                this.f1546u = -1;
                return false;
            case VideoSize.HVGA /*2*/:
                a = bf.m2310a(motionEvent, this.f1546u);
                if (a < 0) {
                    Log.e(f1509c, "Got ACTION_MOVE event but have an invalid active pointer id.");
                    return false;
                }
                d = (bf.m2315d(motionEvent, a) - this.f1543r) * 0.5f;
                if (this.f1545t) {
                    if (d > 0.0f) {
                        m3043a(d);
                        break;
                    }
                    return false;
                }
                break;
            case Version.API03_CUPCAKE_15 /*3*/:
                return false;
            case Version.API05_ECLAIR_20 /*5*/:
                a = bf.m2311b(motionEvent);
                if (a >= 0) {
                    this.f1546u = bf.m2312b(motionEvent, a);
                    break;
                }
                Log.e(f1509c, "Got ACTION_POINTER_DOWN event but have an invalid action index.");
                return false;
            case Version.API06_ECLAIR_201 /*6*/:
                m3050a(motionEvent);
                break;
        }
        return true;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (VERSION.SDK_INT < 21 && (this.f1529d instanceof AbsListView)) {
            return;
        }
        if (this.f1529d == null || cb.m2383B(this.f1529d)) {
            super.requestDisallowInterceptTouchEvent(z);
        }
    }

    @Deprecated
    public void setColorScheme(int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeColors(int... iArr) {
        m3070f();
        this.f1513C.m3198a(iArr);
    }

    public void setColorSchemeResources(int... iArr) {
        Resources resources = getResources();
        int[] iArr2 = new int[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            iArr2[i] = resources.getColor(iArr[i]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setDistanceToTriggerSync(int i) {
        this.f1533h = (float) i;
    }

    public void setNestedScrollingEnabled(boolean z) {
        this.f1536k.m2346a(z);
    }

    public void setOnRefreshListener(ch chVar) {
        this.f1530e = chVar;
    }

    @Deprecated
    public void setProgressBackgroundColor(int i) {
        setProgressBackgroundColorSchemeResource(i);
    }

    public void setProgressBackgroundColorSchemeColor(int i) {
        this.f1550z.setBackgroundColor(i);
        this.f1513C.m3200b(i);
    }

    public void setProgressBackgroundColorSchemeResource(int i) {
        setProgressBackgroundColorSchemeColor(getResources().getColor(i));
    }

    public void setRefreshing(boolean z) {
        if (!z || this.f1531f == z) {
            m3052a(z, false);
            return;
        }
        this.f1531f = z;
        m3045a((!this.f1523M ? (int) (this.f1519I + ((float) this.f1528b)) : (int) this.f1519I) - this.f1541p, true);
        this.f1520J = false;
        m3051a(this.f1524N);
    }

    public void setSize(int i) {
        if (i == 0 || i == 1) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            int i2;
            if (i == 0) {
                i2 = (int) (displayMetrics.density * 56.0f);
                this.f1521K = i2;
                this.f1522L = i2;
            } else {
                i2 = (int) (displayMetrics.density * 40.0f);
                this.f1521K = i2;
                this.f1522L = i2;
            }
            this.f1550z.setImageDrawable(null);
            this.f1513C.m3196a(i);
            this.f1550z.setImageDrawable(this.f1513C);
        }
    }

    public boolean startNestedScroll(int i) {
        return this.f1536k.m2350a(i);
    }

    public void stopNestedScroll() {
        this.f1536k.m2354c();
    }
}
