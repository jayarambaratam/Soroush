package com.p032a.p033a.p042j;

import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

/* renamed from: com.a.a.j.c */
public class C0875c extends InputStream {
    private static final Queue<C0875c> f3059a;
    private InputStream f3060b;
    private IOException f3061c;

    static {
        f3059a = C0879h.m5306a(0);
    }

    C0875c() {
    }

    public static C0875c m5291a(InputStream inputStream) {
        C0875c c0875c;
        synchronized (f3059a) {
            c0875c = (C0875c) f3059a.poll();
        }
        if (c0875c == null) {
            c0875c = new C0875c();
        }
        c0875c.m5294b(inputStream);
        return c0875c;
    }

    public IOException m5292a() {
        return this.f3061c;
    }

    public int available() {
        return this.f3060b.available();
    }

    public void m5293b() {
        this.f3061c = null;
        this.f3060b = null;
        synchronized (f3059a) {
            f3059a.offer(this);
        }
    }

    void m5294b(InputStream inputStream) {
        this.f3060b = inputStream;
    }

    public void close() {
        this.f3060b.close();
    }

    public void mark(int i) {
        this.f3060b.mark(i);
    }

    public boolean markSupported() {
        return this.f3060b.markSupported();
    }

    public int read() {
        try {
            return this.f3060b.read();
        } catch (IOException e) {
            this.f3061c = e;
            return -1;
        }
    }

    public int read(byte[] bArr) {
        try {
            return this.f3060b.read(bArr);
        } catch (IOException e) {
            this.f3061c = e;
            return -1;
        }
    }

    public int read(byte[] bArr, int i, int i2) {
        try {
            return this.f3060b.read(bArr, i, i2);
        } catch (IOException e) {
            this.f3061c = e;
            return -1;
        }
    }

    public synchronized void reset() {
        this.f3060b.reset();
    }

    public long skip(long j) {
        try {
            return this.f3060b.skip(j);
        } catch (IOException e) {
            this.f3061c = e;
            return 0;
        }
    }
}
