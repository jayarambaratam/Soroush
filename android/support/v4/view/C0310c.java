package android.support.v4.view;

import android.support.v4.view.p017a.C0284g;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

/* renamed from: android.support.v4.view.c */
class C0310c implements C0309j {
    final /* synthetic */ C0077a f1341a;
    final /* synthetic */ C0308b f1342b;

    C0310c(C0308b c0308b, C0077a c0077a) {
        this.f1342b = c0308b;
        this.f1341a = c0077a;
    }

    public void m2373a(View view, int i) {
        this.f1341a.sendAccessibilityEvent(view, i);
    }

    public void m2374a(View view, Object obj) {
        this.f1341a.onInitializeAccessibilityNodeInfo(view, new C0284g(obj));
    }

    public boolean m2375a(View view, AccessibilityEvent accessibilityEvent) {
        return this.f1341a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public boolean m2376a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.f1341a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public void m2377b(View view, AccessibilityEvent accessibilityEvent) {
        this.f1341a.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void m2378c(View view, AccessibilityEvent accessibilityEvent) {
        this.f1341a.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public void m2379d(View view, AccessibilityEvent accessibilityEvent) {
        this.f1341a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }
}
