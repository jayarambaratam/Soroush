package mobi.mmdt.ott.view.registeration.introduction;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.C0109i;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.view.registeration.introduction.g */
class C2440g extends C0109i {
    final /* synthetic */ IntroductionActivity f7949a;

    public C2440g(IntroductionActivity introductionActivity, FragmentManager fragmentManager) {
        this.f7949a = introductionActivity;
        super(fragmentManager);
    }

    public Fragment m10646a(int i) {
        switch (i) {
            case VideoSize.QCIF /*0*/:
                return this.f7949a.f7941r;
            case VideoSize.CIF /*1*/:
                return this.f7949a.f7939p;
            case VideoSize.HVGA /*2*/:
                return this.f7949a.f7940q;
            case Version.API03_CUPCAKE_15 /*3*/:
                return this.f7949a.f7942s;
            default:
                return this.f7949a.f7941r;
        }
    }

    public int m10647b() {
        return 4;
    }
}
