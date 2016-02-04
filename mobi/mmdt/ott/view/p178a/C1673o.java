package mobi.mmdt.ott.view.p178a;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.widget.Toast;

/* renamed from: mobi.mmdt.ott.view.a.o */
final class C1673o implements Runnable {
    final /* synthetic */ Activity f5533a;
    final /* synthetic */ Intent f5534b;

    C1673o(Activity activity, Intent intent) {
        this.f5533a = activity;
        this.f5534b = intent;
    }

    public void run() {
        if (this.f5533a != null) {
            try {
                this.f5533a.startActivity(this.f5534b);
                this.f5533a.overridePendingTransition(2131034125, 2131034129);
            } catch (ActivityNotFoundException e) {
                if (this.f5533a != null) {
                    Toast.makeText(this.f5533a, this.f5533a.getString(2131230895), 1).show();
                }
            }
        }
    }
}
