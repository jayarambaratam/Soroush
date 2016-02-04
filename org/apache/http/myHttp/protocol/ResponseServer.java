package org.apache.http.myHttp.protocol;

import org.apache.http.myHttp.HttpResponse;
import org.apache.http.myHttp.HttpResponseInterceptor;
import org.apache.http.myHttp.annotation.Immutable;
import org.apache.http.myHttp.util.Args;

@Immutable
public class ResponseServer implements HttpResponseInterceptor {
    private final String originServer;

    public ResponseServer() {
        this(null);
    }

    public ResponseServer(String str) {
        this.originServer = str;
    }

    public void process(HttpResponse httpResponse, HttpContext httpContext) {
        Args.notNull(httpResponse, "HTTP response");
        if (!httpResponse.containsHeader(HTTP.SERVER_HEADER) && this.originServer != null) {
            httpResponse.addHeader(HTTP.SERVER_HEADER, this.originServer);
        }
    }
}
