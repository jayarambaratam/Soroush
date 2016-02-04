package com.cocosw.bottomsheet;

import android.os.Build.VERSION;
import android.support.v4.view.cb;
import android.support.v4.widget.cw;
import android.view.View;

/* renamed from: com.cocosw.bottomsheet.o */
class C1005o extends cw {
    final /* synthetic */ ClosableSlidingLayout f3810a;

    private C1005o(ClosableSlidingLayout closableSlidingLayout) {
        this.f3810a = closableSlidingLayout;
    }

    public void m6125a(View view, float f, float f2) {
        if (f2 > this.f3810a.f3732c) {
            this.f3810a.m6049b(view, f2);
        } else if (view.getTop() >= this.f3810a.f3736g + (this.f3810a.f3735f / 2)) {
            this.f3810a.m6049b(view, f2);
        } else {
            this.f3810a.f3733d.m3396a(view, 0, this.f3810a.f3736g);
        }
        cb.m2417d(this.f3810a);
    }

    public void m6126a(View view, int i, int i2, int i3, int i4) {
        if (VERSION.SDK_INT < 11) {
            this.f3810a.invalidate();
        }
        if (this.f3810a.f3735f - i2 < 1 && this.f3810a.f3734e != null) {
            this.f3810a.f3734e.m6099a();
        }
    }

    public boolean m6127a(View view, int i) {
        return true;
    }

    public int m6128b(View view, int i, int i2) {
        return Math.max(i, this.f3810a.f3736g);
    }
}
