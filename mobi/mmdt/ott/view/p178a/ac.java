package mobi.mmdt.ott.view.p178a;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

/* renamed from: mobi.mmdt.ott.view.a.ac */
public class ac {
    private static ac f5485a;
    private final Animation f5486b;
    private final Animation f5487c;
    private final Animation f5488d;
    private final Animation f5489e;
    private final Animation f5490f;
    private final Animation f5491g;
    private Context f5492h;

    private ac(Context context) {
        this.f5492h = context;
        this.f5486b = AnimationUtils.loadAnimation(context, 2131034143);
        this.f5487c = AnimationUtils.loadAnimation(context, 2131034142);
        this.f5488d = AnimationUtils.loadAnimation(context, 2131034141);
        this.f5489e = AnimationUtils.loadAnimation(context, 2131034140);
        this.f5490f = AnimationUtils.loadAnimation(context, 2131034145);
        this.f5491g = AnimationUtils.loadAnimation(context, 2131034144);
    }

    public static ac m8459a(Context context) {
        if (f5485a == null) {
            f5485a = new ac(context);
        }
        return f5485a;
    }

    public Animation m8460a() {
        return this.f5491g;
    }

    public Animation m8461b() {
        return this.f5490f;
    }
}
