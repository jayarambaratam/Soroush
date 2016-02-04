package mobi.mmdt.ott.view.p178a;

import android.app.Activity;
import android.content.Intent;

/* renamed from: mobi.mmdt.ott.view.a.u */
final class C1679u implements Runnable {
    final /* synthetic */ Activity f5546a;
    final /* synthetic */ Intent f5547b;

    C1679u(Activity activity, Intent intent) {
        this.f5546a = activity;
        this.f5547b = intent;
    }

    public void run() {
        if (this.f5546a != null) {
            this.f5546a.startActivity(this.f5547b);
            this.f5546a.overridePendingTransition(2131034125, 2131034129);
        }
    }
}
