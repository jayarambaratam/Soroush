package mobi.mmdt.ott.view.conversation.groupinfo;

import android.support.design.widget.Snackbar;
import mobi.mmdt.componentsutils.view.p085a.C1123a;

/* renamed from: mobi.mmdt.ott.view.conversation.groupinfo.h */
class C2257h implements Runnable {
    final /* synthetic */ C2255f f7473a;

    C2257h(C2255f c2255f) {
        this.f7473a = c2255f;
    }

    public void run() {
        C1123a.m6432a(this.f7473a.f7471a.m8494q()).m6437a();
        Snackbar a = Snackbar.m377a(this.f7473a.f7471a.i, this.f7473a.f7471a.getString(2131230821), -2);
        a.m392a(2131230916, new C2258i(this));
        a.m395a();
    }
}
