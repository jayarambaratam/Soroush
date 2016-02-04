package mobi.mmdt.ott.view.registeration.profileinfo;

import android.os.Handler;

/* renamed from: mobi.mmdt.ott.view.registeration.profileinfo.e */
class C2492e implements Runnable {
    final /* synthetic */ ProfileInfoActivity f8086a;

    C2492e(ProfileInfoActivity profileInfoActivity) {
        this.f8086a = profileInfoActivity;
    }

    public void run() {
        new Handler().postDelayed(new C2493f(this), 50);
        new Handler().postDelayed(new C2494g(this), 100);
    }
}
