package org.apache.http.myHttp.entity;

import java.io.OutputStream;

public interface ContentProducer {
    void writeTo(OutputStream outputStream);
}
