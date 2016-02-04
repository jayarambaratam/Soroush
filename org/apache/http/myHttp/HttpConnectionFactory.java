package org.apache.http.myHttp;

import java.net.Socket;

public interface HttpConnectionFactory<T extends HttpConnection> {
    T createConnection(Socket socket);
}
