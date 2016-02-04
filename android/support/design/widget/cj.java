package android.support.design.widget;

import android.support.v4.view.fd;
import android.view.View;

class cj extends fd {
    final /* synthetic */ TextInputLayout f559a;

    cj(TextInputLayout textInputLayout) {
        this.f559a = textInputLayout;
    }

    public void onAnimationEnd(View view) {
        view.setVisibility(4);
        this.f559a.m467a(true);
    }
}
