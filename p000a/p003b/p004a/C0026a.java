package p000a.p003b.p004a;

import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: a.b.a.a */
public class C0026a {
    private static final Logger f82e;
    protected Random f83a;
    protected int f84b;
    protected int f85c;
    protected C0028b f86d;

    static {
        f82e = Logger.getLogger(C0026a.class.getName());
    }

    public C0026a() {
        this((C0028b) null);
    }

    public C0026a(C0028b c0028b) {
        this.f84b = 1500;
        this.f85c = 5000;
        try {
            this.f83a = SecureRandom.getInstance("SHA1PRNG");
        } catch (NoSuchAlgorithmException e) {
            this.f83a = new SecureRandom();
        }
        this.f86d = c0028b;
    }

    public C0029c m40a(C0032f c0032f) {
        C0029c c0029c = this.f86d == null ? null : this.f86d.get(c0032f);
        if (c0029c != null) {
            return c0029c;
        }
        for (String a : m44a()) {
            try {
                c0029c = m41a(c0032f, a);
                if (c0029c != null && c0029c.m56c() == C0031e.NO_ERROR) {
                    for (C0033g a2 : c0029c.m57d()) {
                        if (a2.m69a(c0032f)) {
                            return c0029c;
                        }
                    }
                    continue;
                }
            } catch (Throwable e) {
                f82e.log(Level.FINE, "IOException in query", e);
            }
        }
        return null;
    }

    public C0029c m41a(C0032f c0032f, String str) {
        return m42a(c0032f, str, 53);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public p000a.p003b.p004a.C0029c m42a(p000a.p003b.p004a.C0032f r10, java.lang.String r11, int r12) {
        /*
        r9 = this;
        r4 = 1;
        r2 = 0;
        r1 = 0;
        r0 = r9.f86d;
        if (r0 != 0) goto L_0x000b;
    L_0x0007:
        r0 = r1;
    L_0x0008:
        if (r0 == 0) goto L_0x0012;
    L_0x000a:
        return r0;
    L_0x000b:
        r0 = r9.f86d;
        r0 = r0.get(r10);
        goto L_0x0008;
    L_0x0012:
        r3 = new a.b.a.c;
        r3.<init>();
        r0 = new p000a.p003b.p004a.C0032f[r4];
        r0[r2] = r10;
        r3.m54a(r0);
        r3.m53a(r4);
        r0 = r9.f83a;
        r0 = r0.nextInt();
        r3.m52a(r0);
        r0 = r3.m55b();
        r4 = new java.net.DatagramSocket;
        r4.<init>();
        r5 = new java.net.DatagramPacket;	 Catch:{ Throwable -> 0x00a6, all -> 0x00bd }
        r6 = r0.length;	 Catch:{ Throwable -> 0x00a6, all -> 0x00bd }
        r7 = java.net.InetAddress.getByName(r11);	 Catch:{ Throwable -> 0x00a6, all -> 0x00bd }
        r5.<init>(r0, r6, r7, r12);	 Catch:{ Throwable -> 0x00a6, all -> 0x00bd }
        r0 = r9.f85c;	 Catch:{ Throwable -> 0x00a6, all -> 0x00bd }
        r4.setSoTimeout(r0);	 Catch:{ Throwable -> 0x00a6, all -> 0x00bd }
        r4.send(r5);	 Catch:{ Throwable -> 0x00a6, all -> 0x00bd }
        r0 = new java.net.DatagramPacket;	 Catch:{ Throwable -> 0x00a6, all -> 0x00bd }
        r5 = r9.f84b;	 Catch:{ Throwable -> 0x00a6, all -> 0x00bd }
        r5 = new byte[r5];	 Catch:{ Throwable -> 0x00a6, all -> 0x00bd }
        r6 = r9.f84b;	 Catch:{ Throwable -> 0x00a6, all -> 0x00bd }
        r0.<init>(r5, r6);	 Catch:{ Throwable -> 0x00a6, all -> 0x00bd }
        r4.receive(r0);	 Catch:{ Throwable -> 0x00a6, all -> 0x00bd }
        r0 = r0.getData();	 Catch:{ Throwable -> 0x00a6, all -> 0x00bd }
        r0 = p000a.p003b.p004a.C0029c.m50a(r0);	 Catch:{ Throwable -> 0x00a6, all -> 0x00bd }
        r5 = r0.m51a();	 Catch:{ Throwable -> 0x00a6, all -> 0x00bd }
        r3 = r3.m51a();	 Catch:{ Throwable -> 0x00a6, all -> 0x00bd }
        if (r5 == r3) goto L_0x0077;
    L_0x0065:
        if (r4 == 0) goto L_0x006c;
    L_0x0067:
        if (r1 == 0) goto L_0x0073;
    L_0x0069:
        r4.close();	 Catch:{ Throwable -> 0x006e }
    L_0x006c:
        r0 = r1;
        goto L_0x000a;
    L_0x006e:
        r0 = move-exception;
        r1.addSuppressed(r0);
        goto L_0x006c;
    L_0x0073:
        r4.close();
        goto L_0x006c;
    L_0x0077:
        r3 = r0.m57d();	 Catch:{ Throwable -> 0x00a6, all -> 0x00bd }
        r5 = r3.length;	 Catch:{ Throwable -> 0x00a6, all -> 0x00bd }
    L_0x007c:
        if (r2 >= r5) goto L_0x008f;
    L_0x007e:
        r6 = r3[r2];	 Catch:{ Throwable -> 0x00a6, all -> 0x00bd }
        r6 = r6.m69a(r10);	 Catch:{ Throwable -> 0x00a6, all -> 0x00bd }
        if (r6 == 0) goto L_0x009e;
    L_0x0086:
        r2 = r9.f86d;	 Catch:{ Throwable -> 0x00a6, all -> 0x00bd }
        if (r2 == 0) goto L_0x008f;
    L_0x008a:
        r2 = r9.f86d;	 Catch:{ Throwable -> 0x00a6, all -> 0x00bd }
        r2.put(r10, r0);	 Catch:{ Throwable -> 0x00a6, all -> 0x00bd }
    L_0x008f:
        if (r4 == 0) goto L_0x000a;
    L_0x0091:
        if (r1 == 0) goto L_0x00a1;
    L_0x0093:
        r4.close();	 Catch:{ Throwable -> 0x0098 }
        goto L_0x000a;
    L_0x0098:
        r2 = move-exception;
        r1.addSuppressed(r2);
        goto L_0x000a;
    L_0x009e:
        r2 = r2 + 1;
        goto L_0x007c;
    L_0x00a1:
        r4.close();
        goto L_0x000a;
    L_0x00a6:
        r0 = move-exception;
        throw r0;	 Catch:{ all -> 0x00a8 }
    L_0x00a8:
        r1 = move-exception;
        r8 = r1;
        r1 = r0;
        r0 = r8;
    L_0x00ac:
        if (r4 == 0) goto L_0x00b3;
    L_0x00ae:
        if (r1 == 0) goto L_0x00b9;
    L_0x00b0:
        r4.close();	 Catch:{ Throwable -> 0x00b4 }
    L_0x00b3:
        throw r0;
    L_0x00b4:
        r2 = move-exception;
        r1.addSuppressed(r2);
        goto L_0x00b3;
    L_0x00b9:
        r4.close();
        goto L_0x00b3;
    L_0x00bd:
        r0 = move-exception;
        goto L_0x00ac;
        */
        throw new UnsupportedOperationException("Method not decompiled: a.b.a.a.a(a.b.a.f, java.lang.String, int):a.b.a.c");
    }

    public C0029c m43a(String str, C0036j c0036j, C0035i c0035i) {
        return m40a(new C0032f(str, c0036j, c0035i));
    }

    public String[] m44a() {
        String[] c = m46c();
        if (c != null) {
            f82e.fine("Got DNS servers via reflection: " + Arrays.toString(c));
            return c;
        }
        c = m45b();
        if (c != null) {
            f82e.fine("Got DNS servers via exec: " + Arrays.toString(c));
            return c;
        }
        f82e.fine("No DNS found? Using fallback [8.8.8.8, [2001:4860:4860::8888]]");
        return new String[]{"8.8.8.8", "[2001:4860:4860::8888]"};
    }

    protected String[] m45b() {
        try {
            LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(Runtime.getRuntime().exec("getprop").getInputStream()));
            HashSet hashSet = new HashSet(6);
            while (true) {
                String readLine = lineNumberReader.readLine();
                if (readLine == null) {
                    break;
                }
                int indexOf = readLine.indexOf("]: [");
                if (indexOf != -1) {
                    String substring = readLine.substring(1, indexOf);
                    readLine = readLine.substring(indexOf + 4, readLine.length() - 1);
                    if (substring.endsWith(".dns") || substring.endsWith(".dns1") || substring.endsWith(".dns2") || substring.endsWith(".dns3") || substring.endsWith(".dns4")) {
                        InetAddress byName = InetAddress.getByName(readLine);
                        if (byName != null) {
                            readLine = byName.getHostAddress();
                            if (!(readLine == null || readLine.length() == 0)) {
                                hashSet.add(readLine);
                            }
                        }
                    }
                }
            }
            if (hashSet.size() > 0) {
                return (String[]) hashSet.toArray(new String[hashSet.size()]);
            }
        } catch (Throwable e) {
            f82e.log(Level.WARNING, "Exception in findDNSByExec", e);
        }
        return null;
    }

    protected String[] m46c() {
        try {
            Method method = Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class});
            ArrayList arrayList = new ArrayList(5);
            int length = new String[]{"net.dns1", "net.dns2", "net.dns3", "net.dns4"}.length;
            for (int i = 0; i < length; i++) {
                String str = (String) method.invoke(null, new Object[]{r5[i]});
                if (!(str == null || str.length() == 0 || arrayList.contains(str))) {
                    InetAddress byName = InetAddress.getByName(str);
                    if (byName != null) {
                        str = byName.getHostAddress();
                        if (!(str == null || str.length() == 0 || arrayList.contains(str))) {
                            arrayList.add(str);
                        }
                    }
                }
            }
            if (arrayList.size() > 0) {
                return (String[]) arrayList.toArray(new String[arrayList.size()]);
            }
        } catch (Throwable e) {
            f82e.log(Level.WARNING, "Exception in findDNSByReflection", e);
        }
        return null;
    }
}
