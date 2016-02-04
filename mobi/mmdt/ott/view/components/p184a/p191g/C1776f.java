package mobi.mmdt.ott.view.components.p184a.p191g;

import android.view.View;
import android.view.ViewGroup;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;
import mobi.mmdt.ott.view.components.p184a.C1751i;

/* renamed from: mobi.mmdt.ott.view.components.a.g.f */
public class C1776f extends C1751i {
    public void m8719a(View view) {
        int width = ((ViewGroup) view.getParent()).getWidth() - view.getLeft();
        AnimatorSet d = m8686d();
        Animator[] animatorArr = new Animator[2];
        animatorArr[0] = ObjectAnimator.ofFloat((Object) view, "alpha", 1.0f, 0.0f);
        animatorArr[1] = ObjectAnimator.ofFloat((Object) view, "translationX", 0.0f, (float) width);
        d.playTogether(animatorArr);
    }
}
