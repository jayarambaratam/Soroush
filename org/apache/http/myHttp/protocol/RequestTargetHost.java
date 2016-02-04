package org.apache.http.myHttp.protocol;

import java.net.InetAddress;
import org.apache.http.myHttp.HttpConnection;
import org.apache.http.myHttp.HttpHost;
import org.apache.http.myHttp.HttpInetConnection;
import org.apache.http.myHttp.HttpRequest;
import org.apache.http.myHttp.HttpRequestInterceptor;
import org.apache.http.myHttp.HttpVersion;
import org.apache.http.myHttp.ProtocolException;
import org.apache.http.myHttp.ProtocolVersion;
import org.apache.http.myHttp.annotation.Immutable;
import org.apache.http.myHttp.util.Args;

@Immutable
public class RequestTargetHost implements HttpRequestInterceptor {
    public void process(HttpRequest httpRequest, HttpContext httpContext) {
        Args.notNull(httpRequest, "HTTP request");
        HttpCoreContext adapt = HttpCoreContext.adapt(httpContext);
        ProtocolVersion protocolVersion = httpRequest.getRequestLine().getProtocolVersion();
        if ((!httpRequest.getRequestLine().getMethod().equalsIgnoreCase("CONNECT") || !protocolVersion.lessEquals(HttpVersion.HTTP_1_0)) && !httpRequest.containsHeader(HTTP.TARGET_HOST)) {
            HttpHost httpHost;
            HttpHost targetHost = adapt.getTargetHost();
            if (targetHost == null) {
                HttpConnection connection = adapt.getConnection();
                if (connection instanceof HttpInetConnection) {
                    InetAddress remoteAddress = ((HttpInetConnection) connection).getRemoteAddress();
                    int remotePort = ((HttpInetConnection) connection).getRemotePort();
                    if (remoteAddress != null) {
                        httpHost = new HttpHost(remoteAddress.getHostName(), remotePort);
                        if (httpHost == null) {
                            if (!protocolVersion.lessEquals(HttpVersion.HTTP_1_0)) {
                                throw new ProtocolException("Target host missing");
                            }
                            return;
                        }
                    }
                }
                httpHost = targetHost;
                if (httpHost == null) {
                    if (!protocolVersion.lessEquals(HttpVersion.HTTP_1_0)) {
                        throw new ProtocolException("Target host missing");
                    }
                    return;
                }
            }
            httpHost = targetHost;
            httpRequest.addHeader(HTTP.TARGET_HOST, httpHost.toHostString());
        }
    }
}
