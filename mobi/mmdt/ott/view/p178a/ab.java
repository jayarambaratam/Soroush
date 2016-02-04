package mobi.mmdt.ott.view.p178a;

import android.app.Activity;
import android.content.Intent;

/* renamed from: mobi.mmdt.ott.view.a.ab */
final class ab implements Runnable {
    final /* synthetic */ Activity f5483a;
    final /* synthetic */ Intent f5484b;

    ab(Activity activity, Intent intent) {
        this.f5483a = activity;
        this.f5484b = intent;
    }

    public void run() {
        if (this.f5483a != null) {
            this.f5483a.finish();
            this.f5483a.startActivity(this.f5484b);
            this.f5483a.overridePendingTransition(2131034125, 2131034129);
        }
    }
}
