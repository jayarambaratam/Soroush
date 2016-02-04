package com.p032a.p033a.p037d.p049d.p054d;

import android.graphics.Bitmap;
import android.util.Log;
import com.p032a.p033a.p035b.C0576a;
import com.p032a.p033a.p035b.C0577b;
import com.p032a.p033a.p035b.C0579d;
import com.p032a.p033a.p035b.C0580e;
import com.p032a.p033a.p037d.C0727f;
import com.p032a.p033a.p037d.C0730g;
import com.p032a.p033a.p037d.p039b.C0670y;
import com.p032a.p033a.p037d.p039b.p040a.C0605e;
import java.io.OutputStream;
import net.frakbot.glowpadbackport.BuildConfig;

/* renamed from: com.a.a.d.d.d.s */
public class C0790s implements C0727f<C0770b> {
    private static final C0791t f2874a;
    private final C0577b f2875b;
    private final C0605e f2876c;
    private final C0791t f2877d;

    static {
        f2874a = new C0791t();
    }

    public C0790s(C0605e c0605e) {
        this(c0605e, f2874a);
    }

    C0790s(C0605e c0605e, C0791t c0791t) {
        this.f2876c = c0605e;
        this.f2875b = new C0768a(c0605e);
        this.f2877d = c0791t;
    }

    private C0576a m4992a(byte[] bArr) {
        C0580e a = this.f2877d.m4999a();
        a.m4367a(bArr);
        C0579d b = a.m4369b();
        C0576a a2 = this.f2877d.m4998a(this.f2875b);
        a2.m4342a(b, bArr);
        a2.m4341a();
        return a2;
    }

    private C0670y<Bitmap> m4993a(Bitmap bitmap, C0730g<Bitmap> c0730g, C0770b c0770b) {
        C0670y a = this.f2877d.m5000a(bitmap, this.f2876c);
        C0670y<Bitmap> a2 = c0730g.m4802a(a, c0770b.getIntrinsicWidth(), c0770b.getIntrinsicHeight());
        if (!a.equals(a2)) {
            a.m4680d();
        }
        return a2;
    }

    private boolean m4994a(byte[] bArr, OutputStream outputStream) {
        try {
            outputStream.write(bArr);
            return true;
        } catch (Throwable e) {
            if (Log.isLoggable("GifEncoder", 3)) {
                Log.d("GifEncoder", "Failed to write data to output stream in GifResourceEncoder", e);
            }
            return false;
        }
    }

    public String m4995a() {
        return BuildConfig.FLAVOR;
    }

    public boolean m4996a(com.p032a.p033a.p037d.p039b.C0670y<com.p032a.p033a.p037d.p049d.p054d.C0770b> r11, java.io.OutputStream r12) {
        /* JADX: method processing error */
/*
        Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
*/
        /*
        r10 = this;
        r3 = 0;
        r4 = com.p032a.p033a.p042j.C0876d.m5296a();
        r0 = r11.m4678b();
        r0 = (com.p032a.p033a.p037d.p049d.p054d.C0770b) r0;
        r6 = r0.m4929c();
        r1 = r6 instanceof com.p032a.p033a.p037d.p049d.C0792d;
        if (r1 == 0) goto L_0x001c;
    L_0x0013:
        r0 = r0.m4930d();
        r3 = r10.m4994a(r0, r12);
    L_0x001b:
        return r3;
    L_0x001c:
        r1 = r0.m4930d();
        r7 = r10.m4992a(r1);
        r1 = r10.f2877d;
        r8 = r1.m5001b();
        r1 = r8.m4386a(r12);
        if (r1 == 0) goto L_0x001b;
    L_0x0030:
        r2 = r3;
    L_0x0031:
        r1 = r7.m4344c();
        if (r2 >= r1) goto L_0x0069;
    L_0x0037:
        r1 = r7.m4347f();
        r9 = r10.m4993a(r1, r6, r0);
        r1 = r9.m4678b();	 Catch:{ all -> 0x0064 }
        r1 = (android.graphics.Bitmap) r1;	 Catch:{ all -> 0x0064 }
        r1 = r8.m4385a(r1);	 Catch:{ all -> 0x0064 }
        if (r1 != 0) goto L_0x004f;
    L_0x004b:
        r9.m4680d();
        goto L_0x001b;
    L_0x004f:
        r1 = r7.m4345d();	 Catch:{ all -> 0x0064 }
        r1 = r7.m4340a(r1);	 Catch:{ all -> 0x0064 }
        r8.m4382a(r1);	 Catch:{ all -> 0x0064 }
        r7.m4341a();	 Catch:{ all -> 0x0064 }
        r9.m4680d();
        r1 = r2 + 1;
        r2 = r1;
        goto L_0x0031;
    L_0x0064:
        r0 = move-exception;
        r9.m4680d();
        throw r0;
    L_0x0069:
        r3 = r8.m4384a();
        r1 = "GifEncoder";
        r2 = 2;
        r1 = android.util.Log.isLoggable(r1, r2);
        if (r1 == 0) goto L_0x001b;
    L_0x0076:
        r1 = "GifEncoder";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r6 = "Encoded gif with ";
        r2 = r2.append(r6);
        r6 = r7.m4344c();
        r2 = r2.append(r6);
        r6 = " frames and ";
        r2 = r2.append(r6);
        r0 = r0.m4930d();
        r0 = r0.length;
        r0 = r2.append(r0);
        r2 = " bytes in ";
        r0 = r0.append(r2);
        r4 = com.p032a.p033a.p042j.C0876d.m5295a(r4);
        r0 = r0.append(r4);
        r2 = " ms";
        r0 = r0.append(r2);
        r0 = r0.toString();
        android.util.Log.v(r1, r0);
        goto L_0x001b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.a.a.d.d.d.s.a(com.a.a.d.b.y, java.io.OutputStream):boolean");
    }
}
