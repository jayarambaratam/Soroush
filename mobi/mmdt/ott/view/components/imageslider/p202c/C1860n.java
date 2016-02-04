package mobi.mmdt.ott.view.components.imageslider.p202c;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.View;
import com.nineoldandroids.view.ViewHelper;

/* renamed from: mobi.mmdt.ott.view.components.imageslider.c.n */
public class C1860n extends C1847c {
    private static final Matrix f5982c;
    private static final Camera f5983d;
    private static final float[] f5984e;

    static {
        f5982c = new Matrix();
        f5983d = new Camera();
        f5984e = new float[2];
    }

    protected static float m8985a(float f, int i, int i2) {
        f5982c.reset();
        f5983d.save();
        f5983d.rotateY(Math.abs(f));
        f5983d.getMatrix(f5982c);
        f5983d.restore();
        f5982c.preTranslate(((float) (-i)) * 0.5f, ((float) (-i2)) * 0.5f);
        f5982c.postTranslate(((float) i) * 0.5f, ((float) i2) * 0.5f);
        f5984e[0] = (float) i;
        f5984e[1] = (float) i2;
        f5982c.mapPoints(f5984e);
        return (f > 0.0f ? 1.0f : -1.0f) * (((float) i) - f5984e[0]);
    }

    protected void m8986a(View view, float f) {
        float abs = (f < 0.0f ? 30.0f : -30.0f) * Math.abs(f);
        ViewHelper.setTranslationX(view, C1860n.m8985a(abs, view.getWidth(), view.getHeight()));
        ViewHelper.setPivotX(view, ((float) view.getWidth()) * 0.5f);
        ViewHelper.setPivotY(view, 0.0f);
        ViewHelper.setRotationY(view, abs);
    }
}
