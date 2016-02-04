package mobi.mmdt.ott.view.components.imageslider.Tricks;

import android.os.Bundle;
import android.support.v4.view.C0077a;
import android.support.v4.view.p017a.C0284g;
import android.support.v4.view.p017a.am;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

/* renamed from: mobi.mmdt.ott.view.components.imageslider.Tricks.i */
class C1831i extends C0077a {
    final /* synthetic */ ViewPagerEx f5955a;

    C1831i(ViewPagerEx viewPagerEx) {
        this.f5955a = viewPagerEx;
    }

    private boolean m8914a() {
        return this.f5955a.f5919h != null && this.f5955a.f5919h.m871b() > 1;
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        accessibilityEvent.setClassName(ViewPagerEx.class.getName());
        am a = am.m1888a();
        a.m1890a(m8914a());
        if (accessibilityEvent.getEventType() == ItemAnimator.FLAG_APPEARED_IN_PRE_LAYOUT && this.f5955a.f5919h != null) {
            a.m1889a(this.f5955a.f5919h.m871b());
            a.m1891b(this.f5955a.f5920i);
            a.m1892c(this.f5955a.f5920i);
        }
    }

    public void onInitializeAccessibilityNodeInfo(View view, C0284g c0284g) {
        super.onInitializeAccessibilityNodeInfo(view, c0284g);
        c0284g.m1955b(ViewPagerEx.class.getName());
        c0284g.m1978i(m8914a());
        if (this.f5955a.canScrollHorizontally(1)) {
            c0284g.m1946a((int) ItemAnimator.FLAG_APPEARED_IN_PRE_LAYOUT);
        }
        if (this.f5955a.canScrollHorizontally(-1)) {
            c0284g.m1946a(8192);
        }
    }

    public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        if (super.performAccessibilityAction(view, i, bundle)) {
            return true;
        }
        switch (i) {
            case ItemAnimator.FLAG_APPEARED_IN_PRE_LAYOUT /*4096*/:
                if (!this.f5955a.canScrollHorizontally(1)) {
                    return false;
                }
                this.f5955a.setCurrentItem(this.f5955a.f5920i + 1);
                return true;
            case 8192:
                if (!this.f5955a.canScrollHorizontally(-1)) {
                    return false;
                }
                this.f5955a.setCurrentItem(this.f5955a.f5920i - 1);
                return true;
            default:
                return false;
        }
    }
}
