package mobi.mmdt.ott.view.components.p181b;

import android.database.ContentObserver;
import android.os.Handler;

/* renamed from: mobi.mmdt.ott.view.components.b.o */
class C1794o extends ContentObserver {
    final /* synthetic */ C1785m f5784a;

    public C1794o(C1785m c1785m) {
        this.f5784a = c1785m;
        super(new Handler());
    }

    public boolean deliverSelfNotifications() {
        return true;
    }

    public void onChange(boolean z) {
        this.f5784a.m8749c();
    }
}
