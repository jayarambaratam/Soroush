package mobi.mmdt.ott.view.call;

import android.view.View;
import android.view.View.OnClickListener;
import com.dd.morphingbutton.MorphingButton;
import mobi.mmdt.ott.logic.C1494c;
import mobi.mmdt.ott.logic.p112a.p113a.p116b.C1333f;

/* renamed from: mobi.mmdt.ott.view.call.n */
class C1699n implements OnClickListener {
    final /* synthetic */ MorphingButton f5592a;
    final /* synthetic */ CallActivity f5593b;

    C1699n(CallActivity callActivity, MorphingButton morphingButton) {
        this.f5593b = callActivity;
        this.f5592a = morphingButton;
    }

    public void onClick(View view) {
        if (this.f5593b.f5570q) {
            this.f5592a.m6165a(this.f5593b.m8497a(this.f5592a.getWidth(), this.f5592a.getHeight()).m6207a(this.f5593b.getString(2131230787)));
        } else {
            this.f5592a.m6165a(this.f5593b.m8503b(this.f5592a.getWidth(), this.f5592a.getHeight()).m6206a(2130838475));
        }
        this.f5593b.f5570q = !this.f5593b.f5570q;
        C1494c.m7539a(new C1333f(this.f5593b.getApplicationContext(), this.f5593b.f5570q));
    }
}
