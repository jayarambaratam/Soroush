package org.apache.http.myHttp.entity;

import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.myHttp.Header;
import org.apache.http.myHttp.HttpEntity;
import org.apache.http.myHttp.annotation.NotThreadSafe;
import org.apache.http.myHttp.util.Args;

@NotThreadSafe
public class HttpEntityWrapper implements HttpEntity {
    protected HttpEntity wrappedEntity;

    public HttpEntityWrapper(HttpEntity httpEntity) {
        this.wrappedEntity = (HttpEntity) Args.notNull(httpEntity, "Wrapped entity");
    }

    @Deprecated
    public void consumeContent() {
        this.wrappedEntity.consumeContent();
    }

    public InputStream getContent() {
        return this.wrappedEntity.getContent();
    }

    public Header getContentEncoding() {
        return this.wrappedEntity.getContentEncoding();
    }

    public long getContentLength() {
        return this.wrappedEntity.getContentLength();
    }

    public Header getContentType() {
        return this.wrappedEntity.getContentType();
    }

    public boolean isChunked() {
        return this.wrappedEntity.isChunked();
    }

    public boolean isRepeatable() {
        return this.wrappedEntity.isRepeatable();
    }

    public boolean isStreaming() {
        return this.wrappedEntity.isStreaming();
    }

    public void writeTo(OutputStream outputStream) {
        this.wrappedEntity.writeTo(outputStream);
    }
}
