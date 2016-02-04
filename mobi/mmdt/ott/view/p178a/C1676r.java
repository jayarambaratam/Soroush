package mobi.mmdt.ott.view.p178a;

import android.app.Activity;
import android.content.Intent;

/* renamed from: mobi.mmdt.ott.view.a.r */
final class C1676r implements Runnable {
    final /* synthetic */ Activity f5539a;
    final /* synthetic */ Intent f5540b;

    C1676r(Activity activity, Intent intent) {
        this.f5539a = activity;
        this.f5540b = intent;
    }

    public void run() {
        if (this.f5539a != null) {
            this.f5539a.startActivity(this.f5540b);
            this.f5539a.overridePendingTransition(2131034125, 2131034129);
        }
    }
}
