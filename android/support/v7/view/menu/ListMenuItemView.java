package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.p019a.C0364g;
import android.support.v7.p019a.C0366i;
import android.support.v7.p019a.C0369l;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

public class ListMenuItemView extends LinearLayout implements aa {
    private C0448m f2128a;
    private ImageView f2129b;
    private RadioButton f2130c;
    private TextView f2131d;
    private CheckBox f2132e;
    private TextView f2133f;
    private Drawable f2134g;
    private int f2135h;
    private Context f2136i;
    private boolean f2137j;
    private int f2138k;
    private Context f2139l;
    private LayoutInflater f2140m;
    private boolean f2141n;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.f2139l = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0369l.MenuView, i, 0);
        this.f2134g = obtainStyledAttributes.getDrawable(C0369l.MenuView_android_itemBackground);
        this.f2135h = obtainStyledAttributes.getResourceId(C0369l.MenuView_android_itemTextAppearance, -1);
        this.f2137j = obtainStyledAttributes.getBoolean(C0369l.MenuView_preserveIconSpacing, false);
        this.f2136i = context;
        obtainStyledAttributes.recycle();
    }

    private void m4025a() {
        this.f2129b = (ImageView) getInflater().inflate(C0366i.abc_list_menu_item_icon, this, false);
        addView(this.f2129b, 0);
    }

    private void m4026c() {
        this.f2130c = (RadioButton) getInflater().inflate(C0366i.abc_list_menu_item_radio, this, false);
        addView(this.f2130c);
    }

    private void m4027d() {
        this.f2132e = (CheckBox) getInflater().inflate(C0366i.abc_list_menu_item_checkbox, this, false);
        addView(this.f2132e);
    }

    private LayoutInflater getInflater() {
        if (this.f2140m == null) {
            this.f2140m = LayoutInflater.from(this.f2139l);
        }
        return this.f2140m;
    }

    public void m4028a(C0448m c0448m, int i) {
        this.f2128a = c0448m;
        this.f2138k = i;
        setVisibility(c0448m.isVisible() ? 0 : 8);
        setTitle(c0448m.m4062a((aa) this));
        setCheckable(c0448m.isCheckable());
        m4029a(c0448m.m4075f(), c0448m.m4071d());
        setIcon(c0448m.getIcon());
        setEnabled(c0448m.isEnabled());
    }

    public void m4029a(boolean z, char c) {
        int i = (z && this.f2128a.m4075f()) ? 0 : 8;
        if (i == 0) {
            this.f2133f.setText(this.f2128a.m4073e());
        }
        if (this.f2133f.getVisibility() != i) {
            this.f2133f.setVisibility(i);
        }
    }

    public boolean m4030b() {
        return false;
    }

    public C0448m getItemData() {
        return this.f2128a;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        setBackgroundDrawable(this.f2134g);
        this.f2131d = (TextView) findViewById(C0364g.title);
        if (this.f2135h != -1) {
            this.f2131d.setTextAppearance(this.f2136i, this.f2135h);
        }
        this.f2133f = (TextView) findViewById(C0364g.shortcut);
    }

    protected void onMeasure(int i, int i2) {
        if (this.f2129b != null && this.f2137j) {
            LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f2129b.getLayoutParams();
            if (layoutParams.height > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = layoutParams.height;
            }
        }
        super.onMeasure(i, i2);
    }

    public void setCheckable(boolean z) {
        if (z || this.f2130c != null || this.f2132e != null) {
            CompoundButton compoundButton;
            CompoundButton compoundButton2;
            if (this.f2128a.m4076g()) {
                if (this.f2130c == null) {
                    m4026c();
                }
                compoundButton = this.f2130c;
                compoundButton2 = this.f2132e;
            } else {
                if (this.f2132e == null) {
                    m4027d();
                }
                compoundButton = this.f2132e;
                compoundButton2 = this.f2130c;
            }
            if (z) {
                compoundButton.setChecked(this.f2128a.isChecked());
                int i = z ? 0 : 8;
                if (compoundButton.getVisibility() != i) {
                    compoundButton.setVisibility(i);
                }
                if (compoundButton2 != null && compoundButton2.getVisibility() != 8) {
                    compoundButton2.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.f2132e != null) {
                this.f2132e.setVisibility(8);
            }
            if (this.f2130c != null) {
                this.f2130c.setVisibility(8);
            }
        }
    }

    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if (this.f2128a.m4076g()) {
            if (this.f2130c == null) {
                m4026c();
            }
            compoundButton = this.f2130c;
        } else {
            if (this.f2132e == null) {
                m4027d();
            }
            compoundButton = this.f2132e;
        }
        compoundButton.setChecked(z);
    }

    public void setForceShowIcon(boolean z) {
        this.f2141n = z;
        this.f2137j = z;
    }

    public void setIcon(Drawable drawable) {
        int i = (this.f2128a.m4078i() || this.f2141n) ? 1 : 0;
        if (i == 0 && !this.f2137j) {
            return;
        }
        if (this.f2129b != null || drawable != null || this.f2137j) {
            if (this.f2129b == null) {
                m4025a();
            }
            if (drawable != null || this.f2137j) {
                ImageView imageView = this.f2129b;
                if (i == 0) {
                    drawable = null;
                }
                imageView.setImageDrawable(drawable);
                if (this.f2129b.getVisibility() != 0) {
                    this.f2129b.setVisibility(0);
                    return;
                }
                return;
            }
            this.f2129b.setVisibility(8);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.f2131d.setText(charSequence);
            if (this.f2131d.getVisibility() != 0) {
                this.f2131d.setVisibility(0);
            }
        } else if (this.f2131d.getVisibility() != 8) {
            this.f2131d.setVisibility(8);
        }
    }
}
