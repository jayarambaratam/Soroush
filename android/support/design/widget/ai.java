package android.support.design.widget;

import android.support.v4.view.cb;
import android.view.View;

class ai extends ac {
    private boolean f458j;

    ai(View view, ax axVar) {
        super(view, axVar);
    }

    private void m524c(float f) {
        if (this.d != null) {
            this.d.m554a(-f);
        }
        if (this.c != null) {
            this.c.m774b(-f);
        }
    }

    void m525a(an anVar) {
        if (this.f458j || this.h.getVisibility() != 0) {
            if (anVar != null) {
                anVar.m530b();
            }
        } else if (!cb.m2385D(this.h) || this.h.isInEditMode()) {
            this.h.setVisibility(8);
            if (anVar != null) {
                anVar.m530b();
            }
        } else {
            this.h.animate().scaleX(0.0f).scaleY(0.0f).alpha(0.0f).setDuration(200).setInterpolator(C0072a.f429b).setListener(new aj(this, anVar));
        }
    }

    void m526b(an anVar) {
        if (this.h.getVisibility() == 0) {
            return;
        }
        if (!cb.m2385D(this.h) || this.h.isInEditMode()) {
            this.h.setVisibility(0);
            this.h.setAlpha(1.0f);
            this.h.setScaleY(1.0f);
            this.h.setScaleX(1.0f);
            if (anVar != null) {
                anVar.m529a();
                return;
            }
            return;
        }
        this.h.setAlpha(0.0f);
        this.h.setScaleY(0.0f);
        this.h.setScaleX(0.0f);
        this.h.animate().scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setDuration(200).setInterpolator(C0072a.f429b).setListener(new ak(this, anVar));
    }

    boolean m527b() {
        return true;
    }

    void m528c() {
        m524c(this.h.getRotation());
    }
}
