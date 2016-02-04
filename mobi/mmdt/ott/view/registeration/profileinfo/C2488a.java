package mobi.mmdt.ott.view.registeration.profileinfo;

import android.view.animation.AccelerateDecelerateInterpolator;
import mobi.mmdt.ott.view.components.p184a.C1753a;
import mobi.mmdt.ott.view.components.p184a.p185a.C1752a;

/* renamed from: mobi.mmdt.ott.view.registeration.profileinfo.a */
class C2488a implements Runnable {
    final /* synthetic */ ProfileInfoActivity f8082a;

    C2488a(ProfileInfoActivity profileInfoActivity) {
        this.f8082a = profileInfoActivity;
    }

    public void run() {
        C1753a.m8688a(new C1752a()).m8701a(750).m8702a(new AccelerateDecelerateInterpolator()).m8704a(this.f8082a.f8078w);
    }
}
