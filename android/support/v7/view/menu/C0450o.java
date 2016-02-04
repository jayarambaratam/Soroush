package android.support.v7.view.menu;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.p007d.p008a.C0199b;
import android.support.v4.view.C0319n;
import android.util.Log;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import java.lang.reflect.Method;

@TargetApi(14)
/* renamed from: android.support.v7.view.menu.o */
public class C0450o extends C0441e<C0199b> implements MenuItem {
    private Method f2204c;

    C0450o(Context context, C0199b c0199b) {
        super(context, c0199b);
    }

    C0451p m4085a(ActionProvider actionProvider) {
        return new C0451p(this, this.a, actionProvider);
    }

    public void m4086a(boolean z) {
        try {
            if (this.f2204c == null) {
                this.f2204c = ((C0199b) this.b).getClass().getDeclaredMethod("setExclusiveCheckable", new Class[]{Boolean.TYPE});
            }
            this.f2204c.invoke(this.b, new Object[]{Boolean.valueOf(z)});
        } catch (Throwable e) {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e);
        }
    }

    public boolean collapseActionView() {
        return ((C0199b) this.b).collapseActionView();
    }

    public boolean expandActionView() {
        return ((C0199b) this.b).expandActionView();
    }

    public ActionProvider getActionProvider() {
        C0319n a = ((C0199b) this.b).m1629a();
        return a instanceof C0451p ? ((C0451p) a).f2205a : null;
    }

    public View getActionView() {
        View actionView = ((C0199b) this.b).getActionView();
        return actionView instanceof C0452q ? ((C0452q) actionView).m4087a() : actionView;
    }

    public char getAlphabeticShortcut() {
        return ((C0199b) this.b).getAlphabeticShortcut();
    }

    public int getGroupId() {
        return ((C0199b) this.b).getGroupId();
    }

    public Drawable getIcon() {
        return ((C0199b) this.b).getIcon();
    }

    public Intent getIntent() {
        return ((C0199b) this.b).getIntent();
    }

    public int getItemId() {
        return ((C0199b) this.b).getItemId();
    }

    public ContextMenuInfo getMenuInfo() {
        return ((C0199b) this.b).getMenuInfo();
    }

    public char getNumericShortcut() {
        return ((C0199b) this.b).getNumericShortcut();
    }

    public int getOrder() {
        return ((C0199b) this.b).getOrder();
    }

    public SubMenu getSubMenu() {
        return m4041a(((C0199b) this.b).getSubMenu());
    }

    public CharSequence getTitle() {
        return ((C0199b) this.b).getTitle();
    }

    public CharSequence getTitleCondensed() {
        return ((C0199b) this.b).getTitleCondensed();
    }

    public boolean hasSubMenu() {
        return ((C0199b) this.b).hasSubMenu();
    }

    public boolean isActionViewExpanded() {
        return ((C0199b) this.b).isActionViewExpanded();
    }

    public boolean isCheckable() {
        return ((C0199b) this.b).isCheckable();
    }

    public boolean isChecked() {
        return ((C0199b) this.b).isChecked();
    }

    public boolean isEnabled() {
        return ((C0199b) this.b).isEnabled();
    }

    public boolean isVisible() {
        return ((C0199b) this.b).isVisible();
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        ((C0199b) this.b).m1628a(actionProvider != null ? m4085a(actionProvider) : null);
        return this;
    }

    public MenuItem setActionView(int i) {
        ((C0199b) this.b).setActionView(i);
        View actionView = ((C0199b) this.b).getActionView();
        if (actionView instanceof CollapsibleActionView) {
            ((C0199b) this.b).setActionView(new C0452q(actionView));
        }
        return this;
    }

    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new C0452q(view);
        }
        ((C0199b) this.b).setActionView(view);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c) {
        ((C0199b) this.b).setAlphabeticShortcut(c);
        return this;
    }

    public MenuItem setCheckable(boolean z) {
        ((C0199b) this.b).setCheckable(z);
        return this;
    }

    public MenuItem setChecked(boolean z) {
        ((C0199b) this.b).setChecked(z);
        return this;
    }

    public MenuItem setEnabled(boolean z) {
        ((C0199b) this.b).setEnabled(z);
        return this;
    }

    public MenuItem setIcon(int i) {
        ((C0199b) this.b).setIcon(i);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        ((C0199b) this.b).setIcon(drawable);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        ((C0199b) this.b).setIntent(intent);
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        ((C0199b) this.b).setNumericShortcut(c);
        return this;
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        ((C0199b) this.b).m1627a(onActionExpandListener != null ? new C0453r(this, onActionExpandListener) : null);
        return this;
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        ((C0199b) this.b).setOnMenuItemClickListener(onMenuItemClickListener != null ? new C0454s(this, onMenuItemClickListener) : null);
        return this;
    }

    public MenuItem setShortcut(char c, char c2) {
        ((C0199b) this.b).setShortcut(c, c2);
        return this;
    }

    public void setShowAsAction(int i) {
        ((C0199b) this.b).setShowAsAction(i);
    }

    public MenuItem setShowAsActionFlags(int i) {
        ((C0199b) this.b).setShowAsActionFlags(i);
        return this;
    }

    public MenuItem setTitle(int i) {
        ((C0199b) this.b).setTitle(i);
        return this;
    }

    public MenuItem setTitle(CharSequence charSequence) {
        ((C0199b) this.b).setTitle(charSequence);
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        ((C0199b) this.b).setTitleCondensed(charSequence);
        return this;
    }

    public MenuItem setVisible(boolean z) {
        return ((C0199b) this.b).setVisible(z);
    }
}
