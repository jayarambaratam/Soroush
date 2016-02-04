package mobi.mmdt.ott.view.components.squarecrop;

import android.graphics.Bitmap;
import mobi.mmdt.componentsutils.p079a.p080a.C1104b;
import mobi.mmdt.ott.logic.C1490b;
import mobi.mmdt.ott.view.p178a.al;

/* renamed from: mobi.mmdt.ott.view.components.squarecrop.b */
class C1938b implements Runnable {
    final /* synthetic */ Bitmap f6226a;
    final /* synthetic */ SquareCropActivity f6227b;

    C1938b(SquareCropActivity squareCropActivity, Bitmap bitmap) {
        this.f6227b = squareCropActivity;
        this.f6226a = bitmap;
    }

    public void run() {
        this.f6227b.runOnUiThread(new C1939c(this));
        byte[] a = al.m8478a(this.f6226a);
        String b = C1490b.m7517b();
        try {
            al.m8477a(b, a);
        } catch (Throwable e) {
            C1104b.m6368b((Object) this, e);
        }
        this.f6227b.runOnUiThread(new C1940d(this));
        try {
            Thread.sleep(100);
        } catch (Throwable e2) {
            C1104b.m6368b((Object) this, e2);
        }
        this.f6227b.runOnUiThread(new C1941e(this, b));
    }
}
