package com.p032a.p033a.p045h.p056b;

import android.widget.ImageView;
import com.p032a.p033a.p037d.p049d.p052b.C0742b;
import com.p032a.p033a.p045h.p060a.C0841d;

/* renamed from: com.a.a.h.b.d */
public class C0853d extends C0850e<C0742b> {
    private int f2967b;
    private C0742b f2968c;

    public C0853d(ImageView imageView) {
        this(imageView, -1);
    }

    public C0853d(ImageView imageView, int i) {
        super(imageView);
        this.f2967b = i;
    }

    protected void m5164a(C0742b c0742b) {
        ((ImageView) this.a).setImageDrawable(c0742b);
    }

    public void m5165a(C0742b c0742b, C0841d<? super C0742b> c0841d) {
        Object c0856i;
        if (!c0742b.m4842a()) {
            float intrinsicWidth = ((float) c0742b.getIntrinsicWidth()) / ((float) c0742b.getIntrinsicHeight());
            if (Math.abs((((float) ((ImageView) this.a).getWidth()) / ((float) ((ImageView) this.a).getHeight())) - 1.0f) <= 0.05f && Math.abs(intrinsicWidth - 1.0f) <= 0.05f) {
                c0856i = new C0856i(c0742b, ((ImageView) this.a).getWidth());
            }
        }
        super.m5156a(c0856i, (C0841d) c0841d);
        this.f2968c = c0856i;
        c0856i.m4841a(this.f2967b);
        c0856i.start();
    }

    public void m5168d() {
        if (this.f2968c != null) {
            this.f2968c.start();
        }
    }

    public void m5169e() {
        if (this.f2968c != null) {
            this.f2968c.stop();
        }
    }
}
