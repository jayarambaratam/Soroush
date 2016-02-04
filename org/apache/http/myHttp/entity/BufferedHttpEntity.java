package org.apache.http.myHttp.entity;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.myHttp.HttpEntity;
import org.apache.http.myHttp.annotation.NotThreadSafe;
import org.apache.http.myHttp.util.Args;
import org.apache.http.myHttp.util.EntityUtils;

@NotThreadSafe
public class BufferedHttpEntity extends HttpEntityWrapper {
    private final byte[] buffer;

    public BufferedHttpEntity(HttpEntity httpEntity) {
        super(httpEntity);
        if (!httpEntity.isRepeatable() || httpEntity.getContentLength() < 0) {
            this.buffer = EntityUtils.toByteArray(httpEntity);
        } else {
            this.buffer = null;
        }
    }

    public InputStream getContent() {
        return this.buffer != null ? new ByteArrayInputStream(this.buffer) : super.getContent();
    }

    public long getContentLength() {
        return this.buffer != null ? (long) this.buffer.length : super.getContentLength();
    }

    public boolean isChunked() {
        return this.buffer == null && super.isChunked();
    }

    public boolean isRepeatable() {
        return true;
    }

    public boolean isStreaming() {
        return this.buffer == null && super.isStreaming();
    }

    public void writeTo(OutputStream outputStream) {
        Args.notNull(outputStream, "Output stream");
        if (this.buffer != null) {
            outputStream.write(this.buffer);
        } else {
            super.writeTo(outputStream);
        }
    }
}
