package org.apache.http.myHttp.io;

import org.apache.http.myHttp.HttpMessage;

public interface HttpMessageWriterFactory<T extends HttpMessage> {
    HttpMessageWriter<T> create(SessionOutputBuffer sessionOutputBuffer);
}
