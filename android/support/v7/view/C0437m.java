package android.support.v7.view;

import android.support.v4.view.fd;
import android.view.View;

/* renamed from: android.support.v7.view.m */
class C0437m extends fd {
    final /* synthetic */ C0436l f2111a;
    private boolean f2112b;
    private int f2113c;

    C0437m(C0436l c0436l) {
        this.f2111a = c0436l;
        this.f2112b = false;
        this.f2113c = 0;
    }

    void m4017a() {
        this.f2113c = 0;
        this.f2112b = false;
        this.f2111a.m4009c();
    }

    public void onAnimationEnd(View view) {
        int i = this.f2113c + 1;
        this.f2113c = i;
        if (i == this.f2111a.f2105a.size()) {
            if (this.f2111a.f2108d != null) {
                this.f2111a.f2108d.onAnimationEnd(null);
            }
            m4017a();
        }
    }

    public void onAnimationStart(View view) {
        if (!this.f2112b) {
            this.f2112b = true;
            if (this.f2111a.f2108d != null) {
                this.f2111a.f2108d.onAnimationStart(null);
            }
        }
    }
}
