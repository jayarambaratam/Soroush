package com.p032a.p033a.p037d.p049d.p054d;

import android.os.Handler.Callback;
import android.os.Message;
import com.p032a.p033a.C0872i;

/* renamed from: com.a.a.d.d.d.k */
class C0782k implements Callback {
    final /* synthetic */ C0775g f2861a;

    private C0782k(C0775g c0775g) {
        this.f2861a = c0775g;
    }

    public boolean handleMessage(Message message) {
        if (message.what == 1) {
            this.f2861a.m4944a((C0781i) message.obj);
            return true;
        }
        if (message.what == 2) {
            C0872i.m5268a((C0781i) message.obj);
        }
        return false;
    }
}
