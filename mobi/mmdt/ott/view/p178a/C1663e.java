package mobi.mmdt.ott.view.p178a;

import android.app.Activity;
import android.content.Intent;

/* renamed from: mobi.mmdt.ott.view.a.e */
final class C1663e implements Runnable {
    final /* synthetic */ Activity f5509a;
    final /* synthetic */ Intent f5510b;

    C1663e(Activity activity, Intent intent) {
        this.f5509a = activity;
        this.f5510b = intent;
    }

    public void run() {
        if (this.f5509a != null) {
            this.f5509a.finish();
            this.f5509a.startActivity(this.f5510b);
            this.f5509a.overridePendingTransition(2131034125, 2131034129);
        }
    }
}
