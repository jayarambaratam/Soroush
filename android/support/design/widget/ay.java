package android.support.design.widget;

import android.os.Handler.Callback;
import android.os.Message;
import org.linphone.core.VideoSize;

final class ay implements Callback {
    ay() {
    }

    public boolean handleMessage(Message message) {
        switch (message.what) {
            case VideoSize.QCIF /*0*/:
                ((Snackbar) message.obj).m398c();
                return true;
            case VideoSize.CIF /*1*/:
                ((Snackbar) message.obj).m396b(message.arg1);
                return true;
            default:
                return false;
        }
    }
}
