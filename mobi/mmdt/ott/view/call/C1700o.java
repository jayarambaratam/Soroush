package mobi.mmdt.ott.view.call;

import android.view.View;
import android.view.View.OnClickListener;
import com.dd.morphingbutton.MorphingButton;
import mobi.mmdt.ott.logic.C1494c;
import mobi.mmdt.ott.logic.p112a.p113a.p116b.C1332e;

/* renamed from: mobi.mmdt.ott.view.call.o */
class C1700o implements OnClickListener {
    final /* synthetic */ MorphingButton f5594a;
    final /* synthetic */ CallActivity f5595b;

    C1700o(CallActivity callActivity, MorphingButton morphingButton) {
        this.f5595b = callActivity;
        this.f5594a = morphingButton;
    }

    public void onClick(View view) {
        if (this.f5595b.f5574u) {
            if (this.f5595b.f5571r) {
                this.f5594a.m6165a(this.f5595b.m8497a(this.f5594a.getWidth(), this.f5594a.getHeight()).m6207a(this.f5595b.getString(2131230774)));
            } else {
                this.f5594a.m6165a(this.f5595b.m8503b(this.f5594a.getWidth(), this.f5594a.getHeight()).m6206a(2130838474));
            }
            this.f5595b.f5571r = !this.f5595b.f5571r;
            C1494c.m7539a(new C1332e(this.f5595b.getApplicationContext(), this.f5595b.f5571r));
        }
    }
}
