package com.p032a.p033a.p045h.p056b;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.p032a.p033a.p045h.p060a.C0841d;
import com.p032a.p033a.p045h.p060a.C0843e;

/* renamed from: com.a.a.h.b.e */
public abstract class C0850e<Z> extends C0849l<ImageView, Z> implements C0843e {
    public C0850e(ImageView imageView) {
        super(imageView);
    }

    public void m5153a(Drawable drawable) {
        ((ImageView) this.a).setImageDrawable(drawable);
    }

    public void m5154a(Exception exception, Drawable drawable) {
        ((ImageView) this.a).setImageDrawable(drawable);
    }

    protected abstract void m5155a(Z z);

    public void m5156a(Z z, C0841d<? super Z> c0841d) {
        if (c0841d == null || !c0841d.m5136a(z, this)) {
            m5155a((Object) z);
        }
    }

    public Drawable m5157b() {
        return ((ImageView) this.a).getDrawable();
    }

    public void m5158b(Drawable drawable) {
        ((ImageView) this.a).setImageDrawable(drawable);
    }

    public void m5159c(Drawable drawable) {
        ((ImageView) this.a).setImageDrawable(drawable);
    }
}
