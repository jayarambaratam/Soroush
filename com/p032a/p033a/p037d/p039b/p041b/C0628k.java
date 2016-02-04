package com.p032a.p033a.p037d.p039b.p041b;

import android.util.Log;
import com.p032a.p033a.p034a.C0566a;
import com.p032a.p033a.p034a.C0568c;
import com.p032a.p033a.p034a.C0570e;
import com.p032a.p033a.p037d.C0667c;
import java.io.File;

/* renamed from: com.a.a.d.b.b.k */
public class C0628k implements C0618a {
    private static C0628k f2591a;
    private final C0622e f2592b;
    private final C0638t f2593c;
    private final File f2594d;
    private final int f2595e;
    private C0566a f2596f;

    static {
        f2591a = null;
    }

    protected C0628k(File file, int i) {
        this.f2592b = new C0622e();
        this.f2594d = file;
        this.f2595e = i;
        this.f2593c = new C0638t();
    }

    private synchronized C0566a m4590a() {
        if (this.f2596f == null) {
            this.f2596f = C0566a.m4228a(this.f2594d, 1, 1, (long) this.f2595e);
        }
        return this.f2596f;
    }

    public static synchronized C0618a m4591a(File file, int i) {
        C0618a c0618a;
        synchronized (C0628k.class) {
            if (f2591a == null) {
                f2591a = new C0628k(file, i);
            }
            c0618a = f2591a;
        }
        return c0618a;
    }

    public File m4592a(C0667c c0667c) {
        File file = null;
        try {
            C0570e a = m4590a().m4247a(this.f2593c.m4628a(c0667c));
            if (a != null) {
                file = a.m4272a(0);
            }
        } catch (Throwable e) {
            if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", e);
            }
        }
        return file;
    }

    public void m4593a(C0667c c0667c, C0620c c0620c) {
        C0568c b;
        String a = this.f2593c.m4628a(c0667c);
        this.f2592b.m4584a(c0667c);
        try {
            b = m4590a().m4249b(a);
            if (b != null) {
                if (c0620c.m4580a(b.m4254a(0))) {
                    b.m4255a();
                }
                b.m4257c();
            }
            this.f2592b.m4585b(c0667c);
        } catch (Throwable e) {
            try {
                if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                    Log.w("DiskLruCacheWrapper", "Unable to put to disk cache", e);
                }
                this.f2592b.m4585b(c0667c);
            } catch (Throwable th) {
                this.f2592b.m4585b(c0667c);
            }
        } catch (Throwable th2) {
            b.m4257c();
        }
    }

    public void m4594b(C0667c c0667c) {
        try {
            m4590a().m4250c(this.f2593c.m4628a(c0667c));
        } catch (Throwable e) {
            if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                Log.w("DiskLruCacheWrapper", "Unable to delete from disk cache", e);
            }
        }
    }
}
