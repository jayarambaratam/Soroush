package mobi.mmdt.ott.view.registeration.activationcode;

import android.os.Handler;

/* renamed from: mobi.mmdt.ott.view.registeration.activationcode.d */
class C2409d implements Runnable {
    final /* synthetic */ ActivationCodeActivity f7907a;

    C2409d(ActivationCodeActivity activationCodeActivity) {
        this.f7907a = activationCodeActivity;
    }

    public void run() {
        String a = this.f7907a.f7883l.m10616a();
        if (a == null || a.isEmpty()) {
            new Handler().postDelayed(new C2412g(this), 50);
            return;
        }
        new Handler().postDelayed(new C2410e(this), 50);
        new Handler().postDelayed(new C2411f(this, a), 100);
    }
}
