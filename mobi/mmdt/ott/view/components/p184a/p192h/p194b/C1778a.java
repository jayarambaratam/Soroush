package mobi.mmdt.ott.view.components.p184a.p192h.p194b;

import android.view.View;
import com.daimajia.easing.Glider;
import com.daimajia.easing.Skill;
import com.nineoldandroids.animation.ObjectAnimator;
import mobi.mmdt.ott.view.components.p184a.C1751i;

/* renamed from: mobi.mmdt.ott.view.components.a.h.b.a */
public class C1778a extends C1751i {
    protected void m8721a(View view) {
        m8686d().playTogether(Glider.glide(Skill.QuintEaseOut, (float) m8684c(), ObjectAnimator.ofFloat((Object) view, "scaleX", 1.0f, 1.5f)), Glider.glide(Skill.QuintEaseOut, (float) m8684c(), ObjectAnimator.ofFloat((Object) view, "scaleY", 1.0f, 1.5f)), Glider.glide(Skill.QuintEaseOut, (float) m8684c(), ObjectAnimator.ofFloat((Object) view, "alpha", 1.0f, 0.0f)));
    }
}
