package mobi.mmdt.ott.view.call;

import android.os.CountDownTimer;
import java.util.concurrent.TimeUnit;
import mobi.mmdt.componentsutils.p079a.C1111c;

/* renamed from: mobi.mmdt.ott.view.call.m */
class C1698m extends CountDownTimer {
    final /* synthetic */ CallActivity f5591a;

    C1698m(CallActivity callActivity, long j, long j2) {
        this.f5591a = callActivity;
        super(j, j2);
    }

    public void onFinish() {
    }

    public void onTick(long j) {
        int toSeconds = (int) ((1000000 - TimeUnit.MILLISECONDS.toSeconds(j)) - 1);
        if (toSeconds < 0) {
            toSeconds = 0;
        }
        if (this.f5591a.f5566m != null) {
            this.f5591a.f5566m.setText(C1111c.m6410d(toSeconds));
        }
    }
}
