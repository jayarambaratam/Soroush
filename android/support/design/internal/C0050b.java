package android.support.design.internal;

import android.content.Context;
import android.support.v7.view.menu.C0049i;
import android.support.v7.view.menu.C0448m;
import android.support.v7.view.menu.ad;
import android.view.SubMenu;

/* renamed from: android.support.design.internal.b */
public class C0050b extends C0049i {
    public C0050b(Context context) {
        super(context);
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        C0448m c0448m = (C0448m) m98a(i, i2, i3, charSequence);
        ad c0064o = new C0064o(m125e(), this, c0448m);
        c0448m.m4063a(c0064o);
        return c0064o;
    }
}
