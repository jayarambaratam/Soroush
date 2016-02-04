package mobi.mmdt.ott.view.registeration.introduction;

import android.support.v4.view.ea;
import android.view.View;
import com.nineoldandroids.view.ViewHelper;

/* renamed from: mobi.mmdt.ott.view.registeration.introduction.f */
public class C2439f implements ea {
    final /* synthetic */ IntroductionActivity f7948a;

    public C2439f(IntroductionActivity introductionActivity) {
        this.f7948a = introductionActivity;
    }

    public void m10645a(View view, float f) {
        int width = view.getWidth();
        View findViewById = view.findViewById(2131689866);
        View findViewById2 = view.findViewById(2131689868);
        View findViewById3 = view.findViewById(2131689869);
        View findViewById4 = view.findViewById(2131689867);
        if (0.0f <= f && f < 1.0f) {
            ViewHelper.setTranslationX(view, ((float) width) * (-f));
        } else if (-1.0f < f && f < 0.0f) {
            ViewHelper.setTranslationX(view, ((float) width) * (-f));
        }
        if (f > -1.0f && f < 1.0f) {
            if (findViewById != null) {
                ViewHelper.setAlpha(findViewById, 1.0f - Math.abs(f));
            }
            if (findViewById2 != null) {
                ViewHelper.setTranslationX(findViewById2, ((float) width) * f);
                ViewHelper.setAlpha(findViewById2, 1.0f - Math.abs(f));
            }
            if (findViewById3 != null) {
                ViewHelper.setTranslationX(findViewById3, ((float) width) * f);
                ViewHelper.setAlpha(findViewById3, 1.0f - Math.abs(f));
            }
            if (findViewById4 != null) {
                ViewHelper.setTranslationX(findViewById4, ((float) (width / 2)) * f);
                ViewHelper.setAlpha(findViewById4, 1.0f - Math.abs(f));
            }
        }
    }
}
