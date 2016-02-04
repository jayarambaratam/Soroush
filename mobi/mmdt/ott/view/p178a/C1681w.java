package mobi.mmdt.ott.view.p178a;

import android.app.Activity;
import android.content.Intent;

/* renamed from: mobi.mmdt.ott.view.a.w */
final class C1681w implements Runnable {
    final /* synthetic */ Activity f5550a;
    final /* synthetic */ Intent f5551b;

    C1681w(Activity activity, Intent intent) {
        this.f5550a = activity;
        this.f5551b = intent;
    }

    public void run() {
        if (this.f5550a != null) {
            this.f5550a.finish();
            this.f5550a.startActivity(this.f5551b);
            this.f5550a.overridePendingTransition(2131034125, 2131034129);
        }
    }
}
