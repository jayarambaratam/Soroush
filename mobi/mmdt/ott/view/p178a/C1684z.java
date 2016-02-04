package mobi.mmdt.ott.view.p178a;

import android.app.Activity;
import android.content.Intent;

/* renamed from: mobi.mmdt.ott.view.a.z */
final class C1684z implements Runnable {
    final /* synthetic */ Activity f5556a;
    final /* synthetic */ Intent f5557b;
    final /* synthetic */ boolean f5558c;

    C1684z(Activity activity, Intent intent, boolean z) {
        this.f5556a = activity;
        this.f5557b = intent;
        this.f5558c = z;
    }

    public void run() {
        if (this.f5556a != null) {
            this.f5556a.startActivity(this.f5557b);
            if (this.f5558c) {
                this.f5556a.finish();
            }
            this.f5556a.overridePendingTransition(2131034125, 2131034129);
        }
    }
}
