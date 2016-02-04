package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.design.C0039c;
import android.support.design.C0069j;
import android.support.design.C0070k;
import android.support.design.internal.C0050b;
import android.support.design.internal.C0052c;
import android.support.design.internal.C0067q;
import android.support.v4.os.C0269j;
import android.support.v4.p012b.C0125h;
import android.support.v4.view.cb;
import android.support.v7.view.C0433i;
import android.support.v7.view.menu.C0448m;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import org.linphone.core.VideoSize;

public class NavigationView extends C0067q {
    private static final int[] f356a;
    private static final int[] f357b;
    private final C0050b f358c;
    private final C0052c f359d;
    private au f360e;
    private int f361f;
    private MenuInflater f362g;

    public class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR;
        public Bundle f355a;

        static {
            CREATOR = C0269j.m1809a(new av());
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            this.f355a = parcel.readBundle(classLoader);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeBundle(this.f355a);
        }
    }

    static {
        f356a = new int[]{16842912};
        f357b = new int[]{-16842910};
    }

    public NavigationView(Context context) {
        this(context, null);
    }

    public NavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationView(Context context, AttributeSet attributeSet, int i) {
        int resourceId;
        super(context, attributeSet, i);
        this.f359d = new C0052c();
        cm.m677a(context);
        this.f358c = new C0050b(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0070k.NavigationView, i, C0069j.Widget_Design_NavigationView);
        setBackgroundDrawable(obtainStyledAttributes.getDrawable(C0070k.NavigationView_android_background));
        if (obtainStyledAttributes.hasValue(C0070k.NavigationView_elevation)) {
            cb.m2432j(this, (float) obtainStyledAttributes.getDimensionPixelSize(C0070k.NavigationView_elevation, 0));
        }
        cb.m2404a((View) this, obtainStyledAttributes.getBoolean(C0070k.NavigationView_android_fitsSystemWindows, false));
        this.f361f = obtainStyledAttributes.getDimensionPixelSize(C0070k.NavigationView_android_maxWidth, 0);
        ColorStateList colorStateList = obtainStyledAttributes.hasValue(C0070k.NavigationView_itemIconTint) ? obtainStyledAttributes.getColorStateList(C0070k.NavigationView_itemIconTint) : m369c(16842808);
        if (obtainStyledAttributes.hasValue(C0070k.NavigationView_itemTextAppearance)) {
            resourceId = obtainStyledAttributes.getResourceId(C0070k.NavigationView_itemTextAppearance, 0);
            int i2 = 1;
        } else {
            resourceId = 0;
            boolean z = false;
        }
        ColorStateList colorStateList2 = null;
        if (obtainStyledAttributes.hasValue(C0070k.NavigationView_itemTextColor)) {
            colorStateList2 = obtainStyledAttributes.getColorStateList(C0070k.NavigationView_itemTextColor);
        }
        if (i2 == 0 && r5 == null) {
            colorStateList2 = m369c(16842806);
        }
        Drawable drawable = obtainStyledAttributes.getDrawable(C0070k.NavigationView_itemBackground);
        this.f358c.m101a(new at(this));
        this.f359d.m152a(1);
        this.f359d.initForMenu(context, this.f358c);
        this.f359d.m153a(colorStateList);
        if (i2 != 0) {
            this.f359d.m162c(resourceId);
        }
        this.f359d.m160b(colorStateList2);
        this.f359d.m154a(drawable);
        this.f358c.m103a(this.f359d);
        addView((View) this.f359d.m151a((ViewGroup) this));
        if (obtainStyledAttributes.hasValue(C0070k.NavigationView_menu)) {
            m370a(obtainStyledAttributes.getResourceId(C0070k.NavigationView_menu, 0));
        }
        if (obtainStyledAttributes.hasValue(C0070k.NavigationView_headerLayout)) {
            m371b(obtainStyledAttributes.getResourceId(C0070k.NavigationView_headerLayout, 0));
        }
        obtainStyledAttributes.recycle();
    }

    private ColorStateList m369c(int i) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i, typedValue, true)) {
            return null;
        }
        ColorStateList colorStateList = getResources().getColorStateList(typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(C0039c.colorPrimary, typedValue, true)) {
            return null;
        }
        int i2 = typedValue.data;
        int defaultColor = colorStateList.getDefaultColor();
        return new ColorStateList(new int[][]{f357b, f356a, EMPTY_STATE_SET}, new int[]{colorStateList.getColorForState(f357b, defaultColor), i2, defaultColor});
    }

    private MenuInflater getMenuInflater() {
        if (this.f362g == null) {
            this.f362g = new C0433i(getContext());
        }
        return this.f362g;
    }

    public void m370a(int i) {
        this.f359d.m157a(true);
        getMenuInflater().inflate(i, this.f358c);
        this.f359d.m157a(false);
        this.f359d.updateMenuView(false);
    }

    public View m371b(int i) {
        return this.f359d.m159b(i);
    }

    public int getHeaderCount() {
        return this.f359d.m150a();
    }

    public Drawable getItemBackground() {
        return this.f359d.m163d();
    }

    public ColorStateList getItemIconTintList() {
        return this.f359d.m158b();
    }

    public ColorStateList getItemTextColor() {
        return this.f359d.m161c();
    }

    public Menu getMenu() {
        return this.f358c;
    }

    protected void onMeasure(int i, int i2) {
        switch (MeasureSpec.getMode(i)) {
            case RtlSpacingHelper.UNDEFINED /*-2147483648*/:
                i = MeasureSpec.makeMeasureSpec(Math.min(MeasureSpec.getSize(i), this.f361f), 1073741824);
                break;
            case VideoSize.QCIF /*0*/:
                i = MeasureSpec.makeMeasureSpec(this.f361f, 1073741824);
                break;
        }
        super.onMeasure(i, i2);
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f358c.m112b(savedState.f355a);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f355a = new Bundle();
        this.f358c.m100a(savedState.f355a);
        return savedState;
    }

    public void setCheckedItem(int i) {
        MenuItem findItem = this.f358c.findItem(i);
        if (findItem != null) {
            this.f359d.m155a((C0448m) findItem);
        }
    }

    public void setItemBackground(Drawable drawable) {
        this.f359d.m154a(drawable);
    }

    public void setItemBackgroundResource(int i) {
        setItemBackground(C0125h.m1018a(getContext(), i));
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.f359d.m153a(colorStateList);
    }

    public void setItemTextAppearance(int i) {
        this.f359d.m162c(i);
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.f359d.m160b(colorStateList);
    }

    public void setNavigationItemSelectedListener(au auVar) {
        this.f360e = auVar;
    }
}
