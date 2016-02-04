package mobi.mmdt.ott.view.components.imageslider.p202c;

import android.view.View;
import com.nineoldandroids.view.ViewHelper;

/* renamed from: mobi.mmdt.ott.view.components.imageslider.c.p */
public class C1862p extends C1847c {
    protected void m8988a(View view, float f) {
        if (f >= -1.0f || f <= 1.0f) {
            float height = (float) view.getHeight();
            float max = Math.max(0.85f, 1.0f - Math.abs(f));
            float f2 = ((1.0f - max) * height) / 2.0f;
            float width = (((float) view.getWidth()) * (1.0f - max)) / 2.0f;
            ViewHelper.setPivotY(view, height * 0.5f);
            if (f < 0.0f) {
                ViewHelper.setTranslationX(view, width - (f2 / 2.0f));
            } else {
                ViewHelper.setTranslationX(view, (-width) + (f2 / 2.0f));
            }
            ViewHelper.setScaleX(view, max);
            ViewHelper.setScaleY(view, max);
            ViewHelper.setAlpha(view, (((max - 0.85f) / 0.14999998f) * 0.5f) + 0.5f);
        }
    }
}
