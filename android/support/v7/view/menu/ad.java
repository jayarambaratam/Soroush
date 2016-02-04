package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.p012b.C0125h;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public class ad extends C0049i implements SubMenu {
    private C0049i f258d;
    private C0448m f259e;

    public ad(Context context, C0049i c0049i, C0448m c0448m) {
        super(context);
        this.f258d = c0049i;
        this.f259e = c0448m;
    }

    public String m177a() {
        int itemId = this.f259e != null ? this.f259e.getItemId() : 0;
        return itemId == 0 ? null : super.m99a() + ":" + itemId;
    }

    public void m178a(C0074j c0074j) {
        this.f258d.m101a(c0074j);
    }

    boolean m179a(C0049i c0049i, MenuItem menuItem) {
        return super.m108a(c0049i, menuItem) || this.f258d.m108a(c0049i, menuItem);
    }

    public boolean m180b() {
        return this.f258d.m116b();
    }

    public boolean m181c() {
        return this.f258d.m120c();
    }

    public boolean m182c(C0448m c0448m) {
        return this.f258d.m121c(c0448m);
    }

    public boolean m183d(C0448m c0448m) {
        return this.f258d.m124d(c0448m);
    }

    public MenuItem getItem() {
        return this.f259e;
    }

    public C0049i m184p() {
        return this.f258d;
    }

    public Menu m185s() {
        return this.f258d;
    }

    public SubMenu setHeaderIcon(int i) {
        super.m94a(C0125h.m1018a(m125e(), i));
        return this;
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        super.m94a(drawable);
        return this;
    }

    public SubMenu setHeaderTitle(int i) {
        super.m96a(m125e().getResources().getString(i));
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        super.m96a(charSequence);
        return this;
    }

    public SubMenu setHeaderView(View view) {
        super.m95a(view);
        return this;
    }

    public SubMenu setIcon(int i) {
        this.f259e.setIcon(i);
        return this;
    }

    public SubMenu setIcon(Drawable drawable) {
        this.f259e.setIcon(drawable);
        return this;
    }

    public void setQwertyMode(boolean z) {
        this.f258d.setQwertyMode(z);
    }
}
