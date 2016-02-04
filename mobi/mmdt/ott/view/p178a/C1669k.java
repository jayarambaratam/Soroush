package mobi.mmdt.ott.view.p178a;

import android.app.Activity;
import android.content.Intent;

/* renamed from: mobi.mmdt.ott.view.a.k */
final class C1669k implements Runnable {
    final /* synthetic */ Activity f5524a;
    final /* synthetic */ Intent f5525b;
    final /* synthetic */ boolean f5526c;

    C1669k(Activity activity, Intent intent, boolean z) {
        this.f5524a = activity;
        this.f5525b = intent;
        this.f5526c = z;
    }

    public void run() {
        if (this.f5524a != null) {
            this.f5524a.startActivity(this.f5525b);
            if (this.f5526c) {
                this.f5524a.finish();
            }
            this.f5524a.overridePendingTransition(2131034125, 2131034129);
        }
    }
}
