package mobi.mmdt.ott.view.main.basenavigation.viewpager;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.os.C0269j;
import android.support.v4.view.aa;
import android.support.v4.view.bf;
import android.support.v4.view.bt;
import android.support.v4.view.bw;
import android.support.v4.view.cb;
import android.support.v4.view.db;
import android.support.v4.view.dz;
import android.support.v4.view.ea;
import android.support.v4.widget.ah;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import mobi.mmdt.ott.C1317h;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

public class VerticalViewPager extends ViewGroup {
    private static final int[] f7662a;
    private static final C2338m ag;
    private static final Comparator<C2332g> f7663c;
    private static final Interpolator f7664d;
    private boolean f7665A;
    private boolean f7666B;
    private int f7667C;
    private int f7668D;
    private int f7669E;
    private float f7670F;
    private float f7671G;
    private float f7672H;
    private float f7673I;
    private int f7674J;
    private VelocityTracker f7675K;
    private int f7676L;
    private int f7677M;
    private int f7678N;
    private int f7679O;
    private boolean f7680P;
    private ah f7681Q;
    private ah f7682R;
    private boolean f7683S;
    private boolean f7684T;
    private boolean f7685U;
    private int f7686V;
    private dz f7687W;
    private dz aa;
    private C2335j ab;
    private ea ac;
    private Method ad;
    private int ae;
    private ArrayList<View> af;
    private final Runnable ah;
    private int ai;
    private int f7688b;
    private final ArrayList<C2332g> f7689e;
    private final C2332g f7690f;
    private final Rect f7691g;
    private bt f7692h;
    private int f7693i;
    private int f7694j;
    private Parcelable f7695k;
    private ClassLoader f7696l;
    private Scroller f7697m;
    private C2336k f7698n;
    private int f7699o;
    private Drawable f7700p;
    private int f7701q;
    private int f7702r;
    private float f7703s;
    private float f7704t;
    private int f7705u;
    private int f7706v;
    private boolean f7707w;
    private boolean f7708x;
    private boolean f7709y;
    private int f7710z;

    public class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR;
        int f7712a;
        Parcelable f7713b;
        ClassLoader f7714c;

        static {
            CREATOR = C0269j.m1809a(new C2337l());
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            if (classLoader == null) {
                classLoader = getClass().getClassLoader();
            }
            this.f7712a = parcel.readInt();
            this.f7713b = parcel.readParcelable(classLoader);
            this.f7714c = classLoader;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f7712a + "}";
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f7712a);
            parcel.writeParcelable(this.f7713b, i);
        }
    }

    static {
        f7662a = new int[]{16842931};
        f7663c = new C2328c();
        f7664d = new C2329d();
        ag = new C2338m();
    }

    public VerticalViewPager(Context context) {
        super(context);
        this.f7689e = new ArrayList();
        this.f7690f = new C2332g();
        this.f7691g = new Rect();
        this.f7694j = -1;
        this.f7695k = null;
        this.f7696l = null;
        this.f7703s = -3.4028235E38f;
        this.f7704t = Float.MAX_VALUE;
        this.f7710z = 1;
        this.f7674J = -1;
        this.f7683S = true;
        this.f7684T = false;
        this.ah = new C2330e(this);
        this.ai = 0;
        m10479a();
    }

    public VerticalViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7689e = new ArrayList();
        this.f7690f = new C2332g();
        this.f7691g = new Rect();
        this.f7694j = -1;
        this.f7695k = null;
        this.f7696l = null;
        this.f7703s = -3.4028235E38f;
        this.f7704t = Float.MAX_VALUE;
        this.f7710z = 1;
        this.f7674J = -1;
        this.f7683S = true;
        this.f7684T = false;
        this.ah = new C2330e(this);
        this.ai = 0;
        m10479a();
    }

    private int m10456a(int i, float f, int i2, int i3) {
        if (Math.abs(i3) <= this.f7678N || Math.abs(i2) <= this.f7676L) {
            i = (int) ((i >= this.f7693i ? 0.4f : 0.6f) + (((float) i) + f));
        } else if (i2 <= 0) {
            i++;
        }
        if (this.f7689e.size() <= 0) {
            return i;
        }
        return Math.max(((C2332g) this.f7689e.get(0)).f7717b, Math.min(i, ((C2332g) this.f7689e.get(this.f7689e.size() - 1)).f7717b));
    }

    private Rect m10457a(Rect rect, View view) {
        Rect rect2 = rect == null ? new Rect() : rect;
        if (view == null) {
            rect2.set(0, 0, 0, 0);
            return rect2;
        }
        rect2.left = view.getLeft();
        rect2.right = view.getRight();
        rect2.top = view.getTop();
        rect2.bottom = view.getBottom();
        VerticalViewPager parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = parent;
            rect2.left += viewGroup.getLeft();
            rect2.right += viewGroup.getRight();
            rect2.top += viewGroup.getTop();
            rect2.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect2;
    }

    private void m10459a(int i, int i2, int i3, int i4) {
        if (i2 <= 0 || this.f7689e.isEmpty()) {
            C2332g b = m10488b(this.f7693i);
            int min = (int) ((b != null ? Math.min(b.f7720e, this.f7704t) : 0.0f) * ((float) ((i - getPaddingTop()) - getPaddingBottom())));
            if (min != getScrollY()) {
                m10464a(false);
                scrollTo(getScrollX(), min);
                return;
            }
            return;
        }
        int paddingTop = (int) (((float) (((i - getPaddingTop()) - getPaddingBottom()) + i3)) * (((float) getScrollY()) / ((float) (((i2 - getPaddingTop()) - getPaddingBottom()) + i4))));
        scrollTo(getScrollX(), paddingTop);
        if (!this.f7697m.isFinished()) {
            this.f7697m.startScroll(0, paddingTop, 0, (int) (m10488b(this.f7693i).f7720e * ((float) i)), this.f7697m.getDuration() - this.f7697m.timePassed());
        }
    }

    private void m10460a(int i, boolean z, int i2, boolean z2) {
        int max;
        C2332g b = m10488b(i);
        if (b != null) {
            max = (int) (Math.max(this.f7703s, Math.min(b.f7720e, this.f7704t)) * ((float) getClientHeight()));
        } else {
            max = 0;
        }
        if (z) {
            m10482a(0, max, i2);
            if (z2 && this.f7687W != null) {
                this.f7687W.m665b(i);
            }
            if (z2 && this.aa != null) {
                this.aa.m665b(i);
                return;
            }
            return;
        }
        if (z2 && this.f7687W != null) {
            this.f7687W.m665b(i);
        }
        if (z2 && this.aa != null) {
            this.aa.m665b(i);
        }
        m10464a(false);
        scrollTo(0, max);
        m10470e(max);
    }

    private void m10461a(MotionEvent motionEvent) {
        int b = bf.m2311b(motionEvent);
        if (bf.m2312b(motionEvent, b) == this.f7674J) {
            b = b == 0 ? 1 : 0;
            this.f7671G = bf.m2315d(motionEvent, b);
            this.f7674J = bf.m2312b(motionEvent, b);
            if (this.f7675K != null) {
                this.f7675K.clear();
            }
        }
    }

    private void m10463a(C2332g c2332g, int i, C2332g c2332g2) {
        float f;
        int i2;
        C2332g c2332g3;
        int i3;
        int b = this.f7692h.m871b();
        int clientHeight = getClientHeight();
        float f2 = clientHeight > 0 ? ((float) this.f7699o) / ((float) clientHeight) : 0.0f;
        if (c2332g2 != null) {
            clientHeight = c2332g2.f7717b;
            int i4;
            if (clientHeight < c2332g.f7717b) {
                f = (c2332g2.f7720e + c2332g2.f7719d) + f2;
                i4 = clientHeight + 1;
                i2 = 0;
                while (i4 <= c2332g.f7717b && i2 < this.f7689e.size()) {
                    c2332g3 = (C2332g) this.f7689e.get(i2);
                    while (i4 > c2332g3.f7717b && i2 < this.f7689e.size() - 1) {
                        i2++;
                        c2332g3 = (C2332g) this.f7689e.get(i2);
                    }
                    while (i4 < c2332g3.f7717b) {
                        f += this.f7692h.m879d(i4) + f2;
                        i4++;
                    }
                    c2332g3.f7720e = f;
                    f += c2332g3.f7719d + f2;
                    i4++;
                }
            } else if (clientHeight > c2332g.f7717b) {
                i2 = this.f7689e.size() - 1;
                f = c2332g2.f7720e;
                i4 = clientHeight - 1;
                while (i4 >= c2332g.f7717b && i2 >= 0) {
                    c2332g3 = (C2332g) this.f7689e.get(i2);
                    while (i4 < c2332g3.f7717b && i2 > 0) {
                        i2--;
                        c2332g3 = (C2332g) this.f7689e.get(i2);
                    }
                    while (i4 > c2332g3.f7717b) {
                        f -= this.f7692h.m879d(i4) + f2;
                        i4--;
                    }
                    f -= c2332g3.f7719d + f2;
                    c2332g3.f7720e = f;
                    i4--;
                }
            }
        }
        int size = this.f7689e.size();
        float f3 = c2332g.f7720e;
        i2 = c2332g.f7717b - 1;
        this.f7703s = c2332g.f7717b == 0 ? c2332g.f7720e : -3.4028235E38f;
        this.f7704t = c2332g.f7717b == b + -1 ? (c2332g.f7720e + c2332g.f7719d) - 1.0f : Float.MAX_VALUE;
        for (i3 = i - 1; i3 >= 0; i3--) {
            c2332g3 = (C2332g) this.f7689e.get(i3);
            f = f3;
            while (i2 > c2332g3.f7717b) {
                f -= this.f7692h.m879d(i2) + f2;
                i2--;
            }
            f3 = f - (c2332g3.f7719d + f2);
            c2332g3.f7720e = f3;
            if (c2332g3.f7717b == 0) {
                this.f7703s = f3;
            }
            i2--;
        }
        f3 = (c2332g.f7720e + c2332g.f7719d) + f2;
        i2 = c2332g.f7717b + 1;
        for (i3 = i + 1; i3 < size; i3++) {
            c2332g3 = (C2332g) this.f7689e.get(i3);
            f = f3;
            while (i2 < c2332g3.f7717b) {
                f = (this.f7692h.m879d(i2) + f2) + f;
                i2++;
            }
            if (c2332g3.f7717b == b - 1) {
                this.f7704t = (c2332g3.f7719d + f) - 1.0f;
            }
            c2332g3.f7720e = f;
            f3 = f + (c2332g3.f7719d + f2);
            i2++;
        }
        this.f7684T = false;
    }

    private void m10464a(boolean z) {
        int scrollX;
        boolean z2 = this.ai == 2;
        if (z2) {
            setScrollingCacheEnabled(false);
            this.f7697m.abortAnimation();
            scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.f7697m.getCurrX();
            int currY = this.f7697m.getCurrY();
            if (!(scrollX == currX && scrollY == currY)) {
                scrollTo(currX, currY);
            }
        }
        this.f7709y = false;
        boolean z3 = z2;
        for (scrollX = 0; scrollX < this.f7689e.size(); scrollX++) {
            C2332g c2332g = (C2332g) this.f7689e.get(scrollX);
            if (c2332g.f7718c) {
                c2332g.f7718c = false;
                z3 = true;
            }
        }
        if (!z3) {
            return;
        }
        if (z) {
            cb.m2402a((View) this, this.ah);
        } else {
            this.ah.run();
        }
    }

    private boolean m10465a(float f, float f2) {
        return (f < ((float) this.f7668D) && f2 > 0.0f) || (f > ((float) (getHeight() - this.f7668D)) && f2 < 0.0f);
    }

    private void m10467b(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            cb.m2396a(getChildAt(i), z ? 2 : 0, null);
        }
    }

    private boolean m10468b(float f) {
        boolean z;
        float f2;
        boolean z2 = true;
        boolean z3 = false;
        float f3 = this.f7671G - f;
        this.f7671G = f;
        float scrollY = ((float) getScrollY()) + f3;
        int clientHeight = getClientHeight();
        float f4 = ((float) clientHeight) * this.f7703s;
        float f5 = ((float) clientHeight) * this.f7704t;
        C2332g c2332g = (C2332g) this.f7689e.get(0);
        C2332g c2332g2 = (C2332g) this.f7689e.get(this.f7689e.size() - 1);
        if (c2332g.f7717b != 0) {
            f4 = c2332g.f7720e * ((float) clientHeight);
            z = false;
        } else {
            z = true;
        }
        if (c2332g2.f7717b != this.f7692h.m871b() - 1) {
            f2 = c2332g2.f7720e * ((float) clientHeight);
            z2 = false;
        } else {
            f2 = f5;
        }
        if (scrollY < f4) {
            if (z) {
                z3 = this.f7681Q.m3136a(Math.abs(f4 - scrollY) / ((float) clientHeight));
            }
        } else if (scrollY > f2) {
            if (z2) {
                z3 = this.f7682R.m3136a(Math.abs(scrollY - f2) / ((float) clientHeight));
            }
            f4 = f2;
        } else {
            f4 = scrollY;
        }
        this.f7670F += f4 - ((float) ((int) f4));
        scrollTo(getScrollX(), (int) f4);
        m10470e((int) f4);
        return z3;
    }

    private void m10469c(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    private boolean m10470e(int i) {
        if (this.f7689e.size() == 0) {
            this.f7685U = false;
            m10481a(0, 0.0f, 0);
            if (this.f7685U) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        C2332g i2 = m10474i();
        int clientHeight = getClientHeight();
        int i3 = this.f7699o + clientHeight;
        float f = ((float) this.f7699o) / ((float) clientHeight);
        int i4 = i2.f7717b;
        float f2 = ((((float) i) / ((float) clientHeight)) - i2.f7720e) / (i2.f7719d + f);
        clientHeight = (int) (((float) i3) * f2);
        this.f7685U = false;
        m10481a(i4, f2, clientHeight);
        if (this.f7685U) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    private void m10472g() {
        int i = 0;
        while (i < getChildCount()) {
            if (!((C2333h) getChildAt(i).getLayoutParams()).f7721a) {
                removeViewAt(i);
                i--;
            }
            i++;
        }
    }

    private int getClientHeight() {
        return (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
    }

    private void m10473h() {
        if (this.ae != 0) {
            if (this.af == null) {
                this.af = new ArrayList();
            } else {
                this.af.clear();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.af.add(getChildAt(i));
            }
            Collections.sort(this.af, ag);
        }
    }

    private C2332g m10474i() {
        int clientHeight = getClientHeight();
        float scrollY = clientHeight > 0 ? ((float) getScrollY()) / ((float) clientHeight) : 0.0f;
        float f = clientHeight > 0 ? ((float) this.f7699o) / ((float) clientHeight) : 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        int i = -1;
        int i2 = 0;
        Object obj = 1;
        C2332g c2332g = null;
        while (i2 < this.f7689e.size()) {
            int i3;
            C2332g c2332g2;
            C2332g c2332g3 = (C2332g) this.f7689e.get(i2);
            C2332g c2332g4;
            if (obj != null || c2332g3.f7717b == i + 1) {
                c2332g4 = c2332g3;
                i3 = i2;
                c2332g2 = c2332g4;
            } else {
                c2332g3 = this.f7690f;
                c2332g3.f7720e = (f2 + f3) + f;
                c2332g3.f7717b = i + 1;
                c2332g3.f7719d = this.f7692h.m879d(c2332g3.f7717b);
                c2332g4 = c2332g3;
                i3 = i2 - 1;
                c2332g2 = c2332g4;
            }
            f2 = c2332g2.f7720e;
            f3 = (c2332g2.f7719d + f2) + f;
            if (obj == null && scrollY < f2) {
                return c2332g;
            }
            if (scrollY < f3 || i3 == this.f7689e.size() - 1) {
                return c2332g2;
            }
            f3 = f2;
            i = c2332g2.f7717b;
            obj = null;
            f2 = c2332g2.f7719d;
            c2332g = c2332g2;
            i2 = i3 + 1;
        }
        return c2332g;
    }

    private void m10475j() {
        this.f7665A = false;
        this.f7666B = false;
        if (this.f7675K != null) {
            this.f7675K.recycle();
            this.f7675K = null;
        }
    }

    private void setScrollState(int i) {
        if (this.ai != i) {
            this.ai = i;
            if (this.ac != null) {
                m10467b(i != 0);
            }
            if (this.f7687W != null) {
                this.f7687W.m663a(i);
            }
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.f7708x != z) {
            this.f7708x = z;
        }
    }

    float m10476a(float f) {
        return (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
    }

    C2332g m10477a(int i, int i2) {
        C2332g c2332g = new C2332g();
        c2332g.f7717b = i;
        c2332g.f7716a = this.f7692h.m863a((ViewGroup) this, i);
        c2332g.f7719d = this.f7692h.m879d(i);
        if (i2 < 0 || i2 >= this.f7689e.size()) {
            this.f7689e.add(c2332g);
        } else {
            this.f7689e.add(i2, c2332g);
        }
        return c2332g;
    }

    C2332g m10478a(View view) {
        for (int i = 0; i < this.f7689e.size(); i++) {
            C2332g c2332g = (C2332g) this.f7689e.get(i);
            if (this.f7692h.m870a(view, c2332g.f7716a)) {
                return c2332g;
            }
        }
        return null;
    }

    void m10479a() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.f7697m = new Scroller(context, f7664d);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f = context.getResources().getDisplayMetrics().density;
        this.f7669E = db.m2730a(viewConfiguration);
        this.f7676L = (int) (400.0f * f);
        this.f7677M = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f7681Q = new ah(context);
        this.f7682R = new ah(context);
        this.f7678N = (int) (25.0f * f);
        this.f7679O = (int) (2.0f * f);
        this.f7667C = (int) (16.0f * f);
        cb.m2400a((View) this, new C2334i(this));
        if (cb.m2420e(this) == 0) {
            cb.m2414c((View) this, 1);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void m10480a(int r19) {
        /*
        r18 = this;
        r3 = 0;
        r2 = 2;
        r0 = r18;
        r4 = r0.f7693i;
        r0 = r19;
        if (r4 == r0) goto L_0x033f;
    L_0x000a:
        r0 = r18;
        r2 = r0.f7693i;
        r0 = r19;
        if (r2 >= r0) goto L_0x0030;
    L_0x0012:
        r2 = 130; // 0x82 float:1.82E-43 double:6.4E-322;
    L_0x0014:
        r0 = r18;
        r3 = r0.f7693i;
        r0 = r18;
        r3 = r0.m10488b(r3);
        r0 = r19;
        r1 = r18;
        r1.f7693i = r0;
        r4 = r3;
        r3 = r2;
    L_0x0026:
        r0 = r18;
        r2 = r0.f7692h;
        if (r2 != 0) goto L_0x0033;
    L_0x002c:
        r18.m10473h();
    L_0x002f:
        return;
    L_0x0030:
        r2 = 33;
        goto L_0x0014;
    L_0x0033:
        r0 = r18;
        r2 = r0.f7709y;
        if (r2 == 0) goto L_0x003d;
    L_0x0039:
        r18.m10473h();
        goto L_0x002f;
    L_0x003d:
        r2 = r18.getWindowToken();
        if (r2 == 0) goto L_0x002f;
    L_0x0043:
        r0 = r18;
        r2 = r0.f7692h;
        r0 = r18;
        r2.m868a(r0);
        r0 = r18;
        r2 = r0.f7710z;
        r5 = 0;
        r0 = r18;
        r6 = r0.f7693i;
        r6 = r6 - r2;
        r11 = java.lang.Math.max(r5, r6);
        r0 = r18;
        r5 = r0.f7692h;
        r12 = r5.m871b();
        r5 = r12 + -1;
        r0 = r18;
        r6 = r0.f7693i;
        r2 = r2 + r6;
        r13 = java.lang.Math.min(r5, r2);
        r0 = r18;
        r2 = r0.f7688b;
        if (r12 == r2) goto L_0x00da;
    L_0x0073:
        r2 = r18.getResources();	 Catch:{ NotFoundException -> 0x00d0 }
        r3 = r18.getId();	 Catch:{ NotFoundException -> 0x00d0 }
        r2 = r2.getResourceName(r3);	 Catch:{ NotFoundException -> 0x00d0 }
    L_0x007f:
        r3 = new java.lang.IllegalStateException;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: ";
        r4 = r4.append(r5);
        r0 = r18;
        r5 = r0.f7688b;
        r4 = r4.append(r5);
        r5 = ", found: ";
        r4 = r4.append(r5);
        r4 = r4.append(r12);
        r5 = " Pager id: ";
        r4 = r4.append(r5);
        r2 = r4.append(r2);
        r4 = " Pager class: ";
        r2 = r2.append(r4);
        r4 = r18.getClass();
        r2 = r2.append(r4);
        r4 = " Problematic adapter: ";
        r2 = r2.append(r4);
        r0 = r18;
        r4 = r0.f7692h;
        r4 = r4.getClass();
        r2 = r2.append(r4);
        r2 = r2.toString();
        r3.<init>(r2);
        throw r3;
    L_0x00d0:
        r2 = move-exception;
        r2 = r18.getId();
        r2 = java.lang.Integer.toHexString(r2);
        goto L_0x007f;
    L_0x00da:
        r6 = 0;
        r2 = 0;
        r5 = r2;
    L_0x00dd:
        r0 = r18;
        r2 = r0.f7689e;
        r2 = r2.size();
        if (r5 >= r2) goto L_0x033c;
    L_0x00e7:
        r0 = r18;
        r2 = r0.f7689e;
        r2 = r2.get(r5);
        r2 = (mobi.mmdt.ott.view.main.basenavigation.viewpager.C2332g) r2;
        r7 = r2.f7717b;
        r0 = r18;
        r8 = r0.f7693i;
        if (r7 < r8) goto L_0x01cf;
    L_0x00f9:
        r7 = r2.f7717b;
        r0 = r18;
        r8 = r0.f7693i;
        if (r7 != r8) goto L_0x033c;
    L_0x0101:
        if (r2 != 0) goto L_0x0339;
    L_0x0103:
        if (r12 <= 0) goto L_0x0339;
    L_0x0105:
        r0 = r18;
        r2 = r0.f7693i;
        r0 = r18;
        r2 = r0.m10477a(r2, r5);
        r10 = r2;
    L_0x0110:
        if (r10 == 0) goto L_0x0180;
    L_0x0112:
        r9 = 0;
        r8 = r5 + -1;
        if (r8 < 0) goto L_0x01d4;
    L_0x0117:
        r0 = r18;
        r2 = r0.f7689e;
        r2 = r2.get(r8);
        r2 = (mobi.mmdt.ott.view.main.basenavigation.viewpager.C2332g) r2;
    L_0x0121:
        r14 = r18.getClientHeight();
        if (r14 > 0) goto L_0x01d7;
    L_0x0127:
        r6 = 0;
    L_0x0128:
        r0 = r18;
        r7 = r0.f7693i;
        r7 = r7 + -1;
        r16 = r7;
        r7 = r9;
        r9 = r16;
        r17 = r8;
        r8 = r5;
        r5 = r17;
    L_0x0138:
        if (r9 < 0) goto L_0x0142;
    L_0x013a:
        r15 = (r7 > r6 ? 1 : (r7 == r6 ? 0 : -1));
        if (r15 < 0) goto L_0x0216;
    L_0x013e:
        if (r9 >= r11) goto L_0x0216;
    L_0x0140:
        if (r2 != 0) goto L_0x01e6;
    L_0x0142:
        r6 = r10.f7719d;
        r9 = r8 + 1;
        r2 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r2 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1));
        if (r2 >= 0) goto L_0x017b;
    L_0x014c:
        r0 = r18;
        r2 = r0.f7689e;
        r2 = r2.size();
        if (r9 >= r2) goto L_0x024c;
    L_0x0156:
        r0 = r18;
        r2 = r0.f7689e;
        r2 = r2.get(r9);
        r2 = (mobi.mmdt.ott.view.main.basenavigation.viewpager.C2332g) r2;
        r7 = r2;
    L_0x0161:
        if (r14 > 0) goto L_0x024f;
    L_0x0163:
        r2 = 0;
        r5 = r2;
    L_0x0165:
        r0 = r18;
        r2 = r0.f7693i;
        r2 = r2 + 1;
        r16 = r2;
        r2 = r7;
        r7 = r9;
        r9 = r16;
    L_0x0171:
        if (r9 >= r12) goto L_0x017b;
    L_0x0173:
        r11 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1));
        if (r11 < 0) goto L_0x029a;
    L_0x0177:
        if (r9 <= r13) goto L_0x029a;
    L_0x0179:
        if (r2 != 0) goto L_0x025c;
    L_0x017b:
        r0 = r18;
        r0.m10463a(r10, r8, r4);
    L_0x0180:
        r0 = r18;
        r4 = r0.f7692h;
        r0 = r18;
        r5 = r0.f7693i;
        if (r10 == 0) goto L_0x02e8;
    L_0x018a:
        r2 = r10.f7716a;
    L_0x018c:
        r0 = r18;
        r4.m876b(r0, r5, r2);
        r0 = r18;
        r2 = r0.f7692h;
        r0 = r18;
        r2.m875b(r0);
        r5 = r18.getChildCount();
        r2 = 0;
        r4 = r2;
    L_0x01a0:
        if (r4 >= r5) goto L_0x02eb;
    L_0x01a2:
        r0 = r18;
        r6 = r0.getChildAt(r4);
        r2 = r6.getLayoutParams();
        r2 = (mobi.mmdt.ott.view.main.basenavigation.viewpager.C2333h) r2;
        r2.f7726f = r4;
        r7 = r2.f7721a;
        if (r7 != 0) goto L_0x01cb;
    L_0x01b4:
        r7 = r2.f7723c;
        r8 = 0;
        r7 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1));
        if (r7 != 0) goto L_0x01cb;
    L_0x01bb:
        r0 = r18;
        r6 = r0.m10478a(r6);
        if (r6 == 0) goto L_0x01cb;
    L_0x01c3:
        r7 = r6.f7719d;
        r2.f7723c = r7;
        r6 = r6.f7717b;
        r2.f7725e = r6;
    L_0x01cb:
        r2 = r4 + 1;
        r4 = r2;
        goto L_0x01a0;
    L_0x01cf:
        r2 = r5 + 1;
        r5 = r2;
        goto L_0x00dd;
    L_0x01d4:
        r2 = 0;
        goto L_0x0121;
    L_0x01d7:
        r6 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r7 = r10.f7719d;
        r6 = r6 - r7;
        r7 = r18.getPaddingLeft();
        r7 = (float) r7;
        r15 = (float) r14;
        r7 = r7 / r15;
        r6 = r6 + r7;
        goto L_0x0128;
    L_0x01e6:
        r15 = r2.f7717b;
        if (r9 != r15) goto L_0x0210;
    L_0x01ea:
        r15 = r2.f7718c;
        if (r15 != 0) goto L_0x0210;
    L_0x01ee:
        r0 = r18;
        r15 = r0.f7689e;
        r15.remove(r5);
        r0 = r18;
        r15 = r0.f7692h;
        r2 = r2.f7716a;
        r0 = r18;
        r15.m869a(r0, r9, r2);
        r5 = r5 + -1;
        r8 = r8 + -1;
        if (r5 < 0) goto L_0x0214;
    L_0x0206:
        r0 = r18;
        r2 = r0.f7689e;
        r2 = r2.get(r5);
        r2 = (mobi.mmdt.ott.view.main.basenavigation.viewpager.C2332g) r2;
    L_0x0210:
        r9 = r9 + -1;
        goto L_0x0138;
    L_0x0214:
        r2 = 0;
        goto L_0x0210;
    L_0x0216:
        if (r2 == 0) goto L_0x0230;
    L_0x0218:
        r15 = r2.f7717b;
        if (r9 != r15) goto L_0x0230;
    L_0x021c:
        r2 = r2.f7719d;
        r7 = r7 + r2;
        r5 = r5 + -1;
        if (r5 < 0) goto L_0x022e;
    L_0x0223:
        r0 = r18;
        r2 = r0.f7689e;
        r2 = r2.get(r5);
        r2 = (mobi.mmdt.ott.view.main.basenavigation.viewpager.C2332g) r2;
        goto L_0x0210;
    L_0x022e:
        r2 = 0;
        goto L_0x0210;
    L_0x0230:
        r2 = r5 + 1;
        r0 = r18;
        r2 = r0.m10477a(r9, r2);
        r2 = r2.f7719d;
        r7 = r7 + r2;
        r8 = r8 + 1;
        if (r5 < 0) goto L_0x024a;
    L_0x023f:
        r0 = r18;
        r2 = r0.f7689e;
        r2 = r2.get(r5);
        r2 = (mobi.mmdt.ott.view.main.basenavigation.viewpager.C2332g) r2;
        goto L_0x0210;
    L_0x024a:
        r2 = 0;
        goto L_0x0210;
    L_0x024c:
        r7 = 0;
        goto L_0x0161;
    L_0x024f:
        r2 = r18.getPaddingRight();
        r2 = (float) r2;
        r5 = (float) r14;
        r2 = r2 / r5;
        r5 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r2 = r2 + r5;
        r5 = r2;
        goto L_0x0165;
    L_0x025c:
        r11 = r2.f7717b;
        if (r9 != r11) goto L_0x0332;
    L_0x0260:
        r11 = r2.f7718c;
        if (r11 != 0) goto L_0x0332;
    L_0x0264:
        r0 = r18;
        r11 = r0.f7689e;
        r11.remove(r7);
        r0 = r18;
        r11 = r0.f7692h;
        r2 = r2.f7716a;
        r0 = r18;
        r11.m869a(r0, r9, r2);
        r0 = r18;
        r2 = r0.f7689e;
        r2 = r2.size();
        if (r7 >= r2) goto L_0x0298;
    L_0x0280:
        r0 = r18;
        r2 = r0.f7689e;
        r2 = r2.get(r7);
        r2 = (mobi.mmdt.ott.view.main.basenavigation.viewpager.C2332g) r2;
    L_0x028a:
        r16 = r6;
        r6 = r2;
        r2 = r16;
    L_0x028f:
        r9 = r9 + 1;
        r16 = r2;
        r2 = r6;
        r6 = r16;
        goto L_0x0171;
    L_0x0298:
        r2 = 0;
        goto L_0x028a;
    L_0x029a:
        if (r2 == 0) goto L_0x02c1;
    L_0x029c:
        r11 = r2.f7717b;
        if (r9 != r11) goto L_0x02c1;
    L_0x02a0:
        r2 = r2.f7719d;
        r6 = r6 + r2;
        r7 = r7 + 1;
        r0 = r18;
        r2 = r0.f7689e;
        r2 = r2.size();
        if (r7 >= r2) goto L_0x02bf;
    L_0x02af:
        r0 = r18;
        r2 = r0.f7689e;
        r2 = r2.get(r7);
        r2 = (mobi.mmdt.ott.view.main.basenavigation.viewpager.C2332g) r2;
    L_0x02b9:
        r16 = r6;
        r6 = r2;
        r2 = r16;
        goto L_0x028f;
    L_0x02bf:
        r2 = 0;
        goto L_0x02b9;
    L_0x02c1:
        r0 = r18;
        r2 = r0.m10477a(r9, r7);
        r7 = r7 + 1;
        r2 = r2.f7719d;
        r6 = r6 + r2;
        r0 = r18;
        r2 = r0.f7689e;
        r2 = r2.size();
        if (r7 >= r2) goto L_0x02e6;
    L_0x02d6:
        r0 = r18;
        r2 = r0.f7689e;
        r2 = r2.get(r7);
        r2 = (mobi.mmdt.ott.view.main.basenavigation.viewpager.C2332g) r2;
    L_0x02e0:
        r16 = r6;
        r6 = r2;
        r2 = r16;
        goto L_0x028f;
    L_0x02e6:
        r2 = 0;
        goto L_0x02e0;
    L_0x02e8:
        r2 = 0;
        goto L_0x018c;
    L_0x02eb:
        r18.m10473h();
        r2 = r18.hasFocus();
        if (r2 == 0) goto L_0x002f;
    L_0x02f4:
        r2 = r18.findFocus();
        if (r2 == 0) goto L_0x0330;
    L_0x02fa:
        r0 = r18;
        r2 = r0.m10489b(r2);
    L_0x0300:
        if (r2 == 0) goto L_0x030a;
    L_0x0302:
        r2 = r2.f7717b;
        r0 = r18;
        r4 = r0.f7693i;
        if (r2 == r4) goto L_0x002f;
    L_0x030a:
        r2 = 0;
    L_0x030b:
        r4 = r18.getChildCount();
        if (r2 >= r4) goto L_0x002f;
    L_0x0311:
        r0 = r18;
        r4 = r0.getChildAt(r2);
        r0 = r18;
        r5 = r0.m10478a(r4);
        if (r5 == 0) goto L_0x032d;
    L_0x031f:
        r5 = r5.f7717b;
        r0 = r18;
        r6 = r0.f7693i;
        if (r5 != r6) goto L_0x032d;
    L_0x0327:
        r4 = r4.requestFocus(r3);
        if (r4 != 0) goto L_0x002f;
    L_0x032d:
        r2 = r2 + 1;
        goto L_0x030b;
    L_0x0330:
        r2 = 0;
        goto L_0x0300;
    L_0x0332:
        r16 = r6;
        r6 = r2;
        r2 = r16;
        goto L_0x028f;
    L_0x0339:
        r10 = r2;
        goto L_0x0110;
    L_0x033c:
        r2 = r6;
        goto L_0x0101;
    L_0x033f:
        r4 = r3;
        r3 = r2;
        goto L_0x0026;
        */
        throw new UnsupportedOperationException("Method not decompiled: mobi.mmdt.ott.view.main.basenavigation.viewpager.VerticalViewPager.a(int):void");
    }

    protected void m10481a(int i, float f, int i2) {
        int paddingTop;
        int paddingBottom;
        int i3;
        if (this.f7686V > 0) {
            int scrollY = getScrollY();
            paddingTop = getPaddingTop();
            paddingBottom = getPaddingBottom();
            int height = getHeight();
            int childCount = getChildCount();
            i3 = 0;
            while (i3 < childCount) {
                int i4;
                View childAt = getChildAt(i3);
                C2333h c2333h = (C2333h) childAt.getLayoutParams();
                if (c2333h.f7721a) {
                    int max;
                    switch (c2333h.f7722b & 112) {
                        case Version.API16_JELLY_BEAN_41 /*16*/:
                            max = Math.max((height - childAt.getMeasuredHeight()) / 2, paddingTop);
                            i4 = paddingBottom;
                            paddingBottom = paddingTop;
                            paddingTop = i4;
                            break;
                        case C1317h.Theme_homeAsUpIndicator /*48*/:
                            max = childAt.getHeight() + paddingTop;
                            i4 = paddingTop;
                            paddingTop = paddingBottom;
                            paddingBottom = max;
                            max = i4;
                            break;
                        case C1317h.Theme_panelMenuListTheme /*80*/:
                            max = (height - paddingBottom) - childAt.getMeasuredHeight();
                            i4 = paddingBottom + childAt.getMeasuredHeight();
                            paddingBottom = paddingTop;
                            paddingTop = i4;
                            break;
                        default:
                            max = paddingTop;
                            i4 = paddingBottom;
                            paddingBottom = paddingTop;
                            paddingTop = i4;
                            break;
                    }
                    max = (max + scrollY) - childAt.getTop();
                    if (max != 0) {
                        childAt.offsetTopAndBottom(max);
                    }
                } else {
                    i4 = paddingBottom;
                    paddingBottom = paddingTop;
                    paddingTop = i4;
                }
                i3++;
                i4 = paddingTop;
                paddingTop = paddingBottom;
                paddingBottom = i4;
            }
        }
        if (this.f7687W != null) {
            this.f7687W.m664a(i, f, i2);
        }
        if (this.aa != null) {
            this.aa.m664a(i, f, i2);
        }
        if (this.ac != null) {
            paddingBottom = getScrollY();
            i3 = getChildCount();
            for (paddingTop = 0; paddingTop < i3; paddingTop++) {
                View childAt2 = getChildAt(paddingTop);
                if (!((C2333h) childAt2.getLayoutParams()).f7721a) {
                    this.ac.m2752a(childAt2, ((float) (childAt2.getTop() - paddingBottom)) / ((float) getClientHeight()));
                }
            }
        }
        this.f7685U = true;
    }

    void m10482a(int i, int i2, int i3) {
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int i4 = i - scrollX;
        int i5 = i2 - scrollY;
        if (i4 == 0 && i5 == 0) {
            m10464a(false);
            m10491c();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientHeight = getClientHeight();
        int i6 = clientHeight / 2;
        float a = (((float) i6) * m10476a(Math.min(1.0f, (((float) Math.abs(i4)) * 1.0f) / ((float) clientHeight)))) + ((float) i6);
        int abs = Math.abs(i3);
        if (abs > 0) {
            clientHeight = Math.round(1000.0f * Math.abs(a / ((float) abs))) * 4;
        } else {
            clientHeight = (int) (((((float) Math.abs(i4)) / ((((float) clientHeight) * this.f7692h.m879d(this.f7693i)) + ((float) this.f7699o))) + 1.0f) * 100.0f);
        }
        this.f7697m.startScroll(scrollX, scrollY, i4, i5, Math.min(clientHeight, 600));
        cb.m2417d(this);
    }

    public void m10483a(int i, boolean z) {
        this.f7709y = false;
        m10484a(i, z, false);
    }

    void m10484a(int i, boolean z, boolean z2) {
        m10485a(i, z, z2, 0);
    }

    void m10485a(int i, boolean z, boolean z2, int i2) {
        boolean z3 = false;
        if (this.f7692h == null || this.f7692h.m871b() <= 0) {
            setScrollingCacheEnabled(false);
        } else if (z2 || this.f7693i != i || this.f7689e.size() == 0) {
            if (i < 0) {
                i = 0;
            } else if (i >= this.f7692h.m871b()) {
                i = this.f7692h.m871b() - 1;
            }
            int i3 = this.f7710z;
            if (i > this.f7693i + i3 || i < this.f7693i - i3) {
                for (int i4 = 0; i4 < this.f7689e.size(); i4++) {
                    ((C2332g) this.f7689e.get(i4)).f7718c = true;
                }
            }
            if (this.f7693i != i) {
                z3 = true;
            }
            if (this.f7683S) {
                this.f7693i = i;
                if (z3 && this.f7687W != null) {
                    this.f7687W.m665b(i);
                }
                if (z3 && this.aa != null) {
                    this.aa.m665b(i);
                }
                requestLayout();
                return;
            }
            m10480a(i);
            m10460a(i, z, i2, z3);
        } else {
            setScrollingCacheEnabled(false);
        }
    }

    public boolean m10486a(KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0) {
            return false;
        }
        switch (keyEvent.getKeyCode()) {
            case C1317h.Toolbar_navigationContentDescription /*21*/:
                return m10494d(17);
            case C1317h.Toolbar_logoDescription /*22*/:
                return m10494d(66);
            case C1317h.Theme_popupWindowStyle /*61*/:
                return VERSION.SDK_INT >= 11 ? aa.m2205a(keyEvent) ? m10494d(2) : aa.m2206a(keyEvent, 1) ? m10494d(1) : false : false;
            default:
                return false;
        }
    }

    protected boolean m10487a(View view, boolean z, int i, int i2, int i3) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (i3 + scrollY >= childAt.getTop() && i3 + scrollY < childAt.getBottom() && i2 + scrollX >= childAt.getLeft() && i2 + scrollX < childAt.getRight()) {
                    if (m10487a(childAt, true, i, (i2 + scrollX) - childAt.getLeft(), (i3 + scrollY) - childAt.getTop())) {
                        return true;
                    }
                }
            }
        }
        return z && cb.m2412b(view, -i);
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0) {
                    C2332g a = m10478a(childAt);
                    if (a != null && a.f7717b == this.f7693i) {
                        childAt.addFocusables(arrayList, i, i2);
                    }
                }
            }
        }
        if ((descendantFocusability == 262144 && size != arrayList.size()) || !isFocusable()) {
            return;
        }
        if (((i2 & 1) != 1 || !isInTouchMode() || isFocusableInTouchMode()) && arrayList != null) {
            arrayList.add(this);
        }
    }

    public void addTouchables(ArrayList<View> arrayList) {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                C2332g a = m10478a(childAt);
                if (a != null && a.f7717b == this.f7693i) {
                    childAt.addTouchables(arrayList);
                }
            }
        }
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        LayoutParams generateLayoutParams = !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : layoutParams;
        C2333h c2333h = (C2333h) generateLayoutParams;
        c2333h.f7721a |= view instanceof C2331f;
        if (!this.f7707w) {
            super.addView(view, i, generateLayoutParams);
        } else if (c2333h == null || !c2333h.f7721a) {
            c2333h.f7724d = true;
            addViewInLayout(view, i, generateLayoutParams);
        } else {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
    }

    C2332g m10488b(int i) {
        for (int i2 = 0; i2 < this.f7689e.size(); i2++) {
            C2332g c2332g = (C2332g) this.f7689e.get(i2);
            if (c2332g.f7717b == i) {
                return c2332g;
            }
        }
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    mobi.mmdt.ott.view.main.basenavigation.viewpager.C2332g m10489b(android.view.View r3) {
        /*
        r2 = this;
    L_0x0000:
        r0 = r3.getParent();
        if (r0 == r2) goto L_0x0012;
    L_0x0006:
        if (r0 == 0) goto L_0x000c;
    L_0x0008:
        r1 = r0 instanceof android.view.View;
        if (r1 != 0) goto L_0x000e;
    L_0x000c:
        r0 = 0;
    L_0x000d:
        return r0;
    L_0x000e:
        r0 = (android.view.View) r0;
        r3 = r0;
        goto L_0x0000;
    L_0x0012:
        r0 = r2.m10478a(r3);
        goto L_0x000d;
        */
        throw new UnsupportedOperationException("Method not decompiled: mobi.mmdt.ott.view.main.basenavigation.viewpager.VerticalViewPager.b(android.view.View):mobi.mmdt.ott.view.main.basenavigation.viewpager.g");
    }

    void m10490b() {
        int b = this.f7692h.m871b();
        this.f7688b = b;
        boolean z = this.f7689e.size() < (this.f7710z * 2) + 1 && this.f7689e.size() < b;
        boolean z2 = false;
        int i = this.f7693i;
        boolean z3 = z;
        int i2 = 0;
        while (i2 < this.f7689e.size()) {
            int i3;
            boolean z4;
            int i4;
            boolean z5;
            C2332g c2332g = (C2332g) this.f7689e.get(i2);
            int a = this.f7692h.m860a(c2332g.f7716a);
            if (a == -1) {
                i3 = i2;
                z4 = z2;
                i4 = i;
                z5 = z3;
            } else if (a == -2) {
                this.f7689e.remove(i2);
                i2--;
                if (!z2) {
                    this.f7692h.m868a((ViewGroup) this);
                    z2 = true;
                }
                this.f7692h.m869a((ViewGroup) this, c2332g.f7717b, c2332g.f7716a);
                if (this.f7693i == c2332g.f7717b) {
                    i3 = i2;
                    z4 = z2;
                    i4 = Math.max(0, Math.min(this.f7693i, b - 1));
                    z5 = true;
                } else {
                    i3 = i2;
                    z4 = z2;
                    i4 = i;
                    z5 = true;
                }
            } else if (c2332g.f7717b != a) {
                if (c2332g.f7717b == this.f7693i) {
                    i = a;
                }
                c2332g.f7717b = a;
                i3 = i2;
                z4 = z2;
                i4 = i;
                z5 = true;
            } else {
                i3 = i2;
                z4 = z2;
                i4 = i;
                z5 = z3;
            }
            z3 = z5;
            i = i4;
            z2 = z4;
            i2 = i3 + 1;
        }
        if (z2) {
            this.f7692h.m875b((ViewGroup) this);
        }
        Collections.sort(this.f7689e, f7663c);
        if (z3) {
            i4 = getChildCount();
            for (i2 = 0; i2 < i4; i2++) {
                C2333h c2333h = (C2333h) getChildAt(i2).getLayoutParams();
                if (!c2333h.f7721a) {
                    c2333h.f7723c = 0.0f;
                }
            }
            m10484a(i, false, true);
            requestLayout();
        }
    }

    void m10491c() {
        m10480a(this.f7693i);
    }

    public boolean m10492c(int i) {
        boolean z = true;
        if (this.f7692h == null) {
            return false;
        }
        int clientHeight = getClientHeight();
        int scrollY = getScrollY();
        if (i < 0) {
            if (scrollY <= ((int) (((float) clientHeight) * this.f7703s))) {
                z = false;
            }
            return z;
        } else if (i <= 0) {
            return false;
        } else {
            if (scrollY >= ((int) (((float) clientHeight) * this.f7704t))) {
                z = false;
            }
            return z;
        }
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return (layoutParams instanceof C2333h) && super.checkLayoutParams(layoutParams);
    }

    public void computeScroll() {
        if (this.f7697m.isFinished() || !this.f7697m.computeScrollOffset()) {
            m10464a(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.f7697m.getCurrX();
        int currY = this.f7697m.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
            if (!m10470e(currY)) {
                this.f7697m.abortAnimation();
                scrollTo(currX, 0);
            }
        }
        cb.m2417d(this);
    }

    boolean m10493d() {
        if (this.f7693i <= 0) {
            return false;
        }
        m10483a(this.f7693i - 1, true);
        return true;
    }

    public boolean m10494d(int i) {
        View view;
        boolean d;
        View findFocus = findFocus();
        if (findFocus == this) {
            view = null;
        } else {
            if (findFocus != null) {
                Object obj;
                for (VerticalViewPager parent = findFocus.getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
                    if (parent == this) {
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj == null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(findFocus.getClass().getSimpleName());
                    for (ViewParent parent2 = findFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                        stringBuilder.append(" => ").append(parent2.getClass().getSimpleName());
                    }
                    Log.e("ViewPager", "arrowScroll tried to find focus based on non-child current focused view " + stringBuilder.toString());
                    view = null;
                }
            }
            view = findFocus;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, view, i);
        if (findNextFocus == null || findNextFocus == view) {
            if (i == 33 || i == 1) {
                d = m10493d();
            } else {
                if (i == 130 || i == 2) {
                    d = m10495e();
                }
                d = false;
            }
        } else if (i == 33) {
            d = (view == null || m10457a(this.f7691g, findNextFocus).top < m10457a(this.f7691g, view).top) ? findNextFocus.requestFocus() : m10493d();
        } else {
            if (i == 130) {
                d = (view == null || m10457a(this.f7691g, findNextFocus).bottom > m10457a(this.f7691g, view).bottom) ? findNextFocus.requestFocus() : m10495e();
            }
            d = false;
        }
        if (d) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
        }
        return d;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || m10486a(keyEvent);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == ItemAnimator.FLAG_APPEARED_IN_PRE_LAYOUT) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                C2332g a = m10478a(childAt);
                if (a != null && a.f7717b == this.f7693i && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        int i = 0;
        int a = cb.m2391a(this);
        if (a == 0 || (a == 1 && this.f7692h != null && this.f7692h.m871b() > 1)) {
            int height;
            int width;
            if (!this.f7681Q.m3135a()) {
                a = canvas.save();
                height = getHeight();
                width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                canvas.translate((float) getPaddingLeft(), this.f7703s * ((float) height));
                this.f7681Q.m3134a(width, height);
                i = 0 | this.f7681Q.m3139a(canvas);
                canvas.restoreToCount(a);
            }
            if (!this.f7682R.m3135a()) {
                a = canvas.save();
                height = getHeight();
                width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                canvas.rotate(180.0f);
                canvas.translate((float) ((-width) - getPaddingLeft()), (-(this.f7704t + 1.0f)) * ((float) height));
                this.f7682R.m3134a(width, height);
                i |= this.f7682R.m3139a(canvas);
                canvas.restoreToCount(a);
            }
        } else {
            this.f7681Q.m3140b();
            this.f7682R.m3140b();
        }
        if (i != 0) {
            cb.m2417d(this);
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f7700p;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    boolean m10495e() {
        if (this.f7692h == null || this.f7693i >= this.f7692h.m871b() - 1) {
            return false;
        }
        m10483a(this.f7693i + 1, true);
        return true;
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new C2333h();
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new C2333h(getContext(), attributeSet);
    }

    protected LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public bt getAdapter() {
        return this.f7692h;
    }

    protected int getChildDrawingOrder(int i, int i2) {
        if (this.ae == 2) {
            i2 = (i - 1) - i2;
        }
        return ((C2333h) ((View) this.af.get(i2)).getLayoutParams()).f7726f;
    }

    public int getCurrentItem() {
        return this.f7693i;
    }

    public int getOffscreenPageLimit() {
        return this.f7710z;
    }

    public int getPageMargin() {
        return this.f7699o;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f7683S = true;
    }

    protected void onDetachedFromWindow() {
        removeCallbacks(this.ah);
        super.onDetachedFromWindow();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f7699o > 0 && this.f7700p != null && this.f7689e.size() > 0 && this.f7692h != null) {
            int scrollY = getScrollY();
            int height = getHeight();
            float f = ((float) this.f7699o) / ((float) height);
            C2332g c2332g = (C2332g) this.f7689e.get(0);
            float f2 = c2332g.f7720e;
            int size = this.f7689e.size();
            int i = c2332g.f7717b;
            int i2 = ((C2332g) this.f7689e.get(size - 1)).f7717b;
            int i3 = 0;
            int i4 = i;
            while (i4 < i2) {
                float f3;
                while (i4 > c2332g.f7717b && i3 < size) {
                    i3++;
                    c2332g = (C2332g) this.f7689e.get(i3);
                }
                if (i4 == c2332g.f7717b) {
                    f3 = (c2332g.f7720e + c2332g.f7719d) * ((float) height);
                    f2 = (c2332g.f7720e + c2332g.f7719d) + f;
                } else {
                    float d = this.f7692h.m879d(i4);
                    f3 = (f2 + d) * ((float) height);
                    f2 += d + f;
                }
                if (((float) this.f7699o) + f3 > ((float) scrollY)) {
                    this.f7700p.setBounds(this.f7701q, (int) f3, this.f7702r, (int) ((((float) this.f7699o) + f3) + 0.5f));
                    this.f7700p.draw(canvas);
                }
                if (f3 <= ((float) (scrollY + height))) {
                    i4++;
                } else {
                    return;
                }
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            this.f7665A = false;
            this.f7666B = false;
            this.f7674J = -1;
            if (this.f7675K == null) {
                return false;
            }
            this.f7675K.recycle();
            this.f7675K = null;
            return false;
        }
        if (action != 0) {
            if (this.f7665A) {
                return true;
            }
            if (this.f7666B) {
                return false;
            }
        }
        switch (action) {
            case VideoSize.QCIF /*0*/:
                float x = motionEvent.getX();
                this.f7672H = x;
                this.f7670F = x;
                x = motionEvent.getY();
                this.f7673I = x;
                this.f7671G = x;
                this.f7674J = bf.m2312b(motionEvent, 0);
                this.f7666B = false;
                this.f7697m.computeScrollOffset();
                if (this.ai == 2 && Math.abs(this.f7697m.getFinalY() - this.f7697m.getCurrY()) > this.f7679O) {
                    this.f7697m.abortAnimation();
                    this.f7709y = false;
                    m10491c();
                    this.f7665A = true;
                    m10469c(true);
                    setScrollState(1);
                    break;
                }
                m10464a(false);
                this.f7665A = false;
                break;
                break;
            case VideoSize.HVGA /*2*/:
                action = this.f7674J;
                if (action != -1) {
                    action = bf.m2310a(motionEvent, action);
                    float d = bf.m2315d(motionEvent, action);
                    float f = d - this.f7671G;
                    float abs = Math.abs(f);
                    float c = bf.m2313c(motionEvent, action);
                    float abs2 = Math.abs(c - this.f7672H);
                    if (f == 0.0f || m10465a(this.f7671G, f) || !m10487a(this, false, (int) f, (int) c, (int) d)) {
                        if (abs > ((float) this.f7669E) && 0.5f * abs > abs2) {
                            this.f7665A = true;
                            m10469c(true);
                            setScrollState(1);
                            this.f7671G = f > 0.0f ? this.f7673I + ((float) this.f7669E) : this.f7673I - ((float) this.f7669E);
                            this.f7670F = c;
                            setScrollingCacheEnabled(true);
                        } else if (abs2 > ((float) this.f7669E)) {
                            this.f7666B = true;
                        }
                        if (this.f7665A && m10468b(d)) {
                            cb.m2417d(this);
                            break;
                        }
                    }
                    this.f7670F = c;
                    this.f7671G = d;
                    this.f7666B = true;
                    return false;
                }
                break;
            case Version.API06_ECLAIR_201 /*6*/:
                m10461a(motionEvent);
                break;
        }
        if (this.f7675K == null) {
            this.f7675K = VelocityTracker.obtain();
        }
        this.f7675K.addMovement(motionEvent);
        return this.f7665A;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int max;
        int childCount = getChildCount();
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollY = getScrollY();
        int i7 = 0;
        int i8 = 0;
        while (i8 < childCount) {
            C2333h c2333h;
            int measuredWidth;
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                c2333h = (C2333h) childAt.getLayoutParams();
                if (c2333h.f7721a) {
                    int i9 = c2333h.f7722b & 112;
                    switch (c2333h.f7722b & 7) {
                        case VideoSize.CIF /*1*/:
                            max = Math.max((i5 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            break;
                        case Version.API03_CUPCAKE_15 /*3*/:
                            max = paddingLeft;
                            paddingLeft = childAt.getMeasuredWidth() + paddingLeft;
                            break;
                        case Version.API05_ECLAIR_20 /*5*/:
                            measuredWidth = (i5 - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                            max = measuredWidth;
                            break;
                        default:
                            max = paddingLeft;
                            break;
                    }
                    int i10;
                    switch (i9) {
                        case Version.API16_JELLY_BEAN_41 /*16*/:
                            measuredWidth = Math.max((i6 - childAt.getMeasuredHeight()) / 2, paddingTop);
                            i10 = paddingBottom;
                            paddingBottom = paddingTop;
                            paddingTop = i10;
                            break;
                        case C1317h.Theme_homeAsUpIndicator /*48*/:
                            measuredWidth = childAt.getMeasuredHeight() + paddingTop;
                            i10 = paddingTop;
                            paddingTop = paddingBottom;
                            paddingBottom = measuredWidth;
                            measuredWidth = i10;
                            break;
                        case C1317h.Theme_panelMenuListTheme /*80*/:
                            measuredWidth = (i6 - paddingBottom) - childAt.getMeasuredHeight();
                            i10 = paddingBottom + childAt.getMeasuredHeight();
                            paddingBottom = paddingTop;
                            paddingTop = i10;
                            break;
                        default:
                            measuredWidth = paddingTop;
                            i10 = paddingBottom;
                            paddingBottom = paddingTop;
                            paddingTop = i10;
                            break;
                    }
                    measuredWidth += scrollY;
                    childAt.layout(max, measuredWidth, childAt.getMeasuredWidth() + max, childAt.getMeasuredHeight() + measuredWidth);
                    measuredWidth = i7 + 1;
                    i7 = paddingBottom;
                    paddingBottom = paddingTop;
                    paddingTop = paddingRight;
                    paddingRight = paddingLeft;
                    i8++;
                    paddingLeft = paddingRight;
                    paddingRight = paddingTop;
                    paddingTop = i7;
                    i7 = measuredWidth;
                }
            }
            measuredWidth = i7;
            i7 = paddingTop;
            paddingTop = paddingRight;
            paddingRight = paddingLeft;
            i8++;
            paddingLeft = paddingRight;
            paddingRight = paddingTop;
            paddingTop = i7;
            i7 = measuredWidth;
        }
        max = (i6 - paddingTop) - paddingBottom;
        for (paddingBottom = 0; paddingBottom < childCount; paddingBottom++) {
            View childAt2 = getChildAt(paddingBottom);
            if (childAt2.getVisibility() != 8) {
                c2333h = (C2333h) childAt2.getLayoutParams();
                if (!c2333h.f7721a) {
                    C2332g a = m10478a(childAt2);
                    if (a != null) {
                        i6 = ((int) (a.f7720e * ((float) max))) + paddingTop;
                        if (c2333h.f7724d) {
                            c2333h.f7724d = false;
                            childAt2.measure(MeasureSpec.makeMeasureSpec((i5 - paddingLeft) - paddingRight, 1073741824), MeasureSpec.makeMeasureSpec((int) (c2333h.f7723c * ((float) max)), 1073741824));
                        }
                        childAt2.layout(paddingLeft, i6, childAt2.getMeasuredWidth() + paddingLeft, childAt2.getMeasuredHeight() + i6);
                    }
                }
            }
        }
        this.f7701q = paddingLeft;
        this.f7702r = i5 - paddingRight;
        this.f7686V = i7;
        if (this.f7683S) {
            m10460a(this.f7693i, false, 0, false);
        }
        this.f7683S = false;
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        setMeasuredDimension(getDefaultSize(0, i), getDefaultSize(0, i2));
        int measuredHeight = getMeasuredHeight();
        this.f7668D = Math.min(measuredHeight / 10, this.f7667C);
        int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        int paddingTop = (measuredHeight - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            C2333h c2333h;
            int i5;
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                c2333h = (C2333h) childAt.getLayoutParams();
                if (c2333h != null && c2333h.f7721a) {
                    int i6 = c2333h.f7722b & 7;
                    int i7 = c2333h.f7722b & 112;
                    i3 = RtlSpacingHelper.UNDEFINED;
                    i5 = RtlSpacingHelper.UNDEFINED;
                    Object obj = (i7 == 48 || i7 == 80) ? 1 : null;
                    Object obj2 = (i6 == 3 || i6 == 5) ? 1 : null;
                    if (obj != null) {
                        i3 = 1073741824;
                    } else if (obj2 != null) {
                        i5 = 1073741824;
                    }
                    if (c2333h.width != -2) {
                        i7 = 1073741824;
                        i3 = c2333h.width != -1 ? c2333h.width : measuredWidth;
                    } else {
                        i7 = i3;
                        i3 = measuredWidth;
                    }
                    if (c2333h.height != -2) {
                        i5 = 1073741824;
                        if (c2333h.height != -1) {
                            measuredHeight = c2333h.height;
                            childAt.measure(MeasureSpec.makeMeasureSpec(i3, i7), MeasureSpec.makeMeasureSpec(measuredHeight, i5));
                            if (obj != null) {
                                paddingTop -= childAt.getMeasuredHeight();
                            } else if (obj2 != null) {
                                measuredWidth -= childAt.getMeasuredWidth();
                            }
                        }
                    }
                    measuredHeight = paddingTop;
                    childAt.measure(MeasureSpec.makeMeasureSpec(i3, i7), MeasureSpec.makeMeasureSpec(measuredHeight, i5));
                    if (obj != null) {
                        paddingTop -= childAt.getMeasuredHeight();
                    } else if (obj2 != null) {
                        measuredWidth -= childAt.getMeasuredWidth();
                    }
                }
            }
        }
        this.f7705u = MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        this.f7706v = MeasureSpec.makeMeasureSpec(paddingTop, 1073741824);
        this.f7707w = true;
        m10491c();
        this.f7707w = false;
        i3 = getChildCount();
        for (i5 = 0; i5 < i3; i5++) {
            View childAt2 = getChildAt(i5);
            if (childAt2.getVisibility() != 8) {
                c2333h = (C2333h) childAt2.getLayoutParams();
                if (c2333h == null || !c2333h.f7721a) {
                    childAt2.measure(this.f7705u, MeasureSpec.makeMeasureSpec((int) (c2333h.f7723c * ((float) paddingTop)), 1073741824));
                }
            }
        }
    }

    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        int i3 = -1;
        int childCount = getChildCount();
        if ((i & 2) != 0) {
            i3 = 1;
            i2 = 0;
        } else {
            i2 = childCount - 1;
            childCount = -1;
        }
        while (i2 != childCount) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0) {
                C2332g a = m10478a(childAt);
                if (a != null && a.f7717b == this.f7693i && childAt.requestFocus(i, rect)) {
                    return true;
                }
            }
            i2 += i3;
        }
        return false;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            if (this.f7692h != null) {
                this.f7692h.m865a(savedState.f7713b, savedState.f7714c);
                m10484a(savedState.f7712a, false, true);
                return;
            }
            this.f7694j = savedState.f7712a;
            this.f7695k = savedState.f7713b;
            this.f7696l = savedState.f7714c;
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f7712a = this.f7693i;
        if (this.f7692h != null) {
            savedState.f7713b = this.f7692h.m861a();
        }
        return savedState;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i2 != i4) {
            m10459a(i2, i4, this.f7699o, this.f7699o);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.f7680P) {
            return true;
        }
        if (motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) {
            return false;
        }
        if (this.f7692h == null || this.f7692h.m871b() == 0) {
            return false;
        }
        if (this.f7675K == null) {
            this.f7675K = VelocityTracker.obtain();
        }
        this.f7675K.addMovement(motionEvent);
        float x;
        int b;
        switch (motionEvent.getAction() & 255) {
            case VideoSize.QCIF /*0*/:
                this.f7697m.abortAnimation();
                this.f7709y = false;
                m10491c();
                x = motionEvent.getX();
                this.f7672H = x;
                this.f7670F = x;
                x = motionEvent.getY();
                this.f7673I = x;
                this.f7671G = x;
                this.f7674J = bf.m2312b(motionEvent, 0);
                break;
            case VideoSize.CIF /*1*/:
                if (this.f7665A) {
                    VelocityTracker velocityTracker = this.f7675K;
                    velocityTracker.computeCurrentVelocity(1000, (float) this.f7677M);
                    b = (int) bw.m2359b(velocityTracker, this.f7674J);
                    this.f7709y = true;
                    int clientHeight = getClientHeight();
                    int scrollY = getScrollY();
                    C2332g i = m10474i();
                    m10485a(m10456a(i.f7717b, ((((float) scrollY) / ((float) clientHeight)) - i.f7720e) / i.f7719d, b, (int) (bf.m2315d(motionEvent, bf.m2310a(motionEvent, this.f7674J)) - this.f7673I)), true, true, b);
                    this.f7674J = -1;
                    m10475j();
                    z = this.f7682R.m3141c() | this.f7681Q.m3141c();
                    break;
                }
                break;
            case VideoSize.HVGA /*2*/:
                if (!this.f7665A) {
                    b = bf.m2310a(motionEvent, this.f7674J);
                    float d = bf.m2315d(motionEvent, b);
                    float abs = Math.abs(d - this.f7671G);
                    float c = bf.m2313c(motionEvent, b);
                    x = Math.abs(c - this.f7670F);
                    if (abs > ((float) this.f7669E) && abs > x) {
                        this.f7665A = true;
                        m10469c(true);
                        this.f7671G = d - this.f7673I > 0.0f ? this.f7673I + ((float) this.f7669E) : this.f7673I - ((float) this.f7669E);
                        this.f7670F = c;
                        setScrollState(1);
                        setScrollingCacheEnabled(true);
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                }
                if (this.f7665A) {
                    z = false | m10468b(bf.m2315d(motionEvent, bf.m2310a(motionEvent, this.f7674J)));
                    break;
                }
                break;
            case Version.API03_CUPCAKE_15 /*3*/:
                if (this.f7665A) {
                    m10460a(this.f7693i, true, 0, false);
                    this.f7674J = -1;
                    m10475j();
                    z = this.f7682R.m3141c() | this.f7681Q.m3141c();
                    break;
                }
                break;
            case Version.API05_ECLAIR_20 /*5*/:
                b = bf.m2311b(motionEvent);
                this.f7671G = bf.m2315d(motionEvent, b);
                this.f7674J = bf.m2312b(motionEvent, b);
                break;
            case Version.API06_ECLAIR_201 /*6*/:
                m10461a(motionEvent);
                this.f7671G = bf.m2315d(motionEvent, bf.m2310a(motionEvent, this.f7674J));
                break;
        }
        if (z) {
            cb.m2417d(this);
        }
        return true;
    }

    public void removeView(View view) {
        if (this.f7707w) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public void setAdapter(bt btVar) {
        if (this.f7692h != null) {
            this.f7692h.m872b(this.f7698n);
            this.f7692h.m868a((ViewGroup) this);
            for (int i = 0; i < this.f7689e.size(); i++) {
                C2332g c2332g = (C2332g) this.f7689e.get(i);
                this.f7692h.m869a((ViewGroup) this, c2332g.f7717b, c2332g.f7716a);
            }
            this.f7692h.m875b((ViewGroup) this);
            this.f7689e.clear();
            m10472g();
            this.f7693i = 0;
            scrollTo(0, 0);
        }
        bt btVar2 = this.f7692h;
        this.f7692h = btVar;
        this.f7688b = 0;
        if (this.f7692h != null) {
            if (this.f7698n == null) {
                this.f7698n = new C2336k();
            }
            this.f7692h.m864a(this.f7698n);
            this.f7709y = false;
            boolean z = this.f7683S;
            this.f7683S = true;
            this.f7688b = this.f7692h.m871b();
            if (this.f7694j >= 0) {
                this.f7692h.m865a(this.f7695k, this.f7696l);
                m10484a(this.f7694j, false, true);
                this.f7694j = -1;
                this.f7695k = null;
                this.f7696l = null;
            } else if (z) {
                requestLayout();
            } else {
                m10491c();
            }
        }
        if (this.ab != null && btVar2 != btVar) {
            this.ab.m10498a(btVar2, btVar);
        }
    }

    void setChildrenDrawingOrderEnabledCompat(boolean z) {
        if (VERSION.SDK_INT >= 7) {
            if (this.ad == null) {
                try {
                    this.ad = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[]{Boolean.TYPE});
                } catch (Throwable e) {
                    Log.e("ViewPager", "Can't find setChildrenDrawingOrderEnabled", e);
                }
            }
            try {
                this.ad.invoke(this, new Object[]{Boolean.valueOf(z)});
            } catch (Throwable e2) {
                Log.e("ViewPager", "Error changing children drawing order", e2);
            }
        }
    }

    public void setCurrentItem(int i) {
        this.f7709y = false;
        m10484a(i, !this.f7683S, false);
    }

    public void setOffscreenPageLimit(int i) {
        if (i < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + i + " too small; defaulting to " + 1);
            i = 1;
        }
        if (i != this.f7710z) {
            this.f7710z = i;
            m10491c();
        }
    }

    void setOnAdapterChangeListener(C2335j c2335j) {
        this.ab = c2335j;
    }

    public void setOnPageChangeListener(dz dzVar) {
        this.f7687W = dzVar;
    }

    public void setPageMargin(int i) {
        int i2 = this.f7699o;
        this.f7699o = i;
        int height = getHeight();
        m10459a(height, height, i, i2);
        requestLayout();
    }

    public void setPageMarginDrawable(int i) {
        setPageMarginDrawable(getContext().getResources().getDrawable(i));
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.f7700p = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f7700p;
    }
}
