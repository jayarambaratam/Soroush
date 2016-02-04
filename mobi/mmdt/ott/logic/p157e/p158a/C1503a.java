package mobi.mmdt.ott.logic.p157e.p158a;

import android.content.Context;
import mobi.mmdt.componentsutils.p079a.p084e.C1113a;
import mobi.mmdt.ott.logic.p155b.C1488b;
import mobi.mmdt.ott.logic.p157e.C1514c;
import mobi.mmdt.ott.provider.p169c.C1583c;
import mobi.mmdt.ott.provider.p169c.C1593m;
import mobi.mmdt.ott.provider.p171e.C1607a;
import net.frakbot.glowpadbackport.BuildConfig;

/* renamed from: mobi.mmdt.ott.logic.e.a.a */
public abstract class C1503a {
    protected final Context f5060a;

    protected C1503a(Context context) {
        this.f5060a = context;
    }

    private C1593m m7574a(String str) {
        if (!C1607a.m8167d(this.f5060a, str) || C1113a.m6421a() - C1607a.m8152a(this.f5060a, str).m8207i().longValue() >= 180000) {
            return C1593m.PENDING_RETRANSMIT;
        }
        C1488b.m7514a(this.f5060a).m7515a();
        return C1593m.PENDING;
    }

    private void m7575a(String str, String str2, long j) {
        C1583c.m7961a(this.f5060a, str2, j, j);
        C1583c.m7965a(this.f5060a, str2, m7574a(str));
    }

    protected void m7576a(String str, String str2, String str3, String str4, Long l, String str5, Integer num, String str6, String str7, long j) {
        String str8 = str;
        String str9 = str2;
        String str10 = str6;
        long j2 = j;
        String str11 = str4;
        C1514c.m7637a(this.f5060a).m7638a(str8, str9, str10, j2, str11, l.longValue(), (long) num.intValue(), str5, str3, str7);
        m7575a(str, str2, j);
    }

    protected void m7577a(String str, String str2, String str3, String str4, Long l, String str5, String str6, String str7, long j) {
        C1514c.m7637a(this.f5060a).m7641a(str, str2, str6, BuildConfig.FLAVOR, j, str4, l.longValue(), str5, str3, str7);
        m7575a(str, str2, j);
    }

    protected void m7578a(String str, String str2, String str3, String str4, String str5, long j) {
        C1514c.m7637a(this.f5060a).m7640a(str, str3, str4, str2, j, str5);
        m7575a(str, str3, j);
    }

    protected void m7579a(String str, String str2, String str3, String str4, String str5, String str6, Long l, String str7, Integer num, String str8, String str9, long j) {
        String str10 = str;
        String str11 = str2;
        String str12 = str8;
        String str13 = str3;
        long j2 = j;
        String str14 = str5;
        String str15 = str6;
        C1514c.m7637a(this.f5060a).m7642a(str10, str11, str12, str13, j2, str14, str15, l.longValue(), (long) num.intValue(), str7, str4, str9);
        m7575a(str, str2, j);
    }

    protected void m7580a(String str, String str2, String str3, String str4, String str5, String str6, Long l, String str7, String str8, String str9, long j) {
        C1514c.m7637a(this.f5060a).m7643a(str, str2, str8, str3, j, str5, str6, l.longValue(), str7, str4, str9);
        m7575a(str, str2, j);
    }

    protected void m7581a(String str, String str2, String str3, String str4, String str5, String str6, String str7, long j) {
        C1514c.m7637a(this.f5060a).m7639a(str, str2, str6, j, str3, str4, str5, str7);
        m7575a(str, str2, j);
    }
}
