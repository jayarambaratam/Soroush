package org.apache.http.myHttp;

import org.apache.http.myHttp.protocol.HttpContext;

public interface HttpRequestInterceptor {
    void process(HttpRequest httpRequest, HttpContext httpContext);
}
