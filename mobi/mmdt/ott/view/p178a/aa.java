package mobi.mmdt.ott.view.p178a;

import android.app.Activity;
import android.content.Intent;

/* renamed from: mobi.mmdt.ott.view.a.aa */
final class aa implements Runnable {
    final /* synthetic */ Activity f5481a;
    final /* synthetic */ Intent f5482b;

    aa(Activity activity, Intent intent) {
        this.f5481a = activity;
        this.f5482b = intent;
    }

    public void run() {
        if (this.f5481a != null) {
            this.f5481a.finish();
            this.f5481a.startActivity(this.f5482b);
            this.f5481a.overridePendingTransition(2131034125, 2131034129);
        }
    }
}
