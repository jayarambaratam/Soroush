package org.apache.http.myHttp.entity.mime.content;

import java.io.OutputStream;

public interface ContentBody extends ContentDescriptor {
    String getFilename();

    void writeTo(OutputStream outputStream);
}
