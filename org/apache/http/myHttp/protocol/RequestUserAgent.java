package org.apache.http.myHttp.protocol;

import org.apache.http.myHttp.HttpRequest;
import org.apache.http.myHttp.HttpRequestInterceptor;
import org.apache.http.myHttp.annotation.Immutable;
import org.apache.http.myHttp.params.CoreProtocolPNames;
import org.apache.http.myHttp.params.HttpParams;
import org.apache.http.myHttp.util.Args;

@Immutable
public class RequestUserAgent implements HttpRequestInterceptor {
    private final String userAgent;

    public RequestUserAgent() {
        this(null);
    }

    public RequestUserAgent(String str) {
        this.userAgent = str;
    }

    public void process(HttpRequest httpRequest, HttpContext httpContext) {
        Args.notNull(httpRequest, "HTTP request");
        if (!httpRequest.containsHeader(HTTP.USER_AGENT)) {
            String str = null;
            HttpParams params = httpRequest.getParams();
            if (params != null) {
                str = (String) params.getParameter(CoreProtocolPNames.USER_AGENT);
            }
            if (str == null) {
                str = this.userAgent;
            }
            if (str != null) {
                httpRequest.addHeader(HTTP.USER_AGENT, str);
            }
        }
    }
}
