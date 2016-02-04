package mobi.mmdt.ott.logic.p112a.p120c.p121a.p123b;

import android.content.Context;
import com.p065c.p066a.p067a.C0950c;
import com.p065c.p066a.p067a.C0990j;
import java.util.Map;
import mobi.mmdt.ott.logic.C1494c;
import mobi.mmdt.ott.logic.p112a.C1396d;
import mobi.mmdt.ott.logic.p112a.p147h.C1451b;

/* renamed from: mobi.mmdt.ott.logic.a.c.a.b.t */
public class C1386t extends C0950c {
    private Context f4763a;
    private String f4764b;
    private String f4765c;
    private String f4766d;
    private Map<String, String> f4767e;

    public C1386t(Context context, String str, String str2, String str3, Map<String, String> map) {
        super(new C0990j(C1396d.f4797c));
        this.f4764b = str;
        this.f4765c = str2;
        this.f4766d = str3;
        this.f4767e = map;
        this.f4763a = context;
    }

    protected boolean m7213a(Throwable th) {
        return false;
    }

    public void m7214b() {
        C1494c.m7541c(new C1451b(this.f4763a, new String[]{this.f4764b}, false, false));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m7215c() {
        /*
        r34 = this;
        r16 = 0;
        r15 = 0;
        r5 = 0;
        r0 = r34;
        r2 = r0.f4767e;
        r3 = "SEND_TIME_IN_GMT";
        r2 = r2.get(r3);
        r2 = (java.lang.String) r2;
        r6 = java.lang.Long.parseLong(r2);
        r0 = r34;
        r2 = r0.f4763a;
        r0 = r34;
        r3 = r0.f4764b;
        r4 = java.lang.Long.valueOf(r6);
        mobi.mmdt.ott.provider.p169c.C1583c.m7962a(r2, r3, r4);
        r0 = r34;
        r2 = r0.f4767e;
        r3 = "MINOR_TYPE";
        r2 = r2.get(r3);
        r2 = (java.lang.String) r2;
        r3 = -1;
        r4 = r2.hashCode();
        switch(r4) {
            case -1172269795: goto L_0x004d;
            case 2157948: goto L_0x0057;
            case 2571565: goto L_0x0043;
            default: goto L_0x0037;
        };
    L_0x0037:
        r2 = r3;
    L_0x0038:
        switch(r2) {
            case 0: goto L_0x0061;
            case 1: goto L_0x011b;
            case 2: goto L_0x0162;
            default: goto L_0x003b;
        };
    L_0x003b:
        r2 = "Undefined type";
        r0 = r34;
        mobi.mmdt.componentsutils.p079a.p080a.C1104b.m6366b(r0, r2);
    L_0x0042:
        return;
    L_0x0043:
        r4 = "TEXT";
        r2 = r2.equals(r4);
        if (r2 == 0) goto L_0x0037;
    L_0x004b:
        r2 = 0;
        goto L_0x0038;
    L_0x004d:
        r4 = "STICKER";
        r2 = r2.equals(r4);
        if (r2 == 0) goto L_0x0037;
    L_0x0055:
        r2 = 1;
        goto L_0x0038;
    L_0x0057:
        r4 = "FILE";
        r2 = r2.equals(r4);
        if (r2 == 0) goto L_0x0037;
    L_0x005f:
        r2 = 2;
        goto L_0x0038;
    L_0x0061:
        r4 = mobi.mmdt.ott.provider.p169c.C1594n.TEXT;
        r33 = r5;
    L_0x0065:
        r8 = mobi.mmdt.componentsutils.p079a.p084e.C1113a.m6421a();
        r10 = mobi.mmdt.ott.provider.p169c.C1592l.IN;
        r0 = r34;
        r2 = r0.f4764b;
        r0 = r34;
        r3 = r0.f4763a;
        r3 = mobi.mmdt.ott.p109d.p111b.C1309a.m6934a(r3);
        r3 = r3.m6942b();
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0083;
    L_0x0081:
        r10 = mobi.mmdt.ott.provider.p169c.C1592l.OUT;
    L_0x0083:
        r2 = mobi.mmdt.ott.MyApplication.m6445a();
        r2 = r2.f4177h;
        if (r2 == 0) goto L_0x009b;
    L_0x008b:
        r2 = mobi.mmdt.ott.MyApplication.m6445a();
        r2 = r2.f4177h;
        r0 = r34;
        r3 = r0.f4764b;
        r2 = r2.equals(r3);
        if (r2 != 0) goto L_0x0207;
    L_0x009b:
        r17 = 0;
        r0 = r34;
        r2 = r0.f4767e;
        r3 = "REPLY_ON_MESSAGE_ID";
        r2 = r2.get(r3);
        if (r2 == 0) goto L_0x00c9;
    L_0x00a9:
        r0 = r34;
        r2 = r0.f4767e;
        r3 = "REPLY_ON_MESSAGE_ID";
        r2 = r2.get(r3);
        r2 = (java.lang.String) r2;
        r2 = r2.isEmpty();
        if (r2 != 0) goto L_0x00c9;
    L_0x00bb:
        r0 = r34;
        r2 = r0.f4767e;
        r3 = "REPLY_ON_MESSAGE_ID";
        r2 = r2.get(r3);
        r2 = (java.lang.String) r2;
        r17 = r2;
    L_0x00c9:
        r2 = new mobi.mmdt.ott.d.a.b;
        r0 = r34;
        r3 = r0.f4766d;
        r0 = r34;
        r5 = r0.f4765c;
        r11 = mobi.mmdt.ott.provider.p169c.C1593m.NOT_READ;
        r0 = r34;
        r12 = r0.f4764b;
        r13 = mobi.mmdt.ott.provider.p169c.C1595o.SINGLE;
        r0 = r34;
        r14 = r0.f4764b;
        r2.<init>(r3, r4, r5, r6, r8, r10, r11, r12, r13, r14, r15, r16, r17);
        r0 = r34;
        r3 = r0.f4763a;
        r3 = mobi.mmdt.ott.logic.p157e.C1509a.m7621a(r3);
        r0 = r34;
        r4 = r0.f4767e;
        r0 = r33;
        r3.m7626a(r2, r0, r4);
    L_0x00f3:
        r0 = r34;
        r2 = r0.f4767e;
        r3 = "MINOR_TYPE";
        r2 = r2.get(r3);
        r2 = (java.lang.String) r2;
        r3 = "TEXT";
        r2 = r2.equals(r3);
        if (r2 != 0) goto L_0x0042;
    L_0x0107:
        if (r15 == 0) goto L_0x0042;
    L_0x0109:
        r2 = new mobi.mmdt.ott.logic.a.c.a.b.b;
        r0 = r34;
        r3 = r0.f4763a;
        r0 = r34;
        r4 = r0.f4767e;
        r2.<init>(r3, r15, r4);
        mobi.mmdt.ott.logic.C1494c.m7541c(r2);
        goto L_0x0042;
    L_0x011b:
        r8 = mobi.mmdt.ott.provider.p169c.C1594n.STICKER;
        r0 = r34;
        r2 = r0.f4767e;
        r3 = "STICKER_ID";
        r2 = r2.get(r3);
        r2 = (java.lang.String) r2;
        r0 = r34;
        r3 = r0.f4767e;
        r4 = "STICKER_PACKAGE_ID";
        r3 = r3.get(r4);
        r3 = (java.lang.String) r3;
        r0 = r34;
        r4 = r0.f4767e;
        r9 = "STICKER_VERSION";
        r4 = r4.get(r9);
        r4 = (java.lang.String) r4;
        if (r4 == 0) goto L_0x02bc;
    L_0x0143:
        if (r2 == 0) goto L_0x02bc;
    L_0x0145:
        if (r3 == 0) goto L_0x02bc;
    L_0x0147:
        r9 = r4.isEmpty();
        if (r9 != 0) goto L_0x02bc;
    L_0x014d:
        r9 = r2.isEmpty();
        if (r9 != 0) goto L_0x02bc;
    L_0x0153:
        r9 = r3.isEmpty();
        if (r9 != 0) goto L_0x02bc;
    L_0x0159:
        r16 = mobi.mmdt.ott.provider.p174h.C1629b.m8295a(r4, r3, r2);
        r33 = r5;
        r4 = r8;
        goto L_0x0065;
    L_0x0162:
        r0 = r34;
        r2 = r0.f4767e;
        r3 = "FILE_TYPE";
        r2 = r2.get(r3);
        r2 = (java.lang.String) r2;
        r3 = -1;
        r4 = r2.hashCode();
        switch(r4) {
            case 327328941: goto L_0x0197;
            case 796404377: goto L_0x0183;
            case 802160718: goto L_0x01a1;
            case 808293817: goto L_0x018d;
            default: goto L_0x0176;
        };
    L_0x0176:
        r2 = r3;
    L_0x0177:
        switch(r2) {
            case 0: goto L_0x01ab;
            case 1: goto L_0x01c5;
            case 2: goto L_0x01db;
            case 3: goto L_0x01f1;
            default: goto L_0x017a;
        };
    L_0x017a:
        r2 = "Undefined file type";
        r0 = r34;
        mobi.mmdt.componentsutils.p079a.p080a.C1104b.m6366b(r0, r2);
        goto L_0x0042;
    L_0x0183:
        r4 = "FILE_TYPE_IMAGE";
        r2 = r2.equals(r4);
        if (r2 == 0) goto L_0x0176;
    L_0x018b:
        r2 = 0;
        goto L_0x0177;
    L_0x018d:
        r4 = "FILE_TYPE_VIDEO";
        r2 = r2.equals(r4);
        if (r2 == 0) goto L_0x0176;
    L_0x0195:
        r2 = 1;
        goto L_0x0177;
    L_0x0197:
        r4 = "FILE_TYPE_PUSH_TO_TALK";
        r2 = r2.equals(r4);
        if (r2 == 0) goto L_0x0176;
    L_0x019f:
        r2 = 2;
        goto L_0x0177;
    L_0x01a1:
        r4 = "FILE_TYPE_OTHER";
        r2 = r2.equals(r4);
        if (r2 == 0) goto L_0x0176;
    L_0x01a9:
        r2 = 3;
        goto L_0x0177;
    L_0x01ab:
        r3 = mobi.mmdt.ott.provider.p169c.C1594n.IMAGE;
        r2 = new mobi.mmdt.ott.logic.a.c.a.b.h;
        r0 = r34;
        r4 = r0.f4763a;
        r0 = r34;
        r5 = r0.f4767e;
        r8 = mobi.mmdt.ott.provider.p170d.C1605j.IMAGE;
        r2.<init>(r4, r5, r8);
        r2 = r2.m7152a();
    L_0x01c0:
        r33 = r2;
        r4 = r3;
        goto L_0x0065;
    L_0x01c5:
        r3 = mobi.mmdt.ott.provider.p169c.C1594n.VIDEO;
        r2 = new mobi.mmdt.ott.logic.a.c.a.b.h;
        r0 = r34;
        r4 = r0.f4763a;
        r0 = r34;
        r5 = r0.f4767e;
        r8 = mobi.mmdt.ott.provider.p170d.C1605j.VIDEO;
        r2.<init>(r4, r5, r8);
        r2 = r2.m7152a();
        goto L_0x01c0;
    L_0x01db:
        r3 = mobi.mmdt.ott.provider.p169c.C1594n.PUSH_TO_TALK;
        r2 = new mobi.mmdt.ott.logic.a.c.a.b.h;
        r0 = r34;
        r4 = r0.f4763a;
        r0 = r34;
        r5 = r0.f4767e;
        r8 = mobi.mmdt.ott.provider.p170d.C1605j.PUSH_TO_TALK;
        r2.<init>(r4, r5, r8);
        r2 = r2.m7152a();
        goto L_0x01c0;
    L_0x01f1:
        r3 = mobi.mmdt.ott.provider.p169c.C1594n.FILE;
        r2 = new mobi.mmdt.ott.logic.a.c.a.b.h;
        r0 = r34;
        r4 = r0.f4763a;
        r0 = r34;
        r5 = r0.f4767e;
        r8 = mobi.mmdt.ott.provider.p170d.C1605j.OTHER;
        r2.<init>(r4, r5, r8);
        r2 = r2.m7152a();
        goto L_0x01c0;
    L_0x0207:
        if (r33 == 0) goto L_0x0255;
    L_0x0209:
        r0 = r34;
        r0 = r0.f4763a;
        r18 = r0;
        r19 = r33.m8082n();
        r20 = r33.m8069a();
        r21 = r33.m8079k();
        r22 = r33.m8073e();
        r23 = r33.m8078j();
        r24 = r33.m8077i();
        r26 = 0;
        r27 = r33.m8081m();
        r28 = r33.m8080l();
        r29 = r33.m8075g();
        r30 = r33.m8071c();
        r31 = r33.m8072d();
        r32 = r33.m8070b();
        r33 = r33.m8074f();
        r2 = mobi.mmdt.ott.provider.p170d.C1598c.m8100a(r18, r19, r20, r21, r22, r23, r24, r26, r27, r28, r29, r30, r31, r32, r33);
        r2 = r2.getLastPathSegment();
        r2 = java.lang.Long.parseLong(r2);
        r15 = java.lang.Long.valueOf(r2);
    L_0x0255:
        r0 = r34;
        r2 = r0.f4763a;
        r0 = r34;
        r3 = r0.f4766d;
        r0 = r34;
        r5 = r0.f4765c;
        r11 = mobi.mmdt.ott.provider.p169c.C1593m.READ;
        r0 = r34;
        r12 = r0.f4764b;
        r13 = mobi.mmdt.ott.provider.p169c.C1595o.SINGLE;
        r0 = r34;
        r14 = r0.f4764b;
        mobi.mmdt.ott.provider.p169c.C1583c.m7966a(r2, r3, r4, r5, r6, r8, r10, r11, r12, r13, r14, r15, r16);
        r0 = r34;
        r2 = r0.f4767e;
        r3 = "REPLY_ON_MESSAGE_ID";
        r2 = r2.get(r3);
        if (r2 == 0) goto L_0x00f3;
    L_0x027c:
        r0 = r34;
        r2 = r0.f4767e;
        r3 = "REPLY_ON_MESSAGE_ID";
        r2 = r2.get(r3);
        r2 = (java.lang.String) r2;
        r2 = r2.isEmpty();
        if (r2 != 0) goto L_0x00f3;
    L_0x028e:
        r0 = r34;
        r2 = r0.f4767e;
        r3 = "REPLY_ON_MESSAGE_ID";
        r2 = r2.get(r3);
        r2 = (java.lang.String) r2;
        r0 = r34;
        r3 = r0.f4763a;
        r0 = r34;
        r4 = r0.f4766d;
        mobi.mmdt.ott.provider.p169c.C1583c.m7976b(r3, r4, r2);
        r0 = r34;
        r3 = r0.f4763a;
        r2 = mobi.mmdt.ott.provider.p169c.C1583c.m8003n(r3, r2);
        r0 = r34;
        r3 = r0.f4763a;
        r0 = r34;
        r4 = r0.f4766d;
        r5 = mobi.mmdt.ott.provider.p169c.C1595o.SINGLE;
        mobi.mmdt.ott.logic.p112a.p120c.p121a.p123b.C1387u.m7218a(r3, r4, r2, r5);
        goto L_0x00f3;
    L_0x02bc:
        r33 = r5;
        r4 = r8;
        goto L_0x0065;
        */
        throw new UnsupportedOperationException("Method not decompiled: mobi.mmdt.ott.logic.a.c.a.b.t.c():void");
    }

    protected void m7216d() {
    }
}
