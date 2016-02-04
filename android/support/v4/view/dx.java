package android.support.v4.view;

import android.os.Bundle;
import android.support.v4.view.p017a.C0284g;
import android.support.v4.view.p017a.am;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

class dx extends C0077a {
    final /* synthetic */ ViewPager f1367a;

    dx(ViewPager viewPager) {
        this.f1367a = viewPager;
    }

    private boolean m2747a() {
        return this.f1367a.f1266h != null && this.f1367a.f1266h.m871b() > 1;
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        accessibilityEvent.setClassName(ViewPager.class.getName());
        am a = am.m1888a();
        a.m1890a(m2747a());
        if (accessibilityEvent.getEventType() == ItemAnimator.FLAG_APPEARED_IN_PRE_LAYOUT && this.f1367a.f1266h != null) {
            a.m1889a(this.f1367a.f1266h.m871b());
            a.m1891b(this.f1367a.f1267i);
            a.m1892c(this.f1367a.f1267i);
        }
    }

    public void onInitializeAccessibilityNodeInfo(View view, C0284g c0284g) {
        super.onInitializeAccessibilityNodeInfo(view, c0284g);
        c0284g.m1955b(ViewPager.class.getName());
        c0284g.m1978i(m2747a());
        if (this.f1367a.canScrollHorizontally(1)) {
            c0284g.m1946a((int) ItemAnimator.FLAG_APPEARED_IN_PRE_LAYOUT);
        }
        if (this.f1367a.canScrollHorizontally(-1)) {
            c0284g.m1946a(8192);
        }
    }

    public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        if (super.performAccessibilityAction(view, i, bundle)) {
            return true;
        }
        switch (i) {
            case ItemAnimator.FLAG_APPEARED_IN_PRE_LAYOUT /*4096*/:
                if (!this.f1367a.canScrollHorizontally(1)) {
                    return false;
                }
                this.f1367a.setCurrentItem(this.f1367a.f1267i + 1);
                return true;
            case 8192:
                if (!this.f1367a.canScrollHorizontally(-1)) {
                    return false;
                }
                this.f1367a.setCurrentItem(this.f1367a.f1267i - 1);
                return true;
            default:
                return false;
        }
    }
}
