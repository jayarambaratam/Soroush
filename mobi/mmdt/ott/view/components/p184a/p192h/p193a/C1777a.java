package mobi.mmdt.ott.view.components.p184a.p192h.p193a;

import android.view.View;
import com.daimajia.easing.Glider;
import com.daimajia.easing.Skill;
import com.nineoldandroids.animation.ObjectAnimator;
import mobi.mmdt.ott.view.components.p184a.C1751i;

/* renamed from: mobi.mmdt.ott.view.components.a.h.a.a */
public class C1777a extends C1751i {
    protected void m8720a(View view) {
        m8686d().playTogether(Glider.glide(Skill.QuintEaseOut, (float) m8684c(), ObjectAnimator.ofFloat((Object) view, "scaleX", 1.5f, 1.0f)), Glider.glide(Skill.QuintEaseOut, (float) m8684c(), ObjectAnimator.ofFloat((Object) view, "scaleY", 1.5f, 1.0f)), Glider.glide(Skill.QuintEaseOut, (float) m8684c(), ObjectAnimator.ofFloat((Object) view, "alpha", 0.0f, 1.0f)));
    }
}
