package mobi.mmdt.ott.p095c.p106b;

import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* renamed from: mobi.mmdt.ott.c.b.c */
public class C1267c extends SSLSocketFactory {
    private final SSLSocketFactory f4512a;

    public C1267c() {
        this.f4512a = HttpsURLConnection.getDefaultSSLSocketFactory();
    }

    private static Socket m6856a(Socket socket) {
        return socket instanceof SSLSocket ? new C1270f((SSLSocket) socket, null) : socket;
    }

    public Socket createSocket(String str, int i) {
        return C1267c.m6856a(this.f4512a.createSocket(str, i));
    }

    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) {
        return C1267c.m6856a(this.f4512a.createSocket(str, i, inetAddress, i2));
    }

    public Socket createSocket(InetAddress inetAddress, int i) {
        return C1267c.m6856a(this.f4512a.createSocket(inetAddress, i));
    }

    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) {
        return C1267c.m6856a(this.f4512a.createSocket(inetAddress, i, inetAddress2, i2));
    }

    public Socket createSocket(Socket socket, String str, int i, boolean z) {
        return C1267c.m6856a(this.f4512a.createSocket(socket, str, i, z));
    }

    public String[] getDefaultCipherSuites() {
        return this.f4512a.getDefaultCipherSuites();
    }

    public String[] getSupportedCipherSuites() {
        return this.f4512a.getSupportedCipherSuites();
    }
}
