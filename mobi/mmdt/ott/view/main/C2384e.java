package mobi.mmdt.ott.view.main;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.p032a.p033a.p045h.p056b.C0851b;
import com.p032a.p033a.p045h.p060a.C0841d;
import mobi.mmdt.ott.view.p178a.ai;

/* renamed from: mobi.mmdt.ott.view.main.e */
class C2384e extends C0851b {
    final /* synthetic */ C2383d f7849b;

    C2384e(C2383d c2383d, ImageView imageView) {
        this.f7849b = c2383d;
        super(imageView);
    }

    public void m10581a(Bitmap bitmap, C0841d c0841d) {
        if (this.f7849b.f7848a.f7560D) {
            super.m5156a((Object) bitmap, c0841d);
            return;
        }
        this.f7849b.f7848a.f7560D = true;
        super.m5156a((Object) ai.m8473a(bitmap, 4, true), c0841d);
    }
}
