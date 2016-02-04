package mobi.mmdt.ott.view.components.mediacaption;

import android.os.Handler;
import android.support.v4.view.dz;
import java.util.ArrayList;

/* renamed from: mobi.mmdt.ott.view.components.mediacaption.e */
class C1882e implements dz {
    final /* synthetic */ MediaCaptionActivity f6052a;

    C1882e(MediaCaptionActivity mediaCaptionActivity) {
        this.f6052a = mediaCaptionActivity;
    }

    public void m9035a(int i) {
    }

    public void m9036a(int i, float f, int i2) {
    }

    public void m9037b(int i) {
        this.f6052a.f6025r = (String) new ArrayList(this.f6052a.f6022o.keySet()).get(i);
        new Handler().postDelayed(new C1883f(this), 400);
    }
}
