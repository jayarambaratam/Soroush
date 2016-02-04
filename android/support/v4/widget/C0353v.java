package android.support.v4.widget;

import android.support.v4.view.C0077a;
import android.support.v4.view.p017a.C0284g;
import android.view.View;

/* renamed from: android.support.v4.widget.v */
final class C0353v extends C0077a {
    final /* synthetic */ DrawerLayout f1705a;

    C0353v(DrawerLayout drawerLayout) {
        this.f1705a = drawerLayout;
    }

    public void onInitializeAccessibilityNodeInfo(View view, C0284g c0284g) {
        super.onInitializeAccessibilityNodeInfo(view, c0284g);
        if (!DrawerLayout.m2966n(view)) {
            c0284g.m1959c(null);
        }
    }
}
