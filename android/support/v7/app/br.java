package android.support.v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.support.v4.view.cb;
import android.support.v7.p019a.C0359b;
import android.support.v7.p019a.C0366i;
import android.support.v7.p019a.C0368k;
import android.support.v7.view.menu.C0049i;
import android.support.v7.view.menu.C0445g;
import android.support.v7.widget.DecorToolbar;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.Toolbar.OnMenuItemClickListener;
import android.support.v7.widget.ToolbarWidgetWrapper;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.Window.Callback;
import java.util.ArrayList;

class br extends C0370a {
    private DecorToolbar f1808a;
    private boolean f1809b;
    private Callback f1810c;
    private boolean f1811d;
    private boolean f1812e;
    private ArrayList<C0377c> f1813f;
    private C0445g f1814g;
    private final Runnable f1815h;
    private final OnMenuItemClickListener f1816i;

    public br(Toolbar toolbar, CharSequence charSequence, Callback callback) {
        this.f1813f = new ArrayList();
        this.f1815h = new bs(this);
        this.f1816i = new bt(this);
        this.f1808a = new ToolbarWidgetWrapper(toolbar, false);
        this.f1810c = new bx(this, callback);
        this.f1808a.setWindowCallback(this.f1810c);
        toolbar.setOnMenuItemClickListener(this.f1816i);
        this.f1808a.setWindowTitle(charSequence);
    }

    private View m3683a(Menu menu) {
        m3686b(menu);
        return (menu == null || this.f1814g == null || this.f1814g.m4048a().getCount() <= 0) ? null : (View) this.f1814g.m4047a(this.f1808a.getViewGroup());
    }

    private void m3686b(Menu menu) {
        if (this.f1814g == null && (menu instanceof C0049i)) {
            C0049i c0049i = (C0049i) menu;
            Context context = this.f1808a.getContext();
            TypedValue typedValue = new TypedValue();
            Theme newTheme = context.getResources().newTheme();
            newTheme.setTo(context.getTheme());
            newTheme.resolveAttribute(C0359b.actionBarPopupTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            }
            newTheme.resolveAttribute(C0359b.panelMenuListTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            } else {
                newTheme.applyStyle(C0368k.Theme_AppCompat_CompactMenu, true);
            }
            Context contextThemeWrapper = new ContextThemeWrapper(context, 0);
            contextThemeWrapper.getTheme().setTo(newTheme);
            this.f1814g = new C0445g(contextThemeWrapper, C0366i.abc_list_menu_item_layout);
            this.f1814g.m4050a(new bw());
            c0049i.m103a(this.f1814g);
        }
    }

    private Menu m3689h() {
        if (!this.f1811d) {
            this.f1808a.setMenuCallbacks(new bu(), new bv());
            this.f1811d = true;
        }
        return this.f1808a.getMenu();
    }

    public int m3690a() {
        return this.f1808a.getDisplayOptions();
    }

    public void m3691a(float f) {
        cb.m2432j(this.f1808a.getViewGroup(), f);
    }

    public void m3692a(int i) {
        this.f1808a.setTitle(i != 0 ? this.f1808a.getContext().getText(i) : null);
    }

    public void m3693a(int i, int i2) {
        this.f1808a.setDisplayOptions((this.f1808a.getDisplayOptions() & (i2 ^ -1)) | (i & i2));
    }

    public void m3694a(Configuration configuration) {
        super.m3571a(configuration);
    }

    public void m3695a(Drawable drawable) {
        this.f1808a.setNavigationIcon(drawable);
    }

    public void m3696a(CharSequence charSequence) {
        this.f1808a.setTitle(charSequence);
    }

    public void m3697a(boolean z) {
        m3693a(z ? 4 : 0, 4);
    }

    public boolean m3698a(int i, KeyEvent keyEvent) {
        Menu h = m3689h();
        if (h != null) {
            h.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
            h.performShortcut(i, keyEvent, 0);
        }
        return true;
    }

    public void m3699b() {
        this.f1808a.setVisibility(8);
    }

    public void m3700b(int i) {
        this.f1808a.setNavigationIcon(i);
    }

    public void m3701b(CharSequence charSequence) {
        this.f1808a.setSubtitle(charSequence);
    }

    public void m3702b(boolean z) {
    }

    public Context m3703c() {
        return this.f1808a.getContext();
    }

    public void m3704c(int i) {
        this.f1808a.setNavigationContentDescription(i);
    }

    public void m3705c(CharSequence charSequence) {
        this.f1808a.setWindowTitle(charSequence);
    }

    public void m3706d(boolean z) {
    }

    public boolean m3707d() {
        this.f1808a.getViewGroup().removeCallbacks(this.f1815h);
        cb.m2402a(this.f1808a.getViewGroup(), this.f1815h);
        return true;
    }

    public void m3708e(boolean z) {
    }

    public boolean m3709e() {
        if (!this.f1808a.hasExpandedActionView()) {
            return false;
        }
        this.f1808a.collapseActionView();
        return true;
    }

    public Callback m3710f() {
        return this.f1810c;
    }

    public void m3711f(boolean z) {
        if (z != this.f1812e) {
            this.f1812e = z;
            int size = this.f1813f.size();
            for (int i = 0; i < size; i++) {
                ((C0377c) this.f1813f.get(i)).m3757a(z);
            }
        }
    }

    void m3712g() {
        Menu h = m3689h();
        C0049i c0049i = h instanceof C0049i ? (C0049i) h : null;
        if (c0049i != null) {
            c0049i.m127g();
        }
        try {
            h.clear();
            if (!(this.f1810c.onCreatePanelMenu(0, h) && this.f1810c.onPreparePanel(0, null, h))) {
                h.clear();
            }
            if (c0049i != null) {
                c0049i.m128h();
            }
        } catch (Throwable th) {
            if (c0049i != null) {
                c0049i.m128h();
            }
        }
    }
}
