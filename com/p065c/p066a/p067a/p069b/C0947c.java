package com.p065c.p066a.p067a.p069b;

import android.content.Context;
import com.p065c.p066a.p067a.C0989h;
import com.p065c.p066a.p067a.p072e.C0955a;
import com.p065c.p066a.p067a.p073f.C0962d;

/* renamed from: com.c.a.a.b.c */
public final class C0947c {
    private C0945a f3618a;
    private Context f3619b;

    public C0947c(Context context) {
        this.f3618a = new C0945a();
        this.f3619b = context.getApplicationContext();
    }

    public C0945a m5855a() {
        if (this.f3618a.f3614f == null) {
            this.f3618a.f3614f = new C0989h();
        }
        if (this.f3618a.f3616h == null) {
            this.f3618a.f3616h = new C0962d(this.f3619b);
        }
        return this.f3618a;
    }

    public C0947c m5856a(int i) {
        this.f3618a.f3612d = i;
        return this;
    }

    public C0947c m5857a(C0955a c0955a) {
        this.f3618a.f3617i = c0955a;
        return this;
    }

    public C0947c m5858b(int i) {
        this.f3618a.f3610b = i;
        return this;
    }

    public C0947c m5859c(int i) {
        this.f3618a.f3611c = i;
        return this;
    }

    public C0947c m5860d(int i) {
        this.f3618a.f3613e = i;
        return this;
    }
}
