package mobi.mmdt.ott.view.components.imageslider.p202c;

import android.view.View;
import com.nineoldandroids.view.ViewHelper;

/* renamed from: mobi.mmdt.ott.view.components.imageslider.c.m */
public class C1859m extends C1847c {
    protected void m8984a(View view, float f) {
        float f2 = 0.0f;
        if (f >= 0.0f) {
            f2 = ((float) (-view.getWidth())) * f;
        }
        ViewHelper.setTranslationX(view, f2);
    }
}
