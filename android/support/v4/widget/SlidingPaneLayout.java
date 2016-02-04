package android.support.v4.widget;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.cb;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import java.util.ArrayList;
import org.apache.http.myHttp.HttpStatus;
import org.linphone.core.VideoSize;

public class SlidingPaneLayout extends ViewGroup {
    static final bv f1488a;
    private int f1489b;
    private int f1490c;
    private Drawable f1491d;
    private Drawable f1492e;
    private final int f1493f;
    private boolean f1494g;
    private View f1495h;
    private float f1496i;
    private float f1497j;
    private int f1498k;
    private boolean f1499l;
    private int f1500m;
    private float f1501n;
    private float f1502o;
    private bt f1503p;
    private final ct f1504q;
    private boolean f1505r;
    private boolean f1506s;
    private final Rect f1507t;
    private final ArrayList<br> f1508u;

    class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR;
        boolean f1487a;

        static {
            CREATOR = new bu();
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f1487a = parcel.readInt() != 0;
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f1487a ? 1 : 0);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 17) {
            f1488a = new by();
        } else if (i >= 16) {
            f1488a = new bx();
        } else {
            f1488a = new bw();
        }
    }

    private void m3024a(float f) {
        Object obj;
        int childCount;
        int i;
        View childAt;
        int i2;
        boolean f2 = m3031f();
        bs bsVar = (bs) this.f1495h.getLayoutParams();
        if (bsVar.f1636c) {
            if ((f2 ? bsVar.rightMargin : bsVar.leftMargin) <= 0) {
                obj = 1;
                childCount = getChildCount();
                for (i = 0; i < childCount; i++) {
                    childAt = getChildAt(i);
                    if (childAt == this.f1495h) {
                        i2 = (int) ((1.0f - this.f1497j) * ((float) this.f1500m));
                        this.f1497j = f;
                        i2 -= (int) ((1.0f - f) * ((float) this.f1500m));
                        if (f2) {
                            i2 = -i2;
                        }
                        childAt.offsetLeftAndRight(i2);
                        if (obj == null) {
                            m3026a(childAt, f2 ? this.f1497j - 1.0f : 1.0f - this.f1497j, this.f1490c);
                        }
                    }
                }
            }
        }
        obj = null;
        childCount = getChildCount();
        for (i = 0; i < childCount; i++) {
            childAt = getChildAt(i);
            if (childAt == this.f1495h) {
                i2 = (int) ((1.0f - this.f1497j) * ((float) this.f1500m));
                this.f1497j = f;
                i2 -= (int) ((1.0f - f) * ((float) this.f1500m));
                if (f2) {
                    i2 = -i2;
                }
                childAt.offsetLeftAndRight(i2);
                if (obj == null) {
                    if (f2) {
                    }
                    m3026a(childAt, f2 ? this.f1497j - 1.0f : 1.0f - this.f1497j, this.f1490c);
                }
            }
        }
    }

    private void m3026a(View view, float f, int i) {
        bs bsVar = (bs) view.getLayoutParams();
        if (f > 0.0f && i != 0) {
            int i2 = (((int) (((float) ((-16777216 & i) >>> 24)) * f)) << 24) | (16777215 & i);
            if (bsVar.f1637d == null) {
                bsVar.f1637d = new Paint();
            }
            bsVar.f1637d.setColorFilter(new PorterDuffColorFilter(i2, Mode.SRC_OVER));
            if (cb.m2426g(view) != 2) {
                cb.m2396a(view, 2, bsVar.f1637d);
            }
            m3030d(view);
        } else if (cb.m2426g(view) != 0) {
            if (bsVar.f1637d != null) {
                bsVar.f1637d.setColorFilter(null);
            }
            Runnable brVar = new br(this, view);
            this.f1508u.add(brVar);
            cb.m2402a((View) this, brVar);
        }
    }

    private boolean m3027a(View view, int i) {
        if (!this.f1506s && !m3034a(0.0f, i)) {
            return false;
        }
        this.f1505r = false;
        return true;
    }

    private boolean m3028b(View view, int i) {
        if (!this.f1506s && !m3034a(1.0f, i)) {
            return false;
        }
        this.f1505r = true;
        return true;
    }

    private static boolean m3029c(View view) {
        if (cb.m2433j(view)) {
            return true;
        }
        if (VERSION.SDK_INT >= 18) {
            return false;
        }
        Drawable background = view.getBackground();
        return background != null ? background.getOpacity() == -1 : false;
    }

    private void m3030d(View view) {
        f1488a.m3337a(this, view);
    }

    private boolean m3031f() {
        return cb.m2428h(this) == 1;
    }

    void m3032a() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    void m3033a(View view) {
        int i;
        int i2;
        int i3;
        int i4;
        boolean f = m3031f();
        int width = f ? getWidth() - getPaddingRight() : getPaddingLeft();
        int paddingLeft = f ? getPaddingLeft() : getWidth() - getPaddingRight();
        int paddingTop = getPaddingTop();
        int height = getHeight() - getPaddingBottom();
        if (view == null || !m3029c(view)) {
            i = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
        } else {
            i4 = view.getLeft();
            i3 = view.getRight();
            i2 = view.getTop();
            i = view.getBottom();
        }
        int childCount = getChildCount();
        int i5 = 0;
        while (i5 < childCount) {
            View childAt = getChildAt(i5);
            if (childAt != view) {
                int i6 = (Math.max(f ? paddingLeft : width, childAt.getLeft()) < i4 || Math.max(paddingTop, childAt.getTop()) < i2 || Math.min(f ? width : paddingLeft, childAt.getRight()) > i3 || Math.min(height, childAt.getBottom()) > i) ? 0 : 4;
                childAt.setVisibility(i6);
                i5++;
            } else {
                return;
            }
        }
    }

    boolean m3034a(float f, int i) {
        if (!this.f1494g) {
            return false;
        }
        int width;
        bs bsVar = (bs) this.f1495h.getLayoutParams();
        if (m3031f()) {
            width = (int) (((float) getWidth()) - ((((float) (bsVar.rightMargin + getPaddingRight())) + (((float) this.f1498k) * f)) + ((float) this.f1495h.getWidth())));
        } else {
            width = (int) (((float) (bsVar.leftMargin + getPaddingLeft())) + (((float) this.f1498k) * f));
        }
        if (!this.f1504q.m3396a(this.f1495h, width, this.f1495h.getTop())) {
            return false;
        }
        m3032a();
        cb.m2417d(this);
        return true;
    }

    public boolean m3035b() {
        return m3028b(this.f1495h, 0);
    }

    boolean m3036b(View view) {
        if (view == null) {
            return false;
        }
        boolean z = this.f1494g && ((bs) view.getLayoutParams()).f1636c && this.f1496i > 0.0f;
        return z;
    }

    public boolean m3037c() {
        return m3027a(this.f1495h, 0);
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return (layoutParams instanceof bs) && super.checkLayoutParams(layoutParams);
    }

    public void computeScroll() {
        if (!this.f1504q.m3397a(true)) {
            return;
        }
        if (this.f1494g) {
            cb.m2417d(this);
        } else {
            this.f1504q.m3411f();
        }
    }

    public boolean m3038d() {
        return !this.f1494g || this.f1496i == 1.0f;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        Drawable drawable = m3031f() ? this.f1492e : this.f1491d;
        View childAt = getChildCount() > 1 ? getChildAt(1) : null;
        if (childAt != null && drawable != null) {
            int right;
            int i;
            int top = childAt.getTop();
            int bottom = childAt.getBottom();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            if (m3031f()) {
                right = childAt.getRight();
                i = right + intrinsicWidth;
            } else {
                i = childAt.getLeft();
                right = i - intrinsicWidth;
            }
            drawable.setBounds(right, top, i, bottom);
            drawable.draw(canvas);
        }
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        boolean drawChild;
        bs bsVar = (bs) view.getLayoutParams();
        int save = canvas.save(2);
        if (!(!this.f1494g || bsVar.f1635b || this.f1495h == null)) {
            canvas.getClipBounds(this.f1507t);
            if (m3031f()) {
                this.f1507t.left = Math.max(this.f1507t.left, this.f1495h.getRight());
            } else {
                this.f1507t.right = Math.min(this.f1507t.right, this.f1495h.getLeft());
            }
            canvas.clipRect(this.f1507t);
        }
        if (VERSION.SDK_INT >= 11) {
            drawChild = super.drawChild(canvas, view, j);
        } else if (!bsVar.f1636c || this.f1496i <= 0.0f) {
            if (view.isDrawingCacheEnabled()) {
                view.setDrawingCacheEnabled(false);
            }
            drawChild = super.drawChild(canvas, view, j);
        } else {
            if (!view.isDrawingCacheEnabled()) {
                view.setDrawingCacheEnabled(true);
            }
            Bitmap drawingCache = view.getDrawingCache();
            if (drawingCache != null) {
                canvas.drawBitmap(drawingCache, (float) view.getLeft(), (float) view.getTop(), bsVar.f1637d);
                drawChild = false;
            } else {
                Log.e("SlidingPaneLayout", "drawChild: child view " + view + " returned null drawing cache");
                drawChild = super.drawChild(canvas, view, j);
            }
        }
        canvas.restoreToCount(save);
        return drawChild;
    }

    public boolean m3039e() {
        return this.f1494g;
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new bs();
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new bs(getContext(), attributeSet);
    }

    protected LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof MarginLayoutParams ? new bs((MarginLayoutParams) layoutParams) : new bs(layoutParams);
    }

    public int getCoveredFadeColor() {
        return this.f1490c;
    }

    public int getParallaxDistance() {
        return this.f1500m;
    }

    public int getSliderFadeColor() {
        return this.f1489b;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f1506s = true;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f1506s = true;
        int size = this.f1508u.size();
        for (int i = 0; i < size; i++) {
            ((br) this.f1508u.get(i)).run();
        }
        this.f1508u.clear();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r8) {
        /*
        r7 = this;
        r2 = 0;
        r1 = 1;
        r3 = android.support.v4.view.bf.m2309a(r8);
        r0 = r7.f1494g;
        if (r0 != 0) goto L_0x002d;
    L_0x000a:
        if (r3 != 0) goto L_0x002d;
    L_0x000c:
        r0 = r7.getChildCount();
        if (r0 <= r1) goto L_0x002d;
    L_0x0012:
        r0 = r7.getChildAt(r1);
        if (r0 == 0) goto L_0x002d;
    L_0x0018:
        r4 = r7.f1504q;
        r5 = r8.getX();
        r5 = (int) r5;
        r6 = r8.getY();
        r6 = (int) r6;
        r0 = r4.m3403b(r0, r5, r6);
        if (r0 != 0) goto L_0x0041;
    L_0x002a:
        r0 = r1;
    L_0x002b:
        r7.f1505r = r0;
    L_0x002d:
        r0 = r7.f1494g;
        if (r0 == 0) goto L_0x0037;
    L_0x0031:
        r0 = r7.f1499l;
        if (r0 == 0) goto L_0x0043;
    L_0x0035:
        if (r3 == 0) goto L_0x0043;
    L_0x0037:
        r0 = r7.f1504q;
        r0.m3410e();
        r2 = super.onInterceptTouchEvent(r8);
    L_0x0040:
        return r2;
    L_0x0041:
        r0 = r2;
        goto L_0x002b;
    L_0x0043:
        r0 = 3;
        if (r3 == r0) goto L_0x0048;
    L_0x0046:
        if (r3 != r1) goto L_0x004e;
    L_0x0048:
        r0 = r7.f1504q;
        r0.m3410e();
        goto L_0x0040;
    L_0x004e:
        switch(r3) {
            case 0: goto L_0x005e;
            case 1: goto L_0x0051;
            case 2: goto L_0x0082;
            default: goto L_0x0051;
        };
    L_0x0051:
        r0 = r2;
    L_0x0052:
        r3 = r7.f1504q;
        r3 = r3.m3395a(r8);
        if (r3 != 0) goto L_0x005c;
    L_0x005a:
        if (r0 == 0) goto L_0x0040;
    L_0x005c:
        r2 = r1;
        goto L_0x0040;
    L_0x005e:
        r7.f1499l = r2;
        r0 = r8.getX();
        r3 = r8.getY();
        r7.f1501n = r0;
        r7.f1502o = r3;
        r4 = r7.f1504q;
        r5 = r7.f1495h;
        r0 = (int) r0;
        r3 = (int) r3;
        r0 = r4.m3403b(r5, r0, r3);
        if (r0 == 0) goto L_0x0051;
    L_0x0078:
        r0 = r7.f1495h;
        r0 = r7.m3036b(r0);
        if (r0 == 0) goto L_0x0051;
    L_0x0080:
        r0 = r1;
        goto L_0x0052;
    L_0x0082:
        r0 = r8.getX();
        r3 = r8.getY();
        r4 = r7.f1501n;
        r0 = r0 - r4;
        r0 = java.lang.Math.abs(r0);
        r4 = r7.f1502o;
        r3 = r3 - r4;
        r3 = java.lang.Math.abs(r3);
        r4 = r7.f1504q;
        r4 = r4.m3407d();
        r4 = (float) r4;
        r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
        if (r4 <= 0) goto L_0x0051;
    L_0x00a3:
        r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1));
        if (r0 <= 0) goto L_0x0051;
    L_0x00a7:
        r0 = r7.f1504q;
        r0.m3410e();
        r7.f1499l = r1;
        goto L_0x0040;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.SlidingPaneLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean f = m3031f();
        if (f) {
            this.f1504q.m3392a(2);
        } else {
            this.f1504q.m3392a(1);
        }
        int i5 = i3 - i;
        int paddingRight = f ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = f ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        if (this.f1506s) {
            float f2 = (this.f1494g && this.f1505r) ? 1.0f : 0.0f;
            this.f1496i = f2;
        }
        int i6 = 0;
        int i7 = paddingRight;
        while (i6 < childCount) {
            int i8;
            int i9;
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() == 8) {
                i8 = paddingRight;
                i9 = i7;
            } else {
                int i10;
                bs bsVar = (bs) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                if (bsVar.f1635b) {
                    int min = (Math.min(paddingRight, (i5 - paddingLeft) - this.f1493f) - i7) - (bsVar.leftMargin + bsVar.rightMargin);
                    this.f1498k = min;
                    i9 = f ? bsVar.rightMargin : bsVar.leftMargin;
                    bsVar.f1636c = ((i7 + i9) + min) + (measuredWidth / 2) > i5 - paddingLeft;
                    i8 = (int) (((float) min) * this.f1496i);
                    i10 = i7 + (i9 + i8);
                    this.f1496i = ((float) i8) / ((float) this.f1498k);
                    i8 = 0;
                } else if (!this.f1494g || this.f1500m == 0) {
                    i8 = 0;
                    i10 = paddingRight;
                } else {
                    i8 = (int) ((1.0f - this.f1496i) * ((float) this.f1500m));
                    i10 = paddingRight;
                }
                if (f) {
                    i9 = (i5 - i10) + i8;
                    i8 = i9 - measuredWidth;
                } else {
                    i8 = i10 - i8;
                    i9 = i8 + measuredWidth;
                }
                childAt.layout(i8, paddingTop, i9, childAt.getMeasuredHeight() + paddingTop);
                i8 = childAt.getWidth() + paddingRight;
                i9 = i10;
            }
            i6++;
            paddingRight = i8;
            i7 = i9;
        }
        if (this.f1506s) {
            if (this.f1494g) {
                if (this.f1500m != 0) {
                    m3024a(this.f1496i);
                }
                if (((bs) this.f1495h.getLayoutParams()).f1636c) {
                    m3026a(this.f1495h, this.f1496i, this.f1489b);
                }
            } else {
                for (i8 = 0; i8 < childCount; i8++) {
                    m3026a(getChildAt(i8), 0.0f, this.f1489b);
                }
            }
            m3033a(this.f1495h);
        }
        this.f1506s = false;
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size2 = MeasureSpec.getSize(i2);
        if (mode == 1073741824) {
            if (mode2 == 0) {
                if (!isInEditMode()) {
                    throw new IllegalStateException("Height must not be UNSPECIFIED");
                } else if (mode2 == 0) {
                    i3 = Integer.MIN_VALUE;
                    i4 = size;
                    size = HttpStatus.SC_MULTIPLE_CHOICES;
                }
            }
            i3 = mode2;
            i4 = size;
            size = size2;
        } else if (!isInEditMode()) {
            throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
        } else if (mode == RtlSpacingHelper.UNDEFINED) {
            i3 = mode2;
            i4 = size;
            size = size2;
        } else {
            if (mode == 0) {
                i3 = mode2;
                i4 = HttpStatus.SC_MULTIPLE_CHOICES;
                size = size2;
            }
            i3 = mode2;
            i4 = size;
            size = size2;
        }
        switch (i3) {
            case RtlSpacingHelper.UNDEFINED /*-2147483648*/:
                size2 = 0;
                mode2 = (size - getPaddingTop()) - getPaddingBottom();
                break;
            case 1073741824:
                size2 = (size - getPaddingTop()) - getPaddingBottom();
                mode2 = size2;
                break;
            default:
                size2 = 0;
                mode2 = -1;
                break;
        }
        boolean z = false;
        int paddingLeft = (i4 - getPaddingLeft()) - getPaddingRight();
        int childCount = getChildCount();
        if (childCount > 2) {
            Log.e("SlidingPaneLayout", "onMeasure: More than two child views are not supported.");
        }
        this.f1495h = null;
        int i5 = 0;
        int i6 = paddingLeft;
        int i7 = size2;
        float f = 0.0f;
        while (i5 < childCount) {
            float f2;
            int i8;
            boolean z2;
            View childAt = getChildAt(i5);
            bs bsVar = (bs) childAt.getLayoutParams();
            if (childAt.getVisibility() == 8) {
                bsVar.f1636c = false;
                size2 = i6;
                f2 = f;
                i8 = i7;
                z2 = z;
            } else {
                if (bsVar.f1634a > 0.0f) {
                    f += bsVar.f1634a;
                    if (bsVar.width == 0) {
                        size2 = i6;
                        f2 = f;
                        i8 = i7;
                        z2 = z;
                    }
                }
                mode = bsVar.leftMargin + bsVar.rightMargin;
                mode = bsVar.width == -2 ? MeasureSpec.makeMeasureSpec(paddingLeft - mode, RtlSpacingHelper.UNDEFINED) : bsVar.width == -1 ? MeasureSpec.makeMeasureSpec(paddingLeft - mode, 1073741824) : MeasureSpec.makeMeasureSpec(bsVar.width, 1073741824);
                i8 = bsVar.height == -2 ? MeasureSpec.makeMeasureSpec(mode2, RtlSpacingHelper.UNDEFINED) : bsVar.height == -1 ? MeasureSpec.makeMeasureSpec(mode2, 1073741824) : MeasureSpec.makeMeasureSpec(bsVar.height, 1073741824);
                childAt.measure(mode, i8);
                mode = childAt.getMeasuredWidth();
                i8 = childAt.getMeasuredHeight();
                if (i3 == Integer.MIN_VALUE && i8 > i7) {
                    i7 = Math.min(i8, mode2);
                }
                i8 = i6 - mode;
                boolean z3 = i8 < 0;
                bsVar.f1635b = z3;
                z3 |= z;
                if (bsVar.f1635b) {
                    this.f1495h = childAt;
                }
                size2 = i8;
                i8 = i7;
                float f3 = f;
                z2 = z3;
                f2 = f3;
            }
            i5++;
            z = z2;
            i7 = i8;
            f = f2;
            i6 = size2;
        }
        if (z || f > 0.0f) {
            int i9 = paddingLeft - this.f1493f;
            for (i3 = 0; i3 < childCount; i3++) {
                View childAt2 = getChildAt(i3);
                if (childAt2.getVisibility() != 8) {
                    bsVar = (bs) childAt2.getLayoutParams();
                    if (childAt2.getVisibility() != 8) {
                        Object obj = (bsVar.width != 0 || bsVar.f1634a <= 0.0f) ? null : 1;
                        i8 = obj != null ? 0 : childAt2.getMeasuredWidth();
                        if (!z || childAt2 == this.f1495h) {
                            if (bsVar.f1634a > 0.0f) {
                                mode = bsVar.width == 0 ? bsVar.height == -2 ? MeasureSpec.makeMeasureSpec(mode2, RtlSpacingHelper.UNDEFINED) : bsVar.height == -1 ? MeasureSpec.makeMeasureSpec(mode2, 1073741824) : MeasureSpec.makeMeasureSpec(bsVar.height, 1073741824) : MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                                if (z) {
                                    size2 = paddingLeft - (bsVar.rightMargin + bsVar.leftMargin);
                                    i5 = MeasureSpec.makeMeasureSpec(size2, 1073741824);
                                    if (i8 != size2) {
                                        childAt2.measure(i5, mode);
                                    }
                                } else {
                                    childAt2.measure(MeasureSpec.makeMeasureSpec(((int) ((bsVar.f1634a * ((float) Math.max(0, i6))) / f)) + i8, 1073741824), mode);
                                }
                            }
                        } else if (bsVar.width < 0 && (i8 > i9 || bsVar.f1634a > 0.0f)) {
                            size2 = obj != null ? bsVar.height == -2 ? MeasureSpec.makeMeasureSpec(mode2, RtlSpacingHelper.UNDEFINED) : bsVar.height == -1 ? MeasureSpec.makeMeasureSpec(mode2, 1073741824) : MeasureSpec.makeMeasureSpec(bsVar.height, 1073741824) : MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                            childAt2.measure(MeasureSpec.makeMeasureSpec(i9, 1073741824), size2);
                        }
                    }
                }
            }
        }
        setMeasuredDimension(i4, (getPaddingTop() + i7) + getPaddingBottom());
        this.f1494g = z;
        if (this.f1504q.m3390a() != 0 && !z) {
            this.f1504q.m3411f();
        }
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.f1487a) {
            m3035b();
        } else {
            m3037c();
        }
        this.f1505r = savedState.f1487a;
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f1487a = m3039e() ? m3038d() : this.f1505r;
        return savedState;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            this.f1506s = true;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f1494g) {
            return super.onTouchEvent(motionEvent);
        }
        this.f1504q.m3399b(motionEvent);
        float x;
        float y;
        switch (motionEvent.getAction() & 255) {
            case VideoSize.QCIF /*0*/:
                x = motionEvent.getX();
                y = motionEvent.getY();
                this.f1501n = x;
                this.f1502o = y;
                return true;
            case VideoSize.CIF /*1*/:
                if (!m3036b(this.f1495h)) {
                    return true;
                }
                x = motionEvent.getX();
                y = motionEvent.getY();
                float f = x - this.f1501n;
                float f2 = y - this.f1502o;
                int d = this.f1504q.m3407d();
                if ((f * f) + (f2 * f2) >= ((float) (d * d)) || !this.f1504q.m3403b(this.f1495h, (int) x, (int) y)) {
                    return true;
                }
                m3027a(this.f1495h, 0);
                return true;
            default:
                return true;
        }
    }

    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        if (!isInTouchMode() && !this.f1494g) {
            this.f1505r = view == this.f1495h;
        }
    }

    public void setCoveredFadeColor(int i) {
        this.f1490c = i;
    }

    public void setPanelSlideListener(bt btVar) {
        this.f1503p = btVar;
    }

    public void setParallaxDistance(int i) {
        this.f1500m = i;
        requestLayout();
    }

    @Deprecated
    public void setShadowDrawable(Drawable drawable) {
        setShadowDrawableLeft(drawable);
    }

    public void setShadowDrawableLeft(Drawable drawable) {
        this.f1491d = drawable;
    }

    public void setShadowDrawableRight(Drawable drawable) {
        this.f1492e = drawable;
    }

    @Deprecated
    public void setShadowResource(int i) {
        setShadowDrawable(getResources().getDrawable(i));
    }

    public void setShadowResourceLeft(int i) {
        setShadowDrawableLeft(getResources().getDrawable(i));
    }

    public void setShadowResourceRight(int i) {
        setShadowDrawableRight(getResources().getDrawable(i));
    }

    public void setSliderFadeColor(int i) {
        this.f1489b = i;
    }
}
