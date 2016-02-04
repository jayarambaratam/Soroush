package org.apache.http.myHttp.impl;

import org.apache.http.myHttp.ConnectionReuseStrategy;
import org.apache.http.myHttp.Header;
import org.apache.http.myHttp.HeaderIterator;
import org.apache.http.myHttp.HttpResponse;
import org.apache.http.myHttp.HttpStatus;
import org.apache.http.myHttp.HttpVersion;
import org.apache.http.myHttp.ParseException;
import org.apache.http.myHttp.ProtocolVersion;
import org.apache.http.myHttp.TokenIterator;
import org.apache.http.myHttp.annotation.Immutable;
import org.apache.http.myHttp.message.BasicTokenIterator;
import org.apache.http.myHttp.protocol.HTTP;
import org.apache.http.myHttp.protocol.HttpContext;
import org.apache.http.myHttp.util.Args;

@Immutable
public class DefaultConnectionReuseStrategy implements ConnectionReuseStrategy {
    public static final DefaultConnectionReuseStrategy INSTANCE;

    static {
        INSTANCE = new DefaultConnectionReuseStrategy();
    }

    private boolean canResponseHaveBody(HttpResponse httpResponse) {
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        return (statusCode < HttpStatus.SC_OK || statusCode == HttpStatus.SC_NO_CONTENT || statusCode == HttpStatus.SC_NOT_MODIFIED || statusCode == HttpStatus.SC_RESET_CONTENT) ? false : true;
    }

    protected TokenIterator createTokenIterator(HeaderIterator headerIterator) {
        return new BasicTokenIterator(headerIterator);
    }

    public boolean keepAlive(HttpResponse httpResponse, HttpContext httpContext) {
        boolean z = true;
        Args.notNull(httpResponse, "HTTP response");
        Args.notNull(httpContext, "HTTP context");
        ProtocolVersion protocolVersion = httpResponse.getStatusLine().getProtocolVersion();
        Header firstHeader = httpResponse.getFirstHeader(HTTP.TRANSFER_ENCODING);
        if (firstHeader != null) {
            if (!HTTP.CHUNK_CODING.equalsIgnoreCase(firstHeader.getValue())) {
                return false;
            }
        } else if (canResponseHaveBody(httpResponse)) {
            Header[] headers = httpResponse.getHeaders(HTTP.CONTENT_LEN);
            if (headers.length != 1) {
                return false;
            }
            try {
                if (Integer.parseInt(headers[0].getValue()) < 0) {
                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }
        }
        HeaderIterator headerIterator = httpResponse.headerIterator(HTTP.CONN_DIRECTIVE);
        if (!headerIterator.hasNext()) {
            headerIterator = httpResponse.headerIterator("Proxy-Connection");
        }
        if (headerIterator.hasNext()) {
            try {
                TokenIterator createTokenIterator = createTokenIterator(headerIterator);
                boolean z2 = false;
                while (createTokenIterator.hasNext()) {
                    String nextToken = createTokenIterator.nextToken();
                    if (HTTP.CONN_CLOSE.equalsIgnoreCase(nextToken)) {
                        return false;
                    }
                    if (HTTP.CONN_KEEP_ALIVE.equalsIgnoreCase(nextToken)) {
                        z2 = true;
                    }
                }
                if (z2) {
                    return true;
                }
            } catch (ParseException e2) {
                return false;
            }
        }
        if (protocolVersion.lessEquals(HttpVersion.HTTP_1_0)) {
            z = false;
        }
        return z;
    }
}
