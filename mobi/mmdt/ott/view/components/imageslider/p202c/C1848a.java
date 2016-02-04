package mobi.mmdt.ott.view.components.imageslider.p202c;

import android.view.View;
import com.nineoldandroids.view.ViewHelper;

/* renamed from: mobi.mmdt.ott.view.components.imageslider.c.a */
public class C1848a extends C1847c {
    protected void m8962a(View view, float f) {
        ViewHelper.setPivotX(view, f < 0.0f ? 0.0f : (float) view.getWidth());
        ViewHelper.setScaleX(view, f < 0.0f ? 1.0f + f : 1.0f - f);
    }
}
