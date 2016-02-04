package mobi.mmdt.ott.view.stickermarket;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.p032a.p033a.p045h.p056b.C0851b;
import com.p032a.p033a.p045h.p060a.C0841d;

/* renamed from: mobi.mmdt.ott.view.stickermarket.m */
class C2589m extends C0851b {
    final /* synthetic */ C2588l f8296b;

    C2589m(C2588l c2588l, ImageView imageView) {
        this.f8296b = c2588l;
        super(imageView);
    }

    public void m11024a(Bitmap bitmap, C0841d c0841d) {
        super.m5156a((Object) bitmap, c0841d);
        this.f8296b.f8295b.m10944a((double) (bitmap.getHeight() / bitmap.getWidth()));
    }
}
