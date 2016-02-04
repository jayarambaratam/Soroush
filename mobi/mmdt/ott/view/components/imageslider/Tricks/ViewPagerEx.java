package mobi.mmdt.ott.view.components.imageslider.Tricks;

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
import java.util.Iterator;
import mobi.mmdt.ott.C1317h;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

public class ViewPagerEx extends ViewGroup {
    private static final int[] f5889a;
    private static final C1836o ad;
    private static final Comparator<C1829g> f5890c;
    private static final Interpolator f5891d;
    private int f5892A;
    private int f5893B;
    private int f5894C;
    private float f5895D;
    private float f5896E;
    private float f5897F;
    private float f5898G;
    private int f5899H;
    private VelocityTracker f5900I;
    private int f5901J;
    private int f5902K;
    private int f5903L;
    private int f5904M;
    private boolean f5905N;
    private ah f5906O;
    private ah f5907P;
    private boolean f5908Q;
    private boolean f5909R;
    private int f5910S;
    private ArrayList<C1818k> f5911T;
    private C1818k f5912U;
    private C1832j f5913V;
    private C1833l f5914W;
    private Method aa;
    private int ab;
    private ArrayList<View> ac;
    private final Runnable ae;
    private int af;
    private int f5915b;
    private final ArrayList<C1829g> f5916e;
    private final C1829g f5917f;
    private final Rect f5918g;
    private bt f5919h;
    private int f5920i;
    private int f5921j;
    private Parcelable f5922k;
    private ClassLoader f5923l;
    private Scroller f5924m;
    private C1834m f5925n;
    private int f5926o;
    private Drawable f5927p;
    private int f5928q;
    private int f5929r;
    private float f5930s;
    private float f5931t;
    private boolean f5932u;
    private boolean f5933v;
    private boolean f5934w;
    private int f5935x;
    private boolean f5936y;
    private boolean f5937z;

    public class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR;
        int f5938a;
        Parcelable f5939b;
        ClassLoader f5940c;

        static {
            CREATOR = C0269j.m1809a(new C1835n());
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            if (classLoader == null) {
                classLoader = getClass().getClassLoader();
            }
            this.f5938a = parcel.readInt();
            this.f5939b = parcel.readParcelable(classLoader);
            this.f5940c = classLoader;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f5938a + "}";
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f5938a);
            parcel.writeParcelable(this.f5939b, i);
        }
    }

    static {
        f5889a = new int[]{16842931};
        f5890c = new C1825c();
        f5891d = new C1826d();
        ad = new C1836o();
    }

    public ViewPagerEx(Context context) {
        super(context);
        this.f5916e = new ArrayList();
        this.f5917f = new C1829g();
        this.f5918g = new Rect();
        this.f5921j = -1;
        this.f5922k = null;
        this.f5923l = null;
        this.f5930s = -3.4028235E38f;
        this.f5931t = Float.MAX_VALUE;
        this.f5935x = 1;
        this.f5899H = -1;
        this.f5908Q = true;
        this.f5911T = new ArrayList();
        this.ae = new C1827e(this);
        this.af = 0;
        m8884a();
    }

    public ViewPagerEx(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5916e = new ArrayList();
        this.f5917f = new C1829g();
        this.f5918g = new Rect();
        this.f5921j = -1;
        this.f5922k = null;
        this.f5923l = null;
        this.f5930s = -3.4028235E38f;
        this.f5931t = Float.MAX_VALUE;
        this.f5935x = 1;
        this.f5899H = -1;
        this.f5908Q = true;
        this.f5911T = new ArrayList();
        this.ae = new C1827e(this);
        this.af = 0;
        m8884a();
    }

    private int m8860a(int i, float f, int i2, int i3) {
        if (Math.abs(i3) <= this.f5903L || Math.abs(i2) <= this.f5901J) {
            i = (int) ((i >= this.f5920i ? 0.4f : 0.6f) + (((float) i) + f));
        } else if (i2 <= 0) {
            i++;
        }
        if (this.f5916e.size() <= 0) {
            return i;
        }
        return Math.max(((C1829g) this.f5916e.get(0)).f5945b, Math.min(i, ((C1829g) this.f5916e.get(this.f5916e.size() - 1)).f5945b));
    }

    private Rect m8861a(Rect rect, View view) {
        Rect rect2 = rect == null ? new Rect() : rect;
        if (view == null) {
            rect2.set(0, 0, 0, 0);
            return rect2;
        }
        rect2.left = view.getLeft();
        rect2.right = view.getRight();
        rect2.top = view.getTop();
        rect2.bottom = view.getBottom();
        ViewPagerEx parent = view.getParent();
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

    private void m8863a(int i, int i2, int i3, int i4) {
        if (i2 <= 0 || this.f5916e.isEmpty()) {
            C1829g b = m8895b(this.f5920i);
            int min = (int) ((b != null ? Math.min(b.f5948e, this.f5931t) : 0.0f) * ((float) ((i - getPaddingLeft()) - getPaddingRight())));
            if (min != getScrollX()) {
                m8868a(false);
                scrollTo(min, getScrollY());
                return;
            }
            return;
        }
        int paddingLeft = (int) (((float) (((i - getPaddingLeft()) - getPaddingRight()) + i3)) * (((float) getScrollX()) / ((float) (((i2 - getPaddingLeft()) - getPaddingRight()) + i4))));
        scrollTo(paddingLeft, getScrollY());
        if (!this.f5924m.isFinished()) {
            this.f5924m.startScroll(paddingLeft, 0, (int) (m8895b(this.f5920i).f5948e * ((float) i)), 0, this.f5924m.getDuration() - this.f5924m.timePassed());
        }
    }

    private void m8864a(int i, boolean z, int i2, boolean z2) {
        int max;
        C1829g b = m8895b(i);
        if (b != null) {
            max = (int) (Math.max(this.f5930s, Math.min(b.f5948e, this.f5931t)) * ((float) getClientWidth()));
        } else {
            max = 0;
        }
        if (z) {
            m8887a(max, 0, i2);
            if (z2) {
                m8874d(i);
                return;
            }
            return;
        }
        if (z2) {
            m8874d(i);
        }
        m8868a(false);
        scrollTo(max, 0);
        m8875e(max);
    }

    private void m8865a(MotionEvent motionEvent) {
        int b = bf.m2311b(motionEvent);
        if (bf.m2312b(motionEvent, b) == this.f5899H) {
            b = b == 0 ? 1 : 0;
            this.f5895D = bf.m2313c(motionEvent, b);
            this.f5899H = bf.m2312b(motionEvent, b);
            if (this.f5900I != null) {
                this.f5900I.clear();
            }
        }
    }

    private void m8867a(C1829g c1829g, int i, C1829g c1829g2) {
        int i2;
        float f;
        C1829g c1829g3;
        int i3;
        int b = this.f5919h.m871b();
        int clientWidth = getClientWidth();
        float f2 = clientWidth > 0 ? ((float) this.f5926o) / ((float) clientWidth) : 0.0f;
        if (c1829g2 != null) {
            clientWidth = c1829g2.f5945b;
            int i4;
            if (clientWidth < c1829g.f5945b) {
                i2 = 0;
                f = (c1829g2.f5948e + c1829g2.f5947d) + f2;
                i4 = clientWidth + 1;
                while (i4 <= c1829g.f5945b && i2 < this.f5916e.size()) {
                    c1829g3 = (C1829g) this.f5916e.get(i2);
                    while (i4 > c1829g3.f5945b && i2 < this.f5916e.size() - 1) {
                        i2++;
                        c1829g3 = (C1829g) this.f5916e.get(i2);
                    }
                    while (i4 < c1829g3.f5945b) {
                        f += this.f5919h.m879d(i4) + f2;
                        i4++;
                    }
                    c1829g3.f5948e = f;
                    f += c1829g3.f5947d + f2;
                    i4++;
                }
            } else if (clientWidth > c1829g.f5945b) {
                i2 = this.f5916e.size() - 1;
                f = c1829g2.f5948e;
                i4 = clientWidth - 1;
                while (i4 >= c1829g.f5945b && i2 >= 0) {
                    c1829g3 = (C1829g) this.f5916e.get(i2);
                    while (i4 < c1829g3.f5945b && i2 > 0) {
                        i2--;
                        c1829g3 = (C1829g) this.f5916e.get(i2);
                    }
                    while (i4 > c1829g3.f5945b) {
                        f -= this.f5919h.m879d(i4) + f2;
                        i4--;
                    }
                    f -= c1829g3.f5947d + f2;
                    c1829g3.f5948e = f;
                    i4--;
                }
            }
        }
        int size = this.f5916e.size();
        float f3 = c1829g.f5948e;
        i2 = c1829g.f5945b - 1;
        this.f5930s = c1829g.f5945b == 0 ? c1829g.f5948e : -3.4028235E38f;
        this.f5931t = c1829g.f5945b == b + -1 ? (c1829g.f5948e + c1829g.f5947d) - 1.0f : Float.MAX_VALUE;
        for (i3 = i - 1; i3 >= 0; i3--) {
            c1829g3 = (C1829g) this.f5916e.get(i3);
            f = f3;
            while (i2 > c1829g3.f5945b) {
                f -= this.f5919h.m879d(i2) + f2;
                i2--;
            }
            f3 = f - (c1829g3.f5947d + f2);
            c1829g3.f5948e = f3;
            if (c1829g3.f5945b == 0) {
                this.f5930s = f3;
            }
            i2--;
        }
        f3 = (c1829g.f5948e + c1829g.f5947d) + f2;
        i2 = c1829g.f5945b + 1;
        for (i3 = i + 1; i3 < size; i3++) {
            c1829g3 = (C1829g) this.f5916e.get(i3);
            f = f3;
            while (i2 < c1829g3.f5945b) {
                f = (this.f5919h.m879d(i2) + f2) + f;
                i2++;
            }
            if (c1829g3.f5945b == b - 1) {
                this.f5931t = (c1829g3.f5947d + f) - 1.0f;
            }
            c1829g3.f5948e = f;
            f3 = f + (c1829g3.f5947d + f2);
            i2++;
        }
    }

    private void m8868a(boolean z) {
        int scrollX;
        boolean z2 = this.af == 2;
        if (z2) {
            setScrollingCacheEnabled(false);
            this.f5924m.abortAnimation();
            scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.f5924m.getCurrX();
            int currY = this.f5924m.getCurrY();
            if (!(scrollX == currX && scrollY == currY)) {
                scrollTo(currX, currY);
            }
        }
        this.f5934w = false;
        boolean z3 = z2;
        for (scrollX = 0; scrollX < this.f5916e.size(); scrollX++) {
            C1829g c1829g = (C1829g) this.f5916e.get(scrollX);
            if (c1829g.f5946c) {
                c1829g.f5946c = false;
                z3 = true;
            }
        }
        if (!z3) {
            return;
        }
        if (z) {
            cb.m2402a((View) this, this.ae);
        } else {
            this.ae.run();
        }
    }

    private boolean m8869a(float f, float f2) {
        return (f < ((float) this.f5893B) && f2 > 0.0f) || (f > ((float) (getWidth() - this.f5893B)) && f2 < 0.0f);
    }

    private void m8871b(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            cb.m2396a(getChildAt(i), z ? 2 : 0, null);
        }
    }

    private boolean m8872b(float f) {
        boolean z;
        float f2;
        boolean z2 = true;
        boolean z3 = false;
        float f3 = this.f5895D - f;
        this.f5895D = f;
        float scrollX = ((float) getScrollX()) + f3;
        int clientWidth = getClientWidth();
        float f4 = ((float) clientWidth) * this.f5930s;
        float f5 = ((float) clientWidth) * this.f5931t;
        C1829g c1829g = (C1829g) this.f5916e.get(0);
        C1829g c1829g2 = (C1829g) this.f5916e.get(this.f5916e.size() - 1);
        if (c1829g.f5945b != 0) {
            f4 = c1829g.f5948e * ((float) clientWidth);
            z = false;
        } else {
            z = true;
        }
        if (c1829g2.f5945b != this.f5919h.m871b() - 1) {
            f2 = c1829g2.f5948e * ((float) clientWidth);
            z2 = false;
        } else {
            f2 = f5;
        }
        if (scrollX < f4) {
            if (z) {
                z3 = this.f5906O.m3136a(Math.abs(f4 - scrollX) / ((float) clientWidth));
            }
        } else if (scrollX > f2) {
            if (z2) {
                z3 = this.f5907P.m3136a(Math.abs(scrollX - f2) / ((float) clientWidth));
            }
            f4 = f2;
        } else {
            f4 = scrollX;
        }
        this.f5895D += f4 - ((float) ((int) f4));
        scrollTo((int) f4, getScrollY());
        m8875e((int) f4);
        return z3;
    }

    private void m8873c(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    private void m8874d(int i) {
        Iterator it = this.f5911T.iterator();
        while (it.hasNext()) {
            C1818k c1818k = (C1818k) it.next();
            if (c1818k != null) {
                C1824b c1824b = (C1824b) this.f5919h;
                if (c1824b.m8912e() != 0) {
                    c1818k.m8823a(i % c1824b.m8912e());
                } else {
                    return;
                }
            }
        }
        if (this.f5912U != null) {
            this.f5912U.m8823a(i);
        }
    }

    private boolean m8875e(int i) {
        if (this.f5916e.size() == 0) {
            this.f5909R = false;
            m8886a(0, 0.0f, 0);
            if (this.f5909R) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        C1829g i2 = m8879i();
        int clientWidth = getClientWidth();
        int i3 = this.f5926o + clientWidth;
        float f = ((float) this.f5926o) / ((float) clientWidth);
        int i4 = i2.f5945b;
        float f2 = ((((float) i) / ((float) clientWidth)) - i2.f5948e) / (i2.f5947d + f);
        clientWidth = (int) (((float) i3) * f2);
        this.f5909R = false;
        m8886a(i4, f2, clientWidth);
        if (this.f5909R) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    private void m8877g() {
        int i = 0;
        while (i < getChildCount()) {
            if (!((C1830h) getChildAt(i).getLayoutParams()).f5949a) {
                removeViewAt(i);
                i--;
            }
            i++;
        }
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private void m8878h() {
        if (this.ab != 0) {
            if (this.ac == null) {
                this.ac = new ArrayList();
            } else {
                this.ac.clear();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.ac.add(getChildAt(i));
            }
            Collections.sort(this.ac, ad);
        }
    }

    private C1829g m8879i() {
        int clientWidth = getClientWidth();
        float scrollX = clientWidth > 0 ? ((float) getScrollX()) / ((float) clientWidth) : 0.0f;
        float f = clientWidth > 0 ? ((float) this.f5926o) / ((float) clientWidth) : 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        int i = -1;
        int i2 = 0;
        Object obj = 1;
        C1829g c1829g = null;
        while (i2 < this.f5916e.size()) {
            int i3;
            C1829g c1829g2;
            C1829g c1829g3 = (C1829g) this.f5916e.get(i2);
            C1829g c1829g4;
            if (obj != null || c1829g3.f5945b == i + 1) {
                c1829g4 = c1829g3;
                i3 = i2;
                c1829g2 = c1829g4;
            } else {
                c1829g3 = this.f5917f;
                c1829g3.f5948e = (f2 + f3) + f;
                c1829g3.f5945b = i + 1;
                c1829g3.f5947d = this.f5919h.m879d(c1829g3.f5945b);
                c1829g4 = c1829g3;
                i3 = i2 - 1;
                c1829g2 = c1829g4;
            }
            f2 = c1829g2.f5948e;
            f3 = (c1829g2.f5947d + f2) + f;
            if (obj == null && scrollX < f2) {
                return c1829g;
            }
            if (scrollX < f3 || i3 == this.f5916e.size() - 1) {
                return c1829g2;
            }
            f3 = f2;
            i = c1829g2.f5945b;
            obj = null;
            f2 = c1829g2.f5947d;
            c1829g = c1829g2;
            i2 = i3 + 1;
        }
        return c1829g;
    }

    private void m8880j() {
        this.f5936y = false;
        this.f5937z = false;
        if (this.f5900I != null) {
            this.f5900I.recycle();
            this.f5900I = null;
        }
    }

    private void setScrollState(int i) {
        if (this.af != i) {
            this.af = i;
            if (this.f5914W != null) {
                m8871b(i != 0);
            }
            Iterator it = this.f5911T.iterator();
            while (it.hasNext()) {
                C1818k c1818k = (C1818k) it.next();
                if (c1818k != null) {
                    c1818k.m8825b(i);
                }
            }
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.f5933v != z) {
            this.f5933v = z;
        }
    }

    float m8881a(float f) {
        return (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
    }

    C1829g m8882a(int i, int i2) {
        C1829g c1829g = new C1829g();
        c1829g.f5945b = i;
        c1829g.f5944a = this.f5919h.m863a((ViewGroup) this, i);
        c1829g.f5947d = this.f5919h.m879d(i);
        if (i2 < 0 || i2 >= this.f5916e.size()) {
            this.f5916e.add(c1829g);
        } else {
            this.f5916e.add(i2, c1829g);
        }
        return c1829g;
    }

    C1829g m8883a(View view) {
        for (int i = 0; i < this.f5916e.size(); i++) {
            C1829g c1829g = (C1829g) this.f5916e.get(i);
            if (this.f5919h.m870a(view, c1829g.f5944a)) {
                return c1829g;
            }
        }
        return null;
    }

    void m8884a() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.f5924m = new Scroller(context, f5891d);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f = context.getResources().getDisplayMetrics().density;
        this.f5894C = db.m2730a(viewConfiguration);
        this.f5901J = (int) (400.0f * f);
        this.f5902K = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f5906O = new ah(context);
        this.f5907P = new ah(context);
        this.f5903L = (int) (25.0f * f);
        this.f5904M = (int) (2.0f * f);
        this.f5892A = (int) (16.0f * f);
        cb.m2400a((View) this, new C1831i(this));
        if (cb.m2420e(this) == 0) {
            cb.m2414c((View) this, 1);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void m8885a(int r19) {
        /*
        r18 = this;
        r3 = 0;
        r2 = 2;
        r0 = r18;
        r4 = r0.f5920i;
        r0 = r19;
        if (r4 == r0) goto L_0x033f;
    L_0x000a:
        r0 = r18;
        r2 = r0.f5920i;
        r0 = r19;
        if (r2 >= r0) goto L_0x0030;
    L_0x0012:
        r2 = 66;
    L_0x0014:
        r0 = r18;
        r3 = r0.f5920i;
        r0 = r18;
        r3 = r0.m8895b(r3);
        r0 = r19;
        r1 = r18;
        r1.f5920i = r0;
        r4 = r3;
        r3 = r2;
    L_0x0026:
        r0 = r18;
        r2 = r0.f5919h;
        if (r2 != 0) goto L_0x0033;
    L_0x002c:
        r18.m8878h();
    L_0x002f:
        return;
    L_0x0030:
        r2 = 17;
        goto L_0x0014;
    L_0x0033:
        r0 = r18;
        r2 = r0.f5934w;
        if (r2 == 0) goto L_0x003d;
    L_0x0039:
        r18.m8878h();
        goto L_0x002f;
    L_0x003d:
        r2 = r18.getWindowToken();
        if (r2 == 0) goto L_0x002f;
    L_0x0043:
        r0 = r18;
        r2 = r0.f5919h;
        r0 = r18;
        r2.m868a(r0);
        r0 = r18;
        r2 = r0.f5935x;
        r5 = 0;
        r0 = r18;
        r6 = r0.f5920i;
        r6 = r6 - r2;
        r11 = java.lang.Math.max(r5, r6);
        r0 = r18;
        r5 = r0.f5919h;
        r12 = r5.m871b();
        r5 = r12 + -1;
        r0 = r18;
        r6 = r0.f5920i;
        r2 = r2 + r6;
        r13 = java.lang.Math.min(r5, r2);
        r0 = r18;
        r2 = r0.f5915b;
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
        r5 = r0.f5915b;
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
        r4 = r0.f5919h;
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
        r2 = r0.f5916e;
        r2 = r2.size();
        if (r5 >= r2) goto L_0x033c;
    L_0x00e7:
        r0 = r18;
        r2 = r0.f5916e;
        r2 = r2.get(r5);
        r2 = (mobi.mmdt.ott.view.components.imageslider.Tricks.C1829g) r2;
        r7 = r2.f5945b;
        r0 = r18;
        r8 = r0.f5920i;
        if (r7 < r8) goto L_0x01cf;
    L_0x00f9:
        r7 = r2.f5945b;
        r0 = r18;
        r8 = r0.f5920i;
        if (r7 != r8) goto L_0x033c;
    L_0x0101:
        if (r2 != 0) goto L_0x0339;
    L_0x0103:
        if (r12 <= 0) goto L_0x0339;
    L_0x0105:
        r0 = r18;
        r2 = r0.f5920i;
        r0 = r18;
        r2 = r0.m8882a(r2, r5);
        r10 = r2;
    L_0x0110:
        if (r10 == 0) goto L_0x0180;
    L_0x0112:
        r9 = 0;
        r8 = r5 + -1;
        if (r8 < 0) goto L_0x01d4;
    L_0x0117:
        r0 = r18;
        r2 = r0.f5916e;
        r2 = r2.get(r8);
        r2 = (mobi.mmdt.ott.view.components.imageslider.Tricks.C1829g) r2;
    L_0x0121:
        r14 = r18.getClientWidth();
        if (r14 > 0) goto L_0x01d7;
    L_0x0127:
        r6 = 0;
    L_0x0128:
        r0 = r18;
        r7 = r0.f5920i;
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
        r6 = r10.f5947d;
        r9 = r8 + 1;
        r2 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r2 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1));
        if (r2 >= 0) goto L_0x017b;
    L_0x014c:
        r0 = r18;
        r2 = r0.f5916e;
        r2 = r2.size();
        if (r9 >= r2) goto L_0x024c;
    L_0x0156:
        r0 = r18;
        r2 = r0.f5916e;
        r2 = r2.get(r9);
        r2 = (mobi.mmdt.ott.view.components.imageslider.Tricks.C1829g) r2;
        r7 = r2;
    L_0x0161:
        if (r14 > 0) goto L_0x024f;
    L_0x0163:
        r2 = 0;
        r5 = r2;
    L_0x0165:
        r0 = r18;
        r2 = r0.f5920i;
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
        r0.m8867a(r10, r8, r4);
    L_0x0180:
        r0 = r18;
        r4 = r0.f5919h;
        r0 = r18;
        r5 = r0.f5920i;
        if (r10 == 0) goto L_0x02e8;
    L_0x018a:
        r2 = r10.f5944a;
    L_0x018c:
        r0 = r18;
        r4.m876b(r0, r5, r2);
        r0 = r18;
        r2 = r0.f5919h;
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
        r2 = (mobi.mmdt.ott.view.components.imageslider.Tricks.C1830h) r2;
        r2.f5954f = r4;
        r7 = r2.f5949a;
        if (r7 != 0) goto L_0x01cb;
    L_0x01b4:
        r7 = r2.f5951c;
        r8 = 0;
        r7 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1));
        if (r7 != 0) goto L_0x01cb;
    L_0x01bb:
        r0 = r18;
        r6 = r0.m8883a(r6);
        if (r6 == 0) goto L_0x01cb;
    L_0x01c3:
        r7 = r6.f5947d;
        r2.f5951c = r7;
        r6 = r6.f5945b;
        r2.f5953e = r6;
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
        r7 = r10.f5947d;
        r6 = r6 - r7;
        r7 = r18.getPaddingLeft();
        r7 = (float) r7;
        r15 = (float) r14;
        r7 = r7 / r15;
        r6 = r6 + r7;
        goto L_0x0128;
    L_0x01e6:
        r15 = r2.f5945b;
        if (r9 != r15) goto L_0x0210;
    L_0x01ea:
        r15 = r2.f5946c;
        if (r15 != 0) goto L_0x0210;
    L_0x01ee:
        r0 = r18;
        r15 = r0.f5916e;
        r15.remove(r5);
        r0 = r18;
        r15 = r0.f5919h;
        r2 = r2.f5944a;
        r0 = r18;
        r15.m869a(r0, r9, r2);
        r5 = r5 + -1;
        r8 = r8 + -1;
        if (r5 < 0) goto L_0x0214;
    L_0x0206:
        r0 = r18;
        r2 = r0.f5916e;
        r2 = r2.get(r5);
        r2 = (mobi.mmdt.ott.view.components.imageslider.Tricks.C1829g) r2;
    L_0x0210:
        r9 = r9 + -1;
        goto L_0x0138;
    L_0x0214:
        r2 = 0;
        goto L_0x0210;
    L_0x0216:
        if (r2 == 0) goto L_0x0230;
    L_0x0218:
        r15 = r2.f5945b;
        if (r9 != r15) goto L_0x0230;
    L_0x021c:
        r2 = r2.f5947d;
        r7 = r7 + r2;
        r5 = r5 + -1;
        if (r5 < 0) goto L_0x022e;
    L_0x0223:
        r0 = r18;
        r2 = r0.f5916e;
        r2 = r2.get(r5);
        r2 = (mobi.mmdt.ott.view.components.imageslider.Tricks.C1829g) r2;
        goto L_0x0210;
    L_0x022e:
        r2 = 0;
        goto L_0x0210;
    L_0x0230:
        r2 = r5 + 1;
        r0 = r18;
        r2 = r0.m8882a(r9, r2);
        r2 = r2.f5947d;
        r7 = r7 + r2;
        r8 = r8 + 1;
        if (r5 < 0) goto L_0x024a;
    L_0x023f:
        r0 = r18;
        r2 = r0.f5916e;
        r2 = r2.get(r5);
        r2 = (mobi.mmdt.ott.view.components.imageslider.Tricks.C1829g) r2;
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
        r11 = r2.f5945b;
        if (r9 != r11) goto L_0x0332;
    L_0x0260:
        r11 = r2.f5946c;
        if (r11 != 0) goto L_0x0332;
    L_0x0264:
        r0 = r18;
        r11 = r0.f5916e;
        r11.remove(r7);
        r0 = r18;
        r11 = r0.f5919h;
        r2 = r2.f5944a;
        r0 = r18;
        r11.m869a(r0, r9, r2);
        r0 = r18;
        r2 = r0.f5916e;
        r2 = r2.size();
        if (r7 >= r2) goto L_0x0298;
    L_0x0280:
        r0 = r18;
        r2 = r0.f5916e;
        r2 = r2.get(r7);
        r2 = (mobi.mmdt.ott.view.components.imageslider.Tricks.C1829g) r2;
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
        r11 = r2.f5945b;
        if (r9 != r11) goto L_0x02c1;
    L_0x02a0:
        r2 = r2.f5947d;
        r6 = r6 + r2;
        r7 = r7 + 1;
        r0 = r18;
        r2 = r0.f5916e;
        r2 = r2.size();
        if (r7 >= r2) goto L_0x02bf;
    L_0x02af:
        r0 = r18;
        r2 = r0.f5916e;
        r2 = r2.get(r7);
        r2 = (mobi.mmdt.ott.view.components.imageslider.Tricks.C1829g) r2;
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
        r2 = r0.m8882a(r9, r7);
        r7 = r7 + 1;
        r2 = r2.f5947d;
        r6 = r6 + r2;
        r0 = r18;
        r2 = r0.f5916e;
        r2 = r2.size();
        if (r7 >= r2) goto L_0x02e6;
    L_0x02d6:
        r0 = r18;
        r2 = r0.f5916e;
        r2 = r2.get(r7);
        r2 = (mobi.mmdt.ott.view.components.imageslider.Tricks.C1829g) r2;
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
        r18.m8878h();
        r2 = r18.hasFocus();
        if (r2 == 0) goto L_0x002f;
    L_0x02f4:
        r2 = r18.findFocus();
        if (r2 == 0) goto L_0x0330;
    L_0x02fa:
        r0 = r18;
        r2 = r0.m8896b(r2);
    L_0x0300:
        if (r2 == 0) goto L_0x030a;
    L_0x0302:
        r2 = r2.f5945b;
        r0 = r18;
        r4 = r0.f5920i;
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
        r5 = r0.m8883a(r4);
        if (r5 == 0) goto L_0x032d;
    L_0x031f:
        r5 = r5.f5945b;
        r0 = r18;
        r6 = r0.f5920i;
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
        throw new UnsupportedOperationException("Method not decompiled: mobi.mmdt.ott.view.components.imageslider.Tricks.ViewPagerEx.a(int):void");
    }

    protected void m8886a(int i, float f, int i2) {
        int paddingLeft;
        int paddingRight;
        int i3;
        if (this.f5910S > 0) {
            int scrollX = getScrollX();
            paddingLeft = getPaddingLeft();
            paddingRight = getPaddingRight();
            int width = getWidth();
            int childCount = getChildCount();
            i3 = 0;
            while (i3 < childCount) {
                int i4;
                View childAt = getChildAt(i3);
                C1830h c1830h = (C1830h) childAt.getLayoutParams();
                if (c1830h.f5949a) {
                    int max;
                    switch (c1830h.f5950b & 7) {
                        case VideoSize.CIF /*1*/:
                            max = Math.max((width - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            i4 = paddingRight;
                            paddingRight = paddingLeft;
                            paddingLeft = i4;
                            break;
                        case Version.API03_CUPCAKE_15 /*3*/:
                            max = childAt.getWidth() + paddingLeft;
                            i4 = paddingLeft;
                            paddingLeft = paddingRight;
                            paddingRight = max;
                            max = i4;
                            break;
                        case Version.API05_ECLAIR_20 /*5*/:
                            max = (width - paddingRight) - childAt.getMeasuredWidth();
                            i4 = paddingRight + childAt.getMeasuredWidth();
                            paddingRight = paddingLeft;
                            paddingLeft = i4;
                            break;
                        default:
                            max = paddingLeft;
                            i4 = paddingRight;
                            paddingRight = paddingLeft;
                            paddingLeft = i4;
                            break;
                    }
                    max = (max + scrollX) - childAt.getLeft();
                    if (max != 0) {
                        childAt.offsetLeftAndRight(max);
                    }
                } else {
                    i4 = paddingRight;
                    paddingRight = paddingLeft;
                    paddingLeft = i4;
                }
                i3++;
                i4 = paddingLeft;
                paddingLeft = paddingRight;
                paddingRight = i4;
            }
        }
        Iterator it = this.f5911T.iterator();
        while (it.hasNext()) {
            C1818k c1818k = (C1818k) it.next();
            if (c1818k != null) {
                c1818k.m8824a(i, f, i2);
            }
        }
        if (this.f5912U != null) {
            this.f5912U.m8824a(i, f, i2);
        }
        if (this.f5914W != null) {
            paddingRight = getScrollX();
            i3 = getChildCount();
            for (paddingLeft = 0; paddingLeft < i3; paddingLeft++) {
                View childAt2 = getChildAt(paddingLeft);
                if (!((C1830h) childAt2.getLayoutParams()).f5949a) {
                    this.f5914W.m8916b(childAt2, ((float) (childAt2.getLeft() - paddingRight)) / ((float) getClientWidth()));
                }
            }
        }
        this.f5909R = true;
    }

    void m8887a(int i, int i2, int i3) {
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int i4 = i - scrollX;
        int i5 = i2 - scrollY;
        if (i4 == 0 && i5 == 0) {
            m8868a(false);
            m8898c();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i6 = clientWidth / 2;
        float a = (((float) i6) * m8881a(Math.min(1.0f, (((float) Math.abs(i4)) * 1.0f) / ((float) clientWidth)))) + ((float) i6);
        int abs = Math.abs(i3);
        if (abs > 0) {
            clientWidth = Math.round(1000.0f * Math.abs(a / ((float) abs))) * 4;
        } else {
            clientWidth = (int) (((((float) Math.abs(i4)) / ((((float) clientWidth) * this.f5919h.m879d(this.f5920i)) + ((float) this.f5926o))) + 1.0f) * 100.0f);
        }
        this.f5924m.startScroll(scrollX, scrollY, i4, i5, Math.min(clientWidth, 600));
        cb.m2417d(this);
    }

    public void m8888a(int i, boolean z) {
        this.f5934w = false;
        m8889a(i, z, false);
    }

    void m8889a(int i, boolean z, boolean z2) {
        m8890a(i, z, z2, 0);
    }

    void m8890a(int i, boolean z, boolean z2, int i2) {
        boolean z3 = false;
        if (this.f5919h == null || this.f5919h.m871b() <= 0) {
            setScrollingCacheEnabled(false);
        } else if (z2 || this.f5920i != i || this.f5916e.size() == 0) {
            if (i < 0) {
                i = 0;
            } else if (i >= this.f5919h.m871b()) {
                i = this.f5919h.m871b() - 1;
            }
            int i3 = this.f5935x;
            if (i > this.f5920i + i3 || i < this.f5920i - i3) {
                for (int i4 = 0; i4 < this.f5916e.size(); i4++) {
                    ((C1829g) this.f5916e.get(i4)).f5946c = true;
                }
            }
            if (this.f5920i != i) {
                z3 = true;
            }
            if (this.f5908Q) {
                this.f5920i = i;
                m8874d(i);
                requestLayout();
                return;
            }
            m8885a(i);
            m8864a(i, z, i2, z3);
        } else {
            setScrollingCacheEnabled(false);
        }
    }

    public void m8891a(C1818k c1818k) {
        if (!this.f5911T.contains(c1818k)) {
            this.f5911T.add(c1818k);
        }
    }

    public void m8892a(boolean z, C1833l c1833l) {
        int i = 1;
        boolean z2 = c1833l != null;
        int i2 = z2 == (this.f5914W == null) ? 1 : 0;
        this.f5914W = c1833l;
        setChildrenDrawingOrderEnabledCompat(z2);
        if (z2) {
            if (z) {
                i = 2;
            }
            this.ab = i;
        } else {
            this.ab = 0;
        }
        if (i2 != 0) {
            m8898c();
        }
    }

    public boolean m8893a(KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0) {
            return false;
        }
        switch (keyEvent.getKeyCode()) {
            case C1317h.Toolbar_navigationContentDescription /*21*/:
                return m8899c(17);
            case C1317h.Toolbar_logoDescription /*22*/:
                return m8899c(66);
            case C1317h.Theme_popupWindowStyle /*61*/:
                return VERSION.SDK_INT >= 11 ? aa.m2205a(keyEvent) ? m8899c(2) : aa.m2206a(keyEvent, 1) ? m8899c(1) : false : false;
            default:
                return false;
        }
    }

    protected boolean m8894a(View view, boolean z, int i, int i2, int i3) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (i2 + scrollX >= childAt.getLeft() && i2 + scrollX < childAt.getRight() && i3 + scrollY >= childAt.getTop() && i3 + scrollY < childAt.getBottom()) {
                    if (m8894a(childAt, true, i, (i2 + scrollX) - childAt.getLeft(), (i3 + scrollY) - childAt.getTop())) {
                        return true;
                    }
                }
            }
        }
        return z && cb.m2406a(view, -i);
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0) {
                    C1829g a = m8883a(childAt);
                    if (a != null && a.f5945b == this.f5920i) {
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
                C1829g a = m8883a(childAt);
                if (a != null && a.f5945b == this.f5920i) {
                    childAt.addTouchables(arrayList);
                }
            }
        }
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        LayoutParams generateLayoutParams = !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : layoutParams;
        C1830h c1830h = (C1830h) generateLayoutParams;
        c1830h.f5949a |= view instanceof C1828f;
        if (!this.f5932u) {
            super.addView(view, i, generateLayoutParams);
        } else if (c1830h == null || !c1830h.f5949a) {
            c1830h.f5952d = true;
            addViewInLayout(view, i, generateLayoutParams);
        } else {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
    }

    C1829g m8895b(int i) {
        for (int i2 = 0; i2 < this.f5916e.size(); i2++) {
            C1829g c1829g = (C1829g) this.f5916e.get(i2);
            if (c1829g.f5945b == i) {
                return c1829g;
            }
        }
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    mobi.mmdt.ott.view.components.imageslider.Tricks.C1829g m8896b(android.view.View r3) {
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
        r0 = r2.m8883a(r3);
        goto L_0x000d;
        */
        throw new UnsupportedOperationException("Method not decompiled: mobi.mmdt.ott.view.components.imageslider.Tricks.ViewPagerEx.b(android.view.View):mobi.mmdt.ott.view.components.imageslider.Tricks.g");
    }

    void m8897b() {
        int i;
        int b = this.f5919h.m871b();
        this.f5915b = b;
        boolean z = this.f5916e.size() < (this.f5935x * 2) + 1 && this.f5916e.size() < b;
        boolean z2 = false;
        int i2 = this.f5920i;
        boolean z3 = z;
        int i3 = 0;
        while (i3 < this.f5916e.size()) {
            int i4;
            boolean z4;
            boolean z5;
            C1829g c1829g = (C1829g) this.f5916e.get(i3);
            int a = this.f5919h.m860a(c1829g.f5944a);
            if (a == -1) {
                i4 = i3;
                z4 = z2;
                i = i2;
                z5 = z3;
            } else if (a == -2) {
                this.f5916e.remove(i3);
                i3--;
                if (!z2) {
                    this.f5919h.m868a((ViewGroup) this);
                    z2 = true;
                }
                this.f5919h.m869a((ViewGroup) this, c1829g.f5945b, c1829g.f5944a);
                if (this.f5920i == c1829g.f5945b) {
                    i4 = i3;
                    z4 = z2;
                    i = Math.max(0, Math.min(this.f5920i, b - 1));
                    z5 = true;
                } else {
                    i4 = i3;
                    z4 = z2;
                    i = i2;
                    z5 = true;
                }
            } else if (c1829g.f5945b != a) {
                if (c1829g.f5945b == this.f5920i) {
                    i2 = a;
                }
                c1829g.f5945b = a;
                i4 = i3;
                z4 = z2;
                i = i2;
                z5 = true;
            } else {
                i4 = i3;
                z4 = z2;
                i = i2;
                z5 = z3;
            }
            z3 = z5;
            i2 = i;
            z2 = z4;
            i3 = i4 + 1;
        }
        if (z2) {
            this.f5919h.m875b((ViewGroup) this);
        }
        Collections.sort(this.f5916e, f5890c);
        if (z3) {
            i = getChildCount();
            for (i3 = 0; i3 < i; i3++) {
                C1830h c1830h = (C1830h) getChildAt(i3).getLayoutParams();
                if (!c1830h.f5949a) {
                    c1830h.f5951c = 0.0f;
                }
            }
            m8889a(i2, false, true);
            requestLayout();
        }
    }

    void m8898c() {
        m8885a(this.f5920i);
    }

    public boolean m8899c(int i) {
        View view;
        boolean d;
        View findFocus = findFocus();
        if (findFocus == this) {
            view = null;
        } else {
            if (findFocus != null) {
                Object obj;
                for (ViewPagerEx parent = findFocus.getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
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
                    Log.e("ViewPagerEx", "arrowScroll tried to find focus based on non-child current focused view " + stringBuilder.toString());
                    view = null;
                }
            }
            view = findFocus;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, view, i);
        if (findNextFocus == null || findNextFocus == view) {
            if (i == 17 || i == 1) {
                d = m8900d();
            } else {
                if (i == 66 || i == 2) {
                    d = m8901e();
                }
                d = false;
            }
        } else if (i == 17) {
            d = (view == null || m8861a(this.f5918g, findNextFocus).left < m8861a(this.f5918g, view).left) ? findNextFocus.requestFocus() : m8900d();
        } else {
            if (i == 66) {
                d = (view == null || m8861a(this.f5918g, findNextFocus).left > m8861a(this.f5918g, view).left) ? findNextFocus.requestFocus() : m8901e();
            }
            d = false;
        }
        if (d) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
        }
        return d;
    }

    public boolean canScrollHorizontally(int i) {
        boolean z = true;
        if (this.f5919h == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        if (i < 0) {
            if (scrollX <= ((int) (((float) clientWidth) * this.f5930s))) {
                z = false;
            }
            return z;
        } else if (i <= 0) {
            return false;
        } else {
            if (scrollX >= ((int) (((float) clientWidth) * this.f5931t))) {
                z = false;
            }
            return z;
        }
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return (layoutParams instanceof C1830h) && super.checkLayoutParams(layoutParams);
    }

    public void computeScroll() {
        if (this.f5924m.isFinished() || !this.f5924m.computeScrollOffset()) {
            m8868a(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.f5924m.getCurrX();
        int currY = this.f5924m.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
            if (!m8875e(currX)) {
                this.f5924m.abortAnimation();
                scrollTo(0, currY);
            }
        }
        cb.m2417d(this);
    }

    boolean m8900d() {
        if (this.f5920i <= 0) {
            return false;
        }
        m8888a(this.f5920i - 1, true);
        return true;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || m8893a(keyEvent);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == ItemAnimator.FLAG_APPEARED_IN_PRE_LAYOUT) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                C1829g a = m8883a(childAt);
                if (a != null && a.f5945b == this.f5920i && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
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
        if (a == 0 || (a == 1 && this.f5919h != null && this.f5919h.m871b() > 1)) {
            int height;
            int width;
            if (!this.f5906O.m3135a()) {
                a = canvas.save();
                height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((float) ((-height) + getPaddingTop()), this.f5930s * ((float) width));
                this.f5906O.m3134a(height, width);
                i = 0 | this.f5906O.m3139a(canvas);
                canvas.restoreToCount(a);
            }
            if (!this.f5907P.m3135a()) {
                a = canvas.save();
                height = getWidth();
                width = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate((float) (-getPaddingTop()), (-(this.f5931t + 1.0f)) * ((float) height));
                this.f5907P.m3134a(width, height);
                i |= this.f5907P.m3139a(canvas);
                canvas.restoreToCount(a);
            }
        } else {
            this.f5906O.m3140b();
            this.f5907P.m3140b();
        }
        if (i != 0) {
            cb.m2417d(this);
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f5927p;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    boolean m8901e() {
        if (this.f5919h == null || this.f5920i >= this.f5919h.m871b() - 1) {
            return false;
        }
        m8888a(this.f5920i + 1, true);
        return true;
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new C1830h();
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new C1830h(getContext(), attributeSet);
    }

    protected LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public bt getAdapter() {
        return this.f5919h;
    }

    protected int getChildDrawingOrder(int i, int i2) {
        if (this.ab == 2) {
            i2 = (i - 1) - i2;
        }
        return ((C1830h) ((View) this.ac.get(i2)).getLayoutParams()).f5954f;
    }

    public int getCurrentItem() {
        return this.f5920i;
    }

    public int getOffscreenPageLimit() {
        return this.f5935x;
    }

    public int getPageMargin() {
        return this.f5926o;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f5908Q = true;
    }

    protected void onDetachedFromWindow() {
        removeCallbacks(this.ae);
        super.onDetachedFromWindow();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f5926o > 0 && this.f5927p != null && this.f5916e.size() > 0 && this.f5919h != null) {
            int scrollX = getScrollX();
            int width = getWidth();
            float f = ((float) this.f5926o) / ((float) width);
            C1829g c1829g = (C1829g) this.f5916e.get(0);
            float f2 = c1829g.f5948e;
            int size = this.f5916e.size();
            int i = c1829g.f5945b;
            int i2 = ((C1829g) this.f5916e.get(size - 1)).f5945b;
            int i3 = 0;
            int i4 = i;
            while (i4 < i2) {
                float f3;
                while (i4 > c1829g.f5945b && i3 < size) {
                    i3++;
                    c1829g = (C1829g) this.f5916e.get(i3);
                }
                if (i4 == c1829g.f5945b) {
                    f3 = (c1829g.f5948e + c1829g.f5947d) * ((float) width);
                    f2 = (c1829g.f5948e + c1829g.f5947d) + f;
                } else {
                    float d = this.f5919h.m879d(i4);
                    f3 = (f2 + d) * ((float) width);
                    f2 += d + f;
                }
                if (((float) this.f5926o) + f3 > ((float) scrollX)) {
                    this.f5927p.setBounds((int) f3, this.f5928q, (int) ((((float) this.f5926o) + f3) + 0.5f), this.f5929r);
                    this.f5927p.draw(canvas);
                }
                if (f3 <= ((float) (scrollX + width))) {
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
            this.f5936y = false;
            this.f5937z = false;
            this.f5899H = -1;
            if (this.f5900I == null) {
                return false;
            }
            this.f5900I.recycle();
            this.f5900I = null;
            return false;
        }
        if (action != 0) {
            if (this.f5936y) {
                return true;
            }
            if (this.f5937z) {
                return false;
            }
        }
        switch (action) {
            case VideoSize.QCIF /*0*/:
                float x = motionEvent.getX();
                this.f5897F = x;
                this.f5895D = x;
                x = motionEvent.getY();
                this.f5898G = x;
                this.f5896E = x;
                this.f5899H = bf.m2312b(motionEvent, 0);
                this.f5937z = false;
                this.f5924m.computeScrollOffset();
                if (this.af == 2 && Math.abs(this.f5924m.getFinalX() - this.f5924m.getCurrX()) > this.f5904M) {
                    this.f5924m.abortAnimation();
                    this.f5934w = false;
                    m8898c();
                    this.f5936y = true;
                    m8873c(true);
                    setScrollState(1);
                    break;
                }
                m8868a(false);
                this.f5936y = false;
                break;
                break;
            case VideoSize.HVGA /*2*/:
                action = this.f5899H;
                if (action != -1) {
                    action = bf.m2310a(motionEvent, action);
                    float c = bf.m2313c(motionEvent, action);
                    float f = c - this.f5895D;
                    float abs = Math.abs(f);
                    float d = bf.m2315d(motionEvent, action);
                    float abs2 = Math.abs(d - this.f5898G);
                    if (f == 0.0f || m8869a(this.f5895D, f) || !m8894a(this, false, (int) f, (int) c, (int) d)) {
                        if (abs > ((float) this.f5894C) && 0.5f * abs > abs2) {
                            this.f5936y = true;
                            m8873c(true);
                            setScrollState(1);
                            this.f5895D = f > 0.0f ? this.f5897F + ((float) this.f5894C) : this.f5897F - ((float) this.f5894C);
                            this.f5896E = d;
                            setScrollingCacheEnabled(true);
                        } else if (abs2 > ((float) this.f5894C)) {
                            this.f5937z = true;
                        }
                        if (this.f5936y && m8872b(c)) {
                            cb.m2417d(this);
                            break;
                        }
                    }
                    this.f5895D = c;
                    this.f5896E = d;
                    this.f5937z = true;
                    return false;
                }
                break;
            case Version.API06_ECLAIR_201 /*6*/:
                m8865a(motionEvent);
                break;
        }
        if (this.f5900I == null) {
            this.f5900I = VelocityTracker.obtain();
        }
        this.f5900I.addMovement(motionEvent);
        return this.f5936y;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        C1830h c1830h;
        int max;
        int childCount = getChildCount();
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i7 = 0;
        int i8 = 0;
        while (i8 < childCount) {
            int measuredWidth;
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                c1830h = (C1830h) childAt.getLayoutParams();
                if (c1830h.f5949a) {
                    int i9 = c1830h.f5950b & 112;
                    switch (c1830h.f5950b & 7) {
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
                    max += scrollX;
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
        max = (i5 - paddingLeft) - paddingRight;
        for (paddingRight = 0; paddingRight < childCount; paddingRight++) {
            View childAt2 = getChildAt(paddingRight);
            if (childAt2.getVisibility() != 8) {
                c1830h = (C1830h) childAt2.getLayoutParams();
                if (!c1830h.f5949a) {
                    C1829g a = m8883a(childAt2);
                    if (a != null) {
                        i5 = ((int) (a.f5948e * ((float) max))) + paddingLeft;
                        if (c1830h.f5952d) {
                            c1830h.f5952d = false;
                            childAt2.measure(MeasureSpec.makeMeasureSpec((int) (c1830h.f5951c * ((float) max)), 1073741824), MeasureSpec.makeMeasureSpec((i6 - paddingTop) - paddingBottom, 1073741824));
                        }
                        childAt2.layout(i5, paddingTop, childAt2.getMeasuredWidth() + i5, childAt2.getMeasuredHeight() + paddingTop);
                    }
                }
            }
        }
        this.f5928q = paddingTop;
        this.f5929r = i6 - paddingBottom;
        this.f5910S = i7;
        if (this.f5908Q) {
            m8864a(this.f5920i, false, 0, false);
        }
        this.f5908Q = false;
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        setMeasuredDimension(getDefaultSize(0, i), getDefaultSize(0, i2));
        int measuredWidth = getMeasuredWidth();
        this.f5893B = Math.min(measuredWidth / 10, this.f5892A);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            C1830h c1830h;
            int i6;
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                c1830h = (C1830h) childAt.getLayoutParams();
                if (c1830h != null && c1830h.f5949a) {
                    int i7 = c1830h.f5950b & 7;
                    i3 = c1830h.f5950b & 112;
                    i4 = RtlSpacingHelper.UNDEFINED;
                    i6 = RtlSpacingHelper.UNDEFINED;
                    Object obj = (i3 == 48 || i3 == 80) ? 1 : null;
                    Object obj2 = (i7 == 3 || i7 == 5) ? 1 : null;
                    if (obj != null) {
                        i4 = 1073741824;
                    } else if (obj2 != null) {
                        i6 = 1073741824;
                    }
                    if (c1830h.width != -2) {
                        i3 = 1073741824;
                        i4 = c1830h.width != -1 ? c1830h.width : paddingLeft;
                    } else {
                        i3 = i4;
                        i4 = paddingLeft;
                    }
                    if (c1830h.height != -2) {
                        i6 = 1073741824;
                        if (c1830h.height != -1) {
                            measuredWidth = c1830h.height;
                            childAt.measure(MeasureSpec.makeMeasureSpec(i4, i3), MeasureSpec.makeMeasureSpec(measuredWidth, i6));
                            if (obj != null) {
                                measuredHeight -= childAt.getMeasuredHeight();
                            } else if (obj2 != null) {
                                paddingLeft -= childAt.getMeasuredWidth();
                            }
                        }
                    }
                    measuredWidth = measuredHeight;
                    childAt.measure(MeasureSpec.makeMeasureSpec(i4, i3), MeasureSpec.makeMeasureSpec(measuredWidth, i6));
                    if (obj != null) {
                        measuredHeight -= childAt.getMeasuredHeight();
                    } else if (obj2 != null) {
                        paddingLeft -= childAt.getMeasuredWidth();
                    }
                }
            }
        }
        MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        i4 = MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.f5932u = true;
        m8898c();
        this.f5932u = false;
        i3 = getChildCount();
        for (i6 = 0; i6 < i3; i6++) {
            View childAt2 = getChildAt(i6);
            if (childAt2.getVisibility() != 8) {
                c1830h = (C1830h) childAt2.getLayoutParams();
                if (c1830h == null || !c1830h.f5949a) {
                    childAt2.measure(MeasureSpec.makeMeasureSpec((int) (c1830h.f5951c * ((float) paddingLeft)), 1073741824), i4);
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
                C1829g a = m8883a(childAt);
                if (a != null && a.f5945b == this.f5920i && childAt.requestFocus(i, rect)) {
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
            if (this.f5919h != null) {
                this.f5919h.m865a(savedState.f5939b, savedState.f5940c);
                m8889a(savedState.f5938a, false, true);
                return;
            }
            this.f5921j = savedState.f5938a;
            this.f5922k = savedState.f5939b;
            this.f5923l = savedState.f5940c;
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f5938a = this.f5920i;
        if (this.f5919h != null) {
            savedState.f5939b = this.f5919h.m861a();
        }
        return savedState;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            m8863a(i, i3, this.f5926o, this.f5926o);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.f5905N) {
            return true;
        }
        if (motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) {
            return false;
        }
        if (this.f5919h == null || this.f5919h.m871b() == 0) {
            return false;
        }
        if (this.f5900I == null) {
            this.f5900I = VelocityTracker.obtain();
        }
        this.f5900I.addMovement(motionEvent);
        float x;
        int a;
        switch (motionEvent.getAction() & 255) {
            case VideoSize.QCIF /*0*/:
                this.f5924m.abortAnimation();
                this.f5934w = false;
                m8898c();
                x = motionEvent.getX();
                this.f5897F = x;
                this.f5895D = x;
                x = motionEvent.getY();
                this.f5898G = x;
                this.f5896E = x;
                this.f5899H = bf.m2312b(motionEvent, 0);
                break;
            case VideoSize.CIF /*1*/:
                if (this.f5936y) {
                    VelocityTracker velocityTracker = this.f5900I;
                    velocityTracker.computeCurrentVelocity(1000, (float) this.f5902K);
                    a = (int) bw.m2358a(velocityTracker, this.f5899H);
                    this.f5934w = true;
                    int clientWidth = getClientWidth();
                    int scrollX = getScrollX();
                    C1829g i = m8879i();
                    m8890a(m8860a(i.f5945b, ((((float) scrollX) / ((float) clientWidth)) - i.f5948e) / i.f5947d, a, (int) (bf.m2313c(motionEvent, bf.m2310a(motionEvent, this.f5899H)) - this.f5897F)), true, true, a);
                    this.f5899H = -1;
                    m8880j();
                    z = this.f5907P.m3141c() | this.f5906O.m3141c();
                    break;
                }
                break;
            case VideoSize.HVGA /*2*/:
                if (!this.f5936y) {
                    a = bf.m2310a(motionEvent, this.f5899H);
                    float c = bf.m2313c(motionEvent, a);
                    float abs = Math.abs(c - this.f5895D);
                    float d = bf.m2315d(motionEvent, a);
                    x = Math.abs(d - this.f5896E);
                    if (abs > ((float) this.f5894C) && abs > x) {
                        this.f5936y = true;
                        m8873c(true);
                        this.f5895D = c - this.f5897F > 0.0f ? this.f5897F + ((float) this.f5894C) : this.f5897F - ((float) this.f5894C);
                        this.f5896E = d;
                        setScrollState(1);
                        setScrollingCacheEnabled(true);
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                }
                if (this.f5936y) {
                    z = false | m8872b(bf.m2313c(motionEvent, bf.m2310a(motionEvent, this.f5899H)));
                    break;
                }
                break;
            case Version.API03_CUPCAKE_15 /*3*/:
                if (this.f5936y) {
                    m8864a(this.f5920i, true, 0, false);
                    this.f5899H = -1;
                    m8880j();
                    z = this.f5907P.m3141c() | this.f5906O.m3141c();
                    break;
                }
                break;
            case Version.API05_ECLAIR_20 /*5*/:
                a = bf.m2311b(motionEvent);
                this.f5895D = bf.m2313c(motionEvent, a);
                this.f5899H = bf.m2312b(motionEvent, a);
                break;
            case Version.API06_ECLAIR_201 /*6*/:
                m8865a(motionEvent);
                this.f5895D = bf.m2313c(motionEvent, bf.m2310a(motionEvent, this.f5899H));
                break;
        }
        if (z) {
            cb.m2417d(this);
        }
        return true;
    }

    public void removeView(View view) {
        if (this.f5932u) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public void setAdapter(bt btVar) {
        if (this.f5919h != null) {
            this.f5919h.m872b(this.f5925n);
            this.f5919h.m868a((ViewGroup) this);
            for (int i = 0; i < this.f5916e.size(); i++) {
                C1829g c1829g = (C1829g) this.f5916e.get(i);
                this.f5919h.m869a((ViewGroup) this, c1829g.f5945b, c1829g.f5944a);
            }
            this.f5919h.m875b((ViewGroup) this);
            this.f5916e.clear();
            m8877g();
            this.f5920i = 0;
            scrollTo(0, 0);
        }
        bt btVar2 = this.f5919h;
        this.f5919h = btVar;
        this.f5915b = 0;
        if (this.f5919h != null) {
            if (this.f5925n == null) {
                this.f5925n = new C1834m();
            }
            this.f5919h.m864a(this.f5925n);
            this.f5934w = false;
            boolean z = this.f5908Q;
            this.f5908Q = true;
            this.f5915b = this.f5919h.m871b();
            if (this.f5921j >= 0) {
                this.f5919h.m865a(this.f5922k, this.f5923l);
                m8889a(this.f5921j, false, true);
                this.f5921j = -1;
                this.f5922k = null;
                this.f5923l = null;
            } else if (z) {
                requestLayout();
            } else {
                m8898c();
            }
        }
        if (this.f5913V != null && btVar2 != btVar) {
            this.f5913V.m8915a(btVar2, btVar);
        }
    }

    void setChildrenDrawingOrderEnabledCompat(boolean z) {
        if (VERSION.SDK_INT >= 7) {
            if (this.aa == null) {
                try {
                    this.aa = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[]{Boolean.TYPE});
                } catch (Throwable e) {
                    Log.e("ViewPagerEx", "Can't find setChildrenDrawingOrderEnabled", e);
                }
            }
            try {
                this.aa.invoke(this, new Object[]{Boolean.valueOf(z)});
            } catch (Throwable e2) {
                Log.e("ViewPagerEx", "Error changing children drawing order", e2);
            }
        }
    }

    public void setCurrentItem(int i) {
        this.f5934w = false;
        m8889a(i, !this.f5908Q, false);
    }

    public void setOffscreenPageLimit(int i) {
        if (i < 1) {
            Log.w("ViewPagerEx", "Requested offscreen page limit " + i + " too small; defaulting to " + 1);
            i = 1;
        }
        if (i != this.f5935x) {
            this.f5935x = i;
            m8898c();
        }
    }

    void setOnAdapterChangeListener(C1832j c1832j) {
        this.f5913V = c1832j;
    }

    public void setPageMargin(int i) {
        int i2 = this.f5926o;
        this.f5926o = i;
        int width = getWidth();
        m8863a(width, width, i, i2);
        requestLayout();
    }

    public void setPageMarginDrawable(int i) {
        setPageMarginDrawable(getContext().getResources().getDrawable(i));
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.f5927p = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f5927p;
    }
}
