package mobi.mmdt.ott.view.registeration.profileinfo;

import android.os.Handler;

/* renamed from: mobi.mmdt.ott.view.registeration.profileinfo.j */
class C2497j implements Runnable {
    final /* synthetic */ ProfileInfoActivity f8091a;

    C2497j(ProfileInfoActivity profileInfoActivity) {
        this.f8091a = profileInfoActivity;
    }

    public void run() {
        new Handler().postDelayed(new C2498k(this), 50);
        new Handler().postDelayed(new C2499l(this), 100);
    }
}
