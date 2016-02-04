package org.apache.http.myHttp;

import org.apache.http.myHttp.protocol.HttpContext;

public interface HttpResponseInterceptor {
    void process(HttpResponse httpResponse, HttpContext httpContext);
}
