package android.support.design.widget;

import android.support.v4.view.bf;
import android.support.v4.widget.ct;
import android.support.v4.widget.cw;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

public class SwipeDismissBehavior<V extends View> extends C0071r<V> {
    private ct f376a;
    private bv f377b;
    private boolean f378c;
    private float f379d;
    private boolean f380e;
    private int f381f;
    private float f382g;
    private float f383h;
    private float f384i;
    private final cw f385j;

    public SwipeDismissBehavior() {
        this.f379d = 0.0f;
        this.f381f = 2;
        this.f382g = 0.5f;
        this.f383h = 0.0f;
        this.f384i = 0.5f;
        this.f385j = new bu(this);
    }

    static float m399a(float f, float f2, float f3) {
        return (f3 - f) / (f2 - f);
    }

    private void m402a(ViewGroup viewGroup) {
        if (this.f376a == null) {
            this.f376a = this.f380e ? ct.m3373a(viewGroup, this.f379d, this.f385j) : ct.m3374a(viewGroup, this.f385j);
        }
    }

    private static int m404b(int i, int i2, int i3) {
        return Math.min(Math.max(i, i2), i3);
    }

    private static float m406c(float f, float f2, float f3) {
        return Math.min(Math.max(f, f2), f3);
    }

    public int m411a() {
        return this.f376a != null ? this.f376a.m3390a() : 0;
    }

    public void m412a(float f) {
        this.f383h = m406c(0.0f, f, 1.0f);
    }

    public void m413a(int i) {
        this.f381f = i;
    }

    public void m414a(bv bvVar) {
        this.f377b = bvVar;
    }

    public boolean m415a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        switch (bf.m2309a(motionEvent)) {
            case VideoSize.CIF /*1*/:
            case Version.API03_CUPCAKE_15 /*3*/:
                if (this.f378c) {
                    this.f378c = false;
                    return false;
                }
                break;
            default:
                this.f378c = !coordinatorLayout.m339a((View) v, (int) motionEvent.getX(), (int) motionEvent.getY());
                break;
        }
        if (this.f378c) {
            return false;
        }
        m402a((ViewGroup) coordinatorLayout);
        return this.f376a.m3395a(motionEvent);
    }

    public boolean m416a(View view) {
        return true;
    }

    public void m417b(float f) {
        this.f384i = m406c(0.0f, f, 1.0f);
    }

    public boolean m418b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.f376a == null) {
            return false;
        }
        this.f376a.m3399b(motionEvent);
        return true;
    }
}
