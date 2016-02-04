package mobi.mmdt.ott.view.components.imageslider.p202c;

import android.view.View;
import com.nineoldandroids.view.ViewHelper;

/* renamed from: mobi.mmdt.ott.view.components.imageslider.c.o */
public class C1861o extends C1847c {
    protected void m8987a(View view, float f) {
        float abs = f < 0.0f ? f + 1.0f : Math.abs(1.0f - f);
        ViewHelper.setScaleX(view, abs);
        ViewHelper.setScaleY(view, abs);
        ViewHelper.setPivotX(view, ((float) view.getWidth()) * 0.5f);
        ViewHelper.setPivotY(view, ((float) view.getHeight()) * 0.5f);
        abs = (f < -1.0f || f > 1.0f) ? 0.0f : 1.0f - (abs - 1.0f);
        ViewHelper.setAlpha(view, abs);
    }
}
