package com.p032a.p033a.p037d.p049d.p050a;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.util.Log;
import com.p032a.p033a.p037d.C0598a;
import com.p032a.p033a.p037d.p039b.p040a.C0605e;
import com.p032a.p033a.p042j.C0877f;
import com.p032a.p033a.p042j.C0879h;
import java.io.InputStream;
import java.util.EnumSet;
import java.util.Queue;
import java.util.Set;

/* renamed from: com.a.a.d.d.a.f */
public abstract class C0733f implements C0726a<InputStream> {
    public static final C0733f f2754a;
    public static final C0733f f2755b;
    public static final C0733f f2756c;
    private static final Set<C0748q> f2757d;
    private static final Queue<Options> f2758e;

    static {
        f2757d = EnumSet.of(C0748q.JPEG, C0748q.PNG_A, C0748q.PNG);
        f2758e = C0879h.m5306a(0);
        f2754a = new C0734g();
        f2755b = new C0735h();
        f2756c = new C0736i();
    }

    private int m4808a(int i, int i2, int i3, int i4, int i5) {
        if (i5 == RtlSpacingHelper.UNDEFINED) {
            i5 = i3;
        }
        if (i4 == RtlSpacingHelper.UNDEFINED) {
            i4 = i2;
        }
        int a = (i == 90 || i == 270) ? m4817a(i3, i2, i4, i5) : m4817a(i2, i3, i4, i5);
        return Math.max(1, a == 0 ? 0 : Integer.highestOneBit(a));
    }

    private static android.graphics.Bitmap.Config m4809a(java.io.InputStream r6, com.p032a.p033a.p037d.C0598a r7) {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x0071 in list []
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:58)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
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
        r5 = 5;
        r0 = com.p032a.p033a.p037d.C0598a.ALWAYS_ARGB_8888;
        if (r7 == r0) goto L_0x000f;
    L_0x0005:
        r0 = com.p032a.p033a.p037d.C0598a.PREFER_ARGB_8888;
        if (r7 == r0) goto L_0x000f;
    L_0x0009:
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 16;
        if (r0 != r1) goto L_0x0012;
    L_0x000f:
        r0 = android.graphics.Bitmap.Config.ARGB_8888;
    L_0x0011:
        return r0;
    L_0x0012:
        r1 = 0;
        r0 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r6.mark(r0);
        r0 = new com.a.a.d.d.a.p;	 Catch:{ IOException -> 0x003a, all -> 0x0073 }
        r0.<init>(r6);	 Catch:{ IOException -> 0x003a, all -> 0x0073 }
        r0 = r0.m4857a();	 Catch:{ IOException -> 0x003a, all -> 0x0073 }
        r6.reset();	 Catch:{ IOException -> 0x0029 }
    L_0x0024:
        if (r0 == 0) goto L_0x0089;
    L_0x0026:
        r0 = android.graphics.Bitmap.Config.ARGB_8888;
        goto L_0x0011;
    L_0x0029:
        r1 = move-exception;
        r2 = "Downsampler";
        r2 = android.util.Log.isLoggable(r2, r5);
        if (r2 == 0) goto L_0x0024;
    L_0x0032:
        r2 = "Downsampler";
        r3 = "Cannot reset the input stream";
        android.util.Log.w(r2, r3, r1);
        goto L_0x0024;
    L_0x003a:
        r0 = move-exception;
        r2 = "Downsampler";	 Catch:{ IOException -> 0x003a, all -> 0x0073 }
        r3 = 5;	 Catch:{ IOException -> 0x003a, all -> 0x0073 }
        r2 = android.util.Log.isLoggable(r2, r3);	 Catch:{ IOException -> 0x003a, all -> 0x0073 }
        if (r2 == 0) goto L_0x005c;	 Catch:{ IOException -> 0x003a, all -> 0x0073 }
    L_0x0044:
        r2 = "Downsampler";	 Catch:{ IOException -> 0x003a, all -> 0x0073 }
        r3 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x003a, all -> 0x0073 }
        r3.<init>();	 Catch:{ IOException -> 0x003a, all -> 0x0073 }
        r4 = "Cannot determine whether the image has alpha or not from header for format ";	 Catch:{ IOException -> 0x003a, all -> 0x0073 }
        r3 = r3.append(r4);	 Catch:{ IOException -> 0x003a, all -> 0x0073 }
        r3 = r3.append(r7);	 Catch:{ IOException -> 0x003a, all -> 0x0073 }
        r3 = r3.toString();	 Catch:{ IOException -> 0x003a, all -> 0x0073 }
        android.util.Log.w(r2, r3, r0);	 Catch:{ IOException -> 0x003a, all -> 0x0073 }
    L_0x005c:
        r6.reset();
        r0 = r1;
        goto L_0x0024;
    L_0x0061:
        r0 = move-exception;
        r2 = "Downsampler";
        r2 = android.util.Log.isLoggable(r2, r5);
        if (r2 == 0) goto L_0x0071;
    L_0x006a:
        r2 = "Downsampler";
        r3 = "Cannot reset the input stream";
        android.util.Log.w(r2, r3, r0);
    L_0x0071:
        r0 = r1;
        goto L_0x0024;
    L_0x0073:
        r0 = move-exception;
        r6.reset();	 Catch:{ IOException -> 0x0078 }
    L_0x0077:
        throw r0;
    L_0x0078:
        r1 = move-exception;
        r2 = "Downsampler";
        r2 = android.util.Log.isLoggable(r2, r5);
        if (r2 == 0) goto L_0x0077;
    L_0x0081:
        r2 = "Downsampler";
        r3 = "Cannot reset the input stream";
        android.util.Log.w(r2, r3, r1);
        goto L_0x0077;
    L_0x0089:
        r0 = android.graphics.Bitmap.Config.RGB_565;
        goto L_0x0011;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.a.a.d.d.a.f.a(java.io.InputStream, com.a.a.d.a):android.graphics.Bitmap$Config");
    }

    private Bitmap m4810a(C0877f c0877f, C0753v c0753v, Options options, C0605e c0605e, int i, int i2, int i3, C0598a c0598a) {
        Config a = C0733f.m4809a((InputStream) c0877f, c0598a);
        options.inSampleSize = i3;
        options.inPreferredConfig = a;
        if ((options.inSampleSize == 1 || 19 <= VERSION.SDK_INT) && C0733f.m4813a((InputStream) c0877f)) {
            C0733f.m4812a(options, c0605e.m4512b((int) Math.ceil(((double) i) / ((double) i3)), (int) Math.ceil(((double) i2) / ((double) i3)), a));
        }
        return C0733f.m4814b(c0877f, c0753v, options);
    }

    private static void m4811a(Options options) {
        C0733f.m4816b(options);
        synchronized (f2758e) {
            f2758e.offer(options);
        }
    }

    @TargetApi(11)
    private static void m4812a(Options options, Bitmap bitmap) {
        if (11 <= VERSION.SDK_INT) {
            options.inBitmap = bitmap;
        }
    }

    private static boolean m4813a(java.io.InputStream r4) {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x0046 in list []
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:58)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
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
        r3 = 5;
        r0 = 19;
        r1 = android.os.Build.VERSION.SDK_INT;
        if (r0 > r1) goto L_0x0009;
    L_0x0007:
        r0 = 1;
    L_0x0008:
        return r0;
    L_0x0009:
        r0 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r4.mark(r0);
        r0 = new com.a.a.d.d.a.p;	 Catch:{ IOException -> 0x0032, all -> 0x0059 }
        r0.<init>(r4);	 Catch:{ IOException -> 0x0032, all -> 0x0059 }
        r0 = r0.m4858b();	 Catch:{ IOException -> 0x0032, all -> 0x0059 }
        r1 = f2757d;	 Catch:{ IOException -> 0x0032, all -> 0x0059 }
        r0 = r1.contains(r0);	 Catch:{ IOException -> 0x0032, all -> 0x0059 }
        r4.reset();	 Catch:{ IOException -> 0x0021 }
        goto L_0x0008;
    L_0x0021:
        r1 = move-exception;
        r2 = "Downsampler";
        r2 = android.util.Log.isLoggable(r2, r3);
        if (r2 == 0) goto L_0x0008;
    L_0x002a:
        r2 = "Downsampler";
        r3 = "Cannot reset the input stream";
        android.util.Log.w(r2, r3, r1);
        goto L_0x0008;
    L_0x0032:
        r0 = move-exception;
        r1 = "Downsampler";	 Catch:{ IOException -> 0x0032, all -> 0x0059 }
        r2 = 5;	 Catch:{ IOException -> 0x0032, all -> 0x0059 }
        r1 = android.util.Log.isLoggable(r1, r2);	 Catch:{ IOException -> 0x0032, all -> 0x0059 }
        if (r1 == 0) goto L_0x0043;	 Catch:{ IOException -> 0x0032, all -> 0x0059 }
    L_0x003c:
        r1 = "Downsampler";	 Catch:{ IOException -> 0x0032, all -> 0x0059 }
        r2 = "Cannot determine the image type from header";	 Catch:{ IOException -> 0x0032, all -> 0x0059 }
        android.util.Log.w(r1, r2, r0);	 Catch:{ IOException -> 0x0032, all -> 0x0059 }
    L_0x0043:
        r4.reset();
    L_0x0046:
        r0 = 0;
        goto L_0x0008;
    L_0x0048:
        r0 = move-exception;
        r1 = "Downsampler";
        r1 = android.util.Log.isLoggable(r1, r3);
        if (r1 == 0) goto L_0x0046;
    L_0x0051:
        r1 = "Downsampler";
        r2 = "Cannot reset the input stream";
        android.util.Log.w(r1, r2, r0);
        goto L_0x0046;
    L_0x0059:
        r0 = move-exception;
        r4.reset();	 Catch:{ IOException -> 0x005e }
    L_0x005d:
        throw r0;
    L_0x005e:
        r1 = move-exception;
        r2 = "Downsampler";
        r2 = android.util.Log.isLoggable(r2, r3);
        if (r2 == 0) goto L_0x005d;
    L_0x0067:
        r2 = "Downsampler";
        r3 = "Cannot reset the input stream";
        android.util.Log.w(r2, r3, r1);
        goto L_0x005d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.a.a.d.d.a.f.a(java.io.InputStream):boolean");
    }

    private static Bitmap m4814b(C0877f c0877f, C0753v c0753v, Options options) {
        if (options.inJustDecodeBounds) {
            c0877f.mark(5242880);
        } else {
            c0753v.m4879a();
        }
        Bitmap decodeStream = BitmapFactory.decodeStream(c0877f, null, options);
        try {
            if (options.inJustDecodeBounds) {
                c0877f.reset();
            }
        } catch (Throwable e) {
            if (Log.isLoggable("Downsampler", 6)) {
                Log.e("Downsampler", "Exception loading inDecodeBounds=" + options.inJustDecodeBounds + " sample=" + options.inSampleSize, e);
            }
        }
        return decodeStream;
    }

    @TargetApi(11)
    private static synchronized Options m4815b() {
        Options options;
        synchronized (C0733f.class) {
            synchronized (f2758e) {
                options = (Options) f2758e.poll();
            }
            if (options == null) {
                options = new Options();
                C0733f.m4816b(options);
            }
        }
        return options;
    }

    @TargetApi(11)
    private static void m4816b(Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        if (11 <= VERSION.SDK_INT) {
            options.inBitmap = null;
            options.inMutable = true;
        }
    }

    protected abstract int m4817a(int i, int i2, int i3, int i4);

    public android.graphics.Bitmap m4818a(java.io.InputStream r21, com.p032a.p033a.p037d.p039b.p040a.C0605e r22, int r23, int r24, com.p032a.p033a.p037d.C0598a r25) {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x00be in list []
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:58)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
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
        r20 = this;
        r16 = com.p032a.p033a.p042j.C0873a.m5286a();
        r17 = r16.m5288b();
        r18 = r16.m5288b();
        r9 = com.p032a.p033a.p037d.p049d.p050a.C0733f.m4815b();
        r8 = new com.a.a.d.d.a.v;
        r0 = r21;
        r1 = r18;
        r8.<init>(r0, r1);
        r19 = com.p032a.p033a.p042j.C0875c.m5291a(r8);
        r10 = new com.a.a.j.f;
        r0 = r19;
        r10.<init>(r0);
        r2 = 5242880; // 0x500000 float:7.34684E-39 double:2.590327E-317;
        r0 = r19;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r0.mark(r2);	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r3 = 0;
        r2 = new com.a.a.d.d.a.p;	 Catch:{ IOException -> 0x0097, all -> 0x00c1 }
        r0 = r19;	 Catch:{ IOException -> 0x0097, all -> 0x00c1 }
        r2.<init>(r0);	 Catch:{ IOException -> 0x0097, all -> 0x00c1 }
        r2 = r2.m4859c();	 Catch:{ IOException -> 0x0097, all -> 0x00c1 }
        r19.reset();	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r15 = r2;
    L_0x003b:
        r0 = r17;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r9.inTempStorage = r0;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r0 = r20;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r2 = r0.m4819a(r10, r8, r9);	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r3 = 0;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r4 = r2[r3];	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r3 = 1;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r5 = r2[r3];	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r3 = com.p032a.p033a.p037d.p049d.p050a.C0757z.m4887a(r15);	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r2 = r20;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r6 = r23;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r7 = r24;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r13 = r2.m4808a(r3, r4, r5, r6, r7);	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r6 = r20;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r7 = r10;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r10 = r22;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r11 = r4;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r12 = r5;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r14 = r25;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r3 = r6.m4810a(r7, r8, r9, r10, r11, r12, r13, r14);	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r2 = r19.m5292a();	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        if (r2 == 0) goto L_0x00d8;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
    L_0x006c:
        r3 = new java.lang.RuntimeException;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r3.<init>(r2);	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        throw r3;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
    L_0x0072:
        r2 = move-exception;
        r16.m5287a(r17);
        r0 = r16;
        r1 = r18;
        r0.m5287a(r1);
        r19.m5293b();
        com.p032a.p033a.p037d.p049d.p050a.C0733f.m4811a(r9);
        throw r2;
    L_0x0084:
        r3 = move-exception;
        r4 = "Downsampler";	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r5 = 5;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r4 = android.util.Log.isLoggable(r4, r5);	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        if (r4 == 0) goto L_0x0095;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
    L_0x008e:
        r4 = "Downsampler";	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r5 = "Cannot reset the input stream";	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        android.util.Log.w(r4, r5, r3);	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
    L_0x0095:
        r15 = r2;
        goto L_0x003b;
    L_0x0097:
        r2 = move-exception;
        r4 = "Downsampler";	 Catch:{ IOException -> 0x0097, all -> 0x00c1 }
        r5 = 5;	 Catch:{ IOException -> 0x0097, all -> 0x00c1 }
        r4 = android.util.Log.isLoggable(r4, r5);	 Catch:{ IOException -> 0x0097, all -> 0x00c1 }
        if (r4 == 0) goto L_0x00a8;	 Catch:{ IOException -> 0x0097, all -> 0x00c1 }
    L_0x00a1:
        r4 = "Downsampler";	 Catch:{ IOException -> 0x0097, all -> 0x00c1 }
        r5 = "Cannot determine the image orientation from header";	 Catch:{ IOException -> 0x0097, all -> 0x00c1 }
        android.util.Log.w(r4, r5, r2);	 Catch:{ IOException -> 0x0097, all -> 0x00c1 }
    L_0x00a8:
        r19.reset();
        r15 = r3;
        goto L_0x003b;
    L_0x00ad:
        r2 = move-exception;
        r4 = "Downsampler";
        r5 = 5;
        r4 = android.util.Log.isLoggable(r4, r5);
        if (r4 == 0) goto L_0x00be;
    L_0x00b7:
        r4 = "Downsampler";
        r5 = "Cannot reset the input stream";
        android.util.Log.w(r4, r5, r2);
    L_0x00be:
        r15 = r3;
        goto L_0x003b;
    L_0x00c1:
        r2 = move-exception;
        r19.reset();	 Catch:{ IOException -> 0x00c6 }
    L_0x00c5:
        throw r2;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
    L_0x00c6:
        r3 = move-exception;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r4 = "Downsampler";	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r5 = 5;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r4 = android.util.Log.isLoggable(r4, r5);	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        if (r4 == 0) goto L_0x00c5;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
    L_0x00d0:
        r4 = "Downsampler";	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r5 = "Cannot reset the input stream";	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        android.util.Log.w(r4, r5, r3);	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        goto L_0x00c5;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
    L_0x00d8:
        r2 = 0;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        if (r3 == 0) goto L_0x00f2;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
    L_0x00db:
        r0 = r22;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r2 = com.p032a.p033a.p037d.p049d.p050a.C0757z.m4890a(r3, r0, r15);	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r4 = r3.equals(r2);	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        if (r4 != 0) goto L_0x00f2;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
    L_0x00e7:
        r0 = r22;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r4 = r0.m4511a(r3);	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        if (r4 != 0) goto L_0x00f2;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
    L_0x00ef:
        r3.recycle();	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
    L_0x00f2:
        r16.m5287a(r17);
        r0 = r16;
        r1 = r18;
        r0.m5287a(r1);
        r19.m5293b();
        com.p032a.p033a.p037d.p049d.p050a.C0733f.m4811a(r9);
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.a.a.d.d.a.f.a(java.io.InputStream, com.a.a.d.b.a.e, int, int, com.a.a.d.a):android.graphics.Bitmap");
    }

    public int[] m4819a(C0877f c0877f, C0753v c0753v, Options options) {
        options.inJustDecodeBounds = true;
        C0733f.m4814b(c0877f, c0753v, options);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }
}
