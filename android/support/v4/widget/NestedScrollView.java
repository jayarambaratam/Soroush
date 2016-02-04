package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.bf;
import android.support.v4.view.bo;
import android.support.v4.view.bp;
import android.support.v4.view.bq;
import android.support.v4.view.br;
import android.support.v4.view.bu;
import android.support.v4.view.bw;
import android.support.v4.view.cb;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import java.util.List;
import mobi.mmdt.ott.C1317h;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

public class NestedScrollView extends FrameLayout implements bo, bq, bu {
    private static final au f1460v;
    private static final int[] f1461w;
    private av f1462A;
    private long f1463a;
    private final Rect f1464b;
    private bj f1465c;
    private ah f1466d;
    private ah f1467e;
    private int f1468f;
    private boolean f1469g;
    private boolean f1470h;
    private View f1471i;
    private boolean f1472j;
    private VelocityTracker f1473k;
    private boolean f1474l;
    private boolean f1475m;
    private int f1476n;
    private int f1477o;
    private int f1478p;
    private int f1479q;
    private final int[] f1480r;
    private final int[] f1481s;
    private int f1482t;
    private SavedState f1483u;
    private final br f1484x;
    private final bp f1485y;
    private float f1486z;

    class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR;
        public int f1459a;

        static {
            CREATOR = new aw();
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f1459a = parcel.readInt();
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.f1459a + "}";
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f1459a);
        }
    }

    static {
        f1460v = new au();
        f1461w = new int[]{16843130};
    }

    public NestedScrollView(Context context) {
        this(context, null);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1464b = new Rect();
        this.f1469g = true;
        this.f1470h = false;
        this.f1471i = null;
        this.f1472j = false;
        this.f1475m = true;
        this.f1479q = -1;
        this.f1480r = new int[2];
        this.f1481s = new int[2];
        m2996a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f1461w, i, 0);
        setFillViewport(obtainStyledAttributes.getBoolean(0, false));
        obtainStyledAttributes.recycle();
        this.f1484x = new br(this);
        this.f1485y = new bp(this);
        setNestedScrollingEnabled(true);
        cb.m2400a((View) this, f1460v);
    }

    private View m2995a(boolean z, int i, int i2) {
        List focusables = getFocusables(2);
        View view = null;
        Object obj = null;
        int size = focusables.size();
        int i3 = 0;
        while (i3 < size) {
            View view2;
            Object obj2;
            View view3 = (View) focusables.get(i3);
            int top = view3.getTop();
            int bottom = view3.getBottom();
            if (i < bottom && top < i2) {
                Object obj3 = (i >= top || bottom >= i2) ? null : 1;
                if (view == null) {
                    Object obj4 = obj3;
                    view2 = view3;
                    obj2 = obj4;
                } else {
                    Object obj5 = ((!z || top >= view.getTop()) && (z || bottom <= view.getBottom())) ? null : 1;
                    if (obj != null) {
                        if (!(obj3 == null || obj5 == null)) {
                            view2 = view3;
                            obj2 = obj;
                        }
                    } else if (obj3 != null) {
                        view2 = view3;
                        int i4 = 1;
                    } else if (obj5 != null) {
                        view2 = view3;
                        obj2 = obj;
                    }
                }
                i3++;
                view = view2;
                obj = obj2;
            }
            obj2 = obj;
            view2 = view;
            i3++;
            view = view2;
            obj = obj2;
        }
        return view;
    }

    private void m2996a() {
        this.f1465c = new bj(getContext(), null);
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f1476n = viewConfiguration.getScaledTouchSlop();
        this.f1477o = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f1478p = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    private void m2997a(MotionEvent motionEvent) {
        int action = (motionEvent.getAction() & 65280) >> 8;
        if (bf.m2312b(motionEvent, action) == this.f1479q) {
            action = action == 0 ? 1 : 0;
            this.f1468f = (int) bf.m2315d(motionEvent, action);
            this.f1479q = bf.m2312b(motionEvent, action);
            if (this.f1473k != null) {
                this.f1473k.clear();
            }
        }
    }

    private boolean m2998a(int i, int i2, int i3) {
        boolean z = false;
        int height = getHeight();
        int scrollY = getScrollY();
        int i4 = scrollY + height;
        boolean z2 = i == 33;
        View a = m2995a(z2, i2, i3);
        if (a == null) {
            a = this;
        }
        if (i2 < scrollY || i3 > i4) {
            m3010e(z2 ? i2 - scrollY : i3 - i4);
            z = true;
        }
        if (a != findFocus()) {
            a.requestFocus(i);
        }
        return z;
    }

    private boolean m2999a(Rect rect, boolean z) {
        int a = m3014a(rect);
        boolean z2 = a != 0;
        if (z2) {
            if (z) {
                scrollBy(0, a);
            } else {
                m3015a(0, a);
            }
        }
        return z2;
    }

    private boolean m3000a(View view) {
        return !m3001a(view, 0, getHeight());
    }

    private boolean m3001a(View view, int i, int i2) {
        view.getDrawingRect(this.f1464b);
        offsetDescendantRectToMyCoords(view, this.f1464b);
        return this.f1464b.bottom + i >= getScrollY() && this.f1464b.top - i <= getScrollY() + i2;
    }

    private static boolean m3002a(View view, View view2) {
        if (view == view2) {
            return true;
        }
        ViewParent parent = view.getParent();
        boolean z = (parent instanceof ViewGroup) && m3002a((View) parent, view2);
        return z;
    }

    private static int m3003b(int i, int i2, int i3) {
        return (i2 >= i3 || i < 0) ? 0 : i2 + i > i3 ? i3 - i2 : i;
    }

    private void m3004b(View view) {
        view.getDrawingRect(this.f1464b);
        offsetDescendantRectToMyCoords(view, this.f1464b);
        int a = m3014a(this.f1464b);
        if (a != 0) {
            scrollBy(0, a);
        }
    }

    private boolean m3005b() {
        View childAt = getChildAt(0);
        if (childAt == null) {
            return false;
        }
        return getHeight() < (childAt.getHeight() + getPaddingTop()) + getPaddingBottom();
    }

    private void m3006c() {
        if (this.f1473k == null) {
            this.f1473k = VelocityTracker.obtain();
        } else {
            this.f1473k.clear();
        }
    }

    private boolean m3007c(int i, int i2) {
        if (getChildCount() <= 0) {
            return false;
        }
        int scrollY = getScrollY();
        View childAt = getChildAt(0);
        return i2 >= childAt.getTop() - scrollY && i2 < childAt.getBottom() - scrollY && i >= childAt.getLeft() && i < childAt.getRight();
    }

    private void m3008d() {
        if (this.f1473k == null) {
            this.f1473k = VelocityTracker.obtain();
        }
    }

    private void m3009e() {
        if (this.f1473k != null) {
            this.f1473k.recycle();
            this.f1473k = null;
        }
    }

    private void m3010e(int i) {
        if (i == 0) {
            return;
        }
        if (this.f1475m) {
            m3015a(0, i);
        } else {
            scrollBy(0, i);
        }
    }

    private void m3011f() {
        this.f1472j = false;
        m3009e();
        stopNestedScroll();
        if (this.f1466d != null) {
            this.f1466d.m3141c();
            this.f1467e.m3141c();
        }
    }

    private void m3012f(int i) {
        int scrollY = getScrollY();
        boolean z = (scrollY > 0 || i > 0) && (scrollY < getScrollRange() || i < 0);
        if (!dispatchNestedPreFling(0.0f, (float) i)) {
            dispatchNestedFling(0.0f, (float) i, z);
            if (z) {
                m3022d(i);
            }
        }
    }

    private void m3013g() {
        if (cb.m2391a(this) == 2) {
            this.f1466d = null;
            this.f1467e = null;
        } else if (this.f1466d == null) {
            Context context = getContext();
            this.f1466d = new ah(context);
            this.f1467e = new ah(context);
        }
    }

    private int getScrollRange() {
        return getChildCount() > 0 ? Math.max(0, getChildAt(0).getHeight() - ((getHeight() - getPaddingBottom()) - getPaddingTop())) : 0;
    }

    private float getVerticalScrollFactorCompat() {
        if (this.f1486z == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (context.getTheme().resolveAttribute(16842829, typedValue, true)) {
                this.f1486z = typedValue.getDimension(context.getResources().getDisplayMetrics());
            } else {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
        }
        return this.f1486z;
    }

    protected int m3014a(Rect rect) {
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        if (rect.bottom < getChildAt(0).getHeight()) {
            i -= verticalFadingEdgeLength;
        }
        if (rect.bottom > i && rect.top > scrollY) {
            scrollY = Math.min(rect.height() > height ? (rect.top - scrollY) + 0 : (rect.bottom - i) + 0, getChildAt(0).getBottom() - i);
        } else if (rect.top >= scrollY || rect.bottom >= i) {
            scrollY = 0;
        } else {
            scrollY = Math.max(rect.height() > height ? 0 - (i - rect.bottom) : 0 - (scrollY - rect.top), -getScrollY());
        }
        return scrollY;
    }

    public final void m3015a(int i, int i2) {
        if (getChildCount() != 0) {
            if (AnimationUtils.currentAnimationTimeMillis() - this.f1463a > 250) {
                int max = Math.max(0, getChildAt(0).getHeight() - ((getHeight() - getPaddingBottom()) - getPaddingTop()));
                int scrollY = getScrollY();
                this.f1465c.m3265a(getScrollX(), scrollY, 0, Math.max(0, Math.min(scrollY + i2, max)) - scrollY);
                cb.m2417d(this);
            } else {
                if (!this.f1465c.m3269a()) {
                    this.f1465c.m3277h();
                }
                scrollBy(i, i2);
            }
            this.f1463a = AnimationUtils.currentAnimationTimeMillis();
        }
    }

    public boolean m3016a(int i) {
        int i2 = i == 130 ? 1 : 0;
        int height = getHeight();
        if (i2 != 0) {
            this.f1464b.top = getScrollY() + height;
            i2 = getChildCount();
            if (i2 > 0) {
                View childAt = getChildAt(i2 - 1);
                if (this.f1464b.top + height > childAt.getBottom()) {
                    this.f1464b.top = childAt.getBottom() - height;
                }
            }
        } else {
            this.f1464b.top = getScrollY() - height;
            if (this.f1464b.top < 0) {
                this.f1464b.top = 0;
            }
        }
        this.f1464b.bottom = this.f1464b.top + height;
        return m2998a(i, this.f1464b.top, this.f1464b.bottom);
    }

    boolean m3017a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        boolean z2;
        boolean z3;
        int a = cb.m2391a(this);
        Object obj = computeHorizontalScrollRange() > computeHorizontalScrollExtent() ? 1 : null;
        Object obj2 = computeVerticalScrollRange() > computeVerticalScrollExtent() ? 1 : null;
        Object obj3 = (a == 0 || (a == 1 && obj != null)) ? 1 : null;
        obj = (a == 0 || (a == 1 && obj2 != null)) ? 1 : null;
        int i9 = i3 + i;
        if (obj3 == null) {
            i7 = 0;
        }
        int i10 = i4 + i2;
        if (obj == null) {
            i8 = 0;
        }
        int i11 = -i7;
        int i12 = i7 + i5;
        a = -i8;
        int i13 = i8 + i6;
        if (i9 > i12) {
            z2 = true;
        } else if (i9 < i11) {
            z2 = true;
            i12 = i11;
        } else {
            z2 = false;
            i12 = i9;
        }
        if (i10 > i13) {
            z3 = true;
        } else if (i10 < a) {
            z3 = true;
            i13 = a;
        } else {
            z3 = false;
            i13 = i10;
        }
        if (z3) {
            this.f1465c.m3270a(i12, i13, 0, 0, 0, getScrollRange());
        }
        onOverScrolled(i12, i13, z2, z3);
        return z2 || z3;
    }

    public boolean m3018a(KeyEvent keyEvent) {
        int i = 33;
        this.f1464b.setEmpty();
        if (m3005b()) {
            if (keyEvent.getAction() != 0) {
                return false;
            }
            switch (keyEvent.getKeyCode()) {
                case Version.API19_KITKAT_44 /*19*/:
                    return !keyEvent.isAltPressed() ? m3021c(33) : m3020b(33);
                case C1317h.Toolbar_navigationIcon /*20*/:
                    return !keyEvent.isAltPressed() ? m3021c(130) : m3020b(130);
                case C1317h.Theme_editTextColor /*62*/:
                    if (!keyEvent.isShiftPressed()) {
                        i = 130;
                    }
                    m3016a(i);
                    return false;
                default:
                    return false;
            }
        } else if (!isFocused() || keyEvent.getKeyCode() == 4) {
            return false;
        } else {
            View findFocus = findFocus();
            if (findFocus == this) {
                findFocus = null;
            }
            findFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, 130);
            boolean z = (findFocus == null || findFocus == this || !findFocus.requestFocus(130)) ? false : true;
            return z;
        }
    }

    public void addView(View view) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view);
    }

    public void addView(View view, int i) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i);
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i, layoutParams);
    }

    public void addView(View view, LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, layoutParams);
    }

    public final void m3019b(int i, int i2) {
        m3015a(i - getScrollX(), i2 - getScrollY());
    }

    public boolean m3020b(int i) {
        int i2 = i == 130 ? 1 : 0;
        int height = getHeight();
        this.f1464b.top = 0;
        this.f1464b.bottom = height;
        if (i2 != 0) {
            i2 = getChildCount();
            if (i2 > 0) {
                this.f1464b.bottom = getChildAt(i2 - 1).getBottom() + getPaddingBottom();
                this.f1464b.top = this.f1464b.bottom - height;
            }
        }
        return m2998a(i, this.f1464b.top, this.f1464b.bottom);
    }

    public boolean m3021c(int i) {
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i);
        int maxScrollAmount = getMaxScrollAmount();
        if (findNextFocus == null || !m3001a(findNextFocus, maxScrollAmount, getHeight())) {
            if (i == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i == 130 && getChildCount() > 0) {
                int bottom = getChildAt(0).getBottom();
                int scrollY = (getScrollY() + getHeight()) - getPaddingBottom();
                if (bottom - scrollY < maxScrollAmount) {
                    maxScrollAmount = bottom - scrollY;
                }
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            m3010e(maxScrollAmount);
        } else {
            findNextFocus.getDrawingRect(this.f1464b);
            offsetDescendantRectToMyCoords(findNextFocus, this.f1464b);
            m3010e(m3014a(this.f1464b));
            findNextFocus.requestFocus(i);
        }
        if (findFocus != null && findFocus.isFocused() && m3000a(findFocus)) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(131072);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
        }
        return true;
    }

    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    public void computeScroll() {
        if (this.f1465c.m3276g()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int b = this.f1465c.m3271b();
            int c = this.f1465c.m3272c();
            if (scrollX != b || scrollY != c) {
                int scrollRange = getScrollRange();
                int a = cb.m2391a(this);
                int i = (a == 0 || (a == 1 && scrollRange > 0)) ? 1 : 0;
                m3017a(b - scrollX, c - scrollY, scrollX, scrollY, 0, scrollRange, 0, 0, false);
                if (i != 0) {
                    m3013g();
                    if (c <= 0 && scrollY > 0) {
                        this.f1466d.m3138a((int) this.f1465c.m3275f());
                    } else if (c >= scrollRange && scrollY < scrollRange) {
                        this.f1467e.m3138a((int) this.f1465c.m3275f());
                    }
                }
            }
        }
    }

    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    public int computeVerticalScrollRange() {
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (getChildCount() == 0) {
            return height;
        }
        int bottom = getChildAt(0).getBottom();
        int scrollY = getScrollY();
        height = Math.max(0, bottom - height);
        return scrollY < 0 ? bottom - scrollY : scrollY > height ? bottom + (scrollY - height) : bottom;
    }

    public void m3022d(int i) {
        if (getChildCount() > 0) {
            int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
            int height2 = getChildAt(0).getHeight();
            this.f1465c.m3268a(getScrollX(), getScrollY(), 0, i, 0, 0, 0, Math.max(0, height2 - height), 0, height / 2);
            cb.m2417d(this);
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || m3018a(keyEvent);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.f1485y.m2349a(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.f1485y.m2348a(f, f2);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.f1485y.m2352a(i, i2, iArr, iArr2);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.f1485y.m2351a(i, i2, i3, i4, iArr);
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f1466d != null) {
            int save;
            int width;
            int scrollY = getScrollY();
            if (!this.f1466d.m3135a()) {
                save = canvas.save();
                width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                canvas.translate((float) getPaddingLeft(), (float) Math.min(0, scrollY));
                this.f1466d.m3134a(width, getHeight());
                if (this.f1466d.m3139a(canvas)) {
                    cb.m2417d(this);
                }
                canvas.restoreToCount(save);
            }
            if (!this.f1467e.m3135a()) {
                save = canvas.save();
                width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                int height = getHeight();
                canvas.translate((float) ((-width) + getPaddingLeft()), (float) (Math.max(getScrollRange(), scrollY) + height));
                canvas.rotate(180.0f, (float) width, 0.0f);
                this.f1467e.m3134a(width, height);
                if (this.f1467e.m3139a(canvas)) {
                    cb.m2417d(this);
                }
                canvas.restoreToCount(save);
            }
        }
    }

    protected float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = (getChildAt(0).getBottom() - getScrollY()) - (getHeight() - getPaddingBottom());
        return bottom < verticalFadingEdgeLength ? ((float) bottom) / ((float) verticalFadingEdgeLength) : 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (0.5f * ((float) getHeight()));
    }

    public int getNestedScrollAxes() {
        return this.f1484x.m2355a();
    }

    protected float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        return scrollY < verticalFadingEdgeLength ? ((float) scrollY) / ((float) verticalFadingEdgeLength) : 1.0f;
    }

    public boolean hasNestedScrollingParent() {
        return this.f1485y.m2353b();
    }

    public boolean isNestedScrollingEnabled() {
        return this.f1485y.m2347a();
    }

    protected void measureChild(View view, int i, int i2) {
        view.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width), MeasureSpec.makeMeasureSpec(0, 0));
    }

    protected void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        view.measure(getChildMeasureSpec(i, (((getPaddingLeft() + getPaddingRight()) + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin) + i2, marginLayoutParams.width), MeasureSpec.makeMeasureSpec(marginLayoutParams.bottomMargin + marginLayoutParams.topMargin, 0));
    }

    public void onAttachedToWindow() {
        this.f1470h = false;
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((bf.m2316d(motionEvent) & 2) == 0) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case Version.API08_FROYO_22 /*8*/:
                if (this.f1472j) {
                    return false;
                }
                float e = bf.m2317e(motionEvent, 9);
                if (e == 0.0f) {
                    return false;
                }
                int verticalScrollFactorCompat = (int) (e * getVerticalScrollFactorCompat());
                int scrollRange = getScrollRange();
                int scrollY = getScrollY();
                verticalScrollFactorCompat = scrollY - verticalScrollFactorCompat;
                if (verticalScrollFactorCompat < 0) {
                    scrollRange = 0;
                } else if (verticalScrollFactorCompat <= scrollRange) {
                    scrollRange = verticalScrollFactorCompat;
                }
                if (scrollRange == scrollY) {
                    return false;
                }
                super.scrollTo(getScrollX(), scrollRange);
                return true;
            default:
                return false;
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        int action = motionEvent.getAction();
        if (action == 2 && this.f1472j) {
            return true;
        }
        switch (action & 255) {
            case VideoSize.QCIF /*0*/:
                action = (int) motionEvent.getY();
                if (!m3007c((int) motionEvent.getX(), action)) {
                    this.f1472j = false;
                    m3009e();
                    break;
                }
                this.f1468f = action;
                this.f1479q = bf.m2312b(motionEvent, 0);
                m3006c();
                this.f1473k.addMovement(motionEvent);
                if (!this.f1465c.m3269a()) {
                    z = true;
                }
                this.f1472j = z;
                startNestedScroll(2);
                break;
            case VideoSize.CIF /*1*/:
            case Version.API03_CUPCAKE_15 /*3*/:
                this.f1472j = false;
                this.f1479q = -1;
                m3009e();
                if (this.f1465c.m3270a(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    cb.m2417d(this);
                }
                stopNestedScroll();
                break;
            case VideoSize.HVGA /*2*/:
                action = this.f1479q;
                if (action != -1) {
                    int a = bf.m2310a(motionEvent, action);
                    if (a != -1) {
                        action = (int) bf.m2315d(motionEvent, a);
                        if (Math.abs(action - this.f1468f) > this.f1476n && (getNestedScrollAxes() & 2) == 0) {
                            this.f1472j = true;
                            this.f1468f = action;
                            m3008d();
                            this.f1473k.addMovement(motionEvent);
                            this.f1482t = 0;
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                                break;
                            }
                        }
                    }
                    Log.e("NestedScrollView", "Invalid pointerId=" + action + " in onInterceptTouchEvent");
                    break;
                }
                break;
            case Version.API06_ECLAIR_201 /*6*/:
                m2997a(motionEvent);
                break;
        }
        return this.f1472j;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f1469g = false;
        if (this.f1471i != null && m3002a(this.f1471i, (View) this)) {
            m3004b(this.f1471i);
        }
        this.f1471i = null;
        if (!this.f1470h) {
            if (this.f1483u != null) {
                scrollTo(getScrollX(), this.f1483u.f1459a);
                this.f1483u = null;
            }
            int max = Math.max(0, (getChildCount() > 0 ? getChildAt(0).getMeasuredHeight() : 0) - (((i4 - i2) - getPaddingBottom()) - getPaddingTop()));
            if (getScrollY() > max) {
                scrollTo(getScrollX(), max);
            } else if (getScrollY() < 0) {
                scrollTo(getScrollX(), 0);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.f1470h = true;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f1474l && MeasureSpec.getMode(i2) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            int measuredHeight = getMeasuredHeight();
            if (childAt.getMeasuredHeight() < measuredHeight) {
                childAt.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), ((FrameLayout.LayoutParams) childAt.getLayoutParams()).width), MeasureSpec.makeMeasureSpec((measuredHeight - getPaddingTop()) - getPaddingBottom(), 1073741824));
            }
        }
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (z) {
            return false;
        }
        m3012f((int) f2);
        return true;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        int scrollY = getScrollY();
        scrollBy(0, i4);
        int scrollY2 = getScrollY() - scrollY;
        dispatchNestedScroll(0, scrollY2, 0, i4 - scrollY2, null);
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f1484x.m2357a(view, view2, i);
        startNestedScroll(2);
    }

    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.scrollTo(i, i2);
    }

    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (i == 2) {
            i = 130;
        } else if (i == 1) {
            i = 33;
        }
        View findNextFocus = rect == null ? FocusFinder.getInstance().findNextFocus(this, null, i) : FocusFinder.getInstance().findNextFocusFromRect(this, rect, i);
        return (findNextFocus == null || m3000a(findNextFocus)) ? false : findNextFocus.requestFocus(i, rect);
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f1483u = savedState;
        requestLayout();
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f1459a = getScrollY();
        return savedState;
    }

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.f1462A != null) {
            this.f1462A.m3234a(this, i, i2, i3, i4);
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        View findFocus = findFocus();
        if (findFocus != null && this != findFocus && m3001a(findFocus, 0, i4)) {
            findFocus.getDrawingRect(this.f1464b);
            offsetDescendantRectToMyCoords(findFocus, this.f1464b);
            m3010e(m3014a(this.f1464b));
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return (i & 2) != 0;
    }

    public void onStopNestedScroll(View view) {
        this.f1484x.m2356a(view);
        stopNestedScroll();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        m3008d();
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        int a = bf.m2309a(motionEvent);
        if (a == 0) {
            this.f1482t = 0;
        }
        obtain.offsetLocation(0.0f, (float) this.f1482t);
        switch (a) {
            case VideoSize.QCIF /*0*/:
                if (getChildCount() != 0) {
                    boolean z = !this.f1465c.m3269a();
                    this.f1472j = z;
                    if (z) {
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                    if (!this.f1465c.m3269a()) {
                        this.f1465c.m3277h();
                    }
                    this.f1468f = (int) motionEvent.getY();
                    this.f1479q = bf.m2312b(motionEvent, 0);
                    startNestedScroll(2);
                    break;
                }
                return false;
            case VideoSize.CIF /*1*/:
                if (this.f1472j) {
                    VelocityTracker velocityTracker = this.f1473k;
                    velocityTracker.computeCurrentVelocity(1000, (float) this.f1478p);
                    a = (int) bw.m2359b(velocityTracker, this.f1479q);
                    if (Math.abs(a) > this.f1477o) {
                        m3012f(-a);
                    } else if (this.f1465c.m3270a(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                        cb.m2417d(this);
                    }
                }
                this.f1479q = -1;
                m3011f();
                break;
            case VideoSize.HVGA /*2*/:
                int a2 = bf.m2310a(motionEvent, this.f1479q);
                if (a2 != -1) {
                    int i;
                    int d = (int) bf.m2315d(motionEvent, a2);
                    a = this.f1468f - d;
                    if (dispatchNestedPreScroll(0, a, this.f1481s, this.f1480r)) {
                        a -= this.f1481s[1];
                        obtain.offsetLocation(0.0f, (float) this.f1480r[1]);
                        this.f1482t += this.f1480r[1];
                    }
                    if (this.f1472j || Math.abs(a) <= this.f1476n) {
                        i = a;
                    } else {
                        ViewParent parent2 = getParent();
                        if (parent2 != null) {
                            parent2.requestDisallowInterceptTouchEvent(true);
                        }
                        this.f1472j = true;
                        i = a > 0 ? a - this.f1476n : a + this.f1476n;
                    }
                    if (this.f1472j) {
                        this.f1468f = d - this.f1480r[1];
                        int scrollY = getScrollY();
                        int scrollRange = getScrollRange();
                        a = cb.m2391a(this);
                        Object obj = (a == 0 || (a == 1 && scrollRange > 0)) ? 1 : null;
                        if (m3017a(0, i, 0, getScrollY(), 0, scrollRange, 0, 0, true) && !hasNestedScrollingParent()) {
                            this.f1473k.clear();
                        }
                        int scrollY2 = getScrollY() - scrollY;
                        if (!dispatchNestedScroll(0, scrollY2, 0, i - scrollY2, this.f1480r)) {
                            if (obj != null) {
                                m3013g();
                                a = scrollY + i;
                                if (a < 0) {
                                    this.f1466d.m3137a(((float) i) / ((float) getHeight()), bf.m2313c(motionEvent, a2) / ((float) getWidth()));
                                    if (!this.f1467e.m3135a()) {
                                        this.f1467e.m3141c();
                                    }
                                } else if (a > scrollRange) {
                                    this.f1467e.m3137a(((float) i) / ((float) getHeight()), 1.0f - (bf.m2313c(motionEvent, a2) / ((float) getWidth())));
                                    if (!this.f1466d.m3135a()) {
                                        this.f1466d.m3141c();
                                    }
                                }
                                if (!(this.f1466d == null || (this.f1466d.m3135a() && this.f1467e.m3135a()))) {
                                    cb.m2417d(this);
                                    break;
                                }
                            }
                        }
                        this.f1468f -= this.f1480r[1];
                        obtain.offsetLocation(0.0f, (float) this.f1480r[1]);
                        this.f1482t += this.f1480r[1];
                        break;
                    }
                }
                Log.e("NestedScrollView", "Invalid pointerId=" + this.f1479q + " in onTouchEvent");
                break;
                break;
            case Version.API03_CUPCAKE_15 /*3*/:
                if (this.f1472j && getChildCount() > 0 && this.f1465c.m3270a(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    cb.m2417d(this);
                }
                this.f1479q = -1;
                m3011f();
                break;
            case Version.API05_ECLAIR_20 /*5*/:
                a = bf.m2311b(motionEvent);
                this.f1468f = (int) bf.m2315d(motionEvent, a);
                this.f1479q = bf.m2312b(motionEvent, a);
                break;
            case Version.API06_ECLAIR_201 /*6*/:
                m2997a(motionEvent);
                this.f1468f = (int) bf.m2315d(motionEvent, bf.m2310a(motionEvent, this.f1479q));
                break;
        }
        if (this.f1473k != null) {
            this.f1473k.addMovement(obtain);
        }
        obtain.recycle();
        return true;
    }

    public void requestChildFocus(View view, View view2) {
        if (this.f1469g) {
            this.f1471i = view2;
        } else {
            m3004b(view2);
        }
        super.requestChildFocus(view, view2);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return m2999a(rect, z);
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            m3009e();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    public void requestLayout() {
        this.f1469g = true;
        super.requestLayout();
    }

    public void scrollTo(int i, int i2) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            int b = m3003b(i, (getWidth() - getPaddingRight()) - getPaddingLeft(), childAt.getWidth());
            int b2 = m3003b(i2, (getHeight() - getPaddingBottom()) - getPaddingTop(), childAt.getHeight());
            if (b != getScrollX() || b2 != getScrollY()) {
                super.scrollTo(b, b2);
            }
        }
    }

    public void setFillViewport(boolean z) {
        if (z != this.f1474l) {
            this.f1474l = z;
            requestLayout();
        }
    }

    public void setNestedScrollingEnabled(boolean z) {
        this.f1485y.m2346a(z);
    }

    public void setOnScrollChangeListener(av avVar) {
        this.f1462A = avVar;
    }

    public void setSmoothScrollingEnabled(boolean z) {
        this.f1475m = z;
    }

    public boolean shouldDelayChildPressedState() {
        return true;
    }

    public boolean startNestedScroll(int i) {
        return this.f1485y.m2350a(i);
    }

    public void stopNestedScroll() {
        this.f1485y.m2354c();
    }
}
