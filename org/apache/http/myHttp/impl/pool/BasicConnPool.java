package org.apache.http.myHttp.impl.pool;

import java.util.concurrent.atomic.AtomicLong;
import org.apache.http.myHttp.HttpClientConnection;
import org.apache.http.myHttp.HttpHost;
import org.apache.http.myHttp.annotation.ThreadSafe;
import org.apache.http.myHttp.config.ConnectionConfig;
import org.apache.http.myHttp.config.SocketConfig;
import org.apache.http.myHttp.params.HttpParams;
import org.apache.http.myHttp.pool.AbstractConnPool;
import org.apache.http.myHttp.pool.ConnFactory;

@ThreadSafe
public class BasicConnPool extends AbstractConnPool<HttpHost, HttpClientConnection, BasicPoolEntry> {
    private static final AtomicLong COUNTER;

    static {
        COUNTER = new AtomicLong();
    }

    public BasicConnPool() {
        super(new BasicConnFactory(SocketConfig.DEFAULT, ConnectionConfig.DEFAULT), 2, 20);
    }

    public BasicConnPool(SocketConfig socketConfig, ConnectionConfig connectionConfig) {
        super(new BasicConnFactory(socketConfig, connectionConfig), 2, 20);
    }

    @Deprecated
    public BasicConnPool(HttpParams httpParams) {
        super(new BasicConnFactory(httpParams), 2, 20);
    }

    public BasicConnPool(ConnFactory<HttpHost, HttpClientConnection> connFactory) {
        super(connFactory, 2, 20);
    }

    protected BasicPoolEntry createEntry(HttpHost httpHost, HttpClientConnection httpClientConnection) {
        return new BasicPoolEntry(Long.toString(COUNTER.getAndIncrement()), httpHost, httpClientConnection);
    }
}
