package org.apache.http.myHttp.message;

import org.apache.http.myHttp.Header;
import org.apache.http.myHttp.ProtocolVersion;
import org.apache.http.myHttp.RequestLine;
import org.apache.http.myHttp.StatusLine;
import org.apache.http.myHttp.util.CharArrayBuffer;

public interface LineParser {
    boolean hasProtocolVersion(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor);

    Header parseHeader(CharArrayBuffer charArrayBuffer);

    ProtocolVersion parseProtocolVersion(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor);

    RequestLine parseRequestLine(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor);

    StatusLine parseStatusLine(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor);
}
