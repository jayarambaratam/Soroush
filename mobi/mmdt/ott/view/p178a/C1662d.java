package mobi.mmdt.ott.view.p178a;

import android.app.Activity;
import android.content.Intent;

/* renamed from: mobi.mmdt.ott.view.a.d */
final class C1662d implements Runnable {
    final /* synthetic */ Activity f5507a;
    final /* synthetic */ Intent f5508b;

    C1662d(Activity activity, Intent intent) {
        this.f5507a = activity;
        this.f5508b = intent;
    }

    public void run() {
        if (this.f5507a != null) {
            this.f5507a.finish();
            this.f5507a.startActivity(this.f5508b);
            this.f5507a.overridePendingTransition(2131034125, 2131034129);
        }
    }
}
