package mobi.mmdt.ott.view.main.basenavigation;

import android.view.View;
import android.view.View.OnClickListener;

/* renamed from: mobi.mmdt.ott.view.main.basenavigation.z */
class C2342z implements OnClickListener {
    final /* synthetic */ C2322s f7733a;

    C2342z(C2322s c2322s) {
        this.f7733a = c2322s;
    }

    public void onClick(View view) {
        if (this.f7733a.f7653r != null) {
            switch (view.getId()) {
                case 2131689802:
                    this.f7733a.f7653r.m10293a(ac.RIGHT, true);
                case 2131689808:
                    this.f7733a.f7653r.m10293a(ac.BOTTOM, true);
                case 2131689814:
                    this.f7733a.f7653r.m10293a(ac.LEFT, true);
                case 2131689820:
                    this.f7733a.f7653r.m10293a(ac.TOP, true);
                default:
            }
        }
    }
}
