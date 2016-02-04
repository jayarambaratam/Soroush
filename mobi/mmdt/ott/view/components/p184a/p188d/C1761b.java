package mobi.mmdt.ott.view.components.p184a.p188d;

import android.view.View;
import com.nineoldandroids.animation.ObjectAnimator;
import mobi.mmdt.ott.view.components.p184a.C1751i;

/* renamed from: mobi.mmdt.ott.view.components.a.d.b */
public class C1761b extends C1751i {
    public void m8707a(View view) {
        m8686d().playTogether(ObjectAnimator.ofFloat((Object) view, "rotationY", 0.0f, 90.0f), ObjectAnimator.ofFloat((Object) view, "alpha", 1.0f, 0.0f));
    }
}
