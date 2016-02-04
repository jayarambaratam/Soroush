package org.apache.http.myHttp;

import org.apache.http.myHttp.protocol.HttpContext;

public interface ConnectionReuseStrategy {
    boolean keepAlive(HttpResponse httpResponse, HttpContext httpContext);
}
