package mobi.mmdt.ott.view.conversation.forward;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.C0109i;
import org.linphone.core.VideoSize;

/* renamed from: mobi.mmdt.ott.view.conversation.forward.a */
public class C2238a extends C0109i {
    final /* synthetic */ ForwardActivity f7367a;

    public C2238a(ForwardActivity forwardActivity, FragmentManager fragmentManager) {
        this.f7367a = forwardActivity;
        super(fragmentManager);
    }

    public Fragment m10146a(int i) {
        switch (i) {
            case VideoSize.QCIF /*0*/:
                return this.f7367a.f7360m;
            case VideoSize.CIF /*1*/:
                return this.f7367a.f7359l;
            case VideoSize.HVGA /*2*/:
                return this.f7367a.f7358k;
            default:
                return this.f7367a.f7360m;
        }
    }

    public int m10147b() {
        return 3;
    }

    public CharSequence m10148c(int i) {
        switch (i) {
            case VideoSize.QCIF /*0*/:
                return "Recent";
            case VideoSize.CIF /*1*/:
                return "Groups";
            case VideoSize.HVGA /*2*/:
                return "Contacts";
            default:
                return null;
        }
    }
}
