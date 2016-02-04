package mobi.mmdt.ott.view.p178a;

import android.app.Activity;
import android.content.Intent;

/* renamed from: mobi.mmdt.ott.view.a.i */
final class C1667i implements Runnable {
    final /* synthetic */ Activity f5519a;
    final /* synthetic */ Intent f5520b;

    C1667i(Activity activity, Intent intent) {
        this.f5519a = activity;
        this.f5520b = intent;
    }

    public void run() {
        if (this.f5519a != null) {
            this.f5519a.startActivity(this.f5520b);
            this.f5519a.overridePendingTransition(2131034125, 2131034129);
        }
    }
}
