package org.apache.http.myHttp;

public interface HttpServerConnection extends HttpConnection {
    void flush();

    void receiveRequestEntity(HttpEntityEnclosingRequest httpEntityEnclosingRequest);

    HttpRequest receiveRequestHeader();

    void sendResponseEntity(HttpResponse httpResponse);

    void sendResponseHeader(HttpResponse httpResponse);
}
