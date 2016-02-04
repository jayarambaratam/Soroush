package android.support.v4.view.p017a;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

/* renamed from: android.support.v4.view.a.ah */
final class ah extends AccessibilityNodeProvider {
    final /* synthetic */ ai f1290a;

    ah(ai aiVar) {
        this.f1290a = aiVar;
    }

    public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
        return (AccessibilityNodeInfo) this.f1290a.m1871a(i);
    }

    public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
        return this.f1290a.m1872a(str, i);
    }

    public boolean performAction(int i, int i2, Bundle bundle) {
        return this.f1290a.m1873a(i, i2, bundle);
    }
}
