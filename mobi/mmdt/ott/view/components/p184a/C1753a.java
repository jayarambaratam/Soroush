package mobi.mmdt.ott.view.components.p184a;

import android.view.View;
import android.view.animation.Interpolator;
import com.nineoldandroids.animation.Animator.AnimatorListener;
import java.util.List;

/* renamed from: mobi.mmdt.ott.view.components.a.a */
public class C1753a {
    private C1751i f5733a;
    private long f5734b;
    private long f5735c;
    private Interpolator f5736d;
    private List<AnimatorListener> f5737e;
    private View f5738f;

    private C1753a(C1759c c1759c) {
        this.f5733a = c1759c.f5740b;
        this.f5734b = c1759c.f5741c;
        this.f5735c = c1759c.f5742d;
        this.f5736d = c1759c.f5743e;
        this.f5737e = c1759c.f5739a;
        this.f5738f = c1759c.f5744f;
    }

    public static C1759c m8688a(C1751i c1751i) {
        return new C1759c(null);
    }

    private C1751i m8689a() {
        this.f5733a.m8682b(this.f5738f);
        this.f5733a.m8676a(this.f5734b).m8677a(this.f5736d).m8681b(this.f5735c);
        if (this.f5737e.size() > 0) {
            for (AnimatorListener a : this.f5737e) {
                this.f5733a.m8678a(a);
            }
        }
        this.f5733a.m8679a();
        return this.f5733a;
    }
}
