package mobi.mmdt.ott.logic.p112a.p149i.p151b;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import java.io.File;
import mobi.mmdt.ott.logic.p124j.C1367c;
import mobi.mmdt.ott.provider.p174h.C1629b;
import mobi.mmdt.ott.provider.p174h.C1634g;

/* renamed from: mobi.mmdt.ott.logic.a.i.b.c */
class C1465c implements C1367c {
    final /* synthetic */ C1464b f4910a;

    C1465c(C1464b c1464b) {
        this.f4910a = c1464b;
    }

    public void m7421a(int i) {
        C1629b.m8290a(this.f4910a.f4902a, this.f4910a.f4905d, C1634g.TRANSMITTING);
    }

    public void m7422a(int i, int i2) {
    }

    public void m7423a(int i, Object obj) {
        C1629b.m8290a(this.f4910a.f4902a, this.f4910a.f4905d, C1634g.ERROR);
    }

    public void m7424a(int i, String str, String str2, String str3) {
    }

    public void m7425b(int i) {
        C1629b.m8290a(this.f4910a.f4902a, this.f4910a.f4905d, C1634g.CANCEL);
    }

    public void m7426c(int i) {
        int i2 = 96;
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(new File(this.f4910a.f4903b.getPath()).getAbsolutePath(), options);
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        switch (this.f4910a.f4902a.getResources().getDisplayMetrics().densityDpi) {
            case 160:
                i2 = 64;
                break;
            case 320:
                i2 = 128;
                break;
            case 480:
                i2 = 192;
                break;
            case 640:
                i2 = 256;
                break;
        }
        C1629b.m8289a(this.f4910a.f4902a, this.f4910a.f4905d, i3 / i2, i4 / i2);
        C1629b.m8290a(this.f4910a.f4902a, this.f4910a.f4905d, C1634g.FINISHED);
    }
}
