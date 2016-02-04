package com.p032a.p033a.p037d.p049d.p050a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.util.Log;
import com.p032a.p033a.p037d.C0727f;
import com.p032a.p033a.p037d.p039b.C0670y;
import com.p032a.p033a.p042j.C0876d;
import com.p032a.p033a.p042j.C0879h;
import java.io.OutputStream;

/* renamed from: com.a.a.d.d.a.b */
public class C0728b implements C0727f<Bitmap> {
    private CompressFormat f2749a;
    private int f2750b;

    public C0728b() {
        this(null, 90);
    }

    public C0728b(CompressFormat compressFormat, int i) {
        this.f2749a = compressFormat;
        this.f2750b = i;
    }

    private CompressFormat m4793a(Bitmap bitmap) {
        return this.f2749a != null ? this.f2749a : bitmap.hasAlpha() ? CompressFormat.PNG : CompressFormat.JPEG;
    }

    public String m4794a() {
        return "BitmapEncoder.com.bumptech.glide.load.resource.bitmap";
    }

    public boolean m4795a(C0670y<Bitmap> c0670y, OutputStream outputStream) {
        Bitmap bitmap = (Bitmap) c0670y.m4678b();
        long a = C0876d.m5296a();
        CompressFormat a2 = m4793a(bitmap);
        bitmap.compress(a2, this.f2750b, outputStream);
        if (Log.isLoggable("BitmapEncoder", 2)) {
            Log.v("BitmapEncoder", "Compressed with type: " + a2 + " of size " + C0879h.m5302a(bitmap) + " in " + C0876d.m5295a(a));
        }
        return true;
    }
}
