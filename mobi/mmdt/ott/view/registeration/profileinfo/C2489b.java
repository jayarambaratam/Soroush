package mobi.mmdt.ott.view.registeration.profileinfo;

import android.os.Handler;

/* renamed from: mobi.mmdt.ott.view.registeration.profileinfo.b */
class C2489b implements Runnable {
    final /* synthetic */ ProfileInfoActivity f8083a;

    C2489b(ProfileInfoActivity profileInfoActivity) {
        this.f8083a = profileInfoActivity;
    }

    public void run() {
        new Handler().postDelayed(new C2490c(this), 50);
        new Handler().postDelayed(new C2491d(this), 100);
    }
}
