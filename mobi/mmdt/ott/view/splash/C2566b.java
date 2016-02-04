package mobi.mmdt.ott.view.splash;

import android.content.Intent;
import mobi.mmdt.ott.logic.core.StartUpService;
import mobi.mmdt.ott.view.main.MainActivity;

/* renamed from: mobi.mmdt.ott.view.splash.b */
class C2566b implements Runnable {
    final /* synthetic */ SplashActivity f8214a;

    C2566b(SplashActivity splashActivity) {
        this.f8214a = splashActivity;
    }

    public void run() {
        StartUpService.m7549c(this.f8214a.getApplicationContext());
        Intent intent = new Intent(this.f8214a.getApplicationContext(), MainActivity.class);
        intent.putExtra("KEY_ANIMATION_START", true);
        this.f8214a.startActivity(intent);
        this.f8214a.overridePendingTransition(2131034122, 2131034123);
    }
}
