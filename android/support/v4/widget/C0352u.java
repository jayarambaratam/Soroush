package android.support.v4.widget;

import android.graphics.Rect;
import android.support.v4.view.C0077a;
import android.support.v4.view.cb;
import android.support.v4.view.p017a.C0284g;
import android.support.v4.view.p017a.C0285h;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

/* renamed from: android.support.v4.widget.u */
class C0352u extends C0077a {
    final /* synthetic */ DrawerLayout f1703a;
    private final Rect f1704b;

    C0352u(DrawerLayout drawerLayout) {
        this.f1703a = drawerLayout;
        this.f1704b = new Rect();
    }

    private void m3434a(C0284g c0284g, C0284g c0284g2) {
        Rect rect = this.f1704b;
        c0284g2.m1947a(rect);
        c0284g.m1953b(rect);
        c0284g2.m1958c(rect);
        c0284g.m1964d(rect);
        c0284g.m1962c(c0284g2.m1975g());
        c0284g.m1949a(c0284g2.m1986o());
        c0284g.m1955b(c0284g2.m1987p());
        c0284g.m1966d(c0284g2.m1989r());
        c0284g.m1976h(c0284g2.m1983l());
        c0284g.m1972f(c0284g2.m1981j());
        c0284g.m1950a(c0284g2.m1971e());
        c0284g.m1957b(c0284g2.m1973f());
        c0284g.m1967d(c0284g2.m1977h());
        c0284g.m1970e(c0284g2.m1979i());
        c0284g.m1974g(c0284g2.m1982k());
        c0284g.m1946a(c0284g2.m1952b());
    }

    private void m3435a(C0284g c0284g, ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (DrawerLayout.m2966n(childAt)) {
                c0284g.m1954b(childAt);
            }
        }
    }

    public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() != 32) {
            return super.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
        }
        List text = accessibilityEvent.getText();
        View a = this.f1703a.m2963k();
        if (a != null) {
            CharSequence a2 = this.f1703a.m2969a(this.f1703a.m2984e(a));
            if (a2 != null) {
                text.add(a2);
            }
        }
        return true;
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        accessibilityEvent.setClassName(DrawerLayout.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(View view, C0284g c0284g) {
        if (DrawerLayout.f1425c) {
            super.onInitializeAccessibilityNodeInfo(view, c0284g);
        } else {
            C0284g a = C0284g.m1941a(c0284g);
            super.onInitializeAccessibilityNodeInfo(view, a);
            c0284g.m1948a(view);
            ViewParent i = cb.m2430i(view);
            if (i instanceof View) {
                c0284g.m1959c((View) i);
            }
            m3434a(c0284g, a);
            a.m1990s();
            m3435a(c0284g, (ViewGroup) view);
        }
        c0284g.m1955b(DrawerLayout.class.getName());
        c0284g.m1950a(false);
        c0284g.m1957b(false);
        c0284g.m1951a(C0285h.f1296a);
        c0284g.m1951a(C0285h.f1297b);
    }

    public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return (DrawerLayout.f1425c || DrawerLayout.m2966n(view)) ? super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent) : false;
    }
}
