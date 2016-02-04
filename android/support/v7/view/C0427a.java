package android.support.v7.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.view.db;
import android.support.v7.p019a.C0359b;
import android.support.v7.p019a.C0360c;
import android.support.v7.p019a.C0362e;
import android.support.v7.p019a.C0365h;
import android.support.v7.p019a.C0369l;
import android.view.ViewConfiguration;

/* renamed from: android.support.v7.view.a */
public class C0427a {
    private Context f2053a;

    private C0427a(Context context) {
        this.f2053a = context;
    }

    public static C0427a m3956a(Context context) {
        return new C0427a(context);
    }

    public int m3957a() {
        return this.f2053a.getResources().getInteger(C0365h.abc_max_action_buttons);
    }

    public boolean m3958b() {
        return VERSION.SDK_INT >= 19 || !db.m2731b(ViewConfiguration.get(this.f2053a));
    }

    public int m3959c() {
        return this.f2053a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public boolean m3960d() {
        return this.f2053a.getApplicationInfo().targetSdkVersion >= 16 ? this.f2053a.getResources().getBoolean(C0360c.abc_action_bar_embed_tabs) : this.f2053a.getResources().getBoolean(C0360c.abc_action_bar_embed_tabs_pre_jb);
    }

    public int m3961e() {
        TypedArray obtainStyledAttributes = this.f2053a.obtainStyledAttributes(null, C0369l.ActionBar, C0359b.actionBarStyle, 0);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(C0369l.ActionBar_height, 0);
        Resources resources = this.f2053a.getResources();
        if (!m3960d()) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(C0362e.abc_action_bar_stacked_max_height));
        }
        obtainStyledAttributes.recycle();
        return layoutDimension;
    }

    public boolean m3962f() {
        return this.f2053a.getApplicationInfo().targetSdkVersion < 14;
    }

    public int m3963g() {
        return this.f2053a.getResources().getDimensionPixelSize(C0362e.abc_action_bar_stacked_tab_max_width);
    }
}
