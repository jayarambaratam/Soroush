package android.support.v7.p009c;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.support.v4.os.C0260a;
import android.util.TimingLogger;
import java.util.ArrayList;
import java.util.List;

/* renamed from: android.support.v7.c.g */
public final class C0415g {
    private final List<C0418l> f2034a;
    private final Bitmap f2035b;
    private int f2036c;
    private int f2037d;
    private final List<C0413i> f2038e;
    private Rect f2039f;
    private C0410j f2040g;

    public C0415g(Bitmap bitmap) {
        this.f2036c = 16;
        this.f2037d = 192;
        this.f2038e = new ArrayList();
        if (bitmap == null || bitmap.isRecycled()) {
            throw new IllegalArgumentException("Bitmap is not valid");
        }
        this.f2038e.add(C0412e.f2031c);
        this.f2035b = bitmap;
        this.f2034a = null;
    }

    private int[] m3943a(Bitmap bitmap) {
        int i = 0;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Object obj = new int[(width * height)];
        if (this.f2039f == null) {
            bitmap.getPixels(obj, 0, width, 0, 0, width, height);
            return obj;
        }
        int width2 = this.f2039f.width();
        height = this.f2039f.height();
        bitmap.getPixels(obj, 0, width, this.f2039f.left, this.f2039f.top, width2, height);
        Object obj2 = new int[(width2 * height)];
        while (i < height) {
            System.arraycopy(obj, ((this.f2039f.top + i) * width) + this.f2039f.left, obj2, i * width2, width2);
            i++;
        }
        return obj2;
    }

    public AsyncTask<Bitmap, Void, C0412e> m3944a(C0417k c0417k) {
        if (c0417k == null) {
            throw new IllegalArgumentException("listener can not be null");
        }
        return C0260a.m1797a(new C0416h(this, c0417k), this.f2035b);
    }

    public C0412e m3945a() {
        List list;
        TimingLogger timingLogger = null;
        if (this.f2035b == null) {
            list = this.f2034a;
        } else if (this.f2037d <= 0) {
            throw new IllegalArgumentException("Minimum dimension size for resizing should should be >= 1");
        } else {
            Bitmap a = C0412e.m3934b(this.f2035b, this.f2037d);
            if (timingLogger != null) {
                timingLogger.addSplit("Processed Bitmap");
            }
            Rect rect = this.f2039f;
            if (!(a == this.f2035b || rect == null)) {
                float width = ((float) a.getWidth()) / ((float) this.f2035b.getWidth());
                rect.left = (int) Math.floor((double) (((float) rect.left) * width));
                rect.top = (int) Math.floor((double) (((float) rect.top) * width));
                rect.right = (int) Math.ceil((double) (((float) rect.right) * width));
                rect.bottom = (int) Math.ceil((double) (width * ((float) rect.bottom)));
            }
            C0407a c0407a = new C0407a(m3943a(a), this.f2036c, this.f2038e.isEmpty() ? timingLogger : (C0413i[]) this.f2038e.toArray(new C0413i[this.f2038e.size()]));
            if (a != this.f2035b) {
                a.recycle();
            }
            list = c0407a.m3908a();
            if (timingLogger != null) {
                timingLogger.addSplit("Color quantization completed");
            }
        }
        if (this.f2040g == null) {
            this.f2040g = new C0411d();
        }
        this.f2040g.m3919a(list);
        if (timingLogger != null) {
            timingLogger.addSplit("Generator.generate() completed");
        }
        C0412e c0412e = new C0412e(this.f2040g, timingLogger);
        if (timingLogger != null) {
            timingLogger.addSplit("Created Palette");
            timingLogger.dumpToLog();
        }
        return c0412e;
    }
}
