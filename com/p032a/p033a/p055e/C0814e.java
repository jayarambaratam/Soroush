package com.p032a.p033a.p055e;

import android.content.Context;

/* renamed from: com.a.a.e.e */
public class C0814e {
    public C0812c m5055a(Context context, C0813d c0813d) {
        return (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0 ? 1 : null) != null ? new C0815f(context, c0813d) : new C0819k();
    }
}
