package android.support.v4.widget;

import android.os.Bundle;
import android.support.v4.view.C0077a;
import android.support.v4.view.p017a.C0278a;
import android.support.v4.view.p017a.C0284g;
import android.support.v4.view.p017a.am;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.ScrollView;

class au extends C0077a {
    au() {
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        NestedScrollView nestedScrollView = (NestedScrollView) view;
        accessibilityEvent.setClassName(ScrollView.class.getName());
        am a = C0278a.m1865a(accessibilityEvent);
        a.m1890a(nestedScrollView.getScrollRange() > 0);
        a.m1893d(nestedScrollView.getScrollX());
        a.m1894e(nestedScrollView.getScrollY());
        a.m1895f(nestedScrollView.getScrollX());
        a.m1896g(nestedScrollView.getScrollRange());
    }

    public void onInitializeAccessibilityNodeInfo(View view, C0284g c0284g) {
        super.onInitializeAccessibilityNodeInfo(view, c0284g);
        NestedScrollView nestedScrollView = (NestedScrollView) view;
        c0284g.m1955b(ScrollView.class.getName());
        if (nestedScrollView.isEnabled()) {
            int a = nestedScrollView.getScrollRange();
            if (a > 0) {
                c0284g.m1978i(true);
                if (nestedScrollView.getScrollY() > 0) {
                    c0284g.m1946a(8192);
                }
                if (nestedScrollView.getScrollY() < a) {
                    c0284g.m1946a((int) ItemAnimator.FLAG_APPEARED_IN_PRE_LAYOUT);
                }
            }
        }
    }

    public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        if (super.performAccessibilityAction(view, i, bundle)) {
            return true;
        }
        NestedScrollView nestedScrollView = (NestedScrollView) view;
        if (!nestedScrollView.isEnabled()) {
            return false;
        }
        int min;
        switch (i) {
            case ItemAnimator.FLAG_APPEARED_IN_PRE_LAYOUT /*4096*/:
                min = Math.min(((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()) + nestedScrollView.getScrollY(), nestedScrollView.getScrollRange());
                if (min == nestedScrollView.getScrollY()) {
                    return false;
                }
                nestedScrollView.m3019b(0, min);
                return true;
            case 8192:
                min = Math.max(nestedScrollView.getScrollY() - ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                if (min == nestedScrollView.getScrollY()) {
                    return false;
                }
                nestedScrollView.m3019b(0, min);
                return true;
            default:
                return false;
        }
    }
}
