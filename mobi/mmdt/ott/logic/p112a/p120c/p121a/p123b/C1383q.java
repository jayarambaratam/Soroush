package mobi.mmdt.ott.logic.p112a.p120c.p121a.p123b;

import android.content.Context;
import com.p065c.p066a.p067a.C0950c;
import com.p065c.p066a.p067a.C0990j;
import java.util.Map;
import mobi.mmdt.ott.logic.C1494c;
import mobi.mmdt.ott.logic.p112a.C1396d;
import mobi.mmdt.ott.logic.p112a.p117b.p119b.C1354f;
import mobi.mmdt.ott.logic.p112a.p147h.C1451b;
import mobi.mmdt.ott.provider.p168b.C1573b;
import mobi.mmdt.ott.provider.p169c.C1593m;

/* renamed from: mobi.mmdt.ott.logic.a.c.a.b.q */
public class C1383q extends C0950c {
    private Context f4745a;
    private String f4746b;
    private String f4747c;
    private String f4748d;
    private String f4749e;
    private Map<String, String> f4750f;
    private C1593m f4751g;

    public C1383q(Context context, String str, String str2, String str3, String str4, Map<String, String> map, C1593m c1593m) {
        super(new C0990j(C1396d.f4795a));
        this.f4746b = str;
        this.f4747c = str2;
        this.f4748d = str3;
        this.f4749e = str4;
        this.f4750f = map;
        this.f4745a = context;
        this.f4751g = c1593m;
    }

    protected boolean m7200a(Throwable th) {
        return false;
    }

    public void m7201b() {
        if (!C1573b.m7925c(this.f4745a, this.f4747c)) {
            C1494c.m7539a(new C1354f(this.f4745a, this.f4747c));
        }
        C1494c.m7539a(new C1451b(this.f4745a, new String[]{this.f4746b}, false, false));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m7202c() {
        /*
        r34 = this;
        r16 = 0;
        r15 = 0;
        r5 = 0;
        r0 = r34;
        r2 = r0.f4750f;
        r3 = "MINOR_TYPE";
        r2 = r2.get(r3);
        r2 = (java.lang.String) r2;
        r3 = -1;
        r4 = r2.hashCode();
        switch(r4) {
            case -1172269795: goto L_0x002e;
            case 2157948: goto L_0x0042;
            case 2461631: goto L_0x0038;
            case 2571565: goto L_0x0024;
            default: goto L_0x0018;
        };
    L_0x0018:
        r2 = r3;
    L_0x0019:
        switch(r2) {
            case 0: goto L_0x004c;
            case 1: goto L_0x0160;
            case 2: goto L_0x01a7;
            case 3: goto L_0x01e7;
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
        r4 = "POLL";
        r2 = r2.equals(r4);
        if (r2 == 0) goto L_0x0018;
    L_0x0040:
        r2 = 2;
        goto L_0x0019;
    L_0x0042:
        r4 = "FILE";
        r2 = r2.equals(r4);
        if (r2 == 0) goto L_0x0018;
    L_0x004a:
        r2 = 3;
        goto L_0x0019;
    L_0x004c:
        r4 = mobi.mmdt.ott.provider.p169c.C1594n.TEXT;
        r33 = r5;
    L_0x0050:
        r8 = mobi.mmdt.componentsutils.p079a.p084e.C1113a.m6421a();
        r10 = mobi.mmdt.ott.provider.p169c.C1592l.IN;
        r0 = r34;
        r2 = r0.f4746b;
        r0 = r34;
        r3 = r0.f4745a;
        r3 = mobi.mmdt.ott.p109d.p111b.C1309a.m6934a(r3);
        r3 = r3.m6942b();
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x006e;
    L_0x006c:
        r10 = mobi.mmdt.ott.provider.p169c.C1592l.OUT;
    L_0x006e:
        r2 = mobi.mmdt.ott.MyApplication.m6445a();
        r2 = r2.f4177h;
        if (r2 == 0) goto L_0x0086;
    L_0x0076:
        r2 = mobi.mmdt.ott.MyApplication.m6445a();
        r2 = r2.f4177h;
        r0 = r34;
        r3 = r0.f4747c;
        r2 = r2.equals(r3);
        if (r2 != 0) goto L_0x028c;
    L_0x0086:
        r17 = 0;
        r0 = r34;
        r2 = r0.f4750f;
        r3 = "REPLY_ON_MESSAGE_ID";
        r2 = r2.get(r3);
        if (r2 == 0) goto L_0x00b4;
    L_0x0094:
        r0 = r34;
        r2 = r0.f4750f;
        r3 = "REPLY_ON_MESSAGE_ID";
        r2 = r2.get(r3);
        r2 = (java.lang.String) r2;
        r2 = r2.isEmpty();
        if (r2 != 0) goto L_0x00b4;
    L_0x00a6:
        r0 = r34;
        r2 = r0.f4750f;
        r3 = "REPLY_ON_MESSAGE_ID";
        r2 = r2.get(r3);
        r2 = (java.lang.String) r2;
        r17 = r2;
    L_0x00b4:
        r2 = new mobi.mmdt.ott.d.a.b;
        r0 = r34;
        r3 = r0.f4749e;
        r0 = r34;
        r5 = r0.f4748d;
        r0 = r34;
        r6 = r0.f4750f;
        r7 = "SEND_TIME_IN_GMT";
        r6 = r6.get(r7);
        r6 = (java.lang.String) r6;
        r6 = java.lang.Long.parseLong(r6);
        r0 = r34;
        r11 = r0.f4751g;
        r0 = r34;
        r12 = r0.f4747c;
        r13 = mobi.mmdt.ott.provider.p169c.C1595o.CHANNEL;
        r0 = r34;
        r14 = r0.f4746b;
        r2.<init>(r3, r4, r5, r6, r8, r10, r11, r12, r13, r14, r15, r16, r17);
        r0 = r34;
        r3 = r0.f4745a;
        r3 = mobi.mmdt.ott.logic.p157e.C1509a.m7621a(r3);
        r0 = r34;
        r4 = r0.f4750f;
        r0 = r33;
        r3.m7626a(r2, r0, r4);
    L_0x00f0:
        r0 = r34;
        r2 = r0.f4750f;
        r3 = "REPLY_ON_MESSAGE_ID";
        r2 = r2.get(r3);
        if (r2 == 0) goto L_0x013a;
    L_0x00fc:
        r0 = r34;
        r2 = r0.f4750f;
        r3 = "REPLY_ON_MESSAGE_ID";
        r2 = r2.get(r3);
        r2 = (java.lang.String) r2;
        r2 = r2.isEmpty();
        if (r2 != 0) goto L_0x013a;
    L_0x010e:
        r0 = r34;
        r2 = r0.f4750f;
        r3 = "REPLY_ON_MESSAGE_ID";
        r2 = r2.get(r3);
        r2 = (java.lang.String) r2;
        r0 = r34;
        r3 = r0.f4745a;
        r0 = r34;
        r4 = r0.f4749e;
        mobi.mmdt.ott.provider.p169c.C1583c.m7976b(r3, r4, r2);
        r0 = r34;
        r3 = r0.f4745a;
        r2 = mobi.mmdt.ott.provider.p169c.C1583c.m8003n(r3, r2);
        r0 = r34;
        r3 = r0.f4745a;
        r0 = r34;
        r4 = r0.f4749e;
        r5 = mobi.mmdt.ott.provider.p169c.C1595o.SINGLE;
        mobi.mmdt.ott.logic.p112a.p120c.p121a.p123b.C1387u.m7218a(r3, r4, r2, r5);
    L_0x013a:
        r0 = r34;
        r2 = r0.f4750f;
        r3 = "MINOR_TYPE";
        r2 = r2.get(r3);
        r2 = (java.lang.String) r2;
        r3 = "TEXT";
        r2 = r2.equals(r3);
        if (r2 != 0) goto L_0x0023;
    L_0x014e:
        r2 = new mobi.mmdt.ott.logic.a.c.a.b.b;
        r0 = r34;
        r3 = r0.f4745a;
        r0 = r34;
        r4 = r0.f4750f;
        r2.<init>(r3, r15, r4);
        mobi.mmdt.ott.logic.C1494c.m7539a(r2);
        goto L_0x0023;
    L_0x0160:
        r6 = mobi.mmdt.ott.provider.p169c.C1594n.STICKER;
        r0 = r34;
        r2 = r0.f4750f;
        r3 = "STICKER_ID";
        r2 = r2.get(r3);
        r2 = (java.lang.String) r2;
        r0 = r34;
        r3 = r0.f4750f;
        r4 = "STICKER_PACKAGE_ID";
        r3 = r3.get(r4);
        r3 = (java.lang.String) r3;
        r0 = r34;
        r4 = r0.f4750f;
        r7 = "STICKER_VERSION";
        r4 = r4.get(r7);
        r4 = (java.lang.String) r4;
        if (r4 == 0) goto L_0x030b;
    L_0x0188:
        if (r2 == 0) goto L_0x030b;
    L_0x018a:
        if (r3 == 0) goto L_0x030b;
    L_0x018c:
        r7 = r4.isEmpty();
        if (r7 != 0) goto L_0x030b;
    L_0x0192:
        r7 = r2.isEmpty();
        if (r7 != 0) goto L_0x030b;
    L_0x0198:
        r7 = r3.isEmpty();
        if (r7 != 0) goto L_0x030b;
    L_0x019e:
        r16 = mobi.mmdt.ott.provider.p174h.C1629b.m8295a(r4, r3, r2);
        r33 = r5;
        r4 = r6;
        goto L_0x0050;
    L_0x01a7:
        r4 = mobi.mmdt.ott.provider.p169c.C1594n.VOTE;
        r0 = r34;
        r2 = r0.f4750f;
        r3 = "POLL_ID";
        r2 = r2.get(r3);
        r2 = (java.lang.String) r2;
        r0 = r34;
        r3 = r0.f4750f;
        r6 = "POLL_DATA";
        r3 = r3.get(r6);
        r3 = (java.lang.String) r3;
        if (r2 == 0) goto L_0x0307;
    L_0x01c3:
        if (r3 == 0) goto L_0x0307;
    L_0x01c5:
        r6 = r2.isEmpty();
        if (r6 != 0) goto L_0x0307;
    L_0x01cb:
        r6 = r3.isEmpty();
        if (r6 != 0) goto L_0x0307;
    L_0x01d1:
        r6 = new org.json.JSONObject;
        r6.<init>(r3);
        r3 = "PollID";
        r6.put(r3, r2);
        r2 = r6.toString();
        r0 = r34;
        r0.f4748d = r2;
        r33 = r5;
        goto L_0x0050;
    L_0x01e7:
        r0 = r34;
        r2 = r0.f4750f;
        r3 = "FILE_TYPE";
        r2 = r2.get(r3);
        r2 = (java.lang.String) r2;
        r3 = -1;
        r4 = r2.hashCode();
        switch(r4) {
            case 327328941: goto L_0x021c;
            case 796404377: goto L_0x0208;
            case 802160718: goto L_0x0226;
            case 808293817: goto L_0x0212;
            default: goto L_0x01fb;
        };
    L_0x01fb:
        r2 = r3;
    L_0x01fc:
        switch(r2) {
            case 0: goto L_0x0230;
            case 1: goto L_0x024a;
            case 2: goto L_0x0260;
            case 3: goto L_0x0276;
            default: goto L_0x01ff;
        };
    L_0x01ff:
        r2 = "Undefined file type";
        r0 = r34;
        mobi.mmdt.componentsutils.p079a.p080a.C1104b.m6366b(r0, r2);
        goto L_0x0023;
    L_0x0208:
        r4 = "FILE_TYPE_IMAGE";
        r2 = r2.equals(r4);
        if (r2 == 0) goto L_0x01fb;
    L_0x0210:
        r2 = 0;
        goto L_0x01fc;
    L_0x0212:
        r4 = "FILE_TYPE_VIDEO";
        r2 = r2.equals(r4);
        if (r2 == 0) goto L_0x01fb;
    L_0x021a:
        r2 = 1;
        goto L_0x01fc;
    L_0x021c:
        r4 = "FILE_TYPE_PUSH_TO_TALK";
        r2 = r2.equals(r4);
        if (r2 == 0) goto L_0x01fb;
    L_0x0224:
        r2 = 2;
        goto L_0x01fc;
    L_0x0226:
        r4 = "FILE_TYPE_OTHER";
        r2 = r2.equals(r4);
        if (r2 == 0) goto L_0x01fb;
    L_0x022e:
        r2 = 3;
        goto L_0x01fc;
    L_0x0230:
        r3 = mobi.mmdt.ott.provider.p169c.C1594n.IMAGE;
        r2 = new mobi.mmdt.ott.logic.a.c.a.b.h;
        r0 = r34;
        r4 = r0.f4745a;
        r0 = r34;
        r5 = r0.f4750f;
        r6 = mobi.mmdt.ott.provider.p170d.C1605j.IMAGE;
        r2.<init>(r4, r5, r6);
        r2 = r2.m7152a();
    L_0x0245:
        r33 = r2;
        r4 = r3;
        goto L_0x0050;
    L_0x024a:
        r3 = mobi.mmdt.ott.provider.p169c.C1594n.VIDEO;
        r2 = new mobi.mmdt.ott.logic.a.c.a.b.h;
        r0 = r34;
        r4 = r0.f4745a;
        r0 = r34;
        r5 = r0.f4750f;
        r6 = mobi.mmdt.ott.provider.p170d.C1605j.VIDEO;
        r2.<init>(r4, r5, r6);
        r2 = r2.m7152a();
        goto L_0x0245;
    L_0x0260:
        r3 = mobi.mmdt.ott.provider.p169c.C1594n.PUSH_TO_TALK;
        r2 = new mobi.mmdt.ott.logic.a.c.a.b.h;
        r0 = r34;
        r4 = r0.f4745a;
        r0 = r34;
        r5 = r0.f4750f;
        r6 = mobi.mmdt.ott.provider.p170d.C1605j.PUSH_TO_TALK;
        r2.<init>(r4, r5, r6);
        r2 = r2.m7152a();
        goto L_0x0245;
    L_0x0276:
        r3 = mobi.mmdt.ott.provider.p169c.C1594n.FILE;
        r2 = new mobi.mmdt.ott.logic.a.c.a.b.h;
        r0 = r34;
        r4 = r0.f4745a;
        r0 = r34;
        r5 = r0.f4750f;
        r6 = mobi.mmdt.ott.provider.p170d.C1605j.OTHER;
        r2.<init>(r4, r5, r6);
        r2 = r2.m7152a();
        goto L_0x0245;
    L_0x028c:
        if (r33 == 0) goto L_0x02da;
    L_0x028e:
        r0 = r34;
        r0 = r0.f4745a;
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
    L_0x02da:
        r0 = r34;
        r2 = r0.f4745a;
        r0 = r34;
        r3 = r0.f4749e;
        r0 = r34;
        r5 = r0.f4748d;
        r0 = r34;
        r6 = r0.f4750f;
        r7 = "SEND_TIME_IN_GMT";
        r6 = r6.get(r7);
        r6 = (java.lang.String) r6;
        r6 = java.lang.Long.parseLong(r6);
        r11 = mobi.mmdt.ott.provider.p169c.C1593m.READ;
        r0 = r34;
        r12 = r0.f4747c;
        r13 = mobi.mmdt.ott.provider.p169c.C1595o.CHANNEL;
        r0 = r34;
        r14 = r0.f4746b;
        mobi.mmdt.ott.provider.p169c.C1583c.m7966a(r2, r3, r4, r5, r6, r8, r10, r11, r12, r13, r14, r15, r16);
        goto L_0x00f0;
    L_0x0307:
        r33 = r5;
        goto L_0x0050;
    L_0x030b:
        r33 = r5;
        r4 = r6;
        goto L_0x0050;
        */
        throw new UnsupportedOperationException("Method not decompiled: mobi.mmdt.ott.logic.a.c.a.b.q.c():void");
    }

    protected void m7203d() {
    }
}
