package mobi.mmdt.ott.view.components.imageslider.p202c;

import android.view.View;
import com.nineoldandroids.view.ViewHelper;

/* renamed from: mobi.mmdt.ott.view.components.imageslider.c.h */
public class C1854h extends C1847c {
    protected void m8972a(View view, float f) {
        float f2 = 180.0f * f;
        float f3 = (f2 > 90.0f || f2 < -90.0f) ? 0.0f : 1.0f;
        ViewHelper.setAlpha(view, f3);
        ViewHelper.setPivotY(view, ((float) view.getHeight()) * 0.5f);
        ViewHelper.setPivotX(view, ((float) view.getWidth()) * 0.5f);
        ViewHelper.setRotationY(view, f2);
    }
}
