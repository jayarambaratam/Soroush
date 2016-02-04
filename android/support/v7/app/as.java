package android.support.v7.app;

import android.support.v7.widget.RecyclerView.ItemAnimator;
import mobi.mmdt.ott.C1317h;

class as implements Runnable {
    final /* synthetic */ AppCompatDelegateImplV7 f1783a;

    as(AppCompatDelegateImplV7 appCompatDelegateImplV7) {
        this.f1783a = appCompatDelegateImplV7;
    }

    public void run() {
        if ((this.f1783a.f1748G & 1) != 0) {
            this.f1783a.m3529e(0);
        }
        if ((this.f1783a.f1748G & ItemAnimator.FLAG_APPEARED_IN_PRE_LAYOUT) != 0) {
            this.f1783a.m3529e(C1317h.Theme_spinnerStyle);
        }
        this.f1783a.f1747F = false;
        this.f1783a.f1748G = 0;
    }
}
