package mobi.mmdt.ott.view.registeration.profileinfo;

import android.os.Handler;

/* renamed from: mobi.mmdt.ott.view.registeration.profileinfo.h */
class C2495h implements Runnable {
    final /* synthetic */ ProfileInfoActivity f8089a;

    C2495h(ProfileInfoActivity profileInfoActivity) {
        this.f8089a = profileInfoActivity;
    }

    public void run() {
        new Handler().postDelayed(new C2496i(this), 50);
    }
}
