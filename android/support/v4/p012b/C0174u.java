package android.support.v4.p012b;

import android.database.ContentObserver;
import android.os.Handler;

/* renamed from: android.support.v4.b.u */
public final class C0174u extends ContentObserver {
    final /* synthetic */ C0154t f1089a;

    public C0174u(C0154t c0154t) {
        this.f1089a = c0154t;
        super(new Handler());
    }

    public boolean deliverSelfNotifications() {
        return true;
    }

    public void onChange(boolean z) {
        this.f1089a.m1481y();
    }
}
