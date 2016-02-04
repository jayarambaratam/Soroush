package mobi.mmdt.ott.view.components.p184a.p189e;

import android.view.View;
import android.view.animation.OvershootInterpolator;
import com.nineoldandroids.animation.ObjectAnimator;
import mobi.mmdt.ott.view.components.p184a.C1751i;

/* renamed from: mobi.mmdt.ott.view.components.a.e.a */
public class C1764a extends C1751i {
    public void m8708a(View view) {
        m8686d().setInterpolator(new OvershootInterpolator());
        m8686d().playTogether(ObjectAnimator.ofFloat((Object) view, "scaleX", 1.0f, 1.25f, 0.75f, 1.15f, 1.0f), ObjectAnimator.ofFloat((Object) view, "scaleY", 1.0f, 0.75f, 1.25f, 0.85f, 1.0f));
    }
}
