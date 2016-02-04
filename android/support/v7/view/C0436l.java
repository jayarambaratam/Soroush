package android.support.v7.view;

import android.support.v4.view.el;
import android.support.v4.view.fc;
import android.support.v4.view.fd;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: android.support.v7.view.l */
public class C0436l {
    private final ArrayList<el> f2105a;
    private long f2106b;
    private Interpolator f2107c;
    private fc f2108d;
    private boolean f2109e;
    private final fd f2110f;

    public C0436l() {
        this.f2106b = -1;
        this.f2110f = new C0437m(this);
        this.f2105a = new ArrayList();
    }

    private void m4009c() {
        this.f2109e = false;
    }

    public C0436l m4010a(long j) {
        if (!this.f2109e) {
            this.f2106b = j;
        }
        return this;
    }

    public C0436l m4011a(el elVar) {
        if (!this.f2109e) {
            this.f2105a.add(elVar);
        }
        return this;
    }

    public C0436l m4012a(el elVar, el elVar2) {
        this.f2105a.add(elVar);
        elVar2.m2804b(elVar.m2797a());
        this.f2105a.add(elVar2);
        return this;
    }

    public C0436l m4013a(fc fcVar) {
        if (!this.f2109e) {
            this.f2108d = fcVar;
        }
        return this;
    }

    public C0436l m4014a(Interpolator interpolator) {
        if (!this.f2109e) {
            this.f2107c = interpolator;
        }
        return this;
    }

    public void m4015a() {
        if (!this.f2109e) {
            Iterator it = this.f2105a.iterator();
            while (it.hasNext()) {
                el elVar = (el) it.next();
                if (this.f2106b >= 0) {
                    elVar.m2799a(this.f2106b);
                }
                if (this.f2107c != null) {
                    elVar.m2802a(this.f2107c);
                }
                if (this.f2108d != null) {
                    elVar.m2800a(this.f2110f);
                }
                elVar.m2807c();
            }
            this.f2109e = true;
        }
    }

    public void m4016b() {
        if (this.f2109e) {
            Iterator it = this.f2105a.iterator();
            while (it.hasNext()) {
                ((el) it.next()).m2805b();
            }
            this.f2109e = false;
        }
    }
}
