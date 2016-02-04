package mobi.mmdt.ott.view.components;

import android.graphics.Bitmap;
import android.support.v7.p009c.C0412e;
import android.widget.ImageView;
import com.p032a.p033a.p045h.p056b.C0851b;
import com.p032a.p033a.p045h.p060a.C0841d;

/* renamed from: mobi.mmdt.ott.view.components.d */
class C1799d extends C0851b {
    final /* synthetic */ C1711a f5788b;

    C1799d(C1711a c1711a, ImageView imageView) {
        this.f5788b = c1711a;
        super(imageView);
    }

    public void m8759a(Bitmap bitmap, C0841d c0841d) {
        C0412e.m3933a(bitmap).m3944a(new C1800e(this));
        super.m5156a((Object) bitmap, c0841d);
    }
}
