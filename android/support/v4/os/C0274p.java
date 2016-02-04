package android.support.v4.os;

import android.os.Bundle;

/* renamed from: android.support.v4.os.p */
class C0274p extends C0266g {
    final /* synthetic */ ResultReceiver f1229a;

    C0274p(ResultReceiver resultReceiver) {
        this.f1229a = resultReceiver;
    }

    public void m1813a(int i, Bundle bundle) {
        if (this.f1229a.f1169d != null) {
            this.f1229a.f1169d.post(new C0275q(this.f1229a, i, bundle));
        } else {
            this.f1229a.m1741a(i, bundle);
        }
    }
}
