package mobi.mmdt.ott.view.components.imageslider.p202c;

import android.view.View;
import com.nineoldandroids.view.ViewHelper;

/* renamed from: mobi.mmdt.ott.view.components.imageslider.c.k */
public class C1857k extends C1847c {
    protected void m8980a(View view, float f) {
        float height = (float) view.getHeight();
        float f2 = (-15.0f * f) * -1.25f;
        ViewHelper.setPivotX(view, ((float) view.getWidth()) * 0.5f);
        ViewHelper.setPivotY(view, height);
        ViewHelper.setRotation(view, f2);
    }

    protected boolean m8981b() {
        return true;
    }
}
