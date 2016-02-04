package android.support.v7.app;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;
import org.apache.http.myHttp.entity.ContentLengthStrategy;
import org.linphone.core.VideoSize;

final class ac extends Handler {
    private WeakReference<DialogInterface> f1771a;

    public ac(DialogInterface dialogInterface) {
        this.f1771a = new WeakReference(dialogInterface);
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case -3:
            case ContentLengthStrategy.CHUNKED /*-2*/:
            case ContentLengthStrategy.IDENTITY /*-1*/:
                ((OnClickListener) message.obj).onClick((DialogInterface) this.f1771a.get(), message.what);
            case VideoSize.CIF /*1*/:
                ((DialogInterface) message.obj).dismiss();
            default:
        }
    }
}
