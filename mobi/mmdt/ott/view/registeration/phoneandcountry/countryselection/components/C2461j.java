package mobi.mmdt.ott.view.registeration.phoneandcountry.countryselection.components;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import mobi.mmdt.ott.C1317h;

/* renamed from: mobi.mmdt.ott.view.registeration.phoneandcountry.countryselection.components.j */
public class C2461j extends LayoutParams {
    public boolean f8010a;
    public int f8011b;
    public int f8012c;
    public int f8013d;
    public boolean f8014e;
    public boolean f8015f;
    String f8016g;
    int f8017h;
    private int f8018i;

    public C2461j(int i, int i2) {
        super(i, i2);
        this.f8017h = 1;
        this.f8010a = false;
    }

    @TargetApi(21)
    public C2461j(Context context, AttributeSet attributeSet) {
        boolean z = true;
        super(context, attributeSet);
        this.f8017h = 1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1317h.superslim_LayoutManager);
        this.f8010a = obtainStyledAttributes.getBoolean(0, false);
        this.f8011b = obtainStyledAttributes.getInt(1, 17);
        this.f8018i = obtainStyledAttributes.getInt(2, -1);
        if (VERSION.SDK_INT < 21) {
            TypedValue typedValue = new TypedValue();
            obtainStyledAttributes.getValue(4, typedValue);
            m10765b(obtainStyledAttributes, typedValue.type == 5);
            obtainStyledAttributes.getValue(5, typedValue);
            m10762a(obtainStyledAttributes, typedValue.type == 5);
            obtainStyledAttributes.getValue(3, typedValue);
            if (typedValue.type != 3) {
                z = false;
            }
            m10766c(obtainStyledAttributes, z);
        } else {
            m10765b(obtainStyledAttributes, obtainStyledAttributes.getType(4) == 5);
            m10762a(obtainStyledAttributes, obtainStyledAttributes.getType(5) == 5);
            if (obtainStyledAttributes.getType(3) != 3) {
                z = false;
            }
            m10766c(obtainStyledAttributes, z);
        }
        obtainStyledAttributes.recycle();
    }

    @Deprecated
    public C2461j(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.f8017h = 1;
        m10763a(layoutParams);
    }

    @Deprecated
    public C2461j(MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
        this.f8017h = 1;
        m10763a((ViewGroup.LayoutParams) marginLayoutParams);
    }

    private void m10762a(TypedArray typedArray, boolean z) {
        if (z) {
            this.f8015f = false;
            this.f8012c = typedArray.getDimensionPixelSize(5, 0);
            return;
        }
        this.f8015f = true;
    }

    private void m10763a(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof C2461j) {
            C2461j c2461j = (C2461j) layoutParams;
            this.f8010a = c2461j.f8010a;
            this.f8011b = c2461j.f8011b;
            this.f8018i = c2461j.f8018i;
            this.f8016g = c2461j.f8016g;
            this.f8017h = c2461j.f8017h;
            this.f8012c = c2461j.f8012c;
            this.f8013d = c2461j.f8013d;
            this.f8015f = c2461j.f8015f;
            this.f8014e = c2461j.f8014e;
            return;
        }
        this.f8010a = false;
        this.f8011b = 17;
        this.f8012c = -1;
        this.f8013d = -1;
        this.f8014e = true;
        this.f8015f = true;
        this.f8017h = 1;
    }

    public static C2461j m10764b(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams != null) {
            return layoutParams instanceof MarginLayoutParams ? new C2461j((MarginLayoutParams) layoutParams) : new C2461j(layoutParams);
        } else {
            Log.w("SuperSLiM", "Null value passed in call to LayoutManager.LayoutParams.from().");
            return new C2461j(-2, -2);
        }
    }

    private void m10765b(TypedArray typedArray, boolean z) {
        if (z) {
            this.f8014e = false;
            this.f8013d = typedArray.getDimensionPixelSize(4, 0);
            return;
        }
        this.f8014e = true;
    }

    private void m10766c(TypedArray typedArray, boolean z) {
        if (z) {
            this.f8016g = typedArray.getString(3);
            if (TextUtils.isEmpty(this.f8016g)) {
                this.f8017h = 1;
                return;
            } else {
                this.f8017h = -1;
                return;
            }
        }
        this.f8017h = typedArray.getInt(3, 1);
    }

    public void m10767a(int i) {
        if (i < 0) {
            throw new C2466k(this);
        }
        this.f8018i = i;
    }

    public void m10768b(int i) {
        this.f8017h = i;
    }

    public int m10769c() {
        return this.f8018i;
    }

    public int m10770d() {
        if (this.f8018i != -1) {
            return this.f8018i;
        }
        throw new C2467l(this);
    }

    public boolean m10771e() {
        return (this.f8011b & 4) != 0;
    }

    public boolean m10772f() {
        return (this.f8011b & 1) != 0;
    }

    public boolean m10773g() {
        return (this.f8011b & 8) != 0;
    }

    public boolean m10774h() {
        return (this.f8011b & 2) != 0;
    }

    public boolean m10775i() {
        return (this.f8011b & 16) != 0;
    }
}
