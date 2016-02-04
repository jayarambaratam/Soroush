package org.apache.http.myHttp.impl;

import org.apache.http.myHttp.HttpRequest;
import org.apache.http.myHttp.HttpRequestFactory;
import org.apache.http.myHttp.MethodNotSupportedException;
import org.apache.http.myHttp.RequestLine;
import org.apache.http.myHttp.annotation.Immutable;
import org.apache.http.myHttp.message.BasicHttpEntityEnclosingRequest;
import org.apache.http.myHttp.message.BasicHttpRequest;
import org.apache.http.myHttp.util.Args;

@Immutable
public class DefaultHttpRequestFactory implements HttpRequestFactory {
    public static final DefaultHttpRequestFactory INSTANCE;
    private static final String[] RFC2616_COMMON_METHODS;
    private static final String[] RFC2616_ENTITY_ENC_METHODS;
    private static final String[] RFC2616_SPECIAL_METHODS;

    static {
        INSTANCE = new DefaultHttpRequestFactory();
        RFC2616_COMMON_METHODS = new String[]{"GET"};
        RFC2616_ENTITY_ENC_METHODS = new String[]{"POST", "PUT"};
        RFC2616_SPECIAL_METHODS = new String[]{"HEAD", "OPTIONS", "DELETE", "TRACE", "CONNECT"};
    }

    private static boolean isOneOf(String[] strArr, String str) {
        for (String equalsIgnoreCase : strArr) {
            if (equalsIgnoreCase.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public HttpRequest newHttpRequest(String str, String str2) {
        if (isOneOf(RFC2616_COMMON_METHODS, str)) {
            return new BasicHttpRequest(str, str2);
        }
        if (isOneOf(RFC2616_ENTITY_ENC_METHODS, str)) {
            return new BasicHttpEntityEnclosingRequest(str, str2);
        }
        if (isOneOf(RFC2616_SPECIAL_METHODS, str)) {
            return new BasicHttpRequest(str, str2);
        }
        throw new MethodNotSupportedException(str + " method not supported");
    }

    public HttpRequest newHttpRequest(RequestLine requestLine) {
        Args.notNull(requestLine, "Request line");
        String method = requestLine.getMethod();
        if (isOneOf(RFC2616_COMMON_METHODS, method)) {
            return new BasicHttpRequest(requestLine);
        }
        if (isOneOf(RFC2616_ENTITY_ENC_METHODS, method)) {
            return new BasicHttpEntityEnclosingRequest(requestLine);
        }
        if (isOneOf(RFC2616_SPECIAL_METHODS, method)) {
            return new BasicHttpRequest(requestLine);
        }
        throw new MethodNotSupportedException(method + " method not supported");
    }
}
