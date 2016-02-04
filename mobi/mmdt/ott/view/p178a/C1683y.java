package mobi.mmdt.ott.view.p178a;

import android.app.Activity;
import android.content.Intent;

/* renamed from: mobi.mmdt.ott.view.a.y */
final class C1683y implements Runnable {
    final /* synthetic */ Activity f5554a;
    final /* synthetic */ Intent f5555b;

    C1683y(Activity activity, Intent intent) {
        this.f5554a = activity;
        this.f5555b = intent;
    }

    public void run() {
        if (this.f5554a != null) {
            this.f5554a.finish();
            this.f5554a.startActivity(this.f5555b);
            this.f5554a.overridePendingTransition(2131034125, 2131034129);
        }
    }
}
