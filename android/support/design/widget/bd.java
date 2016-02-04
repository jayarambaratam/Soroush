package android.support.design.widget;

import android.view.View;

class bd implements bl {
    final /* synthetic */ Snackbar f492a;

    bd(Snackbar snackbar) {
        this.f492a = snackbar;
    }

    public void m569a(View view) {
    }

    public void m570b(View view) {
        if (this.f492a.m397b()) {
            Snackbar.f369a.post(new be(this));
        }
    }
}
