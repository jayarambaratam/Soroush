package org.apache.http.myHttp.protocol;

import org.apache.http.myHttp.HttpEntity;
import org.apache.http.myHttp.HttpEntityEnclosingRequest;
import org.apache.http.myHttp.HttpRequest;
import org.apache.http.myHttp.HttpRequestInterceptor;
import org.apache.http.myHttp.HttpVersion;
import org.apache.http.myHttp.ProtocolException;
import org.apache.http.myHttp.ProtocolVersion;
import org.apache.http.myHttp.annotation.Immutable;
import org.apache.http.myHttp.util.Args;

@Immutable
public class RequestContent implements HttpRequestInterceptor {
    private final boolean overwrite;

    public RequestContent() {
        this(false);
    }

    public RequestContent(boolean z) {
        this.overwrite = z;
    }

    public void process(HttpRequest httpRequest, HttpContext httpContext) {
        Args.notNull(httpRequest, "HTTP request");
        if (httpRequest instanceof HttpEntityEnclosingRequest) {
            if (this.overwrite) {
                httpRequest.removeHeaders(HTTP.TRANSFER_ENCODING);
                httpRequest.removeHeaders(HTTP.CONTENT_LEN);
            } else if (httpRequest.containsHeader(HTTP.TRANSFER_ENCODING)) {
                throw new ProtocolException("Transfer-encoding header already present");
            } else if (httpRequest.containsHeader(HTTP.CONTENT_LEN)) {
                throw new ProtocolException("Content-Length header already present");
            }
            ProtocolVersion protocolVersion = httpRequest.getRequestLine().getProtocolVersion();
            HttpEntity entity = ((HttpEntityEnclosingRequest) httpRequest).getEntity();
            if (entity == null) {
                httpRequest.addHeader(HTTP.CONTENT_LEN, "0");
                return;
            }
            if (!entity.isChunked() && entity.getContentLength() >= 0) {
                httpRequest.addHeader(HTTP.CONTENT_LEN, Long.toString(entity.getContentLength()));
            } else if (protocolVersion.lessEquals(HttpVersion.HTTP_1_0)) {
                throw new ProtocolException("Chunked transfer encoding not allowed for " + protocolVersion);
            } else {
                httpRequest.addHeader(HTTP.TRANSFER_ENCODING, HTTP.CHUNK_CODING);
            }
            if (!(entity.getContentType() == null || httpRequest.containsHeader(HTTP.CONTENT_TYPE))) {
                httpRequest.addHeader(entity.getContentType());
            }
            if (entity.getContentEncoding() != null && !httpRequest.containsHeader(HTTP.CONTENT_ENCODING)) {
                httpRequest.addHeader(entity.getContentEncoding());
            }
        }
    }
}
