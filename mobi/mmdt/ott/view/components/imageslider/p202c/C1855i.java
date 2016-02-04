package mobi.mmdt.ott.view.components.imageslider.p202c;

import android.os.Build.VERSION;
import android.view.View;
import com.nineoldandroids.view.ViewHelper;
import mobi.mmdt.ott.view.components.imageslider.Tricks.ViewPagerEx;

/* renamed from: mobi.mmdt.ott.view.components.imageslider.c.i */
public class C1855i extends C1847c {
    private void m8973a(View view) {
        ViewHelper.setTranslationX(view, (float) (((ViewPagerEx) view.getParent()).getScrollX() - view.getLeft()));
    }

    private void m8974a(View view, float f, float f2) {
        float f3 = (f == 0.0f || f == 1.0f) ? 1.0f : f2;
        ViewHelper.setScaleX(view, f3);
        if (f == 0.0f || f == 1.0f) {
            f2 = 1.0f;
        }
        ViewHelper.setScaleY(view, f2);
    }

    private void m8975b(View view, float f, float f2) {
        if (f > 0.0f) {
            ViewHelper.setRotationY(view, -180.0f * (1.0f + f2));
        } else {
            ViewHelper.setRotationY(view, 180.0f * (1.0f + f2));
        }
    }

    private void m8976e(View view, float f) {
        if (((double) f) >= 0.5d || ((double) f) <= -0.5d) {
            view.setVisibility(4);
        } else {
            view.setVisibility(0);
        }
    }

    protected void m8977a(View view, float f) {
        float abs = 1.0f - Math.abs(f);
        if (VERSION.SDK_INT >= 13) {
            view.setCameraDistance(12000.0f);
        }
        m8976e(view, f);
        m8973a(view);
        m8974a(view, f, abs);
        m8975b(view, f, abs);
    }
}
