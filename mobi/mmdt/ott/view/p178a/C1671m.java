package mobi.mmdt.ott.view.p178a;

import android.app.Activity;
import android.content.Intent;

/* renamed from: mobi.mmdt.ott.view.a.m */
final class C1671m implements Runnable {
    final /* synthetic */ Activity f5529a;
    final /* synthetic */ Intent f5530b;

    C1671m(Activity activity, Intent intent) {
        this.f5529a = activity;
        this.f5530b = intent;
    }

    public void run() {
        if (this.f5529a != null) {
            this.f5529a.startActivity(this.f5530b);
            this.f5529a.overridePendingTransition(2131034125, 2131034129);
        }
    }
}
