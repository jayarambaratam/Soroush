package org.apache.http.myHttp.io;

import org.apache.http.myHttp.HttpMessage;
import org.apache.http.myHttp.config.MessageConstraints;

public interface HttpMessageParserFactory<T extends HttpMessage> {
    HttpMessageParser<T> create(SessionInputBuffer sessionInputBuffer, MessageConstraints messageConstraints);
}
