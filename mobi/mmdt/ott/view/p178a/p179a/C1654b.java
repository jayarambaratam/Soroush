package mobi.mmdt.ott.view.p178a.p179a;

import android.graphics.Bitmap;
import android.util.LruCache;

/* renamed from: mobi.mmdt.ott.view.a.a.b */
class C1654b extends LruCache<Integer, Bitmap> {
    final /* synthetic */ C1653a f5469a;

    C1654b(C1653a c1653a, int i) {
        this.f5469a = c1653a;
        super(i);
    }

    protected int m8403a(Integer num, Bitmap bitmap) {
        int a = C1653a.m8397a(bitmap) / 1024;
        return a == 0 ? 1 : a;
    }

    protected /* synthetic */ int sizeOf(Object obj, Object obj2) {
        return m8403a((Integer) obj, (Bitmap) obj2);
    }
}
