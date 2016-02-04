package mobi.mmdt.ott.view.components.p184a.p190f;

import android.view.View;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;
import mobi.mmdt.ott.view.components.p184a.C1751i;

/* renamed from: mobi.mmdt.ott.view.components.a.f.b */
public class C1767b extends C1751i {
    public void m8710a(View view) {
        float width = (float) (view.getWidth() + (view.getWidth() / 4));
        float width2 = (float) ((view.getWidth() / 4) + 0);
        AnimatorSet d = m8686d();
        r3 = new Animator[4];
        r3[2] = ObjectAnimator.ofFloat((Object) view, "pivotX", width, width);
        r3[3] = ObjectAnimator.ofFloat((Object) view, "pivotY", width2, width2);
        d.playTogether(r3);
    }
}
