package mobi.mmdt.ott.view.call;

import android.view.View;
import net.frakbot.glowpadbackport.GlowPadView.OnTriggerListener;

/* renamed from: mobi.mmdt.ott.view.call.r */
class C1703r implements OnTriggerListener {
    final /* synthetic */ CallActivity f5599a;

    C1703r(CallActivity callActivity) {
        this.f5599a = callActivity;
    }

    public void onFinishFinalAnimation() {
    }

    public void onGrabbed(View view, int i) {
        this.f5599a.f5569p = true;
    }

    public void onGrabbedStateChange(View view, int i) {
    }

    public void onReleased(View view, int i) {
        this.f5599a.f5569p = false;
    }

    public void onTrigger(View view, int i) {
        if (i == 0) {
            this.f5599a.m8521l();
        } else {
            this.f5599a.m8523m();
        }
        this.f5599a.f5567n.reset(true);
    }
}
