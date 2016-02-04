package mobi.mmdt.ott.p095c.p106b;

import android.annotation.TargetApi;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.nio.channels.SocketChannel;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

/* renamed from: mobi.mmdt.ott.c.b.e */
class C1269e extends SSLSocket {
    protected final SSLSocket f4513a;

    C1269e(SSLSocket sSLSocket) {
        this.f4513a = sSLSocket;
    }

    public void addHandshakeCompletedListener(HandshakeCompletedListener handshakeCompletedListener) {
        this.f4513a.addHandshakeCompletedListener(handshakeCompletedListener);
    }

    public void bind(SocketAddress socketAddress) {
        this.f4513a.bind(socketAddress);
    }

    public synchronized void close() {
        this.f4513a.close();
    }

    public void connect(SocketAddress socketAddress) {
        this.f4513a.connect(socketAddress);
    }

    public void connect(SocketAddress socketAddress, int i) {
        this.f4513a.connect(socketAddress, i);
    }

    public boolean equals(Object obj) {
        return this.f4513a.equals(obj);
    }

    public SocketChannel getChannel() {
        return this.f4513a.getChannel();
    }

    public boolean getEnableSessionCreation() {
        return this.f4513a.getEnableSessionCreation();
    }

    public String[] getEnabledCipherSuites() {
        return this.f4513a.getEnabledCipherSuites();
    }

    public String[] getEnabledProtocols() {
        return this.f4513a.getEnabledProtocols();
    }

    public InetAddress getInetAddress() {
        return this.f4513a.getInetAddress();
    }

    public InputStream getInputStream() {
        return this.f4513a.getInputStream();
    }

    public boolean getKeepAlive() {
        return this.f4513a.getKeepAlive();
    }

    public InetAddress getLocalAddress() {
        return this.f4513a.getLocalAddress();
    }

    public int getLocalPort() {
        return this.f4513a.getLocalPort();
    }

    public SocketAddress getLocalSocketAddress() {
        return this.f4513a.getLocalSocketAddress();
    }

    public boolean getNeedClientAuth() {
        return this.f4513a.getNeedClientAuth();
    }

    public boolean getOOBInline() {
        return this.f4513a.getOOBInline();
    }

    public OutputStream getOutputStream() {
        return this.f4513a.getOutputStream();
    }

    public int getPort() {
        return this.f4513a.getPort();
    }

    public synchronized int getReceiveBufferSize() {
        return this.f4513a.getReceiveBufferSize();
    }

    public SocketAddress getRemoteSocketAddress() {
        return this.f4513a.getRemoteSocketAddress();
    }

    public boolean getReuseAddress() {
        return this.f4513a.getReuseAddress();
    }

    public synchronized int getSendBufferSize() {
        return this.f4513a.getSendBufferSize();
    }

    public SSLSession getSession() {
        return this.f4513a.getSession();
    }

    public int getSoLinger() {
        return this.f4513a.getSoLinger();
    }

    public synchronized int getSoTimeout() {
        return this.f4513a.getSoTimeout();
    }

    public String[] getSupportedCipherSuites() {
        return this.f4513a.getSupportedCipherSuites();
    }

    public String[] getSupportedProtocols() {
        return this.f4513a.getSupportedProtocols();
    }

    public boolean getTcpNoDelay() {
        return this.f4513a.getTcpNoDelay();
    }

    public int getTrafficClass() {
        return this.f4513a.getTrafficClass();
    }

    public boolean getUseClientMode() {
        return this.f4513a.getUseClientMode();
    }

    public boolean getWantClientAuth() {
        return this.f4513a.getWantClientAuth();
    }

    public boolean isBound() {
        return this.f4513a.isBound();
    }

    public boolean isClosed() {
        return this.f4513a.isClosed();
    }

    public boolean isConnected() {
        return this.f4513a.isConnected();
    }

    public boolean isInputShutdown() {
        return this.f4513a.isInputShutdown();
    }

    public boolean isOutputShutdown() {
        return this.f4513a.isOutputShutdown();
    }

    public void removeHandshakeCompletedListener(HandshakeCompletedListener handshakeCompletedListener) {
        this.f4513a.removeHandshakeCompletedListener(handshakeCompletedListener);
    }

    public void sendUrgentData(int i) {
        this.f4513a.sendUrgentData(i);
    }

    public void setEnableSessionCreation(boolean z) {
        this.f4513a.setEnableSessionCreation(z);
    }

    public void setEnabledCipherSuites(String[] strArr) {
        this.f4513a.setEnabledCipherSuites(strArr);
    }

    public void setEnabledProtocols(String[] strArr) {
        this.f4513a.setEnabledProtocols(strArr);
    }

    public void setKeepAlive(boolean z) {
        this.f4513a.setKeepAlive(z);
    }

    public void setNeedClientAuth(boolean z) {
        this.f4513a.setNeedClientAuth(z);
    }

    public void setOOBInline(boolean z) {
        this.f4513a.setOOBInline(z);
    }

    public void setPerformancePreferences(int i, int i2, int i3) {
        this.f4513a.setPerformancePreferences(i, i2, i3);
    }

    public synchronized void setReceiveBufferSize(int i) {
        this.f4513a.setReceiveBufferSize(i);
    }

    public void setReuseAddress(boolean z) {
        this.f4513a.setReuseAddress(z);
    }

    @TargetApi(9)
    public void setSSLParameters(SSLParameters sSLParameters) {
        this.f4513a.setSSLParameters(sSLParameters);
    }

    public synchronized void setSendBufferSize(int i) {
        this.f4513a.setSendBufferSize(i);
    }

    public void setSoLinger(boolean z, int i) {
        this.f4513a.setSoLinger(z, i);
    }

    public synchronized void setSoTimeout(int i) {
        this.f4513a.setSoTimeout(i);
    }

    public void setTcpNoDelay(boolean z) {
        this.f4513a.setTcpNoDelay(z);
    }

    public void setTrafficClass(int i) {
        this.f4513a.setTrafficClass(i);
    }

    public void setUseClientMode(boolean z) {
        this.f4513a.setUseClientMode(z);
    }

    public void setWantClientAuth(boolean z) {
        this.f4513a.setWantClientAuth(z);
    }

    public void shutdownInput() {
        this.f4513a.shutdownInput();
    }

    public void shutdownOutput() {
        this.f4513a.shutdownOutput();
    }

    public void startHandshake() {
        this.f4513a.startHandshake();
    }

    public String toString() {
        return this.f4513a.toString();
    }
}
