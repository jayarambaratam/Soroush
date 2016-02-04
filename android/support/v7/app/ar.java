package android.support.v7.app;

import android.view.ActionMode;
import android.view.Window.Callback;
import org.linphone.core.VideoSize;

class ar extends ap {
    final /* synthetic */ aq f1782c;

    ar(aq aqVar, Callback callback) {
        this.f1782c = aqVar;
        super(aqVar, callback);
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return null;
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
        if (this.f1782c.m3641l()) {
            switch (i) {
                case VideoSize.QCIF /*0*/:
                    return m3642a(callback);
            }
        }
        return super.onWindowStartingActionMode(callback, i);
    }
}
