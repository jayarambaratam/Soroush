package mobi.mmdt.ott.view.p178a;

import android.app.Activity;
import android.content.Intent;

/* renamed from: mobi.mmdt.ott.view.a.n */
final class C1672n implements Runnable {
    final /* synthetic */ Activity f5531a;
    final /* synthetic */ Intent f5532b;

    C1672n(Activity activity, Intent intent) {
        this.f5531a = activity;
        this.f5532b = intent;
    }

    public void run() {
        if (this.f5531a != null) {
            this.f5531a.startActivityForResult(this.f5532b, 27);
            this.f5531a.overridePendingTransition(2131034125, 2131034129);
        }
    }
}
