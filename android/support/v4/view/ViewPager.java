package android.support.v4.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.os.C0269j;
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
import java.util.List;
import mobi.mmdt.ott.C1317h;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

public class ViewPager extends ViewGroup {
    private static final int[] f1236a;
    private static final ed ah;
    private static final Comparator<dv> f1237c;
    private static final Interpolator f1238d;
    private boolean f1239A;
    private boolean f1240B;
    private int f1241C;
    private int f1242D;
    private int f1243E;
    private float f1244F;
    private float f1245G;
    private float f1246H;
    private float f1247I;
    private int f1248J;
    private VelocityTracker f1249K;
    private int f1250L;
    private int f1251M;
    private int f1252N;
    private int f1253O;
    private boolean f1254P;
    private ah f1255Q;
    private ah f1256R;
    private boolean f1257S;
    private boolean f1258T;
    private boolean f1259U;
    private int f1260V;
    private List<dz> f1261W;
    private dz aa;
    private dz ab;
    private dy ac;
    private ea ad;
    private Method ae;
    private int af;
    private ArrayList<View> ag;
    private final Runnable ai;
    private int aj;
    private int f1262b;
    private final ArrayList<dv> f1263e;
    private final dv f1264f;
    private final Rect f1265g;
    private bt f1266h;
    private int f1267i;
    private int f1268j;
    private Parcelable f1269k;
    private ClassLoader f1270l;
    private Scroller f1271m;
    private eb f1272n;
    private int f1273o;
    private Drawable f1274p;
    private int f1275q;
    private int f1276r;
    private float f1277s;
    private float f1278t;
    private int f1279u;
    private int f1280v;
    private boolean f1281w;
    private boolean f1282x;
    private boolean f1283y;
    private int f1284z;

    public class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR;
        int f1233a;
        Parcelable f1234b;
        ClassLoader f1235c;

        static {
            CREATOR = C0269j.m1809a(new ec());
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            if (classLoader == null) {
                classLoader = getClass().getClassLoader();
            }
            this.f1233a = parcel.readInt();
            this.f1234b = parcel.readParcelable(classLoader);
            this.f1235c = classLoader;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f1233a + "}";
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f1233a);
            parcel.writeParcelable(this.f1234b, i);
        }
    }

    static {
        f1236a = new int[]{16842931};
        f1237c = new dr();
        f1238d = new ds();
        ah = new ed();
    }

    public ViewPager(Context context) {
        super(context);
        this.f1263e = new ArrayList();
        this.f1264f = new dv();
        this.f1265g = new Rect();
        this.f1268j = -1;
        this.f1269k = null;
        this.f1270l = null;
        this.f1277s = -3.4028235E38f;
        this.f1278t = Float.MAX_VALUE;
        this.f1284z = 1;
        this.f1248J = -1;
        this.f1257S = true;
        this.f1258T = false;
        this.ai = new dt(this);
        this.aj = 0;
        m1845a();
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1263e = new ArrayList();
        this.f1264f = new dv();
        this.f1265g = new Rect();
        this.f1268j = -1;
        this.f1269k = null;
        this.f1270l = null;
        this.f1277s = -3.4028235E38f;
        this.f1278t = Float.MAX_VALUE;
        this.f1284z = 1;
        this.f1248J = -1;
        this.f1257S = true;
        this.f1258T = false;
        this.ai = new dt(this);
        this.aj = 0;
        m1845a();
    }

    private int m1818a(int i, float f, int i2, int i3) {
        if (Math.abs(i3) <= this.f1252N || Math.abs(i2) <= this.f1250L) {
            i = (int) ((i >= this.f1267i ? 0.4f : 0.6f) + (((float) i) + f));
        } else if (i2 <= 0) {
            i++;
        }
        if (this.f1263e.size() <= 0) {
            return i;
        }
        return Math.max(((dv) this.f1263e.get(0)).f1357b, Math.min(i, ((dv) this.f1263e.get(this.f1263e.size() - 1)).f1357b));
    }

    private Rect m1819a(Rect rect, View view) {
        Rect rect2 = rect == null ? new Rect() : rect;
        if (view == null) {
            rect2.set(0, 0, 0, 0);
            return rect2;
        }
        rect2.left = view.getLeft();
        rect2.right = view.getRight();
        rect2.top = view.getTop();
        rect2.bottom = view.getBottom();
        ViewPager parent = view.getParent();
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

    private void m1821a(int i, int i2, int i3, int i4) {
        if (i2 <= 0 || this.f1263e.isEmpty()) {
            dv b = m1856b(this.f1267i);
            int min = (int) ((b != null ? Math.min(b.f1360e, this.f1278t) : 0.0f) * ((float) ((i - getPaddingLeft()) - getPaddingRight())));
            if (min != getScrollX()) {
                m1826a(false);
                scrollTo(min, getScrollY());
                return;
            }
            return;
        }
        int paddingLeft = (int) (((float) (((i - getPaddingLeft()) - getPaddingRight()) + i3)) * (((float) getScrollX()) / ((float) (((i2 - getPaddingLeft()) - getPaddingRight()) + i4))));
        scrollTo(paddingLeft, getScrollY());
        if (!this.f1271m.isFinished()) {
            this.f1271m.startScroll(paddingLeft, 0, (int) (m1856b(this.f1267i).f1360e * ((float) i)), 0, this.f1271m.getDuration() - this.f1271m.timePassed());
        }
    }

    private void m1822a(int i, boolean z, int i2, boolean z2) {
        int max;
        dv b = m1856b(i);
        if (b != null) {
            max = (int) (Math.max(this.f1277s, Math.min(b.f1360e, this.f1278t)) * ((float) getClientWidth()));
        } else {
            max = 0;
        }
        if (z) {
            m1848a(max, 0, i2);
            if (z2) {
                m1834e(i);
                return;
            }
            return;
        }
        if (z2) {
            m1834e(i);
        }
        m1826a(false);
        scrollTo(max, 0);
        m1833d(max);
    }

    private void m1824a(dv dvVar, int i, dv dvVar2) {
        float f;
        int i2;
        dv dvVar3;
        int i3;
        int b = this.f1266h.m871b();
        int clientWidth = getClientWidth();
        float f2 = clientWidth > 0 ? ((float) this.f1273o) / ((float) clientWidth) : 0.0f;
        if (dvVar2 != null) {
            clientWidth = dvVar2.f1357b;
            int i4;
            if (clientWidth < dvVar.f1357b) {
                f = (dvVar2.f1360e + dvVar2.f1359d) + f2;
                i4 = clientWidth + 1;
                i2 = 0;
                while (i4 <= dvVar.f1357b && i2 < this.f1263e.size()) {
                    dvVar3 = (dv) this.f1263e.get(i2);
                    while (i4 > dvVar3.f1357b && i2 < this.f1263e.size() - 1) {
                        i2++;
                        dvVar3 = (dv) this.f1263e.get(i2);
                    }
                    while (i4 < dvVar3.f1357b) {
                        f += this.f1266h.m879d(i4) + f2;
                        i4++;
                    }
                    dvVar3.f1360e = f;
                    f += dvVar3.f1359d + f2;
                    i4++;
                }
            } else if (clientWidth > dvVar.f1357b) {
                i2 = this.f1263e.size() - 1;
                f = dvVar2.f1360e;
                i4 = clientWidth - 1;
                while (i4 >= dvVar.f1357b && i2 >= 0) {
                    dvVar3 = (dv) this.f1263e.get(i2);
                    while (i4 < dvVar3.f1357b && i2 > 0) {
                        i2--;
                        dvVar3 = (dv) this.f1263e.get(i2);
                    }
                    while (i4 > dvVar3.f1357b) {
                        f -= this.f1266h.m879d(i4) + f2;
                        i4--;
                    }
                    f -= dvVar3.f1359d + f2;
                    dvVar3.f1360e = f;
                    i4--;
                }
            }
        }
        int size = this.f1263e.size();
        float f3 = dvVar.f1360e;
        i2 = dvVar.f1357b - 1;
        this.f1277s = dvVar.f1357b == 0 ? dvVar.f1360e : -3.4028235E38f;
        this.f1278t = dvVar.f1357b == b + -1 ? (dvVar.f1360e + dvVar.f1359d) - 1.0f : Float.MAX_VALUE;
        for (i3 = i - 1; i3 >= 0; i3--) {
            dvVar3 = (dv) this.f1263e.get(i3);
            f = f3;
            while (i2 > dvVar3.f1357b) {
                f -= this.f1266h.m879d(i2) + f2;
                i2--;
            }
            f3 = f - (dvVar3.f1359d + f2);
            dvVar3.f1360e = f3;
            if (dvVar3.f1357b == 0) {
                this.f1277s = f3;
            }
            i2--;
        }
        f3 = (dvVar.f1360e + dvVar.f1359d) + f2;
        i2 = dvVar.f1357b + 1;
        for (i3 = i + 1; i3 < size; i3++) {
            dvVar3 = (dv) this.f1263e.get(i3);
            f = f3;
            while (i2 < dvVar3.f1357b) {
                f = (this.f1266h.m879d(i2) + f2) + f;
                i2++;
            }
            if (dvVar3.f1357b == b - 1) {
                this.f1278t = (dvVar3.f1359d + f) - 1.0f;
            }
            dvVar3.f1360e = f;
            f3 = f + (dvVar3.f1359d + f2);
            i2++;
        }
        this.f1258T = false;
    }

    private void m1825a(MotionEvent motionEvent) {
        int b = bf.m2311b(motionEvent);
        if (bf.m2312b(motionEvent, b) == this.f1248J) {
            b = b == 0 ? 1 : 0;
            this.f1244F = bf.m2313c(motionEvent, b);
            this.f1248J = bf.m2312b(motionEvent, b);
            if (this.f1249K != null) {
                this.f1249K.clear();
            }
        }
    }

    private void m1826a(boolean z) {
        int scrollX;
        boolean z2 = this.aj == 2;
        if (z2) {
            setScrollingCacheEnabled(false);
            this.f1271m.abortAnimation();
            scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.f1271m.getCurrX();
            int currY = this.f1271m.getCurrY();
            if (!(scrollX == currX && scrollY == currY)) {
                scrollTo(currX, currY);
                if (currX != scrollX) {
                    m1833d(currX);
                }
            }
        }
        this.f1283y = false;
        boolean z3 = z2;
        for (scrollX = 0; scrollX < this.f1263e.size(); scrollX++) {
            dv dvVar = (dv) this.f1263e.get(scrollX);
            if (dvVar.f1358c) {
                dvVar.f1358c = false;
                z3 = true;
            }
        }
        if (!z3) {
            return;
        }
        if (z) {
            cb.m2402a((View) this, this.ai);
        } else {
            this.ai.run();
        }
    }

    private boolean m1827a(float f, float f2) {
        return (f < ((float) this.f1242D) && f2 > 0.0f) || (f > ((float) (getWidth() - this.f1242D)) && f2 < 0.0f);
    }

    private void m1829b(int i, float f, int i2) {
        if (this.aa != null) {
            this.aa.m664a(i, f, i2);
        }
        if (this.f1261W != null) {
            int size = this.f1261W.size();
            for (int i3 = 0; i3 < size; i3++) {
                dz dzVar = (dz) this.f1261W.get(i3);
                if (dzVar != null) {
                    dzVar.m664a(i, f, i2);
                }
            }
        }
        if (this.ab != null) {
            this.ab.m664a(i, f, i2);
        }
    }

    private void m1830b(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            cb.m2396a(getChildAt(i), z ? 2 : 0, null);
        }
    }

    private boolean m1831b(float f) {
        boolean z;
        float f2;
        boolean z2 = true;
        boolean z3 = false;
        float f3 = this.f1244F - f;
        this.f1244F = f;
        float scrollX = ((float) getScrollX()) + f3;
        int clientWidth = getClientWidth();
        float f4 = ((float) clientWidth) * this.f1277s;
        float f5 = ((float) clientWidth) * this.f1278t;
        dv dvVar = (dv) this.f1263e.get(0);
        dv dvVar2 = (dv) this.f1263e.get(this.f1263e.size() - 1);
        if (dvVar.f1357b != 0) {
            f4 = dvVar.f1360e * ((float) clientWidth);
            z = false;
        } else {
            z = true;
        }
        if (dvVar2.f1357b != this.f1266h.m871b() - 1) {
            f2 = dvVar2.f1360e * ((float) clientWidth);
            z2 = false;
        } else {
            f2 = f5;
        }
        if (scrollX < f4) {
            if (z) {
                z3 = this.f1255Q.m3136a(Math.abs(f4 - scrollX) / ((float) clientWidth));
            }
        } else if (scrollX > f2) {
            if (z2) {
                z3 = this.f1256R.m3136a(Math.abs(scrollX - f2) / ((float) clientWidth));
            }
            f4 = f2;
        } else {
            f4 = scrollX;
        }
        this.f1244F += f4 - ((float) ((int) f4));
        scrollTo((int) f4, getScrollY());
        m1833d((int) f4);
        return z3;
    }

    private void m1832c(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    private boolean m1833d(int i) {
        if (this.f1263e.size() == 0) {
            this.f1259U = false;
            m1847a(0, 0.0f, 0);
            if (this.f1259U) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        dv k = m1840k();
        int clientWidth = getClientWidth();
        int i2 = this.f1273o + clientWidth;
        float f = ((float) this.f1273o) / ((float) clientWidth);
        int i3 = k.f1357b;
        float f2 = ((((float) i) / ((float) clientWidth)) - k.f1360e) / (k.f1359d + f);
        clientWidth = (int) (((float) i2) * f2);
        this.f1259U = false;
        m1847a(i3, f2, clientWidth);
        if (this.f1259U) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    private void m1834e(int i) {
        if (this.aa != null) {
            this.aa.m665b(i);
        }
        if (this.f1261W != null) {
            int size = this.f1261W.size();
            for (int i2 = 0; i2 < size; i2++) {
                dz dzVar = (dz) this.f1261W.get(i2);
                if (dzVar != null) {
                    dzVar.m665b(i);
                }
            }
        }
        if (this.ab != null) {
            this.ab.m665b(i);
        }
    }

    private void m1835f(int i) {
        if (this.aa != null) {
            this.aa.m663a(i);
        }
        if (this.f1261W != null) {
            int size = this.f1261W.size();
            for (int i2 = 0; i2 < size; i2++) {
                dz dzVar = (dz) this.f1261W.get(i2);
                if (dzVar != null) {
                    dzVar.m663a(i);
                }
            }
        }
        if (this.ab != null) {
            this.ab.m663a(i);
        }
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private void m1837h() {
        int i = 0;
        while (i < getChildCount()) {
            if (!((dw) getChildAt(i).getLayoutParams()).f1361a) {
                removeViewAt(i);
                i--;
            }
            i++;
        }
    }

    private void m1838i() {
        if (this.af != 0) {
            if (this.ag == null) {
                this.ag = new ArrayList();
            } else {
                this.ag.clear();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.ag.add(getChildAt(i));
            }
            Collections.sort(this.ag, ah);
        }
    }

    private boolean m1839j() {
        this.f1248J = -1;
        m1841l();
        return this.f1255Q.m3141c() | this.f1256R.m3141c();
    }

    private dv m1840k() {
        int clientWidth = getClientWidth();
        float scrollX = clientWidth > 0 ? ((float) getScrollX()) / ((float) clientWidth) : 0.0f;
        float f = clientWidth > 0 ? ((float) this.f1273o) / ((float) clientWidth) : 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        int i = -1;
        int i2 = 0;
        Object obj = 1;
        dv dvVar = null;
        while (i2 < this.f1263e.size()) {
            int i3;
            dv dvVar2;
            dv dvVar3 = (dv) this.f1263e.get(i2);
            dv dvVar4;
            if (obj != null || dvVar3.f1357b == i + 1) {
                dvVar4 = dvVar3;
                i3 = i2;
                dvVar2 = dvVar4;
            } else {
                dvVar3 = this.f1264f;
                dvVar3.f1360e = (f2 + f3) + f;
                dvVar3.f1357b = i + 1;
                dvVar3.f1359d = this.f1266h.m879d(dvVar3.f1357b);
                dvVar4 = dvVar3;
                i3 = i2 - 1;
                dvVar2 = dvVar4;
            }
            f2 = dvVar2.f1360e;
            f3 = (dvVar2.f1359d + f2) + f;
            if (obj == null && scrollX < f2) {
                return dvVar;
            }
            if (scrollX < f3 || i3 == this.f1263e.size() - 1) {
                return dvVar2;
            }
            f3 = f2;
            i = dvVar2.f1357b;
            obj = null;
            f2 = dvVar2.f1359d;
            dvVar = dvVar2;
            i2 = i3 + 1;
        }
        return dvVar;
    }

    private void m1841l() {
        this.f1239A = false;
        this.f1240B = false;
        if (this.f1249K != null) {
            this.f1249K.recycle();
            this.f1249K = null;
        }
    }

    private void setScrollState(int i) {
        if (this.aj != i) {
            this.aj = i;
            if (this.ad != null) {
                m1830b(i != 0);
            }
            m1835f(i);
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.f1282x != z) {
            this.f1282x = z;
        }
    }

    float m1842a(float f) {
        return (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
    }

    dv m1843a(int i, int i2) {
        dv dvVar = new dv();
        dvVar.f1357b = i;
        dvVar.f1356a = this.f1266h.m863a((ViewGroup) this, i);
        dvVar.f1359d = this.f1266h.m879d(i);
        if (i2 < 0 || i2 >= this.f1263e.size()) {
            this.f1263e.add(dvVar);
        } else {
            this.f1263e.add(i2, dvVar);
        }
        return dvVar;
    }

    dv m1844a(View view) {
        for (int i = 0; i < this.f1263e.size(); i++) {
            dv dvVar = (dv) this.f1263e.get(i);
            if (this.f1266h.m870a(view, dvVar.f1356a)) {
                return dvVar;
            }
        }
        return null;
    }

    void m1845a() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.f1271m = new Scroller(context, f1238d);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f = context.getResources().getDisplayMetrics().density;
        this.f1243E = db.m2730a(viewConfiguration);
        this.f1250L = (int) (400.0f * f);
        this.f1251M = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f1255Q = new ah(context);
        this.f1256R = new ah(context);
        this.f1252N = (int) (25.0f * f);
        this.f1253O = (int) (2.0f * f);
        this.f1241C = (int) (16.0f * f);
        cb.m2400a((View) this, new dx(this));
        if (cb.m2420e(this) == 0) {
            cb.m2414c((View) this, 1);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void m1846a(int r19) {
        /*
        r18 = this;
        r3 = 0;
        r2 = 2;
        r0 = r18;
        r4 = r0.f1267i;
        r0 = r19;
        if (r4 == r0) goto L_0x033f;
    L_0x000a:
        r0 = r18;
        r2 = r0.f1267i;
        r0 = r19;
        if (r2 >= r0) goto L_0x0030;
    L_0x0012:
        r2 = 66;
    L_0x0014:
        r0 = r18;
        r3 = r0.f1267i;
        r0 = r18;
        r3 = r0.m1856b(r3);
        r0 = r19;
        r1 = r18;
        r1.f1267i = r0;
        r4 = r3;
        r3 = r2;
    L_0x0026:
        r0 = r18;
        r2 = r0.f1266h;
        if (r2 != 0) goto L_0x0033;
    L_0x002c:
        r18.m1838i();
    L_0x002f:
        return;
    L_0x0030:
        r2 = 17;
        goto L_0x0014;
    L_0x0033:
        r0 = r18;
        r2 = r0.f1283y;
        if (r2 == 0) goto L_0x003d;
    L_0x0039:
        r18.m1838i();
        goto L_0x002f;
    L_0x003d:
        r2 = r18.getWindowToken();
        if (r2 == 0) goto L_0x002f;
    L_0x0043:
        r0 = r18;
        r2 = r0.f1266h;
        r0 = r18;
        r2.m868a(r0);
        r0 = r18;
        r2 = r0.f1284z;
        r5 = 0;
        r0 = r18;
        r6 = r0.f1267i;
        r6 = r6 - r2;
        r11 = java.lang.Math.max(r5, r6);
        r0 = r18;
        r5 = r0.f1266h;
        r12 = r5.m871b();
        r5 = r12 + -1;
        r0 = r18;
        r6 = r0.f1267i;
        r2 = r2 + r6;
        r13 = java.lang.Math.min(r5, r2);
        r0 = r18;
        r2 = r0.f1262b;
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
        r5 = r0.f1262b;
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
        r4 = r0.f1266h;
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
        r2 = r0.f1263e;
        r2 = r2.size();
        if (r5 >= r2) goto L_0x033c;
    L_0x00e7:
        r0 = r18;
        r2 = r0.f1263e;
        r2 = r2.get(r5);
        r2 = (android.support.v4.view.dv) r2;
        r7 = r2.f1357b;
        r0 = r18;
        r8 = r0.f1267i;
        if (r7 < r8) goto L_0x01cf;
    L_0x00f9:
        r7 = r2.f1357b;
        r0 = r18;
        r8 = r0.f1267i;
        if (r7 != r8) goto L_0x033c;
    L_0x0101:
        if (r2 != 0) goto L_0x0339;
    L_0x0103:
        if (r12 <= 0) goto L_0x0339;
    L_0x0105:
        r0 = r18;
        r2 = r0.f1267i;
        r0 = r18;
        r2 = r0.m1843a(r2, r5);
        r10 = r2;
    L_0x0110:
        if (r10 == 0) goto L_0x0180;
    L_0x0112:
        r9 = 0;
        r8 = r5 + -1;
        if (r8 < 0) goto L_0x01d4;
    L_0x0117:
        r0 = r18;
        r2 = r0.f1263e;
        r2 = r2.get(r8);
        r2 = (android.support.v4.view.dv) r2;
    L_0x0121:
        r14 = r18.getClientWidth();
        if (r14 > 0) goto L_0x01d7;
    L_0x0127:
        r6 = 0;
    L_0x0128:
        r0 = r18;
        r7 = r0.f1267i;
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
        r6 = r10.f1359d;
        r9 = r8 + 1;
        r2 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r2 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1));
        if (r2 >= 0) goto L_0x017b;
    L_0x014c:
        r0 = r18;
        r2 = r0.f1263e;
        r2 = r2.size();
        if (r9 >= r2) goto L_0x024c;
    L_0x0156:
        r0 = r18;
        r2 = r0.f1263e;
        r2 = r2.get(r9);
        r2 = (android.support.v4.view.dv) r2;
        r7 = r2;
    L_0x0161:
        if (r14 > 0) goto L_0x024f;
    L_0x0163:
        r2 = 0;
        r5 = r2;
    L_0x0165:
        r0 = r18;
        r2 = r0.f1267i;
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
        r0.m1824a(r10, r8, r4);
    L_0x0180:
        r0 = r18;
        r4 = r0.f1266h;
        r0 = r18;
        r5 = r0.f1267i;
        if (r10 == 0) goto L_0x02e8;
    L_0x018a:
        r2 = r10.f1356a;
    L_0x018c:
        r0 = r18;
        r4.m876b(r0, r5, r2);
        r0 = r18;
        r2 = r0.f1266h;
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
        r2 = (android.support.v4.view.dw) r2;
        r2.f1366f = r4;
        r7 = r2.f1361a;
        if (r7 != 0) goto L_0x01cb;
    L_0x01b4:
        r7 = r2.f1363c;
        r8 = 0;
        r7 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1));
        if (r7 != 0) goto L_0x01cb;
    L_0x01bb:
        r0 = r18;
        r6 = r0.m1844a(r6);
        if (r6 == 0) goto L_0x01cb;
    L_0x01c3:
        r7 = r6.f1359d;
        r2.f1363c = r7;
        r6 = r6.f1357b;
        r2.f1365e = r6;
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
        r7 = r10.f1359d;
        r6 = r6 - r7;
        r7 = r18.getPaddingLeft();
        r7 = (float) r7;
        r15 = (float) r14;
        r7 = r7 / r15;
        r6 = r6 + r7;
        goto L_0x0128;
    L_0x01e6:
        r15 = r2.f1357b;
        if (r9 != r15) goto L_0x0210;
    L_0x01ea:
        r15 = r2.f1358c;
        if (r15 != 0) goto L_0x0210;
    L_0x01ee:
        r0 = r18;
        r15 = r0.f1263e;
        r15.remove(r5);
        r0 = r18;
        r15 = r0.f1266h;
        r2 = r2.f1356a;
        r0 = r18;
        r15.m869a(r0, r9, r2);
        r5 = r5 + -1;
        r8 = r8 + -1;
        if (r5 < 0) goto L_0x0214;
    L_0x0206:
        r0 = r18;
        r2 = r0.f1263e;
        r2 = r2.get(r5);
        r2 = (android.support.v4.view.dv) r2;
    L_0x0210:
        r9 = r9 + -1;
        goto L_0x0138;
    L_0x0214:
        r2 = 0;
        goto L_0x0210;
    L_0x0216:
        if (r2 == 0) goto L_0x0230;
    L_0x0218:
        r15 = r2.f1357b;
        if (r9 != r15) goto L_0x0230;
    L_0x021c:
        r2 = r2.f1359d;
        r7 = r7 + r2;
        r5 = r5 + -1;
        if (r5 < 0) goto L_0x022e;
    L_0x0223:
        r0 = r18;
        r2 = r0.f1263e;
        r2 = r2.get(r5);
        r2 = (android.support.v4.view.dv) r2;
        goto L_0x0210;
    L_0x022e:
        r2 = 0;
        goto L_0x0210;
    L_0x0230:
        r2 = r5 + 1;
        r0 = r18;
        r2 = r0.m1843a(r9, r2);
        r2 = r2.f1359d;
        r7 = r7 + r2;
        r8 = r8 + 1;
        if (r5 < 0) goto L_0x024a;
    L_0x023f:
        r0 = r18;
        r2 = r0.f1263e;
        r2 = r2.get(r5);
        r2 = (android.support.v4.view.dv) r2;
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
        r11 = r2.f1357b;
        if (r9 != r11) goto L_0x0332;
    L_0x0260:
        r11 = r2.f1358c;
        if (r11 != 0) goto L_0x0332;
    L_0x0264:
        r0 = r18;
        r11 = r0.f1263e;
        r11.remove(r7);
        r0 = r18;
        r11 = r0.f1266h;
        r2 = r2.f1356a;
        r0 = r18;
        r11.m869a(r0, r9, r2);
        r0 = r18;
        r2 = r0.f1263e;
        r2 = r2.size();
        if (r7 >= r2) goto L_0x0298;
    L_0x0280:
        r0 = r18;
        r2 = r0.f1263e;
        r2 = r2.get(r7);
        r2 = (android.support.v4.view.dv) r2;
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
        r11 = r2.f1357b;
        if (r9 != r11) goto L_0x02c1;
    L_0x02a0:
        r2 = r2.f1359d;
        r6 = r6 + r2;
        r7 = r7 + 1;
        r0 = r18;
        r2 = r0.f1263e;
        r2 = r2.size();
        if (r7 >= r2) goto L_0x02bf;
    L_0x02af:
        r0 = r18;
        r2 = r0.f1263e;
        r2 = r2.get(r7);
        r2 = (android.support.v4.view.dv) r2;
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
        r2 = r0.m1843a(r9, r7);
        r7 = r7 + 1;
        r2 = r2.f1359d;
        r6 = r6 + r2;
        r0 = r18;
        r2 = r0.f1263e;
        r2 = r2.size();
        if (r7 >= r2) goto L_0x02e6;
    L_0x02d6:
        r0 = r18;
        r2 = r0.f1263e;
        r2 = r2.get(r7);
        r2 = (android.support.v4.view.dv) r2;
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
        r18.m1838i();
        r2 = r18.hasFocus();
        if (r2 == 0) goto L_0x002f;
    L_0x02f4:
        r2 = r18.findFocus();
        if (r2 == 0) goto L_0x0330;
    L_0x02fa:
        r0 = r18;
        r2 = r0.m1857b(r2);
    L_0x0300:
        if (r2 == 0) goto L_0x030a;
    L_0x0302:
        r2 = r2.f1357b;
        r0 = r18;
        r4 = r0.f1267i;
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
        r5 = r0.m1844a(r4);
        if (r5 == 0) goto L_0x032d;
    L_0x031f:
        r5 = r5.f1357b;
        r0 = r18;
        r6 = r0.f1267i;
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
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewPager.a(int):void");
    }

    protected void m1847a(int i, float f, int i2) {
        int paddingLeft;
        int paddingRight;
        int i3;
        if (this.f1260V > 0) {
            int scrollX = getScrollX();
            paddingLeft = getPaddingLeft();
            paddingRight = getPaddingRight();
            int width = getWidth();
            int childCount = getChildCount();
            i3 = 0;
            while (i3 < childCount) {
                int i4;
                View childAt = getChildAt(i3);
                dw dwVar = (dw) childAt.getLayoutParams();
                if (dwVar.f1361a) {
                    int max;
                    switch (dwVar.f1362b & 7) {
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
        m1829b(i, f, i2);
        if (this.ad != null) {
            paddingRight = getScrollX();
            i3 = getChildCount();
            for (paddingLeft = 0; paddingLeft < i3; paddingLeft++) {
                View childAt2 = getChildAt(paddingLeft);
                if (!((dw) childAt2.getLayoutParams()).f1361a) {
                    this.ad.m2752a(childAt2, ((float) (childAt2.getLeft() - paddingRight)) / ((float) getClientWidth()));
                }
            }
        }
        this.f1259U = true;
    }

    void m1848a(int i, int i2, int i3) {
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int i4 = i - scrollX;
        int i5 = i2 - scrollY;
        if (i4 == 0 && i5 == 0) {
            m1826a(false);
            m1862d();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i6 = clientWidth / 2;
        float a = (((float) i6) * m1842a(Math.min(1.0f, (((float) Math.abs(i4)) * 1.0f) / ((float) clientWidth)))) + ((float) i6);
        int abs = Math.abs(i3);
        if (abs > 0) {
            clientWidth = Math.round(1000.0f * Math.abs(a / ((float) abs))) * 4;
        } else {
            clientWidth = (int) (((((float) Math.abs(i4)) / ((((float) clientWidth) * this.f1266h.m879d(this.f1267i)) + ((float) this.f1273o))) + 1.0f) * 100.0f);
        }
        this.f1271m.startScroll(scrollX, scrollY, i4, i5, Math.min(clientWidth, 600));
        cb.m2417d(this);
    }

    public void m1849a(int i, boolean z) {
        this.f1283y = false;
        m1850a(i, z, false);
    }

    void m1850a(int i, boolean z, boolean z2) {
        m1851a(i, z, z2, 0);
    }

    void m1851a(int i, boolean z, boolean z2, int i2) {
        boolean z3 = false;
        if (this.f1266h == null || this.f1266h.m871b() <= 0) {
            setScrollingCacheEnabled(false);
        } else if (z2 || this.f1267i != i || this.f1263e.size() == 0) {
            if (i < 0) {
                i = 0;
            } else if (i >= this.f1266h.m871b()) {
                i = this.f1266h.m871b() - 1;
            }
            int i3 = this.f1284z;
            if (i > this.f1267i + i3 || i < this.f1267i - i3) {
                for (int i4 = 0; i4 < this.f1263e.size(); i4++) {
                    ((dv) this.f1263e.get(i4)).f1358c = true;
                }
            }
            if (this.f1267i != i) {
                z3 = true;
            }
            if (this.f1257S) {
                this.f1267i = i;
                if (z3) {
                    m1834e(i);
                }
                requestLayout();
                return;
            }
            m1846a(i);
            m1822a(i, z, i2, z3);
        } else {
            setScrollingCacheEnabled(false);
        }
    }

    public void m1852a(dz dzVar) {
        if (this.f1261W == null) {
            this.f1261W = new ArrayList();
        }
        this.f1261W.add(dzVar);
    }

    public void m1853a(boolean z, ea eaVar) {
        int i = 1;
        if (VERSION.SDK_INT >= 11) {
            boolean z2 = eaVar != null;
            int i2 = z2 != (this.ad != null) ? 1 : 0;
            this.ad = eaVar;
            setChildrenDrawingOrderEnabledCompat(z2);
            if (z2) {
                if (z) {
                    i = 2;
                }
                this.af = i;
            } else {
                this.af = 0;
            }
            if (i2 != 0) {
                m1862d();
            }
        }
    }

    public boolean m1854a(KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0) {
            return false;
        }
        switch (keyEvent.getKeyCode()) {
            case C1317h.Toolbar_navigationContentDescription /*21*/:
                return m1861c(17);
            case C1317h.Toolbar_logoDescription /*22*/:
                return m1861c(66);
            case C1317h.Theme_popupWindowStyle /*61*/:
                return VERSION.SDK_INT >= 11 ? aa.m2205a(keyEvent) ? m1861c(2) : aa.m2206a(keyEvent, 1) ? m1861c(1) : false : false;
            default:
                return false;
        }
    }

    protected boolean m1855a(View view, boolean z, int i, int i2, int i3) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (i2 + scrollX >= childAt.getLeft() && i2 + scrollX < childAt.getRight() && i3 + scrollY >= childAt.getTop() && i3 + scrollY < childAt.getBottom()) {
                    if (m1855a(childAt, true, i, (i2 + scrollX) - childAt.getLeft(), (i3 + scrollY) - childAt.getTop())) {
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
                    dv a = m1844a(childAt);
                    if (a != null && a.f1357b == this.f1267i) {
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
                dv a = m1844a(childAt);
                if (a != null && a.f1357b == this.f1267i) {
                    childAt.addTouchables(arrayList);
                }
            }
        }
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        LayoutParams generateLayoutParams = !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : layoutParams;
        dw dwVar = (dw) generateLayoutParams;
        dwVar.f1361a |= view instanceof du;
        if (!this.f1281w) {
            super.addView(view, i, generateLayoutParams);
        } else if (dwVar == null || !dwVar.f1361a) {
            dwVar.f1364d = true;
            addViewInLayout(view, i, generateLayoutParams);
        } else {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
    }

    dv m1856b(int i) {
        for (int i2 = 0; i2 < this.f1263e.size(); i2++) {
            dv dvVar = (dv) this.f1263e.get(i2);
            if (dvVar.f1357b == i) {
                return dvVar;
            }
        }
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    android.support.v4.view.dv m1857b(android.view.View r3) {
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
        r0 = r2.m1844a(r3);
        goto L_0x000d;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewPager.b(android.view.View):android.support.v4.view.dv");
    }

    public void m1858b() {
        if (this.f1261W != null) {
            this.f1261W.clear();
        }
    }

    public void m1859b(dz dzVar) {
        if (this.f1261W != null) {
            this.f1261W.remove(dzVar);
        }
    }

    void m1860c() {
        int b = this.f1266h.m871b();
        this.f1262b = b;
        boolean z = this.f1263e.size() < (this.f1284z * 2) + 1 && this.f1263e.size() < b;
        boolean z2 = false;
        int i = this.f1267i;
        boolean z3 = z;
        int i2 = 0;
        while (i2 < this.f1263e.size()) {
            int i3;
            boolean z4;
            int i4;
            boolean z5;
            dv dvVar = (dv) this.f1263e.get(i2);
            int a = this.f1266h.m860a(dvVar.f1356a);
            if (a == -1) {
                i3 = i2;
                z4 = z2;
                i4 = i;
                z5 = z3;
            } else if (a == -2) {
                this.f1263e.remove(i2);
                i2--;
                if (!z2) {
                    this.f1266h.m868a((ViewGroup) this);
                    z2 = true;
                }
                this.f1266h.m869a((ViewGroup) this, dvVar.f1357b, dvVar.f1356a);
                if (this.f1267i == dvVar.f1357b) {
                    i3 = i2;
                    z4 = z2;
                    i4 = Math.max(0, Math.min(this.f1267i, b - 1));
                    z5 = true;
                } else {
                    i3 = i2;
                    z4 = z2;
                    i4 = i;
                    z5 = true;
                }
            } else if (dvVar.f1357b != a) {
                if (dvVar.f1357b == this.f1267i) {
                    i = a;
                }
                dvVar.f1357b = a;
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
            this.f1266h.m875b((ViewGroup) this);
        }
        Collections.sort(this.f1263e, f1237c);
        if (z3) {
            i4 = getChildCount();
            for (i2 = 0; i2 < i4; i2++) {
                dw dwVar = (dw) getChildAt(i2).getLayoutParams();
                if (!dwVar.f1361a) {
                    dwVar.f1363c = 0.0f;
                }
            }
            m1850a(i, false, true);
            requestLayout();
        }
    }

    public boolean m1861c(int i) {
        View view;
        boolean e;
        View findFocus = findFocus();
        if (findFocus == this) {
            view = null;
        } else {
            if (findFocus != null) {
                Object obj;
                for (ViewPager parent = findFocus.getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
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
            if (i == 17 || i == 1) {
                e = m1863e();
            } else {
                if (i == 66 || i == 2) {
                    e = m1864f();
                }
                e = false;
            }
        } else if (i == 17) {
            e = (view == null || m1819a(this.f1265g, findNextFocus).left < m1819a(this.f1265g, view).left) ? findNextFocus.requestFocus() : m1863e();
        } else {
            if (i == 66) {
                e = (view == null || m1819a(this.f1265g, findNextFocus).left > m1819a(this.f1265g, view).left) ? findNextFocus.requestFocus() : m1864f();
            }
            e = false;
        }
        if (e) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
        }
        return e;
    }

    public boolean canScrollHorizontally(int i) {
        boolean z = true;
        if (this.f1266h == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        if (i < 0) {
            if (scrollX <= ((int) (((float) clientWidth) * this.f1277s))) {
                z = false;
            }
            return z;
        } else if (i <= 0) {
            return false;
        } else {
            if (scrollX >= ((int) (((float) clientWidth) * this.f1278t))) {
                z = false;
            }
            return z;
        }
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return (layoutParams instanceof dw) && super.checkLayoutParams(layoutParams);
    }

    public void computeScroll() {
        if (this.f1271m.isFinished() || !this.f1271m.computeScrollOffset()) {
            m1826a(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.f1271m.getCurrX();
        int currY = this.f1271m.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
            if (!m1833d(currX)) {
                this.f1271m.abortAnimation();
                scrollTo(0, currY);
            }
        }
        cb.m2417d(this);
    }

    void m1862d() {
        m1846a(this.f1267i);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || m1854a(keyEvent);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == ItemAnimator.FLAG_APPEARED_IN_PRE_LAYOUT) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                dv a = m1844a(childAt);
                if (a != null && a.f1357b == this.f1267i && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
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
        if (a == 0 || (a == 1 && this.f1266h != null && this.f1266h.m871b() > 1)) {
            int height;
            int width;
            if (!this.f1255Q.m3135a()) {
                a = canvas.save();
                height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((float) ((-height) + getPaddingTop()), this.f1277s * ((float) width));
                this.f1255Q.m3134a(height, width);
                i = 0 | this.f1255Q.m3139a(canvas);
                canvas.restoreToCount(a);
            }
            if (!this.f1256R.m3135a()) {
                a = canvas.save();
                height = getWidth();
                width = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate((float) (-getPaddingTop()), (-(this.f1278t + 1.0f)) * ((float) height));
                this.f1256R.m3134a(width, height);
                i |= this.f1256R.m3139a(canvas);
                canvas.restoreToCount(a);
            }
        } else {
            this.f1255Q.m3140b();
            this.f1256R.m3140b();
        }
        if (i != 0) {
            cb.m2417d(this);
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f1274p;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    boolean m1863e() {
        if (this.f1267i <= 0) {
            return false;
        }
        m1849a(this.f1267i - 1, true);
        return true;
    }

    boolean m1864f() {
        if (this.f1266h == null || this.f1267i >= this.f1266h.m871b() - 1) {
            return false;
        }
        m1849a(this.f1267i + 1, true);
        return true;
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new dw();
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new dw(getContext(), attributeSet);
    }

    protected LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public bt getAdapter() {
        return this.f1266h;
    }

    protected int getChildDrawingOrder(int i, int i2) {
        if (this.af == 2) {
            i2 = (i - 1) - i2;
        }
        return ((dw) ((View) this.ag.get(i2)).getLayoutParams()).f1366f;
    }

    public int getCurrentItem() {
        return this.f1267i;
    }

    public int getOffscreenPageLimit() {
        return this.f1284z;
    }

    public int getPageMargin() {
        return this.f1273o;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f1257S = true;
    }

    protected void onDetachedFromWindow() {
        removeCallbacks(this.ai);
        super.onDetachedFromWindow();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f1273o > 0 && this.f1274p != null && this.f1263e.size() > 0 && this.f1266h != null) {
            int scrollX = getScrollX();
            int width = getWidth();
            float f = ((float) this.f1273o) / ((float) width);
            dv dvVar = (dv) this.f1263e.get(0);
            float f2 = dvVar.f1360e;
            int size = this.f1263e.size();
            int i = dvVar.f1357b;
            int i2 = ((dv) this.f1263e.get(size - 1)).f1357b;
            int i3 = 0;
            int i4 = i;
            while (i4 < i2) {
                float f3;
                while (i4 > dvVar.f1357b && i3 < size) {
                    i3++;
                    dvVar = (dv) this.f1263e.get(i3);
                }
                if (i4 == dvVar.f1357b) {
                    f3 = (dvVar.f1360e + dvVar.f1359d) * ((float) width);
                    f2 = (dvVar.f1360e + dvVar.f1359d) + f;
                } else {
                    float d = this.f1266h.m879d(i4);
                    f3 = (f2 + d) * ((float) width);
                    f2 += d + f;
                }
                if (((float) this.f1273o) + f3 > ((float) scrollX)) {
                    this.f1274p.setBounds((int) f3, this.f1275q, (int) ((((float) this.f1273o) + f3) + 0.5f), this.f1276r);
                    this.f1274p.draw(canvas);
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
            m1839j();
            return false;
        }
        if (action != 0) {
            if (this.f1239A) {
                return true;
            }
            if (this.f1240B) {
                return false;
            }
        }
        switch (action) {
            case VideoSize.QCIF /*0*/:
                float x = motionEvent.getX();
                this.f1246H = x;
                this.f1244F = x;
                x = motionEvent.getY();
                this.f1247I = x;
                this.f1245G = x;
                this.f1248J = bf.m2312b(motionEvent, 0);
                this.f1240B = false;
                this.f1271m.computeScrollOffset();
                if (this.aj == 2 && Math.abs(this.f1271m.getFinalX() - this.f1271m.getCurrX()) > this.f1253O) {
                    this.f1271m.abortAnimation();
                    this.f1283y = false;
                    m1862d();
                    this.f1239A = true;
                    m1832c(true);
                    setScrollState(1);
                    break;
                }
                m1826a(false);
                this.f1239A = false;
                break;
            case VideoSize.HVGA /*2*/:
                action = this.f1248J;
                if (action != -1) {
                    action = bf.m2310a(motionEvent, action);
                    float c = bf.m2313c(motionEvent, action);
                    float f = c - this.f1244F;
                    float abs = Math.abs(f);
                    float d = bf.m2315d(motionEvent, action);
                    float abs2 = Math.abs(d - this.f1247I);
                    if (f == 0.0f || m1827a(this.f1244F, f) || !m1855a(this, false, (int) f, (int) c, (int) d)) {
                        if (abs > ((float) this.f1243E) && 0.5f * abs > abs2) {
                            this.f1239A = true;
                            m1832c(true);
                            setScrollState(1);
                            this.f1244F = f > 0.0f ? this.f1246H + ((float) this.f1243E) : this.f1246H - ((float) this.f1243E);
                            this.f1245G = d;
                            setScrollingCacheEnabled(true);
                        } else if (abs2 > ((float) this.f1243E)) {
                            this.f1240B = true;
                        }
                        if (this.f1239A && m1831b(c)) {
                            cb.m2417d(this);
                            break;
                        }
                    }
                    this.f1244F = c;
                    this.f1245G = d;
                    this.f1240B = true;
                    return false;
                }
                break;
            case Version.API06_ECLAIR_201 /*6*/:
                m1825a(motionEvent);
                break;
        }
        if (this.f1249K == null) {
            this.f1249K = VelocityTracker.obtain();
        }
        this.f1249K.addMovement(motionEvent);
        return this.f1239A;
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
        int scrollX = getScrollX();
        int i7 = 0;
        int i8 = 0;
        while (i8 < childCount) {
            dw dwVar;
            int measuredWidth;
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                dwVar = (dw) childAt.getLayoutParams();
                if (dwVar.f1361a) {
                    int i9 = dwVar.f1362b & 112;
                    switch (dwVar.f1362b & 7) {
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
                dwVar = (dw) childAt2.getLayoutParams();
                if (!dwVar.f1361a) {
                    dv a = m1844a(childAt2);
                    if (a != null) {
                        i5 = ((int) (a.f1360e * ((float) max))) + paddingLeft;
                        if (dwVar.f1364d) {
                            dwVar.f1364d = false;
                            childAt2.measure(MeasureSpec.makeMeasureSpec((int) (dwVar.f1363c * ((float) max)), 1073741824), MeasureSpec.makeMeasureSpec((i6 - paddingTop) - paddingBottom, 1073741824));
                        }
                        childAt2.layout(i5, paddingTop, childAt2.getMeasuredWidth() + i5, childAt2.getMeasuredHeight() + paddingTop);
                    }
                }
            }
        }
        this.f1275q = paddingTop;
        this.f1276r = i6 - paddingBottom;
        this.f1260V = i7;
        if (this.f1257S) {
            m1822a(this.f1267i, false, 0, false);
        }
        this.f1257S = false;
    }

    protected void onMeasure(int i, int i2) {
        dw dwVar;
        int i3;
        int i4;
        setMeasuredDimension(getDefaultSize(0, i), getDefaultSize(0, i2));
        int measuredWidth = getMeasuredWidth();
        this.f1242D = Math.min(measuredWidth / 10, this.f1241C);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                dwVar = (dw) childAt.getLayoutParams();
                if (dwVar != null && dwVar.f1361a) {
                    int i6 = dwVar.f1362b & 7;
                    int i7 = dwVar.f1362b & 112;
                    i3 = RtlSpacingHelper.UNDEFINED;
                    i4 = RtlSpacingHelper.UNDEFINED;
                    Object obj = (i7 == 48 || i7 == 80) ? 1 : null;
                    Object obj2 = (i6 == 3 || i6 == 5) ? 1 : null;
                    if (obj != null) {
                        i3 = 1073741824;
                    } else if (obj2 != null) {
                        i4 = 1073741824;
                    }
                    if (dwVar.width != -2) {
                        i7 = 1073741824;
                        i3 = dwVar.width != -1 ? dwVar.width : paddingLeft;
                    } else {
                        i7 = i3;
                        i3 = paddingLeft;
                    }
                    if (dwVar.height != -2) {
                        i4 = 1073741824;
                        if (dwVar.height != -1) {
                            measuredWidth = dwVar.height;
                            childAt.measure(MeasureSpec.makeMeasureSpec(i3, i7), MeasureSpec.makeMeasureSpec(measuredWidth, i4));
                            if (obj != null) {
                                measuredHeight -= childAt.getMeasuredHeight();
                            } else if (obj2 != null) {
                                paddingLeft -= childAt.getMeasuredWidth();
                            }
                        }
                    }
                    measuredWidth = measuredHeight;
                    childAt.measure(MeasureSpec.makeMeasureSpec(i3, i7), MeasureSpec.makeMeasureSpec(measuredWidth, i4));
                    if (obj != null) {
                        measuredHeight -= childAt.getMeasuredHeight();
                    } else if (obj2 != null) {
                        paddingLeft -= childAt.getMeasuredWidth();
                    }
                }
            }
        }
        this.f1279u = MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        this.f1280v = MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.f1281w = true;
        m1862d();
        this.f1281w = false;
        i3 = getChildCount();
        for (i4 = 0; i4 < i3; i4++) {
            View childAt2 = getChildAt(i4);
            if (childAt2.getVisibility() != 8) {
                dwVar = (dw) childAt2.getLayoutParams();
                if (dwVar == null || !dwVar.f1361a) {
                    childAt2.measure(MeasureSpec.makeMeasureSpec((int) (dwVar.f1363c * ((float) paddingLeft)), 1073741824), this.f1280v);
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
                dv a = m1844a(childAt);
                if (a != null && a.f1357b == this.f1267i && childAt.requestFocus(i, rect)) {
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
            if (this.f1266h != null) {
                this.f1266h.m865a(savedState.f1234b, savedState.f1235c);
                m1850a(savedState.f1233a, false, true);
                return;
            }
            this.f1268j = savedState.f1233a;
            this.f1269k = savedState.f1234b;
            this.f1270l = savedState.f1235c;
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f1233a = this.f1267i;
        if (this.f1266h != null) {
            savedState.f1234b = this.f1266h.m861a();
        }
        return savedState;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            m1821a(i, i3, this.f1273o, this.f1273o);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.f1254P) {
            return true;
        }
        if (motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) {
            return false;
        }
        if (this.f1266h == null || this.f1266h.m871b() == 0) {
            return false;
        }
        if (this.f1249K == null) {
            this.f1249K = VelocityTracker.obtain();
        }
        this.f1249K.addMovement(motionEvent);
        float x;
        int a;
        switch (motionEvent.getAction() & 255) {
            case VideoSize.QCIF /*0*/:
                this.f1271m.abortAnimation();
                this.f1283y = false;
                m1862d();
                x = motionEvent.getX();
                this.f1246H = x;
                this.f1244F = x;
                x = motionEvent.getY();
                this.f1247I = x;
                this.f1245G = x;
                this.f1248J = bf.m2312b(motionEvent, 0);
                break;
            case VideoSize.CIF /*1*/:
                if (this.f1239A) {
                    VelocityTracker velocityTracker = this.f1249K;
                    velocityTracker.computeCurrentVelocity(1000, (float) this.f1251M);
                    a = (int) bw.m2358a(velocityTracker, this.f1248J);
                    this.f1283y = true;
                    int clientWidth = getClientWidth();
                    int scrollX = getScrollX();
                    dv k = m1840k();
                    m1851a(m1818a(k.f1357b, ((((float) scrollX) / ((float) clientWidth)) - k.f1360e) / k.f1359d, a, (int) (bf.m2313c(motionEvent, bf.m2310a(motionEvent, this.f1248J)) - this.f1246H)), true, true, a);
                    z = m1839j();
                    break;
                }
                break;
            case VideoSize.HVGA /*2*/:
                if (!this.f1239A) {
                    a = bf.m2310a(motionEvent, this.f1248J);
                    if (a == -1) {
                        z = m1839j();
                        break;
                    }
                    float c = bf.m2313c(motionEvent, a);
                    float abs = Math.abs(c - this.f1244F);
                    float d = bf.m2315d(motionEvent, a);
                    x = Math.abs(d - this.f1245G);
                    if (abs > ((float) this.f1243E) && abs > x) {
                        this.f1239A = true;
                        m1832c(true);
                        this.f1244F = c - this.f1246H > 0.0f ? this.f1246H + ((float) this.f1243E) : this.f1246H - ((float) this.f1243E);
                        this.f1245G = d;
                        setScrollState(1);
                        setScrollingCacheEnabled(true);
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                }
                if (this.f1239A) {
                    z = false | m1831b(bf.m2313c(motionEvent, bf.m2310a(motionEvent, this.f1248J)));
                    break;
                }
                break;
            case Version.API03_CUPCAKE_15 /*3*/:
                if (this.f1239A) {
                    m1822a(this.f1267i, true, 0, false);
                    z = m1839j();
                    break;
                }
                break;
            case Version.API05_ECLAIR_20 /*5*/:
                a = bf.m2311b(motionEvent);
                this.f1244F = bf.m2313c(motionEvent, a);
                this.f1248J = bf.m2312b(motionEvent, a);
                break;
            case Version.API06_ECLAIR_201 /*6*/:
                m1825a(motionEvent);
                this.f1244F = bf.m2313c(motionEvent, bf.m2310a(motionEvent, this.f1248J));
                break;
        }
        if (z) {
            cb.m2417d(this);
        }
        return true;
    }

    public void removeView(View view) {
        if (this.f1281w) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public void setAdapter(bt btVar) {
        if (this.f1266h != null) {
            this.f1266h.m872b(this.f1272n);
            this.f1266h.m868a((ViewGroup) this);
            for (int i = 0; i < this.f1263e.size(); i++) {
                dv dvVar = (dv) this.f1263e.get(i);
                this.f1266h.m869a((ViewGroup) this, dvVar.f1357b, dvVar.f1356a);
            }
            this.f1266h.m875b((ViewGroup) this);
            this.f1263e.clear();
            m1837h();
            this.f1267i = 0;
            scrollTo(0, 0);
        }
        bt btVar2 = this.f1266h;
        this.f1266h = btVar;
        this.f1262b = 0;
        if (this.f1266h != null) {
            if (this.f1272n == null) {
                this.f1272n = new eb();
            }
            this.f1266h.m864a(this.f1272n);
            this.f1283y = false;
            boolean z = this.f1257S;
            this.f1257S = true;
            this.f1262b = this.f1266h.m871b();
            if (this.f1268j >= 0) {
                this.f1266h.m865a(this.f1269k, this.f1270l);
                m1850a(this.f1268j, false, true);
                this.f1268j = -1;
                this.f1269k = null;
                this.f1270l = null;
            } else if (z) {
                requestLayout();
            } else {
                m1862d();
            }
        }
        if (this.ac != null && btVar2 != btVar) {
            this.ac.m2748a(btVar2, btVar);
        }
    }

    void setChildrenDrawingOrderEnabledCompat(boolean z) {
        if (VERSION.SDK_INT >= 7) {
            if (this.ae == null) {
                try {
                    this.ae = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[]{Boolean.TYPE});
                } catch (Throwable e) {
                    Log.e("ViewPager", "Can't find setChildrenDrawingOrderEnabled", e);
                }
            }
            try {
                this.ae.invoke(this, new Object[]{Boolean.valueOf(z)});
            } catch (Throwable e2) {
                Log.e("ViewPager", "Error changing children drawing order", e2);
            }
        }
    }

    public void setCurrentItem(int i) {
        this.f1283y = false;
        m1850a(i, !this.f1257S, false);
    }

    public void setOffscreenPageLimit(int i) {
        if (i < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + i + " too small; defaulting to " + 1);
            i = 1;
        }
        if (i != this.f1284z) {
            this.f1284z = i;
            m1862d();
        }
    }

    void setOnAdapterChangeListener(dy dyVar) {
        this.ac = dyVar;
    }

    @Deprecated
    public void setOnPageChangeListener(dz dzVar) {
        this.aa = dzVar;
    }

    public void setPageMargin(int i) {
        int i2 = this.f1273o;
        this.f1273o = i;
        int width = getWidth();
        m1821a(width, width, i, i2);
        requestLayout();
    }

    public void setPageMarginDrawable(int i) {
        setPageMarginDrawable(getContext().getResources().getDrawable(i));
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.f1274p = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f1274p;
    }
}
