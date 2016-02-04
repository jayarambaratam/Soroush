package mobi.mmdt.ott.view.p178a;

import android.app.Activity;
import android.content.Intent;

/* renamed from: mobi.mmdt.ott.view.a.l */
final class C1670l implements Runnable {
    final /* synthetic */ Activity f5527a;
    final /* synthetic */ Intent f5528b;

    C1670l(Activity activity, Intent intent) {
        this.f5527a = activity;
        this.f5528b = intent;
    }

    public void run() {
        if (this.f5527a != null) {
            this.f5527a.finish();
            this.f5527a.startActivity(this.f5528b);
            this.f5527a.overridePendingTransition(2131034125, 2131034129);
        }
    }
}
