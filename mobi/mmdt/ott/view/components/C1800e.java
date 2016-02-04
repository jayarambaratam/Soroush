package mobi.mmdt.ott.view.components;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.support.v7.p009c.C0412e;
import android.support.v7.p009c.C0417k;

/* renamed from: mobi.mmdt.ott.view.components.e */
class C1800e implements C0417k {
    final /* synthetic */ C1799d f5789a;

    C1800e(C1799d c1799d) {
        this.f5789a = c1799d;
    }

    public void m8761a(C0412e c0412e) {
        int a = c0412e.m3936a(this.f5789a.f5788b.getResources().getColor(2131623982));
        this.f5789a.f5788b.f5619k.setContentScrimColor(a);
        this.f5789a.f5788b.m8489a(this.f5789a.f5788b.getWindow(), a);
        a = Color.argb(255, Color.red(a), Color.green(a), Color.blue(a));
        this.f5789a.f5788b.f5623o.setBackgroundDrawable(new GradientDrawable(Orientation.TOP_BOTTOM, new int[]{a, 0}));
    }
}
