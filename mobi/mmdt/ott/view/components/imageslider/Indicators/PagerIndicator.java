package mobi.mmdt.ott.view.components.imageslider.Indicators;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.support.v4.view.bt;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.Iterator;
import mobi.mmdt.ott.C1317h;
import mobi.mmdt.ott.view.components.imageslider.Tricks.C1818k;
import mobi.mmdt.ott.view.components.imageslider.Tricks.C1824b;
import mobi.mmdt.ott.view.components.imageslider.Tricks.ViewPagerEx;

public class PagerIndicator extends LinearLayout implements C1818k {
    private Context f5840a;
    private ViewPagerEx f5841b;
    private ImageView f5842c;
    private int f5843d;
    private int f5844e;
    private int f5845f;
    private Drawable f5846g;
    private Drawable f5847h;
    private int f5848i;
    private C1820b f5849j;
    private GradientDrawable f5850k;
    private GradientDrawable f5851l;
    private LayerDrawable f5852m;
    private LayerDrawable f5853n;
    private float f5854o;
    private float f5855p;
    private float f5856q;
    private float f5857r;
    private float f5858s;
    private float f5859t;
    private float f5860u;
    private float f5861v;
    private ArrayList<ImageView> f5862w;
    private DataSetObserver f5863x;

    public PagerIndicator(Context context) {
        this(context, null);
    }

    public PagerIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5848i = 0;
        this.f5849j = C1820b.Visible;
        this.f5862w = new ArrayList();
        this.f5863x = new C1819a(this);
        this.f5840a = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1317h.PagerIndicator, 0, 0);
        int i = obtainStyledAttributes.getInt(0, C1820b.Visible.ordinal());
        for (C1820b c1820b : C1820b.values()) {
            if (c1820b.ordinal() == i) {
                this.f5849j = c1820b;
                break;
            }
        }
        int i2 = obtainStyledAttributes.getInt(1, C1821c.Oval.ordinal());
        C1821c c1821c = C1821c.Oval;
        for (C1821c c1821c2 : C1821c.values()) {
            if (c1821c2.ordinal() == i2) {
                break;
            }
        }
        C1821c c1821c22 = c1821c;
        this.f5845f = obtainStyledAttributes.getResourceId(4, 0);
        this.f5844e = obtainStyledAttributes.getResourceId(5, 0);
        i = obtainStyledAttributes.getColor(2, Color.rgb(255, 255, 255));
        int color = obtainStyledAttributes.getColor(3, Color.argb(80, 0, 0, 0));
        float dimension = obtainStyledAttributes.getDimension(6, (float) ((int) m8826a(6.0f)));
        float dimensionPixelSize = (float) obtainStyledAttributes.getDimensionPixelSize(7, (int) m8826a(6.0f));
        float dimensionPixelSize2 = (float) obtainStyledAttributes.getDimensionPixelSize(8, (int) m8826a(6.0f));
        float dimensionPixelSize3 = (float) obtainStyledAttributes.getDimensionPixelSize(9, (int) m8826a(6.0f));
        this.f5851l = new GradientDrawable();
        this.f5850k = new GradientDrawable();
        float dimensionPixelSize4 = (float) obtainStyledAttributes.getDimensionPixelSize(10, (int) m8826a(3.0f));
        float dimensionPixelSize5 = (float) obtainStyledAttributes.getDimensionPixelSize(11, (int) m8826a(3.0f));
        float dimensionPixelSize6 = (float) obtainStyledAttributes.getDimensionPixelSize(12, (int) m8826a(0.0f));
        float dimensionPixelSize7 = (float) obtainStyledAttributes.getDimensionPixelSize(13, (int) m8826a(0.0f));
        this.f5854o = (float) obtainStyledAttributes.getDimensionPixelSize(14, (int) dimensionPixelSize4);
        this.f5855p = (float) obtainStyledAttributes.getDimensionPixelSize(15, (int) dimensionPixelSize5);
        this.f5856q = (float) obtainStyledAttributes.getDimensionPixelSize(16, (int) dimensionPixelSize6);
        this.f5857r = (float) obtainStyledAttributes.getDimensionPixelSize(17, (int) dimensionPixelSize7);
        this.f5858s = (float) obtainStyledAttributes.getDimensionPixelSize(18, (int) dimensionPixelSize4);
        this.f5859t = (float) obtainStyledAttributes.getDimensionPixelSize(19, (int) dimensionPixelSize5);
        this.f5860u = (float) obtainStyledAttributes.getDimensionPixelSize(20, (int) dimensionPixelSize6);
        this.f5861v = (float) obtainStyledAttributes.getDimensionPixelSize(21, (int) dimensionPixelSize7);
        this.f5852m = new LayerDrawable(new Drawable[]{this.f5851l});
        this.f5853n = new LayerDrawable(new Drawable[]{this.f5850k});
        m8842a(this.f5845f, this.f5844e);
        setDefaultIndicatorShape(c1821c22);
        m8839a(dimension, dimensionPixelSize, C1822d.Px);
        m8844b(dimensionPixelSize2, dimensionPixelSize3, C1822d.Px);
        m8846b(i, color);
        setIndicatorVisibility(this.f5849j);
        obtainStyledAttributes.recycle();
    }

    private float m8826a(float f) {
        return getContext().getResources().getDisplayMetrics().density * f;
    }

    private void m8831c() {
        Iterator it = this.f5862w.iterator();
        while (it.hasNext()) {
            View view = (View) it.next();
            if (this.f5842c == null || !this.f5842c.equals(view)) {
                ((ImageView) view).setImageDrawable(this.f5847h);
            } else {
                ((ImageView) view).setImageDrawable(this.f5846g);
            }
        }
    }

    private int getShouldDrawCount() {
        return this.f5841b.getAdapter() instanceof C1824b ? ((C1824b) this.f5841b.getAdapter()).m8912e() : this.f5841b.getAdapter().m871b();
    }

    private void setItemAsSelected(int i) {
        if (this.f5842c != null) {
            this.f5842c.setImageDrawable(this.f5847h);
            this.f5842c.setPadding((int) this.f5858s, (int) this.f5860u, (int) this.f5859t, (int) this.f5861v);
        }
        ImageView imageView = (ImageView) getChildAt(i + 1);
        if (imageView != null) {
            imageView.setImageDrawable(this.f5846g);
            imageView.setPadding((int) this.f5854o, (int) this.f5856q, (int) this.f5855p, (int) this.f5857r);
            this.f5842c = imageView;
        }
        this.f5843d = i;
    }

    public void m8838a() {
        if (this.f5841b != null && this.f5841b.getAdapter() != null) {
            bt d = ((C1824b) this.f5841b.getAdapter()).m8911d();
            if (d != null) {
                d.m872b(this.f5863x);
            }
            removeAllViews();
        }
    }

    public void m8839a(float f, float f2, C1822d c1822d) {
        if (this.f5845f == 0) {
            if (c1822d == C1822d.DP) {
                f = m8826a(f);
                f2 = m8826a(f2);
            }
            this.f5851l.setSize((int) f, (int) f2);
            m8831c();
        }
    }

    public void m8840a(int i) {
        if (this.f5848i != 0) {
            setItemAsSelected(i - 1);
        }
    }

    public void m8841a(int i, float f, int i2) {
    }

    public void m8842a(int i, int i2) {
        this.f5845f = i;
        this.f5844e = i2;
        if (i == 0) {
            this.f5846g = this.f5852m;
        } else {
            this.f5846g = this.f5840a.getResources().getDrawable(this.f5845f);
        }
        if (i2 == 0) {
            this.f5847h = this.f5853n;
        } else {
            this.f5847h = this.f5840a.getResources().getDrawable(this.f5844e);
        }
        m8831c();
    }

    public void m8843b() {
        this.f5848i = getShouldDrawCount();
        this.f5842c = null;
        Iterator it = this.f5862w.iterator();
        while (it.hasNext()) {
            removeView((View) it.next());
        }
        for (int i = 0; i < this.f5848i; i++) {
            View imageView = new ImageView(this.f5840a);
            imageView.setImageDrawable(this.f5847h);
            imageView.setPadding((int) this.f5858s, (int) this.f5860u, (int) this.f5859t, (int) this.f5861v);
            addView(imageView);
            this.f5862w.add(imageView);
        }
        setItemAsSelected(this.f5843d);
    }

    public void m8844b(float f, float f2, C1822d c1822d) {
        if (this.f5844e == 0) {
            if (c1822d == C1822d.DP) {
                f = m8826a(f);
                f2 = m8826a(f2);
            }
            this.f5850k.setSize((int) f, (int) f2);
            m8831c();
        }
    }

    public void m8845b(int i) {
    }

    public void m8846b(int i, int i2) {
        if (this.f5845f == 0) {
            this.f5851l.setColor(i);
        }
        if (this.f5844e == 0) {
            this.f5850k.setColor(i2);
        }
        m8831c();
    }

    public C1820b getIndicatorVisibility() {
        return this.f5849j;
    }

    public int getSelectedIndicatorResId() {
        return this.f5845f;
    }

    public int getUnSelectedIndicatorResId() {
        return this.f5844e;
    }

    public void setDefaultIndicatorShape(C1821c c1821c) {
        if (this.f5845f == 0) {
            if (c1821c == C1821c.Oval) {
                this.f5851l.setShape(1);
            } else {
                this.f5851l.setShape(0);
            }
        }
        if (this.f5844e == 0) {
            if (c1821c == C1821c.Oval) {
                this.f5850k.setShape(1);
            } else {
                this.f5850k.setShape(0);
            }
        }
        m8831c();
    }

    public void setIndicatorVisibility(C1820b c1820b) {
        if (c1820b == C1820b.Visible) {
            setVisibility(0);
        } else {
            setVisibility(4);
        }
        m8831c();
    }

    public void setViewPager(ViewPagerEx viewPagerEx) {
        if (viewPagerEx.getAdapter() == null) {
            throw new IllegalStateException("Viewpager does not have adapter instance");
        }
        this.f5841b = viewPagerEx;
        this.f5841b.m8891a((C1818k) this);
        ((C1824b) this.f5841b.getAdapter()).m8911d().m864a(this.f5863x);
    }
}
