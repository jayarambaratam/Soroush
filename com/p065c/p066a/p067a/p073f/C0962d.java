package com.p065c.p066a.p067a.p073f;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* renamed from: com.c.a.a.f.d */
public class C0962d implements C0960a, C0961c {
    private C0958b f3661a;

    public C0962d(Context context) {
        context.getApplicationContext().registerReceiver(new C0963e(this), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    public void m5941a(C0958b c0958b) {
        this.f3661a = c0958b;
    }

    public boolean m5942a(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }
}
