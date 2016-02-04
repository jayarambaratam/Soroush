package com.p032a.p033a.p037d.p039b.p040a;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.a.a.d.b.a.i */
public class C0609i implements C0605e {
    private static final Config f2549a;
    private final C0599m f2550b;
    private final Set<Config> f2551c;
    private final int f2552d;
    private final C0611k f2553e;
    private int f2554f;
    private int f2555g;
    private int f2556h;
    private int f2557i;
    private int f2558j;
    private int f2559k;

    static {
        f2549a = Config.ARGB_8888;
    }

    public C0609i(int i) {
        this(i, C0609i.m4533e(), C0609i.m4534f());
    }

    C0609i(int i, C0599m c0599m, Set<Config> set) {
        this.f2552d = i;
        this.f2554f = i;
        this.f2550b = c0599m;
        this.f2551c = set;
        this.f2553e = new C0612l();
    }

    private void m4529b() {
        m4530b(this.f2554f);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void m4530b(int r5) {
        /*
        r4 = this;
        monitor-enter(r4);
    L_0x0001:
        r0 = r4.f2555g;	 Catch:{ all -> 0x0069 }
        if (r0 <= r5) goto L_0x0023;
    L_0x0005:
        r0 = r4.f2550b;	 Catch:{ all -> 0x0069 }
        r0 = r0.m4484a();	 Catch:{ all -> 0x0069 }
        if (r0 != 0) goto L_0x0025;
    L_0x000d:
        r0 = "LruBitmapPool";
        r1 = 5;
        r0 = android.util.Log.isLoggable(r0, r1);	 Catch:{ all -> 0x0069 }
        if (r0 == 0) goto L_0x0020;
    L_0x0016:
        r0 = "LruBitmapPool";
        r1 = "Size mismatch, resetting";
        android.util.Log.w(r0, r1);	 Catch:{ all -> 0x0069 }
        r4.m4532d();	 Catch:{ all -> 0x0069 }
    L_0x0020:
        r0 = 0;
        r4.f2555g = r0;	 Catch:{ all -> 0x0069 }
    L_0x0023:
        monitor-exit(r4);
        return;
    L_0x0025:
        r1 = r4.f2553e;	 Catch:{ all -> 0x0069 }
        r1.m4541b(r0);	 Catch:{ all -> 0x0069 }
        r1 = r4.f2555g;	 Catch:{ all -> 0x0069 }
        r2 = r4.f2550b;	 Catch:{ all -> 0x0069 }
        r2 = r2.m4489c(r0);	 Catch:{ all -> 0x0069 }
        r1 = r1 - r2;
        r4.f2555g = r1;	 Catch:{ all -> 0x0069 }
        r0.recycle();	 Catch:{ all -> 0x0069 }
        r1 = r4.f2559k;	 Catch:{ all -> 0x0069 }
        r1 = r1 + 1;
        r4.f2559k = r1;	 Catch:{ all -> 0x0069 }
        r1 = "LruBitmapPool";
        r2 = 3;
        r1 = android.util.Log.isLoggable(r1, r2);	 Catch:{ all -> 0x0069 }
        if (r1 == 0) goto L_0x0065;
    L_0x0047:
        r1 = "LruBitmapPool";
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0069 }
        r2.<init>();	 Catch:{ all -> 0x0069 }
        r3 = "Evicting bitmap=";
        r2 = r2.append(r3);	 Catch:{ all -> 0x0069 }
        r3 = r4.f2550b;	 Catch:{ all -> 0x0069 }
        r0 = r3.m4488b(r0);	 Catch:{ all -> 0x0069 }
        r0 = r2.append(r0);	 Catch:{ all -> 0x0069 }
        r0 = r0.toString();	 Catch:{ all -> 0x0069 }
        android.util.Log.d(r1, r0);	 Catch:{ all -> 0x0069 }
    L_0x0065:
        r4.m4531c();	 Catch:{ all -> 0x0069 }
        goto L_0x0001;
    L_0x0069:
        r0 = move-exception;
        monitor-exit(r4);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.a.a.d.b.a.i.b(int):void");
    }

    private void m4531c() {
        if (Log.isLoggable("LruBitmapPool", 2)) {
            m4532d();
        }
    }

    private void m4532d() {
        Log.v("LruBitmapPool", "Hits=" + this.f2556h + ", misses=" + this.f2557i + ", puts=" + this.f2558j + ", evictions=" + this.f2559k + ", currentSize=" + this.f2555g + ", maxSize=" + this.f2554f + "\nStrategy=" + this.f2550b);
    }

    private static C0599m m4533e() {
        return VERSION.SDK_INT >= 19 ? new C0613o() : new C0600a();
    }

    private static Set<Config> m4534f() {
        Set hashSet = new HashSet();
        hashSet.addAll(Arrays.asList(Config.values()));
        if (VERSION.SDK_INT >= 19) {
            hashSet.add(null);
        }
        return Collections.unmodifiableSet(hashSet);
    }

    public synchronized Bitmap m4535a(int i, int i2, Config config) {
        Bitmap b;
        b = m4539b(i, i2, config);
        if (b != null) {
            b.eraseColor(0);
        }
        return b;
    }

    public void m4536a() {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "clearMemory");
        }
        m4530b(0);
    }

    @SuppressLint({"InlinedApi"})
    public void m4537a(int i) {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "trimMemory, level=" + i);
        }
        if (i >= 60) {
            m4536a();
        } else if (i >= 40) {
            m4530b(this.f2554f / 2);
        }
    }

    public synchronized boolean m4538a(Bitmap bitmap) {
        boolean z;
        if (bitmap == null) {
            throw new NullPointerException("Bitmap must not be null");
        } else if (bitmap.isMutable() && this.f2550b.m4489c(bitmap) <= this.f2554f && this.f2551c.contains(bitmap.getConfig())) {
            int c = this.f2550b.m4489c(bitmap);
            this.f2550b.m4486a(bitmap);
            this.f2553e.m4540a(bitmap);
            this.f2558j++;
            this.f2555g = c + this.f2555g;
            if (Log.isLoggable("LruBitmapPool", 2)) {
                Log.v("LruBitmapPool", "Put bitmap in pool=" + this.f2550b.m4488b(bitmap));
            }
            m4531c();
            m4529b();
            z = true;
        } else {
            if (Log.isLoggable("LruBitmapPool", 2)) {
                Log.v("LruBitmapPool", "Reject bitmap from pool, bitmap: " + this.f2550b.m4488b(bitmap) + ", is mutable: " + bitmap.isMutable() + ", is allowed config: " + this.f2551c.contains(bitmap.getConfig()));
            }
            z = false;
        }
        return z;
    }

    @TargetApi(12)
    public synchronized Bitmap m4539b(int i, int i2, Config config) {
        Bitmap a;
        a = this.f2550b.m4485a(i, i2, config != null ? config : f2549a);
        if (a == null) {
            if (Log.isLoggable("LruBitmapPool", 3)) {
                Log.d("LruBitmapPool", "Missing bitmap=" + this.f2550b.m4487b(i, i2, config));
            }
            this.f2557i++;
        } else {
            this.f2556h++;
            this.f2555g -= this.f2550b.m4489c(a);
            this.f2553e.m4541b(a);
            if (VERSION.SDK_INT >= 12) {
                a.setHasAlpha(true);
            }
        }
        if (Log.isLoggable("LruBitmapPool", 2)) {
            Log.v("LruBitmapPool", "Get bitmap=" + this.f2550b.m4487b(i, i2, config));
        }
        m4531c();
        return a;
    }
}
