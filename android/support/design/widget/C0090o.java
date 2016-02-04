package android.support.design.widget;

import android.support.v4.view.cb;
import android.view.View;
import org.linphone.core.VideoSize;

/* renamed from: android.support.design.widget.o */
class C0090o implements C0083h {
    final /* synthetic */ CollapsingToolbarLayout f662a;

    private C0090o(CollapsingToolbarLayout collapsingToolbarLayout) {
        this.f662a = collapsingToolbarLayout;
    }

    public void m819a(AppBarLayout appBarLayout, int i) {
        boolean z = false;
        this.f662a.f314s = i;
        int b = this.f662a.f315t != null ? this.f662a.f315t.m2899b() : 0;
        int totalScrollRange = appBarLayout.getTotalScrollRange();
        int childCount = this.f662a.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.f662a.getChildAt(i2);
            C0089n c0089n = (C0089n) childAt.getLayoutParams();
            dj a = CollapsingToolbarLayout.m305b(childAt);
            switch (c0089n.f660a) {
                case VideoSize.CIF /*1*/:
                    if ((this.f662a.getHeight() - b) + i < childAt.getHeight()) {
                        break;
                    }
                    a.m752a(-i);
                    break;
                case VideoSize.HVGA /*2*/:
                    a.m752a(Math.round(c0089n.f661b * ((float) (-i))));
                    break;
                default:
                    break;
            }
        }
        if (!(this.f662a.f308m == null && this.f662a.f309n == null)) {
            CollapsingToolbarLayout collapsingToolbarLayout = this.f662a;
            if (this.f662a.getHeight() + i < this.f662a.getScrimTriggerOffset() + b) {
                z = true;
            }
            collapsingToolbarLayout.setScrimsShown(z);
        }
        if (this.f662a.f309n != null && b > 0) {
            cb.m2417d(this.f662a);
        }
        this.f662a.f305j.m798b(((float) Math.abs(i)) / ((float) ((this.f662a.getHeight() - cb.m2441r(this.f662a)) - b)));
        if (Math.abs(i) == totalScrollRange) {
            cb.m2432j(appBarLayout, appBarLayout.getTargetElevation());
        } else {
            cb.m2432j(appBarLayout, 0.0f);
        }
    }
}
