package mobi.mmdt.ott.view.components.p184a.p191g;

import android.view.View;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;
import mobi.mmdt.ott.view.components.p184a.C1751i;

/* renamed from: mobi.mmdt.ott.view.components.a.g.a */
public class C1771a extends C1751i {
    public void m8714a(View view) {
        int top = view.getTop() + view.getHeight();
        AnimatorSet d = m8686d();
        Animator[] animatorArr = new Animator[2];
        animatorArr[0] = ObjectAnimator.ofFloat((Object) view, "alpha", 0.0f, 1.0f);
        animatorArr[1] = ObjectAnimator.ofFloat((Object) view, "translationY", (float) (-top), 0.0f);
        d.playTogether(animatorArr);
    }
}
