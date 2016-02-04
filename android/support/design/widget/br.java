package android.support.design.widget;

import android.util.StateSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

final class br {
    private final ArrayList<bt> f508a;
    private bt f509b;
    private Animation f510c;
    private WeakReference<View> f511d;
    private AnimationListener f512e;

    br() {
        this.f508a = new ArrayList();
        this.f509b = null;
        this.f510c = null;
        this.f512e = new bs(this);
    }

    private void m599a(bt btVar) {
        this.f510c = btVar.f515b;
        View a = m602a();
        if (a != null) {
            a.startAnimation(this.f510c);
        }
    }

    private void m600c() {
        View a = m602a();
        int size = this.f508a.size();
        for (int i = 0; i < size; i++) {
            if (a.getAnimation() == ((bt) this.f508a.get(i)).f515b) {
                a.clearAnimation();
            }
        }
        this.f511d = null;
        this.f509b = null;
        this.f510c = null;
    }

    private void m601d() {
        if (this.f510c != null) {
            View a = m602a();
            if (a != null && a.getAnimation() == this.f510c) {
                a.clearAnimation();
            }
            this.f510c = null;
        }
    }

    View m602a() {
        return this.f511d == null ? null : (View) this.f511d.get();
    }

    void m603a(View view) {
        View a = m602a();
        if (a != view) {
            if (a != null) {
                m600c();
            }
            if (view != null) {
                this.f511d = new WeakReference(view);
            }
        }
    }

    void m604a(int[] iArr) {
        bt btVar = null;
        int size = this.f508a.size();
        for (int i = 0; i < size; i++) {
            bt btVar2 = (bt) this.f508a.get(i);
            if (StateSet.stateSetMatches(btVar2.f514a, iArr)) {
                btVar = btVar2;
                break;
            }
        }
        if (btVar != this.f509b) {
            if (this.f509b != null) {
                m601d();
            }
            this.f509b = btVar;
            View view = (View) this.f511d.get();
            if (btVar != null && view != null && view.getVisibility() == 0) {
                m599a(btVar);
            }
        }
    }

    public void m605a(int[] iArr, Animation animation) {
        bt btVar = new bt(animation, null);
        animation.setAnimationListener(this.f512e);
        this.f508a.add(btVar);
    }

    public void m606b() {
        if (this.f510c != null) {
            View a = m602a();
            if (a != null && a.getAnimation() == this.f510c) {
                a.clearAnimation();
            }
        }
    }
}
