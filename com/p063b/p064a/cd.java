package com.p063b.p064a;

/* renamed from: com.b.a.cd */
class cd {
    public float f3412a;
    public float f3413b;
    public float f3414c;
    public float f3415d;
    final /* synthetic */ cb f3416e;

    public cd(cb cbVar, float f, float f2, float f3, float f4) {
        this.f3416e = cbVar;
        this.f3414c = 0.0f;
        this.f3415d = 0.0f;
        this.f3412a = f;
        this.f3413b = f2;
        double sqrt = Math.sqrt((double) ((f3 * f3) + (f4 * f4)));
        if (sqrt != 0.0d) {
            this.f3414c = (float) (((double) f3) / sqrt);
            this.f3415d = (float) (((double) f4) / sqrt);
        }
    }

    public void m5626a(float f, float f2) {
        float f3 = f - this.f3412a;
        float f4 = f2 - this.f3413b;
        double sqrt = Math.sqrt((double) ((f3 * f3) + (f4 * f4)));
        if (sqrt != 0.0d) {
            this.f3414c = ((float) (((double) f3) / sqrt)) + this.f3414c;
            this.f3415d += (float) (((double) f4) / sqrt);
        }
    }

    public void m5627a(cd cdVar) {
        this.f3414c += cdVar.f3414c;
        this.f3415d += cdVar.f3415d;
    }

    public String toString() {
        return "(" + this.f3412a + "," + this.f3413b + " " + this.f3414c + "," + this.f3415d + ")";
    }
}
