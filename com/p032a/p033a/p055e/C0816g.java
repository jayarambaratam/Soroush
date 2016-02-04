package com.p032a.p033a.p055e;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* renamed from: com.a.a.e.g */
class C0816g extends BroadcastReceiver {
    final /* synthetic */ C0815f f2919a;

    C0816g(C0815f c0815f) {
        this.f2919a = c0815f;
    }

    public void onReceive(Context context, Intent intent) {
        boolean a = this.f2919a.f2916c;
        this.f2919a.f2916c = this.f2919a.m5057a(context);
        if (a != this.f2919a.f2916c) {
            this.f2919a.f2915b.m5054a(this.f2919a.f2916c);
        }
    }
}
