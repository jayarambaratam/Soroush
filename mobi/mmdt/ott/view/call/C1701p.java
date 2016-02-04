package mobi.mmdt.ott.view.call;

import android.view.View;
import android.view.View.OnClickListener;
import com.dd.morphingbutton.MorphingButton;
import mobi.mmdt.ott.logic.C1494c;
import mobi.mmdt.ott.logic.p112a.p113a.p116b.C1330c;

/* renamed from: mobi.mmdt.ott.view.call.p */
class C1701p implements OnClickListener {
    final /* synthetic */ MorphingButton f5596a;
    final /* synthetic */ CallActivity f5597b;

    C1701p(CallActivity callActivity, MorphingButton morphingButton) {
        this.f5597b = callActivity;
        this.f5596a = morphingButton;
    }

    public void onClick(View view) {
        if (this.f5597b.f5574u) {
            if (this.f5597b.f5572s) {
                this.f5596a.m6165a(this.f5597b.m8497a(this.f5596a.getWidth(), this.f5596a.getHeight()).m6207a(this.f5597b.getString(2131230770)));
            } else {
                this.f5596a.m6165a(this.f5597b.m8503b(this.f5596a.getWidth(), this.f5596a.getHeight()).m6206a(2130838473));
            }
            this.f5597b.f5572s = !this.f5597b.f5572s;
            C1494c.m7539a(new C1330c(this.f5597b.getApplicationContext(), this.f5597b.f5572s));
        }
    }
}
