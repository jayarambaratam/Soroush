package org.apache.http.myHttp.impl.io;

import java.io.IOException;
import java.io.InputStream;
import org.apache.http.myHttp.ConnectionClosedException;
import org.apache.http.myHttp.annotation.NotThreadSafe;
import org.apache.http.myHttp.io.BufferInfo;
import org.apache.http.myHttp.io.SessionInputBuffer;
import org.apache.http.myHttp.util.Args;

@NotThreadSafe
public class ContentLengthInputStream extends InputStream {
    private static final int BUFFER_SIZE = 2048;
    private boolean closed;
    private final long contentLength;
    private SessionInputBuffer in;
    private long pos;

    public ContentLengthInputStream(SessionInputBuffer sessionInputBuffer, long j) {
        this.pos = 0;
        this.closed = false;
        this.in = null;
        this.in = (SessionInputBuffer) Args.notNull(sessionInputBuffer, "Session input buffer");
        this.contentLength = Args.notNegative(j, "Content length");
    }

    public int available() {
        return this.in instanceof BufferInfo ? Math.min(((BufferInfo) this.in).length(), (int) (this.contentLength - this.pos)) : 0;
    }

    public void close() {
        if (!this.closed) {
            try {
                if (this.pos < this.contentLength) {
                    do {
                    } while (read(new byte[BUFFER_SIZE]) >= 0);
                }
                this.closed = true;
            } catch (Throwable th) {
                this.closed = true;
            }
        }
    }

    public int read() {
        if (this.closed) {
            throw new IOException("Attempted read from closed stream.");
        } else if (this.pos >= this.contentLength) {
            return -1;
        } else {
            int read = this.in.read();
            if (read != -1) {
                this.pos++;
            } else if (this.pos < this.contentLength) {
                throw new ConnectionClosedException("Premature end of Content-Length delimited message body (expected: " + this.contentLength + "; received: " + this.pos);
            }
            return read;
        }
    }

    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) {
        if (this.closed) {
            throw new IOException("Attempted read from closed stream.");
        } else if (this.pos >= this.contentLength) {
            return -1;
        } else {
            if (this.pos + ((long) i2) > this.contentLength) {
                i2 = (int) (this.contentLength - this.pos);
            }
            int read = this.in.read(bArr, i, i2);
            if (read != -1 || this.pos >= this.contentLength) {
                if (read > 0) {
                    this.pos += (long) read;
                }
                return read;
            }
            throw new ConnectionClosedException("Premature end of Content-Length delimited message body (expected: " + this.contentLength + "; received: " + this.pos);
        }
    }

    public long skip(long j) {
        if (j <= 0) {
            return 0;
        }
        byte[] bArr = new byte[BUFFER_SIZE];
        long min = Math.min(j, this.contentLength - this.pos);
        long j2 = 0;
        while (min > 0) {
            int read = read(bArr, 0, (int) Math.min(2048, min));
            if (read == -1) {
                break;
            }
            j2 += (long) read;
            min -= (long) read;
        }
        return j2;
    }
}
