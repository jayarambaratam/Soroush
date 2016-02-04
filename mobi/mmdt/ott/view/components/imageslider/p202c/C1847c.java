package mobi.mmdt.ott.view.components.imageslider.p202c;

import android.view.View;
import com.nineoldandroids.view.ViewHelper;
import java.util.ArrayList;
import java.util.HashMap;
import mobi.mmdt.ott.view.components.imageslider.Tricks.C1833l;
import mobi.mmdt.ott.view.components.imageslider.p200a.C1837a;

/* renamed from: mobi.mmdt.ott.view.components.imageslider.c.c */
public abstract class C1847c implements C1833l {
    boolean f5978a;
    boolean f5979b;
    private C1837a f5980c;
    private HashMap<View, ArrayList<Float>> f5981d;

    public C1847c() {
        this.f5981d = new HashMap();
    }

    protected abstract void m8955a(View view, float f);

    public void m8956a(C1837a c1837a) {
        this.f5980c = c1837a;
    }

    protected boolean m8957a() {
        return true;
    }

    public void m8958b(View view, float f) {
        m8960c(view, f);
        m8955a(view, f);
        m8961d(view, f);
    }

    protected boolean m8959b() {
        return false;
    }

    protected void m8960c(View view, float f) {
        float width = (float) view.getWidth();
        ViewHelper.setRotationX(view, 0.0f);
        ViewHelper.setRotationY(view, 0.0f);
        ViewHelper.setRotation(view, 0.0f);
        ViewHelper.setScaleX(view, 1.0f);
        ViewHelper.setScaleY(view, 1.0f);
        ViewHelper.setPivotX(view, 0.0f);
        ViewHelper.setPivotY(view, 0.0f);
        ViewHelper.setTranslationY(view, 0.0f);
        ViewHelper.setTranslationX(view, m8959b() ? 0.0f : (-width) * f);
        if (m8957a()) {
            width = (f <= -1.0f || f >= 1.0f) ? 0.0f : 1.0f;
            ViewHelper.setAlpha(view, width);
        } else {
            ViewHelper.setAlpha(view, 1.0f);
        }
        if (this.f5980c == null) {
            return;
        }
        if ((!this.f5981d.containsKey(view) || ((ArrayList) this.f5981d.get(view)).size() == 1) && f > -1.0f && f < 1.0f) {
            if (this.f5981d.get(view) == null) {
                this.f5981d.put(view, new ArrayList());
            }
            ((ArrayList) this.f5981d.get(view)).add(Float.valueOf(f));
            if (((ArrayList) this.f5981d.get(view)).size() == 2) {
                width = ((Float) ((ArrayList) this.f5981d.get(view)).get(1)).floatValue() - ((Float) ((ArrayList) this.f5981d.get(view)).get(0)).floatValue();
                if (((Float) ((ArrayList) this.f5981d.get(view)).get(0)).floatValue() > 0.0f) {
                    if (width <= -1.0f || width >= 0.0f) {
                        this.f5980c.m8922a(view);
                    } else {
                        this.f5980c.m8923b(view);
                    }
                } else if (width <= -1.0f || width >= 0.0f) {
                    this.f5980c.m8923b(view);
                } else {
                    this.f5980c.m8922a(view);
                }
            }
        }
    }

    protected void m8961d(View view, float f) {
        if (this.f5980c != null) {
            if (f == -1.0f || f == 1.0f) {
                this.f5980c.m8924c(view);
                this.f5978a = true;
            } else if (f == 0.0f) {
                this.f5980c.m8925d(view);
                this.f5979b = true;
            }
            if (this.f5978a && this.f5979b) {
                this.f5981d.clear();
                this.f5978a = false;
                this.f5979b = false;
            }
        }
    }
}
