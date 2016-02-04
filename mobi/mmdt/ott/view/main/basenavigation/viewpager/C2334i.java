package mobi.mmdt.ott.view.main.basenavigation.viewpager;

import android.os.Bundle;
import android.support.v4.view.C0077a;
import android.support.v4.view.ViewPager;
import android.support.v4.view.p017a.C0284g;
import android.support.v4.view.p017a.am;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

/* renamed from: mobi.mmdt.ott.view.main.basenavigation.viewpager.i */
class C2334i extends C0077a {
    final /* synthetic */ VerticalViewPager f7727a;

    C2334i(VerticalViewPager verticalViewPager) {
        this.f7727a = verticalViewPager;
    }

    private boolean m10497a() {
        return this.f7727a.f7692h != null && this.f7727a.f7692h.m871b() > 1;
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        accessibilityEvent.setClassName(ViewPager.class.getName());
        am a = am.m1888a();
        a.m1890a(m10497a());
        if (accessibilityEvent.getEventType() == ItemAnimator.FLAG_APPEARED_IN_PRE_LAYOUT && this.f7727a.f7692h != null) {
            a.m1889a(this.f7727a.f7692h.m871b());
            a.m1891b(this.f7727a.f7693i);
            a.m1892c(this.f7727a.f7693i);
        }
    }

    public void onInitializeAccessibilityNodeInfo(View view, C0284g c0284g) {
        super.onInitializeAccessibilityNodeInfo(view, c0284g);
        c0284g.m1955b(ViewPager.class.getName());
        c0284g.m1978i(m10497a());
        if (this.f7727a.m10492c(1)) {
            c0284g.m1946a((int) ItemAnimator.FLAG_APPEARED_IN_PRE_LAYOUT);
        }
        if (this.f7727a.m10492c(-1)) {
            c0284g.m1946a(8192);
        }
    }

    public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        if (super.performAccessibilityAction(view, i, bundle)) {
            return true;
        }
        switch (i) {
            case ItemAnimator.FLAG_APPEARED_IN_PRE_LAYOUT /*4096*/:
                if (!this.f7727a.m10492c(1)) {
                    return false;
                }
                this.f7727a.setCurrentItem(this.f7727a.f7693i + 1);
                return true;
            case 8192:
                if (!this.f7727a.m10492c(-1)) {
                    return false;
                }
                this.f7727a.setCurrentItem(this.f7727a.f7693i - 1);
                return true;
            default:
                return false;
        }
    }
}
