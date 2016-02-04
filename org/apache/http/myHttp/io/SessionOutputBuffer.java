package org.apache.http.myHttp.io;

import org.apache.http.myHttp.util.CharArrayBuffer;

public interface SessionOutputBuffer {
    void flush();

    HttpTransportMetrics getMetrics();

    void write(int i);

    void write(byte[] bArr);

    void write(byte[] bArr, int i, int i2);

    void writeLine(String str);

    void writeLine(CharArrayBuffer charArrayBuffer);
}
