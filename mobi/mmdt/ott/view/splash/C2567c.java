package mobi.mmdt.ott.view.splash;

import android.content.Intent;
import mobi.mmdt.ott.view.registeration.introduction.IntroductionActivity;

/* renamed from: mobi.mmdt.ott.view.splash.c */
class C2567c implements Runnable {
    final /* synthetic */ SplashActivity f8215a;

    C2567c(SplashActivity splashActivity) {
        this.f8215a = splashActivity;
    }

    public void run() {
        this.f8215a.startActivity(new Intent(this.f8215a.getApplicationContext(), IntroductionActivity.class));
        this.f8215a.overridePendingTransition(2131034122, 2131034123);
    }
}
