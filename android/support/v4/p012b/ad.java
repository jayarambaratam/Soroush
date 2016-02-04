package android.support.v4.p012b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import org.linphone.core.VideoSize;

/* renamed from: android.support.v4.b.ad */
class ad extends Handler {
    public ad() {
        super(Looper.getMainLooper());
    }

    public void handleMessage(Message message) {
        ac acVar = (ac) message.obj;
        switch (message.what) {
            case VideoSize.CIF /*1*/:
                acVar.f1060a.m1500e(acVar.f1061b[0]);
            case VideoSize.HVGA /*2*/:
                acVar.f1060a.m1508b(acVar.f1061b);
            default:
        }
    }
}
