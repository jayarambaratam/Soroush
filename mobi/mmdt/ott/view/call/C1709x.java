package mobi.mmdt.ott.view.call;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.p032a.p033a.p045h.p056b.C0851b;
import com.p032a.p033a.p045h.p060a.C0841d;
import mobi.mmdt.ott.view.p178a.ai;

/* renamed from: mobi.mmdt.ott.view.call.x */
class C1709x extends C0851b {
    final /* synthetic */ C1707v f5615b;

    C1709x(C1707v c1707v, ImageView imageView) {
        this.f5615b = c1707v;
        super(imageView);
    }

    public void m8538a(Bitmap bitmap, C0841d c0841d) {
        if (this.f5615b.f5611i) {
            super.m5156a((Object) bitmap, c0841d);
            return;
        }
        this.f5615b.f5611i = true;
        super.m5156a((Object) ai.m8473a(bitmap, 8, true), c0841d);
    }
}
