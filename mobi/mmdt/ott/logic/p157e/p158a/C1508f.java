package mobi.mmdt.ott.logic.p157e.p158a;

import android.content.Context;

/* renamed from: mobi.mmdt.ott.logic.e.a.f */
public class C1508f extends C1503a implements C1505c {
    private static C1508f f5068b;
    private String f5069c;

    private C1508f(Context context) {
        super(context);
        this.f5069c = "SIMPLE_CHAT";
    }

    public static C1508f m7612a(Context context) {
        if (f5068b == null) {
            f5068b = new C1508f(context);
        }
        return f5068b;
    }

    public void m7613a(String str, String str2, String str3, String str4, long j) {
        super.m7578a(str, str2, str3, this.f5069c, str4, j);
    }

    public void m7614a(String str, String str2, String str3, String str4, Long l, String str5, Integer num, String str6, long j) {
        super.m7576a(str, str2, str3, str4, l, str5, num, this.f5069c, str6, j);
    }

    public void m7615a(String str, String str2, String str3, String str4, Long l, String str5, String str6, long j) {
        super.m7577a(str, str2, str3, str4, l, str5, this.f5069c, str6, j);
    }

    public void m7616a(String str, String str2, String str3, String str4, String str5, String str6, long j) {
        super.m7581a(str, str2, str3, str4, str5, this.f5069c, str6, j);
    }

    public void m7617a(String str, String str2, String str3, String str4, String str5, String str6, Long l, String str7, Integer num, String str8, long j) {
        super.m7579a(str, str2, str3, str4, str5, str6, l, str7, num, this.f5069c, str8, j);
    }

    public void m7618a(String str, String str2, String str3, String str4, String str5, String str6, Long l, String str7, String str8, long j) {
        super.m7580a(str, str2, str3, str4, str5, str6, l, str7, this.f5069c, str8, j);
    }
}
