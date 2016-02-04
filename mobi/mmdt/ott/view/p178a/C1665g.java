package mobi.mmdt.ott.view.p178a;

import android.app.Activity;
import android.content.Intent;

/* renamed from: mobi.mmdt.ott.view.a.g */
final class C1665g implements Runnable {
    final /* synthetic */ Activity f5514a;
    final /* synthetic */ Intent f5515b;
    final /* synthetic */ boolean f5516c;

    C1665g(Activity activity, Intent intent, boolean z) {
        this.f5514a = activity;
        this.f5515b = intent;
        this.f5516c = z;
    }

    public void run() {
        if (this.f5514a != null) {
            this.f5514a.startActivity(this.f5515b);
            if (this.f5516c) {
                this.f5514a.finish();
            }
            this.f5514a.overridePendingTransition(2131034125, 2131034129);
        }
    }
}
