package android.support.v7.view;

import android.content.Context;
import android.support.v7.view.menu.C0049i;
import android.support.v7.view.menu.C0074j;
import android.support.v7.widget.ActionBarContextView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.lang.ref.WeakReference;

/* renamed from: android.support.v7.view.f */
public class C0430f extends C0378b implements C0074j {
    private Context f2057a;
    private ActionBarContextView f2058b;
    private C0376c f2059c;
    private WeakReference<View> f2060d;
    private boolean f2061e;
    private boolean f2062f;
    private C0049i f2063g;

    public C0430f(Context context, ActionBarContextView actionBarContextView, C0376c c0376c, boolean z) {
        this.f2057a = context;
        this.f2058b = actionBarContextView;
        this.f2059c = c0376c;
        this.f2063g = new C0049i(actionBarContextView.getContext()).m93a(1);
        this.f2063g.m101a((C0074j) this);
        this.f2062f = z;
    }

    public MenuInflater m3967a() {
        return new MenuInflater(this.f2058b.getContext());
    }

    public void m3968a(int i) {
        m3974b(this.f2057a.getString(i));
    }

    public void m3969a(View view) {
        this.f2058b.setCustomView(view);
        this.f2060d = view != null ? new WeakReference(view) : null;
    }

    public void m3970a(CharSequence charSequence) {
        this.f2058b.setSubtitle(charSequence);
    }

    public void m3971a(boolean z) {
        super.m3764a(z);
        this.f2058b.setTitleOptional(z);
    }

    public Menu m3972b() {
        return this.f2063g;
    }

    public void m3973b(int i) {
        m3970a(this.f2057a.getString(i));
    }

    public void m3974b(CharSequence charSequence) {
        this.f2058b.setTitle(charSequence);
    }

    public void m3975c() {
        if (!this.f2061e) {
            this.f2061e = true;
            this.f2058b.sendAccessibilityEvent(32);
            this.f2059c.m3645a(this);
        }
    }

    public void m3976d() {
        this.f2059c.m3648b(this, this.f2063g);
    }

    public CharSequence m3977f() {
        return this.f2058b.getTitle();
    }

    public CharSequence m3978g() {
        return this.f2058b.getSubtitle();
    }

    public boolean m3979h() {
        return this.f2058b.isTitleOptional();
    }

    public View m3980i() {
        return this.f2060d != null ? (View) this.f2060d.get() : null;
    }

    public boolean onMenuItemSelected(C0049i c0049i, MenuItem menuItem) {
        return this.f2059c.m3647a((C0378b) this, menuItem);
    }

    public void onMenuModeChange(C0049i c0049i) {
        m3976d();
        this.f2058b.showOverflowMenu();
    }
}
