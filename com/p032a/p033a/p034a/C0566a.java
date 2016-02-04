package com.p032a.p033a.p034a;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import net.frakbot.glowpadbackport.BuildConfig;

/* renamed from: com.a.a.a.a */
public final class C0566a implements Closeable {
    final ThreadPoolExecutor f2341a;
    private final File f2342b;
    private final File f2343c;
    private final File f2344d;
    private final File f2345e;
    private final int f2346f;
    private long f2347g;
    private final int f2348h;
    private long f2349i;
    private Writer f2350j;
    private final LinkedHashMap<String, C0569d> f2351k;
    private int f2352l;
    private long f2353m;
    private final Callable<Void> f2354n;

    private C0566a(File file, int i, int i2, long j) {
        this.f2349i = 0;
        this.f2351k = new LinkedHashMap(0, 0.75f, true);
        this.f2353m = 0;
        this.f2341a = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.f2354n = new C0567b(this);
        this.f2342b = file;
        this.f2346f = i;
        this.f2343c = new File(file, "journal");
        this.f2344d = new File(file, "journal.tmp");
        this.f2345e = new File(file, "journal.bkp");
        this.f2348h = i2;
        this.f2347g = j;
    }

    public static C0566a m4228a(File file, int i, int i2, long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i2 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        } else {
            File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    C0566a.m4234a(file2, file3, false);
                }
            }
            C0566a c0566a = new C0566a(file, i, i2, j);
            if (c0566a.f2343c.exists()) {
                try {
                    c0566a.m4235b();
                    c0566a.m4237c();
                    return c0566a;
                } catch (IOException e) {
                    System.out.println("DiskLruCache " + file + " is corrupt: " + e.getMessage() + ", removing");
                    c0566a.m4248a();
                }
            }
            file.mkdirs();
            c0566a = new C0566a(file, i, i2, j);
            c0566a.m4239d();
            return c0566a;
        }
    }

    private synchronized C0568c m4229a(String str, long j) {
        C0568c c0568c;
        m4245f();
        C0569d c0569d = (C0569d) this.f2351k.get(str);
        if (j == -1 || (c0569d != null && c0569d.f2367h == j)) {
            C0569d c0569d2;
            if (c0569d == null) {
                c0569d = new C0569d(str, null);
                this.f2351k.put(str, c0569d);
                c0569d2 = c0569d;
            } else if (c0569d.f2366g != null) {
                c0568c = null;
            } else {
                c0569d2 = c0569d;
            }
            c0568c = new C0568c(c0569d2, null);
            c0569d2.f2366g = c0568c;
            this.f2350j.append("DIRTY");
            this.f2350j.append(' ');
            this.f2350j.append(str);
            this.f2350j.append('\n');
            this.f2350j.flush();
        } else {
            c0568c = null;
        }
        return c0568c;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void m4232a(com.p032a.p033a.p034a.C0568c r11, boolean r12) {
        /*
        r10 = this;
        r0 = 0;
        monitor-enter(r10);
        r2 = r11.f2357b;	 Catch:{ all -> 0x0012 }
        r1 = r2.f2366g;	 Catch:{ all -> 0x0012 }
        if (r1 == r11) goto L_0x0015;
    L_0x000c:
        r0 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x0012 }
        r0.<init>();	 Catch:{ all -> 0x0012 }
        throw r0;	 Catch:{ all -> 0x0012 }
    L_0x0012:
        r0 = move-exception;
        monitor-exit(r10);
        throw r0;
    L_0x0015:
        if (r12 == 0) goto L_0x0058;
    L_0x0017:
        r1 = r2.f2365f;	 Catch:{ all -> 0x0012 }
        if (r1 != 0) goto L_0x0058;
    L_0x001d:
        r1 = r0;
    L_0x001e:
        r3 = r10.f2348h;	 Catch:{ all -> 0x0012 }
        if (r1 >= r3) goto L_0x0058;
    L_0x0022:
        r3 = r11.f2358c;	 Catch:{ all -> 0x0012 }
        r3 = r3[r1];	 Catch:{ all -> 0x0012 }
        if (r3 != 0) goto L_0x0046;
    L_0x002a:
        r11.m4256b();	 Catch:{ all -> 0x0012 }
        r0 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x0012 }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0012 }
        r2.<init>();	 Catch:{ all -> 0x0012 }
        r3 = "Newly created entry didn't create value for index ";
        r2 = r2.append(r3);	 Catch:{ all -> 0x0012 }
        r1 = r2.append(r1);	 Catch:{ all -> 0x0012 }
        r1 = r1.toString();	 Catch:{ all -> 0x0012 }
        r0.<init>(r1);	 Catch:{ all -> 0x0012 }
        throw r0;	 Catch:{ all -> 0x0012 }
    L_0x0046:
        r3 = r2.m4271b(r1);	 Catch:{ all -> 0x0012 }
        r3 = r3.exists();	 Catch:{ all -> 0x0012 }
        if (r3 != 0) goto L_0x0055;
    L_0x0050:
        r11.m4256b();	 Catch:{ all -> 0x0012 }
    L_0x0053:
        monitor-exit(r10);
        return;
    L_0x0055:
        r1 = r1 + 1;
        goto L_0x001e;
    L_0x0058:
        r1 = r10.f2348h;	 Catch:{ all -> 0x0012 }
        if (r0 >= r1) goto L_0x008d;
    L_0x005c:
        r1 = r2.m4271b(r0);	 Catch:{ all -> 0x0012 }
        if (r12 == 0) goto L_0x0089;
    L_0x0062:
        r3 = r1.exists();	 Catch:{ all -> 0x0012 }
        if (r3 == 0) goto L_0x0086;
    L_0x0068:
        r3 = r2.m4269a(r0);	 Catch:{ all -> 0x0012 }
        r1.renameTo(r3);	 Catch:{ all -> 0x0012 }
        r1 = r2.f2364e;	 Catch:{ all -> 0x0012 }
        r4 = r1[r0];	 Catch:{ all -> 0x0012 }
        r6 = r3.length();	 Catch:{ all -> 0x0012 }
        r1 = r2.f2364e;	 Catch:{ all -> 0x0012 }
        r1[r0] = r6;	 Catch:{ all -> 0x0012 }
        r8 = r10.f2349i;	 Catch:{ all -> 0x0012 }
        r4 = r8 - r4;
        r4 = r4 + r6;
        r10.f2349i = r4;	 Catch:{ all -> 0x0012 }
    L_0x0086:
        r0 = r0 + 1;
        goto L_0x0058;
    L_0x0089:
        com.p032a.p033a.p034a.C0566a.m4233a(r1);	 Catch:{ all -> 0x0012 }
        goto L_0x0086;
    L_0x008d:
        r0 = r10.f2352l;	 Catch:{ all -> 0x0012 }
        r0 = r0 + 1;
        r10.f2352l = r0;	 Catch:{ all -> 0x0012 }
        r0 = 0;
        r2.f2366g = r0;	 Catch:{ all -> 0x0012 }
        r0 = r2.f2365f;	 Catch:{ all -> 0x0012 }
        r0 = r0 | r12;
        if (r0 == 0) goto L_0x00f1;
    L_0x009e:
        r0 = 1;
        r2.f2365f = r0;	 Catch:{ all -> 0x0012 }
        r0 = r10.f2350j;	 Catch:{ all -> 0x0012 }
        r1 = "CLEAN";
        r0.append(r1);	 Catch:{ all -> 0x0012 }
        r0 = r10.f2350j;	 Catch:{ all -> 0x0012 }
        r1 = 32;
        r0.append(r1);	 Catch:{ all -> 0x0012 }
        r0 = r10.f2350j;	 Catch:{ all -> 0x0012 }
        r1 = r2.f2363d;	 Catch:{ all -> 0x0012 }
        r0.append(r1);	 Catch:{ all -> 0x0012 }
        r0 = r10.f2350j;	 Catch:{ all -> 0x0012 }
        r1 = r2.m4270a();	 Catch:{ all -> 0x0012 }
        r0.append(r1);	 Catch:{ all -> 0x0012 }
        r0 = r10.f2350j;	 Catch:{ all -> 0x0012 }
        r1 = 10;
        r0.append(r1);	 Catch:{ all -> 0x0012 }
        if (r12 == 0) goto L_0x00d5;
    L_0x00cb:
        r0 = r10.f2353m;	 Catch:{ all -> 0x0012 }
        r4 = 1;
        r4 = r4 + r0;
        r10.f2353m = r4;	 Catch:{ all -> 0x0012 }
        r2.f2367h = r0;	 Catch:{ all -> 0x0012 }
    L_0x00d5:
        r0 = r10.f2350j;	 Catch:{ all -> 0x0012 }
        r0.flush();	 Catch:{ all -> 0x0012 }
        r0 = r10.f2349i;	 Catch:{ all -> 0x0012 }
        r2 = r10.f2347g;	 Catch:{ all -> 0x0012 }
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 > 0) goto L_0x00e8;
    L_0x00e2:
        r0 = r10.m4243e();	 Catch:{ all -> 0x0012 }
        if (r0 == 0) goto L_0x0053;
    L_0x00e8:
        r0 = r10.f2341a;	 Catch:{ all -> 0x0012 }
        r1 = r10.f2354n;	 Catch:{ all -> 0x0012 }
        r0.submit(r1);	 Catch:{ all -> 0x0012 }
        goto L_0x0053;
    L_0x00f1:
        r0 = r10.f2351k;	 Catch:{ all -> 0x0012 }
        r1 = r2.f2363d;	 Catch:{ all -> 0x0012 }
        r0.remove(r1);	 Catch:{ all -> 0x0012 }
        r0 = r10.f2350j;	 Catch:{ all -> 0x0012 }
        r1 = "REMOVE";
        r0.append(r1);	 Catch:{ all -> 0x0012 }
        r0 = r10.f2350j;	 Catch:{ all -> 0x0012 }
        r1 = 32;
        r0.append(r1);	 Catch:{ all -> 0x0012 }
        r0 = r10.f2350j;	 Catch:{ all -> 0x0012 }
        r1 = r2.f2363d;	 Catch:{ all -> 0x0012 }
        r0.append(r1);	 Catch:{ all -> 0x0012 }
        r0 = r10.f2350j;	 Catch:{ all -> 0x0012 }
        r1 = 10;
        r0.append(r1);	 Catch:{ all -> 0x0012 }
        goto L_0x00d5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.a.a.a.a.a(com.a.a.a.c, boolean):void");
    }

    private static void m4233a(File file) {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private static void m4234a(File file, File file2, boolean z) {
        if (z) {
            C0566a.m4233a(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    private void m4235b() {
        int i;
        Closeable c0571f = new C0571f(new FileInputStream(this.f2343c), C0573h.f2379a);
        try {
            String a = c0571f.m4275a();
            String a2 = c0571f.m4275a();
            String a3 = c0571f.m4275a();
            String a4 = c0571f.m4275a();
            String a5 = c0571f.m4275a();
            if ("libcore.io.DiskLruCache".equals(a) && "1".equals(a2) && Integer.toString(this.f2346f).equals(a3) && Integer.toString(this.f2348h).equals(a4) && BuildConfig.FLAVOR.equals(a5)) {
                i = 0;
                while (true) {
                    m4241d(c0571f.m4275a());
                    i++;
                }
            } else {
                throw new IOException("unexpected journal header: [" + a + ", " + a2 + ", " + a4 + ", " + a5 + "]");
            }
        } catch (EOFException e) {
            this.f2352l = i - this.f2351k.size();
            if (c0571f.m4276b()) {
                m4239d();
            } else {
                this.f2350j = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f2343c, true), C0573h.f2379a));
            }
            C0573h.m4277a(c0571f);
        } catch (Throwable th) {
            C0573h.m4277a(c0571f);
        }
    }

    private void m4237c() {
        C0566a.m4233a(this.f2344d);
        Iterator it = this.f2351k.values().iterator();
        while (it.hasNext()) {
            C0569d c0569d = (C0569d) it.next();
            int i;
            if (c0569d.f2366g == null) {
                for (i = 0; i < this.f2348h; i++) {
                    this.f2349i += c0569d.f2364e[i];
                }
            } else {
                c0569d.f2366g = null;
                for (i = 0; i < this.f2348h; i++) {
                    C0566a.m4233a(c0569d.m4269a(i));
                    C0566a.m4233a(c0569d.m4271b(i));
                }
                it.remove();
            }
        }
    }

    private synchronized void m4239d() {
        if (this.f2350j != null) {
            this.f2350j.close();
        }
        Writer bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f2344d), C0573h.f2379a));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f2346f));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f2348h));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (C0569d c0569d : this.f2351k.values()) {
                if (c0569d.f2366g != null) {
                    bufferedWriter.write("DIRTY " + c0569d.f2363d + '\n');
                } else {
                    bufferedWriter.write("CLEAN " + c0569d.f2363d + c0569d.m4270a() + '\n');
                }
            }
            bufferedWriter.close();
            if (this.f2343c.exists()) {
                C0566a.m4234a(this.f2343c, this.f2345e, true);
            }
            C0566a.m4234a(this.f2344d, this.f2343c, false);
            this.f2345e.delete();
            this.f2350j = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f2343c, true), C0573h.f2379a));
        } catch (Throwable th) {
            bufferedWriter.close();
        }
    }

    private void m4241d(String str) {
        int indexOf = str.indexOf(32);
        if (indexOf == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        String str2;
        int i = indexOf + 1;
        int indexOf2 = str.indexOf(32, i);
        if (indexOf2 == -1) {
            String substring = str.substring(i);
            if (indexOf == "REMOVE".length() && str.startsWith("REMOVE")) {
                this.f2351k.remove(substring);
                return;
            }
            str2 = substring;
        } else {
            str2 = str.substring(i, indexOf2);
        }
        C0569d c0569d = (C0569d) this.f2351k.get(str2);
        if (c0569d == null) {
            c0569d = new C0569d(str2, null);
            this.f2351k.put(str2, c0569d);
        }
        if (indexOf2 != -1 && indexOf == "CLEAN".length() && str.startsWith("CLEAN")) {
            String[] split = str.substring(indexOf2 + 1).split(" ");
            c0569d.f2365f = true;
            c0569d.f2366g = null;
            c0569d.m4262a(split);
        } else if (indexOf2 == -1 && indexOf == "DIRTY".length() && str.startsWith("DIRTY")) {
            c0569d.f2366g = new C0568c(c0569d, null);
        } else if (indexOf2 != -1 || indexOf != "READ".length() || !str.startsWith("READ")) {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    private boolean m4243e() {
        return this.f2352l >= 2000 && this.f2352l >= this.f2351k.size();
    }

    private void m4245f() {
        if (this.f2350j == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    private void m4246g() {
        while (this.f2349i > this.f2347g) {
            m4250c((String) ((Entry) this.f2351k.entrySet().iterator().next()).getKey());
        }
    }

    public synchronized C0570e m4247a(String str) {
        C0570e c0570e = null;
        synchronized (this) {
            m4245f();
            C0569d c0569d = (C0569d) this.f2351k.get(str);
            if (c0569d != null) {
                if (c0569d.f2365f) {
                    for (File exists : c0569d.f2360a) {
                        if (!exists.exists()) {
                            break;
                        }
                    }
                    this.f2352l++;
                    this.f2350j.append("READ");
                    this.f2350j.append(' ');
                    this.f2350j.append(str);
                    this.f2350j.append('\n');
                    if (m4243e()) {
                        this.f2341a.submit(this.f2354n);
                    }
                    c0570e = new C0570e(str, c0569d.f2367h, c0569d.f2360a, c0569d.f2364e, null);
                }
            }
        }
        return c0570e;
    }

    public void m4248a() {
        close();
        C0573h.m4278a(this.f2342b);
    }

    public C0568c m4249b(String str) {
        return m4229a(str, -1);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean m4250c(java.lang.String r7) {
        /*
        r6 = this;
        r1 = 0;
        monitor-enter(r6);
        r6.m4245f();	 Catch:{ all -> 0x005a }
        r0 = r6.f2351k;	 Catch:{ all -> 0x005a }
        r0 = r0.get(r7);	 Catch:{ all -> 0x005a }
        r0 = (com.p032a.p033a.p034a.C0569d) r0;	 Catch:{ all -> 0x005a }
        if (r0 == 0) goto L_0x0015;
    L_0x000f:
        r2 = r0.f2366g;	 Catch:{ all -> 0x005a }
        if (r2 == 0) goto L_0x002d;
    L_0x0015:
        r0 = r1;
    L_0x0016:
        monitor-exit(r6);
        return r0;
    L_0x0018:
        r2 = r6.f2349i;	 Catch:{ all -> 0x005a }
        r4 = r0.f2364e;	 Catch:{ all -> 0x005a }
        r4 = r4[r1];	 Catch:{ all -> 0x005a }
        r2 = r2 - r4;
        r6.f2349i = r2;	 Catch:{ all -> 0x005a }
        r2 = r0.f2364e;	 Catch:{ all -> 0x005a }
        r4 = 0;
        r2[r1] = r4;	 Catch:{ all -> 0x005a }
        r1 = r1 + 1;
    L_0x002d:
        r2 = r6.f2348h;	 Catch:{ all -> 0x005a }
        if (r1 >= r2) goto L_0x005d;
    L_0x0031:
        r2 = r0.m4269a(r1);	 Catch:{ all -> 0x005a }
        r3 = r2.exists();	 Catch:{ all -> 0x005a }
        if (r3 == 0) goto L_0x0018;
    L_0x003b:
        r3 = r2.delete();	 Catch:{ all -> 0x005a }
        if (r3 != 0) goto L_0x0018;
    L_0x0041:
        r0 = new java.io.IOException;	 Catch:{ all -> 0x005a }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x005a }
        r1.<init>();	 Catch:{ all -> 0x005a }
        r3 = "failed to delete ";
        r1 = r1.append(r3);	 Catch:{ all -> 0x005a }
        r1 = r1.append(r2);	 Catch:{ all -> 0x005a }
        r1 = r1.toString();	 Catch:{ all -> 0x005a }
        r0.<init>(r1);	 Catch:{ all -> 0x005a }
        throw r0;	 Catch:{ all -> 0x005a }
    L_0x005a:
        r0 = move-exception;
        monitor-exit(r6);
        throw r0;
    L_0x005d:
        r0 = r6.f2352l;	 Catch:{ all -> 0x005a }
        r0 = r0 + 1;
        r6.f2352l = r0;	 Catch:{ all -> 0x005a }
        r0 = r6.f2350j;	 Catch:{ all -> 0x005a }
        r1 = "REMOVE";
        r0.append(r1);	 Catch:{ all -> 0x005a }
        r0 = r6.f2350j;	 Catch:{ all -> 0x005a }
        r1 = 32;
        r0.append(r1);	 Catch:{ all -> 0x005a }
        r0 = r6.f2350j;	 Catch:{ all -> 0x005a }
        r0.append(r7);	 Catch:{ all -> 0x005a }
        r0 = r6.f2350j;	 Catch:{ all -> 0x005a }
        r1 = 10;
        r0.append(r1);	 Catch:{ all -> 0x005a }
        r0 = r6.f2351k;	 Catch:{ all -> 0x005a }
        r0.remove(r7);	 Catch:{ all -> 0x005a }
        r0 = r6.m4243e();	 Catch:{ all -> 0x005a }
        if (r0 == 0) goto L_0x008f;
    L_0x0088:
        r0 = r6.f2341a;	 Catch:{ all -> 0x005a }
        r1 = r6.f2354n;	 Catch:{ all -> 0x005a }
        r0.submit(r1);	 Catch:{ all -> 0x005a }
    L_0x008f:
        r0 = 1;
        goto L_0x0016;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.a.a.a.a.c(java.lang.String):boolean");
    }

    public synchronized void close() {
        if (this.f2350j != null) {
            Iterator it = new ArrayList(this.f2351k.values()).iterator();
            while (it.hasNext()) {
                C0569d c0569d = (C0569d) it.next();
                if (c0569d.f2366g != null) {
                    c0569d.f2366g.m4256b();
                }
            }
            m4246g();
            this.f2350j.close();
            this.f2350j = null;
        }
    }
}
