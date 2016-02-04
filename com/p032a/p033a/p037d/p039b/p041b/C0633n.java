package com.p032a.p033a.p037d.p039b.p041b;

import android.annotation.SuppressLint;
import com.p032a.p033a.p037d.C0667c;
import com.p032a.p033a.p037d.p039b.C0670y;
import com.p032a.p033a.p042j.C0631e;

/* renamed from: com.a.a.d.b.b.n */
public class C0633n extends C0631e<C0667c, C0670y<?>> implements C0632o {
    private C0634p f2603a;

    public C0633n(int i) {
        super(i);
    }

    protected int m4610a(C0670y<?> c0670y) {
        return c0670y.m4679c();
    }

    public /* synthetic */ C0670y m4612a(C0667c c0667c) {
        return (C0670y) super.m4604c(c0667c);
    }

    @SuppressLint({"InlinedApi"})
    public void m4613a(int i) {
        if (i >= 60) {
            m4598a();
        } else if (i >= 40) {
            m4603b(m4600b() / 2);
        }
    }

    public void m4614a(C0634p c0634p) {
        this.f2603a = c0634p;
    }

    protected void m4615a(C0667c c0667c, C0670y<?> c0670y) {
        if (this.f2603a != null) {
            this.f2603a.m4618b(c0670y);
        }
    }

    public /* bridge */ /* synthetic */ C0670y m4617b(C0667c c0667c, C0670y c0670y) {
        return (C0670y) super.m4602b(c0667c, c0670y);
    }
}
