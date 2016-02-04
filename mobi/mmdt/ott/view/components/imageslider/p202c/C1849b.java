package mobi.mmdt.ott.view.components.imageslider.p202c;

import android.view.View;
import com.nineoldandroids.view.ViewHelper;

/* renamed from: mobi.mmdt.ott.view.components.imageslider.c.b */
public class C1849b extends C1847c {
    private static float m8963a(float f, float f2) {
        return f < f2 ? f2 : f;
    }

    protected void m8964a(View view, float f) {
        float f2 = 1.0f;
        float height = (float) view.getHeight();
        float width = (float) view.getWidth();
        if (f >= 0.0f) {
            f2 = Math.abs(1.0f - f);
        }
        f2 = C1849b.m8963a(f2, 0.5f);
        ViewHelper.setScaleX(view, f2);
        ViewHelper.setScaleY(view, f2);
        ViewHelper.setPivotX(view, width * 0.5f);
        ViewHelper.setPivotY(view, height * 0.5f);
        ViewHelper.setTranslationX(view, f < 0.0f ? width * f : ((-width) * f) * 0.25f);
    }
}
