package android.support.v7.app;

import android.content.Context;
import android.view.Window;
import android.view.Window.Callback;

class ao extends an {
    private boolean f1780r;

    ao(Context context, Window window, ah ahVar) {
        super(context, window, ahVar);
        this.f1780r = true;
    }

    Callback m3640a(Callback callback) {
        return new ap(this, callback);
    }

    public boolean m3641l() {
        return this.f1780r;
    }
}
