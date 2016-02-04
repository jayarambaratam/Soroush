package mobi.mmdt.ott.view.p178a;

import android.app.Activity;
import android.content.Intent;

/* renamed from: mobi.mmdt.ott.view.a.v */
final class C1680v implements Runnable {
    final /* synthetic */ Activity f5548a;
    final /* synthetic */ Intent f5549b;

    C1680v(Activity activity, Intent intent) {
        this.f5548a = activity;
        this.f5549b = intent;
    }

    public void run() {
        if (this.f5548a != null) {
            this.f5548a.finish();
            this.f5548a.startActivity(this.f5549b);
            this.f5548a.overridePendingTransition(2131034125, 2131034129);
        }
    }
}
