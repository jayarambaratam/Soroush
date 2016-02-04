package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.StateListDrawable;
import android.support.design.C0039c;
import android.support.design.C0041e;
import android.support.design.C0043g;
import android.support.design.C0044h;
import android.support.v4.p013c.p014a.C0177a;
import android.support.v4.widget.ci;
import android.support.v7.view.menu.C0448m;
import android.support.v7.view.menu.aa;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;

public class NavigationMenuItemView extends C0046a implements aa {
    private static final int[] f203c;
    private final int f204d;
    private final CheckedTextView f205e;
    private FrameLayout f206f;
    private C0448m f207g;
    private ColorStateList f208h;

    static {
        f203c = new int[]{16842912};
    }

    public NavigationMenuItemView(Context context) {
        this(context, null);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setOrientation(0);
        LayoutInflater.from(context).inflate(C0044h.design_navigation_menu_item, this, true);
        this.f204d = context.getResources().getDimensionPixelSize(C0041e.design_navigation_icon_size);
        this.f205e = (CheckedTextView) findViewById(C0043g.design_menu_item_text);
        this.f205e.setDuplicateParentStateEnabled(true);
    }

    private StateListDrawable m77c() {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(C0039c.colorControlHighlight, typedValue, true)) {
            return null;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(f203c, new ColorDrawable(typedValue.data));
        stateListDrawable.addState(EMPTY_STATE_SET, new ColorDrawable(0));
        return stateListDrawable;
    }

    private void setActionView(View view) {
        if (this.f206f == null) {
            this.f206f = (FrameLayout) ((ViewStub) findViewById(C0043g.design_menu_item_action_area_stub)).inflate();
        }
        this.f206f.removeAllViews();
        if (view != null) {
            this.f206f.addView(view);
        }
    }

    public void m78a() {
        if (this.f206f != null) {
            this.f206f.removeAllViews();
        }
        this.f205e.setCompoundDrawables(null, null, null, null);
    }

    public void m79a(Context context, int i) {
        this.f205e.setTextAppearance(context, i);
    }

    public void m80a(C0448m c0448m, int i) {
        this.f207g = c0448m;
        setVisibility(c0448m.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            setBackgroundDrawable(m77c());
        }
        setCheckable(c0448m.isCheckable());
        setChecked(c0448m.isChecked());
        setEnabled(c0448m.isEnabled());
        setTitle(c0448m.getTitle());
        setIcon(c0448m.getIcon());
        setActionView(c0448m.getActionView());
    }

    public boolean m81b() {
        return false;
    }

    public C0448m getItemData() {
        return this.f207g;
    }

    protected int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (this.f207g != null && this.f207g.isCheckable() && this.f207g.isChecked()) {
            mergeDrawableStates(onCreateDrawableState, f203c);
        }
        return onCreateDrawableState;
    }

    public void setCheckable(boolean z) {
        refreshDrawableState();
    }

    public void setChecked(boolean z) {
        refreshDrawableState();
        this.f205e.setChecked(z);
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                drawable = constantState.newDrawable();
            }
            drawable = C0177a.m1549c(drawable).mutate();
            drawable.setBounds(0, 0, this.f204d, this.f204d);
            C0177a.m1544a(drawable, this.f208h);
        }
        ci.m3356a(this.f205e, drawable, null, null, null);
    }

    void setIconTintList(ColorStateList colorStateList) {
        this.f208h = colorStateList;
        if (this.f207g != null) {
            setIcon(this.f207g.getIcon());
        }
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.f205e.setTextColor(colorStateList);
    }

    public void setTitle(CharSequence charSequence) {
        this.f205e.setText(charSequence);
    }
}
