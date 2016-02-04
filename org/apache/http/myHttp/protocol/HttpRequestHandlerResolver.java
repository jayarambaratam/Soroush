package org.apache.http.myHttp.protocol;

@Deprecated
public interface HttpRequestHandlerResolver {
    HttpRequestHandler lookup(String str);
}
