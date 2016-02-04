package mobi.mmdt.ott.p095c.p096a.p098b.p099a;

/* renamed from: mobi.mmdt.ott.c.a.b.a.ac */
public class ac {
    private String f4270a;
    private boolean f4271b;
    private String f4272c;
    private String f4273d;
    private String f4274e;
    private String f4275f;
    private boolean f4276g;

    public ac(String str, int i, String str2, String str3, String str4, String str5, int i2) {
        boolean z = true;
        this.f4270a = str;
        this.f4271b = i == 1;
        this.f4272c = str2;
        this.f4273d = str4;
        this.f4274e = str5;
        this.f4275f = str3;
        if (i2 != 1) {
            z = false;
        }
        this.f4276g = z;
    }

    public String m6615a() {
        return this.f4275f;
    }

    public String m6616b() {
        return this.f4272c;
    }

    public boolean m6617c() {
        return this.f4271b;
    }

    public String m6618d() {
        return this.f4270a;
    }

    public String m6619e() {
        return this.f4273d;
    }

    public String m6620f() {
        return this.f4274e;
    }

    public boolean m6621g() {
        return this.f4276g;
    }
}
