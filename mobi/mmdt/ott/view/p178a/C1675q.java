package mobi.mmdt.ott.view.p178a;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.widget.Toast;

/* renamed from: mobi.mmdt.ott.view.a.q */
final class C1675q implements Runnable {
    final /* synthetic */ Activity f5537a;
    final /* synthetic */ Intent f5538b;

    C1675q(Activity activity, Intent intent) {
        this.f5537a = activity;
        this.f5538b = intent;
    }

    public void run() {
        if (this.f5537a != null) {
            try {
                this.f5537a.startActivity(this.f5538b);
                this.f5537a.overridePendingTransition(2131034125, 2131034129);
            } catch (ActivityNotFoundException e) {
                if (this.f5537a != null) {
                    Toast.makeText(this.f5537a, this.f5537a.getString(2131230895), 1).show();
                }
            }
        }
    }
}
