package mobi.mmdt.ott.view.registeration.activationcode;

import android.view.View;
import android.view.View.OnClickListener;

/* renamed from: mobi.mmdt.ott.view.registeration.activationcode.y */
class C2430y implements OnClickListener {
    final /* synthetic */ ActivationCodeFragment f7930a;

    C2430y(ActivationCodeFragment activationCodeFragment) {
        this.f7930a = activationCodeFragment;
    }

    public void onClick(View view) {
        if (!this.f7930a.f7895j && !this.f7930a.f7896k) {
            this.f7930a.f7896k = true;
            this.f7930a.f7887b.m10584m();
        }
    }
}
