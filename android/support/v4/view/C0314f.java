package android.support.v4.view;

import android.os.Bundle;
import android.support.v4.view.p017a.C0284g;
import android.support.v4.view.p017a.C0303z;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

/* renamed from: android.support.v4.view.f */
class C0314f implements C0313m {
    final /* synthetic */ C0077a f1385a;
    final /* synthetic */ C0312e f1386b;

    C0314f(C0312e c0312e, C0077a c0077a) {
        this.f1386b = c0312e;
        this.f1385a = c0077a;
    }

    public Object m2886a(View view) {
        C0303z accessibilityNodeProvider = this.f1385a.getAccessibilityNodeProvider(view);
        return accessibilityNodeProvider != null ? accessibilityNodeProvider.m2201a() : null;
    }

    public void m2887a(View view, int i) {
        this.f1385a.sendAccessibilityEvent(view, i);
    }

    public void m2888a(View view, Object obj) {
        this.f1385a.onInitializeAccessibilityNodeInfo(view, new C0284g(obj));
    }

    public boolean m2889a(View view, int i, Bundle bundle) {
        return this.f1385a.performAccessibilityAction(view, i, bundle);
    }

    public boolean m2890a(View view, AccessibilityEvent accessibilityEvent) {
        return this.f1385a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public boolean m2891a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.f1385a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public void m2892b(View view, AccessibilityEvent accessibilityEvent) {
        this.f1385a.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void m2893c(View view, AccessibilityEvent accessibilityEvent) {
        this.f1385a.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public void m2894d(View view, AccessibilityEvent accessibilityEvent) {
        this.f1385a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }
}
