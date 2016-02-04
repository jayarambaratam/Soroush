package mobi.mmdt.ott.view.components.mediaselector;

import android.support.v4.app.C0151x;
import android.support.v4.app.Fragment;
import android.support.v4.app.ah;
import org.linphone.core.VideoSize;

/* renamed from: mobi.mmdt.ott.view.components.mediaselector.d */
public class C1900d extends ah {
    final /* synthetic */ MainMediaSelectorActivity f6103a;

    public C1900d(MainMediaSelectorActivity mainMediaSelectorActivity, C0151x c0151x) {
        this.f6103a = mainMediaSelectorActivity;
        super(c0151x);
    }

    public Fragment m9076a(int i) {
        switch (i) {
            case VideoSize.QCIF /*0*/:
                return this.f6103a.f6057i;
            case VideoSize.CIF /*1*/:
                return this.f6103a.f6058j;
            default:
                return this.f6103a.f6057i;
        }
    }

    public int m9077b() {
        return this.f6103a.f6061m == 1 ? 2 : this.f6103a.f6061m == 2 ? 1 : this.f6103a.f6061m == 3 ? 1 : 1;
    }

    public CharSequence m9078c(int i) {
        switch (i) {
            case VideoSize.QCIF /*0*/:
                return this.f6103a.getString(2131230906);
            case VideoSize.CIF /*1*/:
                return this.f6103a.getString(2131230966);
            default:
                return this.f6103a.getString(2131230906);
        }
    }
}
