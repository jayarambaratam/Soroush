package android.support.v4.os;

import android.os.Bundle;

/* renamed from: android.support.v4.os.q */
class C0275q implements Runnable {
    final int f1230a;
    final Bundle f1231b;
    final /* synthetic */ ResultReceiver f1232c;

    C0275q(ResultReceiver resultReceiver, int i, Bundle bundle) {
        this.f1232c = resultReceiver;
        this.f1230a = i;
        this.f1231b = bundle;
    }

    public void run() {
        this.f1232c.m1741a(this.f1230a, this.f1231b);
    }
}
