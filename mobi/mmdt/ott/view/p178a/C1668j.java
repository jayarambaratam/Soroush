package mobi.mmdt.ott.view.p178a;

import android.app.Activity;
import android.content.Intent;

/* renamed from: mobi.mmdt.ott.view.a.j */
final class C1668j implements Runnable {
    final /* synthetic */ Activity f5521a;
    final /* synthetic */ Intent f5522b;
    final /* synthetic */ boolean f5523c;

    C1668j(Activity activity, Intent intent, boolean z) {
        this.f5521a = activity;
        this.f5522b = intent;
        this.f5523c = z;
    }

    public void run() {
        if (this.f5521a != null) {
            this.f5521a.startActivity(this.f5522b);
            if (this.f5523c) {
                this.f5521a.finish();
            }
            this.f5521a.overridePendingTransition(2131034125, 2131034129);
        }
    }
}
