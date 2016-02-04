package mobi.mmdt.ott.view.p178a;

import android.app.Activity;
import android.content.Intent;

/* renamed from: mobi.mmdt.ott.view.a.c */
final class C1661c implements Runnable {
    final /* synthetic */ Activity f5505a;
    final /* synthetic */ Intent f5506b;

    C1661c(Activity activity, Intent intent) {
        this.f5505a = activity;
        this.f5506b = intent;
    }

    public void run() {
        if (this.f5505a != null) {
            this.f5505a.finish();
            this.f5505a.startActivity(this.f5506b);
            this.f5505a.overridePendingTransition(2131034125, 2131034129);
        }
    }
}
