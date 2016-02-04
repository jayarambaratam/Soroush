package mobi.mmdt.ott.view.components.imageslider.Tricks;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;

/* renamed from: mobi.mmdt.ott.view.components.imageslider.Tricks.a */
public class C1823a extends Scroller {
    private int f5941a;

    public C1823a(Context context, Interpolator interpolator) {
        super(context, interpolator);
        this.f5941a = 1000;
    }

    public C1823a(Context context, Interpolator interpolator, int i) {
        this(context, interpolator);
        this.f5941a = i;
    }

    public void startScroll(int i, int i2, int i3, int i4) {
        super.startScroll(i, i2, i3, i4, this.f5941a);
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        super.startScroll(i, i2, i3, i4, this.f5941a);
    }
}
