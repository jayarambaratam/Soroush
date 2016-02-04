package com.p032a.p033a.p045h.p056b;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.p032a.p033a.p037d.p049d.p052b.C0742b;

/* renamed from: com.a.a.h.b.f */
public class C0854f {
    public <Z> C0778k<Z> m5170a(ImageView imageView, Class<Z> cls) {
        if (C0742b.class.isAssignableFrom(cls)) {
            return new C0853d(imageView);
        }
        if (Bitmap.class.equals(cls)) {
            return new C0851b(imageView);
        }
        if (Drawable.class.isAssignableFrom(cls)) {
            return new C0852c(imageView);
        }
        throw new IllegalArgumentException("Unhandled class: " + cls + ", try .as*(Class).transcode(ResourceTranscoder)");
    }
}
