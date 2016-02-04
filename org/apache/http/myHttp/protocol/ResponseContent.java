package org.apache.http.myHttp.protocol;

import org.apache.http.myHttp.HttpEntity;
import org.apache.http.myHttp.HttpResponse;
import org.apache.http.myHttp.HttpResponseInterceptor;
import org.apache.http.myHttp.HttpStatus;
import org.apache.http.myHttp.HttpVersion;
import org.apache.http.myHttp.ProtocolException;
import org.apache.http.myHttp.ProtocolVersion;
import org.apache.http.myHttp.annotation.Immutable;
import org.apache.http.myHttp.util.Args;

@Immutable
public class ResponseContent implements HttpResponseInterceptor {
    private final boolean overwrite;

    public ResponseContent() {
        this(false);
    }

    public ResponseContent(boolean z) {
        this.overwrite = z;
    }

    public void process(HttpResponse httpResponse, HttpContext httpContext) {
        Args.notNull(httpResponse, "HTTP response");
        if (this.overwrite) {
            httpResponse.removeHeaders(HTTP.TRANSFER_ENCODING);
            httpResponse.removeHeaders(HTTP.CONTENT_LEN);
        } else if (httpResponse.containsHeader(HTTP.TRANSFER_ENCODING)) {
            throw new ProtocolException("Transfer-encoding header already present");
        } else if (httpResponse.containsHeader(HTTP.CONTENT_LEN)) {
            throw new ProtocolException("Content-Length header already present");
        }
        ProtocolVersion protocolVersion = httpResponse.getStatusLine().getProtocolVersion();
        HttpEntity entity = httpResponse.getEntity();
        if (entity != null) {
            long contentLength = entity.getContentLength();
            if (entity.isChunked() && !protocolVersion.lessEquals(HttpVersion.HTTP_1_0)) {
                httpResponse.addHeader(HTTP.TRANSFER_ENCODING, HTTP.CHUNK_CODING);
            } else if (contentLength >= 0) {
                httpResponse.addHeader(HTTP.CONTENT_LEN, Long.toString(entity.getContentLength()));
            }
            if (!(entity.getContentType() == null || httpResponse.containsHeader(HTTP.CONTENT_TYPE))) {
                httpResponse.addHeader(entity.getContentType());
            }
            if (entity.getContentEncoding() != null && !httpResponse.containsHeader(HTTP.CONTENT_ENCODING)) {
                httpResponse.addHeader(entity.getContentEncoding());
                return;
            }
            return;
        }
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        if (statusCode != HttpStatus.SC_NO_CONTENT && statusCode != HttpStatus.SC_NOT_MODIFIED && statusCode != HttpStatus.SC_RESET_CONTENT) {
            httpResponse.addHeader(HTTP.CONTENT_LEN, "0");
        }
    }
}
