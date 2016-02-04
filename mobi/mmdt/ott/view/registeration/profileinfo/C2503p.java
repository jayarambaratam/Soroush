package mobi.mmdt.ott.view.registeration.profileinfo;

import android.content.Intent;
import mobi.mmdt.ott.logic.C1502d;
import mobi.mmdt.ott.view.main.MainActivity;

/* renamed from: mobi.mmdt.ott.view.registeration.profileinfo.p */
class C2503p implements Runnable {
    final /* synthetic */ C2501n f8097a;

    C2503p(C2501n c2501n) {
        this.f8097a = c2501n;
    }

    public void run() {
        if (this.f8097a.f8095a.f8077v) {
            this.f8097a.f8095a.finish();
            this.f8097a.f8095a.overridePendingTransition(2131034125, 2131034129);
            return;
        }
        C1502d.m7573a(this.f8097a.f8095a.getApplicationContext());
        Intent intent = new Intent(this.f8097a.f8095a.getApplicationContext(), MainActivity.class);
        intent.putExtra("KEY_ANIMATION_START", true);
        this.f8097a.f8095a.startActivity(intent);
        this.f8097a.f8095a.finish();
        this.f8097a.f8095a.overridePendingTransition(2131034125, 2131034129);
    }
}
