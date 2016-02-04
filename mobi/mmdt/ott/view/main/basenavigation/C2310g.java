package mobi.mmdt.ott.view.main.basenavigation;

import android.support.v4.view.dz;
import org.linphone.core.VideoSize;

/* renamed from: mobi.mmdt.ott.view.main.basenavigation.g */
class C2310g implements dz {
    final /* synthetic */ C2285a f7625a;

    C2310g(C2285a c2285a) {
        this.f7625a = c2285a;
    }

    public void m10419a(int i) {
    }

    public void m10420a(int i, float f, int i2) {
    }

    public void m10421b(int i) {
        switch (i) {
            case VideoSize.QCIF /*0*/:
                this.f7625a.m10302b(false);
                this.f7625a.m10306c(ac.TOP);
            case VideoSize.CIF /*1*/:
                this.f7625a.m10302b(true);
                this.f7625a.m10306c(ac.CENTER);
            case VideoSize.HVGA /*2*/:
                this.f7625a.m10302b(false);
                this.f7625a.m10306c(ac.BOTTOM);
            default:
                this.f7625a.m10302b(true);
        }
    }
}
