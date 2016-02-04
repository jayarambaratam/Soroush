package android.support.v7.app;

import android.content.Context;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.TintManager;
import android.view.KeyEvent;
import android.view.MotionEvent;

class bc extends ContentFrameLayout {
    final /* synthetic */ AppCompatDelegateImplV7 f1794a;

    public bc(AppCompatDelegateImplV7 appCompatDelegateImplV7, Context context) {
        this.f1794a = appCompatDelegateImplV7;
        super(context);
    }

    private boolean m3653a(int i, int i2) {
        return i < -5 || i2 < -5 || i > getWidth() + 5 || i2 > getHeight() + 5;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.f1794a.m3550a(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0 || !m3653a((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        this.f1794a.m3523c(0);
        return true;
    }

    public void setBackgroundResource(int i) {
        setBackgroundDrawable(TintManager.getDrawable(getContext(), i));
    }
}
