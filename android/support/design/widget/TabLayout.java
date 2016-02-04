package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.design.C0041e;
import android.support.design.C0069j;
import android.support.design.C0070k;
import android.support.v4.view.ViewPager;
import android.support.v4.view.bt;
import android.support.v4.view.cb;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout.LayoutParams;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.myHttp.HttpStatus;
import org.linphone.core.VideoSize;

public class TabLayout extends HorizontalScrollView {
    private final ArrayList<cd> f386a;
    private cd f387b;
    private final ca f388c;
    private int f389d;
    private int f390e;
    private int f391f;
    private int f392g;
    private int f393h;
    private ColorStateList f394i;
    private float f395j;
    private float f396k;
    private final int f397l;
    private int f398m;
    private final int f399n;
    private final int f400o;
    private final int f401p;
    private int f402q;
    private int f403r;
    private int f404s;
    private bz f405t;
    private OnClickListener f406u;
    private cn f407v;
    private cn f408w;

    public TabLayout(Context context) {
        this(context, null);
    }

    public TabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f386a = new ArrayList();
        this.f398m = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        cm.m677a(context);
        setHorizontalScrollBarEnabled(false);
        this.f388c = new ca(this, context);
        addView(this.f388c, -2, -1);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0070k.TabLayout, i, C0069j.Widget_Design_TabLayout);
        this.f388c.m644b(obtainStyledAttributes.getDimensionPixelSize(C0070k.TabLayout_tabIndicatorHeight, 0));
        this.f388c.m639a(obtainStyledAttributes.getColor(C0070k.TabLayout_tabIndicatorColor, 0));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(C0070k.TabLayout_tabPadding, 0);
        this.f392g = dimensionPixelSize;
        this.f391f = dimensionPixelSize;
        this.f390e = dimensionPixelSize;
        this.f389d = dimensionPixelSize;
        this.f389d = obtainStyledAttributes.getDimensionPixelSize(C0070k.TabLayout_tabPaddingStart, this.f389d);
        this.f390e = obtainStyledAttributes.getDimensionPixelSize(C0070k.TabLayout_tabPaddingTop, this.f390e);
        this.f391f = obtainStyledAttributes.getDimensionPixelSize(C0070k.TabLayout_tabPaddingEnd, this.f391f);
        this.f392g = obtainStyledAttributes.getDimensionPixelSize(C0070k.TabLayout_tabPaddingBottom, this.f392g);
        this.f393h = obtainStyledAttributes.getResourceId(C0070k.TabLayout_tabTextAppearance, C0069j.TextAppearance_Design_Tab);
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(this.f393h, C0070k.TextAppearance);
        try {
            this.f395j = (float) obtainStyledAttributes2.getDimensionPixelSize(C0070k.TextAppearance_android_textSize, 0);
            this.f394i = obtainStyledAttributes2.getColorStateList(C0070k.TextAppearance_android_textColor);
            if (obtainStyledAttributes.hasValue(C0070k.TabLayout_tabTextColor)) {
                this.f394i = obtainStyledAttributes.getColorStateList(C0070k.TabLayout_tabTextColor);
            }
            if (obtainStyledAttributes.hasValue(C0070k.TabLayout_tabSelectedTextColor)) {
                this.f394i = m421a(this.f394i.getDefaultColor(), obtainStyledAttributes.getColor(C0070k.TabLayout_tabSelectedTextColor, 0));
            }
            this.f399n = obtainStyledAttributes.getDimensionPixelSize(C0070k.TabLayout_tabMinWidth, -1);
            this.f400o = obtainStyledAttributes.getDimensionPixelSize(C0070k.TabLayout_tabMaxWidth, -1);
            this.f397l = obtainStyledAttributes.getResourceId(C0070k.TabLayout_tabBackground, 0);
            this.f402q = obtainStyledAttributes.getDimensionPixelSize(C0070k.TabLayout_tabContentStart, 0);
            this.f404s = obtainStyledAttributes.getInt(C0070k.TabLayout_tabMode, 1);
            this.f403r = obtainStyledAttributes.getInt(C0070k.TabLayout_tabGravity, 0);
            obtainStyledAttributes.recycle();
            Resources resources = getResources();
            this.f396k = (float) resources.getDimensionPixelSize(C0041e.design_tab_text_size_2line);
            this.f401p = resources.getDimensionPixelSize(C0041e.design_tab_scrollable_min_width);
            m441e();
        } finally {
            obtainStyledAttributes2.recycle();
        }
    }

    private int m419a(int i, float f) {
        int i2 = 0;
        if (this.f404s != 0) {
            return 0;
        }
        View childAt = this.f388c.getChildAt(i);
        View childAt2 = i + 1 < this.f388c.getChildCount() ? this.f388c.getChildAt(i + 1) : null;
        int width = childAt != null ? childAt.getWidth() : 0;
        if (childAt2 != null) {
            i2 = childAt2.getWidth();
        }
        return ((((int) ((((float) (i2 + width)) * f) * 0.5f)) + childAt.getLeft()) + (childAt.getWidth() / 2)) - (getWidth() / 2);
    }

    private static ColorStateList m421a(int i, int i2) {
        r0 = new int[2][];
        int[] iArr = new int[]{SELECTED_STATE_SET, i2};
        r0[1] = EMPTY_STATE_SET;
        iArr[1] = i;
        return new ColorStateList(r0, iArr);
    }

    private void m425a(cd cdVar, int i) {
        cdVar.m657a(i);
        this.f386a.add(i, cdVar);
        int size = this.f386a.size();
        for (int i2 = i + 1; i2 < size; i2++) {
            ((cd) this.f386a.get(i2)).m657a(i2);
        }
    }

    private void m426a(LayoutParams layoutParams) {
        if (this.f404s == 1 && this.f403r == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
            return;
        }
        layoutParams.width = -2;
        layoutParams.weight = 0.0f;
    }

    private void m427a(boolean z) {
        for (int i = 0; i < this.f388c.getChildCount(); i++) {
            View childAt = this.f388c.getChildAt(i);
            childAt.setMinimumWidth(getTabMinWidth());
            m426a((LayoutParams) childAt.getLayoutParams());
            if (z) {
                childAt.requestLayout();
            }
        }
    }

    private void m430b(int i) {
        cf c = m433c(i);
        if (c != null) {
            c.m671a();
        }
    }

    private cf m433c(int i) {
        return (cf) this.f388c.getChildAt(i);
    }

    private cf m434c(cd cdVar) {
        cf cfVar = new cf(this, getContext(), cdVar);
        cfVar.setFocusable(true);
        cfVar.setMinimumWidth(getTabMinWidth());
        if (this.f406u == null) {
            this.f406u = new bx(this);
        }
        cfVar.setOnClickListener(this.f406u);
        return cfVar;
    }

    private void m435c() {
        int childCount = this.f388c.getChildCount();
        for (int i = 0; i < childCount; i++) {
            m430b(i);
        }
    }

    private void m436c(cd cdVar, boolean z) {
        View c = m434c(cdVar);
        this.f388c.addView(c, m439d());
        if (z) {
            c.setSelected(true);
        }
    }

    private int m437d(int i) {
        return Math.round(getResources().getDisplayMetrics().density * ((float) i));
    }

    private LayoutParams m439d() {
        LayoutParams layoutParams = new LayoutParams(-2, -1);
        m426a(layoutParams);
        return layoutParams;
    }

    private void m441e() {
        cb.m2409b(this.f388c, this.f404s == 0 ? Math.max(0, this.f402q - this.f389d) : 0, 0, 0, 0);
        switch (this.f404s) {
            case VideoSize.QCIF /*0*/:
                this.f388c.setGravity(8388611);
                break;
            case VideoSize.CIF /*1*/:
                this.f388c.setGravity(1);
                break;
        }
        m427a(true);
    }

    private void m442e(int i) {
        if (i != -1) {
            if (getWindowToken() == null || !cb.m2385D(this) || this.f388c.m642a()) {
                m453a(i, 0.0f, true);
                return;
            }
            int scrollX = getScrollX();
            int a = m419a(i, 0.0f);
            if (scrollX != a) {
                if (this.f407v == null) {
                    this.f407v = dk.m755a();
                    this.f407v.m684a(C0072a.f429b);
                    this.f407v.m680a((int) HttpStatus.SC_MULTIPLE_CHOICES);
                    this.f407v.m683a(new by(this));
                }
                this.f407v.m681a(scrollX, a);
                this.f407v.m678a();
            }
            this.f388c.m641a(i, (int) HttpStatus.SC_MULTIPLE_CHOICES);
        }
    }

    private int getDefaultHeight() {
        Object obj;
        int size = this.f386a.size();
        for (int i = 0; i < size; i++) {
            cd cdVar = (cd) this.f386a.get(i);
            if (cdVar != null && cdVar.m658b() != null && !TextUtils.isEmpty(cdVar.m660d())) {
                obj = 1;
                break;
            }
        }
        obj = null;
        return obj != null ? 72 : 48;
    }

    private float getScrollPosition() {
        return this.f388c.m643b();
    }

    private int getTabMaxWidth() {
        return this.f398m;
    }

    private int getTabMinWidth() {
        return this.f399n != -1 ? this.f399n : this.f404s == 0 ? this.f401p : 0;
    }

    private void setSelectedTabView(int i) {
        int childCount = this.f388c.getChildCount();
        if (i < childCount && !this.f388c.getChildAt(i).isSelected()) {
            int i2 = 0;
            while (i2 < childCount) {
                this.f388c.getChildAt(i2).setSelected(i2 == i);
                i2++;
            }
        }
    }

    public cd m451a() {
        return new cd(this);
    }

    public cd m452a(int i) {
        return (cd) this.f386a.get(i);
    }

    public void m453a(int i, float f, boolean z) {
        if ((this.f408w == null || !this.f408w.m685b()) && i >= 0 && i < this.f388c.getChildCount()) {
            this.f388c.m640a(i, f);
            scrollTo(m419a(i, f), 0);
            if (z) {
                setSelectedTabView(Math.round(((float) i) + f));
            }
        }
    }

    public void m454a(cd cdVar) {
        m455a(cdVar, this.f386a.isEmpty());
    }

    public void m455a(cd cdVar, boolean z) {
        if (cdVar.f544f != this) {
            throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
        }
        m436c(cdVar, z);
        m425a(cdVar, this.f386a.size());
        if (z) {
            cdVar.m661e();
        }
    }

    public void m456b() {
        this.f388c.removeAllViews();
        Iterator it = this.f386a.iterator();
        while (it.hasNext()) {
            ((cd) it.next()).m657a(-1);
            it.remove();
        }
        this.f387b = null;
    }

    void m457b(cd cdVar) {
        m458b(cdVar, true);
    }

    void m458b(cd cdVar, boolean z) {
        if (this.f387b != cdVar) {
            if (z) {
                int c = cdVar != null ? cdVar.m659c() : -1;
                if (c != -1) {
                    setSelectedTabView(c);
                }
                if ((this.f387b == null || this.f387b.m659c() == -1) && c != -1) {
                    m453a(c, 0.0f, true);
                } else {
                    m442e(c);
                }
            }
            if (!(this.f387b == null || this.f405t == null)) {
                this.f405t.m631b(this.f387b);
            }
            this.f387b = cdVar;
            if (this.f387b != null && this.f405t != null) {
                this.f405t.m630a(this.f387b);
            }
        } else if (this.f387b != null) {
            if (this.f405t != null) {
                this.f405t.m632c(this.f387b);
            }
            m442e(cdVar.m659c());
        }
    }

    public int getSelectedTabPosition() {
        return this.f387b != null ? this.f387b.m659c() : -1;
    }

    public int getTabCount() {
        return this.f386a.size();
    }

    public int getTabGravity() {
        return this.f403r;
    }

    public int getTabMode() {
        return this.f404s;
    }

    public ColorStateList getTabTextColors() {
        return this.f394i;
    }

    protected void onMeasure(int i, int i2) {
        int i3 = 1;
        int d = (m437d(getDefaultHeight()) + getPaddingTop()) + getPaddingBottom();
        switch (MeasureSpec.getMode(i2)) {
            case RtlSpacingHelper.UNDEFINED /*-2147483648*/:
                i2 = MeasureSpec.makeMeasureSpec(Math.min(d, MeasureSpec.getSize(i2)), 1073741824);
                break;
            case VideoSize.QCIF /*0*/:
                i2 = MeasureSpec.makeMeasureSpec(d, 1073741824);
                break;
        }
        d = MeasureSpec.getSize(i);
        if (MeasureSpec.getMode(i) != 0) {
            this.f398m = this.f400o > 0 ? this.f400o : d - m437d(56);
        }
        super.onMeasure(i, i2);
        if (getChildCount() == 1) {
            View childAt = getChildAt(0);
            switch (this.f404s) {
                case VideoSize.QCIF /*0*/:
                    if (childAt.getMeasuredWidth() >= getMeasuredWidth()) {
                        d = 0;
                        break;
                    } else {
                        d = 1;
                        break;
                    }
                case VideoSize.CIF /*1*/:
                    if (childAt.getMeasuredWidth() == getMeasuredWidth()) {
                        i3 = 0;
                    }
                    d = i3;
                    break;
                default:
                    d = 0;
                    break;
            }
            if (d != 0) {
                childAt.measure(MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom(), childAt.getLayoutParams().height));
            }
        }
    }

    public void setOnTabSelectedListener(bz bzVar) {
        this.f405t = bzVar;
    }

    public void setSelectedTabIndicatorColor(int i) {
        this.f388c.m639a(i);
    }

    public void setSelectedTabIndicatorHeight(int i) {
        this.f388c.m644b(i);
    }

    public void setTabGravity(int i) {
        if (this.f403r != i) {
            this.f403r = i;
            m441e();
        }
    }

    public void setTabMode(int i) {
        if (i != this.f404s) {
            this.f404s = i;
            m441e();
        }
    }

    public void setTabTextColors(ColorStateList colorStateList) {
        if (this.f394i != colorStateList) {
            this.f394i = colorStateList;
            m435c();
        }
    }

    public void setTabsFromPagerAdapter(bt btVar) {
        m456b();
        int b = btVar.m871b();
        for (int i = 0; i < b; i++) {
            m454a(m451a().m655a(btVar.m877c(i)));
        }
    }

    public void setupWithViewPager(ViewPager viewPager) {
        bt adapter = viewPager.getAdapter();
        if (adapter == null) {
            throw new IllegalArgumentException("ViewPager does not have a PagerAdapter set");
        }
        setTabsFromPagerAdapter(adapter);
        viewPager.m1852a(new ce(this));
        setOnTabSelectedListener(new cg(viewPager));
        if (adapter.m871b() > 0) {
            int currentItem = viewPager.getCurrentItem();
            if (getSelectedTabPosition() != currentItem) {
                m457b(m452a(currentItem));
            }
        }
    }
}
