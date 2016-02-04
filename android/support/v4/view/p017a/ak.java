package android.support.v4.view.p017a;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

/* renamed from: android.support.v4.view.a.ak */
final class ak extends AccessibilityNodeProvider {
    final /* synthetic */ al f1291a;

    ak(al alVar) {
        this.f1291a = alVar;
    }

    public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
        return (AccessibilityNodeInfo) this.f1291a.m1878a(i);
    }

    public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
        return this.f1291a.m1879a(str, i);
    }

    public AccessibilityNodeInfo findFocus(int i) {
        return (AccessibilityNodeInfo) this.f1291a.m1881b(i);
    }

    public boolean performAction(int i, int i2, Bundle bundle) {
        return this.f1291a.m1880a(i, i2, bundle);
    }
}
