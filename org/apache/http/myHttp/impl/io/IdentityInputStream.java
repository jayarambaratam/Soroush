package org.apache.http.myHttp.impl.io;

import java.io.InputStream;
import org.apache.http.myHttp.annotation.NotThreadSafe;
import org.apache.http.myHttp.io.BufferInfo;
import org.apache.http.myHttp.io.SessionInputBuffer;
import org.apache.http.myHttp.util.Args;

@NotThreadSafe
public class IdentityInputStream extends InputStream {
    private boolean closed;
    private final SessionInputBuffer in;

    public IdentityInputStream(SessionInputBuffer sessionInputBuffer) {
        this.closed = false;
        this.in = (SessionInputBuffer) Args.notNull(sessionInputBuffer, "Session input buffer");
    }

    public int available() {
        return this.in instanceof BufferInfo ? ((BufferInfo) this.in).length() : 0;
    }

    public void close() {
        this.closed = true;
    }

    public int read() {
        return this.closed ? -1 : this.in.read();
    }

    public int read(byte[] bArr, int i, int i2) {
        return this.closed ? -1 : this.in.read(bArr, i, i2);
    }
}
