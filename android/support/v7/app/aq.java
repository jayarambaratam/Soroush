package android.support.v7.app;

import android.content.Context;
import android.view.Window;
import android.view.Window.Callback;

class aq extends ao {
    aq(Context context, Window window, ah ahVar) {
        super(context, window, ahVar);
    }

    Callback m3643a(Callback callback) {
        return new ar(this, callback);
    }
}
