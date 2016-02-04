package mobi.mmdt.ott.view.p178a;

import android.app.Activity;
import android.content.Intent;

/* renamed from: mobi.mmdt.ott.view.a.f */
final class C1664f implements Runnable {
    final /* synthetic */ Activity f5511a;
    final /* synthetic */ Intent f5512b;
    final /* synthetic */ boolean f5513c;

    C1664f(Activity activity, Intent intent, boolean z) {
        this.f5511a = activity;
        this.f5512b = intent;
        this.f5513c = z;
    }

    public void run() {
        if (this.f5511a != null) {
            this.f5511a.startActivity(this.f5512b);
            if (this.f5513c) {
                this.f5511a.finish();
            }
            this.f5511a.overridePendingTransition(2131034125, 2131034129);
        }
    }
}
