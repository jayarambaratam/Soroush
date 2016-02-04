package mobi.mmdt.ott.view.components.p184a;

import android.view.View;
import android.view.animation.Interpolator;
import com.nineoldandroids.animation.Animator.AnimatorListener;
import java.util.ArrayList;
import java.util.List;

/* renamed from: mobi.mmdt.ott.view.components.a.c */
public final class C1759c {
    private List<AnimatorListener> f5739a;
    private C1751i f5740b;
    private long f5741c;
    private long f5742d;
    private Interpolator f5743e;
    private View f5744f;

    private C1759c(C1751i c1751i) {
        this.f5739a = new ArrayList();
        this.f5741c = 1000;
        this.f5742d = 0;
        this.f5740b = c1751i;
    }

    public C1759c m8701a(long j) {
        this.f5741c = j;
        return this;
    }

    public C1759c m8702a(Interpolator interpolator) {
        this.f5743e = interpolator;
        return this;
    }

    public C1759c m8703a(C1770f c1770f) {
        this.f5739a.add(new C1763d(this, c1770f));
        return this;
    }

    public C1779h m8704a(View view) {
        this.f5744f = view;
        return new C1779h(this.f5744f, null);
    }

    public C1759c m8705b(C1770f c1770f) {
        this.f5739a.add(new C1765e(this, c1770f));
        return this;
    }
}
