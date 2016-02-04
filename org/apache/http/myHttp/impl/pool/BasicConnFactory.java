package org.apache.http.myHttp.impl.pool;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.myHttp.HttpClientConnection;
import org.apache.http.myHttp.HttpConnectionFactory;
import org.apache.http.myHttp.HttpHost;
import org.apache.http.myHttp.annotation.Immutable;
import org.apache.http.myHttp.config.ConnectionConfig;
import org.apache.http.myHttp.config.SocketConfig;
import org.apache.http.myHttp.impl.DefaultBHttpClientConnection;
import org.apache.http.myHttp.impl.DefaultBHttpClientConnectionFactory;
import org.apache.http.myHttp.params.CoreConnectionPNames;
import org.apache.http.myHttp.params.HttpParamConfig;
import org.apache.http.myHttp.params.HttpParams;
import org.apache.http.myHttp.pool.ConnFactory;
import org.apache.http.myHttp.util.Args;

@Immutable
public class BasicConnFactory implements ConnFactory<HttpHost, HttpClientConnection> {
    private final HttpConnectionFactory<? extends HttpClientConnection> connFactory;
    private final int connectTimeout;
    private final SocketFactory plainfactory;
    private final SocketConfig sconfig;
    private final SSLSocketFactory sslfactory;

    public BasicConnFactory() {
        this(null, null, 0, SocketConfig.DEFAULT, ConnectionConfig.DEFAULT);
    }

    public BasicConnFactory(int i, SocketConfig socketConfig, ConnectionConfig connectionConfig) {
        this(null, null, i, socketConfig, connectionConfig);
    }

    public BasicConnFactory(SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, int i, SocketConfig socketConfig, ConnectionConfig connectionConfig) {
        this.plainfactory = socketFactory;
        this.sslfactory = sSLSocketFactory;
        this.connectTimeout = i;
        if (socketConfig == null) {
            socketConfig = SocketConfig.DEFAULT;
        }
        this.sconfig = socketConfig;
        if (connectionConfig == null) {
            connectionConfig = ConnectionConfig.DEFAULT;
        }
        this.connFactory = new DefaultBHttpClientConnectionFactory(connectionConfig);
    }

    @Deprecated
    public BasicConnFactory(SSLSocketFactory sSLSocketFactory, HttpParams httpParams) {
        Args.notNull(httpParams, "HTTP params");
        this.plainfactory = null;
        this.sslfactory = sSLSocketFactory;
        this.connectTimeout = httpParams.getIntParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 0);
        this.sconfig = HttpParamConfig.getSocketConfig(httpParams);
        this.connFactory = new DefaultBHttpClientConnectionFactory(HttpParamConfig.getConnectionConfig(httpParams));
    }

    public BasicConnFactory(SocketConfig socketConfig, ConnectionConfig connectionConfig) {
        this(null, null, 0, socketConfig, connectionConfig);
    }

    @Deprecated
    public BasicConnFactory(HttpParams httpParams) {
        this(null, httpParams);
    }

    @Deprecated
    protected HttpClientConnection create(Socket socket, HttpParams httpParams) {
        HttpClientConnection defaultBHttpClientConnection = new DefaultBHttpClientConnection(httpParams.getIntParameter(CoreConnectionPNames.SOCKET_BUFFER_SIZE, 8192));
        defaultBHttpClientConnection.bind(socket);
        return defaultBHttpClientConnection;
    }

    public HttpClientConnection create(HttpHost httpHost) {
        Socket createSocket;
        String schemeName = httpHost.getSchemeName();
        Socket socket = null;
        if (HttpHost.DEFAULT_SCHEME_NAME.equalsIgnoreCase(schemeName)) {
            socket = this.plainfactory != null ? this.plainfactory.createSocket() : new Socket();
        }
        if ("https".equalsIgnoreCase(schemeName)) {
            createSocket = (this.sslfactory != null ? this.sslfactory : SSLSocketFactory.getDefault()).createSocket();
        } else {
            createSocket = socket;
        }
        if (createSocket == null) {
            throw new IOException(schemeName + " scheme is not supported");
        }
        schemeName = httpHost.getHostName();
        int port = httpHost.getPort();
        if (port == -1) {
            if (httpHost.getSchemeName().equalsIgnoreCase(HttpHost.DEFAULT_SCHEME_NAME)) {
                port = 80;
            } else if (httpHost.getSchemeName().equalsIgnoreCase("https")) {
                port = 443;
            }
        }
        createSocket.setSoTimeout(this.sconfig.getSoTimeout());
        createSocket.connect(new InetSocketAddress(schemeName, port), this.connectTimeout);
        createSocket.setTcpNoDelay(this.sconfig.isTcpNoDelay());
        int soLinger = this.sconfig.getSoLinger();
        if (soLinger >= 0) {
            createSocket.setSoLinger(soLinger > 0, soLinger);
        }
        createSocket.setKeepAlive(this.sconfig.isSoKeepAlive());
        return (HttpClientConnection) this.connFactory.createConnection(createSocket);
    }
}
