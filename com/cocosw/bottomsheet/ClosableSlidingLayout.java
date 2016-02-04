package com.cocosw.bottomsheet;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.view.bf;
import android.support.v4.view.cb;
import android.support.v4.widget.ct;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import org.linphone.core.VideoSize;

class ClosableSlidingLayout extends FrameLayout {
    View f3730a;
    boolean f3731b;
    private final float f3732c;
    private ct f3733d;
    private C0994n f3734e;
    private int f3735f;
    private int f3736g;
    private int f3737h;
    private boolean f3738i;
    private float f3739j;
    private boolean f3740k;
    private float f3741l;

    public ClosableSlidingLayout(Context context) {
        this(context, null);
    }

    public ClosableSlidingLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @TargetApi(11)
    public ClosableSlidingLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3740k = false;
        this.f3731b = true;
        this.f3733d = ct.m3373a((ViewGroup) this, 0.8f, new C1005o());
        this.f3732c = getResources().getDisplayMetrics().density * 400.0f;
    }

    private float m6043a(MotionEvent motionEvent, int i) {
        int a = bf.m2310a(motionEvent, i);
        return a < 0 ? -1.0f : bf.m2315d(motionEvent, a);
    }

    private void m6045a(View view, float f) {
        if (this.f3734e != null) {
            this.f3734e.m6100b();
        }
    }

    private boolean m6047a() {
        boolean z = true;
        if (VERSION.SDK_INT >= 14) {
            return cb.m2412b(this.f3730a, -1);
        }
        if (this.f3730a instanceof AbsListView) {
            AbsListView absListView = (AbsListView) this.f3730a;
            return absListView.getChildCount() > 0 && (absListView.getFirstVisiblePosition() > 0 || absListView.getChildAt(0).getTop() < absListView.getPaddingTop());
        } else {
            if (this.f3730a.getScrollY() <= 0) {
                z = false;
            }
            return z;
        }
    }

    private void m6049b(View view, float f) {
        this.f3733d.m3396a(view, 0, this.f3736g + this.f3735f);
        this.f3733d.m3410e();
        cb.m2417d(this);
    }

    public void m6053a(C0994n c0994n) {
        this.f3734e = c0994n;
    }

    void m6054a(boolean z) {
        this.f3740k = z;
    }

    public void computeScroll() {
        if (this.f3733d.m3397a(true)) {
            cb.m2417d(this);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int a = bf.m2309a(motionEvent);
        if (!isEnabled() || m6047a()) {
            return false;
        }
        if (a == 3 || a == 1) {
            this.f3737h = -1;
            this.f3738i = false;
            if (this.f3740k && (-this.f3741l) > ((float) this.f3733d.m3407d())) {
                m6045a(this.f3733d.m3404c(), 0.0f);
            }
            this.f3733d.m3410e();
            return false;
        }
        float a2;
        switch (a) {
            case VideoSize.QCIF /*0*/:
                this.f3735f = getChildAt(0).getHeight();
                this.f3736g = getChildAt(0).getTop();
                this.f3737h = bf.m2312b(motionEvent, 0);
                this.f3738i = false;
                a2 = m6043a(motionEvent, this.f3737h);
                if (a2 != -1.0f) {
                    this.f3739j = a2;
                    this.f3741l = 0.0f;
                    break;
                }
                return false;
            case VideoSize.HVGA /*2*/:
                if (this.f3737h == -1) {
                    return false;
                }
                a2 = m6043a(motionEvent, this.f3737h);
                if (a2 != -1.0f) {
                    this.f3741l = a2 - this.f3739j;
                    if (this.f3731b && this.f3741l > ((float) this.f3733d.m3407d()) && !this.f3738i) {
                        this.f3738i = true;
                        this.f3733d.m3393a(getChildAt(0), 0);
                        break;
                    }
                }
                return false;
        }
        this.f3733d.m3395a(motionEvent);
        return this.f3738i;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled() || m6047a()) {
            return super.onTouchEvent(motionEvent);
        }
        try {
            if (this.f3731b) {
                this.f3733d.m3399b(motionEvent);
            }
        } catch (Exception e) {
        }
        return true;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
    }
}
