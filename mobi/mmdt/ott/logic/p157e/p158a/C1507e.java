package mobi.mmdt.ott.logic.p157e.p158a;

import android.content.Context;
import mobi.mmdt.ott.provider.p169c.C1583c;
import mobi.mmdt.ott.provider.p169c.C1593m;

/* renamed from: mobi.mmdt.ott.logic.e.a.e */
public class C1507e extends C1503a implements C1505c {
    private static C1507e f5066b;
    private String f5067c;

    private C1507e(Context context) {
        super(context);
        this.f5067c = "GROUP_CHAT";
    }

    public static C1507e m7605a(Context context) {
        if (f5066b == null) {
            f5066b = new C1507e(context);
        }
        return f5066b;
    }

    public void m7606a(String str, String str2, String str3, String str4, long j) {
        super.m7578a(str, str2, str3, this.f5067c, str4, j);
        C1583c.m7965a(this.a, str3, C1593m.SEEN);
    }

    public void m7607a(String str, String str2, String str3, String str4, Long l, String str5, Integer num, String str6, long j) {
        super.m7576a(str, str2, str3, str4, l, str5, num, this.f5067c, str6, j);
        C1583c.m7965a(this.a, str2, C1593m.SEEN);
    }

    public void m7608a(String str, String str2, String str3, String str4, Long l, String str5, String str6, long j) {
        super.m7577a(str, str2, str3, str4, l, str5, this.f5067c, str6, j);
        C1583c.m7965a(this.a, str2, C1593m.SEEN);
    }

    public void m7609a(String str, String str2, String str3, String str4, String str5, String str6, long j) {
        super.m7581a(str, str2, str3, str4, str5, this.f5067c, str6, j);
        C1583c.m7965a(this.a, str2, C1593m.SEEN);
    }

    public void m7610a(String str, String str2, String str3, String str4, String str5, String str6, Long l, String str7, Integer num, String str8, long j) {
        super.m7579a(str, str2, str3, str4, str5, str6, l, str7, num, this.f5067c, str8, j);
        C1583c.m7965a(this.a, str2, C1593m.SEEN);
    }

    public void m7611a(String str, String str2, String str3, String str4, String str5, String str6, Long l, String str7, String str8, long j) {
        super.m7580a(str, str2, str3, str4, str5, str6, l, str7, this.f5067c, str8, j);
        C1583c.m7965a(this.a, str2, C1593m.SEEN);
    }
}
