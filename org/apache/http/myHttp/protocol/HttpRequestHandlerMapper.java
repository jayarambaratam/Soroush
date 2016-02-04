package org.apache.http.myHttp.protocol;

import org.apache.http.myHttp.HttpRequest;

public interface HttpRequestHandlerMapper {
    HttpRequestHandler lookup(HttpRequest httpRequest);
}
