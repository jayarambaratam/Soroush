package mobi.mmdt.ott.view.p178a.p179a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.widget.ImageView;
import mobi.mmdt.componentsutils.C1118e;
import mobi.mmdt.ott.MyApplication;

/* renamed from: mobi.mmdt.ott.view.a.a.d */
public abstract class C1656d {
    private Bitmap f5471a;
    private boolean f5472b;
    private boolean f5473c;
    private final Object f5474d;
    private int f5475e;
    private Resources f5476f;

    protected C1656d(Context context, int i) {
        this.f5472b = true;
        this.f5473c = false;
        this.f5474d = new Object();
        this.f5476f = context.getResources();
        this.f5475e = i;
    }

    private C1653a m8407a() {
        return MyApplication.m6445a().f4170a;
    }

    private void m8409a(ImageView imageView, Bitmap bitmap) {
        if (this.f5472b) {
            Drawable transitionDrawable = new TransitionDrawable(new Drawable[]{new ColorDrawable(this.f5476f.getColor(C1118e.transparent)), new BitmapDrawable(this.f5476f, bitmap)});
            imageView.setImageDrawable(transitionDrawable);
            transitionDrawable.startTransition(50);
            return;
        }
        imageView.setImageBitmap(bitmap);
    }

    public static boolean m8411a(int i, ImageView imageView) {
        C1658f b = C1656d.m8412b(imageView);
        if (b == null) {
            return true;
        }
        Integer valueOf = Integer.valueOf(b.f5479b);
        if (valueOf != null && valueOf.equals(Integer.valueOf(i))) {
            return false;
        }
        b.cancel(true);
        return true;
    }

    private static C1658f m8412b(ImageView imageView) {
        if (imageView != null) {
            Drawable drawable = imageView.getDrawable();
            if (drawable instanceof C1657e) {
                return ((C1657e) drawable).m8418a();
            }
        }
        return null;
    }

    protected abstract Bitmap m8415a(int i);

    public void m8416a(Integer num, ImageView imageView) {
        if (num != null) {
            Bitmap bitmap = null;
            if (m8407a() != null) {
                bitmap = m8407a().m8401a(num.intValue());
            }
            if (bitmap != null) {
                imageView.setImageBitmap(bitmap);
            } else if (C1656d.m8411a(num.intValue(), imageView)) {
                C1658f c1658f = new C1658f(this, imageView);
                imageView.setImageDrawable(new C1657e(this.f5476f, this.f5471a, c1658f));
                c1658f.execute(new Integer[]{num});
            }
        }
    }

    public void m8417a(boolean z) {
        this.f5472b = z;
    }
}
