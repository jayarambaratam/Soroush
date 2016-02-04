package mobi.mmdt.ott.view.components.p184a.p196j;

import android.view.View;
import com.nineoldandroids.animation.ObjectAnimator;
import mobi.mmdt.ott.view.components.p184a.C1751i;

/* renamed from: mobi.mmdt.ott.view.components.a.j.a */
public class C1781a extends C1751i {
    protected void m8723a(View view) {
        m8686d().playTogether(ObjectAnimator.ofFloat((Object) view, "alpha", 1.0f, 0.0f, 0.0f), ObjectAnimator.ofFloat((Object) view, "scaleX", 1.0f, 0.3f, 0.0f), ObjectAnimator.ofFloat((Object) view, "scaleY", 1.0f, 0.3f, 0.0f));
    }
}
