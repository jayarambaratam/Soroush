package com.p032a.p033a;

import android.content.Context;
import android.os.Build.VERSION;
import com.p032a.p033a.p037d.C0598a;
import com.p032a.p033a.p037d.p039b.C0655f;
import com.p032a.p033a.p037d.p039b.p040a.C0605e;
import com.p032a.p033a.p037d.p039b.p040a.C0606f;
import com.p032a.p033a.p037d.p039b.p040a.C0609i;
import com.p032a.p033a.p037d.p039b.p041b.C0619b;
import com.p032a.p033a.p037d.p039b.p041b.C0629l;
import com.p032a.p033a.p037d.p039b.p041b.C0632o;
import com.p032a.p033a.p037d.p039b.p041b.C0633n;
import com.p032a.p033a.p037d.p039b.p041b.C0635q;
import com.p032a.p033a.p037d.p039b.p043c.C0640a;
import java.util.concurrent.ExecutorService;

/* renamed from: com.a.a.k */
public class C0882k {
    private final Context f3070a;
    private C0655f f3071b;
    private C0605e f3072c;
    private C0632o f3073d;
    private ExecutorService f3074e;
    private ExecutorService f3075f;
    private C0598a f3076g;
    private C0619b f3077h;

    public C0882k(Context context) {
        this.f3070a = context.getApplicationContext();
    }

    C0872i m5317a() {
        if (this.f3074e == null) {
            this.f3074e = new C0640a(Math.max(1, Runtime.getRuntime().availableProcessors()));
        }
        if (this.f3075f == null) {
            this.f3075f = new C0640a(1);
        }
        C0635q c0635q = new C0635q(this.f3070a);
        if (this.f3072c == null) {
            if (VERSION.SDK_INT >= 11) {
                this.f3072c = new C0609i(c0635q.m4623b());
            } else {
                this.f3072c = new C0606f();
            }
        }
        if (this.f3073d == null) {
            this.f3073d = new C0633n(c0635q.m4622a());
        }
        if (this.f3077h == null) {
            this.f3077h = new C0629l(this.f3070a);
        }
        if (this.f3071b == null) {
            this.f3071b = new C0655f(this.f3073d, this.f3077h, this.f3075f, this.f3074e);
        }
        if (this.f3076g == null) {
            this.f3076g = C0598a.f2534d;
        }
        return new C0872i(this.f3071b, this.f3073d, this.f3072c, this.f3070a, this.f3076g);
    }
}
