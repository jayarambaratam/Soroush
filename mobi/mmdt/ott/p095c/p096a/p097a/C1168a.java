package mobi.mmdt.ott.p095c.p096a.p097a;

import mobi.mmdt.ott.p095c.p108d.C1302c;

/* renamed from: mobi.mmdt.ott.c.a.a.a */
public class C1168a extends C1167x {
    String f4261a;
    String f4262b;

    public C1168a(String str, String str2, String str3, String str4, String str5, String str6) {
        super(str);
        this.f4261a = str5;
        this.f4262b = str6;
        put("PhoneNo", str);
        put("VerificationToken", m6581a(str, str2));
        put("HashMethod", str3);
        put("EncryptionMethod", str4);
    }

    private String m6581a(String str, String str2) {
        return C1302c.m6874a(str + str2 + this.f4261a + this.f4262b);
    }
}
