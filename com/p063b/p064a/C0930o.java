package com.p063b.p064a;

/* renamed from: com.b.a.o */
public class C0930o implements Cloneable {
    public float f3576a;
    public float f3577b;
    public float f3578c;
    public float f3579d;

    public C0930o(float f, float f2, float f3, float f4) {
        this.f3576a = f;
        this.f3577b = f2;
        this.f3578c = f3;
        this.f3579d = f4;
    }

    public static C0930o m5805a(float f, float f2, float f3, float f4) {
        return new C0930o(f, f2, f3 - f, f4 - f2);
    }

    public float m5806a() {
        return this.f3576a + this.f3578c;
    }

    public void m5807a(C0930o c0930o) {
        if (c0930o.f3576a < this.f3576a) {
            this.f3576a = c0930o.f3576a;
        }
        if (c0930o.f3577b < this.f3577b) {
            this.f3577b = c0930o.f3577b;
        }
        if (c0930o.m5806a() > m5806a()) {
            this.f3578c = c0930o.m5806a() - this.f3576a;
        }
        if (c0930o.m5808b() > m5808b()) {
            this.f3579d = c0930o.m5808b() - this.f3577b;
        }
    }

    public float m5808b() {
        return this.f3577b + this.f3579d;
    }

    public String toString() {
        return "[" + this.f3576a + " " + this.f3577b + " " + this.f3578c + " " + this.f3579d + "]";
    }
}
