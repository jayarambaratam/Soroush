package org.apache.http.myHttp.impl;

import org.apache.http.myHttp.ConnectionReuseStrategy;
import org.apache.http.myHttp.HttpResponse;
import org.apache.http.myHttp.annotation.Immutable;
import org.apache.http.myHttp.protocol.HttpContext;

@Immutable
public class NoConnectionReuseStrategy implements ConnectionReuseStrategy {
    public static final NoConnectionReuseStrategy INSTANCE;

    static {
        INSTANCE = new NoConnectionReuseStrategy();
    }

    public boolean keepAlive(HttpResponse httpResponse, HttpContext httpContext) {
        return false;
    }
}
