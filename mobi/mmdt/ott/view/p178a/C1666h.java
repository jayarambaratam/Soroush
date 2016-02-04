package mobi.mmdt.ott.view.p178a;

import android.app.Activity;
import android.content.Intent;

/* renamed from: mobi.mmdt.ott.view.a.h */
final class C1666h implements Runnable {
    final /* synthetic */ Activity f5517a;
    final /* synthetic */ Intent f5518b;

    C1666h(Activity activity, Intent intent) {
        this.f5517a = activity;
        this.f5518b = intent;
    }

    public void run() {
        if (this.f5517a != null) {
            this.f5517a.startActivity(this.f5518b);
            this.f5517a.overridePendingTransition(2131034125, 2131034129);
        }
    }
}
