package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.p007d.p008a.C0200c;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

class ae extends ac implements SubMenu {
    ae(Context context, C0200c c0200c) {
        super(context, c0200c);
    }

    public C0200c m4045b() {
        return (C0200c) this.b;
    }

    public void clearHeader() {
        m4045b().clearHeader();
    }

    public MenuItem getItem() {
        return m4040a(m4045b().getItem());
    }

    public SubMenu setHeaderIcon(int i) {
        m4045b().setHeaderIcon(i);
        return this;
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        m4045b().setHeaderIcon(drawable);
        return this;
    }

    public SubMenu setHeaderTitle(int i) {
        m4045b().setHeaderTitle(i);
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        m4045b().setHeaderTitle(charSequence);
        return this;
    }

    public SubMenu setHeaderView(View view) {
        m4045b().setHeaderView(view);
        return this;
    }

    public SubMenu setIcon(int i) {
        m4045b().setIcon(i);
        return this;
    }

    public SubMenu setIcon(Drawable drawable) {
        m4045b().setIcon(drawable);
        return this;
    }
}
