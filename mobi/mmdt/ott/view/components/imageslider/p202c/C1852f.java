package mobi.mmdt.ott.view.components.imageslider.p202c;

import android.view.View;
import com.nineoldandroids.view.ViewHelper;

/* renamed from: mobi.mmdt.ott.view.components.imageslider.c.f */
public class C1852f extends C1847c {
    protected void m8969a(View view, float f) {
        if (f <= 0.0f) {
            ViewHelper.setTranslationX(view, 0.0f);
            ViewHelper.setScaleX(view, 1.0f);
            ViewHelper.setScaleY(view, 1.0f);
        } else if (f <= 1.0f) {
            float abs = 0.75f + (0.25f * (1.0f - Math.abs(f)));
            ViewHelper.setAlpha(view, 1.0f - f);
            ViewHelper.setPivotY(view, 0.5f * ((float) view.getHeight()));
            ViewHelper.setTranslationX(view, ((float) view.getWidth()) * (-f));
            ViewHelper.setScaleX(view, abs);
            ViewHelper.setScaleY(view, abs);
        }
    }

    protected boolean m8970b() {
        return true;
    }
}
