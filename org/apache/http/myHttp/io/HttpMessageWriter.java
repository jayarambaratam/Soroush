package org.apache.http.myHttp.io;

import org.apache.http.myHttp.HttpMessage;

public interface HttpMessageWriter<T extends HttpMessage> {
    void write(T t);
}
