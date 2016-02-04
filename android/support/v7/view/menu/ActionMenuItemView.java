package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.cb;
import android.support.v7.p019a.C0360c;
import android.support.v7.p019a.C0369l;
import android.support.v7.widget.ActionMenuView.ActionMenuChildView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.ListPopupWindow.ForwardingListener;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Toast;

public class ActionMenuItemView extends AppCompatTextView implements aa, ActionMenuChildView, OnClickListener, OnLongClickListener {
    private C0448m f2114a;
    private CharSequence f2115b;
    private Drawable f2116c;
    private C0438k f2117d;
    private ForwardingListener f2118e;
    private C0443c f2119f;
    private boolean f2120g;
    private boolean f2121h;
    private int f2122i;
    private int f2123j;
    private int f2124k;

    public ActionMenuItemView(Context context) {
        this(context, null);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Resources resources = context.getResources();
        this.f2120g = resources.getBoolean(C0360c.abc_config_allowActionMenuItemTextWithIcon);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0369l.ActionMenuItemView, i, 0);
        this.f2122i = obtainStyledAttributes.getDimensionPixelSize(C0369l.ActionMenuItemView_android_minWidth, 0);
        obtainStyledAttributes.recycle();
        this.f2124k = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        setOnLongClickListener(this);
        this.f2123j = -1;
    }

    private void m4021c() {
        int i = 0;
        int i2 = !TextUtils.isEmpty(this.f2115b) ? 1 : 0;
        if (this.f2116c == null || (this.f2114a.m4082m() && (this.f2120g || this.f2121h))) {
            i = 1;
        }
        setText((i2 & i) != 0 ? this.f2115b : null);
    }

    public void m4022a(C0448m c0448m, int i) {
        this.f2114a = c0448m;
        setIcon(c0448m.getIcon());
        setTitle(c0448m.m4062a((aa) this));
        setId(c0448m.getItemId());
        setVisibility(c0448m.isVisible() ? 0 : 8);
        setEnabled(c0448m.isEnabled());
        if (c0448m.hasSubMenu() && this.f2118e == null) {
            this.f2118e = new C0442b(this);
        }
    }

    public boolean m4023a() {
        return !TextUtils.isEmpty(getText());
    }

    public boolean m4024b() {
        return true;
    }

    public C0448m getItemData() {
        return this.f2114a;
    }

    public boolean needsDividerAfter() {
        return m4023a();
    }

    public boolean needsDividerBefore() {
        return m4023a() && this.f2114a.getIcon() == null;
    }

    public void onClick(View view) {
        if (this.f2117d != null) {
            this.f2117d.invokeItem(this.f2114a);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        this.f2120g = getContext().getResources().getBoolean(C0360c.abc_config_allowActionMenuItemTextWithIcon);
        m4021c();
    }

    public boolean onLongClick(View view) {
        if (m4023a()) {
            return false;
        }
        int[] iArr = new int[2];
        Rect rect = new Rect();
        getLocationOnScreen(iArr);
        getWindowVisibleDisplayFrame(rect);
        Context context = getContext();
        int width = getWidth();
        int height = getHeight();
        int i = iArr[1] + (height / 2);
        width = (width / 2) + iArr[0];
        if (cb.m2428h(view) == 0) {
            width = context.getResources().getDisplayMetrics().widthPixels - width;
        }
        Toast makeText = Toast.makeText(context, this.f2114a.getTitle(), 0);
        if (i < rect.height()) {
            makeText.setGravity(8388661, width, (iArr[1] + height) - rect.top);
        } else {
            makeText.setGravity(81, 0, height);
        }
        makeText.show();
        return true;
    }

    protected void onMeasure(int i, int i2) {
        boolean a = m4023a();
        if (a && this.f2123j >= 0) {
            super.setPadding(this.f2123j, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i, i2);
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int measuredWidth = getMeasuredWidth();
        size = mode == RtlSpacingHelper.UNDEFINED ? Math.min(size, this.f2122i) : this.f2122i;
        if (mode != 1073741824 && this.f2122i > 0 && measuredWidth < size) {
            super.onMeasure(MeasureSpec.makeMeasureSpec(size, 1073741824), i2);
        }
        if (!a && this.f2116c != null) {
            super.setPadding((getMeasuredWidth() - this.f2116c.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return (this.f2114a.hasSubMenu() && this.f2118e != null && this.f2118e.onTouch(this, motionEvent)) ? true : super.onTouchEvent(motionEvent);
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }

    public void setExpandedFormat(boolean z) {
        if (this.f2121h != z) {
            this.f2121h = z;
            if (this.f2114a != null) {
                this.f2114a.m4077h();
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.f2116c = drawable;
        if (drawable != null) {
            float f;
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > this.f2124k) {
                f = ((float) this.f2124k) / ((float) intrinsicWidth);
                intrinsicWidth = this.f2124k;
                intrinsicHeight = (int) (((float) intrinsicHeight) * f);
            }
            if (intrinsicHeight > this.f2124k) {
                f = ((float) this.f2124k) / ((float) intrinsicHeight);
                intrinsicHeight = this.f2124k;
                intrinsicWidth = (int) (((float) intrinsicWidth) * f);
            }
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        }
        setCompoundDrawables(drawable, null, null, null);
        m4021c();
    }

    public void setItemInvoker(C0438k c0438k) {
        this.f2117d = c0438k;
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        this.f2123j = i;
        super.setPadding(i, i2, i3, i4);
    }

    public void setPopupCallback(C0443c c0443c) {
        this.f2119f = c0443c;
    }

    public void setTitle(CharSequence charSequence) {
        this.f2115b = charSequence;
        setContentDescription(this.f2115b);
        m4021c();
    }
}
