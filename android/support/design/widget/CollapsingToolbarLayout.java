package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.design.C0043g;
import android.support.design.C0069j;
import android.support.design.C0070k;
import android.support.v4.p012b.C0125h;
import android.support.v4.view.cb;
import android.support.v4.view.ff;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public class CollapsingToolbarLayout extends FrameLayout {
    private boolean f296a;
    private int f297b;
    private Toolbar f298c;
    private View f299d;
    private int f300e;
    private int f301f;
    private int f302g;
    private int f303h;
    private final Rect f304i;
    private final C0086k f305j;
    private boolean f306k;
    private boolean f307l;
    private Drawable f308m;
    private Drawable f309n;
    private int f310o;
    private boolean f311p;
    private cn f312q;
    private C0083h f313r;
    private int f314s;
    private ff f315t;

    public CollapsingToolbarLayout(Context context) {
        this(context, null);
    }

    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet, int i) {
        int dimensionPixelSize;
        super(context, attributeSet, i);
        this.f296a = true;
        this.f304i = new Rect();
        cm.m677a(context);
        this.f305j = new C0086k(this);
        this.f305j.m795a(C0072a.f430c);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0070k.CollapsingToolbarLayout, i, C0069j.Widget_Design_CollapsingToolbar);
        this.f305j.m804c(obtainStyledAttributes.getInt(C0070k.CollapsingToolbarLayout_expandedTitleGravity, 8388691));
        this.f305j.m807d(obtainStyledAttributes.getInt(C0070k.CollapsingToolbarLayout_collapsedTitleGravity, 8388627));
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(C0070k.CollapsingToolbarLayout_expandedTitleMargin, 0);
        this.f303h = dimensionPixelSize2;
        this.f302g = dimensionPixelSize2;
        this.f301f = dimensionPixelSize2;
        this.f300e = dimensionPixelSize2;
        boolean z = cb.m2428h(this) == 1;
        if (obtainStyledAttributes.hasValue(C0070k.CollapsingToolbarLayout_expandedTitleMarginStart)) {
            dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(C0070k.CollapsingToolbarLayout_expandedTitleMarginStart, 0);
            if (z) {
                this.f302g = dimensionPixelSize;
            } else {
                this.f300e = dimensionPixelSize;
            }
        }
        if (obtainStyledAttributes.hasValue(C0070k.CollapsingToolbarLayout_expandedTitleMarginEnd)) {
            dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(C0070k.CollapsingToolbarLayout_expandedTitleMarginEnd, 0);
            if (z) {
                this.f300e = dimensionPixelSize;
            } else {
                this.f302g = dimensionPixelSize;
            }
        }
        if (obtainStyledAttributes.hasValue(C0070k.CollapsingToolbarLayout_expandedTitleMarginTop)) {
            this.f301f = obtainStyledAttributes.getDimensionPixelSize(C0070k.CollapsingToolbarLayout_expandedTitleMarginTop, 0);
        }
        if (obtainStyledAttributes.hasValue(C0070k.CollapsingToolbarLayout_expandedTitleMarginBottom)) {
            this.f303h = obtainStyledAttributes.getDimensionPixelSize(C0070k.CollapsingToolbarLayout_expandedTitleMarginBottom, 0);
        }
        this.f306k = obtainStyledAttributes.getBoolean(C0070k.CollapsingToolbarLayout_titleEnabled, true);
        setTitle(obtainStyledAttributes.getText(C0070k.CollapsingToolbarLayout_title));
        this.f305j.m811f(C0069j.TextAppearance_Design_CollapsingToolbar_Expanded);
        this.f305j.m809e(C0069j.TextAppearance_AppCompat_Widget_ActionBar_Title);
        if (obtainStyledAttributes.hasValue(C0070k.CollapsingToolbarLayout_expandedTitleTextAppearance)) {
            this.f305j.m811f(obtainStyledAttributes.getResourceId(C0070k.CollapsingToolbarLayout_expandedTitleTextAppearance, 0));
        }
        if (obtainStyledAttributes.hasValue(C0070k.CollapsingToolbarLayout_collapsedTitleTextAppearance)) {
            this.f305j.m809e(obtainStyledAttributes.getResourceId(C0070k.CollapsingToolbarLayout_collapsedTitleTextAppearance, 0));
        }
        setContentScrim(obtainStyledAttributes.getDrawable(C0070k.CollapsingToolbarLayout_contentScrim));
        setStatusBarScrim(obtainStyledAttributes.getDrawable(C0070k.CollapsingToolbarLayout_statusBarScrim));
        this.f297b = obtainStyledAttributes.getResourceId(C0070k.CollapsingToolbarLayout_toolbarId, -1);
        obtainStyledAttributes.recycle();
        setWillNotDraw(false);
        cb.m2401a((View) this, new C0087l(this));
    }

    private void m301a(int i) {
        m306b();
        if (this.f312q == null) {
            this.f312q = dk.m755a();
            this.f312q.m680a(600);
            this.f312q.m684a(C0072a.f429b);
            this.f312q.m683a(new C0088m(this));
        } else if (this.f312q.m685b()) {
            this.f312q.m688e();
        }
        this.f312q.m681a(this.f310o, i);
        this.f312q.m678a();
    }

    private static dj m305b(View view) {
        dj djVar = (dj) view.getTag(C0043g.view_offset_helper);
        if (djVar != null) {
            return djVar;
        }
        djVar = new dj(view);
        view.setTag(C0043g.view_offset_helper, djVar);
        return djVar;
    }

    private void m306b() {
        if (this.f296a) {
            Toolbar toolbar;
            int childCount = getChildCount();
            int i = 0;
            Toolbar toolbar2 = null;
            while (i < childCount) {
                View childAt = getChildAt(i);
                if (childAt instanceof Toolbar) {
                    if (this.f297b == -1) {
                        toolbar = (Toolbar) childAt;
                        break;
                    } else if (this.f297b == childAt.getId()) {
                        toolbar = (Toolbar) childAt;
                        break;
                    } else if (toolbar2 == null) {
                        toolbar = (Toolbar) childAt;
                        i++;
                        toolbar2 = toolbar;
                    }
                }
                toolbar = toolbar2;
                i++;
                toolbar2 = toolbar;
            }
            toolbar = null;
            if (toolbar != null) {
                toolbar2 = toolbar;
            }
            this.f298c = toolbar2;
            m308c();
            this.f296a = false;
        }
    }

    private void m308c() {
        if (!(this.f306k || this.f299d == null)) {
            ViewParent parent = this.f299d.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f299d);
            }
        }
        if (this.f306k && this.f298c != null) {
            if (this.f299d == null) {
                this.f299d = new View(getContext());
            }
            if (this.f299d.getParent() == null) {
                this.f298c.addView(this.f299d, -1, -1);
            }
        }
    }

    private void setScrimAlpha(int i) {
        if (i != this.f310o) {
            if (!(this.f308m == null || this.f298c == null)) {
                cb.m2417d(this.f298c);
            }
            this.f310o = i;
            cb.m2417d(this);
        }
    }

    protected C0089n m310a() {
        return new C0089n(super.generateDefaultLayoutParams());
    }

    protected LayoutParams m311a(ViewGroup.LayoutParams layoutParams) {
        return new C0089n(layoutParams);
    }

    public void m312a(boolean z, boolean z2) {
        int i = 255;
        if (this.f311p != z) {
            if (z2) {
                if (!z) {
                    i = 0;
                }
                m301a(i);
            } else {
                if (!z) {
                    i = 0;
                }
                setScrimAlpha(i);
            }
            this.f311p = z;
        }
    }

    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof C0089n;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        m306b();
        if (this.f298c == null && this.f308m != null && this.f310o > 0) {
            this.f308m.mutate().setAlpha(this.f310o);
            this.f308m.draw(canvas);
        }
        if (this.f306k && this.f307l) {
            this.f305j.m793a(canvas);
        }
        if (this.f309n != null && this.f310o > 0) {
            int b = this.f315t != null ? this.f315t.m2899b() : 0;
            if (b > 0) {
                this.f309n.setBounds(0, -this.f314s, getWidth(), b - this.f314s);
                this.f309n.mutate().setAlpha(this.f310o);
                this.f309n.draw(canvas);
            }
        }
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        m306b();
        if (view == this.f298c && this.f308m != null && this.f310o > 0) {
            this.f308m.mutate().setAlpha(this.f310o);
            this.f308m.draw(canvas);
        }
        return super.drawChild(canvas, view, j);
    }

    protected /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return m310a();
    }

    protected /* synthetic */ LayoutParams m11098generateDefaultLayoutParams() {
        return m310a();
    }

    protected /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return m311a(layoutParams);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new C0089n(getContext(), attributeSet);
    }

    public int getCollapsedTitleGravity() {
        return this.f305j.m803c();
    }

    public Typeface getCollapsedTitleTypeface() {
        return this.f305j.m806d();
    }

    public Drawable getContentScrim() {
        return this.f308m;
    }

    public int getExpandedTitleGravity() {
        return this.f305j.m797b();
    }

    public Typeface getExpandedTitleTypeface() {
        return this.f305j.m808e();
    }

    final int getScrimTriggerOffset() {
        return cb.m2441r(this) * 2;
    }

    public Drawable getStatusBarScrim() {
        return this.f309n;
    }

    public CharSequence getTitle() {
        return this.f306k ? this.f305j.m814i() : null;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            if (this.f313r == null) {
                this.f313r = new C0090o();
            }
            ((AppBarLayout) parent).m295a(this.f313r);
        }
    }

    protected void onDetachedFromWindow() {
        ViewParent parent = getParent();
        if (this.f313r != null && (parent instanceof AppBarLayout)) {
            ((AppBarLayout) parent).m297b(this.f313r);
        }
        super.onDetachedFromWindow();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f306k && this.f299d != null) {
            this.f307l = this.f299d.isShown();
            if (this.f307l) {
                dc.m743b(this, this.f299d, this.f304i);
                this.f305j.m800b(this.f304i.left, i4 - this.f304i.height(), this.f304i.right, i4);
                this.f305j.m792a(this.f300e, this.f304i.bottom + this.f301f, (i3 - i) - this.f302g, (i4 - i2) - this.f303h);
                this.f305j.m813h();
            }
        }
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (!(this.f315t == null || cb.m2447x(childAt))) {
                int b = this.f315t.m2899b();
                if (childAt.getTop() < b) {
                    childAt.offsetTopAndBottom(b);
                }
            }
            m305b(childAt).m751a();
        }
        if (this.f298c != null) {
            if (this.f306k && TextUtils.isEmpty(this.f305j.m814i())) {
                this.f305j.m796a(this.f298c.getTitle());
            }
            setMinimumHeight(this.f298c.getHeight());
        }
    }

    protected void onMeasure(int i, int i2) {
        m306b();
        super.onMeasure(i, i2);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.f308m != null) {
            this.f308m.setBounds(0, 0, i, i2);
        }
    }

    public void setCollapsedTitleGravity(int i) {
        this.f305j.m807d(i);
    }

    public void setCollapsedTitleTextAppearance(int i) {
        this.f305j.m809e(i);
    }

    public void setCollapsedTitleTextColor(int i) {
        this.f305j.m791a(i);
    }

    public void setCollapsedTitleTypeface(Typeface typeface) {
        this.f305j.m794a(typeface);
    }

    public void setContentScrim(Drawable drawable) {
        if (this.f308m != drawable) {
            if (this.f308m != null) {
                this.f308m.setCallback(null);
            }
            if (drawable != null) {
                this.f308m = drawable.mutate();
                drawable.setBounds(0, 0, getWidth(), getHeight());
                drawable.setCallback(this);
                drawable.setAlpha(this.f310o);
            } else {
                this.f308m = null;
            }
            cb.m2417d(this);
        }
    }

    public void setContentScrimColor(int i) {
        setContentScrim(new ColorDrawable(i));
    }

    public void setContentScrimResource(int i) {
        setContentScrim(C0125h.m1018a(getContext(), i));
    }

    public void setExpandedTitleColor(int i) {
        this.f305j.m799b(i);
    }

    public void setExpandedTitleGravity(int i) {
        this.f305j.m804c(i);
    }

    public void setExpandedTitleTextAppearance(int i) {
        this.f305j.m811f(i);
    }

    public void setExpandedTitleTypeface(Typeface typeface) {
        this.f305j.m801b(typeface);
    }

    public void setScrimsShown(boolean z) {
        boolean z2 = cb.m2385D(this) && !isInEditMode();
        m312a(z, z2);
    }

    public void setStatusBarScrim(Drawable drawable) {
        if (this.f309n != drawable) {
            if (this.f309n != null) {
                this.f309n.setCallback(null);
            }
            this.f309n = drawable;
            drawable.setCallback(this);
            drawable.mutate().setAlpha(this.f310o);
            cb.m2417d(this);
        }
    }

    public void setStatusBarScrimColor(int i) {
        setStatusBarScrim(new ColorDrawable(i));
    }

    public void setStatusBarScrimResource(int i) {
        setStatusBarScrim(C0125h.m1018a(getContext(), i));
    }

    public void setTitle(CharSequence charSequence) {
        this.f305j.m796a(charSequence);
    }

    public void setTitleEnabled(boolean z) {
        if (z != this.f306k) {
            this.f306k = z;
            m308c();
            requestLayout();
        }
    }
}
