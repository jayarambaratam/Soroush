package android.support.design.widget;

import android.content.Context;
import android.support.v4.view.bf;
import android.support.v4.view.bw;
import android.support.v4.view.cb;
import android.support.v4.widget.bj;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

abstract class ap<V extends View> extends di<V> {
    private Runnable f271a;
    private bj f272b;
    private boolean f273c;
    private int f274d;
    private int f275e;
    private int f276f;
    private VelocityTracker f277g;

    public ap() {
        this.f274d = -1;
        this.f276f = -1;
    }

    public ap(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f274d = -1;
        this.f276f = -1;
    }

    private void m222c() {
        if (this.f277g == null) {
            this.f277g = VelocityTracker.obtain();
        }
    }

    int m223a() {
        return m220b();
    }

    int m224a(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        int b = m220b();
        if (i2 == 0 || b < i2 || b > i3) {
            return 0;
        }
        int a = as.m541a(i, i2, i3);
        if (b == a) {
            return 0;
        }
        m218a(a);
        return b - a;
    }

    int m225a(V v) {
        return v.getHeight();
    }

    final boolean m226a(CoordinatorLayout coordinatorLayout, V v, int i, int i2, float f) {
        if (this.f271a != null) {
            v.removeCallbacks(this.f271a);
            this.f271a = null;
        }
        if (this.f272b == null) {
            this.f272b = bj.m3263a(v.getContext());
        }
        this.f272b.m3267a(0, m220b(), 0, Math.round(f), 0, 0, i, i2);
        if (!this.f272b.m3276g()) {
            return false;
        }
        this.f271a = new aq(this, coordinatorLayout, v);
        cb.m2402a((View) v, this.f271a);
        return true;
    }

    public boolean m227a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.f276f < 0) {
            this.f276f = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getAction() == 2 && this.f273c) {
            return true;
        }
        int y;
        switch (bf.m2309a(motionEvent)) {
            case VideoSize.QCIF /*0*/:
                this.f273c = false;
                int x = (int) motionEvent.getX();
                y = (int) motionEvent.getY();
                if (m232c(v) && coordinatorLayout.m339a((View) v, x, y)) {
                    this.f275e = y;
                    this.f274d = bf.m2312b(motionEvent, 0);
                    m222c();
                    break;
                }
            case VideoSize.CIF /*1*/:
            case Version.API03_CUPCAKE_15 /*3*/:
                this.f273c = false;
                this.f274d = -1;
                if (this.f277g != null) {
                    this.f277g.recycle();
                    this.f277g = null;
                    break;
                }
                break;
            case VideoSize.HVGA /*2*/:
                y = this.f274d;
                if (y != -1) {
                    y = bf.m2310a(motionEvent, y);
                    if (y != -1) {
                        y = (int) bf.m2315d(motionEvent, y);
                        if (Math.abs(y - this.f275e) > this.f276f) {
                            this.f273c = true;
                            this.f275e = y;
                            break;
                        }
                    }
                }
                break;
        }
        if (this.f277g != null) {
            this.f277g.addMovement(motionEvent);
        }
        return this.f273c;
    }

    int m228b(CoordinatorLayout coordinatorLayout, V v, int i) {
        return m224a(coordinatorLayout, (View) v, i, (int) RtlSpacingHelper.UNDEFINED, (int) ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    final int m229b(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        return m224a(coordinatorLayout, (View) v, m223a() - i, i2, i3);
    }

    int m230b(V v) {
        return -v.getHeight();
    }

    public boolean m231b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.f276f < 0) {
            this.f276f = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        switch (bf.m2309a(motionEvent)) {
            case VideoSize.QCIF /*0*/:
                int y = (int) motionEvent.getY();
                if (coordinatorLayout.m339a((View) v, (int) motionEvent.getX(), y) && m232c(v)) {
                    this.f275e = y;
                    this.f274d = bf.m2312b(motionEvent, 0);
                    m222c();
                    break;
                }
                return false;
                break;
            case VideoSize.CIF /*1*/:
                if (this.f277g != null) {
                    this.f277g.addMovement(motionEvent);
                    this.f277g.computeCurrentVelocity(1000);
                    m226a(coordinatorLayout, (View) v, -m225a((View) v), 0, bw.m2359b(this.f277g, this.f274d));
                    break;
                }
                break;
            case VideoSize.HVGA /*2*/:
                int a = bf.m2310a(motionEvent, this.f274d);
                if (a != -1) {
                    a = (int) bf.m2315d(motionEvent, a);
                    int i = this.f275e - a;
                    if (!this.f273c && Math.abs(i) > this.f276f) {
                        this.f273c = true;
                        i = i > 0 ? i - this.f276f : i + this.f276f;
                    }
                    if (this.f273c) {
                        this.f275e = a;
                        m229b(coordinatorLayout, v, i, m230b(v), 0);
                        break;
                    }
                }
                return false;
                break;
            case Version.API03_CUPCAKE_15 /*3*/:
                break;
        }
        this.f273c = false;
        this.f274d = -1;
        if (this.f277g != null) {
            this.f277g.recycle();
            this.f277g = null;
        }
        if (this.f277g != null) {
            this.f277g.addMovement(motionEvent);
        }
        return true;
    }

    boolean m232c(V v) {
        return false;
    }
}
