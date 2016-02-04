package mobi.mmdt.ott.view.p178a.p179a;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.app.FragmentManager;
import android.graphics.Bitmap;
import android.util.LruCache;
import mobi.mmdt.ott.view.p178a.ak;

/* renamed from: mobi.mmdt.ott.view.a.a.a */
public class C1653a {
    private LruCache<Integer, Bitmap> f5468a;

    private C1653a(float f) {
        m8400b(f);
    }

    public static int m8396a(float f) {
        if (f >= 0.05f && f <= 0.8f) {
            return Math.round((((float) Runtime.getRuntime().maxMemory()) * f) / 1024.0f);
        }
        throw new IllegalArgumentException("setMemCacheSizePercent - percent must be between 0.05 and 0.8 (inclusive)");
    }

    @TargetApi(12)
    public static int m8397a(Bitmap bitmap) {
        return ak.m8476b() ? bitmap.getByteCount() : bitmap.getRowBytes() * bitmap.getHeight();
    }

    public static C1653a m8398a(FragmentManager fragmentManager, float f) {
        C1655c a = C1653a.m8399a(fragmentManager);
        C1653a c1653a = (C1653a) a.m8404a();
        if (c1653a != null) {
            return c1653a;
        }
        c1653a = new C1653a(f);
        a.m8405a(c1653a);
        return c1653a;
    }

    public static C1655c m8399a(FragmentManager fragmentManager) {
        C1655c c1655c = (C1655c) fragmentManager.findFragmentByTag("ImageCache");
        if (c1655c != null) {
            return c1655c;
        }
        Fragment c1655c2 = new C1655c();
        fragmentManager.beginTransaction().add(c1655c2, "ImageCache").commitAllowingStateLoss();
        return c1655c2;
    }

    private void m8400b(float f) {
        this.f5468a = new C1654b(this, C1653a.m8396a(f));
    }

    public Bitmap m8401a(int i) {
        if (this.f5468a != null) {
            Bitmap bitmap = (Bitmap) this.f5468a.get(Integer.valueOf(i));
            if (bitmap != null) {
                return bitmap;
            }
        }
        return null;
    }

    public void m8402a(Integer num, Bitmap bitmap) {
        if (num != null && bitmap != null && this.f5468a != null && this.f5468a.get(num) == null) {
            this.f5468a.put(num, bitmap);
        }
    }
}
