package android.support.v7.app;

import android.support.v4.view.cb;
import android.support.v4.view.fd;
import android.view.View;

class ay extends fd {
    final /* synthetic */ AppCompatDelegateImplV7 f1789a;

    ay(AppCompatDelegateImplV7 appCompatDelegateImplV7) {
        this.f1789a = appCompatDelegateImplV7;
    }

    public void onAnimationEnd(View view) {
        cb.m2413c(this.f1789a.f1755n, 1.0f);
        this.f1789a.f1758q.m2800a(null);
        this.f1789a.f1758q = null;
    }

    public void onAnimationStart(View view) {
        this.f1789a.f1755n.setVisibility(0);
        this.f1789a.f1755n.sendAccessibilityEvent(32);
        if (this.f1789a.f1755n.getParent() != null) {
            cb.m2446w((View) this.f1789a.f1755n.getParent());
        }
    }
}
