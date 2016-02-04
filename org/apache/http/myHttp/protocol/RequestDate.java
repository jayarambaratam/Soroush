package org.apache.http.myHttp.protocol;

import org.apache.http.myHttp.HttpEntityEnclosingRequest;
import org.apache.http.myHttp.HttpRequest;
import org.apache.http.myHttp.HttpRequestInterceptor;
import org.apache.http.myHttp.annotation.ThreadSafe;
import org.apache.http.myHttp.util.Args;

@ThreadSafe
public class RequestDate implements HttpRequestInterceptor {
    private static final HttpDateGenerator DATE_GENERATOR;

    static {
        DATE_GENERATOR = new HttpDateGenerator();
    }

    public void process(HttpRequest httpRequest, HttpContext httpContext) {
        Args.notNull(httpRequest, "HTTP request");
        if ((httpRequest instanceof HttpEntityEnclosingRequest) && !httpRequest.containsHeader(HTTP.DATE_HEADER)) {
            httpRequest.setHeader(HTTP.DATE_HEADER, DATE_GENERATOR.getCurrentDate());
        }
    }
}
