package org.apache.http.myHttp.io;

import org.apache.http.myHttp.HttpMessage;

public interface HttpMessageParser<T extends HttpMessage> {
    T parse();
}
