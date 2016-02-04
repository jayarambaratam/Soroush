package mobi.mmdt.ott.view.components.p184a.p190f;

import android.view.View;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;
import mobi.mmdt.ott.view.components.p184a.C1751i;

/* renamed from: mobi.mmdt.ott.view.components.a.f.c */
public class C1768c extends C1751i {
    public void m8711a(View view) {
        float width = (float) (0 - (view.getWidth() / 4));
        float height = (float) (view.getHeight() - (view.getWidth() / 4));
        AnimatorSet d = m8686d();
        r3 = new Animator[4];
        r3[2] = ObjectAnimator.ofFloat((Object) view, "pivotX", width, width);
        r3[3] = ObjectAnimator.ofFloat((Object) view, "pivotY", height, height);
        d.playTogether(r3);
    }
}
