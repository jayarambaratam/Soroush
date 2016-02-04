package android.support.design.widget;

import android.view.View;
import org.linphone.core.VideoSize;

class bc implements bv {
    final /* synthetic */ Snackbar f491a;

    bc(Snackbar snackbar) {
        this.f491a = snackbar;
    }

    public void m565a(int i) {
        switch (i) {
            case VideoSize.QCIF /*0*/:
                bn.m578a().m591d(this.f491a.f375g);
            case VideoSize.CIF /*1*/:
            case VideoSize.HVGA /*2*/:
                bn.m578a().m590c(this.f491a.f375g);
            default:
        }
    }

    public void m566a(View view) {
        this.f491a.m384c(0);
    }
}
