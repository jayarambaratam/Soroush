package mobi.mmdt.ott.view.components.p184a.p195i;

import android.view.View;
import com.nineoldandroids.animation.ObjectAnimator;
import mobi.mmdt.ott.view.components.p184a.C1751i;

/* renamed from: mobi.mmdt.ott.view.components.a.i.a */
public class C1780a extends C1751i {
    public void m8722a(View view) {
        m8686d().playTogether(ObjectAnimator.ofFloat((Object) view, "scaleX", 0.45f, 1.0f), ObjectAnimator.ofFloat((Object) view, "scaleY", 0.45f, 1.0f), ObjectAnimator.ofFloat((Object) view, "alpha", 0.0f, 1.0f));
    }
}
