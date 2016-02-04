package mobi.mmdt.ott.logic.p112a.p120c.p121a.p123b;

import android.content.Context;
import com.p065c.p066a.p067a.C0950c;
import com.p065c.p066a.p067a.C0990j;
import java.util.Map;
import mobi.mmdt.componentsutils.p079a.p084e.C1113a;
import mobi.mmdt.ott.logic.p112a.C1396d;
import mobi.mmdt.ott.logic.p157e.p159b.C1512c;
import mobi.mmdt.ott.provider.p169c.C1583c;
import mobi.mmdt.ott.provider.p169c.C1592l;
import mobi.mmdt.ott.provider.p169c.C1593m;
import mobi.mmdt.ott.provider.p169c.C1594n;
import mobi.mmdt.ott.provider.p169c.C1595o;

/* renamed from: mobi.mmdt.ott.logic.a.c.a.b.r */
public class C1384r extends C0950c {
    private Context f4752a;
    private String f4753b;
    private String f4754c;
    private String f4755d;
    private Map<String, String> f4756e;

    public C1384r(Context context, String str, Map<String, String> map, String str2, String str3) {
        super(new C0990j(C1396d.f4797c));
        this.f4752a = context;
        this.f4753b = str;
        this.f4756e = map;
        this.f4754c = str2;
        this.f4755d = str3;
    }

    private void m7204a(String str, String str2) {
        long a = (this.f4756e.get("SEND_TIME_IN_GMT") == null || ((String) this.f4756e.get("SEND_TIME_IN_GMT")).isEmpty()) ? C1113a.m6421a() : Long.parseLong((String) this.f4756e.get("SEND_TIME_IN_GMT"));
        C1583c.m7966a(this.f4752a, this.f4754c, C1594n.REPORT, this.f4755d, a, C1113a.m6421a(), C1592l.IN, C1593m.NOT_READ, str, C1595o.GROUP, str2, null, null);
        C1512c.m7631a(str);
    }

    protected boolean m7205a(Throwable th) {
        return false;
    }

    public void m7206b() {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m7207c() {
        /*
        r5 = this;
        r2 = -1;
        r1 = 0;
        r3 = 1;
        r0 = r5.f4756e;
        r4 = "MINOR_TYPE";
        r0 = r0.get(r4);
        r0 = (java.lang.String) r0;
        r4 = r0.hashCode();
        switch(r4) {
            case -2121374843: goto L_0x0019;
            case -2111016062: goto L_0x0074;
            case -2061373186: goto L_0x0041;
            case -1910032207: goto L_0x008a;
            case -595182139: goto L_0x0069;
            case -130796361: goto L_0x0055;
            case 2541179: goto L_0x002d;
            case 412406372: goto L_0x004b;
            case 842821146: goto L_0x0023;
            case 1228560761: goto L_0x0037;
            case 1415076238: goto L_0x0095;
            case 1796846346: goto L_0x005f;
            case 2114316148: goto L_0x007f;
            default: goto L_0x0014;
        };
    L_0x0014:
        r0 = r2;
    L_0x0015:
        switch(r0) {
            case 0: goto L_0x00a1;
            case 1: goto L_0x00f8;
            case 2: goto L_0x0139;
            case 3: goto L_0x0159;
            case 4: goto L_0x0195;
            case 5: goto L_0x01b8;
            case 6: goto L_0x0201;
            case 7: goto L_0x024d;
            case 8: goto L_0x028c;
            case 9: goto L_0x02bb;
            case 10: goto L_0x02d1;
            case 11: goto L_0x02e7;
            case 12: goto L_0x0305;
            default: goto L_0x0018;
        };
    L_0x0018:
        return;
    L_0x0019:
        r4 = "USER_ACTIVATION_CHANGE";
        r0 = r0.equals(r4);
        if (r0 == 0) goto L_0x0014;
    L_0x0021:
        r0 = r1;
        goto L_0x0015;
    L_0x0023:
        r4 = "USER_PROFILE_CHANGE";
        r0 = r0.equals(r4);
        if (r0 == 0) goto L_0x0014;
    L_0x002b:
        r0 = r3;
        goto L_0x0015;
    L_0x002d:
        r4 = "SEEN";
        r0 = r0.equals(r4);
        if (r0 == 0) goto L_0x0014;
    L_0x0035:
        r0 = 2;
        goto L_0x0015;
    L_0x0037:
        r4 = "GROUP_INVITATION";
        r0 = r0.equals(r4);
        if (r0 == 0) goto L_0x0014;
    L_0x003f:
        r0 = 3;
        goto L_0x0015;
    L_0x0041:
        r4 = "GROUP_CHANGE_METADATA";
        r0 = r0.equals(r4);
        if (r0 == 0) goto L_0x0014;
    L_0x0049:
        r0 = 4;
        goto L_0x0015;
    L_0x004b:
        r4 = "GROUP_REMOVE";
        r0 = r0.equals(r4);
        if (r0 == 0) goto L_0x0014;
    L_0x0053:
        r0 = 5;
        goto L_0x0015;
    L_0x0055:
        r4 = "GROUP_LEAVE";
        r0 = r0.equals(r4);
        if (r0 == 0) goto L_0x0014;
    L_0x005d:
        r0 = 6;
        goto L_0x0015;
    L_0x005f:
        r4 = "GROUP_JOIN";
        r0 = r0.equals(r4);
        if (r0 == 0) goto L_0x0014;
    L_0x0067:
        r0 = 7;
        goto L_0x0015;
    L_0x0069:
        r4 = "GROUP_CHANGE_ROLE";
        r0 = r0.equals(r4);
        if (r0 == 0) goto L_0x0014;
    L_0x0071:
        r0 = 8;
        goto L_0x0015;
    L_0x0074:
        r4 = "CHANNEL_CHANGE_METADATA";
        r0 = r0.equals(r4);
        if (r0 == 0) goto L_0x0014;
    L_0x007c:
        r0 = 9;
        goto L_0x0015;
    L_0x007f:
        r4 = "CHANNEL_MEMBERSHIP_ADD";
        r0 = r0.equals(r4);
        if (r0 == 0) goto L_0x0014;
    L_0x0087:
        r0 = 10;
        goto L_0x0015;
    L_0x008a:
        r4 = "CHANNEL_MEMBERSHIP_REMOVE";
        r0 = r0.equals(r4);
        if (r0 == 0) goto L_0x0014;
    L_0x0092:
        r0 = 11;
        goto L_0x0015;
    L_0x0095:
        r4 = "CALL_REQUEST";
        r0 = r0.equals(r4);
        if (r0 == 0) goto L_0x0014;
    L_0x009d:
        r0 = 12;
        goto L_0x0015;
    L_0x00a1:
        r0 = r5.f4756e;
        r4 = "ACTION";
        r0 = r0.get(r4);
        r0 = (java.lang.String) r0;
        r4 = r0.hashCode();
        switch(r4) {
            case -1770111376: goto L_0x00dd;
            case 204392913: goto L_0x00d3;
            default: goto L_0x00b2;
        };
    L_0x00b2:
        r0 = r2;
    L_0x00b3:
        switch(r0) {
            case 0: goto L_0x00b8;
            case 1: goto L_0x00e7;
            default: goto L_0x00b6;
        };
    L_0x00b6:
        goto L_0x0018;
    L_0x00b8:
        r0 = r5.f4756e;
        r2 = "USERNAME";
        r0 = r0.get(r2);
        r0 = (java.lang.String) r0;
        r2 = r5.f4752a;
        mobi.mmdt.ott.provider.p171e.C1607a.m8151a(r2, r0, r1);
        r1 = new mobi.mmdt.ott.logic.a.f.a.b;
        r2 = r5.f4752a;
        r1.<init>(r2, r0);
        mobi.mmdt.ott.logic.C1494c.m7540b(r1);
        goto L_0x0018;
    L_0x00d3:
        r4 = "activated";
        r0 = r0.equals(r4);
        if (r0 == 0) goto L_0x00b2;
    L_0x00db:
        r0 = r1;
        goto L_0x00b3;
    L_0x00dd:
        r4 = "deactivated";
        r0 = r0.equals(r4);
        if (r0 == 0) goto L_0x00b2;
    L_0x00e5:
        r0 = r3;
        goto L_0x00b3;
    L_0x00e7:
        r0 = r5.f4756e;
        r1 = "USERNAME";
        r0 = r0.get(r1);
        r0 = (java.lang.String) r0;
        r1 = r5.f4752a;
        mobi.mmdt.ott.provider.p171e.C1607a.m8151a(r1, r0, r3);
        goto L_0x0018;
    L_0x00f8:
        r0 = r5.f4756e;
        r1 = "CHANGE_TIME";
        r0 = r0.get(r1);
        r0 = (java.lang.String) r0;
        r1 = new org.json.JSONObject;	 Catch:{ Exception -> 0x012f }
        r0 = r5.f4756e;	 Catch:{ Exception -> 0x012f }
        r2 = "PROFILE_DATA";
        r0 = r0.get(r2);	 Catch:{ Exception -> 0x012f }
        r0 = (java.lang.String) r0;	 Catch:{ Exception -> 0x012f }
        r1.<init>(r0);	 Catch:{ Exception -> 0x012f }
        r0 = r5.f4756e;	 Catch:{ Exception -> 0x012f }
        r1 = "USERNAME";
        r0 = r0.get(r1);	 Catch:{ Exception -> 0x012f }
        r0 = (java.lang.String) r0;	 Catch:{ Exception -> 0x012f }
        r1 = new mobi.mmdt.ott.logic.a.h.b;	 Catch:{ Exception -> 0x012f }
        r2 = r5.f4752a;	 Catch:{ Exception -> 0x012f }
        r3 = 1;
        r3 = new java.lang.String[r3];	 Catch:{ Exception -> 0x012f }
        r4 = 0;
        r3[r4] = r0;	 Catch:{ Exception -> 0x012f }
        r0 = 1;
        r4 = 0;
        r1.<init>(r2, r3, r0, r4);	 Catch:{ Exception -> 0x012f }
        mobi.mmdt.ott.logic.C1494c.m7540b(r1);	 Catch:{ Exception -> 0x012f }
        goto L_0x0018;
    L_0x012f:
        r0 = move-exception;
        r1 = mobi.mmdt.ott.logic.p157e.C1515d.class;
        r2 = "Exception happened in MessageListener";
        mobi.mmdt.componentsutils.p079a.p080a.C1104b.m6367b(r1, r2, r0);
        goto L_0x0018;
    L_0x0139:
        r0 = r5.f4756e;
        r1 = "SEEN_TIME_IN_GMT";
        r0 = r0.get(r1);
        r0 = (java.lang.String) r0;
        r0 = java.lang.Long.parseLong(r0);
        r0 = java.lang.Long.valueOf(r0);
        r1 = r5.f4752a;
        r2 = r5.f4753b;
        mobi.mmdt.ott.provider.p169c.C1583c.m7962a(r1, r2, r0);
        r0 = r5.f4752a;
        mobi.mmdt.ott.provider.p169c.C1583c.m7960a(r0);
        goto L_0x0018;
    L_0x0159:
        r0 = r5.f4756e;
        r1 = "JID";
        r0 = r0.get(r1);
        r0 = (java.lang.String) r0;
        r1 = r5.f4756e;
        r2 = "USER_ID";
        r1 = r1.get(r2);
        r1 = (java.lang.String) r1;
        r2 = new mobi.mmdt.ott.logic.a.e.a.b.f;
        r4 = r5.f4752a;
        r2.<init>(r4, r0);
        mobi.mmdt.ott.logic.C1494c.m7540b(r2);
        r2 = r5.f4752a;
        r2 = mobi.mmdt.ott.logic.p157e.C1518g.m7654a(r2);
        r2 = r2.m7663b();
        r2.m7498a(r0, r3);
        r2 = p000a.p001a.p002a.C0002c.m2a();
        r3 = new mobi.mmdt.ott.logic.a.e.b.a.e;
        r3.<init>();
        r2.m17c(r3);
        r5.m7204a(r0, r1);
        goto L_0x0018;
    L_0x0195:
        r0 = r5.f4756e;
        r1 = "JID";
        r0 = r0.get(r1);
        r0 = (java.lang.String) r0;
        r1 = r5.f4756e;
        r2 = "USER_ID";
        r1 = r1.get(r2);
        r1 = (java.lang.String) r1;
        r2 = new mobi.mmdt.ott.logic.a.e.a.b.f;
        r3 = r5.f4752a;
        r2.<init>(r3, r0);
        mobi.mmdt.ott.logic.C1494c.m7540b(r2);
        r5.m7204a(r0, r1);
        goto L_0x0018;
    L_0x01b8:
        r0 = r5.f4756e;
        r1 = "JID";
        r0 = r0.get(r1);
        r0 = (java.lang.String) r0;
        r1 = r5.f4756e;
        r2 = "USER_ID";
        r1 = r1.get(r2);
        r1 = (java.lang.String) r1;
        r2 = r5.f4756e;
        r3 = "REMOVED_USER_ID";
        r2 = r2.get(r3);
        r2 = (java.lang.String) r2;
        r3 = r5.f4752a;
        r3 = mobi.mmdt.ott.p109d.p111b.C1309a.m6934a(r3);
        r3 = r3.m6942b();
        r2 = r2.equals(r3);
        if (r2 != 0) goto L_0x01f2;
    L_0x01e6:
        r2 = p000a.p001a.p002a.C0002c.m2a();
        r3 = new mobi.mmdt.ott.logic.a.e.b.a.e;
        r3.<init>();
        r2.m17c(r3);
    L_0x01f2:
        r2 = new mobi.mmdt.ott.logic.a.e.a.b.f;
        r3 = r5.f4752a;
        r2.<init>(r3, r0);
        mobi.mmdt.ott.logic.C1494c.m7540b(r2);
        r5.m7204a(r0, r1);
        goto L_0x0018;
    L_0x0201:
        r0 = r5.f4756e;
        r1 = "JID";
        r0 = r0.get(r1);
        r0 = (java.lang.String) r0;
        r1 = r5.f4756e;
        r2 = "USER_ID";
        r1 = r1.get(r2);
        r1 = (java.lang.String) r1;
        r2 = r5.f4752a;
        r2 = mobi.mmdt.ott.provider.p173g.C1622c.m8254a(r2, r0);
        if (r2 == 0) goto L_0x0018;
    L_0x021d:
        r2 = r5.f4752a;
        r2 = mobi.mmdt.ott.p109d.p111b.C1309a.m6934a(r2);
        r2 = r2.m6942b();
        r2 = r1.equals(r2);
        if (r2 != 0) goto L_0x0248;
    L_0x022d:
        r2 = new mobi.mmdt.ott.logic.a.e.a.b.f;
        r3 = r5.f4752a;
        r2.<init>(r3, r0);
        mobi.mmdt.ott.logic.C1494c.m7540b(r2);
        r2 = p000a.p001a.p002a.C0002c.m2a();
        r3 = new mobi.mmdt.ott.logic.a.e.b.a.e;
        r3.<init>();
        r2.m17c(r3);
        r5.m7204a(r0, r1);
        goto L_0x0018;
    L_0x0248:
        r5.m7204a(r0, r1);
        goto L_0x0018;
    L_0x024d:
        r0 = r5.f4756e;
        r1 = "JID";
        r0 = r0.get(r1);
        r0 = (java.lang.String) r0;
        r1 = r5.f4756e;
        r2 = "USER_ID";
        r1 = r1.get(r2);
        r1 = (java.lang.String) r1;
        r2 = r5.f4752a;
        r2 = mobi.mmdt.ott.p109d.p111b.C1309a.m6934a(r2);
        r2 = r2.m6942b();
        r2 = r1.equals(r2);
        if (r2 != 0) goto L_0x0018;
    L_0x0271:
        r2 = new mobi.mmdt.ott.logic.a.e.a.b.f;
        r3 = r5.f4752a;
        r2.<init>(r3, r0);
        mobi.mmdt.ott.logic.C1494c.m7540b(r2);
        r2 = p000a.p001a.p002a.C0002c.m2a();
        r3 = new mobi.mmdt.ott.logic.a.e.b.a.e;
        r3.<init>();
        r2.m17c(r3);
        r5.m7204a(r0, r1);
        goto L_0x0018;
    L_0x028c:
        r0 = r5.f4756e;
        r1 = "JID";
        r0 = r0.get(r1);
        r0 = (java.lang.String) r0;
        r1 = r5.f4756e;
        r2 = "USER_ID";
        r1 = r1.get(r2);
        r1 = (java.lang.String) r1;
        r2 = new mobi.mmdt.ott.logic.a.e.a.b.f;
        r3 = r5.f4752a;
        r2.<init>(r3, r0);
        mobi.mmdt.ott.logic.C1494c.m7540b(r2);
        r2 = p000a.p001a.p002a.C0002c.m2a();
        r3 = new mobi.mmdt.ott.logic.a.e.b.a.e;
        r3.<init>();
        r2.m17c(r3);
        r5.m7204a(r0, r1);
        goto L_0x0018;
    L_0x02bb:
        r1 = new mobi.mmdt.ott.logic.a.b.b.f;
        r2 = r5.f4752a;
        r0 = r5.f4756e;
        r3 = "CHANNEL_ID";
        r0 = r0.get(r3);
        r0 = (java.lang.String) r0;
        r1.<init>(r2, r0);
        mobi.mmdt.ott.logic.C1494c.m7540b(r1);
        goto L_0x0018;
    L_0x02d1:
        r0 = r5.f4756e;
        r1 = "CHANNEL_ID";
        r0 = r0.get(r1);
        r0 = (java.lang.String) r0;
        r1 = new mobi.mmdt.ott.logic.a.b.b.f;
        r2 = r5.f4752a;
        r1.<init>(r2, r0);
        mobi.mmdt.ott.logic.C1494c.m7540b(r1);
        goto L_0x0018;
    L_0x02e7:
        r0 = r5.f4756e;
        r1 = "CHANNEL_ID";
        r0 = r0.get(r1);
        r0 = (java.lang.String) r0;
        r1 = new mobi.mmdt.ott.logic.a.b.b.f;
        r2 = r5.f4752a;
        r1.<init>(r2, r0);
        mobi.mmdt.ott.logic.C1494c.m7540b(r1);
        mobi.mmdt.ott.logic.p157e.p159b.C1512c.m7635c(r0);
        r1 = r5.f4752a;
        mobi.mmdt.ott.provider.p169c.C1583c.m7989e(r1, r0);
        goto L_0x0018;
    L_0x0305:
        r0 = r5.f4756e;
        r1 = "CALLER";
        r0 = r0.get(r1);
        r0 = (java.lang.String) r0;
        r0 = r5.f4756e;
        r1 = "CALLEE";
        r0 = r0.get(r1);
        r0 = (java.lang.String) r0;
        r0 = r5.f4752a;
        r0 = mobi.mmdt.ott.logic.p161g.C1534g.m7722a(r0);
        r0.m7743d();
        goto L_0x0018;
        */
        throw new UnsupportedOperationException("Method not decompiled: mobi.mmdt.ott.logic.a.c.a.b.r.c():void");
    }

    protected void m7208d() {
    }
}
