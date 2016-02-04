package com.p065c.p066a.p067a;

import java.io.Serializable;

@Deprecated
/* renamed from: com.c.a.a.a */
public abstract class C0944a implements Serializable {
    private boolean f3605a;
    private String f3606b;
    private boolean f3607c;
    private transient int f3608d;

    protected C0944a(boolean z, boolean z2, String str) {
        this.f3605a = z;
        this.f3607c = z2;
        this.f3606b = str;
    }

    public final boolean m5828a() {
        return this.f3607c;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean m5829a(int r8) {
        /*
        r7 = this;
        r0 = 1;
        r1 = 0;
        r7.f3608d = r8;
        r2 = com.p065c.p066a.p067a.p072e.C0956b.m5906a();
        if (r2 == 0) goto L_0x001b;
    L_0x000a:
        r2 = "running job %s";
        r3 = new java.lang.Object[r0];
        r4 = r7.getClass();
        r4 = r4.getSimpleName();
        r3[r1] = r4;
        com.p065c.p066a.p067a.p072e.C0956b.m5904a(r2, r3);
    L_0x001b:
        r7.m5832c();	 Catch:{ Throwable -> 0x0038, all -> 0x0074 }
        r2 = com.p065c.p066a.p067a.p072e.C0956b.m5906a();	 Catch:{ Throwable -> 0x0038, all -> 0x0074 }
        if (r2 == 0) goto L_0x0037;
    L_0x0024:
        r2 = "finished job %s";
        r3 = 1;
        r3 = new java.lang.Object[r3];	 Catch:{ Throwable -> 0x0038, all -> 0x0074 }
        r4 = 0;
        r5 = r7.getClass();	 Catch:{ Throwable -> 0x0038, all -> 0x0074 }
        r5 = r5.getSimpleName();	 Catch:{ Throwable -> 0x0038, all -> 0x0074 }
        r3[r4] = r5;	 Catch:{ Throwable -> 0x0038, all -> 0x0074 }
        com.p065c.p066a.p067a.p072e.C0956b.m5904a(r2, r3);	 Catch:{ Throwable -> 0x0038, all -> 0x0074 }
    L_0x0037:
        return r0;
    L_0x0038:
        r2 = move-exception;
        r3 = "error while executing job";
        r4 = 0;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0078 }
        com.p065c.p066a.p067a.p072e.C0956b.m5905a(r2, r3, r4);	 Catch:{ all -> 0x0078 }
        r3 = r7.m5836g();	 Catch:{ all -> 0x0078 }
        if (r8 >= r3) goto L_0x0052;
    L_0x0047:
        r3 = r0;
    L_0x0048:
        if (r3 == 0) goto L_0x004e;
    L_0x004a:
        r3 = r7.m5830a(r2);	 Catch:{ Throwable -> 0x0054 }
    L_0x004e:
        if (r3 == 0) goto L_0x0066;
    L_0x0050:
        r0 = r1;
        goto L_0x0037;
    L_0x0052:
        r3 = r1;
        goto L_0x0048;
    L_0x0054:
        r2 = move-exception;
        r4 = "shouldReRunOnThrowable did throw an exception";
        r5 = 0;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x005e }
        com.p065c.p066a.p067a.p072e.C0956b.m5905a(r2, r4, r5);	 Catch:{ all -> 0x005e }
        goto L_0x004e;
    L_0x005e:
        r2 = move-exception;
        r6 = r2;
        r2 = r0;
        r0 = r6;
    L_0x0062:
        if (r3 == 0) goto L_0x006c;
    L_0x0064:
        r0 = r1;
        goto L_0x0037;
    L_0x0066:
        r7.m5833d();	 Catch:{ Throwable -> 0x006a }
        goto L_0x0037;
    L_0x006a:
        r1 = move-exception;
        goto L_0x0037;
    L_0x006c:
        if (r2 == 0) goto L_0x0071;
    L_0x006e:
        r7.m5833d();	 Catch:{ Throwable -> 0x0072 }
    L_0x0071:
        throw r0;
    L_0x0072:
        r1 = move-exception;
        goto L_0x0071;
    L_0x0074:
        r0 = move-exception;
        r2 = r1;
        r3 = r1;
        goto L_0x0062;
    L_0x0078:
        r2 = move-exception;
        r3 = r1;
        r6 = r0;
        r0 = r2;
        r2 = r6;
        goto L_0x0062;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.c.a.a.a.a(int):boolean");
    }

    protected abstract boolean m5830a(Throwable th);

    public abstract void m5831b();

    public abstract void m5832c();

    protected abstract void m5833d();

    public final boolean m5834e() {
        return this.f3605a;
    }

    public final String m5835f() {
        return this.f3606b;
    }

    protected int m5836g() {
        return 20;
    }
}
