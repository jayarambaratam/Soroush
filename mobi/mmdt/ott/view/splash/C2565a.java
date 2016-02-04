package mobi.mmdt.ott.view.splash;

import android.content.Intent;
import mobi.mmdt.ott.view.registeration.introduction.IntroductionActivity;

/* renamed from: mobi.mmdt.ott.view.splash.a */
class C2565a implements Runnable {
    final /* synthetic */ SplashActivity f8213a;

    C2565a(SplashActivity splashActivity) {
        this.f8213a = splashActivity;
    }

    public void run() {
        this.f8213a.startActivity(new Intent(this.f8213a.getApplicationContext(), IntroductionActivity.class));
        this.f8213a.overridePendingTransition(2131034122, 2131034123);
    }
}
