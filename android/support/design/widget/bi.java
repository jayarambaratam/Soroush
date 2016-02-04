package android.support.design.widget;

import android.support.v4.view.fd;
import android.view.View;

class bi extends fd {
    final /* synthetic */ int f497a;
    final /* synthetic */ Snackbar f498b;

    bi(Snackbar snackbar, int i) {
        this.f498b = snackbar;
        this.f497a = i;
    }

    public void onAnimationEnd(View view) {
        this.f498b.m389e(this.f497a);
    }

    public void onAnimationStart(View view) {
        this.f498b.f372d.m375b(0, 180);
    }
}
