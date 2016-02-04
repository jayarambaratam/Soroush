package mobi.mmdt.ott.logic.p112a.p120c.p121a.p123b;

import android.content.Context;
import com.p065c.p066a.p067a.C0950c;
import com.p065c.p066a.p067a.C0990j;
import java.util.Map;
import mobi.mmdt.ott.logic.C1494c;
import mobi.mmdt.ott.logic.p112a.C1396d;
import mobi.mmdt.ott.logic.p112a.p128e.p129a.p131b.C1408f;
import mobi.mmdt.ott.logic.p112a.p147h.C1451b;
import mobi.mmdt.ott.provider.p173g.C1622c;

/* renamed from: mobi.mmdt.ott.logic.a.c.a.b.s */
public class C1385s extends C0950c {
    private Context f4757a;
    private String f4758b;
    private String f4759c;
    private String f4760d;
    private String f4761e;
    private Map<String, String> f4762f;

    public C1385s(Context context, String str, String str2, String str3, String str4, Map<String, String> map) {
        super(new C0990j(C1396d.f4796b));
        this.f4758b = str;
        this.f4759c = str2;
        this.f4760d = str3;
        this.f4761e = str4;
        this.f4762f = map;
        this.f4757a = context;
    }

    protected boolean m7209a(Throwable th) {
        return false;
    }

    public void m7210b() {
        if (!C1622c.m8254a(this.f4757a, this.f4759c)) {
            C1494c.m7540b(new C1408f(this.f4757a, this.f4759c));
        }
        C1494c.m7540b(new C1451b(this.f4757a, new String[]{this.f4758b}, false, false));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m7211c() {
        /*
        r34 = this;
        r16 = 0;
        r15 = 0;
        r5 = 0;
        r0 = r34;
        r2 = r0.f4762f;
        r3 = "MINOR_TYPE";
        r2 = r2.get(r3);
        r2 = (java.lang.String) r2;
        r3 = -1;
        r4 = r2.hashCode();
        switch(r4) {
            case -1172269795: goto L_0x002e;
            case 2157948: goto L_0x0038;
            case 2571565: goto L_0x0024;
            default: goto L_0x0018;
        };
    L_0x0018:
        r2 = r3;
    L_0x0019:
        switch(r2) {
            case 0: goto L_0x0042;
            case 1: goto L_0x0162;
            case 2: goto L_0x01a9;
            default: goto L_0x001c;
        };
    L_0x001c:
        r2 = "Undefined type";
        r0 = r34;
        mobi.mmdt.componentsutils.p079a.p080a.C1104b.m6366b(r0, r2);
    L_0x0023:
        return;
    L_0x0024:
        r4 = "TEXT";
        r2 = r2.equals(r4);
        if (r2 == 0) goto L_0x0018;
    L_0x002c:
        r2 = 0;
        goto L_0x0019;
    L_0x002e:
        r4 = "STICKER";
        r2 = r2.equals(r4);
        if (r2 == 0) goto L_0x0018;
    L_0x0036:
        r2 = 1;
        goto L_0x0019;
    L_0x0038:
        r4 = "FILE";
        r2 = r2.equals(r4);
        if (r2 == 0) goto L_0x0018;
    L_0x0040:
        r2 = 2;
        goto L_0x0019;
    L_0x0042:
        r4 = mobi.mmdt.ott.provider.p169c.C1594n.TEXT;
        r33 = r5;
    L_0x0046:
        r8 = mobi.mmdt.componentsutils.p079a.p084e.C1113a.m6421a();
        r10 = mobi.mmdt.ott.provider.p169c.C1592l.IN;
        r0 = r34;
        r2 = r0.f4758b;
        r0 = r34;
        r3 = r0.f4757a;
        r3 = mobi.mmdt.ott.p109d.p111b.C1309a.m6934a(r3);
        r3 = r3.m6942b();
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0064;
    L_0x0062:
        r10 = mobi.mmdt.ott.provider.p169c.C1592l.OUT;
    L_0x0064:
        r0 = r34;
        r2 = r0.f4757a;
        r0 = r34;
        r3 = r0.f4761e;
        r2 = mobi.mmdt.ott.provider.p169c.C1583c.m7972a(r2, r3, r10);
        if (r2 != 0) goto L_0x0023;
    L_0x0072:
        r2 = mobi.mmdt.ott.MyApplication.m6445a();
        r2 = r2.f4177h;
        if (r2 == 0) goto L_0x008a;
    L_0x007a:
        r2 = mobi.mmdt.ott.MyApplication.m6445a();
        r2 = r2.f4177h;
        r0 = r34;
        r3 = r0.f4759c;
        r2 = r2.equals(r3);
        if (r2 != 0) goto L_0x024e;
    L_0x008a:
        r17 = 0;
        r0 = r34;
        r2 = r0.f4762f;
        r3 = "REPLY_ON_MESSAGE_ID";
        r2 = r2.get(r3);
        if (r2 == 0) goto L_0x00b8;
    L_0x0098:
        r0 = r34;
        r2 = r0.f4762f;
        r3 = "REPLY_ON_MESSAGE_ID";
        r2 = r2.get(r3);
        r2 = (java.lang.String) r2;
        r2 = r2.isEmpty();
        if (r2 != 0) goto L_0x00b8;
    L_0x00aa:
        r0 = r34;
        r2 = r0.f4762f;
        r3 = "REPLY_ON_MESSAGE_ID";
        r2 = r2.get(r3);
        r2 = (java.lang.String) r2;
        r17 = r2;
    L_0x00b8:
        r2 = new mobi.mmdt.ott.d.a.b;
        r0 = r34;
        r3 = r0.f4761e;
        r0 = r34;
        r5 = r0.f4760d;
        r0 = r34;
        r6 = r0.f4762f;
        r7 = "SEND_TIME_IN_GMT";
        r6 = r6.get(r7);
        r6 = (java.lang.String) r6;
        r6 = java.lang.Long.parseLong(r6);
        r11 = mobi.mmdt.ott.provider.p169c.C1593m.NOT_READ;
        r0 = r34;
        r12 = r0.f4759c;
        r13 = mobi.mmdt.ott.provider.p169c.C1595o.GROUP;
        r0 = r34;
        r14 = r0.f4758b;
        r2.<init>(r3, r4, r5, r6, r8, r10, r11, r12, r13, r14, r15, r16, r17);
        r0 = r34;
        r3 = r0.f4757a;
        r3 = mobi.mmdt.ott.logic.p157e.C1509a.m7621a(r3);
        r0 = r34;
        r4 = r0.f4762f;
        r0 = r33;
        r3.m7626a(r2, r0, r4);
    L_0x00f2:
        r0 = r34;
        r2 = r0.f4762f;
        r3 = "REPLY_ON_MESSAGE_ID";
        r2 = r2.get(r3);
        if (r2 == 0) goto L_0x013c;
    L_0x00fe:
        r0 = r34;
        r2 = r0.f4762f;
        r3 = "REPLY_ON_MESSAGE_ID";
        r2 = r2.get(r3);
        r2 = (java.lang.String) r2;
        r2 = r2.isEmpty();
        if (r2 != 0) goto L_0x013c;
    L_0x0110:
        r0 = r34;
        r2 = r0.f4762f;
        r3 = "REPLY_ON_MESSAGE_ID";
        r2 = r2.get(r3);
        r2 = (java.lang.String) r2;
        r0 = r34;
        r3 = r0.f4757a;
        r0 = r34;
        r4 = r0.f4761e;
        mobi.mmdt.ott.provider.p169c.C1583c.m7976b(r3, r4, r2);
        r0 = r34;
        r3 = r0.f4757a;
        r2 = mobi.mmdt.ott.provider.p169c.C1583c.m8003n(r3, r2);
        r0 = r34;
        r3 = r0.f4757a;
        r0 = r34;
        r4 = r0.f4761e;
        r5 = mobi.mmdt.ott.provider.p169c.C1595o.SINGLE;
        mobi.mmdt.ott.logic.p112a.p120c.p121a.p123b.C1387u.m7218a(r3, r4, r2, r5);
    L_0x013c:
        r0 = r34;
        r2 = r0.f4762f;
        r3 = "MINOR_TYPE";
        r2 = r2.get(r3);
        r2 = (java.lang.String) r2;
        r3 = "TEXT";
        r2 = r2.equals(r3);
        if (r2 != 0) goto L_0x0023;
    L_0x0150:
        r2 = new mobi.mmdt.ott.logic.a.c.a.b.b;
        r0 = r34;
        r3 = r0.f4757a;
        r0 = r34;
        r4 = r0.f4762f;
        r2.<init>(r3, r15, r4);
        mobi.mmdt.ott.logic.C1494c.m7541c(r2);
        goto L_0x0023;
    L_0x0162:
        r6 = mobi.mmdt.ott.provider.p169c.C1594n.STICKER;
        r0 = r34;
        r2 = r0.f4762f;
        r3 = "STICKER_ID";
        r2 = r2.get(r3);
        r2 = (java.lang.String) r2;
        r0 = r34;
        r3 = r0.f4762f;
        r4 = "STICKER_PACKAGE_ID";
        r3 = r3.get(r4);
        r3 = (java.lang.String) r3;
        r0 = r34;
        r4 = r0.f4762f;
        r7 = "STICKER_VERSION";
        r4 = r4.get(r7);
        r4 = (java.lang.String) r4;
        if (r4 == 0) goto L_0x02c9;
    L_0x018a:
        if (r2 == 0) goto L_0x02c9;
    L_0x018c:
        if (r3 == 0) goto L_0x02c9;
    L_0x018e:
        r7 = r4.isEmpty();
        if (r7 != 0) goto L_0x02c9;
    L_0x0194:
        r7 = r2.isEmpty();
        if (r7 != 0) goto L_0x02c9;
    L_0x019a:
        r7 = r3.isEmpty();
        if (r7 != 0) goto L_0x02c9;
    L_0x01a0:
        r16 = mobi.mmdt.ott.provider.p174h.C1629b.m8295a(r4, r3, r2);
        r33 = r5;
        r4 = r6;
        goto L_0x0046;
    L_0x01a9:
        r0 = r34;
        r2 = r0.f4762f;
        r3 = "FILE_TYPE";
        r2 = r2.get(r3);
        r2 = (java.lang.String) r2;
        r3 = -1;
        r4 = r2.hashCode();
        switch(r4) {
            case 327328941: goto L_0x01de;
            case 796404377: goto L_0x01ca;
            case 802160718: goto L_0x01e8;
            case 808293817: goto L_0x01d4;
            default: goto L_0x01bd;
        };
    L_0x01bd:
        r2 = r3;
    L_0x01be:
        switch(r2) {
            case 0: goto L_0x01f2;
            case 1: goto L_0x020c;
            case 2: goto L_0x0222;
            case 3: goto L_0x0238;
            default: goto L_0x01c1;
        };
    L_0x01c1:
        r2 = "Undefined file type";
        r0 = r34;
        mobi.mmdt.componentsutils.p079a.p080a.C1104b.m6366b(r0, r2);
        goto L_0x0023;
    L_0x01ca:
        r4 = "FILE_TYPE_IMAGE";
        r2 = r2.equals(r4);
        if (r2 == 0) goto L_0x01bd;
    L_0x01d2:
        r2 = 0;
        goto L_0x01be;
    L_0x01d4:
        r4 = "FILE_TYPE_VIDEO";
        r2 = r2.equals(r4);
        if (r2 == 0) goto L_0x01bd;
    L_0x01dc:
        r2 = 1;
        goto L_0x01be;
    L_0x01de:
        r4 = "FILE_TYPE_PUSH_TO_TALK";
        r2 = r2.equals(r4);
        if (r2 == 0) goto L_0x01bd;
    L_0x01e6:
        r2 = 2;
        goto L_0x01be;
    L_0x01e8:
        r4 = "FILE_TYPE_OTHER";
        r2 = r2.equals(r4);
        if (r2 == 0) goto L_0x01bd;
    L_0x01f0:
        r2 = 3;
        goto L_0x01be;
    L_0x01f2:
        r3 = mobi.mmdt.ott.provider.p169c.C1594n.IMAGE;
        r2 = new mobi.mmdt.ott.logic.a.c.a.b.h;
        r0 = r34;
        r4 = r0.f4757a;
        r0 = r34;
        r5 = r0.f4762f;
        r6 = mobi.mmdt.ott.provider.p170d.C1605j.IMAGE;
        r2.<init>(r4, r5, r6);
        r2 = r2.m7152a();
    L_0x0207:
        r33 = r2;
        r4 = r3;
        goto L_0x0046;
    L_0x020c:
        r3 = mobi.mmdt.ott.provider.p169c.C1594n.VIDEO;
        r2 = new mobi.mmdt.ott.logic.a.c.a.b.h;
        r0 = r34;
        r4 = r0.f4757a;
        r0 = r34;
        r5 = r0.f4762f;
        r6 = mobi.mmdt.ott.provider.p170d.C1605j.VIDEO;
        r2.<init>(r4, r5, r6);
        r2 = r2.m7152a();
        goto L_0x0207;
    L_0x0222:
        r3 = mobi.mmdt.ott.provider.p169c.C1594n.PUSH_TO_TALK;
        r2 = new mobi.mmdt.ott.logic.a.c.a.b.h;
        r0 = r34;
        r4 = r0.f4757a;
        r0 = r34;
        r5 = r0.f4762f;
        r6 = mobi.mmdt.ott.provider.p170d.C1605j.PUSH_TO_TALK;
        r2.<init>(r4, r5, r6);
        r2 = r2.m7152a();
        goto L_0x0207;
    L_0x0238:
        r3 = mobi.mmdt.ott.provider.p169c.C1594n.FILE;
        r2 = new mobi.mmdt.ott.logic.a.c.a.b.h;
        r0 = r34;
        r4 = r0.f4757a;
        r0 = r34;
        r5 = r0.f4762f;
        r6 = mobi.mmdt.ott.provider.p170d.C1605j.OTHER;
        r2.<init>(r4, r5, r6);
        r2 = r2.m7152a();
        goto L_0x0207;
    L_0x024e:
        if (r33 == 0) goto L_0x029c;
    L_0x0250:
        r0 = r34;
        r0 = r0.f4757a;
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
    L_0x029c:
        r0 = r34;
        r2 = r0.f4757a;
        r0 = r34;
        r3 = r0.f4761e;
        r0 = r34;
        r5 = r0.f4760d;
        r0 = r34;
        r6 = r0.f4762f;
        r7 = "SEND_TIME_IN_GMT";
        r6 = r6.get(r7);
        r6 = (java.lang.String) r6;
        r6 = java.lang.Long.parseLong(r6);
        r11 = mobi.mmdt.ott.provider.p169c.C1593m.READ;
        r0 = r34;
        r12 = r0.f4759c;
        r13 = mobi.mmdt.ott.provider.p169c.C1595o.GROUP;
        r0 = r34;
        r14 = r0.f4758b;
        mobi.mmdt.ott.provider.p169c.C1583c.m7966a(r2, r3, r4, r5, r6, r8, r10, r11, r12, r13, r14, r15, r16);
        goto L_0x00f2;
    L_0x02c9:
        r33 = r5;
        r4 = r6;
        goto L_0x0046;
        */
        throw new UnsupportedOperationException("Method not decompiled: mobi.mmdt.ott.logic.a.c.a.b.s.c():void");
    }

    protected void m7212d() {
    }
}
