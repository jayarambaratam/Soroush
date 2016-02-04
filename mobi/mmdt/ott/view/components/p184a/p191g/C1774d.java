package mobi.mmdt.ott.view.components.p184a.p191g;

import android.view.View;
import android.view.ViewGroup;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;
import mobi.mmdt.ott.view.components.p184a.C1751i;

/* renamed from: mobi.mmdt.ott.view.components.a.g.d */
public class C1774d extends C1751i {
    public void m8717a(View view) {
        int height = ((ViewGroup) view.getParent()).getHeight() - view.getTop();
        AnimatorSet d = m8686d();
        Animator[] animatorArr = new Animator[2];
        animatorArr[0] = ObjectAnimator.ofFloat((Object) view, "alpha", 0.0f, 1.0f);
        animatorArr[1] = ObjectAnimator.ofFloat((Object) view, "translationY", (float) height, 0.0f);
        d.playTogether(animatorArr);
    }
}
