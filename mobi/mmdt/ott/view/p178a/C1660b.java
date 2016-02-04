package mobi.mmdt.ott.view.p178a;

import android.app.Activity;
import android.content.Intent;

/* renamed from: mobi.mmdt.ott.view.a.b */
final class C1660b implements Runnable {
    final /* synthetic */ Activity f5502a;
    final /* synthetic */ Intent f5503b;
    final /* synthetic */ boolean f5504c;

    C1660b(Activity activity, Intent intent, boolean z) {
        this.f5502a = activity;
        this.f5503b = intent;
        this.f5504c = z;
    }

    public void run() {
        if (this.f5502a != null) {
            this.f5502a.startActivity(this.f5503b);
            if (this.f5504c) {
                this.f5502a.finish();
            }
            this.f5502a.overridePendingTransition(2131034125, 2131034129);
        }
    }
}
