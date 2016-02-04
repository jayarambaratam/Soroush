package mobi.mmdt.ott.view.stickermarket;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.C0109i;
import net.frakbot.glowpadbackport.BuildConfig;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.view.stickermarket.q */
public class C2593q extends C0109i {
    final /* synthetic */ StickerMarketActivity f8301a;

    public C2593q(StickerMarketActivity stickerMarketActivity, FragmentManager fragmentManager) {
        this.f8301a = stickerMarketActivity;
        super(fragmentManager);
    }

    public Fragment m11026a(int i) {
        switch (i) {
            case VideoSize.QCIF /*0*/:
                if (this.f8301a.f8244l == null) {
                    this.f8301a.f8244l = C2594r.m11029a(C2610z.LIST_TYPE_NEW, BuildConfig.FLAVOR);
                }
                return this.f8301a.f8244l;
            case VideoSize.CIF /*1*/:
                if (this.f8301a.f8245m == null) {
                    this.f8301a.f8245m = C2594r.m11029a(C2610z.LIST_TYPE_TOP, BuildConfig.FLAVOR);
                }
                return this.f8301a.f8245m;
            case VideoSize.HVGA /*2*/:
                if (this.f8301a.f8246n == null) {
                    this.f8301a.f8246n = C2594r.m11029a(C2610z.LIST_TYPE_FREE, BuildConfig.FLAVOR);
                }
                return this.f8301a.f8246n;
            case Version.API03_CUPCAKE_15 /*3*/:
                if (this.f8301a.f8247o == null) {
                    this.f8301a.f8247o = C2594r.m11029a(C2610z.LIST_TYPE_CATEGORIES, BuildConfig.FLAVOR);
                }
                return this.f8301a.f8247o;
            default:
                if (this.f8301a.f8244l == null) {
                    this.f8301a.f8244l = C2594r.m11029a(C2610z.LIST_TYPE_NEW, BuildConfig.FLAVOR);
                }
                return this.f8301a.f8244l;
        }
    }

    public int m11027b() {
        return 4;
    }

    public CharSequence m11028c(int i) {
        switch (i) {
            case VideoSize.QCIF /*0*/:
                return "New";
            case VideoSize.CIF /*1*/:
                return "Top";
            case VideoSize.HVGA /*2*/:
                return "Free";
            case Version.API03_CUPCAKE_15 /*3*/:
                return "Categories";
            default:
                return BuildConfig.FLAVOR + i;
        }
    }
}
