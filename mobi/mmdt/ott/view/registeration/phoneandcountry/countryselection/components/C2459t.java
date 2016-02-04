package mobi.mmdt.ott.view.registeration.phoneandcountry.countryselection.components;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;

/* renamed from: mobi.mmdt.ott.view.registeration.phoneandcountry.countryselection.components.t */
public abstract class C2459t {
    protected LayoutManager f8003b;

    public C2459t(LayoutManager layoutManager) {
        this.f8003b = layoutManager;
    }

    public int m10731a(int i, int i2, int i3) {
        while (i2 >= 0) {
            View childAt = this.f8003b.getChildAt(i2);
            C2461j c2461j = (C2461j) childAt.getLayoutParams();
            if (c2461j.m10770d() != i) {
                return i3;
            }
            if (!c2461j.f8010a) {
                return this.f8003b.getDecoratedBottom(childAt);
            }
            i2--;
        }
        return i3;
    }

    public abstract int m10732a(int i, int i2, int i3, C2474s c2474s, C2471p c2471p);

    public int m10733a(int i, SparseArray<Boolean> sparseArray) {
        int i2 = 0;
        int i3 = 0;
        while (i2 < sparseArray.size()) {
            int i4;
            if (((Boolean) sparseArray.get(i, Boolean.valueOf(false))).booleanValue()) {
                i4 = i2 + 1;
                i2 = i3;
            } else {
                i4 = i2;
                i2 = i3 + 1;
            }
            i++;
            i3 = i2;
            i2 = i4;
        }
        return i3;
    }

    public abstract int m10734a(int i, View view, C2474s c2474s, C2471p c2471p);

    public abstract int m10735a(int i, C2474s c2474s, C2471p c2471p);

    protected int m10736a(C2472q c2472q, int i, C2465i c2465i, C2471p c2471p) {
        int childCount = c2465i == C2465i.START ? 0 : this.f8003b.getChildCount();
        c2471p.m10783a(i);
        this.f8003b.addView(c2472q.f8037a, childCount);
        return childCount;
    }

    public View m10737a(int i, boolean z) {
        int childCount = this.f8003b.getChildCount();
        View view = null;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.f8003b.getChildAt(i2);
            C2461j c2461j = (C2461j) childAt.getLayoutParams();
            if (i != c2461j.m10770d()) {
                return view;
            }
            if (!c2461j.f8010a || !z) {
                return childAt;
            }
            view = childAt;
        }
        return view;
    }

    public C2461j m10738a(Context context, AttributeSet attributeSet) {
        return new C2461j(context, attributeSet);
    }

    public C2461j m10739a(C2461j c2461j) {
        return c2461j;
    }

    public int m10740b(int i, int i2, int i3) {
        while (i2 < this.f8003b.getChildCount()) {
            View childAt = this.f8003b.getChildAt(i2);
            C2461j c2461j = (C2461j) childAt.getLayoutParams();
            if (c2461j.m10770d() != i) {
                return i3;
            }
            if (!c2461j.f8010a) {
                return this.f8003b.getDecoratedTop(childAt);
            }
            i2++;
        }
        return i3;
    }

    public abstract int m10741b(int i, int i2, int i3, C2474s c2474s, C2471p c2471p);

    public int m10742b(int i, SparseArray<Boolean> sparseArray) {
        int i2 = 0;
        int i3 = 0;
        while (i2 < sparseArray.size()) {
            int i4;
            if (((Boolean) sparseArray.get(i, Boolean.valueOf(false))).booleanValue()) {
                i4 = i2 + 1;
                i2 = i3;
            } else {
                i4 = i2;
                i2 = i3 + 1;
            }
            i--;
            i3 = i2;
            i2 = i4;
        }
        return i3;
    }

    public abstract int m10743b(int i, View view, C2474s c2474s, C2471p c2471p);

    public C2459t m10744b(C2474s c2474s) {
        return this;
    }

    public View m10745c(int i) {
        View view = null;
        for (int childCount = this.f8003b.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.f8003b.getChildAt(childCount);
            C2461j c2461j = (C2461j) childAt.getLayoutParams();
            if (i != c2461j.m10770d()) {
                return view;
            }
            if (!c2461j.f8010a) {
                return childAt;
            }
            view = childAt;
        }
        return view;
    }
}
