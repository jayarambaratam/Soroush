package mobi.mmdt.ott.view.p178a;

import android.app.Activity;
import android.content.Intent;

/* renamed from: mobi.mmdt.ott.view.a.p */
final class C1674p implements Runnable {
    final /* synthetic */ Activity f5535a;
    final /* synthetic */ Intent f5536b;

    C1674p(Activity activity, Intent intent) {
        this.f5535a = activity;
        this.f5536b = intent;
    }

    public void run() {
        if (this.f5535a != null) {
            this.f5535a.startActivity(this.f5536b);
            this.f5535a.overridePendingTransition(2131034125, 2131034129);
        }
    }
}
