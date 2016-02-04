package mobi.mmdt.ott.view.registeration.activationcode;

import android.os.CountDownTimer;
import android.os.Handler;
import net.frakbot.glowpadbackport.BuildConfig;

class ac extends CountDownTimer {
    final /* synthetic */ ActivationCodeFragment f7900a;

    ac(ActivationCodeFragment activationCodeFragment, long j, long j2) {
        this.f7900a = activationCodeFragment;
        super(j, j2);
    }

    public void onFinish() {
    }

    public void onTick(long j) {
        int i = ((int) (j / 1000)) - 1;
        this.f7900a.f7886a = i + 1;
        this.f7900a.f7893h.m4125a((float) i, 500);
        this.f7900a.f7893h.setText(i + BuildConfig.FLAVOR);
        if (i == 0) {
            this.f7900a.f7895j = false;
            new Handler().postDelayed(new ad(this), 100);
            new Handler().postDelayed(new ae(this), 600);
        }
    }
}
