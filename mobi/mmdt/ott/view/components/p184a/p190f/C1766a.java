package mobi.mmdt.ott.view.components.p184a.p190f;

import android.view.View;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;
import mobi.mmdt.ott.view.components.p184a.C1751i;

/* renamed from: mobi.mmdt.ott.view.components.a.f.a */
public class C1766a extends C1751i {
    public void m8709a(View view) {
        float width = (float) ((view.getWidth() / 4) + 0);
        float width2 = (float) (0 - (view.getWidth() / 4));
        AnimatorSet d = m8686d();
        r3 = new Animator[4];
        r3[2] = ObjectAnimator.ofFloat((Object) view, "pivotX", width, width);
        r3[3] = ObjectAnimator.ofFloat((Object) view, "pivotY", width2, width2);
        d.playTogether(r3);
    }
}
