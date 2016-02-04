package mobi.mmdt.ott.view.main.basenavigation;

import android.support.v4.view.dz;
import org.apache.http.myHttp.HttpStatus;

/* renamed from: mobi.mmdt.ott.view.main.basenavigation.o */
class C2318o implements dz {
    final /* synthetic */ C2285a f7633a;

    C2318o(C2285a c2285a) {
        this.f7633a = c2285a;
    }

    public void m10424a(int i) {
    }

    public void m10425a(int i, float f, int i2) {
    }

    public void m10426b(int i) {
        if (i == 1) {
            this.f7633a.f7537H = ac.CENTER;
            this.f7633a.m10314a(this.f7633a.f7536G, ac.CENTER);
            this.f7633a.m10317b((int) HttpStatus.SC_MULTIPLE_CHOICES);
            this.f7633a.f7557z = true;
            this.f7633a.f7546o.m3807a(this.f7633a.f7557z);
            this.f7633a.f7546o.m3800a();
            this.f7633a.m8492e(this.f7633a.m10312a(ac.CENTER));
            this.f7633a.f7532C.setDrawerLockMode(0);
            this.f7633a.m10301b(ac.CENTER);
            return;
        }
        this.f7633a.m10313a((int) HttpStatus.SC_MULTIPLE_CHOICES);
        this.f7633a.f7557z = false;
        this.f7633a.f7546o.m3807a(this.f7633a.f7557z);
        this.f7633a.f7546o.m3800a();
        if (i == 0) {
            this.f7633a.f7537H = ac.LEFT;
            this.f7633a.m10314a(this.f7633a.f7536G, ac.LEFT);
            this.f7633a.m8492e(this.f7633a.m10312a(ac.LEFT));
            this.f7633a.f7532C.setDrawerLockMode(1);
            this.f7633a.m10301b(ac.LEFT);
        } else if (i == 2) {
            this.f7633a.f7537H = ac.RIGHT;
            this.f7633a.m10314a(this.f7633a.f7536G, ac.RIGHT);
            this.f7633a.m8492e(this.f7633a.m10312a(ac.RIGHT));
            this.f7633a.f7532C.setDrawerLockMode(1);
            this.f7633a.m10301b(ac.RIGHT);
        }
    }
}
