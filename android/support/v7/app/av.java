package android.support.v7.app;

import android.support.v7.widget.ContentFrameLayout.OnAttachListener;

class av implements OnAttachListener {
    final /* synthetic */ AppCompatDelegateImplV7 f1786a;

    av(AppCompatDelegateImplV7 appCompatDelegateImplV7) {
        this.f1786a = appCompatDelegateImplV7;
    }

    public void onAttachedFromWindow() {
    }

    public void onDetachedFromWindow() {
        this.f1786a.m3538v();
    }
}
