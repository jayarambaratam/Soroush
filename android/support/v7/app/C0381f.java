package android.support.v7.app;

import android.view.View;
import android.view.View.OnClickListener;

/* renamed from: android.support.v7.app.f */
class C0381f implements OnClickListener {
    final /* synthetic */ C0380e f1879a;

    C0381f(C0380e c0380e) {
        this.f1879a = c0380e;
    }

    public void onClick(View view) {
        if (this.f1879a.f1873e) {
            this.f1879a.m3799c();
        } else if (this.f1879a.f1877i != null) {
            this.f1879a.f1877i.onClick(view);
        }
    }
}
