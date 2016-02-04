package mobi.mmdt.ott.view.components.p184a.p187c;

import android.view.View;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;
import mobi.mmdt.ott.view.components.p184a.C1751i;

/* renamed from: mobi.mmdt.ott.view.components.a.c.b */
public class C1758b extends C1751i {
    public void m8694a(View view) {
        AnimatorSet d = m8686d();
        Animator[] animatorArr = new Animator[2];
        animatorArr[0] = ObjectAnimator.ofFloat((Object) view, "alpha", 1.0f, 0.0f);
        animatorArr[1] = ObjectAnimator.ofFloat((Object) view, "translationY", 0.0f, (float) (view.getHeight() / 4));
        d.playTogether(animatorArr);
    }
}
