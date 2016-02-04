package org.apache.http.myHttp.entity.mime;

import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.myHttp.Header;
import org.apache.http.myHttp.HttpEntity;
import org.apache.http.myHttp.message.BasicHeader;
import org.apache.http.myHttp.protocol.HTTP;

class MultipartFormEntity implements HttpEntity {
    private final long contentLength;
    private final Header contentType;
    private final AbstractMultipartForm multipart;

    MultipartFormEntity(AbstractMultipartForm abstractMultipartForm, String str, long j) {
        this.multipart = abstractMultipartForm;
        this.contentType = new BasicHeader(HTTP.CONTENT_TYPE, str);
        this.contentLength = j;
    }

    public void consumeContent() {
        if (isStreaming()) {
            throw new UnsupportedOperationException("Streaming entity does not implement #consumeContent()");
        }
    }

    public InputStream getContent() {
        throw new UnsupportedOperationException("Multipart form entity does not implement #getContent()");
    }

    public Header getContentEncoding() {
        return null;
    }

    public long getContentLength() {
        return this.contentLength;
    }

    public Header getContentType() {
        return this.contentType;
    }

    AbstractMultipartForm getMultipart() {
        return this.multipart;
    }

    public boolean isChunked() {
        return !isRepeatable();
    }

    public boolean isRepeatable() {
        return this.contentLength != -1;
    }

    public boolean isStreaming() {
        return !isRepeatable();
    }

    public void writeTo(OutputStream outputStream) {
        this.multipart.writeTo(outputStream);
    }
}
