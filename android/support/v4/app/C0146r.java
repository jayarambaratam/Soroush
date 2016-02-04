package android.support.v4.app;

import android.os.Handler;
import android.os.Message;
import org.linphone.core.VideoSize;

/* renamed from: android.support.v4.app.r */
class C0146r extends Handler {
    final /* synthetic */ C0145q f997a;

    C0146r(C0145q c0145q) {
        this.f997a = c0145q;
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case VideoSize.CIF /*1*/:
                if (this.f997a.f993e) {
                    this.f997a.m1306a(false);
                }
            case VideoSize.HVGA /*2*/:
                this.f997a.b_();
                this.f997a.f990b.m1375p();
            default:
                super.handleMessage(message);
        }
    }
}
