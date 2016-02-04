package android.support.v7.view.menu;

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

/* renamed from: android.support.v7.view.menu.a */
public class C0439a implements C0199b {
    private final int f2142a;
    private final int f2143b;
    private final int f2144c;
    private final int f2145d;
    private CharSequence f2146e;
    private CharSequence f2147f;
    private Intent f2148g;
    private char f2149h;
    private char f2150i;
    private Drawable f2151j;
    private int f2152k;
    private Context f2153l;
    private OnMenuItemClickListener f2154m;
    private int f2155n;

    public C0439a(Context context, int i, int i2, int i3, int i4, CharSequence charSequence) {
        this.f2152k = 0;
        this.f2155n = 16;
        this.f2153l = context;
        this.f2142a = i2;
        this.f2143b = i;
        this.f2144c = i3;
        this.f2145d = i4;
        this.f2146e = charSequence;
    }

    public C0199b m4031a(int i) {
        throw new UnsupportedOperationException();
    }

    public C0199b m4032a(bc bcVar) {
        return this;
    }

    public C0199b m4033a(C0319n c0319n) {
        throw new UnsupportedOperationException();
    }

    public C0199b m4034a(View view) {
        throw new UnsupportedOperationException();
    }

    public C0319n m4035a() {
        return null;
    }

    public C0199b m4036b(int i) {
        setShowAsAction(i);
        return this;
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
        return this.f2150i;
    }

    public int getGroupId() {
        return this.f2143b;
    }

    public Drawable getIcon() {
        return this.f2151j;
    }

    public Intent getIntent() {
        return this.f2148g;
    }

    public int getItemId() {
        return this.f2142a;
    }

    public ContextMenuInfo getMenuInfo() {
        return null;
    }

    public char getNumericShortcut() {
        return this.f2149h;
    }

    public int getOrder() {
        return this.f2145d;
    }

    public SubMenu getSubMenu() {
        return null;
    }

    public CharSequence getTitle() {
        return this.f2146e;
    }

    public CharSequence getTitleCondensed() {
        return this.f2147f != null ? this.f2147f : this.f2146e;
    }

    public boolean hasSubMenu() {
        return false;
    }

    public boolean isActionViewExpanded() {
        return false;
    }

    public boolean isCheckable() {
        return (this.f2155n & 1) != 0;
    }

    public boolean isChecked() {
        return (this.f2155n & 2) != 0;
    }

    public boolean isEnabled() {
        return (this.f2155n & 16) != 0;
    }

    public boolean isVisible() {
        return (this.f2155n & 8) == 0;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    public /* synthetic */ MenuItem setActionView(int i) {
        return m4031a(i);
    }

    public /* synthetic */ MenuItem setActionView(View view) {
        return m4034a(view);
    }

    public MenuItem setAlphabeticShortcut(char c) {
        this.f2150i = c;
        return this;
    }

    public MenuItem setCheckable(boolean z) {
        this.f2155n = (z ? 1 : 0) | (this.f2155n & -2);
        return this;
    }

    public MenuItem setChecked(boolean z) {
        this.f2155n = (z ? 2 : 0) | (this.f2155n & -3);
        return this;
    }

    public MenuItem setEnabled(boolean z) {
        this.f2155n = (z ? 16 : 0) | (this.f2155n & -17);
        return this;
    }

    public MenuItem setIcon(int i) {
        this.f2152k = i;
        this.f2151j = C0125h.m1018a(this.f2153l, i);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.f2151j = drawable;
        this.f2152k = 0;
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.f2148g = intent;
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        this.f2149h = c;
        return this;
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.f2154m = onMenuItemClickListener;
        return this;
    }

    public MenuItem setShortcut(char c, char c2) {
        this.f2149h = c;
        this.f2150i = c2;
        return this;
    }

    public void setShowAsAction(int i) {
    }

    public /* synthetic */ MenuItem setShowAsActionFlags(int i) {
        return m4036b(i);
    }

    public MenuItem setTitle(int i) {
        this.f2146e = this.f2153l.getResources().getString(i);
        return this;
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f2146e = charSequence;
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f2147f = charSequence;
        return this;
    }

    public MenuItem setVisible(boolean z) {
        this.f2155n = (z ? 0 : 8) | (this.f2155n & 8);
        return this;
    }
}
