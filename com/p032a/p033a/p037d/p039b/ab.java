package com.p032a.p033a.p037d.p039b;

import android.os.Handler.Callback;
import android.os.Message;

/* renamed from: com.a.a.d.b.ab */
class ab implements Callback {
    private ab() {
    }

    public boolean handleMessage(Message message) {
        if (message.what != 1) {
            return false;
        }
        ((C0670y) message.obj).m4680d();
        return true;
    }
}
