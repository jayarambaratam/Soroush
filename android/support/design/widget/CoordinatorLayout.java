package android.support.design.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.design.C0069j;
import android.support.design.C0070k;
import android.support.v4.os.C0269j;
import android.support.v4.p012b.C0125h;
import android.support.v4.view.C0327v;
import android.support.v4.view.bf;
import android.support.v4.view.bq;
import android.support.v4.view.br;
import android.support.v4.view.cb;
import android.support.v4.view.ff;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup.OnHierarchyChangeListener;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mobi.mmdt.ott.C1317h;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

public class CoordinatorLayout extends ViewGroup implements bq {
    static final String f317a;
    static final Class<?>[] f318b;
    static final ThreadLocal<Map<String, Constructor<C0071r>>> f319c;
    static final Comparator<View> f320e;
    static final C0099y f321f;
    final Comparator<View> f322d;
    private final List<View> f323g;
    private final List<View> f324h;
    private final List<View> f325i;
    private final Rect f326j;
    private final Rect f327k;
    private final Rect f328l;
    private final int[] f329m;
    private Paint f330n;
    private boolean f331o;
    private int[] f332p;
    private View f333q;
    private View f334r;
    private View f335s;
    private C0096v f336t;
    private boolean f337u;
    private ff f338v;
    private boolean f339w;
    private Drawable f340x;
    private OnHierarchyChangeListener f341y;
    private final br f342z;

    public class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR;
        SparseArray<Parcelable> f316a;

        static {
            CREATOR = C0269j.m1809a(new C0097w());
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            int readInt = parcel.readInt();
            int[] iArr = new int[readInt];
            parcel.readIntArray(iArr);
            Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
            this.f316a = new SparseArray(readInt);
            for (int i = 0; i < readInt; i++) {
                this.f316a.append(iArr[i], readParcelableArray[i]);
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            int i2 = 0;
            super.writeToParcel(parcel, i);
            int size = this.f316a != null ? this.f316a.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            while (i2 < size) {
                iArr[i2] = this.f316a.keyAt(i2);
                parcelableArr[i2] = (Parcelable) this.f316a.valueAt(i2);
                i2++;
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i);
        }
    }

    static {
        Package packageR = CoordinatorLayout.class.getPackage();
        f317a = packageR != null ? packageR.getName() : null;
        if (VERSION.SDK_INT >= 21) {
            f320e = new C0098x();
            f321f = new C0100z();
        } else {
            f320e = null;
            f321f = null;
        }
        f318b = new Class[]{Context.class, AttributeSet.class};
        f319c = new ThreadLocal();
    }

    public CoordinatorLayout(Context context) {
        this(context, null);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet, int i) {
        int i2 = 0;
        super(context, attributeSet, i);
        this.f322d = new C0091p(this);
        this.f323g = new ArrayList();
        this.f324h = new ArrayList();
        this.f325i = new ArrayList();
        this.f326j = new Rect();
        this.f327k = new Rect();
        this.f328l = new Rect();
        this.f329m = new int[2];
        this.f342z = new br(this);
        cm.m677a(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0070k.CoordinatorLayout, i, C0069j.Widget_Design_CoordinatorLayout);
        int resourceId = obtainStyledAttributes.getResourceId(C0070k.CoordinatorLayout_keylines, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.f332p = resources.getIntArray(resourceId);
            float f = resources.getDisplayMetrics().density;
            int length = this.f332p.length;
            while (i2 < length) {
                int[] iArr = this.f332p;
                iArr[i2] = (int) (((float) iArr[i2]) * f);
                i2++;
            }
        }
        this.f340x = obtainStyledAttributes.getDrawable(C0070k.CoordinatorLayout_statusBarBackground);
        obtainStyledAttributes.recycle();
        if (f321f != null) {
            f321f.m847a(this, new C0092q(this));
        }
        super.setOnHierarchyChangeListener(new C0094t(this));
    }

    private int m313a(int i) {
        if (this.f332p == null) {
            Log.e("CoordinatorLayout", "No keylines defined for " + this + " - attempted index lookup " + i);
            return 0;
        } else if (i >= 0 && i < this.f332p.length) {
            return this.f332p[i];
        } else {
            Log.e("CoordinatorLayout", "Keyline index " + i + " out of range for " + this);
            return 0;
        }
    }

    static C0071r m314a(Context context, AttributeSet attributeSet, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(".")) {
            str = context.getPackageName() + str;
        } else if (str.indexOf(46) < 0 && !TextUtils.isEmpty(f317a)) {
            str = f317a + '.' + str;
        }
        try {
            Map map;
            Map map2 = (Map) f319c.get();
            if (map2 == null) {
                HashMap hashMap = new HashMap();
                f319c.set(hashMap);
                map = hashMap;
            } else {
                map = map2;
            }
            Constructor constructor = (Constructor) map.get(str);
            if (constructor == null) {
                constructor = Class.forName(str, true, context.getClassLoader()).getConstructor(f318b);
                constructor.setAccessible(true);
                map.put(str, constructor);
            }
            return (C0071r) constructor.newInstance(new Object[]{context, attributeSet});
        } catch (Throwable e) {
            throw new RuntimeException("Could not inflate Behavior subclass " + str, e);
        }
    }

    private void m317a(ff ffVar) {
        if (!ffVar.m2902e()) {
            int childCount = getChildCount();
            ff ffVar2 = ffVar;
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (cb.m2447x(childAt)) {
                    ff a;
                    C0071r b = ((C0095u) childAt.getLayoutParams()).m831b();
                    if (b != null) {
                        a = b.m199a(this, childAt, ffVar2);
                        if (a.m2902e()) {
                            return;
                        }
                    }
                    a = ffVar2;
                    ffVar2 = cb.m2407b(childAt, a);
                    if (ffVar2.m2902e()) {
                        return;
                    }
                }
            }
        }
    }

    private void m318a(View view, View view2, int i) {
        C0095u c0095u = (C0095u) view.getLayoutParams();
        Rect rect = this.f326j;
        Rect rect2 = this.f327k;
        m336a(view2, rect);
        m335a(view, i, rect, rect2);
        view.layout(rect2.left, rect2.top, rect2.right, rect2.bottom);
    }

    private void m319a(List<View> list) {
        list.clear();
        boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        int i = childCount - 1;
        while (i >= 0) {
            list.add(getChildAt(isChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i) : i));
            i--;
        }
        if (f320e != null) {
            Collections.sort(list, f320e);
        }
    }

    private static void m320a(List<View> list, Comparator<View> comparator) {
        if (list != null && list.size() >= 2) {
            int i;
            View[] viewArr = new View[list.size()];
            list.toArray(viewArr);
            for (int i2 = 0; i2 < r5; i2++) {
                i = i2;
                for (int i3 = i2 + 1; i3 < r5; i3++) {
                    if (comparator.compare(viewArr[i3], viewArr[i]) < 0) {
                        i = i3;
                    }
                }
                if (i2 != i) {
                    View view = viewArr[i];
                    viewArr[i] = viewArr[i2];
                    viewArr[i2] = view;
                }
            }
            list.clear();
            for (Object add : viewArr) {
                list.add(add);
            }
        }
    }

    private boolean m321a(MotionEvent motionEvent, int i) {
        boolean z;
        boolean z2 = false;
        Object obj = null;
        MotionEvent motionEvent2 = null;
        int a = bf.m2309a(motionEvent);
        List list = this.f324h;
        m319a(list);
        int size = list.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj2;
            MotionEvent motionEvent3;
            View view = (View) list.get(i2);
            C0095u c0095u = (C0095u) view.getLayoutParams();
            C0071r b = c0095u.m831b();
            if ((!z2 && obj == null) || a == 0) {
                if (!(z2 || b == null)) {
                    switch (i) {
                        case VideoSize.QCIF /*0*/:
                            z2 = b.m206a(this, view, motionEvent);
                            break;
                        case VideoSize.CIF /*1*/:
                            z2 = b.m212b(this, view, motionEvent);
                            break;
                    }
                    if (z2) {
                        this.f333q = view;
                    }
                }
                z = z2;
                boolean e = c0095u.m836e();
                boolean a2 = c0095u.m829a(this, view);
                Object obj3 = (!a2 || e) ? null : 1;
                if (a2 && obj3 == null) {
                    list.clear();
                    return z;
                }
                MotionEvent motionEvent4 = motionEvent2;
                obj2 = obj3;
                motionEvent3 = motionEvent4;
            } else if (b != null) {
                if (motionEvent2 == null) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    motionEvent3 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                } else {
                    motionEvent3 = motionEvent2;
                }
                switch (i) {
                    case VideoSize.QCIF /*0*/:
                        b.m206a(this, view, motionEvent3);
                        break;
                    case VideoSize.CIF /*1*/:
                        b.m212b(this, view, motionEvent3);
                        break;
                }
                obj2 = obj;
                z = z2;
            } else {
                motionEvent3 = motionEvent2;
                z = z2;
                obj2 = obj;
            }
            i2++;
            obj = obj2;
            z2 = z;
            motionEvent2 = motionEvent3;
        }
        z = z2;
        list.clear();
        return z;
    }

    private static int m322b(int i) {
        return i == 0 ? 8388659 : i;
    }

    private void m323b(View view, int i, int i2) {
        C0095u c0095u = (C0095u) view.getLayoutParams();
        int a = C0327v.m2941a(m324c(c0095u.f668c), i2);
        int i3 = a & 7;
        int i4 = a & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (i2 == 1) {
            i = width - i;
        }
        int a2 = m313a(i) - measuredWidth;
        a = 0;
        switch (i3) {
            case VideoSize.CIF /*1*/:
                a2 += measuredWidth / 2;
                break;
            case Version.API05_ECLAIR_20 /*5*/:
                a2 += measuredWidth;
                break;
        }
        switch (i4) {
            case Version.API16_JELLY_BEAN_41 /*16*/:
                a = 0 + (measuredHeight / 2);
                break;
            case C1317h.Theme_panelMenuListTheme /*80*/:
                a = 0 + measuredHeight;
                break;
        }
        a2 = Math.max(getPaddingLeft() + c0095u.leftMargin, Math.min(a2, ((width - getPaddingRight()) - measuredWidth) - c0095u.rightMargin));
        int max = Math.max(getPaddingTop() + c0095u.topMargin, Math.min(a, ((height - getPaddingBottom()) - measuredHeight) - c0095u.bottomMargin));
        view.layout(a2, max, a2 + measuredWidth, max + measuredHeight);
    }

    private static int m324c(int i) {
        return i == 0 ? 8388661 : i;
    }

    private void m325c(View view, int i) {
        C0095u c0095u = (C0095u) view.getLayoutParams();
        Rect rect = this.f326j;
        rect.set(getPaddingLeft() + c0095u.leftMargin, getPaddingTop() + c0095u.topMargin, (getWidth() - getPaddingRight()) - c0095u.rightMargin, (getHeight() - getPaddingBottom()) - c0095u.bottomMargin);
        if (!(this.f338v == null || !cb.m2447x(this) || cb.m2447x(view))) {
            rect.left += this.f338v.m2897a();
            rect.top += this.f338v.m2899b();
            rect.right -= this.f338v.m2900c();
            rect.bottom -= this.f338v.m2901d();
        }
        Rect rect2 = this.f327k;
        C0327v.m2942a(m322b(c0095u.f668c), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i);
        view.layout(rect2.left, rect2.top, rect2.right, rect2.bottom);
    }

    private static int m326d(int i) {
        return i == 0 ? 17 : i;
    }

    private void m327e() {
        int i = 0;
        if (this.f333q != null) {
            C0071r b = ((C0095u) this.f333q.getLayoutParams()).m831b();
            if (b != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                b.m212b(this, this.f333q, obtain);
                obtain.recycle();
            }
            this.f333q = null;
        }
        int childCount = getChildCount();
        while (i < childCount) {
            ((C0095u) getChildAt(i).getLayoutParams()).m837f();
            i++;
        }
    }

    private void m328f() {
        this.f323g.clear();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            m330a(childAt).m832b(this, childAt);
            this.f323g.add(childAt);
        }
        m320a(this.f323g, this.f322d);
    }

    private void setWindowInsets(ff ffVar) {
        boolean z = true;
        if (this.f338v != ffVar) {
            this.f338v = ffVar;
            boolean z2 = ffVar != null && ffVar.m2899b() > 0;
            this.f339w = z2;
            if (this.f339w || getBackground() != null) {
                z = false;
            }
            setWillNotDraw(z);
            m317a(ffVar);
            requestLayout();
        }
    }

    public C0095u m329a(AttributeSet attributeSet) {
        return new C0095u(getContext(), attributeSet);
    }

    C0095u m330a(View view) {
        C0095u c0095u = (C0095u) view.getLayoutParams();
        if (!c0095u.f667b) {
            C0093s c0093s = null;
            for (Class cls = view.getClass(); cls != null; cls = cls.getSuperclass()) {
                c0093s = (C0093s) cls.getAnnotation(C0093s.class);
                if (c0093s != null) {
                    break;
                }
            }
            C0093s c0093s2 = c0093s;
            if (c0093s2 != null) {
                try {
                    c0095u.m827a((C0071r) c0093s2.m822a().newInstance());
                } catch (Throwable e) {
                    Log.e("CoordinatorLayout", "Default behavior class " + c0093s2.m822a().getName() + " could not be instantiated. Did you forget a default constructor?", e);
                }
            }
            c0095u.f667b = true;
        }
        return c0095u;
    }

    protected C0095u m331a(LayoutParams layoutParams) {
        return layoutParams instanceof C0095u ? new C0095u((C0095u) layoutParams) : layoutParams instanceof MarginLayoutParams ? new C0095u((MarginLayoutParams) layoutParams) : new C0095u(layoutParams);
    }

    void m332a() {
        boolean z = false;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (m350e(getChildAt(i))) {
                z = true;
                break;
            }
        }
        if (z == this.f337u) {
            return;
        }
        if (z) {
            m341b();
        } else {
            m345c();
        }
    }

    public void m333a(View view, int i) {
        C0095u c0095u = (C0095u) view.getLayoutParams();
        if (c0095u.m835d()) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        } else if (c0095u.f672g != null) {
            m318a(view, c0095u.f672g, i);
        } else if (c0095u.f670e >= 0) {
            m323b(view, c0095u.f670e, i);
        } else {
            m325c(view, i);
        }
    }

    public void m334a(View view, int i, int i2, int i3, int i4) {
        measureChildWithMargins(view, i, i2, i3, i4);
    }

    void m335a(View view, int i, Rect rect, Rect rect2) {
        C0095u c0095u = (C0095u) view.getLayoutParams();
        int a = C0327v.m2941a(m326d(c0095u.f668c), i);
        int a2 = C0327v.m2941a(m322b(c0095u.f669d), i);
        int i2 = a & 7;
        int i3 = a & 112;
        a = a2 & 7;
        int i4 = a2 & 112;
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        switch (a) {
            case VideoSize.CIF /*1*/:
                a2 = (rect.width() / 2) + rect.left;
                break;
            case Version.API05_ECLAIR_20 /*5*/:
                a2 = rect.right;
                break;
            default:
                a2 = rect.left;
                break;
        }
        switch (i4) {
            case Version.API16_JELLY_BEAN_41 /*16*/:
                a = rect.top + (rect.height() / 2);
                break;
            case C1317h.Theme_panelMenuListTheme /*80*/:
                a = rect.bottom;
                break;
            default:
                a = rect.top;
                break;
        }
        switch (i2) {
            case VideoSize.CIF /*1*/:
                a2 -= measuredWidth / 2;
                break;
            case Version.API05_ECLAIR_20 /*5*/:
                break;
            default:
                a2 -= measuredWidth;
                break;
        }
        switch (i3) {
            case Version.API16_JELLY_BEAN_41 /*16*/:
                a -= measuredHeight / 2;
                break;
            case C1317h.Theme_panelMenuListTheme /*80*/:
                break;
            default:
                a -= measuredHeight;
                break;
        }
        i2 = getWidth();
        i3 = getHeight();
        a2 = Math.max(getPaddingLeft() + c0095u.leftMargin, Math.min(a2, ((i2 - getPaddingRight()) - measuredWidth) - c0095u.rightMargin));
        int max = Math.max(getPaddingTop() + c0095u.topMargin, Math.min(a, ((i3 - getPaddingBottom()) - measuredHeight) - c0095u.bottomMargin));
        rect2.set(a2, max, a2 + measuredWidth, max + measuredHeight);
    }

    void m336a(View view, Rect rect) {
        dc.m743b(this, view, rect);
    }

    void m337a(View view, boolean z, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.set(0, 0, 0, 0);
        } else if (z) {
            m336a(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    void m338a(boolean z) {
        int h = cb.m2428h(this);
        int size = this.f323g.size();
        for (int i = 0; i < size; i++) {
            int i2;
            View view = (View) this.f323g.get(i);
            C0095u c0095u = (C0095u) view.getLayoutParams();
            for (i2 = 0; i2 < i; i2++) {
                if (c0095u.f673h == ((View) this.f323g.get(i2))) {
                    m343b(view, h);
                }
            }
            Rect rect = this.f326j;
            Rect rect2 = this.f327k;
            m347c(view, rect);
            m337a(view, true, rect2);
            if (!rect.equals(rect2)) {
                m344b(view, rect2);
                for (i2 = i + 1; i2 < size; i2++) {
                    View view2 = (View) this.f323g.get(i2);
                    C0095u c0095u2 = (C0095u) view2.getLayoutParams();
                    C0071r b = c0095u2.m831b();
                    if (b != null && b.m213b(this, view2, view)) {
                        if (z || !c0095u2.m840i()) {
                            boolean c = b.m215c(this, view2, view);
                            if (z) {
                                c0095u2.m833b(c);
                            }
                        } else {
                            c0095u2.m841j();
                        }
                    }
                }
            }
        }
    }

    public boolean m339a(View view, int i, int i2) {
        Rect rect = this.f326j;
        m336a(view, rect);
        return rect.contains(i, i2);
    }

    public boolean m340a(View view, View view2) {
        if (view.getVisibility() != 0 || view2.getVisibility() != 0) {
            return false;
        }
        Rect rect = this.f326j;
        m337a(view, view.getParent() != this, rect);
        Rect rect2 = this.f327k;
        m337a(view2, view2.getParent() != this, rect2);
        return rect.left <= rect2.right && rect.top <= rect2.bottom && rect.right >= rect2.left && rect.bottom >= rect2.top;
    }

    void m341b() {
        if (this.f331o) {
            if (this.f336t == null) {
                this.f336t = new C0096v(this);
            }
            getViewTreeObserver().addOnPreDrawListener(this.f336t);
        }
        this.f337u = true;
    }

    void m342b(View view) {
        int size = this.f323g.size();
        int i = 0;
        Object obj = null;
        while (i < size) {
            Object obj2;
            View view2 = (View) this.f323g.get(i);
            if (view2 == view) {
                obj2 = 1;
            } else {
                if (obj != null) {
                    C0095u c0095u = (C0095u) view2.getLayoutParams();
                    C0071r b = c0095u.m831b();
                    if (b != null && c0095u.m830a(this, view2, view)) {
                        b.m216d(this, view2, view);
                    }
                }
                obj2 = obj;
            }
            i++;
            obj = obj2;
        }
    }

    void m343b(View view, int i) {
        C0095u c0095u = (C0095u) view.getLayoutParams();
        if (c0095u.f672g != null) {
            Rect rect = this.f326j;
            Rect rect2 = this.f327k;
            Rect rect3 = this.f328l;
            m336a(c0095u.f672g, rect);
            m337a(view, false, rect2);
            m335a(view, i, rect, rect3);
            int i2 = rect3.left - rect2.left;
            int i3 = rect3.top - rect2.top;
            if (i2 != 0) {
                view.offsetLeftAndRight(i2);
            }
            if (i3 != 0) {
                view.offsetTopAndBottom(i3);
            }
            if (i2 != 0 || i3 != 0) {
                C0071r b = c0095u.m831b();
                if (b != null) {
                    b.m215c(this, view, c0095u.f672g);
                }
            }
        }
    }

    void m344b(View view, Rect rect) {
        ((C0095u) view.getLayoutParams()).m826a(rect);
    }

    void m345c() {
        if (this.f331o && this.f336t != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f336t);
        }
        this.f337u = false;
    }

    public void m346c(View view) {
        int size = this.f323g.size();
        int i = 0;
        Object obj = null;
        while (i < size) {
            Object obj2;
            View view2 = (View) this.f323g.get(i);
            if (view2 == view) {
                obj2 = 1;
            } else {
                if (obj != null) {
                    C0095u c0095u = (C0095u) view2.getLayoutParams();
                    C0071r b = c0095u.m831b();
                    if (b != null && c0095u.m830a(this, view2, view)) {
                        b.m215c(this, view2, view);
                    }
                }
                obj2 = obj;
            }
            i++;
            obj = obj2;
        }
    }

    void m347c(View view, Rect rect) {
        rect.set(((C0095u) view.getLayoutParams()).m834c());
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return (layoutParams instanceof C0095u) && super.checkLayoutParams(layoutParams);
    }

    protected C0095u m348d() {
        return new C0095u(-2, -2);
    }

    public List<View> m349d(View view) {
        C0095u c0095u = (C0095u) view.getLayoutParams();
        List<View> list = this.f325i;
        list.clear();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt != view && c0095u.m830a(this, view, childAt)) {
                list.add(childAt);
            }
        }
        return list;
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        C0095u c0095u = (C0095u) view.getLayoutParams();
        if (c0095u.f666a != null && c0095u.f666a.m214c(this, view) > 0.0f) {
            if (this.f330n == null) {
                this.f330n = new Paint();
            }
            this.f330n.setColor(c0095u.f666a.m210b(this, view));
            canvas.drawRect((float) getPaddingLeft(), (float) getPaddingTop(), (float) (getWidth() - getPaddingRight()), (float) (getHeight() - getPaddingBottom()), this.f330n);
        }
        return super.drawChild(canvas, view, j);
    }

    boolean m350e(View view) {
        C0095u c0095u = (C0095u) view.getLayoutParams();
        if (c0095u.f672g != null) {
            return true;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt != view && c0095u.m830a(this, view, childAt)) {
                return true;
            }
        }
        return false;
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return m348d();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m329a(attributeSet);
    }

    protected /* synthetic */ LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return m331a(layoutParams);
    }

    public int getNestedScrollAxes() {
        return this.f342z.m2355a();
    }

    public Drawable getStatusBarBackground() {
        return this.f340x;
    }

    protected int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    protected int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m327e();
        if (this.f337u) {
            if (this.f336t == null) {
                this.f336t = new C0096v(this);
            }
            getViewTreeObserver().addOnPreDrawListener(this.f336t);
        }
        if (this.f338v == null && cb.m2447x(this)) {
            cb.m2446w(this);
        }
        this.f331o = true;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m327e();
        if (this.f337u && this.f336t != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f336t);
        }
        if (this.f335s != null) {
            onStopNestedScroll(this.f335s);
        }
        this.f331o = false;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f339w && this.f340x != null) {
            int b = this.f338v != null ? this.f338v.m2899b() : 0;
            if (b > 0) {
                this.f340x.setBounds(0, 0, getWidth(), b);
                this.f340x.draw(canvas);
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = null;
        int a = bf.m2309a(motionEvent);
        if (a == 0) {
            m327e();
        }
        boolean a2 = m321a(motionEvent, 0);
        if (motionEvent2 != null) {
            motionEvent2.recycle();
        }
        if (a == 1 || a == 3) {
            m327e();
        }
        return a2;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int h = cb.m2428h(this);
        int size = this.f323g.size();
        for (int i5 = 0; i5 < size; i5++) {
            View view = (View) this.f323g.get(i5);
            C0071r b = ((C0095u) view.getLayoutParams()).m831b();
            if (b == null || !b.m204a(this, view, h)) {
                m333a(view, h);
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        m328f();
        m332a();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int h = cb.m2428h(this);
        Object obj = h == 1 ? 1 : null;
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size2 = MeasureSpec.getSize(i2);
        int i3 = paddingLeft + paddingRight;
        int i4 = paddingTop + paddingBottom;
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        paddingBottom = getSuggestedMinimumHeight();
        Object obj2 = (this.f338v == null || !cb.m2447x(this)) ? null : 1;
        int size3 = this.f323g.size();
        int i5 = 0;
        int i6 = 0;
        int i7 = paddingBottom;
        int i8 = suggestedMinimumWidth;
        while (i5 < size3) {
            int i9;
            View view = (View) this.f323g.get(i5);
            C0095u c0095u = (C0095u) view.getLayoutParams();
            int i10 = 0;
            if (c0095u.f670e >= 0 && mode != 0) {
                int a = m313a(c0095u.f670e);
                paddingTop = C0327v.m2941a(m324c(c0095u.f668c), h) & 7;
                if ((paddingTop == 3 && obj == null) || (paddingTop == 5 && obj != null)) {
                    i10 = Math.max(0, (size - paddingRight) - a);
                } else if ((paddingTop == 5 && obj == null) || (paddingTop == 3 && obj != null)) {
                    i10 = Math.max(0, a - paddingLeft);
                }
            }
            if (obj2 == null || cb.m2447x(view)) {
                i9 = i2;
                suggestedMinimumWidth = i;
            } else {
                paddingTop = this.f338v.m2899b() + this.f338v.m2901d();
                suggestedMinimumWidth = MeasureSpec.makeMeasureSpec(size - (this.f338v.m2897a() + this.f338v.m2900c()), mode);
                i9 = MeasureSpec.makeMeasureSpec(size2 - paddingTop, mode2);
            }
            C0071r b = c0095u.m831b();
            if (b == null || !b.m205a(this, view, suggestedMinimumWidth, i10, i9, 0)) {
                m334a(view, suggestedMinimumWidth, i10, i9, 0);
            }
            i10 = Math.max(i8, ((view.getMeasuredWidth() + i3) + c0095u.leftMargin) + c0095u.rightMargin);
            suggestedMinimumWidth = Math.max(i7, ((view.getMeasuredHeight() + i4) + c0095u.topMargin) + c0095u.bottomMargin);
            i5++;
            i6 = cb.m2389a(i6, cb.m2435l(view));
            i7 = suggestedMinimumWidth;
            i8 = i10;
        }
        setMeasuredDimension(cb.m2390a(i8, i, -16777216 & i6), cb.m2390a(i7, i2, i6 << 16));
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        int childCount = getChildCount();
        int i = 0;
        boolean z2 = false;
        while (i < childCount) {
            boolean a;
            View childAt = getChildAt(i);
            C0095u c0095u = (C0095u) childAt.getLayoutParams();
            if (c0095u.m839h()) {
                C0071r b = c0095u.m831b();
                a = b != null ? b.m208a(this, childAt, view, f, f2, z) | z2 : z2;
            } else {
                a = z2;
            }
            i++;
            z2 = a;
        }
        if (z2) {
            m338a(true);
        }
        return z2;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        int childCount = getChildCount();
        int i = 0;
        boolean z = false;
        while (i < childCount) {
            boolean a;
            View childAt = getChildAt(i);
            C0095u c0095u = (C0095u) childAt.getLayoutParams();
            if (c0095u.m839h()) {
                C0071r b = c0095u.m831b();
                a = b != null ? b.m207a(this, childAt, view, f, f2) | z : z;
            } else {
                a = z;
            }
            i++;
            z = a;
        }
        return z;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        int i3 = 0;
        int i4 = 0;
        Object obj = null;
        int childCount = getChildCount();
        int i5 = 0;
        while (i5 < childCount) {
            int max;
            int max2;
            Object obj2;
            View childAt = getChildAt(i5);
            C0095u c0095u = (C0095u) childAt.getLayoutParams();
            if (c0095u.m839h()) {
                C0071r b = c0095u.m831b();
                if (b != null) {
                    int[] iArr2 = this.f329m;
                    this.f329m[1] = 0;
                    iArr2[0] = 0;
                    b.m203a(this, childAt, view, i, i2, this.f329m);
                    max = i > 0 ? Math.max(i3, this.f329m[0]) : Math.min(i3, this.f329m[0]);
                    max2 = i2 > 0 ? Math.max(i4, this.f329m[1]) : Math.min(i4, this.f329m[1]);
                    int i6 = 1;
                } else {
                    obj2 = obj;
                    max = i3;
                    max2 = i4;
                }
            } else {
                obj2 = obj;
                max = i3;
                max2 = i4;
            }
            i5++;
            i4 = max2;
            i3 = max;
            obj = obj2;
        }
        iArr[0] = i3;
        iArr[1] = i4;
        if (obj != null) {
            m338a(true);
        }
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        Object obj = null;
        int i5 = 0;
        while (i5 < childCount) {
            Object obj2;
            View childAt = getChildAt(i5);
            C0095u c0095u = (C0095u) childAt.getLayoutParams();
            if (c0095u.m839h()) {
                C0071r b = c0095u.m831b();
                if (b != null) {
                    b.m202a(this, childAt, view, i, i2, i3, i4);
                    obj2 = 1;
                } else {
                    obj2 = obj;
                }
            } else {
                obj2 = obj;
            }
            i5++;
            obj = obj2;
        }
        if (obj != null) {
            m338a(true);
        }
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f342z.m2357a(view, view2, i);
        this.f334r = view;
        this.f335s = view2;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            C0095u c0095u = (C0095u) childAt.getLayoutParams();
            if (c0095u.m839h()) {
                C0071r b = c0095u.m831b();
                if (b != null) {
                    b.m211b(this, childAt, view, view2, i);
                }
            }
        }
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        SparseArray sparseArray = savedState.f316a;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            C0071r b = m330a(childAt).m831b();
            if (!(id == -1 || b == null)) {
                Parcelable parcelable2 = (Parcelable) sparseArray.get(id);
                if (parcelable2 != null) {
                    b.m200a(this, childAt, parcelable2);
                }
            }
        }
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        SparseArray sparseArray = new SparseArray();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            C0071r b = ((C0095u) childAt.getLayoutParams()).m831b();
            if (!(id == -1 || b == null)) {
                Parcelable a = b.m198a(this, childAt);
                if (a != null) {
                    sparseArray.append(id, a);
                }
            }
        }
        savedState.f316a = sparseArray;
        return savedState;
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        int childCount = getChildCount();
        int i2 = 0;
        boolean z = false;
        while (i2 < childCount) {
            boolean z2;
            View childAt = getChildAt(i2);
            C0095u c0095u = (C0095u) childAt.getLayoutParams();
            C0071r b = c0095u.m831b();
            if (b != null) {
                boolean a = b.m209a(this, childAt, view, view2, i);
                z2 = z | a;
                c0095u.m828a(a);
            } else {
                c0095u.m828a(false);
                z2 = z;
            }
            i2++;
            z = z2;
        }
        return z;
    }

    public void onStopNestedScroll(View view) {
        this.f342z.m2356a(view);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            C0095u c0095u = (C0095u) childAt.getLayoutParams();
            if (c0095u.m839h()) {
                C0071r b = c0095u.m831b();
                if (b != null) {
                    b.m201a(this, childAt, view);
                }
                c0095u.m838g();
                c0095u.m841j();
            }
        }
        this.f334r = null;
        this.f335s = null;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        MotionEvent motionEvent2 = null;
        int a = bf.m2309a(motionEvent);
        boolean z2;
        MotionEvent obtain;
        if (this.f333q == null) {
            boolean a2 = m321a(motionEvent, 1);
            if (a2) {
                z2 = a2;
            } else {
                z2 = a2;
                z = false;
                if (this.f333q == null) {
                    z |= super.onTouchEvent(motionEvent);
                } else if (z2) {
                    if (null != null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    } else {
                        obtain = null;
                    }
                    super.onTouchEvent(obtain);
                    motionEvent2 = obtain;
                }
                if (!z || a == 0) {
                    if (motionEvent2 != null) {
                        motionEvent2.recycle();
                    }
                    if (a == 1 || a == 3) {
                        m327e();
                    }
                    return z;
                }
                if (motionEvent2 != null) {
                    motionEvent2.recycle();
                }
                m327e();
                return z;
            }
        }
        z2 = false;
        C0071r b = ((C0095u) this.f333q.getLayoutParams()).m831b();
        z = b != null ? b.m212b(this, this.f333q, motionEvent) : false;
        if (this.f333q == null) {
            z |= super.onTouchEvent(motionEvent);
        } else if (z2) {
            if (null != null) {
                obtain = null;
            } else {
                long uptimeMillis2 = SystemClock.uptimeMillis();
                obtain = MotionEvent.obtain(uptimeMillis2, uptimeMillis2, 3, 0.0f, 0.0f, 0);
            }
            super.onTouchEvent(obtain);
            motionEvent2 = obtain;
        }
        if (z) {
        }
        if (motionEvent2 != null) {
            motionEvent2.recycle();
        }
        m327e();
        return z;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (z) {
            m327e();
        }
    }

    public void setOnHierarchyChangeListener(OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f341y = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(Drawable drawable) {
        this.f340x = drawable;
        invalidate();
    }

    public void setStatusBarBackgroundColor(int i) {
        setStatusBarBackground(new ColorDrawable(i));
    }

    public void setStatusBarBackgroundResource(int i) {
        setStatusBarBackground(i != 0 ? C0125h.m1018a(getContext(), i) : null);
    }
}
