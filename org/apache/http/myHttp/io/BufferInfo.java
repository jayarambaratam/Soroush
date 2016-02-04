package org.apache.http.myHttp.io;

public interface BufferInfo {
    int available();

    int capacity();

    int length();
}
