package mobi.mmdt.ott.view.p178a;

import android.app.Activity;
import android.content.Intent;

/* renamed from: mobi.mmdt.ott.view.a.t */
final class C1678t implements Runnable {
    final /* synthetic */ Activity f5543a;
    final /* synthetic */ Intent f5544b;
    final /* synthetic */ boolean f5545c;

    C1678t(Activity activity, Intent intent, boolean z) {
        this.f5543a = activity;
        this.f5544b = intent;
        this.f5545c = z;
    }

    public void run() {
        if (this.f5543a != null) {
            this.f5543a.startActivityForResult(this.f5544b, 19);
            if (this.f5545c) {
                this.f5543a.finish();
            }
            this.f5543a.overridePendingTransition(2131034125, 2131034129);
        }
    }
}
