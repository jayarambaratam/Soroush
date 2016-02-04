package android.support.design.widget;

import android.support.v4.view.dz;
import java.lang.ref.WeakReference;

public class ce implements dz {
    private final WeakReference<TabLayout> f545a;
    private int f546b;
    private int f547c;

    public ce(TabLayout tabLayout) {
        this.f545a = new WeakReference(tabLayout);
    }

    public void m666a(int i) {
        this.f546b = this.f547c;
        this.f547c = i;
    }

    public void m667a(int i, float f, int i2) {
        boolean z = true;
        TabLayout tabLayout = (TabLayout) this.f545a.get();
        if (tabLayout != null) {
            if (!(this.f547c == 1 || (this.f547c == 2 && this.f546b == 1))) {
                z = false;
            }
            tabLayout.m453a(i, f, z);
        }
    }

    public void m668b(int i) {
        TabLayout tabLayout = (TabLayout) this.f545a.get();
        if (tabLayout != null && tabLayout.getSelectedTabPosition() != i) {
            tabLayout.m458b(tabLayout.m452a(i), this.f547c == 0);
        }
    }
}
