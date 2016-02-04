package org.apache.http.myHttp.protocol;

import org.apache.http.myHttp.HttpResponse;
import org.apache.http.myHttp.HttpResponseInterceptor;
import org.apache.http.myHttp.HttpStatus;
import org.apache.http.myHttp.annotation.ThreadSafe;
import org.apache.http.myHttp.util.Args;

@ThreadSafe
public class ResponseDate implements HttpResponseInterceptor {
    private static final HttpDateGenerator DATE_GENERATOR;

    static {
        DATE_GENERATOR = new HttpDateGenerator();
    }

    public void process(HttpResponse httpResponse, HttpContext httpContext) {
        Args.notNull(httpResponse, "HTTP response");
        if (httpResponse.getStatusLine().getStatusCode() >= HttpStatus.SC_OK && !httpResponse.containsHeader(HTTP.DATE_HEADER)) {
            httpResponse.setHeader(HTTP.DATE_HEADER, DATE_GENERATOR.getCurrentDate());
        }
    }
}
