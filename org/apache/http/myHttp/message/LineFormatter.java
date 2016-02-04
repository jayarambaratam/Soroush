package org.apache.http.myHttp.message;

import org.apache.http.myHttp.Header;
import org.apache.http.myHttp.ProtocolVersion;
import org.apache.http.myHttp.RequestLine;
import org.apache.http.myHttp.StatusLine;
import org.apache.http.myHttp.util.CharArrayBuffer;

public interface LineFormatter {
    CharArrayBuffer appendProtocolVersion(CharArrayBuffer charArrayBuffer, ProtocolVersion protocolVersion);

    CharArrayBuffer formatHeader(CharArrayBuffer charArrayBuffer, Header header);

    CharArrayBuffer formatRequestLine(CharArrayBuffer charArrayBuffer, RequestLine requestLine);

    CharArrayBuffer formatStatusLine(CharArrayBuffer charArrayBuffer, StatusLine statusLine);
}
