package org.apache.http.myHttp.protocol;

import org.apache.http.myHttp.HttpRequest;
import org.apache.http.myHttp.HttpResponse;

public interface HttpRequestHandler {
    void handle(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext);
}
