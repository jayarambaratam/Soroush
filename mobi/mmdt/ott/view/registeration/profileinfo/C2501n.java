package mobi.mmdt.ott.view.registeration.profileinfo;

import android.os.Handler;

/* renamed from: mobi.mmdt.ott.view.registeration.profileinfo.n */
class C2501n implements Runnable {
    final /* synthetic */ ProfileInfoActivity f8095a;

    C2501n(ProfileInfoActivity profileInfoActivity) {
        this.f8095a = profileInfoActivity;
    }

    public void run() {
        new Handler().postDelayed(new C2502o(this), 50);
        new Handler().postDelayed(new C2503p(this), 100);
    }
}
