package org.apache.http.myHttp.impl.pool;

import java.io.IOException;
import org.apache.http.myHttp.HttpClientConnection;
import org.apache.http.myHttp.HttpHost;
import org.apache.http.myHttp.annotation.ThreadSafe;
import org.apache.http.myHttp.pool.PoolEntry;

@ThreadSafe
public class BasicPoolEntry extends PoolEntry<HttpHost, HttpClientConnection> {
    public BasicPoolEntry(String str, HttpHost httpHost, HttpClientConnection httpClientConnection) {
        super(str, httpHost, httpClientConnection);
    }

    public void close() {
        try {
            ((HttpClientConnection) getConnection()).close();
        } catch (IOException e) {
        }
    }

    public boolean isClosed() {
        return !((HttpClientConnection) getConnection()).isOpen();
    }
}
