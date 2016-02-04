package org.apache.http.myHttp.impl.entity;

import org.apache.http.myHttp.Header;
import org.apache.http.myHttp.HeaderElement;
import org.apache.http.myHttp.HttpMessage;
import org.apache.http.myHttp.ProtocolException;
import org.apache.http.myHttp.annotation.Immutable;
import org.apache.http.myHttp.entity.ContentLengthStrategy;
import org.apache.http.myHttp.protocol.HTTP;
import org.apache.http.myHttp.util.Args;

@Immutable
public class LaxContentLengthStrategy implements ContentLengthStrategy {
    public static final LaxContentLengthStrategy INSTANCE;
    private final int implicitLen;

    static {
        INSTANCE = new LaxContentLengthStrategy();
    }

    public LaxContentLengthStrategy() {
        this(-1);
    }

    public LaxContentLengthStrategy(int i) {
        this.implicitLen = i;
    }

    public long determineLength(HttpMessage httpMessage) {
        Args.notNull(httpMessage, "HTTP message");
        Header firstHeader = httpMessage.getFirstHeader(HTTP.TRANSFER_ENCODING);
        if (firstHeader != null) {
            try {
                HeaderElement[] elements = firstHeader.getElements();
                int length = elements.length;
                return (!HTTP.IDENTITY_CODING.equalsIgnoreCase(firstHeader.getValue()) && length > 0 && HTTP.CHUNK_CODING.equalsIgnoreCase(elements[length - 1].getName())) ? -2 : -1;
            } catch (Throwable e) {
                throw new ProtocolException("Invalid Transfer-Encoding header value: " + firstHeader, e);
            }
        } else if (httpMessage.getFirstHeader(HTTP.CONTENT_LEN) == null) {
            return (long) this.implicitLen;
        } else {
            long parseLong;
            Header[] headers = httpMessage.getHeaders(HTTP.CONTENT_LEN);
            int length2 = headers.length - 1;
            while (length2 >= 0) {
                try {
                    parseLong = Long.parseLong(headers[length2].getValue());
                    break;
                } catch (NumberFormatException e2) {
                    length2--;
                }
            }
            parseLong = -1;
            return parseLong >= 0 ? parseLong : -1;
        }
    }
}
