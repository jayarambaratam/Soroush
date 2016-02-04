package android.support.v4.view;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.p017a.C0284g;
import android.support.v4.view.p017a.C0303z;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

/* renamed from: android.support.v4.view.a */
public class C0077a {
    private static final Object DEFAULT_DELEGATE;
    private static final C0306d IMPL;
    final Object mBridge;

    static {
        if (VERSION.SDK_INT >= 16) {
            IMPL = new C0312e();
        } else if (VERSION.SDK_INT >= 14) {
            IMPL = new C0308b();
        } else {
            IMPL = new C0307g();
        }
        DEFAULT_DELEGATE = IMPL.m2269a();
    }

    public C0077a() {
        this.mBridge = IMPL.m2270a(this);
    }

    public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        return IMPL.m2274a(DEFAULT_DELEGATE, view, accessibilityEvent);
    }

    public C0303z getAccessibilityNodeProvider(View view) {
        return IMPL.m2268a(DEFAULT_DELEGATE, view);
    }

    Object getBridge() {
        return this.mBridge;
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        IMPL.m2276b(DEFAULT_DELEGATE, view, accessibilityEvent);
    }

    public void onInitializeAccessibilityNodeInfo(View view, C0284g c0284g) {
        IMPL.m2272a(DEFAULT_DELEGATE, view, c0284g);
    }

    public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        IMPL.m2277c(DEFAULT_DELEGATE, view, accessibilityEvent);
    }

    public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return IMPL.m2275a(DEFAULT_DELEGATE, viewGroup, view, accessibilityEvent);
    }

    public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        return IMPL.m2273a(DEFAULT_DELEGATE, view, i, bundle);
    }

    public void sendAccessibilityEvent(View view, int i) {
        IMPL.m2271a(DEFAULT_DELEGATE, view, i);
    }

    public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
        IMPL.m2278d(DEFAULT_DELEGATE, view, accessibilityEvent);
    }
}
