package android.support.v7.app;

import android.support.v4.view.bs;
import android.support.v4.view.cb;
import android.support.v4.view.ff;
import android.view.View;

class at implements bs {
    final /* synthetic */ AppCompatDelegateImplV7 f1784a;

    at(AppCompatDelegateImplV7 appCompatDelegateImplV7) {
        this.f1784a = appCompatDelegateImplV7;
    }

    public ff m3644a(View view, ff ffVar) {
        int b = ffVar.m2899b();
        int c = this.f1784a.m3531f(b);
        if (b != c) {
            ffVar = ffVar.m2898a(ffVar.m2897a(), c, ffVar.m2900c(), ffVar.m2901d());
        }
        return cb.m2392a(view, ffVar);
    }
}
