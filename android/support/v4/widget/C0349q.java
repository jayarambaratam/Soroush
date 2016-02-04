package android.support.v4.widget;

import android.database.ContentObserver;
import android.os.Handler;

/* renamed from: android.support.v4.widget.q */
class C0349q extends ContentObserver {
    final /* synthetic */ C0335o f1700a;

    public C0349q(C0335o c0335o) {
        this.f1700a = c0335o;
        super(new Handler());
    }

    public boolean deliverSelfNotifications() {
        return true;
    }

    public void onChange(boolean z) {
        this.f1700a.onContentChanged();
    }
}
