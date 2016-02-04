package org.apache.http.myHttp;

import java.io.IOException;

public class ConnectionClosedException extends IOException {
    private static final long serialVersionUID = 617550366255636674L;

    public ConnectionClosedException(String str) {
        super(str);
    }
}
