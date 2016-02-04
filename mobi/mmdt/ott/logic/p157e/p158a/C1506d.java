package mobi.mmdt.ott.logic.p157e.p158a;

import android.content.Context;
import mobi.mmdt.ott.provider.p169c.C1583c;
import mobi.mmdt.ott.provider.p169c.C1593m;

/* renamed from: mobi.mmdt.ott.logic.e.a.d */
public class C1506d extends C1503a implements C1505c {
    private static C1506d f5064b;
    private String f5065c;

    private C1506d(Context context) {
        super(context);
        this.f5065c = "CHANNEL_CHAT";
    }

    public static C1506d m7598a(Context context) {
        if (f5064b == null) {
            f5064b = new C1506d(context);
        }
        return f5064b;
    }

    public void m7599a(String str, String str2, String str3, String str4, long j) {
        super.m7578a(str, str2, str3, this.f5065c, str4, j);
        C1583c.m7965a(this.a, str3, C1593m.SEEN);
    }

    public void m7600a(String str, String str2, String str3, String str4, Long l, String str5, Integer num, String str6, long j) {
        super.m7576a(str, str2, str3, str4, l, str5, num, this.f5065c, str6, j);
        C1583c.m7965a(this.a, str2, C1593m.SEEN);
    }

    public void m7601a(String str, String str2, String str3, String str4, Long l, String str5, String str6, long j) {
        super.m7577a(str, str2, str3, str4, l, str5, this.f5065c, str6, j);
        C1583c.m7965a(this.a, str2, C1593m.SEEN);
    }

    public void m7602a(String str, String str2, String str3, String str4, String str5, String str6, long j) {
        super.m7581a(str, str2, str3, str4, str5, this.f5065c, str6, j);
        C1583c.m7965a(this.a, str2, C1593m.SEEN);
    }

    public void m7603a(String str, String str2, String str3, String str4, String str5, String str6, Long l, String str7, Integer num, String str8, long j) {
        super.m7579a(str, str2, str3, str4, str5, str6, l, str7, num, this.f5065c, str8, j);
        C1583c.m7965a(this.a, str2, C1593m.SEEN);
    }

    public void m7604a(String str, String str2, String str3, String str4, String str5, String str6, Long l, String str7, String str8, long j) {
        super.m7580a(str, str2, str3, str4, str5, str6, l, str7, this.f5065c, str8, j);
        C1583c.m7965a(this.a, str2, C1593m.SEEN);
    }
}
