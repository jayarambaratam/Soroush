package mobi.mmdt.ott.view.main.basenavigation.viewpager;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;

/* renamed from: mobi.mmdt.ott.view.main.basenavigation.viewpager.b */
public class C2327b extends Scroller {
    public C2327b(Context context, Interpolator interpolator) {
        super(context, interpolator);
    }

    public void startScroll(int i, int i2, int i3, int i4) {
        super.startScroll(i, i2, i3, i4, 600);
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        super.startScroll(i, i2, i3, i4, 600);
    }
}
