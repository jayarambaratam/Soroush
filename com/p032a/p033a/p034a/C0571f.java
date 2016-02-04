package com.p032a.p033a.p034a;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* renamed from: com.a.a.a.f */
class C0571f implements Closeable {
    private final InputStream f2373a;
    private final Charset f2374b;
    private byte[] f2375c;
    private int f2376d;
    private int f2377e;

    public C0571f(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null || charset == null) {
            throw new NullPointerException();
        } else if (i < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        } else if (charset.equals(C0573h.f2379a)) {
            this.f2373a = inputStream;
            this.f2374b = charset;
            this.f2375c = new byte[i];
        } else {
            throw new IllegalArgumentException("Unsupported encoding");
        }
    }

    public C0571f(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    private void m4274c() {
        int read = this.f2373a.read(this.f2375c, 0, this.f2375c.length);
        if (read == -1) {
            throw new EOFException();
        }
        this.f2376d = 0;
        this.f2377e = read;
    }

    public String m4275a() {
        String str;
        synchronized (this.f2373a) {
            if (this.f2375c == null) {
                throw new IOException("LineReader is closed");
            }
            int i;
            if (this.f2376d >= this.f2377e) {
                m4274c();
            }
            int i2 = this.f2376d;
            while (i2 != this.f2377e) {
                if (this.f2375c[i2] == (byte) 10) {
                    int i3 = (i2 == this.f2376d || this.f2375c[i2 - 1] != 13) ? i2 : i2 - 1;
                    str = new String(this.f2375c, this.f2376d, i3 - this.f2376d, this.f2374b.name());
                    this.f2376d = i2 + 1;
                } else {
                    i2++;
                }
            }
            ByteArrayOutputStream c0572g = new C0572g(this, (this.f2377e - this.f2376d) + 80);
            loop1:
            while (true) {
                c0572g.write(this.f2375c, this.f2376d, this.f2377e - this.f2376d);
                this.f2377e = -1;
                m4274c();
                i = this.f2376d;
                while (i != this.f2377e) {
                    if (this.f2375c[i] == (byte) 10) {
                        break loop1;
                    }
                    i++;
                }
            }
            if (i != this.f2376d) {
                c0572g.write(this.f2375c, this.f2376d, i - this.f2376d);
            }
            this.f2376d = i + 1;
            str = c0572g.toString();
        }
        return str;
    }

    public boolean m4276b() {
        return this.f2377e == -1;
    }

    public void close() {
        synchronized (this.f2373a) {
            if (this.f2375c != null) {
                this.f2375c = null;
                this.f2373a.close();
            }
        }
    }
}
