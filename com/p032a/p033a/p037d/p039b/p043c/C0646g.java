package com.p032a.p033a.p037d.p039b.p043c;

import android.util.Log;

/* renamed from: com.a.a.d.b.c.g */
enum C0646g extends C0645f {
    C0646g(String str, int i) {
        super(i, null);
    }

    protected void m4632a(Throwable th) {
        if (Log.isLoggable("PriorityExecutor", 6)) {
            Log.e("PriorityExecutor", "Request threw uncaught throwable", th);
        }
    }
}
