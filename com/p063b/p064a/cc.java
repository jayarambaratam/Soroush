package com.p063b.p064a;

import java.util.ArrayList;
import java.util.List;

/* renamed from: com.b.a.cc */
class cc implements ak {
    final /* synthetic */ cb f3403a;
    private List<cd> f3404b;
    private float f3405c;
    private float f3406d;
    private cd f3407e;
    private boolean f3408f;
    private boolean f3409g;
    private int f3410h;
    private boolean f3411i;

    public cc(cb cbVar, aj ajVar) {
        this.f3403a = cbVar;
        this.f3404b = new ArrayList();
        this.f3407e = null;
        this.f3408f = false;
        this.f3409g = true;
        this.f3410h = -1;
        ajVar.m5489a(this);
        if (this.f3411i) {
            this.f3407e.m5627a((cd) this.f3404b.get(this.f3410h));
            this.f3404b.set(this.f3410h, this.f3407e);
            this.f3411i = false;
        }
        if (this.f3407e != null) {
            this.f3404b.add(this.f3407e);
        }
    }

    public List<cd> m5619a() {
        return this.f3404b;
    }

    public void m5620a(float f, float f2) {
        if (this.f3411i) {
            this.f3407e.m5627a((cd) this.f3404b.get(this.f3410h));
            this.f3404b.set(this.f3410h, this.f3407e);
            this.f3411i = false;
        }
        if (this.f3407e != null) {
            this.f3404b.add(this.f3407e);
        }
        this.f3405c = f;
        this.f3406d = f2;
        this.f3407e = new cd(this.f3403a, f, f2, 0.0f, 0.0f);
        this.f3410h = this.f3404b.size();
    }

    public void m5621a(float f, float f2, float f3, float f4) {
        this.f3407e.m5626a(f, f2);
        this.f3404b.add(this.f3407e);
        this.f3407e = new cd(this.f3403a, f3, f4, f3 - f, f4 - f2);
        this.f3411i = false;
    }

    public void m5622a(float f, float f2, float f3, float f4, float f5, float f6) {
        if (this.f3409g || this.f3408f) {
            this.f3407e.m5626a(f, f2);
            this.f3404b.add(this.f3407e);
            this.f3408f = false;
        }
        this.f3407e = new cd(this.f3403a, f5, f6, f5 - f3, f6 - f4);
        this.f3411i = false;
    }

    public void m5623a(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5) {
        this.f3408f = true;
        this.f3409g = false;
        cb.m5579b(this.f3407e.f3412a, this.f3407e.f3413b, f, f2, f3, z, z2, f4, f5, this);
        this.f3409g = true;
        this.f3411i = false;
    }

    public void m5624b() {
        this.f3404b.add(this.f3407e);
        m5625b(this.f3405c, this.f3406d);
        this.f3411i = true;
    }

    public void m5625b(float f, float f2) {
        this.f3407e.m5626a(f, f2);
        this.f3404b.add(this.f3407e);
        this.f3407e = new cd(this.f3403a, f, f2, f - this.f3407e.f3412a, f2 - this.f3407e.f3413b);
        this.f3411i = false;
    }
}
