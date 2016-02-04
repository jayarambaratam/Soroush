package mobi.mmdt.ott.view.components.imageslider.p202c;

import android.view.View;
import com.nineoldandroids.view.ViewHelper;

/* renamed from: mobi.mmdt.ott.view.components.imageslider.c.l */
public class C1858l extends C1847c {
    protected void m8982a(View view, float f) {
        float f2 = -15.0f * f;
        ViewHelper.setPivotX(view, ((float) view.getWidth()) * 0.5f);
        ViewHelper.setPivotY(view, 0.0f);
        ViewHelper.setTranslationX(view, 0.0f);
        ViewHelper.setRotation(view, f2);
    }

    protected boolean m8983b() {
        return true;
    }
}
