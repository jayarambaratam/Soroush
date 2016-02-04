package mobi.mmdt.ott.view.p178a;

import android.app.Activity;
import android.content.Intent;

/* renamed from: mobi.mmdt.ott.view.a.s */
final class C1677s implements Runnable {
    final /* synthetic */ Activity f5541a;
    final /* synthetic */ Intent f5542b;

    C1677s(Activity activity, Intent intent) {
        this.f5541a = activity;
        this.f5542b = intent;
    }

    public void run() {
        if (this.f5541a != null) {
            this.f5541a.startActivity(this.f5542b);
            this.f5541a.overridePendingTransition(2131034125, 2131034129);
        }
    }
}
