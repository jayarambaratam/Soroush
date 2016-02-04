package mobi.mmdt.ott.view.main.basenavigation;

import android.support.v7.widget.SearchView.OnQueryTextListener;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.view.main.basenavigation.j */
class C2313j implements OnQueryTextListener {
    final /* synthetic */ C2285a f7628a;

    C2313j(C2285a c2285a) {
        this.f7628a = c2285a;
    }

    public boolean onQueryTextChange(String str) {
        switch (C2309f.f7624a[this.f7628a.f7537H.ordinal()]) {
            case VideoSize.CIF /*1*/:
                this.f7628a.f7551t.m10380a(str);
                break;
            case VideoSize.HVGA /*2*/:
                this.f7628a.f7552u.m10380a(str);
                break;
            case Version.API03_CUPCAKE_15 /*3*/:
                this.f7628a.f7549r.m10380a(str);
                break;
        }
        return false;
    }

    public boolean onQueryTextSubmit(String str) {
        return false;
    }
}
