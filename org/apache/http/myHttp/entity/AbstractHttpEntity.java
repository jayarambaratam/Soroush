package org.apache.http.myHttp.entity;

import org.apache.http.myHttp.Header;
import org.apache.http.myHttp.HttpEntity;
import org.apache.http.myHttp.annotation.NotThreadSafe;
import org.apache.http.myHttp.message.BasicHeader;
import org.apache.http.myHttp.protocol.HTTP;

@NotThreadSafe
public abstract class AbstractHttpEntity implements HttpEntity {
    protected static final int OUTPUT_BUFFER_SIZE = 4096;
    protected boolean chunked;
    protected Header contentEncoding;
    protected Header contentType;

    protected AbstractHttpEntity() {
    }

    @Deprecated
    public void consumeContent() {
    }

    public Header getContentEncoding() {
        return this.contentEncoding;
    }

    public Header getContentType() {
        return this.contentType;
    }

    public boolean isChunked() {
        return this.chunked;
    }

    public void setChunked(boolean z) {
        this.chunked = z;
    }

    public void setContentEncoding(String str) {
        Header header = null;
        if (str != null) {
            header = new BasicHeader(HTTP.CONTENT_ENCODING, str);
        }
        setContentEncoding(header);
    }

    public void setContentEncoding(Header header) {
        this.contentEncoding = header;
    }

    public void setContentType(String str) {
        Header header = null;
        if (str != null) {
            header = new BasicHeader(HTTP.CONTENT_TYPE, str);
        }
        setContentType(header);
    }

    public void setContentType(Header header) {
        this.contentType = header;
    }
}
