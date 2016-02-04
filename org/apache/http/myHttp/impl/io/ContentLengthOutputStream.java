package org.apache.http.myHttp.impl.io;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.http.myHttp.annotation.NotThreadSafe;
import org.apache.http.myHttp.io.SessionOutputBuffer;
import org.apache.http.myHttp.util.Args;

@NotThreadSafe
public class ContentLengthOutputStream extends OutputStream {
    private boolean closed;
    private final long contentLength;
    private final SessionOutputBuffer out;
    private long total;

    public ContentLengthOutputStream(SessionOutputBuffer sessionOutputBuffer, long j) {
        this.total = 0;
        this.closed = false;
        this.out = (SessionOutputBuffer) Args.notNull(sessionOutputBuffer, "Session output buffer");
        this.contentLength = Args.notNegative(j, "Content length");
    }

    public void close() {
        if (!this.closed) {
            this.closed = true;
            this.out.flush();
        }
    }

    public void flush() {
        this.out.flush();
    }

    public void write(int i) {
        if (this.closed) {
            throw new IOException("Attempted write to closed stream.");
        } else if (this.total < this.contentLength) {
            this.out.write(i);
            this.total++;
        }
    }

    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    public void write(byte[] bArr, int i, int i2) {
        if (this.closed) {
            throw new IOException("Attempted write to closed stream.");
        } else if (this.total < this.contentLength) {
            long j = this.contentLength - this.total;
            if (((long) i2) > j) {
                i2 = (int) j;
            }
            this.out.write(bArr, i, i2);
            this.total += (long) i2;
        }
    }
}
