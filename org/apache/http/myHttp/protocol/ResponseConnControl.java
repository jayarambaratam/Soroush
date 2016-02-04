package org.apache.http.myHttp.protocol;

import org.apache.http.myHttp.Header;
import org.apache.http.myHttp.HttpEntity;
import org.apache.http.myHttp.HttpRequest;
import org.apache.http.myHttp.HttpResponse;
import org.apache.http.myHttp.HttpResponseInterceptor;
import org.apache.http.myHttp.HttpStatus;
import org.apache.http.myHttp.HttpVersion;
import org.apache.http.myHttp.ProtocolVersion;
import org.apache.http.myHttp.annotation.Immutable;
import org.apache.http.myHttp.util.Args;

@Immutable
public class ResponseConnControl implements HttpResponseInterceptor {
    public void process(HttpResponse httpResponse, HttpContext httpContext) {
        Args.notNull(httpResponse, "HTTP response");
        HttpCoreContext adapt = HttpCoreContext.adapt(httpContext);
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        if (statusCode == HttpStatus.SC_BAD_REQUEST || statusCode == HttpStatus.SC_REQUEST_TIMEOUT || statusCode == HttpStatus.SC_LENGTH_REQUIRED || statusCode == HttpStatus.SC_REQUEST_TOO_LONG || statusCode == HttpStatus.SC_REQUEST_URI_TOO_LONG || statusCode == HttpStatus.SC_SERVICE_UNAVAILABLE || statusCode == HttpStatus.SC_NOT_IMPLEMENTED) {
            httpResponse.setHeader(HTTP.CONN_DIRECTIVE, HTTP.CONN_CLOSE);
            return;
        }
        Header firstHeader = httpResponse.getFirstHeader(HTTP.CONN_DIRECTIVE);
        if (firstHeader == null || !HTTP.CONN_CLOSE.equalsIgnoreCase(firstHeader.getValue())) {
            HttpEntity entity = httpResponse.getEntity();
            if (entity != null) {
                ProtocolVersion protocolVersion = httpResponse.getStatusLine().getProtocolVersion();
                if (entity.getContentLength() < 0 && (!entity.isChunked() || protocolVersion.lessEquals(HttpVersion.HTTP_1_0))) {
                    httpResponse.setHeader(HTTP.CONN_DIRECTIVE, HTTP.CONN_CLOSE);
                    return;
                }
            }
            HttpRequest request = adapt.getRequest();
            if (request != null) {
                firstHeader = request.getFirstHeader(HTTP.CONN_DIRECTIVE);
                if (firstHeader != null) {
                    httpResponse.setHeader(HTTP.CONN_DIRECTIVE, firstHeader.getValue());
                } else if (request.getProtocolVersion().lessEquals(HttpVersion.HTTP_1_0)) {
                    httpResponse.setHeader(HTTP.CONN_DIRECTIVE, HTTP.CONN_CLOSE);
                }
            }
        }
    }
}
