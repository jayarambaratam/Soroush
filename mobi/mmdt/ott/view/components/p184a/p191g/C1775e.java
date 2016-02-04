package mobi.mmdt.ott.view.components.p184a.p191g;

import android.view.View;
import android.view.ViewGroup;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;
import mobi.mmdt.ott.view.components.p184a.C1751i;

/* renamed from: mobi.mmdt.ott.view.components.a.g.e */
public class C1775e extends C1751i {
    public void m8718a(View view) {
        int height = ((ViewGroup) view.getParent()).getHeight() - view.getTop();
        AnimatorSet d = m8686d();
        Animator[] animatorArr = new Animator[2];
        animatorArr[0] = ObjectAnimator.ofFloat((Object) view, "alpha", 1.0f, 0.0f);
        animatorArr[1] = ObjectAnimator.ofFloat((Object) view, "translationY", 0.0f, (float) height);
        d.playTogether(animatorArr);
    }
}
