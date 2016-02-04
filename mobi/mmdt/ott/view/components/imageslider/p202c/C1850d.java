package mobi.mmdt.ott.view.components.imageslider.p202c;

import android.view.View;
import com.nineoldandroids.view.ViewHelper;

/* renamed from: mobi.mmdt.ott.view.components.imageslider.c.d */
public class C1850d extends C1847c {
    protected void m8965a(View view, float f) {
        ViewHelper.setPivotX(view, f > 0.0f ? 0.0f : (float) view.getWidth());
        ViewHelper.setPivotY(view, 0.0f);
        ViewHelper.setRotation(view, -90.0f * f);
    }

    public boolean m8966b() {
        return true;
    }
}
