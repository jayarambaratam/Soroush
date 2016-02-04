package com.cocosw.bottomsheet;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.util.DisplayMetrics;
import android.util.SparseIntArray;
import android.view.Menu;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import mobi.mmdt.componentsutils.view.roundavatarimageview.RoundAvatarImageView;

/* renamed from: com.cocosw.bottomsheet.c */
public class C0993c extends Dialog implements DialogInterface {
    private String f3765a;
    private Drawable f3766b;
    private Drawable f3767c;
    private boolean f3768d;
    private int f3769e;
    private GridView f3770f;
    private C1013w f3771g;
    private C1003l f3772h;
    private final SparseIntArray f3773i;
    private boolean f3774j;
    private String f3775k;
    private boolean f3776l;
    private float f3777m;
    private RoundAvatarImageView f3778n;
    private int f3779o;
    private boolean f3780p;
    private boolean f3781q;
    private C0991a f3782r;
    private C0991a f3783s;
    private C0991a f3784t;
    private OnDismissListener f3785u;

    C0993c(Context context, int i) {
        super(context, i);
        this.f3773i = new SparseIntArray();
        this.f3779o = -1;
        this.f3780p = true;
        this.f3781q = true;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, C1012v.BottomSheet, C1008r.bottomSheetStyle, 0);
        try {
            this.f3767c = obtainStyledAttributes.getDrawable(C1012v.BottomSheet_bs_moreDrawable);
            this.f3766b = obtainStyledAttributes.getDrawable(C1012v.BottomSheet_bs_closeDrawable);
            this.f3765a = obtainStyledAttributes.getString(C1012v.BottomSheet_bs_moreText);
            this.f3768d = obtainStyledAttributes.getBoolean(C1012v.BottomSheet_bs_collapseListIcons, true);
            if (VERSION.SDK_INT >= 19) {
                WindowManager windowManager = (WindowManager) context.getSystemService("window");
                this.f3774j = context.getResources().getConfiguration().orientation == 1;
                try {
                    Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", new Class[]{String.class});
                    declaredMethod.setAccessible(true);
                    this.f3775k = (String) declaredMethod.invoke(null, new Object[]{"qemu.hw.mainkeys"});
                } catch (Throwable th) {
                    this.f3775k = null;
                }
                obtainStyledAttributes = context.obtainStyledAttributes(new int[]{16843760});
                try {
                    this.f3776l = obtainStyledAttributes.getBoolean(0, false);
                    if ((((Activity) context).getWindow().getAttributes().flags & 134217728) != 0) {
                        this.f3776l = true;
                    }
                    this.f3777m = m6073a(windowManager);
                    if (this.f3776l) {
                        m6078a(true);
                    }
                    this.f3769e = m6075a(context.getResources(), "status_bar_height");
                } finally {
                    obtainStyledAttributes.recycle();
                }
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @SuppressLint({"NewApi"})
    private float m6073a(WindowManager windowManager) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (VERSION.SDK_INT >= 16) {
            windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        } else {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        }
        return Math.min(((float) displayMetrics.widthPixels) / displayMetrics.density, ((float) displayMetrics.heightPixels) / displayMetrics.density);
    }

    @TargetApi(14)
    private int m6074a(Context context) {
        Resources resources = context.getResources();
        if (VERSION.SDK_INT < 14 || !m6081b(context)) {
            return 0;
        }
        String str;
        if (this.f3774j) {
            str = "navigation_bar_height";
        } else if (!m6080b()) {
            return 0;
        } else {
            str = "navigation_bar_height_landscape";
        }
        return m6075a(resources, str);
    }

    private int m6075a(Resources resources, String str) {
        int identifier = resources.getIdentifier(str, "dimen", "android");
        return identifier > 0 ? resources.getDimensionPixelSize(identifier) : 0;
    }

    @TargetApi(19)
    private void m6078a(boolean z) {
        Window window = getWindow();
        LayoutParams attributes = window.getAttributes();
        if (z) {
            attributes.flags |= 67108864;
        } else {
            attributes.flags &= -67108865;
        }
        window.setAttributes(attributes);
        window.setFlags(134217728, 134217728);
    }

    private boolean m6080b() {
        return this.f3777m >= 600.0f || this.f3774j;
    }

    @TargetApi(14)
    private boolean m6081b(Context context) {
        boolean z = true;
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
        if (identifier != 0) {
            return "1".equals(this.f3775k) ? false : "0".equals(this.f3775k) ? true : resources.getBoolean(identifier);
        } else {
            if (ViewConfiguration.get(context).hasPermanentMenuKey()) {
                z = false;
            }
            return z;
        }
    }

    private int m6082c() {
        int i = 1;
        try {
            Field declaredField = GridView.class.getDeclaredField("mRequestedNumColumns");
            declaredField.setAccessible(true);
            i = declaredField.getInt(this.f3770f);
        } catch (Exception e) {
        }
        return i;
    }

    private void m6084c(Context context) {
        setCanceledOnTouchOutside(this.f3780p);
        ClosableSlidingLayout closableSlidingLayout = (ClosableSlidingLayout) View.inflate(context, C1010t.bottom_sheet_dialog, null);
        setContentView(closableSlidingLayout);
        if (!this.f3781q) {
            closableSlidingLayout.f3731b = this.f3781q;
        }
        closableSlidingLayout.m6053a(new C0995d(this));
        setOnShowListener(new C0996e(this));
        int[] iArr = new int[2];
        closableSlidingLayout.getLocationOnScreen(iArr);
        if (VERSION.SDK_INT >= 19) {
            closableSlidingLayout.setPadding(0, iArr[0] == 0 ? this.f3769e : 0, 0, 0);
            closableSlidingLayout.getChildAt(0).setPadding(0, 0, 0, this.f3776l ? m6074a(getContext()) + closableSlidingLayout.getPaddingBottom() : 0);
        }
        TextView textView = (TextView) closableSlidingLayout.findViewById(C1009s.bottom_sheet_title);
        if (this.f3772h.f3800d != null) {
            textView.setVisibility(0);
            textView.setText(this.f3772h.f3800d);
        }
        this.f3778n = (RoundAvatarImageView) closableSlidingLayout.findViewById(C1009s.bottom_sheet_title_image);
        this.f3770f = (GridView) closableSlidingLayout.findViewById(C1009s.bottom_sheet_gridview);
        closableSlidingLayout.f3730a = this.f3770f;
        if (this.f3772h.f3801e) {
            this.f3770f.setNumColumns(this.f3772h.f3802f);
        } else {
            this.f3770f.setNumColumns(1);
        }
        if (this.f3772h.f3801e) {
            for (int i = 0; i < m6098a().size(); i++) {
                if (m6098a().getItem(i).getIcon() == null) {
                    throw new IllegalArgumentException("You must set titleIcon for each items in grid style");
                }
            }
        }
        if (this.f3772h.f3808l > 0) {
            this.f3779o = this.f3772h.f3808l * m6082c();
        } else {
            this.f3779o = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
        closableSlidingLayout.m6054a(false);
        this.f3784t = this.f3772h.f3799c;
        this.f3783s = this.f3784t;
        if (m6098a().size() > this.f3779o) {
            this.f3782r = this.f3772h.f3799c;
            this.f3783s = this.f3772h.f3799c.m6063a(this.f3779o - 1);
            C0992b c0992b = new C0992b(context, 0, C1009s.bs_more, 0, this.f3779o - 1, this.f3765a);
            c0992b.setIcon(this.f3767c);
            this.f3783s.m6062a(c0992b);
            this.f3784t = this.f3783s;
            closableSlidingLayout.m6054a(true);
        }
        this.f3771g = new C1013w(context, new C0997f(this), C1010t.bs_list_divider, C1009s.headerlayout, C1009s.header);
        this.f3770f.setAdapter(this.f3771g);
        this.f3771g.m6136a(this.f3770f);
        m6086d();
        this.f3770f.setOnItemClickListener(new C0999h(this, closableSlidingLayout));
        if (this.f3772h.f3804h != null) {
            setOnDismissListener(this.f3772h.f3804h);
        }
        m6093h();
    }

    private void m6086d() {
        int i = 0;
        this.f3784t.m6064b();
        if (!this.f3772h.f3801e && this.f3784t.size() > 0) {
            int groupId = this.f3784t.getItem(0).getGroupId();
            ArrayList arrayList = new ArrayList();
            while (i < this.f3784t.size()) {
                if (this.f3784t.getItem(i).getGroupId() != groupId) {
                    groupId = this.f3784t.getItem(i).getGroupId();
                    arrayList.add(new C1016z(i, null));
                }
                i++;
            }
            if (arrayList.size() > 0) {
                C1016z[] c1016zArr = new C1016z[arrayList.size()];
                arrayList.toArray(c1016zArr);
                this.f3771g.m6137a(c1016zArr);
                return;
            }
            this.f3771g.f3812a.clear();
        }
    }

    private void m6088e() {
        if (VERSION.SDK_INT >= 19) {
            Transition changeBounds = new ChangeBounds();
            changeBounds.setDuration(300);
            TransitionManager.beginDelayedTransition(this.f3770f, changeBounds);
        }
        this.f3784t = this.f3782r;
        m6086d();
        this.f3771g.notifyDataSetChanged();
        this.f3770f.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.f3778n.setVisibility(0);
        this.f3778n.setImageDrawable(this.f3766b);
        this.f3778n.setOnClickListener(new C1000i(this));
        m6093h();
    }

    private void m6090f() {
        this.f3784t = this.f3783s;
        m6086d();
        this.f3771g.notifyDataSetChanged();
        m6093h();
        if (this.f3772h.f3805i != null) {
            this.f3778n.setVisibility(0);
            this.f3778n.setImageDrawable(this.f3772h.f3805i);
        } else if (this.f3772h.f3806j != null) {
            this.f3778n.setVisibility(0);
            this.f3778n.setName(this.f3772h.f3806j);
            this.f3778n.setBackgroundColor(this.f3772h.f3807k);
        } else {
            this.f3778n.setVisibility(8);
        }
    }

    private boolean m6092g() {
        return this.f3771g.f3812a.size() > 0;
    }

    private void m6093h() {
        if (m6092g()) {
            this.f3770f.getViewTreeObserver().addOnGlobalLayoutListener(new C1001j(this));
        }
    }

    public Menu m6098a() {
        return this.f3772h.f3799c;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m6084c(getContext());
        LayoutParams attributes = getWindow().getAttributes();
        attributes.height = -2;
        attributes.gravity = 80;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{16842996});
        try {
            attributes.width = obtainStyledAttributes.getLayoutDimension(0, -1);
            super.setOnDismissListener(new C1002k(this));
            getWindow().setAttributes(attributes);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public void setCanceledOnTouchOutside(boolean z) {
        super.setCanceledOnTouchOutside(z);
        this.f3780p = z;
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        this.f3785u = onDismissListener;
    }
}
