package mobi.mmdt.ott.view.components.imageslider.p202c;

import android.view.View;
import com.nineoldandroids.view.ViewHelper;

/* renamed from: mobi.mmdt.ott.view.components.imageslider.c.g */
public class C1853g extends C1847c {
    protected void m8971a(View view, float f) {
        if (f < -1.0f || f > 1.0f) {
            ViewHelper.setAlpha(view, 0.6f);
        } else if (f <= 0.0f || f <= 1.0f) {
            ViewHelper.setAlpha(view, f <= 0.0f ? f + 1.0f : 1.0f - f);
        } else if (f == 0.0f) {
            ViewHelper.setAlpha(view, 1.0f);
        }
    }
}
