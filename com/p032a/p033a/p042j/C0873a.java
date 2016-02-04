package com.p032a.p033a.p042j;

import android.util.Log;
import java.util.Queue;

/* renamed from: com.a.a.j.a */
public final class C0873a {
    private static final C0873a f3055b;
    private final Queue<byte[]> f3056a;

    static {
        f3055b = new C0873a();
    }

    private C0873a() {
        this.f3056a = C0879h.m5306a(0);
    }

    public static C0873a m5286a() {
        return f3055b;
    }

    public boolean m5287a(byte[] bArr) {
        boolean z = false;
        if (bArr.length == 65536) {
            synchronized (this.f3056a) {
                if (this.f3056a.size() < 32) {
                    z = true;
                    this.f3056a.offer(bArr);
                }
            }
        }
        return z;
    }

    public byte[] m5288b() {
        byte[] bArr;
        synchronized (this.f3056a) {
            bArr = (byte[]) this.f3056a.poll();
        }
        if (bArr == null) {
            bArr = new byte[65536];
            if (Log.isLoggable("ByteArrayPool", 3)) {
                Log.d("ByteArrayPool", "Created temp bytes");
            }
        }
        return bArr;
    }
}
