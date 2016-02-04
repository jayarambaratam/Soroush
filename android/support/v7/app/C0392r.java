package android.support.v7.app;

import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;

/* renamed from: android.support.v7.app.r */
class C0392r implements OnClickListener {
    final /* synthetic */ C0391q f1945a;

    C0392r(C0391q c0391q) {
        this.f1945a = c0391q;
    }

    public void onClick(View view) {
        Message obtain = (view != this.f1945a.f1932n || this.f1945a.f1934p == null) ? (view != this.f1945a.f1935q || this.f1945a.f1937s == null) ? (view != this.f1945a.f1938t || this.f1945a.f1940v == null) ? null : Message.obtain(this.f1945a.f1940v) : Message.obtain(this.f1945a.f1937s) : Message.obtain(this.f1945a.f1934p);
        if (obtain != null) {
            obtain.sendToTarget();
        }
        this.f1945a.f1917M.obtainMessage(1, this.f1945a.f1920b).sendToTarget();
    }
}
