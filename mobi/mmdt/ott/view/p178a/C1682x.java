package mobi.mmdt.ott.view.p178a;

import android.app.Activity;
import android.content.Intent;

/* renamed from: mobi.mmdt.ott.view.a.x */
final class C1682x implements Runnable {
    final /* synthetic */ Activity f5552a;
    final /* synthetic */ Intent f5553b;

    C1682x(Activity activity, Intent intent) {
        this.f5552a = activity;
        this.f5553b = intent;
    }

    public void run() {
        if (this.f5552a != null) {
            this.f5552a.finish();
            this.f5552a.startActivity(this.f5553b);
            this.f5552a.overridePendingTransition(2131034125, 2131034129);
        }
    }
}
