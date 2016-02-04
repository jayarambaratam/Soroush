package mobi.mmdt.ott.view.registeration.introduction;

import android.support.v4.view.dz;
import mobi.mmdt.componentsutils.C1118e;

/* renamed from: mobi.mmdt.ott.view.registeration.introduction.d */
class C2437d implements dz {
    final /* synthetic */ IntroductionActivity f7946a;

    C2437d(IntroductionActivity introductionActivity) {
        this.f7946a = introductionActivity;
    }

    public void m10642a(int i) {
    }

    public void m10643a(int i, float f, int i2) {
        if (i != 2 || f <= 0.0f) {
            if (!this.f7946a.f7932i) {
                this.f7946a.f7933j.setBackgroundColor(this.f7946a.getResources().getColor(C1118e.primary_material_light));
                this.f7946a.f7932i = true;
            }
        } else if (this.f7946a.f7932i) {
            this.f7946a.f7933j.setBackgroundColor(0);
            this.f7946a.f7932i = false;
        }
    }

    public void m10644b(int i) {
        this.f7946a.m10626b(i);
        if (i == 3) {
            this.f7946a.f7936m.setVisibility(8);
            this.f7946a.f7938o.setVisibility(8);
            this.f7946a.f7937n.setVisibility(0);
        } else if (i < 3) {
            this.f7946a.f7936m.setVisibility(8);
            this.f7946a.f7938o.setVisibility(0);
            this.f7946a.f7937n.setVisibility(8);
        }
    }
}
