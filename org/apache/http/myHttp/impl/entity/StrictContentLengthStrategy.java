package org.apache.http.myHttp.impl.entity;

import org.apache.http.myHttp.Header;
import org.apache.http.myHttp.HttpMessage;
import org.apache.http.myHttp.HttpVersion;
import org.apache.http.myHttp.ProtocolException;
import org.apache.http.myHttp.annotation.Immutable;
import org.apache.http.myHttp.entity.ContentLengthStrategy;
import org.apache.http.myHttp.protocol.HTTP;
import org.apache.http.myHttp.util.Args;

@Immutable
public class StrictContentLengthStrategy implements ContentLengthStrategy {
    public static final StrictContentLengthStrategy INSTANCE;
    private final int implicitLen;

    static {
        INSTANCE = new StrictContentLengthStrategy();
    }

    public StrictContentLengthStrategy() {
        this(-1);
    }

    public StrictContentLengthStrategy(int i) {
        this.implicitLen = i;
    }

    public long determineLength(HttpMessage httpMessage) {
        Args.notNull(httpMessage, "HTTP message");
        Header firstHeader = httpMessage.getFirstHeader(HTTP.TRANSFER_ENCODING);
        if (firstHeader != null) {
            String value = firstHeader.getValue();
            if (HTTP.CHUNK_CODING.equalsIgnoreCase(value)) {
                if (!httpMessage.getProtocolVersion().lessEquals(HttpVersion.HTTP_1_0)) {
                    return -2;
                }
                throw new ProtocolException("Chunked transfer encoding not allowed for " + httpMessage.getProtocolVersion());
            } else if (HTTP.IDENTITY_CODING.equalsIgnoreCase(value)) {
                return -1;
            } else {
                throw new ProtocolException("Unsupported transfer encoding: " + value);
            }
        }
        firstHeader = httpMessage.getFirstHeader(HTTP.CONTENT_LEN);
        if (firstHeader == null) {
            return (long) this.implicitLen;
        }
        String value2 = firstHeader.getValue();
        try {
            long parseLong = Long.parseLong(value2);
            if (parseLong >= 0) {
                return parseLong;
            }
            throw new ProtocolException("Negative content length: " + value2);
        } catch (NumberFormatException e) {
            throw new ProtocolException("Invalid content length: " + value2);
        }
    }
}
