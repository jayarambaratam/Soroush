package mobi.mmdt.ott.view.components.p184a.p186b;

import android.view.View;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;
import mobi.mmdt.ott.view.components.p184a.C1751i;

/* renamed from: mobi.mmdt.ott.view.components.a.b.b */
public class C1755b extends C1751i {
    public void m8692a(View view) {
        AnimatorSet d = m8686d();
        Animator[] animatorArr = new Animator[2];
        animatorArr[0] = ObjectAnimator.ofFloat((Object) view, "alpha", 0.0f, 1.0f);
        animatorArr[1] = ObjectAnimator.ofFloat((Object) view, "translationY", (float) (view.getHeight() / 4), 0.0f);
        d.playTogether(animatorArr);
    }
}
