package mobi.mmdt.ott.logic.p112a.p135f.p136a;

import android.graphics.Bitmap;
import java.util.TimerTask;
import mobi.mmdt.ott.logic.notifications.p166b.C1553a;
import mobi.mmdt.ott.provider.p171e.C1611e;

/* renamed from: mobi.mmdt.ott.logic.a.f.a.c */
class C1423c extends TimerTask {
    final /* synthetic */ C1611e f4854a;
    final /* synthetic */ Bitmap f4855b;
    final /* synthetic */ C1422b f4856c;

    C1423c(C1422b c1422b, C1611e c1611e, Bitmap bitmap) {
        this.f4856c = c1422b;
        this.f4854a = c1611e;
        this.f4855b = bitmap;
    }

    public void run() {
        C1553a.m7847a(this.f4856c.f4852a, this.f4856c.f4853b, this.f4854a.m8205g(), this.f4855b);
    }
}
