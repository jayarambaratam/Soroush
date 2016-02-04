package mobi.mmdt.ott.view.registeration.profileinfo;

import android.os.Handler;

/* renamed from: mobi.mmdt.ott.view.registeration.profileinfo.q */
class C2504q implements Runnable {
    final /* synthetic */ ProfileInfoActivity f8098a;

    C2504q(ProfileInfoActivity profileInfoActivity) {
        this.f8098a = profileInfoActivity;
    }

    public void run() {
        new Handler().postDelayed(new C2505r(this), 50);
        new Handler().postDelayed(new C2506s(this), 100);
    }
}
