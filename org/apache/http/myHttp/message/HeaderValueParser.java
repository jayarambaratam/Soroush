package org.apache.http.myHttp.message;

import org.apache.http.myHttp.HeaderElement;
import org.apache.http.myHttp.NameValuePair;
import org.apache.http.myHttp.util.CharArrayBuffer;

public interface HeaderValueParser {
    HeaderElement[] parseElements(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor);

    HeaderElement parseHeaderElement(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor);

    NameValuePair parseNameValuePair(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor);

    NameValuePair[] parseParameters(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor);
}
