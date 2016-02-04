package mobi.mmdt.ott.logic.core;

import android.content.Intent;

/* renamed from: mobi.mmdt.ott.logic.core.g */
class C1501g implements Runnable {
    final /* synthetic */ Intent f5058a;
    final /* synthetic */ StartUpService f5059b;

    C1501g(StartUpService startUpService, Intent intent) {
        this.f5059b = startUpService;
        this.f5058a = intent;
    }

    public void run() {
        if (this.f5058a == null) {
            StartUpService.m7554f(this.f5059b.getApplicationContext());
        } else {
            this.f5059b.onHandleIntent(this.f5058a);
        }
    }
}
