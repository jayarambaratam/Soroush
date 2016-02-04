package android.support.v7.p009c;

import android.graphics.Bitmap;
import java.util.List;

/* renamed from: android.support.v7.c.e */
public final class C0412e {
    private static final C0413i f2031c;
    private final List<C0418l> f2032a;
    private final C0410j f2033b;

    static {
        f2031c = new C0414f();
    }

    private C0412e(List<C0418l> list, C0410j c0410j) {
        this.f2032a = list;
        this.f2033b = c0410j;
    }

    public static C0415g m3933a(Bitmap bitmap) {
        return new C0415g(bitmap);
    }

    private static Bitmap m3934b(Bitmap bitmap, int i) {
        int max = Math.max(bitmap.getWidth(), bitmap.getHeight());
        if (max <= i) {
            return bitmap;
        }
        double d = ((double) i) / ((double) max);
        return Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(((double) bitmap.getWidth()) * d), (int) Math.ceil(d * ((double) bitmap.getHeight())), false);
    }

    public int m3936a(int i) {
        C0418l a = m3937a();
        return a != null ? a.m3950a() : i;
    }

    public C0418l m3937a() {
        return this.f2033b.m3918a();
    }
}
