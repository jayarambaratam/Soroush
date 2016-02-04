package mobi.mmdt.ott.view.p178a.p179a;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import java.lang.ref.WeakReference;

/* renamed from: mobi.mmdt.ott.view.a.a.e */
class C1657e extends BitmapDrawable {
    private final WeakReference<C1658f> f5477a;

    public C1657e(Resources resources, Bitmap bitmap, C1658f c1658f) {
        super(resources, bitmap);
        this.f5477a = new WeakReference(c1658f);
    }

    public C1658f m8418a() {
        return (C1658f) this.f5477a.get();
    }
}
