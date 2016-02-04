package org.apache.http.myHttp.impl;

import android.support.v7.widget.RecyclerView.ItemAnimator;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import org.apache.http.myHttp.Header;
import org.apache.http.myHttp.HttpConnection;
import org.apache.http.myHttp.HttpConnectionMetrics;
import org.apache.http.myHttp.HttpEntity;
import org.apache.http.myHttp.HttpInetConnection;
import org.apache.http.myHttp.HttpMessage;
import org.apache.http.myHttp.annotation.NotThreadSafe;
import org.apache.http.myHttp.config.MessageConstraints;
import org.apache.http.myHttp.entity.BasicHttpEntity;
import org.apache.http.myHttp.entity.ContentLengthStrategy;
import org.apache.http.myHttp.impl.entity.LaxContentLengthStrategy;
import org.apache.http.myHttp.impl.entity.StrictContentLengthStrategy;
import org.apache.http.myHttp.impl.io.ChunkedInputStream;
import org.apache.http.myHttp.impl.io.ChunkedOutputStream;
import org.apache.http.myHttp.impl.io.ContentLengthInputStream;
import org.apache.http.myHttp.impl.io.ContentLengthOutputStream;
import org.apache.http.myHttp.impl.io.HttpTransportMetricsImpl;
import org.apache.http.myHttp.impl.io.IdentityInputStream;
import org.apache.http.myHttp.impl.io.IdentityOutputStream;
import org.apache.http.myHttp.impl.io.SessionInputBufferImpl;
import org.apache.http.myHttp.impl.io.SessionOutputBufferImpl;
import org.apache.http.myHttp.io.HttpTransportMetrics;
import org.apache.http.myHttp.io.SessionInputBuffer;
import org.apache.http.myHttp.io.SessionOutputBuffer;
import org.apache.http.myHttp.protocol.HTTP;
import org.apache.http.myHttp.util.Args;
import org.apache.http.myHttp.util.Asserts;
import org.apache.http.myHttp.util.NetUtils;

@NotThreadSafe
public class BHttpConnectionBase implements HttpConnection, HttpInetConnection {
    private final HttpConnectionMetricsImpl connMetrics;
    private final SessionInputBufferImpl inbuffer;
    private final ContentLengthStrategy incomingContentStrategy;
    private volatile boolean open;
    private final SessionOutputBufferImpl outbuffer;
    private final ContentLengthStrategy outgoingContentStrategy;
    private volatile Socket socket;

    protected BHttpConnectionBase(int i, int i2, CharsetDecoder charsetDecoder, CharsetEncoder charsetEncoder, MessageConstraints messageConstraints, ContentLengthStrategy contentLengthStrategy, ContentLengthStrategy contentLengthStrategy2) {
        Args.positive(i, "Buffer size");
        HttpTransportMetrics httpTransportMetricsImpl = new HttpTransportMetricsImpl();
        HttpTransportMetrics httpTransportMetricsImpl2 = new HttpTransportMetricsImpl();
        this.inbuffer = new SessionInputBufferImpl(httpTransportMetricsImpl, i, -1, messageConstraints != null ? messageConstraints : MessageConstraints.DEFAULT, charsetDecoder);
        this.outbuffer = new SessionOutputBufferImpl(httpTransportMetricsImpl2, i, i2, charsetEncoder);
        this.connMetrics = new HttpConnectionMetricsImpl(httpTransportMetricsImpl, httpTransportMetricsImpl2);
        if (contentLengthStrategy == null) {
            contentLengthStrategy = LaxContentLengthStrategy.INSTANCE;
        }
        this.incomingContentStrategy = contentLengthStrategy;
        if (contentLengthStrategy2 == null) {
            contentLengthStrategy2 = StrictContentLengthStrategy.INSTANCE;
        }
        this.outgoingContentStrategy = contentLengthStrategy2;
    }

    private int fillInputBuffer(int i) {
        int soTimeout = this.socket.getSoTimeout();
        try {
            this.socket.setSoTimeout(i);
            int fillBuffer = this.inbuffer.fillBuffer();
            return fillBuffer;
        } finally {
            this.socket.setSoTimeout(soTimeout);
        }
    }

    protected boolean awaitInput(int i) {
        if (this.inbuffer.hasBufferedData()) {
            return true;
        }
        fillInputBuffer(i);
        return this.inbuffer.hasBufferedData();
    }

    protected void bind(Socket socket) {
        Args.notNull(socket, "Socket");
        this.socket = socket;
        this.open = true;
        this.inbuffer.bind(null);
        this.outbuffer.bind(null);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void close() {
        /*
        r2 = this;
        r0 = r2.open;
        if (r0 != 0) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        r0 = 0;
        r2.open = r0;
        r1 = r2.socket;
        r0 = r2.inbuffer;	 Catch:{ all -> 0x001e }
        r0.clear();	 Catch:{ all -> 0x001e }
        r0 = r2.outbuffer;	 Catch:{ all -> 0x001e }
        r0.flush();	 Catch:{ all -> 0x001e }
        r1.shutdownOutput();	 Catch:{ IOException -> 0x0023, UnsupportedOperationException -> 0x0027 }
    L_0x0017:
        r1.shutdownInput();	 Catch:{ IOException -> 0x0025, UnsupportedOperationException -> 0x0027 }
    L_0x001a:
        r1.close();
        goto L_0x0004;
    L_0x001e:
        r0 = move-exception;
        r1.close();
        throw r0;
    L_0x0023:
        r0 = move-exception;
        goto L_0x0017;
    L_0x0025:
        r0 = move-exception;
        goto L_0x001a;
    L_0x0027:
        r0 = move-exception;
        goto L_0x001a;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.http.myHttp.impl.BHttpConnectionBase.close():void");
    }

    protected InputStream createInputStream(long j, SessionInputBuffer sessionInputBuffer) {
        return j == -2 ? new ChunkedInputStream(sessionInputBuffer) : j == -1 ? new IdentityInputStream(sessionInputBuffer) : new ContentLengthInputStream(sessionInputBuffer, j);
    }

    protected OutputStream createOutputStream(long j, SessionOutputBuffer sessionOutputBuffer) {
        return j == -2 ? new ChunkedOutputStream((int) ItemAnimator.FLAG_MOVED, sessionOutputBuffer) : j == -1 ? new IdentityOutputStream(sessionOutputBuffer) : new ContentLengthOutputStream(sessionOutputBuffer, j);
    }

    protected void doFlush() {
        this.outbuffer.flush();
    }

    protected void ensureOpen() {
        Asserts.check(this.open, "Connection is not open");
        if (!this.inbuffer.isBound()) {
            this.inbuffer.bind(getSocketInputStream(this.socket));
        }
        if (!this.outbuffer.isBound()) {
            this.outbuffer.bind(getSocketOutputStream(this.socket));
        }
    }

    public InetAddress getLocalAddress() {
        return this.socket != null ? this.socket.getLocalAddress() : null;
    }

    public int getLocalPort() {
        return this.socket != null ? this.socket.getLocalPort() : -1;
    }

    public HttpConnectionMetrics getMetrics() {
        return this.connMetrics;
    }

    public InetAddress getRemoteAddress() {
        return this.socket != null ? this.socket.getInetAddress() : null;
    }

    public int getRemotePort() {
        return this.socket != null ? this.socket.getPort() : -1;
    }

    protected SessionInputBuffer getSessionInputBuffer() {
        return this.inbuffer;
    }

    protected SessionOutputBuffer getSessionOutputBuffer() {
        return this.outbuffer;
    }

    protected Socket getSocket() {
        return this.socket;
    }

    protected InputStream getSocketInputStream(Socket socket) {
        return socket.getInputStream();
    }

    protected OutputStream getSocketOutputStream(Socket socket) {
        return socket.getOutputStream();
    }

    public int getSocketTimeout() {
        int i = -1;
        if (this.socket != null) {
            try {
                i = this.socket.getSoTimeout();
            } catch (SocketException e) {
            }
        }
        return i;
    }

    protected void incrementRequestCount() {
        this.connMetrics.incrementRequestCount();
    }

    protected void incrementResponseCount() {
        this.connMetrics.incrementResponseCount();
    }

    public boolean isOpen() {
        return this.open;
    }

    public boolean isStale() {
        if (!isOpen()) {
            return true;
        }
        try {
            return fillInputBuffer(1) < 0;
        } catch (SocketTimeoutException e) {
            return false;
        } catch (IOException e2) {
            return true;
        }
    }

    protected HttpEntity prepareInput(HttpMessage httpMessage) {
        BasicHttpEntity basicHttpEntity = new BasicHttpEntity();
        long determineLength = this.incomingContentStrategy.determineLength(httpMessage);
        InputStream createInputStream = createInputStream(determineLength, this.inbuffer);
        if (determineLength == -2) {
            basicHttpEntity.setChunked(true);
            basicHttpEntity.setContentLength(-1);
            basicHttpEntity.setContent(createInputStream);
        } else if (determineLength == -1) {
            basicHttpEntity.setChunked(false);
            basicHttpEntity.setContentLength(-1);
            basicHttpEntity.setContent(createInputStream);
        } else {
            basicHttpEntity.setChunked(false);
            basicHttpEntity.setContentLength(determineLength);
            basicHttpEntity.setContent(createInputStream);
        }
        Header firstHeader = httpMessage.getFirstHeader(HTTP.CONTENT_TYPE);
        if (firstHeader != null) {
            basicHttpEntity.setContentType(firstHeader);
        }
        firstHeader = httpMessage.getFirstHeader(HTTP.CONTENT_ENCODING);
        if (firstHeader != null) {
            basicHttpEntity.setContentEncoding(firstHeader);
        }
        return basicHttpEntity;
    }

    protected OutputStream prepareOutput(HttpMessage httpMessage) {
        return createOutputStream(this.outgoingContentStrategy.determineLength(httpMessage), this.outbuffer);
    }

    public void setSocketTimeout(int i) {
        if (this.socket != null) {
            try {
                this.socket.setSoTimeout(i);
            } catch (SocketException e) {
            }
        }
    }

    public void shutdown() {
        this.open = false;
        Socket socket = this.socket;
        if (socket != null) {
            socket.close();
        }
    }

    public String toString() {
        if (this.socket == null) {
            return "[Not bound]";
        }
        StringBuilder stringBuilder = new StringBuilder();
        SocketAddress remoteSocketAddress = this.socket.getRemoteSocketAddress();
        SocketAddress localSocketAddress = this.socket.getLocalSocketAddress();
        if (!(remoteSocketAddress == null || localSocketAddress == null)) {
            NetUtils.formatAddress(stringBuilder, localSocketAddress);
            stringBuilder.append("<->");
            NetUtils.formatAddress(stringBuilder, remoteSocketAddress);
        }
        return stringBuilder.toString();
    }
}
