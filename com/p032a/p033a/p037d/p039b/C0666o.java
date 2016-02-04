package com.p032a.p033a.p037d.p039b;

import android.os.Handler.Callback;
import android.os.Message;

/* renamed from: com.a.a.d.b.o */
class C0666o implements Callback {
    private C0666o() {
    }

    public boolean handleMessage(Message message) {
        if (1 != message.what && 2 != message.what) {
            return false;
        }
        C0663l c0663l = (C0663l) message.obj;
        if (1 == message.what) {
            c0663l.m4661b();
        } else {
            c0663l.m4663c();
        }
        return true;
    }
}
