package mobi.mmdt.ott.logic.p112a.p120c.p121a.p123b;

import android.content.Context;
import com.p065c.p066a.p067a.C0950c;
import com.p065c.p066a.p067a.C0990j;
import java.util.Map;
import mobi.mmdt.ott.logic.p112a.C1396d;
import mobi.mmdt.ott.logic.p124j.C1367c;

/* renamed from: mobi.mmdt.ott.logic.a.c.a.b.b */
public class C1368b extends C0950c {
    private Context f4699a;
    private Long f4700b;
    private Map<String, String> f4701c;

    public C1368b(Context context, Long l, Map<String, String> map) {
        super(new C0990j(C1396d.f4795a));
        this.f4699a = context;
        this.f4700b = l;
        this.f4701c = map;
    }

    private C1367c m7133a(Long l, String str) {
        return new C1369c(this, str, l);
    }

    protected boolean m7134a(Throwable th) {
        return false;
    }

    public void m7135b() {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m7136c() {
        /*
        r7 = this;
        r4 = 2;
        r2 = -1;
        r6 = 0;
        r3 = 1;
        r1 = 0;
        r0 = r7.f4700b;
        if (r0 == 0) goto L_0x001e;
    L_0x0009:
        r0 = r7.f4701c;
        r5 = "MINOR_TYPE";
        r0 = r0.get(r5);
        r0 = (java.lang.String) r0;
        r5 = r0.hashCode();
        switch(r5) {
            case -1172269795: goto L_0x0029;
            case 2157948: goto L_0x0033;
            case 2571565: goto L_0x001f;
            default: goto L_0x001a;
        };
    L_0x001a:
        r0 = r2;
    L_0x001b:
        switch(r0) {
            case 0: goto L_0x001e;
            case 1: goto L_0x001e;
            case 2: goto L_0x003d;
            default: goto L_0x001e;
        };
    L_0x001e:
        return;
    L_0x001f:
        r5 = "TEXT";
        r0 = r0.equals(r5);
        if (r0 == 0) goto L_0x001a;
    L_0x0027:
        r0 = r1;
        goto L_0x001b;
    L_0x0029:
        r5 = "STICKER";
        r0 = r0.equals(r5);
        if (r0 == 0) goto L_0x001a;
    L_0x0031:
        r0 = r3;
        goto L_0x001b;
    L_0x0033:
        r5 = "FILE";
        r0 = r0.equals(r5);
        if (r0 == 0) goto L_0x001a;
    L_0x003b:
        r0 = r4;
        goto L_0x001b;
    L_0x003d:
        r0 = r7.f4701c;
        r5 = "FILE_TYPE";
        r0 = r0.get(r5);
        r0 = (java.lang.String) r0;
        r5 = r0.hashCode();
        switch(r5) {
            case 327328941: goto L_0x009b;
            case 796404377: goto L_0x0087;
            case 802160718: goto L_0x00a5;
            case 808293817: goto L_0x0091;
            default: goto L_0x004e;
        };
    L_0x004e:
        r0 = r2;
    L_0x004f:
        switch(r0) {
            case 0: goto L_0x0053;
            case 1: goto L_0x00c8;
            case 2: goto L_0x0116;
            case 3: goto L_0x0127;
            default: goto L_0x0052;
        };
    L_0x0052:
        goto L_0x001e;
    L_0x0053:
        r0 = r7.f4701c;
        r2 = "FILE_THUMBNAIL_URL";
        r0 = r0.get(r2);
        if (r0 == 0) goto L_0x006d;
    L_0x005d:
        r0 = r7.f4701c;
        r2 = "FILE_THUMBNAIL_URL";
        r0 = r0.get(r2);
        r0 = (java.lang.String) r0;
        r0 = r0.isEmpty();
        if (r0 == 0) goto L_0x00af;
    L_0x006d:
        r0 = r7.f4699a;
        r2 = mobi.mmdt.ott.provider.p170d.C1605j.IMAGE;
        r0 = mobi.mmdt.ott.logic.p124j.C1543a.m7782a(r0, r2);
        if (r0 == 0) goto L_0x001e;
    L_0x0077:
        r0 = r7.f4699a;
        r0 = mobi.mmdt.ott.logic.p124j.C1545d.m7786a(r0);
        r2 = r7.f4700b;
        r2 = r2.longValue();
        r0.m7787a(r2, r1, r6);
        goto L_0x001e;
    L_0x0087:
        r4 = "FILE_TYPE_IMAGE";
        r0 = r0.equals(r4);
        if (r0 == 0) goto L_0x004e;
    L_0x008f:
        r0 = r1;
        goto L_0x004f;
    L_0x0091:
        r4 = "FILE_TYPE_VIDEO";
        r0 = r0.equals(r4);
        if (r0 == 0) goto L_0x004e;
    L_0x0099:
        r0 = r3;
        goto L_0x004f;
    L_0x009b:
        r5 = "FILE_TYPE_PUSH_TO_TALK";
        r0 = r0.equals(r5);
        if (r0 == 0) goto L_0x004e;
    L_0x00a3:
        r0 = r4;
        goto L_0x004f;
    L_0x00a5:
        r4 = "FILE_TYPE_OTHER";
        r0 = r0.equals(r4);
        if (r0 == 0) goto L_0x004e;
    L_0x00ad:
        r0 = 3;
        goto L_0x004f;
    L_0x00af:
        r0 = r7.f4700b;
        r1 = "FILE_TYPE_IMAGE";
        r0 = r7.m7133a(r0, r1);
        r1 = r7.f4699a;
        r1 = mobi.mmdt.ott.logic.p124j.C1545d.m7786a(r1);
        r2 = r7.f4700b;
        r4 = r2.longValue();
        r1.m7787a(r4, r3, r0);
        goto L_0x001e;
    L_0x00c8:
        r0 = r7.f4701c;
        r2 = "FILE_THUMBNAIL_URL";
        r0 = r0.get(r2);
        if (r0 == 0) goto L_0x00e2;
    L_0x00d2:
        r0 = r7.f4701c;
        r2 = "FILE_THUMBNAIL_URL";
        r0 = r0.get(r2);
        r0 = (java.lang.String) r0;
        r0 = r0.isEmpty();
        if (r0 == 0) goto L_0x00fd;
    L_0x00e2:
        r0 = r7.f4699a;
        r2 = mobi.mmdt.ott.provider.p170d.C1605j.VIDEO;
        r0 = mobi.mmdt.ott.logic.p124j.C1543a.m7782a(r0, r2);
        if (r0 == 0) goto L_0x001e;
    L_0x00ec:
        r0 = r7.f4699a;
        r0 = mobi.mmdt.ott.logic.p124j.C1545d.m7786a(r0);
        r2 = r7.f4700b;
        r2 = r2.longValue();
        r0.m7787a(r2, r1, r6);
        goto L_0x001e;
    L_0x00fd:
        r0 = r7.f4700b;
        r1 = "FILE_TYPE_VIDEO";
        r0 = r7.m7133a(r0, r1);
        r1 = r7.f4699a;
        r1 = mobi.mmdt.ott.logic.p124j.C1545d.m7786a(r1);
        r2 = r7.f4700b;
        r4 = r2.longValue();
        r1.m7787a(r4, r3, r0);
        goto L_0x001e;
    L_0x0116:
        r0 = r7.f4699a;
        r0 = mobi.mmdt.ott.logic.p124j.C1545d.m7786a(r0);
        r2 = r7.f4700b;
        r2 = r2.longValue();
        r0.m7787a(r2, r1, r6);
        goto L_0x001e;
    L_0x0127:
        r0 = r7.f4699a;
        r2 = mobi.mmdt.ott.provider.p170d.C1605j.OTHER;
        r0 = mobi.mmdt.ott.logic.p124j.C1543a.m7782a(r0, r2);
        if (r0 == 0) goto L_0x001e;
    L_0x0131:
        r0 = r7.f4699a;
        r0 = mobi.mmdt.ott.logic.p124j.C1545d.m7786a(r0);
        r2 = r7.f4700b;
        r2 = r2.longValue();
        r0.m7787a(r2, r1, r6);
        goto L_0x001e;
        */
        throw new UnsupportedOperationException("Method not decompiled: mobi.mmdt.ott.logic.a.c.a.b.b.c():void");
    }

    protected void m7137d() {
    }
}
