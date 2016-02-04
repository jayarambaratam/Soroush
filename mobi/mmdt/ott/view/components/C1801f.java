package mobi.mmdt.ott.view.components;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.p032a.p033a.p045h.p056b.C0851b;
import com.p032a.p033a.p045h.p060a.C0841d;
import mobi.mmdt.ott.view.p178a.ai;

/* renamed from: mobi.mmdt.ott.view.components.f */
class C1801f extends C0851b {
    final /* synthetic */ C1711a f5790b;

    C1801f(C1711a c1711a, ImageView imageView) {
        this.f5790b = c1711a;
        super(imageView);
    }

    public void m8762a(Bitmap bitmap, C0841d c0841d) {
        if (this.f5790b.f5630v) {
            super.m5156a((Object) bitmap, c0841d);
            return;
        }
        this.f5790b.f5630v = true;
        super.m5156a((Object) ai.m8473a(bitmap, 4, true), c0841d);
    }
}
