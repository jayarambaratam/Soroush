package org.apache.http.myHttp;

public interface HttpRequest extends HttpMessage {
    RequestLine getRequestLine();
}
