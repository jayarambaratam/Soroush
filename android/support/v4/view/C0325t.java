package android.support.v4.view;

import android.os.Handler;
import android.os.Message;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: android.support.v4.view.t */
class C0325t extends Handler {
    final /* synthetic */ C0324s f1417a;

    C0325t(C0324s c0324s) {
        this.f1417a = c0324s;
    }

    C0325t(C0324s c0324s, Handler handler) {
        this.f1417a = c0324s;
        super(handler.getLooper());
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case VideoSize.CIF /*1*/:
                this.f1417a.f1401i.onShowPress(this.f1417a.f1408p);
            case VideoSize.HVGA /*2*/:
                this.f1417a.m2934c();
            case Version.API03_CUPCAKE_15 /*3*/:
                if (this.f1417a.f1402j == null) {
                    return;
                }
                if (this.f1417a.f1403k) {
                    this.f1417a.f1404l = true;
                } else {
                    this.f1417a.f1402j.onSingleTapConfirmed(this.f1417a.f1408p);
                }
            default:
                throw new RuntimeException("Unknown message " + message);
        }
    }
}
