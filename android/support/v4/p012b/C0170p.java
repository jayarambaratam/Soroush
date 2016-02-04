package android.support.v4.p012b;

import android.content.ComponentName;
import android.content.Intent;

/* renamed from: android.support.v4.b.p */
class C0170p implements C0169o {
    C0170p() {
    }

    public Intent m1537a(ComponentName componentName) {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.setComponent(componentName);
        intent.addCategory("android.intent.category.LAUNCHER");
        return intent;
    }
}
