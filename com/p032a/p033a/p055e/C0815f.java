package com.p032a.p033a.p055e;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* renamed from: com.a.a.e.f */
class C0815f implements C0812c {
    private final Context f2914a;
    private final C0813d f2915b;
    private boolean f2916c;
    private boolean f2917d;
    private final BroadcastReceiver f2918e;

    public C0815f(Context context, C0813d c0813d) {
        this.f2918e = new C0816g(this);
        this.f2914a = context.getApplicationContext();
        this.f2915b = c0813d;
    }

    private void m5056a() {
        if (!this.f2917d) {
            this.f2916c = m5057a(this.f2914a);
            this.f2914a.registerReceiver(this.f2918e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.f2917d = true;
        }
    }

    private boolean m5057a(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private void m5062b() {
        if (this.f2917d) {
            this.f2914a.unregisterReceiver(this.f2918e);
            this.f2917d = false;
        }
    }

    public void m5063d() {
        m5056a();
    }

    public void m5064e() {
        m5062b();
    }

    public void m5065f() {
    }
}
