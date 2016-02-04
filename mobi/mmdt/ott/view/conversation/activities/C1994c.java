package mobi.mmdt.ott.view.conversation.activities;

import android.os.Handler;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import mobi.mmdt.componentsutils.p079a.C1111c;

/* renamed from: mobi.mmdt.ott.view.conversation.activities.c */
class C1994c implements OnGlobalLayoutListener {
    final /* synthetic */ C1992a f6468a;

    C1994c(C1992a c1992a) {
        this.f6468a = c1992a;
    }

    public void onGlobalLayout() {
        int x = this.f6468a.m9448x();
        if (this.f6468a.f6369s != x) {
            this.f6468a.f6369s = x;
            if (x > this.f6468a.m9366H() / 3) {
                if (!this.f6468a.f6371u) {
                    if (C1111c.m6413e(this.f6468a.getApplicationContext())) {
                        new Handler().postDelayed(new C1995d(this), 100);
                    } else {
                        new Handler().postDelayed(new C1997e(this), 100);
                    }
                }
                this.f6468a.m9368J();
                return;
            }
            this.f6468a.m9446v();
        }
    }
}
