package com.cocosw.bottomsheet;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.p007d.p008a.C0199b;
import android.support.v4.p012b.C0125h;
import android.support.v4.view.C0319n;
import android.support.v4.view.bc;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;

/* renamed from: com.cocosw.bottomsheet.b */
class C0992b implements C0199b {
    private final int f3751a;
    private final int f3752b;
    private final int f3753c;
    private final int f3754d;
    private CharSequence f3755e;
    private CharSequence f3756f;
    private Intent f3757g;
    private char f3758h;
    private char f3759i;
    private Drawable f3760j;
    private int f3761k;
    private Context f3762l;
    private OnMenuItemClickListener f3763m;
    private int f3764n;

    public C0992b(Context context, int i, int i2, int i3, int i4, CharSequence charSequence) {
        this.f3761k = 0;
        this.f3764n = 16;
        this.f3762l = context;
        this.f3751a = i2;
        this.f3752b = i;
        this.f3753c = i3;
        this.f3754d = i4;
        this.f3755e = charSequence;
    }

    public C0199b m6065a(int i) {
        throw new UnsupportedOperationException();
    }

    public C0199b m6066a(bc bcVar) {
        return this;
    }

    public C0199b m6067a(C0319n c0319n) {
        throw new UnsupportedOperationException();
    }

    public C0199b m6068a(View view) {
        throw new UnsupportedOperationException();
    }

    public C0319n m6069a() {
        return null;
    }

    public C0992b m6070a(boolean z) {
        this.f3764n = (z ? 4 : 0) | (this.f3764n & -5);
        return this;
    }

    public C0199b m6071b(int i) {
        setShowAsAction(i);
        return this;
    }

    public boolean m6072b() {
        if (this.f3763m != null && this.f3763m.onMenuItemClick(this)) {
            return true;
        }
        if (this.f3757g == null) {
            return false;
        }
        this.f3762l.startActivity(this.f3757g);
        return true;
    }

    public boolean collapseActionView() {
        return false;
    }

    public boolean expandActionView() {
        return false;
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    public View getActionView() {
        return null;
    }

    public char getAlphabeticShortcut() {
        return this.f3759i;
    }

    public int getGroupId() {
        return this.f3752b;
    }

    public Drawable getIcon() {
        return this.f3760j;
    }

    public Intent getIntent() {
        return this.f3757g;
    }

    public int getItemId() {
        return this.f3751a;
    }

    public ContextMenuInfo getMenuInfo() {
        return null;
    }

    public char getNumericShortcut() {
        return this.f3758h;
    }

    public int getOrder() {
        return this.f3754d;
    }

    public SubMenu getSubMenu() {
        return null;
    }

    public CharSequence getTitle() {
        return this.f3755e;
    }

    public CharSequence getTitleCondensed() {
        return this.f3756f != null ? this.f3756f : this.f3755e;
    }

    public boolean hasSubMenu() {
        return false;
    }

    public boolean isActionViewExpanded() {
        return false;
    }

    public boolean isCheckable() {
        return (this.f3764n & 1) != 0;
    }

    public boolean isChecked() {
        return (this.f3764n & 2) != 0;
    }

    public boolean isEnabled() {
        return (this.f3764n & 16) != 0;
    }

    public boolean isVisible() {
        return (this.f3764n & 8) == 0;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    public /* synthetic */ MenuItem setActionView(int i) {
        return m6065a(i);
    }

    public /* synthetic */ MenuItem setActionView(View view) {
        return m6068a(view);
    }

    public MenuItem setAlphabeticShortcut(char c) {
        this.f3759i = c;
        return this;
    }

    public MenuItem setCheckable(boolean z) {
        this.f3764n = (z ? 1 : 0) | (this.f3764n & -2);
        return this;
    }

    public MenuItem setChecked(boolean z) {
        this.f3764n = (z ? 2 : 0) | (this.f3764n & -3);
        return this;
    }

    public MenuItem setEnabled(boolean z) {
        this.f3764n = (z ? 16 : 0) | (this.f3764n & -17);
        return this;
    }

    public MenuItem setIcon(int i) {
        this.f3761k = i;
        if (i > 0) {
            this.f3760j = C0125h.m1018a(this.f3762l, i);
        }
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.f3760j = drawable;
        this.f3761k = 0;
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.f3757g = intent;
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        this.f3758h = c;
        return this;
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.f3763m = onMenuItemClickListener;
        return this;
    }

    public MenuItem setShortcut(char c, char c2) {
        this.f3758h = c;
        this.f3759i = c2;
        return this;
    }

    public void setShowAsAction(int i) {
    }

    public /* synthetic */ MenuItem setShowAsActionFlags(int i) {
        return m6071b(i);
    }

    public MenuItem setTitle(int i) {
        this.f3755e = this.f3762l.getResources().getString(i);
        return this;
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f3755e = charSequence;
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f3756f = charSequence;
        return this;
    }

    public MenuItem setVisible(boolean z) {
        this.f3764n = (z ? 0 : 8) | (this.f3764n & 8);
        return this;
    }
}
