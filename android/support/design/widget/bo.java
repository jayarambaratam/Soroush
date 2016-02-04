package android.support.design.widget;

import android.os.Handler.Callback;
import android.os.Message;
import org.linphone.core.VideoSize;

class bo implements Callback {
    final /* synthetic */ bn f505a;

    bo(bn bnVar) {
        this.f505a = bnVar;
    }

    public boolean handleMessage(Message message) {
        switch (message.what) {
            case VideoSize.QCIF /*0*/:
                this.f505a.m583b((bq) message.obj);
                return true;
            default:
                return false;
        }
    }
}
